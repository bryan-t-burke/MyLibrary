package org.personal.myPair;

// technically not a core java class, but it's very handy to have
public class MyPair<K, V> {

    // not sure if I want these final or modifiable yet.
    private final K key;
    private final V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}