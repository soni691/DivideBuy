package main.java.pageObjects;

import   main.java.utils.*;

public interface CRMLoginPageElements {
	String EmailAddress ="//input[@id='email']" ;
	String password ="//input[@id='password']";
	String Signin ="//button[contains(text(),'Login')]";
	String Settings = "//a[@id='navbarSettingsLink']";
	String Logout = "//a[normalize-space()='Logout']";
}
