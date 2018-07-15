
package com.ngls.user.session;

import com.ngls.common.util.basic.PrintableBeanUtils;
import com.ngls.user.dto.UserDto;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户会话信息
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public final class UserInfo implements Serializable {

    private static final long serialVersionUID = -3612349479598051309L;

    @ApiModelProperty("用户id")
    public Long id;

    @ApiModelProperty("授权用户唯一标识")
    private String openId;

    @ApiModelProperty("同一个开发平台下 多个应用的unionId一致")
    private String unionId;

    @ApiModelProperty("授权用户会话秘钥")
    private String sessionKey;

    @ApiModelProperty("OAuth2.0认证类型，初期固定为wechat：微信")
    private String oauthType;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatarUrl;

    @ApiModelProperty("用户的性别，值为1时是男性，值为2时是女性，值为0时是未知")
    private Integer gender;

    @ApiModelProperty("用户所在城市")
    private String city;

    @ApiModelProperty("用户所在省份")
    private String province;

    @ApiModelProperty("用户所在国家")
    private String country;

    @ApiModelProperty("用户的语言，简体中文为zh_CN")
    private String language;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    public UserInfo() {
    }

    public UserInfo(UserDto userDto) {
        this.id = userDto.getId();
        this.openId = userDto.getOpenId();
        this.unionId = userDto.getUnionId();
        this.sessionKey = userDto.getSessionKey();
        this.oauthType = userDto.getOauthType();
        this.nickName = userDto.getNickName();
        this.avatarUrl = userDto.getAvatarUrl();
        this.gender = userDto.getGender();
        this.city = userDto.getCity();
        this.province = userDto.getProvince();
        this.country = userDto.getCountry();
        this.language = userDto.getLanguage();
        this.createTime = userDto.getCreateTime();
        this.updateTime = userDto.getUpdateTime();
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


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", oauthType='" + oauthType + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}