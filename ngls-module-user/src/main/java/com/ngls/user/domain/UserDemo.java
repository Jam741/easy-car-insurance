package com.ngls.user.domain;

import io.swagger.annotations.ApiModelProperty;

public class UserDemo {

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户年龄")
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
