package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void validateUpdate(){
        String command = "UPDATE 1 { \"name\" : \"Nurbakyt\", \"age\" : 22}";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateShouldThrowException(){
        String command = "UPDATE 1 \"name\" : \"Nurbakyt\", \"age\" : 22}";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Invalid Person json", ex.getMessage());
    }

    @Test
    void validateCreate(){
        String command = "CREATE { \"name\" : \"Nurbakyt\", \"age\" : 22}";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateCreateShouldThrowException(){
        String command = "CREATE { \"name\" : \"Nurbakyt\" \"age\" : 22}";
        Exception ex = assertThrows(
                IllegalArgumentException.class, () -> validator.validate(command)
        );
        assertEquals("Invalid Person json", ex.getMessage());
    }

    @Test
    void validateDelete(){
        String command = "DELETE 1";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateDeleteShouldThrowException(){
        String command = "DELETE rsg vrsbv rsb";
        Exception ex = assertThrows(
                IllegalArgumentException.class, () -> validator.validate(command)
        );
        assertEquals("Illegal command", ex.getMessage());
    }

    @Test
    void validateGet(){
        String command1 = "GET";
        assertDoesNotThrow(() -> validator.validate(command1));
        String command2 = "GET 1";
        assertDoesNotThrow(() -> validator.validate(command2));
    }

    @Test
    void validateGetShouldThrowException(){
        String command = "GET sg rgd";
        Exception ex = assertThrows(
                IllegalArgumentException.class, () -> validator.validate(command)
        );
        assertEquals("Illegal command", ex.getMessage());
    }
}
