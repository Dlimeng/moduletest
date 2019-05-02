package com.lm.design.structure.filter;

import lombok.Data;

/**
 * 应用标准
 * @Author: limeng
 * @Date: 2019/5/2 10:43
 */
@Data
public class Person {
    private String name;
    //性别
    private String gender;
    //婚姻状况
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
}
