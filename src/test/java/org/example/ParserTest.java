package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    private final Validator validator = new Validator();
    private final Parser parser = new Parser(validator);


    @Test
    void parseUpdateTest(){

        String command = "UPDATE 1 rr rtt";
        Command result = parser.parse(command);

        assertEquals(CommandType.UPDATE, result.getCommandType());
        assertEquals(1, result.getId());
        assertEquals("rr rtt", result.getValue());

    }


    @Test
    void parseCreateTest(){
        String command = "CREATE rrr tt yyy";
        Command result2 = parser.parse(command);

        assertEquals(CommandType.CREATE, result2.getCommandType());
        assertEquals(null, result2.getId());
        assertEquals("rrr tt yyy", result2.getValue());

    }

    @Test
    void parseDeleteTest(){
        String command = "DELETE 1";
        Command result3 = parser.parse(command);

        assertEquals(CommandType.DELETE, result3.getCommandType());
        assertEquals(1, result3.getId());
        assertEquals(null, result3.getValue());
    }

    @Test
    void parseGetTest(){
        String command = "GET 1";
        Command result = parser.parse(command);

        assertEquals(CommandType.GET, result.getCommandType());
        assertEquals(1, result.getId());
        assertEquals(null, result.getValue());

    }
}
