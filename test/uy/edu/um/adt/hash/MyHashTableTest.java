package uy.edu.um.adt.hash;

import org.junit.Assert;
import org.junit.Test;
import uy.edu.um.adt.Exceptions.InvalidValue;

import static org.junit.Assert.*;

public class MyHashTableTest {
    HashTable<Object,Object> hash = new HashTable<>();

    @Test
    public void put() {


    }

    @Test
    public void contains() {
    }

    @Test
    public void remove() throws InvalidValue {
        hash.put("ola","Prueba1");
        hash.put("alo","Prueba2");
        hash.remove("alo");
        Assert.assertFalse(hash.contains("alo"));
    }
}