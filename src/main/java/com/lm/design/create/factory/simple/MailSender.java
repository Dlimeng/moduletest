package com.lm.design.create.factory.simple;

/**
 * @Author: limeng
 * @Date: 2019/4/25 22:39
 */
public class MailSender implements Sender {
    @Override
    public void sendMessage() {
        System.out.println("send MailSender");
    }
}
