package org.example;

public class Parser {
    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public Command parse(String s){
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
        return null;
    }

    private Command parseCreate(String s){
        return null;
    }

    private Command parseUpdate(String s){
        return null;
    }

    private Command parseDelete(String s){
        return null;
    }
}
