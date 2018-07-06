package com.ngls.web.customer.controller.token;

import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.session.UserSession;
import com.ngls.user.session.UserSessionComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * AccessToken相关接口
 *
 * @author Kixs
 * @version 1.0, 2018/7/7
 */
@RestController
@RequestMapping("/access_token")
@Api(value = "/access_token", description = "AccessToken相关接口")
public class AccessTokenController {

    @Resource
    private UserSessionComponent userSessionComponent;

    @RequestMapping(value = "refresh", method = RequestMethod.POST)
    @ApiOperation(value = "刷新用户令牌", notes = "刷新用户令牌，返回null表示刷新失败")
    public ApiResult<UserSession> refreshToken(
            @ApiParam(name = "sessionId", value = "用户会话ID")
            @RequestParam("sessionId") String sessionId,
            @ApiParam(name = "refreshToken", value = "刷新令牌")
            @RequestParam("refreshToken") String refreshToken, HttpSession session) {
        return userSessionComponent.update(session, sessionId, refreshToken);
    }
}
