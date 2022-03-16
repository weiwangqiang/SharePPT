package com.example.observerdemo.subscribe;

import com.example.observerdemo.subscribe.base.IPublisher;

public class Publisher implements IPublisher<String> {

    private String publisher;

    public Publisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(EventChannel eventChannel, String event) {
        eventChannel.publish(publisher, event);
    }
}
