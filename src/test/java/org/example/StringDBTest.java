package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringDBTest {

    @Test
    void testCreate(){
        StringDB stringDB = new StringDB(new HashMap<>());
        stringDB.add("hello");
        HashMap<Integer, String> hashMap = stringDB.getAll();

        assertEquals(1, hashMap.size());
        assertEquals("hello", hashMap.get(1));
    }

    @Test
    void testUpdate(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "tr trt");

        StringDB stringDB = new StringDB(hashMap);
        stringDB.update(1, "hello");
        HashMap<Integer, String> all = stringDB.getAll();

        assertEquals(1, all.size());
        assertEquals("hello", all.get(1));
    }

    @Test
    void testDelete(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "brhj vnejr vren");

        StringDB stringDB = new StringDB(hashMap);
        stringDB.delete(1);

        HashMap<Integer, String> all = stringDB.getAll();
        assertTrue(stringDB.getAll().isEmpty());

    }

    @Test
    void testGet(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "hello");
        StringDB stringDB = new StringDB(hashMap);

        String s = stringDB.get(1);
        assertEquals("hello", s);
    }
}
