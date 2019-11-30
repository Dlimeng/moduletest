package com.lm.jvm;

/**
 * @Classname Passenger
 * @Description TODO
 * @Date 2019/11/30 19:00
 * @Created by limeng
 */
public abstract class Passenger {
    abstract void passThroughImmigration();

    public static void main(String[] args) {
        Passenger chinesePassenger = new ChinesePassenger();
        Passenger foreignerPassenger = new ForeignerPassenger();

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000 ; i++) {
            if(i % 100_000_000 == 0){
                long temp = System.currentTimeMillis();
                System.out.println("i:"+i+" "+(temp - current));

                current = temp;
            }
            Passenger passenger = (i < 1_000_000_000) ? chinesePassenger : foreignerPassenger;
            passenger.passThroughImmigration();
        }

    }


}
class ChinesePassenger extends Passenger { @Override void passThroughImmigration() {} }
class ForeignerPassenger extends Passenger { @Override void passThroughImmigration() {
}}