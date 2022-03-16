package com.example.observerdemo.subscribe;

public class Event<M> {
    public Event(String publisher, M message) {
        this.publisher = publisher;
        this.message = message;
    }

    public String publisher;
    public M message;
}
