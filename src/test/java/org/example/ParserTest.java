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
}
