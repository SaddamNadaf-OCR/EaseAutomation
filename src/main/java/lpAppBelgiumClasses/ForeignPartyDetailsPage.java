package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ForeignPartyDetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_FP_AddPartiesBtn = "//input[@id='addFP']";
	public static final String OCR_FP_ConsigneeCode = "//a[contains(text(),'Consignee Code')]";
	public static final String OCR_FP_ConsigneeId = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_FP_SearchConsigneeBtn = "//button[@name='Search']";
	public static final String OCR_FP_SelectConsigneeBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_FP_SaveConsignee = "//button[@name='btn-sbmt']";
	public static final String OCR_FP_ConsigneeType = "//select[@id='saveBelgiumFPPopup_authorisationConsigneeValue_licConsType']";
	public static final String OCR_FP_CloseEditForeignPartyPopup = "//button[@class='btn-close']";
	public static final String OCR_ViewEditAuth_ForeignPartyDetails = "//label[contains(text(),'Foreign Party Details')]";
	public static final String OCR_AddForeignPartyButton = "//button[@id='fpartyBtn']";

	/* ******************************* Constructor ****************************** */

	public ForeignPartyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Add Party Button
	public void addPartyBtn() {
		clickElement(driver, test, OCR_FP_AddPartiesBtn, "click on Add Party Button");
	}

	// Click on Consignee Part No Link
	public void createNewForeignParty() {
		clickElement(driver, test, OCR_FP_ConsigneeCode, "Click on Consignee Part No Link");
	}

	// selecting the search Consignee pop up
	public void searchConsignee(String consigneeCode ) {
		try {
			typeText(driver, test, OCR_FP_ConsigneeId, "Enter Consignee Code : ", consigneeCode);
			clickElement(driver, test, OCR_FP_SearchConsigneeBtn, "Click on Search Button");
			String consignee = "//td[contains(text(),'" + consigneeCode + "')]";
			clickElement(driver, test, consignee, "Selected Consignee Code :" + consigneeCode);
			clickElement(driver, test, OCR_FP_SelectConsigneeBtn, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Click on Consignee Pop up close");
		}
	}

	//select the consigneeType and click on save button
	public void saveForeignParty(String  consigneeType) {
		selectByVisibleText(driver, test, OCR_FP_ConsigneeType, "Select Consignee Type:", consigneeType);
		clickElement(driver, test, OCR_FP_SaveConsignee, "click on save button");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
	}

	//validating the Add Parties is Added or not in grid table
	public void validate_addParties(String consigneeType) {
		try {				
			String consgTypeTable = "//table[@id='foreignPartyTabel']//tr//td/a[contains(text(),'"+consigneeType.trim()+"')]";
			isDisplayed(driver, consgTypeTable);
			test.log(LogStatus.PASS, "Add foreign party is Added in result grid table : "+consigneeType);			
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Parties in result grid table : " +consigneeType);
		}
	}

	// validate forigen party details
	public void validateForigenPartyDetailsError() {
		clickElement(driver, test, OCR_FP_SaveConsignee, "click on save button");
		try {
			if (isDisplayed(driver,"(//h4[contains(text(),'Error')])[2]")) {				

				if (isDisplayed(driver,"//li[text()='Consignee Type  is required.']")) {
					test.log(LogStatus.INFO, "Consignee Type  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Name  is required.']")) {
					test.log(LogStatus.INFO, "Name  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Address  is required.']")) {
					test.log(LogStatus.INFO, "Address  is required.");
				}
				if (isDisplayed(driver,"//li[text()='City  is required.']")) {
					test.log(LogStatus.INFO, "City  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Country  is required.']")) {
					test.log(LogStatus.INFO, "Country  is required.");
				}				
				Wait.waitfor(3);
				clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Create Foreign Party");					
			clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
		}
	}

	// validate forigen party details of same consignee type
	public void validateForigenPartyDetailsErrorofSameCType(String consigneeType) {
		selectByVisibleText(driver, test, OCR_FP_ConsigneeType, "Select Consignee Type : ", consigneeType);
		clickElement(driver, test, OCR_FP_SaveConsignee, "click on save button");
		Wait.waitfor(3);
		if(consigneeType.equalsIgnoreCase("Foreign End User")) {
			try {
				if (isDisplayed(driver,"(//h4[contains(text(),'Error')])[2]")) {				

					if (isDisplayed(driver,"//span[text()='Only one End User is permitted.']")) {
						test.log(LogStatus.INFO, "Only one End User is permitted.");
					}

					Wait.waitfor(3);
					clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on SAVE button of same consignee Type in Create Foreign Party");
				clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
			}
		}
		if(consigneeType.equalsIgnoreCase("Foreign Consignee")) {
			try {
				if (isDisplayed(driver,"(//h4[contains(text(),'Error')])[2]")) {				

					if (isDisplayed(driver,"//span[text()='Only one Foreign Consignee is permitted.']")) {
						test.log(LogStatus.INFO, "Only one Foreign Consignee is permitted.");
					}
					Wait.waitfor(3);
					clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on SAVE button of same consignee Type in Create Foreign Party");					
				clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");			
			}
		}
	}
	
	//Foreign Party Details
	public void addForeignParty() {
		clickElement(driver, test, OCR_ViewEditAuth_ForeignPartyDetails, "Clicking on Foreign Party Details Label :");
		clickElement(driver, test, OCR_AddForeignPartyButton, "Clicking on Add Foreign Party Button :");
		Wait.waitfor(2);
	}

}
