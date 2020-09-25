package com.lm.design.action.observed;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: limeng
 * @Date: 2019/5/27 21:51
 */
public class Subject {
    private List<Observed> observeds=new ArrayList<>();
    private int state;

    public void attach(Observed observed){
        observeds.add(observed);
    }

    public void notifyAllObservers(){
        for (Observed observed : observeds){
            observed.update();
        }
    }

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }
}
