package main.java.Test;

import java.sql.SQLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.Base.BaseTest;
import main.java.pages.Checkout;

public class CheckoutTestClass extends BaseTest {
	@Test(enabled = true)
	@Parameters({ "url" })
	public void Checkout() throws ClassNotFoundException, SQLException, InterruptedException {
		
		  Checkout checkout = new Checkout();	  
		  checkout.URLAuthentication(); 
		  checkout.hover();
		  checkout.clickonBed();	  
		  checkout.clickonProduct(); 
		  checkout.clickonAddtoCartbutton();
		  checkout.clickonPaywithDVBbutton();
		  checkout.clickonContinuebutton();
		  checkout.enterPostcode();
		  checkout.SelectDeliveryOption();
		  checkout.selectEMI();
		  checkout.EnterCustEmailId();
		  checkout.enterCustDetails();	
		  checkout.V5getOTP();
	}
}
