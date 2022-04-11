package main.java.pageObjects;

public interface AccountPageElements {
	String AccountEmail ="//input[@id='exampleInputEmail1']" ;
	String AccountPassword = "//input[@id='exampleInputPassword1']";
	String AccountLogin ="//button[normalize-space()='Log In']";
	String Accountlogout = "//button[normalize-space()='Log Out']";
	String YourAccount ="//a[normalize-space()='Your Account']";
	String Paybutton ="//button[normalize-space()='Pay']";
	String payinstallments =".row:nth-child(3) span > label";
	String payfirstinstallment =".ng-scope:nth-child(2) > .text-center label";
}
