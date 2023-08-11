package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Loader {
    String path = "/Users/nurbakyt/Downloads/StringCRUD/src/main/java/map.properties";
    File file = new File(path);


    public void saveToFile(Map<Integer, String> map) {
        try (FileOutputStream outputStream = new FileOutputStream(new File(path))) {
            //Map<String, String> stringMap = new HashMap<>();
            Properties properties = new Properties();

            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                properties.put(entry.getKey().toString(), entry.getValue());
            }
            properties.store(outputStream, null);
        }catch (Exception e){
            throw new RuntimeException("Error " + e.getMessage());
        }
    }


    public Map<Integer, String> loadFromFile() {
        try(FileInputStream inputStream = new FileInputStream(new File(path))) {
            Map<Integer, String> stringMap = new HashMap<>();

            Properties properties = new Properties();
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                stringMap.put(Integer.parseInt(key), properties.get(key).toString());
            }
            return stringMap;
        }catch (Exception e){
            throw new RuntimeException("Error " + e.getMessage()) ;
        }

    }

}
