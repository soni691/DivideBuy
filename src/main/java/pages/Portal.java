package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import main.java.Base.BaseTest;
import main.java.pageObjects.CRMLoginPageElements;
import main.java.pageObjects.PortalPageElements;
import main.java.utils.ElelmentFetch;

public class Portal extends BaseTest {
	ElelmentFetch elementFtech = new ElelmentFetch();
	public void clickonPortalLogin() throws InterruptedException {
		//ElelmentFetch elementFtech = new ElelmentFetch();
		BaseTest.logger.info("Clicking on Signin Button");
		elementFtech.getWebElement("XPATH", PortalPageElements.Portallogin).click();
		//To assert Portal login page
		String TxtBoxContent = driver.findElement(By.xpath("//button[@id='btnSave']")).getText();
		System.out.println(TxtBoxContent);
		Assert.assertEquals(TxtBoxContent,"Add New Retailer");
		Thread.sleep(2000);
	}
	
	public void enterPortalEmail() {
		BaseTest.logger.info("Entering EmailId");
		elementFtech.getWebElement("XPATH", PortalPageElements.PortalEmail).sendKeys("padmin@dividebuy.co.uk");
	}
	public void enterPortalPassword() {
		BaseTest.logger.info("Entering Password");
		elementFtech.getWebElement("XPATH", PortalPageElements.Portalpassword).sendKeys("Admin@123");
	}
	public void enterPortalPIN() {
		BaseTest.logger.info("Entering PIN");
		elementFtech.getWebElement("XPATH", PortalPageElements.PoratlPin1box).sendKeys("1");
		elementFtech.getWebElement("XPATH", PortalPageElements.PoratlPin2box).sendKeys("2");
		elementFtech.getWebElement("XPATH", PortalPageElements.PoratlPin3box).sendKeys("3");
		elementFtech.getWebElement("XPATH", PortalPageElements.PoratlPin4box).sendKeys("4");
	}
	
	public void Portallogout() throws InterruptedException {
		BaseTest.logger.info("clicking on logout");
		elementFtech.getWebElement("XPATH", PortalPageElements.Portallogout).click();
		Thread.sleep(2000);
	}
}
