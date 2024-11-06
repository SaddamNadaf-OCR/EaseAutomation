package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class EndUseSpecificPurposePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_EndUser ="//textarea[@id='editGLEndUsePurpose_authorisationHeaderValue_endUse']";
	public static final String OCR_EndUser_SaveBtn ="//input[@id='validateGoodsForm']";
	public static final String OCR_EndUseType = "//select[@id='licenseGBSave_authorisationHeader_endUseCode']";
	public static final String OCR_EndUserType ="//select[@id='licenseGBSave_authorisationHeader_endUserCode']";
	public static final String OCR_EndUseTextBox = "//textarea[@id='licenseGBSave_endUse']";
	

	/* ******************************* Constructor ****************************** */

	public EndUseSpecificPurposePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//End User Specific data function
	public void endUseSpecificPurpose(String endUserspecific) {
		typeText(driver, test, OCR_EndUser, "End User Specific data is :  ", endUserspecific);
		clickElement(driver, test, OCR_EndUser_SaveBtn, "Click on Save Button");
	}

	//validate end user/specific purpose 
	public void validateEndUserError() {
		clickElement(driver, test, OCR_EndUser_SaveBtn, "Click on Save Button");
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[text()='End Use/Specific Purpose is required']")) {
					test.log(LogStatus.INFO, "End Use/Specific Purpose is required");
				} 				
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Exporter Details");					
		}
	}
	
	//End User Data
	public void endUserData(String EndUse, String EndUserType, String EndUserTextbox) {
		selectByVisibleText(driver, test, OCR_EndUseType, "Selecting End Use Type :", EndUse);
		selectByVisibleText(driver, test, OCR_EndUserType, "Selecting End User Type :", EndUserType);
		typeText(driver, test, OCR_EndUseTextBox, "Entering End user Data :", EndUserTextbox);
	}
	
	//Validatin of End User Data
	public void validationEndUser() {
		try {
			if(isDisplayed(driver, OCR_EndUseType)) {
				test.log(LogStatus.PASS, "End Use is Added Succesfully :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "End is not Added :");
		}
		
		try {
			if(isDisplayed(driver, OCR_EndUseType)) {
				test.log(LogStatus.PASS, "End User is Added Succesfully :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "END User is Not Added :");
		}
		
		try {
			if(isDisplayed(driver, OCR_EndUseTextBox)) {
				test.log(LogStatus.PASS, "End User Details are Added Successfully :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "End User ia Not Added :");
		}
	}
}

