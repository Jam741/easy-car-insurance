
package com.ngls.user.session;

import com.ngls.common.util.basic.UUIDUnsigned32;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.common.util.security.MD5Utils;
import com.ngls.user.exception.UserErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 自定义用户Session的管理组件.
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@Component
public class UserSessionComponent {

    public static final String SESSION_ID_KEY = "session-id";

    public static final String ACCESS_TOKEN_KEY = "access-token";

    static final Logger LOG = LoggerFactory.getLogger(UserSessionComponent.class);

    @Resource
    private RedisTemplate<String, UserSession> redisTemplate;

    @Value("${http.session.enable}")
    private String httpSessionEnable;

    public UserSession add(HttpSession httpSession, UserInfo userInfo) {
        return addOrUpdate(httpSession, userInfo, null);
    }

    public UserSession add(HttpSession httpSession, UserInfo userInfo, String loginFrom){
        //如果从H5登录的 并且缓存中有session信息 则不更新token 直接返回
        if(StringUtils.isNotBlank(loginFrom)){
            UserSession session = redisTemplate.opsForValue().get(getSessionKey(userInfo));
            if(session==null){
                return add(httpSession,userInfo);
            }else{
                return session;
            }
        }else{
            return add(httpSession,userInfo);
        }
    }

    public boolean refreshUserInfo(HttpSession httpSession, UserInfo userInfo) {
        UserSession session = redisTemplate.opsForValue().get(getSessionKey(userInfo));
        if (session == null) {
            LOG.warn("刷新用户会话信息失败！cause: 用户不存在. userInfo = {}", userInfo);
            return false;
        }

        session.setUserInfo(userInfo);
        redisTemplate.opsForValue().set(session.getSessionId(), session);
        return true;
    }

    public ApiResult<UserSession> update(HttpSession httpSession, String sessionId, String refreshToken) {
        UserSession session = redisTemplate.opsForValue().get(sessionId);
        if (session == null) {
            LOG.debug("更新AccessToken失败！cause: 用户不存在." +
                    " sessionId = {}, refreshToken = {}", sessionId, refreshToken);
            return ApiResult.fail(UserErrorCode.USER_NOT_LOGIN);
        }
        if (!session.isAccessTokenExpired()) {
            LOG.debug("更新AccessToken失败！cause: 未到刷新时间." +
                    " sessionId = {}, refreshToken = {}", sessionId, refreshToken);
            return ApiResult.fail(UserErrorCode.USER_TOKEN_CANT_REFRESH);
        }
        if (!session.getRefreshToken().equals(refreshToken)) {
            LOG.debug("更新AccessToken失败！cause: 刷新令牌错误." +
                    " sessionId = {}, refreshToken = {}", sessionId, refreshToken);
            return ApiResult.fail(UserErrorCode.USER_NOT_LOGIN);
        }
        return ApiResult.succ(addOrUpdate(httpSession, session.getUserInfo(), session));
    }

    public void remove(HttpSession httpSession, UserInfo userInfo) {
        if (userInfo != null) {
            redisTemplate.delete(getSessionKey(userInfo));
            if (isHttpSessionEnable()) {
                httpSession.removeAttribute(SESSION_ID_KEY);
                httpSession.removeAttribute(ACCESS_TOKEN_KEY);
            }
        }
    }

    private String getSessionKey(UserInfo userInfo) {
        return "c:" + userInfo.getId();
    }

    private boolean isHttpSessionEnable() {
        return Boolean.TRUE.toString().equalsIgnoreCase(httpSessionEnable);
    }

    private UserSession addOrUpdate(HttpSession httpSession, UserInfo userInfo, UserSession oldSession) {
        UserSession session = new UserSession();
        session.setSessionId(getSessionKey(userInfo));
        session.setAccessToken(MD5Utils.getMD5Code(
                "c" + userInfo.getId() + UUIDUnsigned32.randomUUIDString()));
        session.setRefreshToken(MD5Utils.getMD5Code(
                userInfo.getId() + "c" + UUIDUnsigned32.randomUUIDString()));
        session.setUserInfo(userInfo);
        if (UserSession.ACCESS_TOKEN_EXPIRE_TIME > 0) {
            LocalDateTime expireTime = LocalDateTime.now().plus(UserSession.ACCESS_TOKEN_EXPIRE_TIME, ChronoUnit.MINUTES);
            session.setExpireTime(expireTime);
        }
        if (oldSession != null) {
            session.setOldAccessToken(oldSession.getAccessToken());
        }
        redisTemplate.opsForValue().set(session.getSessionId(), session);

        if (isHttpSessionEnable()) {
            LOG.info("将用户会话写入HttpSession.");
            httpSession.setAttribute(SESSION_ID_KEY, session.getSessionId());
            httpSession.setAttribute(ACCESS_TOKEN_KEY, session.getAccessToken());
        }

        return session;
    }

    /**
     * IM更换服务商之后，已登录用户获取token时报accid为空，在会获取token时为imUid为空的用户更新imUid
     *
     * @param userInfo 新的用户信息
     */
    public void updateUserInfo(UserInfo userInfo) {
        UserSession session = redisTemplate.opsForValue().get(getSessionKey(userInfo));
        if (session != null) {
            session.setUserInfo(userInfo);
            redisTemplate.opsForValue().set(session.getSessionId(), session);
        }
    }


}