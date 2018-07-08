package com.ngls.basic.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO 可以考虑以后跟多个码表结合，增加type字段标识码类型
 *
 * @author Kixs
 * @version 1.0, 2018/7/8
 */
@Entity
@Table(name = "insurance_supported_city")
public class InsuranceSupportedCity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) comment '支持城市名称'")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
