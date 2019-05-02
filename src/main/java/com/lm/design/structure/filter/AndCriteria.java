package com.lm.design.structure.filter;

import java.util.List;

/**
 * 合并标准
 * @Author: limeng
 * @Date: 2019/5/2 11:01
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons  = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons );
    }
}
