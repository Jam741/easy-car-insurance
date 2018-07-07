package com.ngls.user.service.impl;

import com.ngls.common.util.basic.JsonUtils;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.common.util.validation.FieldChecker;
import com.ngls.user.dao.UserRepository;
import com.ngls.user.domain.User;
import com.ngls.user.dto.UserDto;
import com.ngls.user.service.LoginService;
import com.ngls.user.support.WechatLogin.UserIdentity;
import com.ngls.user.support.WechatLogin.WechatUserInfo;
import com.ngls.user.support.WechatLoginSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 用户登录服务实现类.
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private WechatLoginSupport wechatLoginSupport;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiResult<UserDto> wechatLogin(String code, HttpServletRequest request) {
        FieldChecker.checkEmpty(code, "code");
        ApiResult<UserIdentity> result = wechatLoginSupport.getUserIdentity(code);
        if (result.isSucc()) {
            User user = userRepository.findByOpenId(result.getData().getOpenid());
            if (user == null) {
                user = new User();
                user.setOpenId(result.getData().getOpenid());
                user.setUnionId(result.getData().getUnionid());
                user.setSessionKey(result.getData().getSession_key());
                user.setOauthType("wechat");
                user.setCreateTime(LocalDateTime.now());
                user.setUpdateTime(LocalDateTime.now());
                userRepository.save(user);
            } else {
                user.setOpenId(result.getData().getOpenid());
                user.setUnionId(result.getData().getUnionid());
                user.setSessionKey(result.getData().getSession_key());
                user.setUpdateTime(LocalDateTime.now());
                userRepository.save(user);
            }
            return ApiResult.succ(new UserDto(user));
        } else {
            return ApiResult.fail(result.getError(), result.getMessage());
        }
    }

}