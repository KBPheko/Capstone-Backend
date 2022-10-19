package com.service;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.entity.Login;

public class LoginServiceTest {

  @Test
  public void createProfileTest() {
    //throw new RuntimeException("Test not implemented");
	  LoginService lc = new LoginService();
	  Login l1 = new Login();
	  l1.setEmail("admin@outlook.com");
	  l1.setPassword("admin");
	  String result1 = lc.createProfile(l1);
	  assertEquals("Admin role can't be created", result1);
  }

  @Test
  @Ignore
  public void signInTest() {
    throw new RuntimeException("Test not implemented");
  }
}
