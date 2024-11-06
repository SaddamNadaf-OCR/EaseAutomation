package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class FTTemplatePage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_NewRequest = "//button[@name='deny'][2]";
	public static final String OCR_Template = "//select[@name='templateName']";
	public static final String OCR_Button_Select = "//button[@name='deny'][contains(text(),'Select')]";

	public FTTemplatePage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	} 
	//Click on New Request Button
	public void click_newrequest() {
		clickElement(driver, test, OCR_Button_NewRequest, "Click on New Request Button");
	}
	
	public void validate_templateError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Please select a Template')]")) {
					test.log(LogStatus.INFO, "Please select a Template");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Template Page");					
		}
	}
	
	//.............................Select Template......................//
	public void template(String Template) {
		selectByVisibleText(driver, test, OCR_Template, "Selecting Template :", Template);
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button :");
	}
	//Click on Select Button
		public void click_select() {
			clickElement(driver, test, OCR_Button_Select, "Click on Select Button");
		}
}
