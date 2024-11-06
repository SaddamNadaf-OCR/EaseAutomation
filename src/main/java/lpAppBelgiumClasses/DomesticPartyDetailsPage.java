package lpAppBelgiumClasses;
/* 
 * Module : LP
 * Author  : Saddam
 * created date : April 2024
 * Descriptions : Domestic Party Details Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class DomesticPartyDetailsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_DP_SaveParty = "//input[@name='save']";
	public static final String OCR_DP_SaveAndReturn = "//input[@name='saveAndReturn']";
	public static final String OCR_DP_Cancel = "//input[@name='Cancel']";
	public static final String OCR_DP_PartyCode = "//a[@id='partyTypeAnchor']";
	public static final String OCR_DP_ExporterCode = "//input[@name='exporter.expCode']";
	public static final String OCR_DP_ExporterStatus = "//select[@name='exporter.status']";
	public static final String OCR_DP_SearchPopup = "//button[@name='Search']";
	public static final String OCR_DP_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_DP_ClosePopup = "//button[@class='btn-close']";
	public static final String OCR_DP_PartyType = "//select[@id='SelectEuPartyType']";
	public static final String OCR_ViewEditAuth_DomesticPartyDetails = "//label[contains(text(),'Domestic Party Details')]";
	public static final String OCR_FP_SelectConsigneeBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_FP_SaveConsignee = "//button[@name='btn-sbmt']";
	
	public static final String OCR_FP_CloseEditForeignPartyPopup = "//button[@class='btn-close']";

	/* ******************************* Constructor ****************************** */

	public DomesticPartyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Party Code Link
	public void createDomesticParty() {
		clickElement(driver, test, OCR_DP_PartyCode, "Click on Party Code Link");
	}

	// selecting the search Party pop up
	public void searchparty(String exporterCode, String ExporterStatus ) {
		clickElement(driver, test, OCR_DP_PartyCode, "Clicking on Party Code Link :");
		try {
			typeText(driver, test, OCR_DP_ExporterCode, "Enter Exporter Code : ", exporterCode);
			selectByVisibleText(driver, test, OCR_DP_ExporterStatus, "Selecting Exporter Status :", ExporterStatus);
			clickElement(driver, test, OCR_DP_SearchPopup, "Click on Search Button");
			String consignee = "//td[contains(text(),'" + exporterCode + "')]";
			clickElement(driver, test, consignee, "Selected Consignee Code :" + exporterCode);
			clickElement(driver, test, OCR_DP_SelectPopup, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_DP_ClosePopup, "Click on Consignee Pop up close");
		}
	}

	//select the consigneeType and click on save button
	public void saveDomesticParty(String partyType) {
		selectByVisibleText(driver, test, OCR_DP_PartyType, "Select Party Type:", partyType);
		clickElement(driver, test, OCR_DP_SaveParty, "click on save button");
	}

	//validating the Add Parties is Added or not in grid table
	public void validate_addParties(String partyType) {
		clickElement(driver, test, OCR_ViewEditAuth_DomesticPartyDetails, "Clicking on Domestic Party Details Label :");
		try {				
			String partyTypeTable = "//table[@id='foreignPartyTabel']//tr//td/a[contains(text(),'"+partyType.trim()+"')]";
			isDisplayed(driver, partyTypeTable);
			test.log(LogStatus.PASS, "Add foreign party is Added in result grid table : "+partyTypeTable);			
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Parties in result grid table : " +partyType);
		}
	}

	// validate forigen party details
	public void validateForigenPartyDetailsError() {
		clickElement(driver, test, OCR_DP_SaveParty, "click on save button");
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
				//clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Create Foreign Party");					
			clickElement(driver, test, OCR_FP_CloseEditForeignPartyPopup, "Edit Foreign Party Pop up close");
		}
	}

	// validate forigen party details of same consignee type
	public void validateForigenPartyDetailsErrorofSameCType(String partyType) {
		selectByVisibleText(driver, test, OCR_DP_PartyType, "Select Party Type : ", partyType);
		clickElement(driver, test, OCR_FP_SaveConsignee, "click on save button");
		Wait.waitfor(3);
		if(partyType.equalsIgnoreCase("Foreign End User")) {
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
		if(partyType.equalsIgnoreCase("Foreign Consignee")) {
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
}