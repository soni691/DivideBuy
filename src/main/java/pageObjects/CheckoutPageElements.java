package main.java.pageObjects;

public interface CheckoutPageElements {
	String RetailerHomeMenu ="//a[normalize-space()='Home & Decor']" ;
	String RetailerBedBathMenu ="//span[normalize-space()='Bed & Bath']";
	String RetailerElectronicsMenu ="//a[contains(text(),'Electronics')]";
	String RetailertestProduct="//a[contains(text(),'Gramercy Throw')]";
	String RetailerprodetailAddtocart = "//button[@onclick='productAddToCartForm.submit(this)']//span//span[contains(text(),'Add to Cart')]";
	String PaywithDVBbutton= "//span[@class='dividebuy-spreadcost']";
	String CartContinueasGuestbutton= "//button[@id='btn_continue_guest']";
	String Postcode ="//input[@id='userPostcode']";
	String ViewOptions ="//a[@id='get_shipping_estimate']";
	String FreeShipping = "//label[normalize-space()='Free']";
	String Checkout = "//a[@id='dividebuy_checkout_btn']";
	String EMIOptiondropdown ="//select[@id='ddlMonths']";
	String ThreeMonthEmi ="//option[contains(text(),'4 Months')]";
	String CustomerEmail ="//input[@id='emailAddress']";
	String Next ="//button[contains(text(),'Next')]";
	String EnteryOtp = "//input[@id='otp']";
	String VerifyOtP ="//div[contains(@class,'text-center col-9 col-md-10 mx-auto form-group')]//button[@type='button'][normalize-space()='Verify']";
	String iframeclosebutton="//div[@id='icon-close']";
	String Title="//select[@id='ddlTitle']";
	String MrTitle= "//*[@id=\"ddlTitle\"]/option[1]";
	String Firtsname = "//input[@id='firstName']";
	String Lastname= "//input[@id='lastName']";
	String BirthDate="//input[@id='day']";
	String BirthMonth="//input[@id='month']";
	String BirthYear="//input[@id='year']";
	String Income ="//input[@id='income']";
	String MobileNumber = "//input[@id='mobileNumber']";
	String MobileVerify ="//button[normalize-space()='Verify']";
}
