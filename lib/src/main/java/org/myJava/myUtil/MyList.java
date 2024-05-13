package org.myJava.myUtil;

public interface MyList<E> {
    boolean add(E e);

    void clear();

    boolean contains(Object o);

    E get(int index);

    boolean isEmpty();

    boolean remove(Object o);

    E set(int index, E element);

    int size();

}