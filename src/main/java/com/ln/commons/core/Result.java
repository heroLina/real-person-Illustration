package com.ln.commons.core;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lina on 2018/5/18.
 */
@Data
public class Result implements Serializable{
    private Integer code;
    private String msg;
    private Object data;
    public Result(Integer code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    public Result(Object data){
        this.code=0;
        this.msg="success";
        this.data=data;
    }
}
