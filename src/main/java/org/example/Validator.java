package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Validator {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void validate(String s){
        String[] str = s.split(" ");
        switch (str[0]){
            case "GET" -> validateGet(s);
            case "CREATE" -> validateCreate(s);
            case "UPDATE" -> validateUpdate(s);
            case "DELETE" -> validateDelete(s);

            default -> throw new RuntimeException("Unknown command " + str[0]);
        }
    }

    private void validateGet(String s){
        String[] str = s.split(" ");
        if(!str[0].equals("GET")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length > 2){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length > 1 && isNotInt(str[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    private void validateCreate(String s) {
        String[] str = s.split(" ");
        if (!str[0].equals("CREATE")) {
            throw new IllegalArgumentException("Illegal command");
        }
        String toReplace = String.format("%s ", str[0]);
        String value = s.replace(toReplace, "");
        try{
            objectMapper.readValue(value, Person.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid Person json");
        }
    }

    private void validateUpdate(String s){
        String[] str = s.split(" ");
        if(!str[0].equals("UPDATE")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(isNotInt(str[1])){
            throw new IllegalArgumentException("Illegal command");
        }
        String toReplace = String.format("%s %s ", str[0], str[1]);
        String value = s.replace(toReplace, "");
        try{
            objectMapper.readValue(value, Person.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid Person json");
        }
    }

    private void validateDelete(String s){
        String[] str = s.split(" ");
        if(!str[0].equals("DELETE")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length != 2){
            throw new IllegalArgumentException("Illegal command");
        }
        if(isNotInt(str[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    private boolean isNotInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
