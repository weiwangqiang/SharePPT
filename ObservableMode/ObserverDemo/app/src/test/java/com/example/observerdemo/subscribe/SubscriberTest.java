package com.example.observerdemo.subscribe;

import org.junit.Test;

public class SubscriberTest {

    @Test
    public void subscriber() {
        EventChannel<String> eventEventChannel = new EventChannel<>();
        Publisher publisherA = new Publisher("publish A");
        Publisher publisherB = new Publisher("publish B");

        Subscriber subscriberA = new Subscriber("subscriber A");
        Subscriber subscriberB = new Subscriber("subscriber B");

        eventEventChannel.subscriber(subscriberA);
        eventEventChannel.subscriber(subscriberB);

        publisherA.publish(eventEventChannel, "A Event");
        publisherB.publish(eventEventChannel, "B Event");
        eventEventChannel.join();
    }
}
