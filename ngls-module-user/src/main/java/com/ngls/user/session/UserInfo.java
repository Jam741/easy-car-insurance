
package com.ngls.user.session;

import com.ngls.common.util.basic.PrintableBeanUtils;
import com.ngls.user.dto.CustomerDto;
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

    @ApiModelProperty("OAuth2.0认证类型，初期固定为wechat：微信")
    private String oauthType;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String headImage;

    @ApiModelProperty("作用域")
    private String scope;

    @ApiModelProperty("第三方用户信息")
    private String oauthUserInfo;

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
        this.oauthType = userDto.getOauthType();
        this.nickName = userDto.getNickName();
        this.headImage = userDto.getHeadImage();
        this.scope = userDto.getScope();
        this.oauthUserInfo = userDto.getOauthUserInfo();
        this.createTime = userDto.getCreateTime();
        this.updateTime = userDto.getUpdateTime();
    }

    @Override
    public String toString() {
        return PrintableBeanUtils.toString(this);
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