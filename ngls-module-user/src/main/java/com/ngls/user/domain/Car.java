package com.ngls.user.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "car")
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "varchar(20) comment '车牌号'")
    public String licenseNo;

    @Column(columnDefinition = "int(10) comment '城市code'")
    public int cityCode;

    @Column(columnDefinition = "varchar(20) comment '车架号'")
    public String carVin;

    @Column(columnDefinition = "varchar(20) comment '发动机号'")
    public String engineNo;

    @Column(columnDefinition = "int(2) comment '大小号牌：0小车，1大车，默认0'")
    public int renewalCarType;

    @Column(columnDefinition = "varchar(50) comment '车主名字'")
    public String licenseOwner;

    @Column(columnDefinition = "varchar(18) comment '车主电话号码'")
    public String ownerPhone;

    @Column(columnDefinition = "varchar(10) comment '车主身份证后六位'")
    public String sixDigitsAfterIdCard;

    @Column(columnDefinition = "int(2) comment '使用性质\n" +
            "1：家庭自用车（默认），\n" +
            "2：党政机关、事业团体，\n" +
            "3：非营业企业客车，\n" +
            "4：不区分营业非营业（仅支持人保报价），\n" +
            "5：出租租赁（仅支持人保报价），\n" +
            "6：营业货车（仅支持人保报价），\n" +
            "7：非营业货车（仅支持人保报价）\n" +
            "8: 城市公交\n'")
    public int carUsedType;

    @Column(columnDefinition = "varchar(50) comment '投保人'")
    public String postedName;

    @Column(columnDefinition = "varchar(50) comment '被保人'")
    public String insuredName;

    @Column(columnDefinition = "int(50) comment '保险公司Id'")
    public Long companyId;


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

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public int getRenewalCarType() {
        return renewalCarType;
    }

    public void setRenewalCarType(int renewalCarType) {
        this.renewalCarType = renewalCarType;
    }

    public String getLicenseOwner() {
        return licenseOwner;
    }

    public void setLicenseOwner(String licenseOwner) {
        this.licenseOwner = licenseOwner;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getSixDigitsAfterIdCard() {
        return sixDigitsAfterIdCard;
    }

    public void setSixDigitsAfterIdCard(String sixDigitsAfterIdCard) {
        this.sixDigitsAfterIdCard = sixDigitsAfterIdCard;
    }

    public int getCarUsedType() {
        return carUsedType;
    }

    public void setCarUsedType(int carUsedType) {
        this.carUsedType = carUsedType;
    }

    public String getPostedName() {
        return postedName;
    }

    public void setPostedName(String postedName) {
        this.postedName = postedName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
