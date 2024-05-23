package uy.edu.um.adt.hash;

import uy.edu.um.adt.Exceptions.InvalidValue;

public class HashTable<K,V> implements MyHashTable<K,V> {

    private ValueStash<K,V>[] stashes;   //Arreglar
    private int size;

    public HashTable(){
        this.size = 11;
        this.stashes = new ValueStash[size];
    }

    private int hashFunction(K key){
        int hashedKey = 0;
        String stringKey = key.toString();

        for (int i = 0; i < stringKey.length(); i++) {
            char aux = stringKey.charAt(i);
            hashedKey = hashedKey + (int)aux;
        }

        hashedKey = hashedKey % size;
        return hashedKey;
    }


    @Override
    public void put(K key, V value) {
        int index = hashFunction(key);
        ValueStash<K,V> nuevoObjeto = new ValueStash<>();
        nuevoObjeto.setKey(key);
        nuevoObjeto.setValue(value);

        if(stashes[index] != null ){
            while (stashes[index] != null){
                index = (index + 1) % size;
            }
        }

        stashes[index] = nuevoObjeto;
        System.out.println(stashes[index].getValue() + " " + index); //Borrar
    }

    @Override
    public boolean contains(K key) {
        boolean existe = false;
        for (int i = 0; i < stashes.length; i++) {
            if(stashes[i] != null && key.equals(stashes[i].getKey())){
                existe = true;
            }
        }
        return existe;
    }

    @Override
    public void remove(K clave) throws InvalidValue {
        Integer index = hashFunction(clave);
        if(clave.equals(stashes[index].getKey())){
           stashes[index] = null;
        }else{
            index = null;
            for (int i = 0; i < stashes.length; i++) {
                if(stashes[i] != null && clave.equals(stashes[i].getKey())){
                    index = i;
                }
            }
            if (index==null) {
                throw new InvalidValue();
            }else{
                stashes[index] = null;
            }
        }
    }




    public V find(K clave) throws InvalidValue{
        Integer index = hashFunction(clave);
        if(clave.equals(stashes[index].getKey())){
            return stashes[index].getValue();
        }
        else{
            index = null;
            for (int i = 0; i < stashes.length; i++) {
                if(stashes[i] != null && clave.equals(stashes[i].getKey())){
                    index = i;
                }
            }
            if(index == null){
                throw new InvalidValue();
            }else{
                return stashes[index].getValue();
            }
        }
    }

    private void resize(int newSize){
  //Hacer un nuevo array y rehashear todos los elementos.
    }


    public ValueStash[] getStashes() {
        return stashes;
    }

    public void setStashes(ValueStash[] stashes) {
        this.stashes = stashes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
