package com.wl.springbootdemo01.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author w.z
 * @date 2019/8/8 16:59
 * controller返回结果实体类
 */
public class ResultVo<T> implements Serializable {

    /**
     * 状态提示码
     */
    @ApiModelProperty(example = "0000")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty(example = "成功")
    private String msg;

    /**
     * 具体内容
     */
    private T data;  

    public ResultVo() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
