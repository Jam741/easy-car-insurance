package com.ngls.web.customer.config;

import com.ngls.common.util.exception.GlobalExceptionHandler;
import com.ngls.user.session.UserSession;
import com.ngls.user.session.UserSessionArgResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * MVC配置
 *
 * @author wangbing
 * @version 1.0, 2018/7/5
 */
@Configuration
public class UserWebMvcConfigurer implements WebMvcConfigurer {

    @Value("${http.session.enable}")
    private String httpSessionEnable;

    @Value("${global.exception.enable}")
    private String globalExceptionEnable;

    @Resource
    private RedisTemplate<String, UserSession> redisTemplate;

    /**
     * 配置FromSession自动注入
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserSessionArgResolver(redisTemplate, isHttpSessionEnable()));
    }

    /**
     * 配置CORS跨域访问
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET,POST,OPTIONS,PUT,DELETE")
                .allowCredentials(true)
                .maxAge(1800);
    }

    /**
     * 配置全局异常捕获
     *
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new GlobalExceptionHandler(isGlobalExceptionEnable()));
    }

    private boolean isHttpSessionEnable() {
        return Boolean.TRUE.toString().equalsIgnoreCase((httpSessionEnable));
    }

    private boolean isGlobalExceptionEnable() {
        return Boolean.TRUE.toString().equalsIgnoreCase((globalExceptionEnable));
    }
}
