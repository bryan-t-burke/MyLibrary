package org.personal.myMap;

public interface MyMap<K, V> {
    void clear();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    default V getOrDefault(Object key, V defaultValue) {
        return defaultValue;
    }

    boolean isEmpty();

    V put(K key, V value);

    default V putIfAbsent(K key, V value) {
        return value;
    }

    boolean remove(Object o);

    int size();
}
