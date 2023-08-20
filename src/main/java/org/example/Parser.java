package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {

    private final Validator validator;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public Parser(Validator validator) {
        this.validator = validator;
    }

    public Command parse(String s) throws JsonProcessingException {

        validator.validate(s);
        String[] str = s.split(" ");

        switch (str[0]){
            case "GET" -> {
                return parseGet(s);
            }
            case "CREATE" -> {
               return parseCreate(s);
            }

            case "UPDATE" -> {
                return parseUpdate(s);
            }

            case "DELETE" -> {
                return parseDelete(s);
            }
        }
        return null;
    }

    private Command parseGet(String s){
        String[] str = s.split(" ");
        if(str.length == 1){
            return new Command(CommandType.GET_ALL);
        }else {
            Integer id = Integer.parseInt(str[1]);
            return new Command(CommandType.GET, id);
        }
    }

    private Command parseCreate(String s) throws JsonProcessingException {
        String[] str = s.split(" ");
        String toReplace = String.format("%s ", str[0]);
        CommandType commandType = CommandType.CREATE;
        String value = s.replace(toReplace, "");
        Person person = objectMapper.readValue(value, Person.class);
        return new Command(commandType, person);
    }

    //UPDATE 6 {"name" : "Nurbakyt", "age": 22}
    private Command parseUpdate(String s) throws JsonProcessingException {
        String[] str = s.split(" ");//str[0]
        String toReplace = String.format("%s %s ", str[0], str[1]);
        CommandType commandType = CommandType.UPDATE;
        Integer id = Integer.parseInt(str[1]);
        String value = s.replace(toReplace, "");
        //{"name" : "Nurbakyt", "age": 22}
        Person person = objectMapper.readValue(value, Person.class);
        return new Command(commandType, id, person);
    }

    private Command parseDelete(String s){
        String[] str = s.split(" ");
        CommandType commandType = CommandType.DELETE;
        Integer id = Integer.parseInt(str[1]);
        return new Command(commandType, id);
    }
}
