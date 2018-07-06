package com.ngls.web.customer.controller.customer;

import com.ngls.common.util.mvc.resolver.FromSession;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.dto.UserDto;
import com.ngls.user.service.UserService;
import com.ngls.user.session.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping(value = "")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ApiResult<UserDto> getUserInfo(@FromSession UserInfo userInfo) {
        return userService.findUserById(userInfo.getId());
    }
}
