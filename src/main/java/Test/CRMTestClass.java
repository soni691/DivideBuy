package main.java.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.Base.*;
import main.java.pages.*;

public class CRMTestClass extends BaseTest {
	/*
	 * @DataProvider(name = "url") public Object[][] dataProviderMethod() { return
	 * new Object[][] { { "https://crm.dividebuysandbox.co.uk" }, {
	 * "https://rcadminsandbox.co.uk/" } }; }
	 */
	
	@Test(enabled=false)
	@Parameters({ "url" })
	public void CRMLogin(String url) {
		CRMLogin crmLogin = new CRMLogin();
		crmLogin.enterEmail();
		crmLogin.enterPassword();
		crmLogin.clickonLogin();
		crmLogin.CRMLogout();
	}
}
