
package com.ngls.user.exception;

import com.ngls.common.util.exception.ErrorCode;

/**
 * 用户服务相关的错误码定义（code：301 - 400）.
 *
 * @author Kixs
 * @version 1.0, 2016/6/12
 */
public enum UserErrorCode implements ErrorCode {

    USER_EXISTED(301, "用户已存在"),
    USER_NOT_EXISTED(302, "用户不存在"),
    USER_NOT_AVAILABLE(303, "用户已失效"),
    ACCOUNT_DELETED(304, "账户已被禁用"),
    USER_NOT_LOGIN(312, "用户未登录"),
    USER_TOKEN_EXPIRED(314, "用户令牌已过期"),
    USER_TOKEN_REFRESHED(315, "用户令牌被刷新"),
    USER_TOKEN_CANT_REFRESH(316, "用户令牌未到刷新时间"),
    USER_TOKEN_LOGGED_OTHER(317, "用户在其它设备登录"),

    WECHAT_LOGIN_ERROR(110,"微信登录失败，%s");

    private final int code;

    private final String message;

    UserErrorCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
