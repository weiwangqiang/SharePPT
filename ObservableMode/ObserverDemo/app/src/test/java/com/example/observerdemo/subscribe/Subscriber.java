package com.example.observerdemo.subscribe;

import com.example.observerdemo.subscribe.base.ISubscriber;

public class Subscriber implements ISubscriber<String> {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String publisher, String message) {
        System.out.println(String.format("%s 收到 %s 的 %s 消息 ", name, publisher, message));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s 处理完 %s 的 %s 消息 ", name, publisher, message));
    }
}
