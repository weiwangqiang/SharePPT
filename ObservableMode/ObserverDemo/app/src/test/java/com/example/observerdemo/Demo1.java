package com.example.observerdemo;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class Demo1 {
    @Test
    public void test() {
        Observable observable = new StringObservable();
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(" ==> " + arg);
            }
        };
        observable.addObserver(observer);
        observable.notifyObservers("update");
    }

    private static class StringObservable extends Observable {
        @Override
        public void notifyObservers() {
            setChanged();
            super.notifyObservers();
        }

        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    }
}