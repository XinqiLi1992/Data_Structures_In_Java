package main.ds.deque;

public interface Deque<E> {
    int getSize();
    boolean isEmpty();
    void addLast(E e);
    void addFront(E e);
    E removeLast();
    E removeFront();
    E getLast();
    E getFront();
}
