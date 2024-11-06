package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class UltimateEndUserUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/************************** Locators ***********************/
	public static final String OCR_UltimateEndUsersTab = "//i[@id='ULTI_ENDUS']";
	public static final String OCR_UltimateEndUser_AddUltimateEndUserBtn = "//input[@id='addEndUse']";
	public static final String OCR_UltimateEndUser_IndividualRadioBtn = "//input[@id='typeFlagI']";
	public static final String OCR_UltimateEndUser_Individuallink = "//b[contains(text(),'Individual')]";
	public static final String OCR_UltimateEndUser_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_UltimateEndUser_ConsigneeStatus = "//select[@id='searchForm_consignee_status']";
	public static final String OCR_UltimateEndUser_ConsigneeSearchBtn = "//button[@name='Search']";
	public static final String OCR_UltimateEndUser_ConsigneeSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_UltimateEndUser_TypesofRecipient_Consignee = "//input[@id='consignee']";
	public static final String OCR_UltimateEndUser_TypesofRecipient_EndUser = "//input[@id='endUser']";
	public static final String OCR_UltimateEndUser_TypesofRecipient_OtherInfoTextBox = "//textarea[@id='editThirdPartySection_authorisationConsigneeValue_licConsOtherInfo']";
	public static final String OCR_UltimateEndUser_TypesofRecipient_Title = "//input[@id='licConsTitle']";
	public static final String OCR_UltimateEndUser_TypesofRecipient_Surname = "//input[@id='editUltimateEndUseSection_authorisationConsigneeValue_licConsSurname']";
	public static final String OCR_UltimateEndUser_TypesofRecipient_ConsigneeEmailId = "//input[@id='editUltimateEndUseSection_licUkAuthCnsigneeMailIdValues_0__itemDesc']";
	public static final String OCR_UltimateEndUser_TypesofRecipient_ConsigneePhoneNo = "//input[@id='editUltimateEndUseSection_licUkAuthCnsigneePhoneValues_0__itemDesc']";
	public static final String OCR_UltimateEndUser_OrganizationRadioBtn = "//input[@id='typeFlagO']";
	public static final String OCR_UltimateEndUser_OrganizationLink = "//b[contains(text(),'Organization')]";
	public static final String OCR_UltimateEndUser_OrganizationNatureofBusiness = "//input[@id='editUltimateEndUseSection_authorisationConsigneeValue_licConsBusinessNature']";
	public static final String OCR_UltimateEndUser_OrganizationWebsiteAddrs = "//input[@id='editUltimateEndUseSection_authorisationConsigneeValue_licConsWebsite']";
	public static final String OCR_UltimateEndUser_Save = "//button[@id='save']";
	public static final String OCR_UltimateEndUser_SaveandReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_UltimateEndUser_AddMore = "//button[@id='AddMore']";
	public static final String OCR_UltimateEndUser_CloseBtn = "//input[@id='cancelPopup']";
	public static final String OCR_UltimateEndUser_OtherInfo = "//textarea[@id='editUltimateEndUseSection_authorisationConsigneeValue_licConsOtherInfo']";

	/****************** Constructor ***************/
	public UltimateEndUserUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickOnUltimateEndUsersTab() {
		clickElement(driver, test, OCR_UltimateEndUsersTab, "Click on Ultimate EndUsers Tab");
	}

	public void addUltimateEndUSer() {
		clickElement(driver, test, OCR_UltimateEndUser_AddUltimateEndUserBtn, "Click on Add Ultimate End User Button");
		Wait.waitfor(4);
	}

	public void addNewUltimateEndUSer(String UltimateUserSelectType, String UltimateIndConsigneeCode, String UltimateIndStatus, String UltimateUserTitle,
			String UltimateUserSurname, String UltimateUserEmailId, String UltimateUserTelephoneNo, String UltimateOrgConsigneeCode, String UltimateOrgStatus,
			String UltimateUserNatureBusiness, String UltimateUserWebAddress, String UltimateUserOtherInfo) {
		if (UltimateUserSelectType.contains("Individual")) {
			clickElement(driver, test, OCR_UltimateEndUser_IndividualRadioBtn, "Click on Individual radio Button");
			clickElement(driver, test, OCR_UltimateEndUser_Individuallink, "click on Individual Link");
			addConsignee(UltimateIndConsigneeCode, UltimateIndStatus);
			Wait.waitfor(2);
			typeText(driver, test, OCR_UltimateEndUser_TypesofRecipient_Title, "Enter the Individual Title : ", UltimateUserTitle);
			typeText(driver, test, OCR_UltimateEndUser_TypesofRecipient_Surname, "Enter the Individual Surname : ", UltimateUserSurname);
			Wait.waitfor(2);
			typeText(driver, test, OCR_UltimateEndUser_TypesofRecipient_ConsigneeEmailId, "Enter the Email Address : ", UltimateUserEmailId);
			typeText(driver, test, OCR_UltimateEndUser_TypesofRecipient_ConsigneePhoneNo, "Enter the Telephone No : ",	UltimateUserTelephoneNo);
			addOtherInfo(UltimateUserOtherInfo);
		} else {
			clickElement(driver, test, OCR_UltimateEndUser_OrganizationRadioBtn, "Click on Organisation Button");
			clickElement(driver, test, OCR_UltimateEndUser_OrganizationLink, "click on Organisation Link");
			addConsignee(UltimateOrgConsigneeCode, UltimateOrgStatus);
			Wait.waitfor(2);
			typeText(driver, test, OCR_UltimateEndUser_OrganizationNatureofBusiness, "Enter the  Nature of Business : ", UltimateUserNatureBusiness);
			typeText(driver, test, OCR_UltimateEndUser_OrganizationWebsiteAddrs, "Enter the  Website Address : ", UltimateUserWebAddress);
			Wait.waitfor(2);
			addOtherInfo(UltimateUserOtherInfo);
		}
	}

	public void addConsignee(String ConsigneeCode, String Status) {
		typeText(driver, test, OCR_UltimateEndUser_ConsigneeCode, "Enter the  Consignee Code : ", ConsigneeCode);
		selectByVisibleText(driver, test, OCR_UltimateEndUser_ConsigneeStatus, "Select the status from dropdown : ", Status);
		clickElement(driver, test, OCR_UltimateEndUser_ConsigneeSearchBtn, "click on Search Button");
		String Ccode = "//td[contains(text(),'" + ConsigneeCode + "')]";
		clickElement(driver, test, Ccode, "Enter Consignee Code" + ConsigneeCode);
		clickElement(driver, test, OCR_UltimateEndUser_ConsigneeSelectBtn, "Click on select Button");
	}

	public void addOtherInfo(String OtherInfo) {
		typeText(driver, test, OCR_UltimateEndUser_OtherInfo, "Enter the  other Info Text : ", OtherInfo);
	}

	public void clickOnSaveReturn() {
		clickElement(driver, test, OCR_UltimateEndUser_SaveandReturn, "click on save and Return");
	}

	// validations in Ultimate End Users Tab
	public void validateUltimateEndUsersTypeError() {
		try {
			Wait.waitfor(3);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Type is mandatory!']")) {
					test.log(LogStatus.INFO, "Type is mandatory");
				}
				clickElement(driver, test, OCR_UltimateEndUser_CloseBtn, "Close Ultimate End Users Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_UltimateEndUser_CloseBtn, "Close Ultimate End Users Pop up");
		}
	}

	// validations in Ultimate End Users Tab
	public void validateUltimateEndUsersIndividualError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_UltimateEndUser_IndividualRadioBtn, "Click on Individual radio Button");
			clickElement(driver, test, OCR_UltimateEndUser_SaveandReturn, "Click on Save and Return");
			Wait.waitfor(3);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Title is mandatory.']")) {
					test.log(LogStatus.INFO, "Title is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Forename is mandatory.']")) {
					test.log(LogStatus.INFO, "Forename is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Surname is mandatory.']")) {
					test.log(LogStatus.INFO, "Surname is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Address is mandatory.']")) {
					test.log(LogStatus.INFO, "Address is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Country is mandatory.']")) {
					test.log(LogStatus.INFO, "Country is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Email Address cannot be blank.']")) {
					test.log(LogStatus.INFO, "Email Address cannot be blank.");
				}
				if (isDisplayed(driver, "//li[text()='Telephone No cannot be blank.']")) {
					test.log(LogStatus.INFO, "Telephone No cannot be blank");
				}
				clickElement(driver, test, OCR_UltimateEndUser_CloseBtn, "Close Ultimate End Users Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_UltimateEndUser_CloseBtn, "Close Ultimate End Users Pop up");
		}
	}

	// validations in Ultimate End Users Tab
	public void validateUltimateEndUsersOrganizationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_UltimateEndUser_OrganizationRadioBtn, "Click on Organization radio Button");
			clickElement(driver, test, OCR_UltimateEndUser_SaveandReturn, "Click on Save and Return");
			Wait.waitfor(3);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Organization Name is mandatory.']")) {
					test.log(LogStatus.INFO, "Organization Name is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Address is mandatory.']")) {
					test.log(LogStatus.INFO, "Address is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Country is mandatory.']")) {
					test.log(LogStatus.INFO, "Country is mandatory");
				}
				if (isDisplayed(driver, "//li[text()='Nature of Business  is mandatory.']")) {
					test.log(LogStatus.INFO, "Nature of Business is mandatory");
				}
				clickElement(driver, test, OCR_UltimateEndUser_CloseBtn, "Close Ultimate End Users Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_UltimateEndUser_CloseBtn, "Close Ultimate End Users Pop up");
		}
	}
}
