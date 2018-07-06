
package com.ngls.user.exception;

import com.ngls.common.util.mvc.support.ApiError;

import java.io.Serializable;

/**
 * 用户令牌被刷新的ApiError.
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
public class UserTokenRefreshedError extends ApiError implements Serializable {

    private static final long serialVersionUID = 6629422591346229094L;

    public UserTokenRefreshedError() {
        super(UserErrorCode.USER_TOKEN_REFRESHED, UserErrorCode.USER_TOKEN_REFRESHED.getMessage());
    }

}