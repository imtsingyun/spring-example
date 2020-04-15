package me.alphar.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sendMail(String to) {
        System.out.println("MailSender: 模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(this.applicationContext, to);
        applicationContext.publishEvent(mse);
    }
}
