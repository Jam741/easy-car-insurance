package com.ngls.user.dto;

import com.ngls.user.domain.User;
import com.ngls.user.session.UserSession;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
@ApiModel
public class UserDto implements Serializable {

    @ApiModelProperty("用户id")
    public Long id;

    @ApiModelProperty("授权用户唯一标识")
    private String openId;

    @ApiModelProperty("同一个开发平台下 多个应用的unionId一致")
    private String unionId;

    @ApiModelProperty("OAuth2.0认证类型，初期固定为wechat：微信")
    private String oauthType;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String headImage;

    @ApiModelProperty("授权token")
    private String accessToken;

    @ApiModelProperty("授权token超时时间（单位：s）")
    private Long expiresIn;

    @ApiModelProperty("刷新token")
    private String refreshToken;

    @ApiModelProperty("作用域")
    private String scope;

    @ApiModelProperty("第三方用户信息")
    private String oauthUserInfo;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("用户会话信息")
    private UserSession userSession;

    public UserDto() {
    }

    public UserDto(User user) {
        BeanUtils.copyProperties(user, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOauthType() {
        return oauthType;
    }

    public void setOauthType(String oauthType) {
        this.oauthType = oauthType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getOauthUserInfo() {
        return oauthUserInfo;
    }

    public void setOauthUserInfo(String oauthUserInfo) {
        this.oauthUserInfo = oauthUserInfo;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
}
