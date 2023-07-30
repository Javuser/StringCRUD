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
    // update 1 rrr ttt yyy
    // commandType - update
    // id - 1
    // value - rrr ttt yyy
    private Command parseUpdate(String s){
        String[] str = s.split(" ");
        String toReplace = String.format("%s %s ", str[0], str[1]);
        CommandType commandType = CommandType.UPDATE;
        Integer id = Integer.parseInt(str[1]);
        String value = s.replace(toReplace, "");

        return new Command(commandType, id, value);
    }

    private Command parseDelete(String s){
       return null;
    }
}
