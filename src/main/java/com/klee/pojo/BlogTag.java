package com.klee.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class BlogTag implements Serializable {
    private int bTagId;

    private String bTagName;
}
