package com.lm.design.observer;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname NewsPaperOffice
 * @Description TODO
 * @Date 2020/1/23 14:13
 * @Created by limeng
 */
public class NewsPaperOffice implements ISubject {
    private int time = 1;
    private List<IObserver> mList = new ArrayList<>();
    @Override
    public void registerObserver(IObserver iObserver) {
        if(iObserver != null){
            mList.add(iObserver);
        }
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        mList.remove(iObserver);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < mList.size(); i++) {
            mList.get(i).update("第"+time +"次发的新闻");
        }
        time++;
    }
}
