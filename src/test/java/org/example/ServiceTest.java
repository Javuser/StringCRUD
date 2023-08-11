package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    @Test
    void testCreate(){

        StringDB stringDB = new StringDB(new HashMap<>());
        Service service = new Service(stringDB);
        Command command = new Command(CommandType.CREATE, "strt ttr");

        service.execute(command);
        HashMap<Integer, String> all = stringDB.getAll();

        assertEquals(1, all.size());
        assertEquals("strt ttr", all.get(1));
    }

    @Test
    void testUpdate(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "hbvd");

        StringDB stringDB = new StringDB(hashMap);
        Service service = new Service(stringDB);
        Command command = new Command(CommandType.UPDATE, 1, "hello world");


        service.execute(command);
        HashMap<Integer, String> all = stringDB.getAll();

        assertEquals(1, all.size());
        assertEquals("hello world", all.get(1));

    }

    @Test
    void testDelete(){
        StringDB stringDB = new StringDB(new HashMap<>());
        Service service = new Service(stringDB);
        Command command = new Command(CommandType.DELETE, 1);
        service.execute(command);
        HashMap<Integer, String> all = stringDB.getAll();

        assertTrue(stringDB.getAll().isEmpty());

    }
}
