package org.personal.myMap;

public interface MyMap<K, V> {
    public void clear();

    public boolean containsKey(Object key);

    public boolean containsValue(Object value);

    public V get(Object key);

    public default V getOrDefault(Object key, V defaultValue) {
        return defaultValue;
    }

    public boolean isEmpty();

    public V put(K key, V value);

    public default V putIfAbsent(K key, V value) {
        return value;
    }

    public boolean remove(Object o);

    public int size();
}
