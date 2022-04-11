package main.java.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import main.java.Base.BaseTest;
import main.java.pageObjects.AccountPageElements;
import main.java.pageObjects.CheckoutPageElements;
import main.java.utils.ElelmentFetch;
import main.java.utils.ExcelReader;

public class Account extends BaseTest {
	ElelmentFetch elementFtech = new ElelmentFetch();
	ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "/TestData" + "/DVB_Testdata.xlsx");
	
	public void enterAccountEmail() {
		elementFtech.getWebElement("XPATH", AccountPageElements.AccountEmail).sendKeys(excelReader.getCellData("Customer_Details", 7, 2));		
	}
	public void enterAccountPassword() {
		elementFtech.getWebElement("XPATH", AccountPageElements.AccountPassword).sendKeys("Admin@123");
	}
	public void clickonAccountlogin() throws InterruptedException {
		elementFtech.getWebElement("XPATH", AccountPageElements.AccountLogin).click();
		Thread.sleep(10000);
	}
	public void Accountlogout() {
		String TxtBoxContent = driver.findElement(By.xpath("//div[@class='hidden-xs']//h1[contains(text(),'Your credit with DivideBuy')]")).getText();
		System.out.println(TxtBoxContent);
		Assert.assertEquals(TxtBoxContent,"Your credit with DivideBuy");
		elementFtech.getWebElement("XPATH", AccountPageElements.Accountlogout).click();
	}
	public void AccountpayFirstInstallment() throws InterruptedException {
		elementFtech.getWebElement("XPATH", AccountPageElements.YourAccount).click();
		elementFtech.getWebElement("XPATH", AccountPageElements.Paybutton).click();
		elementFtech.getWebElement("CSS", AccountPageElements.payinstallments).click();
		elementFtech.getWebElement("CSS", AccountPageElements.payfirstinstallment).click();
	}
}
