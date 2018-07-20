package com.ngls.user.dto;

import com.ngls.user.domain.Banner;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class BannerDto implements Serializable {


    @ApiModelProperty("ID")
    public Long id;

    @ApiModelProperty("图片地址")
    private String img;

    @ApiModelProperty("网址")
    private String action;


    public BannerDto() {
    }

    public BannerDto(Banner banner) {
        BeanUtils.copyProperties(banner, this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
