package com.example.observerdemo.subscribe;

import com.example.observerdemo.subscribe.base.ISubscriber;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class EventChannel<M> {
    private BlockingDeque<Event<M>> linkedBlockingDeque = new LinkedBlockingDeque<>();
    private Set<ISubscriber<M>> subscriberList = new HashSet<>();
    private Thread task;

    public EventChannel() {
        task = new Thread(() -> {
            try {
                Event<M> event;
                while ((event = linkedBlockingDeque.take()) != null) {
                    update(event.publisher, event.message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        task.start();
    }

    public void join() {
        try {
            task.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(String publisher, M message) {
        System.out.println(String.format("EventChannel 收到 消息 %s ", message));
        linkedBlockingDeque.offer(new Event(publisher, message));
    }

    public void cancel() {
        task.interrupt();
    }

    public void subscriber(ISubscriber<M> subscriber) {
        subscriberList.add(subscriber);
    }

    public void unSubscriber(ISubscriber<M> subscriber) {
        subscriberList.remove(subscriber);
    }

    public void update(String publisher, M message) {
        for (ISubscriber<M> subscriber : subscriberList) {
            subscriber.update(publisher, message);
        }
    }

    public static class Event<M> {
        public Event(String publisher, M message) {
            this.publisher = publisher;
            this.message = message;
        }

        public String publisher;
        public M message;
    }
}
