package com.ngls.user.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author Kixs
 * @version 1.0, 2018/7/3
 */
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -431535053464985789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "varchar(128) comment '授权用户唯一标识'")
    private String openId; // 授权用户唯一标识

    @Column(columnDefinition = "varchar(128) comment '授权用户唯一标识'")
    private String unionId; //同一个开发平台下 多个应用的unionId一致

    @Column(columnDefinition = "varchar(20) comment 'OAuth2.0认证类型，初期固定为wechat：微信'")
    private String oauthType; // OAuth2.0认证类型，初期固定为wechat：微信

    @Column(columnDefinition = "varchar(50) comment '昵称'")
    private String nickName; // 昵称

    @Column(columnDefinition = "varchar(255) comment '头像'")
    private String headImage; // 头像

    @Column(columnDefinition = "varchar(128) comment '授权token'")
    private String accessToken; // 授权token

    @Column(columnDefinition = "int(11) comment '授权token超时时间（单位：s）'")
    private Long expiresIn; // 授权token超时时间（单位：s）

    @Column(columnDefinition = "varchar(128) comment '刷新token'")
    private String refreshToken; // 刷新token

    @Column(columnDefinition = "text comment '作用域'")
    private String scope; // 作用域

    @Column(columnDefinition = "text comment '第三方用户信息'")
    private String oauthUserInfo; // 第三方用户信息

    @Column(columnDefinition = "datetime comment '创建时间'")
    private LocalDateTime createTime; // 创建时间

    @Column(columnDefinition = "datetime comment '更新时间'")
    private LocalDateTime updateTime; // 更新时间

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
}
