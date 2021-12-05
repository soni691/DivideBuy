package main.java.pageObjects;

public interface V5CheckoutPageElements {
	String RetailerProductSearchBar ="//input[@id='woocommerce-product-search-field-0']" ;
	String TestProduct="//a[@href='https://wordpress.dividebuy-qa.info/product/testing-product/']//img[@alt='Placeholder']";
	String addtoCart ="//button[normalize-space()='Add to cart']";
	String ViewCart ="//div[@role='alert']//a[@class='button wc-forward'][normalize-space()='View cart']";
	String paywithDividebuy ="//span[@class='dividebuy-spreadcost']";
	String PostCode ="//input[@id='user_postcode']";
	String ViewOptions ="//a[@id='get_shipping_estimate']";
	String FreeShipping = "//label[normalize-space()='Free shipping']//div[@class='control__indicator']";
	String Checkout = "//a[@id='dividebuy_checkout_btn']";
	String EMIOptiondropdown ="//select[@id='ddlMonths']";
	String ThreeMonthEmi ="//*[@id=\"ddlMonths\"]/option[5]";
	String CustomerEmail ="//input[@id='emailAddress']";
	String Next ="//button[contains(text(),'Next')]";
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
	String CartContinueasGuestbutton= "//button[@id='btn_continue_guest']";
	String Postcode ="//input[@id='user_postcode']";
	String EnterOtp = "//input[@id='otp']";
	String VerifyOtP ="//div[contains(@class,'text-center col-9 col-md-10 mx-auto form-group')]//button[@type='button'][normalize-space()='Verify']";
}
