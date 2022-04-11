package main.java.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.Base.BaseTest;
import main.java.pages.Account;
import main.java.pages.CRMLogin;

public class AccountTest extends BaseTest{
	@Test(enabled=false)
	@Parameters({ "url" })
	public void AccountLogin(String url) throws InterruptedException {
		Account actLogin = new Account();
		actLogin.enterAccountEmail();
		actLogin.enterAccountPassword();
		actLogin.clickonAccountlogin();
		//actLogin.Accountlogout();
		actLogin.AccountpayFirstInstallment();
	}
}
