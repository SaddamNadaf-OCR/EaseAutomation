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

public class AgreementReqMLAPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']"; 
	public static final String OCR_Ques_NotApplicable="	//input[@name='notApplicableQues']"; 
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";

	public  AgreementReqMLAPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}

	//Click on All Not Applicable checkbox
	public void notapplicable() {
		List<WebElement> notapplicable= driver.findElements(By.xpath(OCR_Ques_NotApplicable));

		for(int i=0; i< notapplicable.size(); i++) {
			//System.out.println(notapplicable.size());
			WebElement checkbox=notapplicable.get(i);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" ,checkbox);
			//nacheckbox.click();		
		}
		Wait.waitfor(3);
	}
	
	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");	
	}
    
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
    
	//Validating MLA Questions
	public void validate_MLAQuestionsError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'MLA Agreement Questions Question:1 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "MLA Agreement Questions Question:1 - Please select one of the options.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in MLA Questionnairre Page.");					
		}
	}
}
