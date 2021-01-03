package com.holddie.timeout;

import org.junit.Ignore;
import org.junit.Test;

public class TimeoutTest {
    //This test will always failed :)
    @Ignore
    @Test(expected = Test.None.class, timeout = 1000)
    public void infinity() {
        while (true) ;
    }

    //This test can't run more than 5 seconds, else failed
    @Test(timeout = 5000)
    public void testSlowMethod() {
        //...
    }
}
