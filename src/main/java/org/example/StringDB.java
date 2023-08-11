package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StringDB {
    private final Map<Integer, String> hashMap;
    private AtomicInteger id;

    public StringDB(Map<Integer, String> hashMap) {
        this.hashMap = new HashMap<>(hashMap);
        //todo вычислить айди

//        Integer maxId = hashMap.keySet()
        Integer maxId = hashMap.keySet().stream().max(Integer::compareTo).orElse(0);
        id = new AtomicInteger(maxId);
    }


    public StringDB() {
        this.hashMap = new HashMap<>();
    }

    public Integer add(String s){
        id.incrementAndGet();
        hashMap.put(id.get(), s);
        return id.get();
    }

    public String get(Integer id){
        return hashMap.get(id);
    }

    public HashMap<Integer, String> getAll(){
        return new HashMap<>(hashMap);
    }

    public void update(Integer id, String s){
        hashMap.replace(id, s);
    }

    public void delete(Integer id){
        hashMap.remove(id);
    }
}
