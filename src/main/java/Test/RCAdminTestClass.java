package main.java.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.Base.*;
import main.java.pages.*;

public class RCAdminTestClass extends BaseTest {
	
	@Parameters({ "url" })
	@Test(enabled=false)
	public void RCAdmiLogin() {
		RCadmin rcadminLogin = new RCadmin();
		rcadminLogin.enterEmail();
		rcadminLogin.enterPassword();
		rcadminLogin.clickonRCALogin();
		rcadminLogin.Rcadminlogout();
	}
	
}
