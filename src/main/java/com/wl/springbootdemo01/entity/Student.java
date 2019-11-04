package com.wl.springbootdemo01.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户实体类
 * @author w.z
 * @date 2019/11/1 10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "student",description = "学生信息")
public class Student {

    /**
     * 学号
     */
    @NotNull
    @ApiModelProperty(example = "31201709229")
    @Pattern(regexp = "[0-9]{13}",message = "学号格式错误")
    private String studentno;

    /**
     * 姓名
     */
    @NotNull
    @ApiModelProperty(example = "wz")
    private String stname;

    /**
     * 性别
     */
    @NotNull
    @ApiModelProperty(example = "女")
    private String sex;

    /**
     * 地址
     */
    @NotNull
    @ApiModelProperty(example = "xx大学")
    private String address;
}
