package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    @Test
    void testCreate(){
        //given
        StringDB stringDB = new StringDB(new HashMap<>());
        Service service = new Service(stringDB);
        Person person = new Person();
        person.setAge(22);
        person.setName("HHH");
        Command command = new Command(CommandType.CREATE, person);

        //when
        service.execute(command);

        //then
        HashMap<Integer, Person> all = stringDB.getAll();

        assertEquals(1, all.size());
        assertEquals(person.getName(), all.get(1).getName());
        assertEquals(person.getAge(), all.get(1).getAge());
    }

    @Test
    void testUpdate(){
        //given
        Person person = new Person();
        person.setAge(22);
        person.setName("HHH");

        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(1, person);

        StringDB stringDB = new StringDB(hashMap);
        Service service = new Service(stringDB);

        Person personToUpdate = new Person();
        personToUpdate.setAge(23);
        personToUpdate.setName("UUU");

        Command command = new Command(CommandType.UPDATE, 1, personToUpdate);

        //when
        service.execute(command);

        //then
        HashMap<Integer, Person> all = stringDB.getAll();

        assertEquals(1, all.size());
        assertEquals(personToUpdate.getName(), all.get(1).getName());
        assertEquals(personToUpdate.getAge(), all.get(1).getAge());

    }

    @Test
    void testDelete(){
        //given
        StringDB stringDB = new StringDB(new HashMap<>());
        Service service = new Service(stringDB);
        Command command = new Command(CommandType.DELETE, 1);

        //when
        service.execute(command);

        //then
        HashMap<Integer, Person> all = stringDB.getAll();

        assertTrue(stringDB.getAll().isEmpty());
    }

    @Test
    void testGetById(){
        //given
        Person person = new Person();
        person.setName("HHH");
        person.setAge(30);

        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(5, person);

        StringDB stringDB = new StringDB(hashMap);
        Service service = new Service(stringDB);
        Command command = new Command(CommandType.GET, 5);

        //when
        service.execute(command);

        //then
        HashMap<Integer, Person> all = stringDB.getAll();
        assertEquals(1, all.size());
        assertEquals(hashMap.get(5), all.get(command.getId()));
    }

}
