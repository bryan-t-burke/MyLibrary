package org.personal.myPair;

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