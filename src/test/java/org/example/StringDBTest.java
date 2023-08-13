package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringDBTest {

    @Test
    void testCreate(){
        //given
        Person person = new Person();
        person.setName("Nurbakyt");
        person.setAge(22);
        StringDB stringDB = new StringDB(new HashMap<>());

        //when
        stringDB.add(person);

        //then
        HashMap<Integer, Person> hashMap = stringDB.getAll();

        assertEquals(1, hashMap.size());
        assertEquals(person.getAge(), hashMap.get(1).getAge());
        assertEquals(person.getName(), hashMap.get(1).getName());
    }

    @Test
    void testUpdate(){
        Person person = new Person();
        person.setAge(24);
        person.setName("Anzor");
        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(4, person);

        StringDB stringDB = new StringDB(hashMap);
        stringDB.update(4, person);
        HashMap<Integer, Person> all = stringDB.getAll();

        assertEquals(1, all.size());
        assertEquals(person.getAge(), all.get(1).getAge());
        assertEquals(person.getName(), all.get(1).getName());
    }

    @Test
    void testDelete(){
        Person person = new Person();
        person.setAge(22);
        person.setName("Nurbakyt");
        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(1, person);

        StringDB stringDB = new StringDB(hashMap);
        stringDB.delete(1);

        HashMap<Integer, Person> all = stringDB.getAll();
        assertTrue(stringDB.getAll().isEmpty());

    }

    @Test
    void testGet(){
        //given
        Person person = new Person();
        person.setAge(30);
        person.setName("Anzor");

        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(1, person);

        StringDB stringDB = new StringDB(hashMap);
        HashMap<Integer, Person> all = stringDB.getAll();

        assertEquals(person, all.get(1));
    }
}
