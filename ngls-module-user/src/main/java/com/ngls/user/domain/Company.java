package com.ngls.user.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "varchar(50) comment '保险公司名称'")
    private String name;

    @Column(columnDefinition = "varchar(100) comment 'log'")
    private String logo;

    @Column(columnDefinition = "varchar(100) comment 'slogin'")
    private String slogin;

    @Column(columnDefinition = "varchar(50) comment '主页'")
    private String home;


    public Company() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogin() {
        return slogin;
    }

    public void setSlogin(String slogin) {
        this.slogin = slogin;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
