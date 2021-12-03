package main.java.Base;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.internal.TestMethodArguments;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import  main.java.utils.*;

public class BaseTest {
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	@SuppressWarnings("deprecation")
	
	@BeforeTest
	public void Report() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/reports" +"/reports"+ dateName +"/DividebuyAutomationReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("DVB Automation Report");
		htmlReporter.config().setReportName("DivideBuy Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Sumit Soni");
	}
	
	
	@BeforeMethod
	@Parameters(value={"browserName", "url" })
	public void initializeBrowser(String browserName, String url,Method testMethod) {
		logger= extent.createTest(testMethod.getName());
		setupDriver(browserName);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
	
	@AfterMethod
	public void driverQuit(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText= "Test Case:"+methodName + "Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS,m);
			}
		else if(result.getStatus()==ITestResult.FAILURE) {	
			String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
			String methodName = result.getMethod().getMethodName();
			String logText= "<b>Test Method:"+ methodName + "Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.fail("<details><summary><b><font color=red>Exception Occured,click to see details:"+"</font></b></summary>" + exceptionMessage.replaceAll(",","<br>") + "</details> \n");
			String path = takeScreenshot(result.getMethod().getMethodName());
			try {
				logger.fail("<b><font color=red>" + "Screenshot of failure" + "</font></br>",
						MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
			catch(IOException e) {
				logger.fail("Test failed,can not attach screenshot");
			}
			logger.log(Status.FAIL, m);
			//String logText1= "<b>Test Method " +	methodName + " Failed</b>";	
			}
		driver.quit();
	}
	
	
	@AfterTest
	public void flushReport() {
		extent.flush();
	}
	
	public void setupDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers" +"/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers" +"/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	public String takeScreenshot(String methodName) {
		String fileName = getScreenshotname(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdir();
		String path = directory + fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("Screenshot Stored at" + path);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getScreenshotname(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

}
