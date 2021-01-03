package com.holddie;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.junit.Assert;
import org.junit.Test;

public class JsonPathTest {

    public static final String result =
            "{\n"
                    + "    \"store\": {\n"
                    + "        \"book\": [\n"
                    + "            {\n"
                    + "                \"category\": \"reference\",\n"
                    + "                \"author\": \"Nigel Rees\",\n"
                    + "                \"title\": \"Sayings of the Century\",\n"
                    + "                \"price\": 8.95\n"
                    + "            },\n"
                    + "            {\n"
                    + "                \"category\": \"fiction\",\n"
                    + "                \"author\": \"Evelyn Waugh\",\n"
                    + "                \"title\": \"Sword of Honour\",\n"
                    + "                \"price\": 12.99\n"
                    + "            },\n"
                    + "            {\n"
                    + "                \"category\": \"fiction\",\n"
                    + "                \"author\": \"Herman Melville\",\n"
                    + "                \"title\": \"Moby Dick\",\n"
                    + "                \"isbn\": \"0-553-21311-3\",\n"
                    + "                \"price\": 8.99\n"
                    + "            },\n"
                    + "            {\n"
                    + "                \"category\": \"fiction\",\n"
                    + "                \"author\": \"J. R. R. Tolkien\",\n"
                    + "                \"title\": \"The Lord of the Rings\",\n"
                    + "                \"isbn\": \"0-395-19395-8\",\n"
                    + "                \"price\": 22.99\n"
                    + "            }\n"
                    + "        ],\n"
                    + "        \"bicycle\": {\n"
                    + "            \"color\": \"red\",\n"
                    + "            \"price\": 19.95\n"
                    + "        }\n"
                    + "    },\n"
                    + "    \"expensive\": 10\n"
                    + "}";

    @Test
    public void testMethod() {
        String json = result;
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        String author0 = JsonPath.read(document, "$.store.book[0].author");
        String author1 = JsonPath.read(document, "$.store.book[1].author");
        Assert.assertEquals(author0, "Nigel Rees");
        Assert.assertEquals(author1, "Evelyn Waugh");
    }

    @Test
    public void testFluentAPI() {
        ReadContext ctx = JsonPath.parse(result);
        List<String> authorsOfBooksWithISBN = ctx.read("$.store.book[?(@.isbn)].author");
        List<Map<String, Object>> expensiveBooks =
                JsonPath.using(Configuration.defaultConfiguration())
                        .parse(result)
                        .read("$.store.book[?(@.price > 10)]", List.class);
        System.out.println(authorsOfBooksWithISBN);
        System.out.println(expensiveBooks);
    }
}
