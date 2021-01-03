package com.holddie.suite;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {
	@Test
	public void authenticateSuccessTest(){
		LoginService login = new LoginService();
		assertTrue("authenticate failed", login.authenticate("demo", "demo"));
	}
	
	@Test
	public void authenticateFailTest(){
		LoginService login = new LoginService();
		assertFalse("authenticate failed", login.authenticate("demo1", "demo"));
	}
}
