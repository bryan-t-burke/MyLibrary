package org.myJava.myUtil;

public class MyArrayList<E> implements MyList<E> {

    private int size;
    private Object[] contents;

    public MyArrayList() {
        this.size = 0;
        this.contents = new Object[10]; // 10 chosen arbitrarily
    }

    public MyArrayList(int initialCapacity) {
        this.size = 0;
        this.contents = new Object[initialCapacity];
    }

    @Override
    public boolean add(E element) {
        // check the current number of elements
        if (this.contents.length == this.size()) {
            // if the array is full we need to allocate more space before we can insert the new element
            if (!this.increaseSize()) {
                // if we were unable to increase the size of the array, return early
                return false;
            }
        }
        // add the new element to the end and increase the size counter
        this.contents[size++] = element;

        // element successfully added
        return true;
    }

    @Override
    public void clear() {
        // for now, I'm making a trade-off for space instead of time, so instead of spending time shrinking the array now and
        // possibly having to increase it again later, I'm just leaving the space that was previously allocated
        for (int i = 0; i < this.size; ++i) {
            this.contents[i] = null;
        }
        this.size = 0;
    }

    @Override
    public boolean contains(Object compareTo) {
        // use this.size instead of contents.length since the array will likely be larger than the number of elements.
        for (int i = 0; i < this.size; ++i) {
            if (null == compareTo && null == this.contents[i]) {
                return true;
            } else if (null != this.contents[i] && this.contents[i].equals(compareTo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    //@SuppressWarnings("unchecked")
    // compiler doesn't like the (E) cast, so I need to decide if/how I want to change that or if I just want to suppress
    // the warning
    public E get(int index) {
        if (size - 1 < index) {
            // technically it will do this anyway without the check, and technically we null out the values in the array when
            // remove them, but adding this as a safety net.
            throw new IndexOutOfBoundsException(String.format("Index %d is outside the current bounds of the list", index));
        }
        return (E) this.contents[index];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean remove(Object o) {
        // for now, I'm making a trade-off for space instead of time, so instead of spending time shrinking the array now and
        // possibly having to increase it again later, I'm just leaving the space that was previously allocated
        this.contents[--size] = null;
        return true;
    }

    @Override
    //@SuppressWarnings("unchecked")
    public E set(int index, E element) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        this.contents[index] = element;
        return (E) this.contents[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean increaseSize() {
        // 2x chosen arbitrarily. For now this implementation will use extra space as a trade-off for compute time.
        // So instead of increasing by small amounts and possibly having to do it a lot, we'll increase by large amounts
        // to reduce the number of times this method is called.
        try {
            Object[] newContents = new Object[this.contents.length * 2];
            for (int i = 0; i < this.contents.length; ++i) {
                newContents[i] = this.contents[i];
            }
            contents = newContents;
        } catch (Exception e) {
            // not really sure what can go wrong here, but just in case
            return false;
        }
        return true;
    }

}