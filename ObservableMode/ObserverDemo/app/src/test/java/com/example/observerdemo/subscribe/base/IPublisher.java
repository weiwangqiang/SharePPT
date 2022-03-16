package com.example.observerdemo.subscribe.base;

import com.example.observerdemo.subscribe.EventChannel;

public interface IPublisher<M> {
    void publish(EventChannel eventChannel, M event);
}
