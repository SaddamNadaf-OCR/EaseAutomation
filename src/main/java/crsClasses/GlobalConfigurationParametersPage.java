package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class GlobalConfigurationParametersPage extends GenericMethods {
		
		public WebDriver driver;
		public ExtentTest test;

		/* ******************************** LOCATORS ******************************** */
		public static final String OCR_ParameterValue="//textarea[@id='editGlobalConf_globalConf_confValue']";		
		public static final String OCR_Button_Save_Return="//button[contains(text(),'Save & Return')]";
		public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";

		public GlobalConfigurationParametersPage(WebDriver driver, ExtentTest test) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
			this.test = test;
		}
		
		public void Edit_TFP_Default() {
			clickElement(driver, test,"//a[contains(text(),'ER_TFP_DEFAULT')]","Click on TFP Default");
			clearText(driver, test, OCR_ParameterValue,"Clear Previous Value");
			typeText(driver, test, OCR_ParameterValue,"Enter Parameter Value","Nancy");
			clickElement(driver, test, OCR_Button_Save_Return,"Click on Save and Return Button");
			
		}
		
		public void Edit_EFP_Default() {
			clickElement(driver, test,"//a[contains(text(),'ER_EFP_DEFAULT')]","Click on EFP Default");
			clearText(driver, test, OCR_ParameterValue,"Clear Previous Value");
			typeText(driver, test, OCR_ParameterValue,"Enter Parameter Value","Nancy");
			clickElement(driver, test, OCR_Button_Save_Return,"Click on Save and Return Button");
			
		}
	
	

}
