package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import main.java.Base.BaseTest;
import main.java.pageObjects.*;

import main.java.utils.*;

public class CRMLogin extends BaseTest {
	ElelmentFetch elementFtech = new ElelmentFetch();
	ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "/TestData" + "/DVB_Testdata.xlsx");
	public void clickonLogin() {
		//ElelmentFetch elementFtech = new ElelmentFetch();
		BaseTest.logger.info("Clicking on Signin Button");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.Signin).click();
	}
	
	public void enterEmail() {
		BaseTest.logger.info("Entering EmailId");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.EmailAddress).sendKeys("admin@dividebuy.co.uk");
	}
	public void enterPassword() {
		BaseTest.logger.info("Entering Password");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.password).sendKeys("password");
	}
	public void CRMLogout() {
		//ElelmentFetch elementFtech = new ElelmentFetch();
		BaseTest.logger.info("Clicking on Settings options");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.Settings).click();
		BaseTest.logger.info("Clicking on Logout option");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.Logout).click();
	}
	
	public void CRMSearchCustomer() throws InterruptedException {
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.CRMCustomers).click();
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.AllCustomers).click();
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.InputCustomer).sendKeys(excelReader.getCellData("Customer_Details", 7, 2));
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.CustomerSearch).click();
		Thread.sleep(3000);
	}
	
	public void CRMCustUpdatePassword() {
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.CustEdit).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(CRMLoginPageElements.password));
		js.executeScript("arguments[0].scrollIntoView();", element);
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.password).sendKeys("Admin@123");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.ConfirmPassword).sendKeys("Admin@123");
		elementFtech.getWebElement("XPATH", CRMLoginPageElements.UpdatePassword).click();
	}
}
