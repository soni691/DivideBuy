package main.java.pages;

import main.java.Base.BaseTest;
import main.java.pageObjects.*;

import main.java.utils.*;

public class CRMLogin {
	ElelmentFetch elementFtech = new ElelmentFetch();
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
}
