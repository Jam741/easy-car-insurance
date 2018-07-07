package com.ngls.user.service;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录服务接口.
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
public interface LoginService {

    /**
     * 使用微信的accessToken登录
     *
     * @param code 微信code
     * @return 结果
     */
    ApiResult<UserDto> wechatLogin(String code, HttpServletRequest request);
}
