package com.crystal.DependencyInjection;

public class MyMessageDITest {

    public static void main(String [] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        String phone = "4088888888";

        MessageServiceInjector injector = null;
        Consumer app = null;

        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }

}
