package main.java.pageObjects;

import   main.java.utils.*;

public interface CRMLoginPageElements {
	String EmailAddress ="//input[@id='email']" ;
	String password ="//input[@id='password']";
	String Signin ="//button[contains(text(),'Login')]";
	String Settings = "//a[@id='userDropdown']";
	String Logout = "//button[normalize-space()='Logout']";
}
