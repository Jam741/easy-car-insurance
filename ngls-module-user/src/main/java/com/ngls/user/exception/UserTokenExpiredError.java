
package com.ngls.user.exception;

import com.ngls.common.util.mvc.support.ApiError;

import java.io.Serializable;

/**
 * 用户令牌过期的ApiError.
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
public class UserTokenExpiredError extends ApiError implements Serializable {

    private static final long serialVersionUID = 8669283813332316655L;

    public UserTokenExpiredError() {
        super(UserErrorCode.USER_TOKEN_EXPIRED, UserErrorCode.USER_TOKEN_EXPIRED.getMessage());
    }

}