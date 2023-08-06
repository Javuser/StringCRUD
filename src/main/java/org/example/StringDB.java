package org.example;

import java.util.HashMap;

public class StringDB {
    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private int id2 = 0;


    public int incrementId(){
        return id2++;
    }
    public int stringId(){
        return id2;
    }
    public int add(String s){
        hashMap.put(stringId(), s);
        return incrementId();
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
        hashMap.replace(id, s);
        if(hashMap.replace(id, s) == null){
            throw new IllegalArgumentException("No string with id=" + id);
        }
    }

    public void delete(Integer id){
        hashMap.remove(id);
//        if(hashMap.remove(id) == null){
//            throw new IllegalArgumentException("No string with id=" + id);
//        }
    }
}
