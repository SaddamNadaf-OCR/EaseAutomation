package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchGlobalConfigurationPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ParameterName="//input[@name='globalConf.confCode']";		
	public static final String OCR_Button_Search ="//button[contains(text(),'Search')]";	
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";

	public SearchGlobalConfigurationPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	
	public void enter_TFP_ParameterName() {
		typeText(driver, test, OCR_ParameterName, "Enter Parameter Name","ER_TFP_Default");
		clickElement(driver, test, OCR_Button_Search,"Click on Search Button");
	}
	
	public void enter_EFP_ParameterName() {
		typeText(driver, test, OCR_ParameterName, "Enter Parameter Name","ER_EFP_Default");
		clickElement(driver, test, OCR_Button_Search,"Click on Search Button");
	}
	
	
	
	
	

}
