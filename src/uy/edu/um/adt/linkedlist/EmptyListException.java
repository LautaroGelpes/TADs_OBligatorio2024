package uy.edu.um.adt.linkedlist;

public class EmptyListException extends Exception{
    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }
}
