package org.example;

import java.util.HashMap;

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
        }

    }

    private HashMap<Integer, String> getHashMap(){
        return getHashMap();
    }
    private void get(Command command){
        String s = stringDB.get(command.getId());
        System.out.println(s);
    }

    private void add(Command command){
        Integer id = stringDB.add(command.getValue());
    }
    private void update(Command command){
        stringDB.update(command.getId(), command.getValue());
    }
    private void delete(Command command){
        stringDB.delete(command.getId());
    }
}
