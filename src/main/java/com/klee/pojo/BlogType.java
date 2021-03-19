package com.klee.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class BlogType implements Serializable {
    private int bTypeId;
    private String bTypeName;
}
