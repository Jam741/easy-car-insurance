package com.ngls.user.dto;


import com.ngls.user.domain.GroupBooking;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel
public class GroupBookingDto implements Serializable {

    @ApiModelProperty("拼团 ID")
    public Long id;

    @ApiModelProperty("车牌号")
    private String licenseNo;

    @ApiModelProperty("车主姓名")
    private String ownerName;

    @ApiModelProperty("车险到期时间")
    private LocalDateTime lastDate;

    @ApiModelProperty("车主电话号码")
    private String ownerPhone;

    @ApiModelProperty("用户 ID")
    private Long userId;

    @ApiModelProperty("上家投保公司信息")
    private Long companyId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public GroupBookingDto(GroupBooking groupBooking) {
        BeanUtils.copyProperties(groupBooking, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDateTime getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDateTime lastDate) {
        this.lastDate = lastDate;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
}
