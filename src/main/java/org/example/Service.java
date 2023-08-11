package org.example;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {

    private final StringDB stringDB;

    public Service(StringDB stringDB) {
        this.stringDB = stringDB;
    }

    public void execute(Command command){
        switch (command.getCommandType()) {
            case GET -> get(command);
            case CREATE -> add(command);
            case UPDATE -> update(command);
            case DELETE -> delete(command);
            case GET_ALL -> getAll();
        }

    }

    public HashMap<Integer, String> getHashMap(){
        return stringDB.getAll();
    }
    private void get(Command command){
        String s = stringDB.get(command.getId());
        System.out.println(s);
    }

    private void add(Command command){
        Integer id = stringDB.add(command.getValue());
        System.out.println("saved to hashmap with id = " + id);
    }
    private void update(Command command){
        stringDB.update(command.getId(), command.getValue());
        System.out.println("updated in hashmap with id = " + command.getId());
    }
    private void delete(Command command){
        stringDB.delete(command.getId());
        System.out.println("deleted from hashmap with id = " + command.getId());
    }
    private void getAll(){
        getHashMap().forEach((key, value) -> System.out.println(String.format("%s: %s", key, value)));
    }
}
