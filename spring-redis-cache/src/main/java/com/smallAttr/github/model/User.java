package com.smallAttr.github.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: chenGang
 * @Date: 2018/6/9 上午1:05
 * @Description:
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String email;
}
