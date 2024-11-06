package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqSubmitPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_NameofExportRepresentative="//select[@id='editAggSubmit_reviewManager']";
	public static final String OCR_Phone="//input[@id='editAggSubmit_exportRequestValue_reviewerTelNo']";
	public static final String OCR_Button_Save ="//button[contains(text(),'Save')]";
	public static final String OCR_Button_ForwardNavigation="//button[@id='next-btn']";
	public static final String OCR_Button_SubmitForReview="//button[@name='submitForReview']";
	
	public AgreementReqSubmitPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}

   //Selecting Reviewer Name
   public void addreviewer(String ReviewerName) {
	   selectByVisibleText(driver, test, OCR_NameofExportRepresentative,"Selecting Export Reviewer", ReviewerName);
   }
   
   //Clicking on Save Button
   public void save() {
	   clickElement(driver, test, OCR_Button_Save,"Clicking on Save Button: ");
   }
   
   //Submit request for review
   public void submitforreview() {
	   clickElement(driver, test, OCR_Button_SubmitForReview,"Clicking on Submit for Review Button: ");
   }
   
   //Click on Forward Button 
   public void moveForward() {
	    Wait.waitfor(3);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
		Wait.waitfor(3);
	}
   
   //Validating Submit Page.
   public void validate_SubmitError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Please select an Export Representative')]")) {
					test.log(LogStatus.INFO, "Document Type is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please enter Export Representative Email Address')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}			
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Submit Page.");					
		}
	}
   
}
