package com.holddie.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionExample2 {

    @Test
    void test_exception_custom() {
        Exception exception = assertThrows(NameNotFoundException.class, () -> findByName("mkyong"));
        assertTrue(exception.getMessage().contains("not found"));
    }

    String findByName(String name) throws NameNotFoundException {
        throw new NameNotFoundException(name + " not found!");
    }
}
