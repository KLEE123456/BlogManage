package com.klee.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客实体类
 */
@Component
@Data
public class Blog implements Serializable {
    private int blogId;

    private String blogTitle;

    private String blogComment;

    private String blogPhoto;

    private String blogFlag;

    private String blogView;

    private boolean appreciation;//赞赏开启

    private boolean shareStatement;//版权开启

    private boolean commentabled;//评论开启

    private boolean published;//发布

    private boolean recommend;//推荐

    private Date createTime;

    private Date updateTime;

    private BlogType blogType;

    private User user;

}
