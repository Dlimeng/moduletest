package com.lm.analyze;

import lombok.Data;

/**
 * @Author: limeng
 * @Date: 2019/4/23 22:47
 */
@Data
public class Account {
    /***
     * 主键
     */
    private Long id;

    /***
     * 用户真实姓名
     */
    private String realname;

    /**
     * 医院id
     */
    private Integer hospitalId;
}
