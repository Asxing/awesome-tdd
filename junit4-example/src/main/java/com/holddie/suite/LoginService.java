package com.holddie.suite;

public class LoginService {
	public boolean authenticate(String userName, String password){
		if("demo".equals(userName) && "demo".equals(password)){
			return true;
		}
		return false;
	}
}
