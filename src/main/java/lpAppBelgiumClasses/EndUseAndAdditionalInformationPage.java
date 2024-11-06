package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class EndUseAndAdditionalInformationPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EndUser ="//textarea[@id='editEndUsePurpose_authorisationHeaderValue_endUse']";
	public static final String OCR_EndUser_SaveBtn ="//input[@id='validateGoodsForm']";
	public static final String OCR_AdditionalInformation_DateofContract = "//input[@id='dateOfContract_id']";
	public static final String OCR_AdditionalInformation_CustomsRegimeField = "//input[@id='editEndUsePurpose_authorisationAdditionalInfoValue_customsRegime']";
	public static final String OCR_AdditionalInformation_AdditionalInformationField = "//textarea[@id='editEndUsePurpose_authorisationAdditionalInfoValue_additionalInfo']";
	public static final String OCR_ApplicantStatement_YesCheckbox = "//input[@id='Yes']";
	public static final String OCR_ApplicantStatement_NoCheckbox = "//input[@id='No']";

	/* ******************************* Constructor ****************************** */

	public EndUseAndAdditionalInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//End User Specific data function
	public void endUseSpecificPurpose(String endUserspecific) {
		typeText(driver, test, OCR_EndUser, "End User Specific data is :  ", endUserspecific);		
	}

	//Click on Save button in End use & Additional informations
	public void click_EndUseAndAddInfoSaveBtn() {
		clickElement(driver, test, OCR_EndUser_SaveBtn, "Click on Save Button");
	}

	//Add Additional Information function
	public void additionalInformationPage(String ContractDate, String customsRegime, String additionalInformation) {
		clickElement(driver, test, OCR_AdditionalInformation_DateofContract, "Clicking on Contract Date");		
		date(driver, test, "Selecing the to date : " , ContractDate);
		typeText(driver, test, OCR_AdditionalInformation_CustomsRegimeField, "Custom Regime is: ", customsRegime);
		typeText(driver, test, OCR_AdditionalInformation_AdditionalInformationField, "Additional Information is: ", additionalInformation);	
	}

	// Add Acknowledgement
	public void add_acknowledgement(String AcknowledgementChkBox) {
		if (AcknowledgementChkBox.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_ApplicantStatement_YesCheckbox, "Click on YES Check Box");
		} else {
			clickElement(driver, test, OCR_ApplicantStatement_NoCheckbox, "Click on NO Check Box");
		}		
	}
	
	//validate end user/specific purpose 
	public void validateEndUserError() {
		clickElement(driver, test, OCR_EndUser_SaveBtn, "Click on Save Button");
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[text()='End Use/Specific Purpose is required']")) {
					test.log(LogStatus.INFO, "End Use/Specific Purpose is required");
				} 	
				if (isDisplayed(driver,"//li[text()='Date of Contract is required.']")) {
					test.log(LogStatus.INFO, "Date of Contract is required.");
				} 
				if (isDisplayed(driver,"//li[text()='Please select Yes or No.']")) {
					test.log(LogStatus.INFO, "Please select Yes or No.");
				} 
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in End Use & Additional Information");					
		}
	}
}
