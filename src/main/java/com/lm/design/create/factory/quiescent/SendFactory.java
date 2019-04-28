package com.lm.design.create.factory.quiescent;

import com.lm.design.create.factory.simple.MailSender;
import com.lm.design.create.factory.simple.Sender;
import com.lm.design.create.factory.simple.SmsSender;

/**
 * 静态工厂
 * 共同接口
 * @Author: limeng
 * @Date: 2019/4/25 23:12
 */
public class SendFactory {
    public static Sender getProduceMail(){
        return new MailSender();
    }

    public static Sender getProduceSms(){
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender produceMail = SendFactory.getProduceMail();
        Sender produceSms = SendFactory.getProduceSms();
        produceMail.sendMessage();
        produceSms.sendMessage();
    }
}
