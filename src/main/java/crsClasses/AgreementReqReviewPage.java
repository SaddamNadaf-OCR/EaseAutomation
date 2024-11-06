package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqReviewPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Determination="//select[@id='editAgreementStatus_disposition']";
	public static final String OCR_Status="//select[@name='status']";
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";
	public static final String OCR_RevPhone="//input[@id='editAgreementStatus_exportRequestValue_approverTelNo']";
	public static final String OCR_Button_Search="//button[contains(text(),'Search')]";
	public static final String OCR_AgreementNo="//a[contains(text(),'Agreement Number')]";
	public static final String OCR_AmendmentNumber="//a[contains(text(),'Amendment Number')]"; 
	public static final String OCR_Searchedrecord="//td[@class='ui-state-default jqgrid-rownum'][contains(text(),'1')]";
	public static final String OCR_Button_Select="//button[contains(text(),'Select')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']"; 


	public AgreementReqReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	//Select Status
	public void select_status(String Status) {
		selectByVisibleText(driver, test, OCR_Status, "Selecting Status:", Status);
	}

	//Select Determination
	public void select_determination(String Determination) {
		selectByVisibleText(driver, test, OCR_Determination, "Selecting Determination :", Determination);
	}
    
	// Enter Phone No
	public void enter_phoneno(String Phone) {
		typeText(driver, test, OCR_RevPhone, "Enter Phone No :", Phone);
	}

    //Add Agreement No
	public void add_agreementno(){
		clickElement(driver, test, OCR_AgreementNo, "Clicking on Agreement No Link :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Searchedrecord,"Clicking on searched record :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button :");		
	}
    
	//Add Amendment No
	public void add_amendmentno(){
		clickElement(driver, test, OCR_AmendmentNumber, "Clicking on Amendment Number Link :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Searchedrecord,"Clicking on searched record :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button :");		
	}

	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button :");
	}

	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
}