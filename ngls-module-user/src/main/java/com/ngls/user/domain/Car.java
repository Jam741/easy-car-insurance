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

    @Column(columnDefinition = "comment '保险公司Id'")
    public Long companyId;
}
