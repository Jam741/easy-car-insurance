package com.ngls.web.customer.config;

import com.ngls.common.util.web.access.AccessControlFilter;
import com.ngls.common.util.web.access.handler.ApiErrorHandler;
import com.ngls.user.exception.UserNotLoginError;
import com.ngls.user.exception.UserTokenExpiredError;
import com.ngls.user.exception.UserTokenLoggedOtherError;
import com.ngls.user.exception.UserTokenRefreshedError;
import com.ngls.user.session.UserSessionPermissionValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * 过滤器配置
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@Configuration
public class FilterConfig {

    @Value("${http.session.enable}")
    private String httpSessionEnable;

    @Value("${logback.http.debug.enable}")
    private String logbackHttpDebugEnable;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 加入自定义全局过滤器配置配置
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(getAccessControlFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("accessControlFilter");

        return registration;
    }

    /**
     * 配置访问控制过滤器
     *
     * @return
     */
    @Bean(name = "accessControlFilter")
    public Filter getAccessControlFilter() {
        AccessControlFilter accessControlFilter = new AccessControlFilter();

        accessControlFilter.setLogbackHttpDebugEnable(enableLogbackHttpDebug());

        UserSessionPermissionValidator validator = new UserSessionPermissionValidator(redisTemplate);
        validator.setHttpSessionEnable(enableHttpSession());
        accessControlFilter.setValidator(validator);

        ApiErrorHandler rejectedHandler = new ApiErrorHandler();
        rejectedHandler.setError(new UserNotLoginError());
        accessControlFilter.setRejectedHandler(rejectedHandler);

        ApiErrorHandler tokenExpiredHandler = new ApiErrorHandler();
        tokenExpiredHandler.setError(new UserTokenExpiredError());
        accessControlFilter.setTokenExpiredHandler(tokenExpiredHandler);

        ApiErrorHandler tokenRefreshedHandler = new ApiErrorHandler();
        tokenRefreshedHandler.setError(new UserTokenRefreshedError());
        accessControlFilter.setTokenRefreshedHandler(tokenRefreshedHandler);

        ApiErrorHandler tokenLoggedOtherHandler = new ApiErrorHandler();
        tokenLoggedOtherHandler.setError(new UserTokenLoggedOtherError());
        accessControlFilter.setTokenRefreshedHandler(tokenRefreshedHandler);

        accessControlFilter.setBasePath("/");
        // 配置禁止访问的接口地址
        accessControlFilter.setForbiddenUrls(new String[]{});
        // 如果允许AJAX跨域调用，则排除验证OPTIONS请求
        accessControlFilter.setExcludeMethods(new String[]{"OPTIONS"});
        // 配置不需要登录就能访问的接口地址
        accessControlFilter.setExcludeUrls(new String[]{
                "/demo-user/.*",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/swagger-resources.*",
                "/webjars/.*",
                "/user/wechatLogin",
                "/access_token/refresh"
        });

        return accessControlFilter;
    }

    private boolean enableHttpSession() {
        return Boolean.TRUE.toString().equalsIgnoreCase(httpSessionEnable);
    }

    private boolean enableLogbackHttpDebug() {
        return Boolean.TRUE.toString().equalsIgnoreCase(logbackHttpDebugEnable);
    }
}
