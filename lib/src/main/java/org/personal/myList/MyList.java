package org.personal.myList;

public interface MyList<E> {
    public boolean add(E e);

    public void clear();

    public boolean contains(Object o);

    public E get(int index);

    public boolean isEmpty();

    public boolean remove(Object o);

    public E set(int index, E element);

    public int size();

}