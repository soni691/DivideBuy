package main.java.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import main.java.Base.BaseTest;
import main.java.pageObjects.CheckoutPageElements;
import main.java.utils.ElelmentFetch;

public class Checkout extends BaseTest{
	ElelmentFetch elementFtech = new ElelmentFetch();
	public String otp;
	
	public void URLAuthentication() {
		driver.get("https://dbuytest:O6jdmP$sqma68Ccd@moduleinstalledmagento1.dbuytest.info/");
	}

	public void hover() {
	Actions action = new Actions(driver);	
	WebElement TxtBoxContent = driver.findElement(By.xpath("//a[normalize-space()='Home & Decor']"));
	//Performing the mouse hover action on the target element.
	action.moveToElement(TxtBoxContent).perform();
	}
	
	public void clickonBed() {
		elementFtech.getWebElement("XPATH", CheckoutPageElements.RetailerBedBathMenu).click();
	}
	
	public void clickonProduct() {
		elementFtech.getWebElement("XPATH", CheckoutPageElements.RetailertestProduct).click();
	}
	public void clickonAddtoCartbutton() {
		elementFtech.getWebElement("XPATH", CheckoutPageElements.RetailerprodetailAddtocart).click();
	}
	public void clickonPaywithDVBbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element= driver.findElement(By.xpath(CheckoutPageElements.PaywithDVBbutton));
		js.executeScript("arguments[0].scrollIntoView();",element);
		elementFtech.getWebElement("XPATH", CheckoutPageElements.PaywithDVBbutton).click();
	}
	public void clickonContinuebutton() {
		BaseTest.logger.info("Clicking on Continue Button");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.CartContinueasGuestbutton).click();
	}
	public void enterPostcode() {
		BaseTest.logger.info("Entering Postcode");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Postcode).sendKeys("SK102LF");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.ViewOptions).click();
	}
	public void SelectDeliveryOption() {
		BaseTest.logger.info("Clicking on Free Shipping option");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.FreeShipping).click();
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Checkout).click();
	}
	public void selectEMI() {
		BaseTest.logger.info("Selecting 3 months EMI option");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.EMIOptiondropdown).click();
		elementFtech.getWebElement("XPATH", CheckoutPageElements.ThreeMonthEmi).click();
	}
	public void EnterCustEmailId() throws InterruptedException {
		BaseTest.logger.info("Entering Customer email");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.CustomerEmail).sendKeys("hawk13.eye13@yopmail.com");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Next).click();
		Thread.sleep(3000);
	}
	public void getOTP() throws ClassNotFoundException, SQLException {
		String dbUrl = "jdbc:mysql://dividebuysandbox.co.uk:3306/dbsbV4_laravel";
		String dbusername ="sumit-dvbsanddb";
		String dbpassword="tOons*bnRMu14i8p";
		String query = "SELECT * FROM otp_log where contact_number = 07458303401 order by id desc limit 1";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl,dbusername,dbpassword);
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery(query);	
		while (rs.next()){
    		otp = rs.getString(4);								        
            //String myAge = rs.getString(2);					                               
            System. out.println("otp is + "  +otp);
		}
		con.close();
	}
	public void enterCustDetails() throws ClassNotFoundException, SQLException, InterruptedException {
		BaseTest.logger.info("Entering Customer Details");
		
		//driver.switchTo().frame(0);
		//elementFtech.getWebElement("XPATH", CheckoutPageElements.iframeclosebutton).click();
		//driver.switchTo().defaultContent();
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Title).click();
		elementFtech.getWebElement("XPATH", CheckoutPageElements.MrTitle).click();
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Firtsname).sendKeys("Catheryn");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Lastname).sendKeys("Somerfield");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.BirthDate).sendKeys("06");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.BirthMonth).sendKeys("09");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.BirthYear).sendKeys("1980");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Income).sendKeys("999999");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.MobileNumber).sendKeys("07458303401");
		elementFtech.getWebElement("XPATH", CheckoutPageElements.MobileVerify).click();
		getOTP();
		elementFtech.getWebElement("XPATH", CheckoutPageElements.EnteryOtp).sendKeys(otp);
		elementFtech.getWebElement("XPATH", CheckoutPageElements.VerifyOtP).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element= driver.findElement(By.xpath(CheckoutPageElements.Next));
		js.executeScript("arguments[0].scrollIntoView();",element);
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Next).click();
		Thread.sleep(10000);
	}
	
	
		
	 // closing DB Connection		
	
	
}