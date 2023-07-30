package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void validateUpdate(){
        String command = "UPDATE 1 rrt rt";
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validateShouldThrowException(){
        String command = "UPDATE ret";
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(command)
        );

        assertEquals("Illegal command", ex.getMessage());
    }

}
