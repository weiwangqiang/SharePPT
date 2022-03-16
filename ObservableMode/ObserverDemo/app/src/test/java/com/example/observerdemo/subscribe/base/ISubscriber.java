package com.example.observerdemo.subscribe.base;

public interface ISubscriber<M> {
    void update(String publisher, M message);
}
