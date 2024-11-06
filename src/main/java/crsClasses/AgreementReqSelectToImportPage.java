package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AgreementReqSelectToImportPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_SelectAll = "//input[@name='selectBox1']";
	public static final String OCR_Button_Import ="//button[contains(text(), 'Import ')]"; 
	
	

	public AgreementReqSelectToImportPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Select All Button
	public void selectall() {
		clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button: ");
	}
	
	//Click on Import Item
	public void import_item() {
		clickElement(driver, test, OCR_Button_Import,"Clicking on Import Button");
		
	}

}
