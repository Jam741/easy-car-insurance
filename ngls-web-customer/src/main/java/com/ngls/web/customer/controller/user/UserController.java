package com.ngls.web.customer.controller.user;

import com.ngls.common.util.mvc.resolver.FromSession;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.common.util.mvc.support.NullObject;
import com.ngls.user.dto.UserDto;
import com.ngls.user.exception.UserErrorCode;
import com.ngls.user.service.LoginService;
import com.ngls.user.service.UserService;
import com.ngls.user.session.UserInfo;
import com.ngls.user.session.UserSessionComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户相关接口
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "v1.0.0 * 用户相关接口")
public class UserController {

    @Resource
    private LoginService loginService;

    @Resource
    private UserSessionComponent userSessionComponent;

    @RequestMapping(value = "wechatLogin", method = RequestMethod.POST)
    @ApiOperation(value = "微信登录", notes = "微信登录")
    public ApiResult<UserDto> wechatLogin(
            @ApiParam(name = "code", value = "首次使用微信登录时，客户端从微信处获得的code")
            @RequestParam("code") String code,
            HttpServletRequest request) {
        ApiResult<UserDto> apiResult = loginService.wechatLogin(code, request);

        if (apiResult.isSucc()) {
            apiResult.getData().setUserSession(userSessionComponent.add(request.getSession(), new UserInfo(apiResult
                    .getData()), ""));
        }

        return apiResult;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ApiOperation(value = "用户登出接口", notes = "用户登出接口")
    public ApiResult<NullObject> logout(@FromSession UserInfo userInfo, HttpSession httpSession) {
        if (userInfo == null) {
            return ApiResult.fail(UserErrorCode.USER_NOT_LOGIN);
        }
        userSessionComponent.remove(httpSession, userInfo);
        return ApiResult.succ(null, "用户已退出！");
    }

}
