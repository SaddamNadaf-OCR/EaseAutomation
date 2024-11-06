package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class AdditionalInformationPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AdditionalInformation_DateofContract = "//input[@id='dateOfContract_id']";
	public static final String OCR_AdditionalInformation_CustomsRegimeField = "//input[@id='editAddtionalInfoForm_authorisationAdditionalInfoValue_customsRegime']";
	public static final String OCR_AdditionalInformation_AdditionalInformationField = "//textarea[@id='additionalInfoGL']";
	public static final String OCR_AdditionalInformation_SaveBtn = "//input[@id='validateCertificationForm']";

	/* ******************************* Constructor ****************************** */

	public AdditionalInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//Add Additional Information function
	public void additionalInformationPage(String ContractDate, String customsRegime, String additionalInformation) {
		clickElement(driver, test, OCR_AdditionalInformation_DateofContract, "Clicking on Contract Date");		
		date(driver, test, "Select the ContractDate : ", ContractDate);
		test.log(LogStatus.PASS, "Selecing the to date : " + ContractDate);
		typeText(driver, test, OCR_AdditionalInformation_CustomsRegimeField, "Custom Regime is: ", customsRegime);
		typeText(driver, test, OCR_AdditionalInformation_AdditionalInformationField, "Additional Information is: ", additionalInformation);
		clickElement(driver, test, OCR_AdditionalInformation_SaveBtn, "click on save Button");
	}

	//validate AdditionalInformation
	public void validateAdditionalInfoError() {
		clickElement(driver, test, OCR_AdditionalInformation_SaveBtn, "click on save Button");
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[text()='Date of Contract is required.']")) {
					test.log(LogStatus.INFO, "Date of Contract is required.");
				} 
				if (isDisplayed(driver,"//li[text()='Customs Regime is required.']")) {
					test.log(LogStatus.INFO, "Customs Regime is required.");
				} 
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Additional information");					
		}
	}
}
