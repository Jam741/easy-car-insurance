
package com.ngls.user.dto;

import com.ngls.user.session.UserSession;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 5897963366243976312L;

    @ApiModelProperty("用户id")
    public Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOauthUserInfo() {
        return oauthUserInfo;
    }

    public void setOauthUserInfo(String oauthUserInfo) {
        this.oauthUserInfo = oauthUserInfo;
    }
}