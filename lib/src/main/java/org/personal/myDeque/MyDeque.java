package org.personal.myDeque;

import org.personal.myQueue.MyQueue;

public interface MyDeque<E> extends MyQueue<E> {
    boolean add(E e);

    void addFirst(E e);

    void addLast(E e);

    boolean contains(Object o);

    // Iterator<E> descendingIterator();

    E element();

    E getFirst();

    E getLast();

    // Iterator<E> iterator();

    boolean offer(E e);

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E peek();

    E peekFirst();

    E peekLast();

    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e);

    E remove();

    boolean remove(Object o);

    E removeFirst();

    boolean removeFirstOccurence(Object o);

    E removeLast();

    boolean removeLastOccurence(Object o);

    int size();
}
