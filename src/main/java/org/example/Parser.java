package org.example;

import java.util.HashMap;

public class Parser {
    private final Validator validator;
    private final StringDB stringDB;

    HashMap<Integer, String> hashMap = new HashMap<>();
    //int id = 0;

    public Parser(Validator validator, StringDB stringDB) {
        this.validator = validator;
        this.stringDB = stringDB;
    }


    public Command parse(String s){
        validator.validate(s);
        String[] str = s.split(" ");

        String t;
        switch (str[0]){
            case "GET" -> {
                return parseGet(s);
            }
            case "CREATE" -> {
       //         t = String.valueOf(parseCreate(s));
               // System.out.println("String saved with id=" + stringDB.add(s));
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
        //System.out.println(stringDB.get(s));
        return null;
    }

    private Command parseCreate(String s){


     //   hashMap.put(id, s);
        System.out.println("String saved with id=" + stringDB.add(s));

        return null;//
    }

    private Command parseUpdate(String s){
        return null;
    }

    private Command parseDelete(String s){
        return null;
    }
}
