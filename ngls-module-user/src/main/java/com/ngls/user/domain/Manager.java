package com.ngls.user.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 管理员信息
 *
 * @author Kixs
 * @version 1.0, 2018/7/4
 */
@Entity
@Table(name = "manager")
public class Manager implements Serializable {

    private static final long serialVersionUID = 6113831341251817296L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "varchar(30) comment '登录账号名'")
    private String userName; // 登录账号名

    @Column(columnDefinition = "varchar(18) comment '绑定手机号'")
    private String userPhone; // 绑定手机号

    @Column(columnDefinition = "varchar(512) comment '密码'")
    private String password; // 密码

    @Column(columnDefinition = "varchar(20) comment '真实姓名'")
    private String name; // 真实姓名

    @Column(columnDefinition = "char(1) comment '管理员类型'")
    private String managerType; // 管理员类型

    @Column(columnDefinition = "tinyint(1) comment '是否可用'")
    private Boolean available; // 是否可用

    @Column(columnDefinition = "tinyint(1) comment '是否删除'")
    private Boolean deleted; // 是否删除

    @Column(columnDefinition = "int(11) comment '创建人id，表示此账号由谁创建'")
    private Long creatorId; // 创建人id，表示此账号由谁创建

    @Column(columnDefinition = "datetime comment '最近一次登录时间'")
    private Date lastLoginTime; // 最近一次登录时间

    @Column(columnDefinition = "varchar(15) comment '最近一次登录IP地址'")
    private String lastLoginIp; // 最近一次登录IP地址

    @Column(columnDefinition = "varchar(15) comment '注册IP地址'")
    private String registerIp; // 注册IP地址

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
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
