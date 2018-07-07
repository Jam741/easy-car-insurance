package com.ngls.user.support;

import com.ngls.common.util.basic.JsonUtils;
import com.ngls.common.util.http.HttpRequestUtils;
import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.exception.UserErrorCode;
import com.ngls.user.support.WechatLogin.ErrorMsg;
import com.ngls.user.support.WechatLogin.UserIdentity;
import com.ngls.user.support.WechatLogin.WechatUserInfo;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信OAuth2.0支持
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@Component
public class WechatLoginSupport {

    @Value("${wechat.login.weixin.app.id}")
    private String weixinAppId;

    @Value("${wechat.login.weixin.app.secret}")
    private String weixinSecret;

    // private final static String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?";
    private final static String getAccessTokenUrl = "https://api.weixin.qq.com/sns/jscode2session?";

    private final static String refreshAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";

    private final static String checkAccessTokenUrl = "https://api.weixin.qq.com/sns/auth?";

    private final static String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?";

    private ApiResult<UserIdentity> parseAccessTokenResult(String resultStr) {
        JSONObject jsonObject = new JSONObject(resultStr);
        if (!jsonObject.has("errcode")) {
            UserIdentity userIdentity = JsonUtils.jsonToObject(resultStr, new TypeReference<UserIdentity>() {
            });
            return ApiResult.succ(userIdentity);
        } else {
            ErrorMsg errorMsg = JsonUtils.jsonToObject(resultStr, new TypeReference<ErrorMsg>() {
            });
            return ApiResult.failFormatMsg(UserErrorCode.WECHAT_LOGIN_ERROR, "code:" + errorMsg.getErrcode() + "   " +
                    "desc:" + errorMsg.getErrmsg());
        }
    }

    public ApiResult<UserIdentity> getUserIdentity(String code) {

        String url = getAccessTokenUrl + "appid=" + weixinAppId + "&secret=" +
                weixinSecret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println("getUserIdentity          request_url============" + url);
        String resultStr = HttpRequestUtils.httpRequest(url, "GET", null);
        System.out.println("getUserIdentity          resultStr============" + resultStr);
        return parseAccessTokenResult(resultStr);
    }

    public ApiResult<UserIdentity> refreshAccessToken(String refreshToken) {
        String url = refreshAccessTokenUrl + "appid=" + weixinAppId + "&grant_type=refresh_token&refresh_token=" +
                refreshToken;
        String resultStr = HttpRequestUtils.httpRequest(url, "GET", null);
        System.out.println("refreshAccessToken               resultStr============" + resultStr);
        return parseAccessTokenResult(resultStr);
    }

    public ApiResult checkAccessToken(String accessToken, String openId) {
        String url = checkAccessTokenUrl + "access_token=" + accessToken + "&openid=" + openId;
        String resultStr = HttpRequestUtils.httpRequest(url, "GET", null);
        System.out.println("checkAccessToken                   resultStr============" + resultStr);
        ErrorMsg errorMsg = JsonUtils.jsonToObject(resultStr, new TypeReference<ErrorMsg>() {
        });
        //errcode==0 是正常的  其他值则是错误返回
        if (errorMsg.getErrcode() == 0) {
            return ApiResult.succ();
        } else {
            return ApiResult.failFormatMsg(UserErrorCode.WECHAT_LOGIN_ERROR, "code:" + errorMsg.getErrcode() + "   " +
                    "desc:" + errorMsg.getErrmsg());
        }
    }

    public ApiResult<WechatUserInfo> getUserInfo(String accessToken, String openId) {
        String url = getUserInfoUrl + "access_token=" + accessToken + "&openid=" + openId;
        String resultStr = HttpRequestUtils.httpRequest(url, "GET", null);
        System.out.println("getUserInfo                     resultStr============" + resultStr);
        JSONObject jsonObject = new JSONObject(resultStr);
        if (!jsonObject.has("errcode")) {
            WechatUserInfo wechatUserInfo = JsonUtils.jsonToObject(resultStr, new TypeReference<WechatUserInfo>() {
            });
            return ApiResult.succ(wechatUserInfo);
        } else {
            ErrorMsg errorMsg = JsonUtils.jsonToObject(resultStr, new TypeReference<ErrorMsg>() {
            });
            return ApiResult.failFormatMsg(UserErrorCode.WECHAT_LOGIN_ERROR, "code:" + errorMsg.getErrcode() + "   " +
                    "desc:" + errorMsg.getErrmsg());
        }
    }

}
