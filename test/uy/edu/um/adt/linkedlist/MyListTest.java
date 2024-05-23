package uy.edu.um.adt.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.adt.Exceptions.EmptyListException;
import uy.edu.um.adt.Exceptions.InvalidValue;

import static org.junit.Assert.*;

public class MyListTest {
    MyList<String> myList;

    @Before
    public void Base(){
        myList = new MyLinkedListImpl<>();
        myList.add("value1");
        myList.add("value2");
        myList.add("value3");
        myList.add("value4");
        myList.add("value5");
    }

    @Test
    public void addTest() {
        Assert.assertTrue(myList.contains("value4"));
    }

    @Test
    public void getTest() throws EmptyListException, InvalidValue {
        Assert.assertEquals("value3",myList.get(2));
    }
    @Test(expected = InvalidValue.class)
    public void getInvalidValueTest1() throws EmptyListException, InvalidValue {
        myList.get(-1);
    }
    @Test(expected = InvalidValue.class)
    public void getInvalidValueTest2() throws EmptyListException, InvalidValue {
        myList.get(6);
    }
    @Test
    public void containsFalseTest() {
        Assert.assertFalse(myList.contains("value10"));
    }

    @Test
    public void removeTest() throws EmptyListException,InvalidValue {
        myList.remove("value4");
        Assert.assertFalse(myList.contains("value4"));
    }
    @Test(expected = InvalidValue.class)
    public void removeInvalidValueTest() throws EmptyListException,InvalidValue {
        myList.remove("HelloWorld");
    }
    @Test
    public void sizeTest() {
        Assert.assertEquals(5,myList.size());
    }

    @Test
    public void getFirsttest() {
        Assert.assertEquals("value1",myList.getFirst());
    }

    @Test
    public void isEmptyFalseTest() {
        Assert.assertFalse(myList.isEmpty());

    }

    @Test
    public void isEmptyTrueTest() {
        MyList<String> myOtherList = new MyLinkedListImpl<>();
        Assert.assertTrue(myOtherList.isEmpty());

    }
}