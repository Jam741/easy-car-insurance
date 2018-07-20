package com.ngls.user.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 广告
 */

@Table(name = "banner")
@Entity
public class Banner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "varchar(200) comment '图片URL'")
    private String img;

    @Column(columnDefinition = "varchar(200) comment '图片对应的网址'")
    private String action;


    public Banner() {
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
