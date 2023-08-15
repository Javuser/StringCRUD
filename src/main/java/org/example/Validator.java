package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Validator {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void validate(String command){
        String[] commandArgs = command.split(" ");
        switch (commandArgs[0]){
            case "GET" -> validateGet(command);
            case "CREATE" -> validateCreate(command);
            case "UPDATE" -> validateUpdate(command);
            case "DELETE" -> validateDelete(command);

            default -> throw new RuntimeException("Unknown command " + commandArgs[0]);
        }
    }

    private void validateGet(String command){
        String[] commandArgs = command.split(" ");
        if(!commandArgs[0].equals("GET")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(commandArgs.length > 2){
            throw new IllegalArgumentException("Illegal command");
        }
        if(commandArgs.length > 1 && isNotInt(commandArgs[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    private void validateCreate(String command) {
        String[] commandArgs = command.split(" ");
        if (!commandArgs[0].equals("CREATE")) {
            throw new IllegalArgumentException("Illegal command");
        }
        String toReplace = String.format("%s ", commandArgs[0]);
        String value = command.replace(toReplace, "");
        try{
            objectMapper.readValue(value, Person.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid Person json");
        }
    }

    private void validateUpdate(String command){
        String[] commandArgs = command.split(" ");
        if(!commandArgs[0].equals("UPDATE")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(isNotInt(commandArgs[1])){
            throw new IllegalArgumentException("Illegal command");
        }
        String toReplace = String.format("%s %s ", commandArgs[0], commandArgs[1]);
        String value = command.replace(toReplace, "");
        try{
            objectMapper.readValue(value, Person.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid Person json");
        }
    }

    private void validateDelete(String command){
        String[] commandArgs = command.split(" ");
        if(!commandArgs[0].equals("DELETE")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(commandArgs.length != 2){
            throw new IllegalArgumentException("Illegal command");
        }
        if(isNotInt(commandArgs[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    private boolean isNotInt(String command) {
        try {
            Integer.parseInt(command);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
