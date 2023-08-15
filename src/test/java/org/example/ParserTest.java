package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {
    private final Validator validator = new Validator();
    private final Parser parser = new Parser(validator);


    @Test
    void parseUpdateTest() throws JsonProcessingException {

        String command = "UPDATE 1 { \"name\" : \"Nurbakyt\", \"age\" : 22}";
        Command result = parser.parse(command);

        assertEquals(CommandType.UPDATE, result.getCommandType());
        Person person = result.getPerson();

        assertEquals(1, result.getId());
        assertEquals("Nurbakyt", person.getName());
        assertEquals(22, person.getAge());
    }


    @Test
    void parseCreateTest() throws JsonProcessingException {
        String command = "CREATE { \"name\" : \"Nurbakyt\", \"age\" : 22}";
        Command result = parser.parse(command);

        Person person = result.getPerson();
        assertEquals(CommandType.CREATE, result.getCommandType());
        assertNull(result.getId());
        assertEquals("Nurbakyt", person.getName());
        assertEquals(22, person.getAge());
    }

    @Test
    void parseDeleteTest() throws JsonProcessingException {
        String command = "DELETE 1";
        Command result = parser.parse(command);

        assertEquals(CommandType.DELETE, result.getCommandType());
        assertEquals(1, result.getId());
        assertNull(result.getPerson());
    }

    @Test
    void parseGetTest() throws JsonProcessingException {
        String command = "GET 1";
        Command result = parser.parse(command);

        assertEquals(CommandType.GET, result.getCommandType());
        assertEquals(1, result.getId());
        assertNull(result.getPerson());

    }
}
