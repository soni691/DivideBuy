package main.java.Test;

import org.testng.annotations.Test;

import main.java.Base.*;
import main.java.pages.*;

public class TestClass extends BaseTest {
	@Test(enabled=false)
	public void CRMLogin() {
		CRMLogin crmLogin = new CRMLogin();
		crmLogin.enterEmail();
		crmLogin.enterPassword();
		crmLogin.clickonLogin();
	}
	@Test
	public void RCAdmiLogin() {
		RCadmin rcadminLogin = new RCadmin();
		rcadminLogin.enterEmail();
		rcadminLogin.enterPassword();
		rcadminLogin.clickonRCALogin();
	}

}
