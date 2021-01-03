package com.holddie.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		LoginServiceTest.class,
		UserServiceTest.class,
})
public class SuiteTest {

}
