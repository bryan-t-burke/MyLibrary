package org.myJava.myUtil;

public interface MyQueue<E> {
    boolean add(E e);

    E element();

    boolean offer(E e);

    E peek();

    E poll();

    E remove();
}
