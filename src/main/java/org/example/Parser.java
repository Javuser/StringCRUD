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

    //GET 4
    //commandType - GET
    //id - 4
    private Command parseGet(String s){
        String[] str = s.split(" ");
        CommandType commandType = CommandType.GET;
        Integer id = Integer.parseInt(str[1]);
        String value = null;

        return new Command(commandType, id, value);
    }

    //CREATE rrr ttt yy
    private Command parseCreate(String s){
        String[] str = s.split(" ");
        String toReplace = String.format("%s ", str[0]);
        CommandType commandType = CommandType.CREATE;
        String value = s.replace(toReplace, "");
        return new Command(commandType, value);
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
    //DELETE 1
    private Command parseDelete(String s){
        String[] str = s.split(" ");
        CommandType commandType = CommandType.DELETE;
        Integer id = Integer.parseInt(str[1]);
        return new Command(commandType, id);
    }
}
