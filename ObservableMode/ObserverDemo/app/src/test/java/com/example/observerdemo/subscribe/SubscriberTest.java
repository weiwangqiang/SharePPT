package com.example.observerdemo.subscribe;

import org.junit.Test;

public class SubscriberTest {

    @Test
    public void subscriber() {
        EventChannel<String> eventEventChannel = new EventChannel<>();
        Publisher publisherA = new Publisher("publisher A");
        Publisher publisherB = new Publisher("publisher B");

        Subscriber subscriberA = new Subscriber("subscriber A");
        Subscriber subscriberB = new Subscriber("subscriber B");

        eventEventChannel.subscriber(EventType.START.name(), subscriberA);
        eventEventChannel.subscriber(EventType.END.name(), subscriberB);

        publisherA.publish(eventEventChannel, EventType.START.name());
        publisherB.publish(eventEventChannel, EventType.END.name());
        eventEventChannel.join();
    }

    private enum EventType {
        START, END
    }
}
