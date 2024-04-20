package org.personal.myMap;

import org.personal.myList.MyArrayList;
import org.personal.myList.MyList;
import org.personal.myPair.MyPair;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private final int prime;
    private int size;

    // contents indexes are the hashes of the key.
    // each index contains a list of pairs
    // each pair's left is the unaltered key, each pair's right is the value
    // not the most efficient way to handle collisions but works for now
    private final MyList<MyList<MyPair<K, V>>> contents;

    public MyHashMap() {
        this.prime = 101; // prime number chosen arbitrarily
        this.contents = new MyArrayList<MyList<MyPair<K, V>>>(prime);
        for (int i = 0; i < this.prime; ++i) {
            this.contents.add(null);
        }
        this.size = 0;
    }

    @Override
    public void clear() {
        // we can't just go from 0 to this.size because the indexes won't be filled in order
        for (int i = 0; i < contents.size(); ++i) {
            contents.set(i, null);
        }
        this.size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int hash = key.hashCode() % this.prime;
        if (this.contents.get(hash) != null) {
            MyList<MyPair<K, V>> list = this.contents.get(hash);
            for (int i = 0; i < list.size(); ++i) {
                MyPair<K, V> pair = list.get(i);
                if (pair.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        // right now just exhaustively searching the whole container. Will revisit this method later.
        for (int i = 0; i < this.contents.size(); ++i) {
            MyList<MyPair<K, V>> list = this.contents.get(i);
            if (list != null) {
                for (int j = 0; j < list.size(); ++j) {
                    MyPair<K, V> pair = list.get(j);
                    if (pair.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hash = key.hashCode() % this.prime;
        MyList<MyPair<K, V>> list = this.contents.get(hash);
        if (list != null) {
            for (int i = 0; i < list.size(); ++i) {
                MyPair<K, V> pair = list.get(i);
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V value = this.get(key);
        return value == null ? defaultValue : value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode() % this.prime;
        MyList<MyPair<K, V>> list = this.contents.get(hash);
        if (list == null) {
            list = new MyArrayList<>();
        }
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            MyPair<K, V> pair = list.get(i);
            if (pair.getKey().equals(key)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            list.add(new MyPair<K, V>(key, value));
            this.contents.add(list);
        } else {
            list.set(index, new MyPair<>(key, value));
        }
        return value;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        int hash = key.hashCode() % this.prime;
        MyList<MyPair<K, V>> list = this.contents.get(hash);
        if (list == null) {
            list = new MyArrayList<>();
        }
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            MyPair<K, V> pair = list.get(i);
            if (pair.getKey().equals(key)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            list.add(new MyPair<K, V>(key, value));
            this.contents.add(list);
            return null;
        } else {
            return list.get(index).getValue();
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

}