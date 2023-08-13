package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Loader {
    String path = "/Users/nurbakyt/Downloads/StringCRUD/src/main/java/person.properties";
    File file = new File(path);


    ObjectMapper objectMapper = new ObjectMapper();

    public void saveToFile(Map<Integer, Person> map) {
        try (FileOutputStream outputStream = new FileOutputStream(new File(path))) {
            Properties properties = new Properties();
            for (Map.Entry<Integer, Person> entry : map.entrySet()) {
                properties.put(entry.getKey().toString(), objectMapper.writeValueAsString(entry.getValue()));
            }
            properties.store(outputStream, null);
        }catch (Exception e){
            throw new RuntimeException("Error " + e.getMessage());
        }
    }


    public Map<Integer, Person> loadFromFile() {
        try(FileInputStream inputStream = new FileInputStream(new File(path))) {
            Map<Integer, Person> map = new HashMap<>();

            Properties properties = new Properties();
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                map.put(Integer.parseInt(key), objectMapper.readValue(properties.get(key).toString(),
                                Person.class));
            }
            return map;
        }catch (Exception e){
            throw new RuntimeException("Error " + e.getMessage()) ;
        }

    }

}
