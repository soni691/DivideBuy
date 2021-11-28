package main.java.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.Base.*;
import main.java.pages.*;

public class PortalTestClass extends BaseTest {
	@Parameters({ "url" })
	@Test
	public void PortalLogin() {
		Portal portal= new Portal();
		portal.enterPortalEmail();
		portal.enterPortalPassword();
		portal.enterPortalPIN();
		portal.clickonPortalLogin();
	}
}
