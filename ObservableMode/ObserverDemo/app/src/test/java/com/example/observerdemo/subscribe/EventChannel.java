package com.example.observerdemo.subscribe;

import com.example.observerdemo.subscribe.base.ISubscriber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class EventChannel<M> {
    private BlockingDeque<Event<M>> linkedBlockingDeque = new LinkedBlockingDeque<>();
    private Map<M, Set<ISubscriber<M>>> subscriberMap = new HashMap<>();
    private Thread task;

    public EventChannel() {
        task = new Thread(() -> {
            try {
                Event<M> event;
                while ((event = linkedBlockingDeque.take()) != null) {
                    update(event.publisher, event);
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
        System.out.println(String.format("EventChannel 收到 %s 发布的消息 %s ", publisher, message));
        linkedBlockingDeque.offer(new Event(publisher, message));
    }

    public void cancel() {
        task.interrupt();
    }

    public void subscriber(M message, ISubscriber<M> subscriber) {
        if (!subscriberMap.containsKey(message)) {
            subscriberMap.put(message, new HashSet<>());
        }
        subscriberMap.get(message).add(subscriber);
    }

    public void unSubscriber(ISubscriber<M> subscriber) {
        subscriberMap.remove(subscriber);
    }

    public void update(String publisher, Event<M> event) {
        if (!subscriberMap.containsKey(event.message)) {
            return;
        }
        for (ISubscriber<M> subscriber : subscriberMap.get(event.message)) {
            subscriber.update(publisher, event.message);
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
