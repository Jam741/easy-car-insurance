package com.ngls.user.domain;

import java.io.Serializable;

/**
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
public class UserJPADemo implements Serializable {

    private Long id;

    private String name;

    private int age;

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
