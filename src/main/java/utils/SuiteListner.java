package main.java.utils;

import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.util.RetryAnalyzerCount;

import com.aventstack.extentreports.utils.FileUtil;

import main.java.Base.*;

public class SuiteListner implements ITestListener,IAnnotationTransformer {
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		String fileName = System.getProperty("user.dir")+"/screenshots"+"/screenshots"+iTestResult.getMethod().getMethodName();
		System.out.println(fileName);
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(fileName + ".png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
	}

	/*
	 * @Override public void transform(ITestAnnotation iTestAnnotation, Class
	 * aClass, Constructor constructor, Method method) {
	 * iTestAnnotation.setRetryAnalyzer(RetryAnalyzerCount.class); }
	 */
}
