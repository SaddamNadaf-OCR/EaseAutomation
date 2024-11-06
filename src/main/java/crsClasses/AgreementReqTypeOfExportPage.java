package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqTypeOfExportPage extends GenericMethods{


	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_TypeOfDS_SelectAll="//input[@id='selectDef1']";
	public static final String OCR_TypeOfTD_SelectAll="//input[@id='selectDef2']";
	public static final String OCR_MethodOfTP_SelectAll="//input[@id='selectDef3']";
	public static final String OCR_PermanentExport="//input[@id='selectDef4']";
	public static final String OCR_TemporaryExport="//input[@id='selectDef5']";
	public static final String OCR_TemporaryImport="//input[@id='selectDef6']";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";



	/* ******************** Constructor ***************************** */
	public AgreementReqTypeOfExportPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}

	//Click on Type of Defense Services Checkbox
	public void typeofDefenseServices() {

		clickElement(driver, test, OCR_TypeOfDS_SelectAll, "Clicking on Select All checkbox: ");
	}
    
	//Click on Type of TechData Checkbox
	public void typeofTechData() {

		clickElement(driver, test, OCR_TypeOfTD_SelectAll, "Clicking on Select All checkbox: ");
	}
    
	//Click on Method of Transport Checkbox
	public void  MethodofTransport() {

		clickElement(driver, test, OCR_MethodOfTP_SelectAll, "Clicking on Select All checkbox: ");
	}

	//Click on Permanent Export Select All Checkbox
	public void   PermanentExport() {

		clickElement(driver, test, OCR_PermanentExport, "Clicking on Select All checkbox: ");
	}
    
	// Click on Temporary Export Select All Checkbox
	public void   TemporaryExport() {

		clickElement(driver, test, OCR_TemporaryExport, "Clicking on Select All checkbox: ");
	}
    
	// Click on Temporary Import Select All Checkbox
	public void   TemporaryImport() {

		clickElement(driver, test, OCR_TemporaryImport, "Clicking on Select All checkbox: ");
	}

    // Click on Save Button
	public void click_SaveButton() {		
		scrollToElement(driver, OCR_Button_Save);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");	
	}
    
	// Click on forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
	
	//Click on submit page
	public void movetoSubmitPage() {
		Wait.waitfor(3);
		clickElement(driver, test, "//a[contains(text(), 'Submit')]", "Clicking on Submit Tab");		
	}

}
