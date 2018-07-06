
package com.ngls.user.exception;

import com.ngls.common.util.mvc.support.ApiError;

import java.io.Serializable;

/**
 * 用户未登录的ApiError.
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
public final class UserNotLoginError extends ApiError implements Serializable {

    private static final long serialVersionUID = 6220374455666420003L;

    public UserNotLoginError() {
        super(UserErrorCode.USER_NOT_LOGIN, UserErrorCode.USER_NOT_LOGIN.getMessage());
    }

}