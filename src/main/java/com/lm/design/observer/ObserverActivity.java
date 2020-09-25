package com.lm.design.observer;

/**
 * @Classname ObserverActivity
 * @Description TODO
 * @Date 2020/1/23 14:18
 * @Created by limeng
 */
public class ObserverActivity {

    public static void main(String[] args) {
        ISubject  mNewsPaperOffice = new NewsPaperOffice();
        FirstObserver mFirstObserver = new FirstObserver();

        SecondObserver mSecondObserver = new SecondObserver();

        mNewsPaperOffice.registerObserver(mFirstObserver);
        mNewsPaperOffice.registerObserver(mSecondObserver);
        mNewsPaperOffice.notifyObserver();

        System.out.println(mFirstObserver.getMessage());
        System.out.println(mSecondObserver.getMessage());

    }
}
