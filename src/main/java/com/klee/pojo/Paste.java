package com.klee.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class Paste implements Serializable {
    private int pasteId;

    private int blogId;

    private int bTagId;
}
