package uy.edu.um.adt.linkedlist;

import uy.edu.um.adt.Exceptions.EmptyListException;

public interface MyList<T> {

    void add(T value);

    T get(int position) throws EmptyListException;

    boolean contains(T value);

    void remove(T value) throws EmptyListException;

    int size();

    T getFirst();

    boolean isEmpty();
}
