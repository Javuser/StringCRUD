package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StringDB {
    private final Map<Integer, Person> hashMap;
    private final AtomicInteger id;

    public StringDB(Map<Integer, Person> hashMap) {
        this.hashMap = new HashMap<>(hashMap);
        Integer maxId = hashMap.keySet().stream().max(Integer::compareTo).orElse(0);
        this.id = new AtomicInteger(maxId);
    }

    public Integer add(Person person){
        id.incrementAndGet();
        hashMap.put(id.get(), person);
        return id.get();
    }

    public Person get(Integer id){
        return hashMap.get(id);
    }

    public HashMap<Integer, Person> getAll(){
        return new HashMap<>(hashMap);
    }

    public void update(Integer id, Person person){
        hashMap.replace(id, person);
    }

    public void delete(Integer id){
        hashMap.remove(id);
    }
}
