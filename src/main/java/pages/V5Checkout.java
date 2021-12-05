package main.java.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import main.java.Base.BaseTest;
import main.java.pageObjects.CheckoutPageElements;
import main.java.pageObjects.V5CheckoutPageElements;
import main.java.utils.ElelmentFetch;
import main.java.utils.ExcelReader;

public class V5Checkout extends BaseTest {
	ElelmentFetch elementFtech = new ElelmentFetch();
	ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "/TestData" + "/DVB_Testdata.xlsx");
	public String otp;

	public void SearchProduct() {
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.RetailerProductSearchBar).sendKeys("Testing Product");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.RetailerProductSearchBar).sendKeys(Keys.ENTER);
	}

	public void clickonProduct() {
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.TestProduct).click();
	}

	public void clickonAddtoCartbutton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(V5CheckoutPageElements.addtoCart));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.addtoCart).click();
		Thread.sleep(3000);
	}

	public void clickonViewcart() {
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.ViewCart).click();
	}

	public void clickonPaywithDVBbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(V5CheckoutPageElements.paywithDividebuy));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.paywithDividebuy).click();
	}

	public void clickonContinuebutton() throws InterruptedException {
		BaseTest.logger.info("Clicking on Continue Button");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.CartContinueasGuestbutton).click();
		Thread.sleep(2000);
	}

	public void enterPostcode() {
		BaseTest.logger.info("Entering Postcode");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Postcode).sendKeys("SK102LF");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.ViewOptions).click();
	}

	public void SelectDeliveryOption() {
		BaseTest.logger.info("Clicking on Free Shipping option");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.FreeShipping).click();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Checkout).click();
	}

	public void selectEMI() {
		BaseTest.logger.info("Selecting 3 months EMI option");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.EMIOptiondropdown).click();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.ThreeMonthEmi).click();
	}

	public void EnterCustEmailId() throws InterruptedException {
		BaseTest.logger.info("Entering Customer email");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.CustomerEmail).sendKeys(excelReader.getCellData("Customer_Details", 7, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Next).click();
		Thread.sleep(3000);
	}

	public void getOTP() throws ClassNotFoundException, SQLException {
		String dbUrl = "jdbc:mysql://v5-qa-database.c1sghtuv3sp4.eu-west-2.rds.amazonaws.com:3306/customers";
		String dbusername = "dividebuy";
		String dbpassword = "FBkyQNmFUnJnmHMhe3vc0z58m9KsSvS0MBxX8Q4ko";
		String DBNumber= excelReader.getCellData("Customer_Details", 6, 2);
		String query = "SELECT * FROM otp_logs where contact_number = ("+DBNumber+") order by id desc limit 1";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, dbusername, dbpassword);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			otp = rs.getString(5);
			// String myAge = rs.getString(2);
			System.out.println("otp is + " + otp);
		}
		con.close();
	}

	public void enterCustDetails() throws ClassNotFoundException, SQLException, InterruptedException {
		BaseTest.logger.info("Entering Customer Details");

		// driver.switchTo().frame(0);
		// elementFtech.getWebElement("XPATH",
		// CheckoutPageElements.iframeclosebutton).click();
		// driver.switchTo().defaultContent();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Title).click();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.MrTitle).click();
		String data = excelReader.getCellData("Customer_Details", 0, 2);
		System.out.println(data);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Firtsname).sendKeys(excelReader.getCellData("Customer_Details", 0, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Lastname).sendKeys(excelReader.getCellData("Customer_Details", 1, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.BirthDate).sendKeys(excelReader.getCellData("Customer_Details", 2, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.BirthMonth).sendKeys(excelReader.getCellData("Customer_Details", 3, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.BirthYear).sendKeys(excelReader.getCellData("Customer_Details", 4, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.Income).sendKeys(excelReader.getCellData("Customer_Details", 5, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.MobileNumber).sendKeys(excelReader.getCellData("Customer_Details", 6, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.MobileVerify).click();
		getOTP();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.EnterOtp).sendKeys(otp);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.VerifyOtP).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(CheckoutPageElements.Next));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Next).click();
		Thread.sleep(10000);

	}
}
