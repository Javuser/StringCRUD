package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String personJson = "{ \"name\" : \"Nurbakyt\", \"age\" : 22}";


        Person person = new Person();

        {
            try {
                person = objectMapper.readValue(personJson, Person.class);
                System.out.println("person brand : " + person.getName());
                System.out.println("person age : " + person.getAge());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

}
