package com.holddie;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    @Test
    public void testSimple() throws JSONException {
        String result = "{id:1,name:\"Juergen\"}";
        JSONAssert.assertEquals("{id:1}", result, false); // Pass
        JSONAssert.assertEquals("{id:1}", result, true); // Fail
    }

    @Test
    public void testSimple1() throws JSONException {
        String result = "{id:1,name:\"Juergen\"}";
        JSONAssert.assertEquals("{name:\"Juergen\",id:1}", result, true); // Pass
    }

    @Test
    public void testList() throws JSONException {
        String result = "[1,2,3,4,5]";
        JSONAssert.assertEquals("[1,2,3,4,5]", result, false); // Pass
        JSONAssert.assertEquals("[1,2,3]", result, false); // Fail
        JSONAssert.assertEquals("[1,2,3,4,5,6]", result, false); // Fail
    }
}
