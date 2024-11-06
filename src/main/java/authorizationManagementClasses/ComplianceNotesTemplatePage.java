package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ComplianceNotesTemplatePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String Temp_Select="//input[@value='Select']";
	public static final String Temp_New="//input[@value='New']";
	public static final String Temp_Cancel="//input[@value='Cancel']";
		
	//.................................Constructor.....................................//
	public ComplianceNotesTemplatePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//.............................Click on Select Tab..................................//
	public void selectByTemplate(String templateName) {
		selectByVisibleText(driver, test, "//option[contains(text(),'"+templateName+"')]", "Selecting Template Value From table", templateName);
		clickElement(driver, test, Temp_Select, "Clicking on Select Tab");
	}
	
	//.............................Click on New Tab...................................//
	public void clickonNew() {
		clickElement(driver, test, Temp_New, "Clicking on New Tab");
	}
	
	//.............................Click on Cancel Tab...................................//
	public void clickonCancel() {
		clickElement(driver, test, Temp_Cancel, "Clicking on Cancel Tab");
	}

}
