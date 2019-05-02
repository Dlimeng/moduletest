package com.lm.design.structure.filter;

import java.util.List;

/**
 * 标准
 * @Author: limeng
 * @Date: 2019/5/2 10:42
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
