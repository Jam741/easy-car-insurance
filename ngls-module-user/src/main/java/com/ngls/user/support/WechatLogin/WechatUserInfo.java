
package com.ngls.user.support.WechatLogin;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 微信用户信息
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public class WechatUserInfo implements Serializable {

    private static final long serialVersionUID = 2405515468673620968L;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("openid")
    private String openid;

    @ApiModelProperty("unionid")
    private String unionid;

    @ApiModelProperty("昵称")
    private String nickname;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
}
