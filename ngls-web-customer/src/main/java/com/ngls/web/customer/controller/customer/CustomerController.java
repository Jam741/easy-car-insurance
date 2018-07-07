package com.ngls.web.customer.controller.customer;

import com.ngls.common.util.mvc.resolver.FromSession;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.UserDto;
import com.ngls.user.service.UserService;
import com.ngls.user.session.UserInfo;
import com.ngls.user.session.UserSessionComponent;
import com.ngls.user.support.WechatLogin.WechatUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@RestController
@RequestMapping("/customer")
@Api(value = "/customer", description = "v1.0.0 * 用户信息接口")
public class CustomerController {

    @Resource
    private UserService userService;

    @Resource
    private UserSessionComponent userSessionComponent;

    @GetMapping(value = "")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ApiResult<UserDto> getUserInfo(@FromSession UserInfo userInfo) {
        return userService.findUserById(userInfo.getId());
    }

    @PostMapping("")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    public ApiResult<UserDto> updateUserInfo(
            @ApiParam(name = "wechatUserInfo", value = "微信用户信息")
            @RequestBody WechatUserInfo wechatUserInfo, HttpSession httpSession) {
        ApiResult<UserDto> result = userService.updateUserInfo(wechatUserInfo);

        if (result.isSucc()) {
            // 更新Session中的用户信息
            userSessionComponent.refreshUserInfo(httpSession, new UserInfo(result.getData()));
        }

        return result;
    }
}
