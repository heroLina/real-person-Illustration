package com.ln.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lina on 2018/5/18.
 */
@Data
public class Admin implements Serializable {
    private Integer id;
    private String mobile;
    private String name;
}
