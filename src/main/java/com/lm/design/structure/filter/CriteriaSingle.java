package com.lm.design.structure.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 婚姻状况
 * @Author: limeng
 * @Date: 2019/5/2 10:55
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> peoples = new ArrayList<>();
        for (Person person : persons){
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                peoples.add(person);
            }
        }

        return peoples;
    }
}
