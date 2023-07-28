package org.example;

import java.util.HashMap;

public class StringDB {
    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private int id = 0;


    public int add(String s){
        hashMap.put(id, s);
        return id++;
    }

    public String get(int id){
        if(hashMap.containsKey(id)){
            return hashMap.get(id);
        }
        throw new IllegalArgumentException("No string with id= " + id);
    }
    public HashMap<Integer, String> getAll(){
        if(hashMap.size() == 0){
            throw new IllegalArgumentException("Empty");
        }
        return hashMap;
    }

    public void update(Integer id, String s){
        if(hashMap.replace(id, s) == null){
            throw new IllegalArgumentException("No string with id=" + id);
        }
    }

    public void delete(Integer id, String s){
        if(hashMap.remove(id) == null){
            throw new IllegalArgumentException("No string with id=" + id);
        }
    }
}
