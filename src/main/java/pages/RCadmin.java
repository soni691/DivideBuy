package main.java.pages;

import org.testng.Assert;

import main.java.Base.BaseTest;
import main.java.pageObjects.CRMLoginPageElements;
import main.java.pageObjects.RCadminPageElements;
import main.java.utils.ElelmentFetch;

public class RCadmin extends BaseTest{
	ElelmentFetch elementFtech = new ElelmentFetch();
	public void clickonRCALogin() throws InterruptedException {
		//ElelmentFetch elementFtech = new ElelmentFetch();
		BaseTest.logger.info("Clicking on RCAdmin Login Button");
		elementFtech.getWebElement("XPATH", RCadminPageElements.RCAminlogin).click();
		Thread.sleep(3000);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Manage Orders: DivideBuy";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	public void enterEmail() {
		BaseTest.logger.info("Entering Rcadmin EmailId");
		elementFtech.getWebElement("XPATH", RCadminPageElements.RCAdminEmail).sendKeys("Sigma");
	}
	public void enterPassword() {
		BaseTest.logger.info("Entering RCAdmin Password");
		elementFtech.getWebElement("XPATH", RCadminPageElements.RCAdminpassword).sendKeys("Admin$123");
	}
	public void Rcadminlogout() {
		BaseTest.logger.info("Clicking on logout");
		elementFtech.getWebElement("XPATH", RCadminPageElements.RCAminlogout).click();
	}

}
