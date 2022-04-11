package main.java.pageObjects;

import   main.java.utils.*;

public interface CRMLoginPageElements {
	String EmailAddress ="//input[@id='email']" ;
	String password ="//input[@id='password']";
	String Signin ="//button[contains(text(),'Login')]";
	String Settings = "//a[@id='userDropdown']";
	String Logout = "//button[normalize-space()='Logout']";
	String CRMCustomers ="//span[normalize-space()='Customers']";
	String AllCustomers = "//a[@href='https://crm.dividebuy-qa.info/customers']";
	String InputCustomer ="//input[@placeholder='Search']";
	String CustomerSearch = "//i[@class='fa fa-search']";
	String CustEdit = "//i[@class='fa fa-pencil']";
	String Newpassword = "//input[@id='password']";
	String ConfirmPassword ="//input[@id='password-confirm']";
	String UpdatePassword = "//button[normalize-space()='Update Password']";
}
