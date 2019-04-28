package com.lm.design.create.factory.simple;

/**
 *  简单工厂
 * @Author: limeng
 * @Date: 2019/4/25 22:41
 */
public class SendFactory {
    public Sender produce(String type){
        if(type.equals("mail")){
            return new MailSender();
        }else if(type.equals("sms")){
            return new SmsSender();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("mail");
        sender.sendMessage();
    }
}
