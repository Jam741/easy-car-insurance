package com.ngls.user.service.impl;

import com.ngls.common.util.basic.JsonUtils;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.common.util.validation.FieldChecker;
import com.ngls.user.dao.UserRepository;
import com.ngls.user.domain.User;
import com.ngls.user.dto.UserDto;
import com.ngls.user.service.LoginService;
import com.ngls.user.support.WechatLogin.GetAccessToken;
import com.ngls.user.support.WechatLogin.WechatUserInfo;
import com.ngls.user.support.WechatLoginSupport;
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

    @Resource
    private WechatLoginSupport wechatLoginSupport;

    @Resource
    private UserRepository userRepository;

    @Override
    public ApiResult<UserDto> wechatLogin(String code, HttpServletRequest request) {
        FieldChecker.checkEmpty(code, "code");
        ApiResult<GetAccessToken> getAccessTokenApiResult = wechatLoginSupport.getAccessToken(code);
        if (getAccessTokenApiResult.isSucc()) {
            User user = userRepository.findByOpenId(getAccessTokenApiResult.getData().getOpenid());
            if (user == null) {
                ApiResult<WechatUserInfo> userResult = wechatLoginSupport.getUserInfo(
                        getAccessTokenApiResult.getData().getAccess_token(),
                        getAccessTokenApiResult.getData().getOpenid());
                user = new User();
                user.setOpenId(getAccessTokenApiResult.getData().getOpenid());
                user.setUnionId(getAccessTokenApiResult.getData().getUnionid());
                user.setOauthType("wechat");
                user.setNickName(userResult.getData().getNickname());
                user.setHeadImage(userResult.getData().getHeadimgurl());
                user.setAccessToken(getAccessTokenApiResult.getData().getAccess_token());
                user.setExpiresIn(System.currentTimeMillis() + getAccessTokenApiResult.getData().getExpires_in() * 1000L);
                user.setRefreshToken(getAccessTokenApiResult.getData().getRefresh_token());
                user.setScope(getAccessTokenApiResult.getData().getScope());
                user.setOauthUserInfo(JsonUtils.objectToJson(userResult.getData()));
                user.setCreateTime(LocalDateTime.now());
                user.setUpdateTime(LocalDateTime.now());
                userRepository.save(user);
            } else {
                user.setAccessToken(getAccessTokenApiResult.getData().getAccess_token());
                user.setOpenId(getAccessTokenApiResult.getData().getOpenid());
                user.setExpiresIn(System.currentTimeMillis() + getAccessTokenApiResult.getData().getExpires_in() * 1000L);
                user.setRefreshToken(getAccessTokenApiResult.getData().getRefresh_token());
                user.setUpdateTime(LocalDateTime.now());
                userRepository.save(user);
            }
            return ApiResult.succ(new UserDto(user));
        } else {
            return ApiResult.fail(getAccessTokenApiResult.getError(), getAccessTokenApiResult.getMessage());
        }
    }

}