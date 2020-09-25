package com.lm.jvm;

import java.lang.invoke.*;

/**
 * @Classname Circuit
 * @Description TODO
 * @Date 2019/12/17 11:13
 * @Created by limeng
 */
public class Circuit {
    public static void startRace(Object obj){

    }

    public static void main(String[] args) {

        startRace(new Horse());

    }

    public static CallSite bootstrap(MethodHandles.Lookup l, String name, MethodType callSiteType) throws Throwable{
        MethodHandle mh = l.findVirtual(Horse.class, name, MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(callSiteType));
    }

}

class Horse{
    public void race(){
        System.out.println("Horse.race()");
    }
}

class Deer{
    public void race(){
        System.out.println("Deer.race()");
    }
}
