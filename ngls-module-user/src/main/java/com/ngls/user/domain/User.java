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
@Entity
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

    @Column(columnDefinition = "varchar(128) comment '授权用户会话秘钥'")
    private String sessionKey;

    @Column(columnDefinition = "varchar(20) comment 'OAuth2.0认证类型，初期固定为wechat：微信'")
    private String oauthType; // OAuth2.0认证类型，初期固定为wechat：微信

    @Column(columnDefinition = "varchar(50) comment '昵称'")
    private String nickName; // 昵称

    @Column(columnDefinition = "varchar(255) comment '头像'")
    private String avatarUrl; // 头像

    @Column(columnDefinition = "int(1) comment '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知'")
    private Integer gender; // 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知

    @Column(columnDefinition = "varchar(20) comment '用户所在城市'")
    private String city; // 用户所在城市

    @Column(columnDefinition = "varchar(20) comment '用户所在省份'")
    private String province; // 用户所在省份

    @Column(columnDefinition = "varchar(20) comment '用户所在国家'")
    private String country; // 用户所在国家

    @Column(columnDefinition = "varchar(20) comment '用户的语言，简体中文为zh_CN'")
    private String language; // 用户的语言，简体中文为zh_CN

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

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
