package com.holddie;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.RegularExpressionValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    public void testExample1() throws JSONException {
        String actual = "{id:123, name:\"John\"}";
        JSONAssert.assertEquals("{id:123,name:\"John\"}", actual, JSONCompareMode.LENIENT);
    }

    @Test
    public void testEx2() throws JSONException {
        String actual = "{id:123,name:\"John\"}";
        JSONAssert.assertNotEquals("{name:\"John\"}", actual, JSONCompareMode.STRICT);
    }

    @Test
    public void testEx3() throws JSONException {
        String actual = "{id:123,name:\"John\",zip:\"33025\"}";
        JSONAssert.assertEquals("{id:123,name:\"John\"}", actual, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{id:123,name:\"John\"}", actual, false);

        actual = "{id:123,name:\"John\"}";
        JSONAssert.assertNotEquals("{name:\"John\"}", actual, JSONCompareMode.STRICT);
        JSONAssert.assertNotEquals("{name:\"John\"}", actual, true);
    }

    @Test
    public void testEx4() throws JSONException {
        String actual = "{id:123,name:\"John\"}";
        String failureMessage = "Only one field is expected: name";
        try {
            JSONAssert.assertEquals(
                    failureMessage, "{name:\"John\"}", actual, JSONCompareMode.STRICT);
        } catch (AssertionError ae) {
            assertThat(ae.getMessage()).containsIgnoringCase(failureMessage);
        }
    }

    @Test
    public void testEx5() throws JSONException {
        JSONAssert.assertEquals(
                "{entry:{id:x}}",
                "{entry:{id:1, id:2}}",
                new CustomComparator(
                        JSONCompareMode.STRICT,
                        new Customization(
                                "entry.id", new RegularExpressionValueMatcher<Object>("\\d"))));

        JSONAssert.assertNotEquals(
                "{entry:{id:x}}",
                "{entry:{id:1, id:as}}",
                new CustomComparator(
                        JSONCompareMode.STRICT,
                        new Customization(
                                "entry.id", new RegularExpressionValueMatcher<Object>("\\d"))));
    }
}
