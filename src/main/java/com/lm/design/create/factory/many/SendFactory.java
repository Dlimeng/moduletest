package com.lm.design.create.factory.many;

import com.lm.design.create.factory.simple.MailSender;
import com.lm.design.create.factory.simple.Sender;
import com.lm.design.create.factory.simple.SmsSender;

/**
 * 多个工厂
 * @Author: limeng
 * @Date: 2019/4/25 22:47
 */
public class SendFactory {

    public Sender getProduceMail(){
        return new MailSender();
    }

    public Sender getProduceSms(){
        return new SmsSender();
    }

    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender produceMail = sendFactory.getProduceMail();
        Sender produceSms = sendFactory.getProduceSms();
        produceMail.sendMessage();
        produceSms.sendMessage();
    }
}
