package com.holddie.exception;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.startsWith;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExy {
    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0); // execution will never get past this line
    }

    @Test
    public void shouldThrow() throws ClassNotFoundException {
        TestThing testThing = new TestThing();
        thrown.expect(ClassNotFoundException.class);
        thrown.expectMessage(startsWith("some Message"));
        testThing.chuck();
    }

    private class TestThing {
        public void chuck() throws ClassNotFoundException {
            throw new ClassNotFoundException("some Message");
        }
    }
}
