package main.java.Test;

import java.sql.SQLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.Base.BaseTest;
import main.java.pages.Checkout;
import main.java.pages.V5Checkout;
import main.java.utils.ExcelReader;

public class V5CheckoutTestClass extends BaseTest {
	@Test(enabled = true)
	@Parameters({ "url" })
	public void Checkout() throws ClassNotFoundException, SQLException, InterruptedException {
		//ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"/TestData"+"/DVB_Testdata.xlsx");
		V5Checkout V5checkout = new V5Checkout();	
		 Checkout checkout = new Checkout();
		  
		  checkout.URLAuthentication();
		 // V5checkout.SearchProduct(); 
		 // String data=excel.getCellData("Customer_Details", 0, 2);
		  //System.out.println(data);
		 // checkout.hover();
		 // checkout.clickonBed();
		 // checkout.clickonElectronics();
			  V5checkout.clickonProduct(); 
			  V5checkout.clickonAddtoCartbutton();
			  V5checkout.clickonViewcart();
			 
			  V5checkout.clickonPaywithDVBbutton();
			  V5checkout.clickonContinuebutton();
			  V5checkout.enterPostcode();
			  V5checkout.SelectDeliveryOption(); 
			  V5checkout.selectEMI();
			  V5checkout.EnterCustEmailId();
			  V5checkout.enterCustDetails();
			  V5checkout.clickonAgreePay();
			  V5checkout.enterCreditCarddetails();
			  //V5checkout.enter3dSecurepwd();
			  V5checkout.enter3dsecurepopup();
	}
	
	@Test(invocationCount = 1,enabled = false)
	//@Test(enabled = true)
	@Parameters({ "url" })
	public void ExistingCheckout() throws ClassNotFoundException, SQLException, InterruptedException {
		//ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"/TestData"+"/DVB_Testdata.xlsx");
		V5Checkout V5checkout = new V5Checkout();	
		 Checkout checkout = new Checkout();
		  
		  checkout.URLAuthentication();
		 // V5checkout.SearchProduct(); 
		 // String data=excel.getCellData("Customer_Details", 0, 2);
		  //System.out.println(data);
		  checkout.hover();
		  checkout.clickonBed();
			  V5checkout.clickonProduct(); 
			  V5checkout.clickonAddtoCartbutton();
			 // V5checkout.clickonViewcart(); 
			  V5checkout.clickonPaywithDVBbutton();
			  V5checkout.clickonContinuebutton();
			  V5checkout.enterPostcode();
			  V5checkout.SelectDeliveryOption(); 
			  V5checkout.selectEMI();
			  V5checkout.EnterCustEmailId();
			  //V5checkout.enterCustDetails();
			  //V5checkout.clickonAgreePay();
			 // V5checkout.enterCreditCarddetails();
			  //V5checkout.enter3dSecurepwd();
			  //V5checkout.enter3dsecurepopup();
			  V5checkout.ExistingCustomer();
			  V5checkout.enter3dsecurepopup();
	}
}
