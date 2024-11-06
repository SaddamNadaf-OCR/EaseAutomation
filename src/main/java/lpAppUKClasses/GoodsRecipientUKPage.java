package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class GoodsRecipientUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/******************* Locators ****************/
	public static final String OCR_GoodsRecipientTab = "//i[@id='GRS']";
	public static final String OCR_GoodsRecipient_AddGoodsRecipientBtn = "//button[@id='addRecipientBtn']";
	public static final String OCR_GoodsRecipient_IndividualRadioBtn = "//input[@id='typeFlagI']";
	public static final String OCR_GoodsRecipient_Individuallink = "//b[contains(text(),'Individual')]";
	public static final String OCR_GoodsRecipient_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_GoodsRecipient_ConsigneeStatus = "//select[@id='searchForm_consignee_status']";
	public static final String OCR_GoodsRecipient_ConsigneeSearchBtn = "//button[@name='Search']";
	public static final String OCR_GoodsRecipient_ConsigneeSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GoodsRecipient_TypesofRecipient_Consignee = "//input[@id='consignee']";
	public static final String OCR_GoodsRecipient_TypesofRecipient_EndUser = "//input[@id='endUser']";
	public static final String OCR_GoodsRecipient_TypesofRecipient_OtherInfoTextBox = "//textarea[@id='editThirdPartySection_authorisationConsigneeValue_licConsOtherInfo']";
	public static final String OCR_GoodsRecipientSection_IndividualTitle = "//input[@id='licConsTitle']";
	public static final String OCR_GoodsRecipientSection_IndividualSurname = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsSurname']";
	public static final String OCR_GoodsLocationSection_IndividualEmailIdField = "//input[@id='editThirdPartySection_licUkAuthCnsigneeMailIdValues_0__itemDesc']";
	public static final String OCR_GoodsLocationSection_IndividualTelephoneNo = "//input[@id='editThirdPartySection_licUkAuthCnsigneePhoneValues_0__itemDesc']";
	public static final String OCR_GoodsRecipient_TypesofRecipient_ConsigneePhoneNo = "//input[@id='editThirdPartySection_licUkAuthCnsigneePhoneValues_0__itemDesc']";
	public static final String OCR_GoodsRecipient_OrganizationRadioBtn = "(//input[@id='typeFlagO'])[1]";
	public static final String OCR_GoodsRecipient_OrganizationLink = "//b[contains(text(),'Organization')]";
	public static final String OCR_GoodsRecipient_OrganizationWebsiteAdd = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsWebsite']";
	public static final String OCR_GoodsRecipient_Save = "//button[@id='save']";
	public static final String OCR_GoodsRecipient_SaveandReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_GoodsRecipient_AddMore = "//button[@id='AddMore']";
	public static final String OCR_GoodsRecipient_CloseBtn = "//input[@id='cancelPopup']";
	public static final String OCR_GoodsRecipient_EndUserDropDwn = "//select[@id='endUserDropdown']";

	/**************** Constructor ********************************/
	public GoodsRecipientUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickOnGoodsRecipientTab() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GoodsRecipientTab, "Click on Goods Recipient Tab");
	}

	public void clickOnAddGoodsRecipient() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GoodsRecipient_AddGoodsRecipientBtn, "Click on Add Goods Recipient");
	}

	public void selectType(String GoodsRecipientSelectType, String GoodsRecIndConsigneeCode, String GoodsRecIndStatus,
			String GoodsRecTitle, String GoodsRecSurname, String GoodsRecEmail, String GoodsRecTelephone,
			String GoodsRecOrgConsigneeCode, String GoodsRecOrgStatus, String GoodsRecWebAddress,
			String GoodsRecipientType, String GoodsRecipientEndUserType, String GoodsRecipientOtherInfo) {
		if (GoodsRecipientSelectType.contains("Individual")) {
			clickElement(driver, test, OCR_GoodsRecipient_IndividualRadioBtn, "Click on Individual radio Button");
			clickElement(driver, test, OCR_GoodsRecipient_Individuallink, "click on Individual Link");
			addConsignee(GoodsRecIndConsigneeCode, GoodsRecIndStatus);
			typeText(driver, test, OCR_GoodsRecipientSection_IndividualTitle, "Enter Individual Title : ", GoodsRecTitle);
			typeText(driver, test, OCR_GoodsRecipientSection_IndividualSurname, "Enter Individual Surname : ",
					GoodsRecSurname);
			typeText(driver, test, OCR_GoodsLocationSection_IndividualEmailIdField, "Enter Individual Email Address : ",
					GoodsRecEmail);
			typeText(driver, test, OCR_GoodsLocationSection_IndividualTelephoneNo, "Enter Individual Telephone No : ",
					GoodsRecTelephone);
			Wait.waitfor(2);
			addOtherDetails(GoodsRecipientType, GoodsRecipientEndUserType, GoodsRecipientOtherInfo);
		} else {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsRecipient_OrganizationRadioBtn, "Click on Organisation Button");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsRecipient_OrganizationLink, "click on Organisation Link");
			addConsignee(GoodsRecOrgConsigneeCode, GoodsRecOrgStatus);
			typeText(driver, test, OCR_GoodsRecipient_OrganizationWebsiteAdd, "Add Website Address : ",
					GoodsRecWebAddress);
			Wait.waitfor(2);
			addOtherDetails(GoodsRecipientType, GoodsRecipientEndUserType, GoodsRecipientOtherInfo);
		}
	}

	public void addConsignee(String ConsigneeCode, String Status) {
		typeText(driver, test, OCR_GoodsRecipient_ConsigneeCode, "Enter Consignee Code : ", ConsigneeCode);
		selectByVisibleText(driver, test, OCR_GoodsRecipient_ConsigneeStatus, "select status from dropdown : ", Status);
		clickElement(driver, test, OCR_GoodsRecipient_ConsigneeSearchBtn, "click on Search Button");
		String Ccode = "//td[contains(text(),'" + ConsigneeCode + "')]";
		Wait.waitfor(4);
		clickElement(driver, test, Ccode, "Enter Consignee Code" + ConsigneeCode);
		clickElement(driver, test, OCR_GoodsRecipient_ConsigneeSelectBtn, "Click on select Button");
		Wait.waitfor(3);
	}

	public void addOtherDetails(String GoodsRecipientType, String GoodsRecipientEndUserType,
			String GoodsRecipientOtherInfo) {
		if (GoodsRecipientType.contains("Consignee")) {
			clickElement(driver, test, OCR_GoodsRecipient_TypesofRecipient_Consignee, "click on Consignee CheckBox");
		} else {
			clickElement(driver, test, OCR_GoodsRecipient_TypesofRecipient_EndUser, "Click on End USer");
			selectByVisibleText(driver, test, OCR_GoodsRecipient_EndUserDropDwn, "Select End User dropdown : ",
					GoodsRecipientEndUserType);
		}
		typeText(driver, test, OCR_GoodsRecipient_TypesofRecipient_OtherInfoTextBox, "Add OtherInfo : ",
				GoodsRecipientOtherInfo);
	}

	public void clickOnSaveReturn() {
		clickElement(driver, test, OCR_GoodsRecipient_SaveandReturn, "Click on Save and Return");
	}

	// validations in Goods Recepient Tab
	public void validateGoodsRecepientTypeError() {
		try {
			Wait.waitfor(3);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Type is required']")) {
					test.log(LogStatus.INFO, "Type is required");
				}
				clickElement(driver, test, OCR_GoodsRecipient_CloseBtn, "Close Good Recipient Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_GoodsRecipient_CloseBtn, "Close Good Recipient Pop up");
		}
	}

	// validations in Goods Recepient Tab
	public void validateGoodsRecepientTypeIndividualError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsRecipient_IndividualRadioBtn, "Click on Individual radio Button");
			clickElement(driver, test, OCR_GoodsRecipient_SaveandReturn, "Click on Save and Return");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Title is required.']")) {
					test.log(LogStatus.INFO, "Title is required");
				}
				if (isDisplayed(driver, "//li[text()='Forename is required.']")) {
					test.log(LogStatus.INFO, "Forename is required");
				}
				if (isDisplayed(driver, "//li[text()='Surname is required.']")) {
					test.log(LogStatus.INFO, "Surname is required");
				}
				if (isDisplayed(driver, "//li[text()='Address is required.']")) {
					test.log(LogStatus.INFO, "Address is required");
				}
				if (isDisplayed(driver, "//li[text()='Country is required.']")) {
					test.log(LogStatus.INFO, "Country is required");
				}
				if (isDisplayed(driver, "//li[text()='Email Address is required.']")) {
					test.log(LogStatus.INFO, "Email Address is  required");
				}
				if (isDisplayed(driver, "//li[text()='Telephone No is required.']")) {
					test.log(LogStatus.INFO, "Telephone No is required");
				}
				clickElement(driver, test, OCR_GoodsRecipient_CloseBtn, "Close Good Recipient Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_GoodsRecipient_CloseBtn, "Close Good Recipient Pop up");
		}
	}

	// validations in Goods Recepient Tab
	public void validateGoodsRecepientTypeOrganizationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsRecipient_OrganizationRadioBtn, "Click on Organisation Button");
			clickElement(driver, test, OCR_GoodsRecipient_SaveandReturn, "Click on Save and Return");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Organization Name is required.']")) {
					test.log(LogStatus.INFO, "Organization Name is required");
				}
				if (isDisplayed(driver, "//li[text()='Address is required.']")) {
					test.log(LogStatus.INFO, "Address is required");
				}
				if (isDisplayed(driver, "//li[text()='Country is required.']")) {
					test.log(LogStatus.INFO, "Country is required");
				}
				clickElement(driver, test, OCR_GoodsRecipient_CloseBtn, "Close Good Recipient Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_GoodsRecipient_CloseBtn, "Close Good Recipient Pop up");
		}
	}

}
