package com.lm.jvm.oom;

/**
 * 1.对象可以被GC时自我拯救
 * 2.这种自救的机会一次，因为一对象的finalize方法最多只会被系统自动调用一次
 * @Classname FinalizeEscapeGC
 * @Description TODO
 * @Date 2020/1/25 4:06
 * @Created by limeng
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes,I am still alive;");
    }


    @Override
    protected void finalize() throws Throwable {

        super.finalize();

        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no I am dead;");
        }

        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no I am dead;");
        }
    }
}
