package com.lm.design.structure.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 女性
 * @Author: limeng
 * @Date: 2019/5/2 10:52
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> peoples = new ArrayList<>();
        for (Person person:persons){
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                peoples.add(person);
            }
        }
        return peoples;
    }
}
