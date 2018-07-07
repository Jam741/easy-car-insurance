package com.ngls.user.service;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.UserDto;
import com.ngls.user.support.WechatLogin.WechatUserInfo;

/**
 * 用户Service
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public interface UserService {

    /**
     * 查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    ApiResult<UserDto> findUserById(Long id);

    /**
     * 更细用户信息
     *
     * @param wechatUserInfo 微信用户信息
     * @return 用户信息
     */
    ApiResult<UserDto> updateUserInfo(WechatUserInfo wechatUserInfo);
}
