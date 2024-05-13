package org.personal.myQueue;

public interface MyQueue<E> {
    boolean add(E e);

    E element();

    boolean offer(E e);

    E peek();

    E poll();

    E remove();
}
