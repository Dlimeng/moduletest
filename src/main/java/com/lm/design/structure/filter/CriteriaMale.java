package com.lm.design.structure.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 男
 * @Author: limeng
 * @Date: 2019/5/2 10:48
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> peoples = new ArrayList<>();
        for (Person person:persons){
            if(person.getGender().equalsIgnoreCase("MALE")){
                peoples.add(person);
            }
        }
        return persons;
    }
}
