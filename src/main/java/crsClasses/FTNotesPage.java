package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class FTNotesPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddAdditionalNotes ="//button[contains(text(),'Add Additional Notes')]";
	public static final String OCR_Notes ="//textarea[@id='editForeignTravelNotes_foreignTravelNotes_secureNotes']";
	public static final String OCR_Button_SavendReturn = "//button[contains(text(),'Save & Return')]";  
	public static final String OCR_Button_ForwardNavigation="//button[@id='next-btn']";
	
	
	/* ******************************** Constructor ******************************** */
	public FTNotesPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	// Click on Additional Notes Button
	public void click_additionalnotes() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_AddAdditionalNotes)));
		//clickElement(driver, test, OCR_Button_AddAdditionalNotes, "Click on Additional Notes Button");
	}
	//Entering Notes
	public void enter_notes(String Notes) {
		typeText(driver, test, OCR_Notes,"Entering Notes :", Notes);
	}
	//Click on Save and Return Button
	public void savendreturn() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_SavendReturn)));
		clickElement(driver, test, OCR_Button_SavendReturn, "Click on Save and Return Button");
	}
	//Click on Cancel Button
		public void cancel() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//button[@name='cancel.x']")));
			//clickElement(driver, test, "//button[@name='cancel.x']", "Click on Save and Return Button");
		}	
	//Click on Save and Return Button
	public void moveforward() {
		clickElement(driver, test, OCR_Button_ForwardNavigation, "Click on Save and Return Button");
	}
	//Validate notes error
	public void validatenoteserror() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Secure notes is a required field.')]")) {
					test.log(LogStatus.INFO, "Secure notes is a required field.");
				}	
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Notes Page");					
		}
		
	}


}
