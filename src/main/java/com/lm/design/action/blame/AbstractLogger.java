package com.lm.design.action.blame;

/**
 * @Author: limeng
 * @Date: 2019/5/8 21:44
 */
public abstract class AbstractLogger {
    public  final static int INFO =1;
    public  final static int DEBUG = 2;
    public  final static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level,String message){
        if(this.level <= level){
            write(message);
        }else{
            /**
             * 如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者
             */
            if (nextLogger != null) {
                nextLogger.logMessage(level,message);
            }
        }

    }

    abstract protected void write(String message);

}
