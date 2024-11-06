package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;


public class FTAdditionalInfoAdditionalQuestionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_NotApplicable = "//input[@name='notApplicable']";
	public static final String OCR_Button_Save = "//input[@name='saveQuestions']";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";

	/* ******************************** Constructor ******************************** */
	public FTAdditionalInfoAdditionalQuestionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Not Applicable CheckBox
	public void click_notapplicable(){
		scrollToElement(driver, OCR_NotApplicable);
		List <WebElement> allcheckbox=driver.findElements(By.xpath(OCR_NotApplicable));	 
		for (int i = 1; i <= allcheckbox.size(); i++) {
			Wait.waitfor(3);
			scrollToElement(driver, OCR_NotApplicable + "[" + i + "]");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_NotApplicable + "[" + i + "]", "Click on Not Applicable :");
		}
		scrollToTop(driver);
		/*for(int i=0;i<allcheckbox.size();i++) {
			WebElement radiobuttons=allcheckbox.get(i);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" ,radiobuttons);
			radiobuttons.click();	
		}*/
	}

	//Click on Save Button
	public void save() {
		//scrollToElement(driver, OCR_Button_Save);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_Save)));
	}

	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	} 

	//Validating the Questionarria
	public void validate_additionalquestnerror() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				
				if (isDisplayed(driver,"//li[contains(text(),'Test Group Question:1 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "Test Group Question:1 - Please select one of the options.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Additional Questions Question:2 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "Additional Questions Question:2 - Please select one of the options.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Additional Info Page");					
		}
	}
	
	// Click on Submit Request tab
	public void movetosubmitreq() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//a[contains(text(),'Submit Request')]")));
	}
	
	//click Label
	public void clicklable() {
		clickElement(driver, test, "//textarea[@name='responseDescriptive']", "");
	}

}
