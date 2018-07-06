package com.ngls.user.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
@Entity
@Table(name = "user_jap_demo")
public class UserJpaDemo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment '姓名'")
    private String name;

    @Column(columnDefinition = "int(5) comment '年龄'")
    private int age;

    public UserJpaDemo() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
