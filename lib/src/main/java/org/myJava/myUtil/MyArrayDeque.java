package org.myJava.myUtil;

import java.util.NoSuchElementException;

public class MyArrayDeque<E> implements MyDeque<E> {
    private int size;
    private int first;
    private int last;
    private Object[] contents;

    public MyArrayDeque() {
        this.size = 20;
        // since you can add to the front and back we want to keep the contents toward the middle
        this.first = 10;
        this.last = this.first;
        this.contents = new Object[this.size];
    }

    @Override
    public boolean add(E e) {
        // documentation lists it as the same as addLast, but addLast is void so calling offerLast
        return this.offerLast(e);
    }

    @Override
    public void addFirst(E e) {
        this.offerFirst(e);
    }

    @Override
    public void addLast(E e) {
        this.add(e);
    }

    public void clear() {
        for (int i = this.first; i < this.last + 1; ++i) {
            this.contents[i] = null;
            this.first = this.contents.length / 2;
            this.last = this.first;
            this.size = 0;
        }
    }

    //public ArrayDeque<E> clone() {}

    @Override
    public boolean contains(Object o) {
        return false;
    }

    //descendingIterator

    @Override
    public E element() {
        return this.getFirst();
    }

    @Override
    public E getFirst() {
        E item = this.peekFirst();
        if (null == item) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public E getLast() {
        E item = this.peekLast();
        if (null == item) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //iterator

    @Override
    public boolean offer(E e) {
        return this.offerLast(e);
    }

    @Override
    public boolean offerFirst(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        if (this.first == 0) {
            this.resize();
        }

        --this.first;
        this.contents[this.first] = e;
        ++this.size;
        // no capacity restriction on ArrayDeque
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        if (this.last == contents.length - 1) {
            this.resize();
        }

        ++this.last;
        this.contents[this.last] = e;
        ++this.size;
        // no capacity restriction on ArrayDeque
        return true;
    }

    @Override
    public E peek() {
        return this.peekFirst();
    }

    @Override
    public E peekFirst() {
        if (this.size == 0) {
            return null;
        }
        return (E) this.contents[this.first];
    }

    @Override
    public E peekLast() {
        if (this.size == 0) {
            return null;
        }
        return (E) this.contents[this.last];
    }

    @Override
    public E poll() {
        return this.pollFirst();
    }

    @Override
    public E pollFirst() {
        if (this.size == 0) {
            return null;
        }
        E item = (E) this.contents[this.first];
        this.contents[this.first] = null;
        ++this.first;
        --this.size;
        return item;
    }

    @Override
    public E pollLast() {
        if (this.size == 0) {
            return null;
        }
        E item = (E) this.contents[this.last];
        this.contents[this.last] = null;
        --this.last;
        --this.size;
        return item;
    }

    @Override
    public E pop() {
        return this.removeFirst();
    }

    @Override
    public void push(E e) {
        this.addFirst(e);
    }

    @Override
    public E remove() {
        return this.removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        return this.removeFirstOccurence(o);
    }

    @Override
    public E removeFirst() {
        E item = this.pollFirst();
        if (null == item) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public boolean removeFirstOccurence(Object o) {
        if (this.size == 0) {
            return false;
        }




        return false;
    }

    @Override
    public E removeLast() {
        E item = this.pollLast();
        if (null == item) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public boolean removeLastOccurence(Object o) {
        if (this.size == 0) {
            return false;
        }






        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void resize() {
        if (this.size < this.contents.length / 2) {
            // if there's space in the array just shift the contents back to the middle
            this.shiftContents();
            return;
        }

    }
    private void shiftContents() {

    }

}
