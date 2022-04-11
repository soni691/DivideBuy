package main.java.pages;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
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
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.RetailerProductSearchBar).sendKeys(excelReader.getCellData("Customer_Details", 8, 2));
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.RetailerProductSearchBar).sendKeys(Keys.ENTER);
	}

	public void clickonProduct() {
		//String shtproduct= excelReader.getCellData("Customer_Details", 8, 2);
		//String xpath = String.format("//a[@aria-label='Add \\“%s\\” to your cart']", shtproduct);
		//String xpath1 = xpath.replaceAll("\\"," ");
		//System.out.println(xpath1);
		//elementFtech.getWebElement("XPATH", xpath).click();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.TestProduct).click();
	}
	public void viewcartProduc() {
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.productViewpage).click();
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
		// elementFtech.getWebElement("XPATH",CheckoutPageElements.iframeclosebutton).click();
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
		WebElement element = driver.findElement(By.xpath(V5CheckoutPageElements.Next));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Next).click();
		Thread.sleep(10000);
	}
	
	public void clickonAgreePay() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(V5CheckoutPageElements.AgreeAndPay));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.AgreeAndPay).click();
	}
	
	public void enterCreditCarddetails() throws InterruptedException {
		//SagePay card
		//elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardNumber).sendKeys("4929000000006");
	//	elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardYear).click();
	//	elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardYear23).click();
		//elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardCVV).sendKeys("123");
		//elementFtech.getWebElement("XPATH", V5CheckoutPageElements.completePurchase).click();	
		
		//DNA Card
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardNumber).sendKeys(excelReader.getCellData("Customer_Details", 9, 2));
		Thread.sleep(2000);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardYear).click();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardYear23).click();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.cardCVV).sendKeys("123");
		Thread.sleep(3000);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.completePurchase).click();	
		Thread.sleep(35000);
	}
	
	public void enter3dSecurepwd() {
		driver.switchTo().activeElement();
		driver.switchTo().frame("sagepayFrame");
		//elementFtech.getWebElement("XPATH",CheckoutPageElements.iframeclosebutton).click();
		//driver.switchTo().defaultContent();
		System.out.println(V5CheckoutPageElements.threedPassword);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.threedPassword).sendKeys("password");	
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.threedSubmit).click();
	}
	
	public void enter3dsecurepopup() throws InterruptedException {
		
		WebElement iframeElement=driver.findElement(By.xpath("//*[@id=\"sagepayFrame\"]"));
	    driver.switchTo().frame(iframeElement);
		//driver.switchTo().activeElement();
		//driver.switchTo().frame("sagepayFrame");
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.threedPassword).sendKeys("challenge");	
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.popup3dnext).click();
		Thread.sleep(7000);
		driver.switchTo().defaultContent();
		String confirmation=elementFtech.getWebElement("XPATH", V5CheckoutPageElements.OrderConfirmation).getText();
		assertEquals(confirmation,"YOUR ORDER HAS BEEN RECEIVED.");		
	}
	public void ExistingCustomer() throws ClassNotFoundException, SQLException, InterruptedException {
		try {
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.ExistingNext).click();
		getOTP();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.EnterOtp).sendKeys(otp);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.VerifyOtP).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(V5CheckoutPageElements.Next));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", CheckoutPageElements.Next).click();
		clickonAgreePay();
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.ExistingCVV).sendKeys("123");
		Thread.sleep(2000);
		elementFtech.getWebElement("XPATH", V5CheckoutPageElements.completePurchase).click();
		Thread.sleep(9000); }
		catch(WebDriverException e) {

e.printStackTrace();

}
	}
}
