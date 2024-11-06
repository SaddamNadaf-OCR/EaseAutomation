package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class OtherThirdPartyDocumentsUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/******************************** Locators ************************************/

	public static final String OCR_OtherThirdPartyTab = "//i[@id='OTHER_THIRD_PARTY']";
	public static final String OCR_OtherPartySection_AddOtherPartiesBtn = "//button[@id='addOtherThirdParty']";
	public static final String OCR_OtherPartySection_AddOtherPartySectionBtn = "//button[@id='addOtherThirdParty']";
	public static final String OCR_OtherPartySection_IndividualRadioBtn = "//input[@id='typeFlagI']";
	public static final String OCR_OtherPartySection_Individuallink = "//b[contains(text(),'Individual')]";
	public static final String OCR_OtherPartySection_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_OtherPartySection_ConsigneeSearchBtn = "//button[@name='Search']";
	public static final String OCR_OtherPartySection_ConsigneeSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_OtherPartySection_Title = "//input[@id='licConsTitle']";
	public static final String OCR_OtherPartySection_Surname = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsSurname']";
	public static final String OCR_OtherPartySection_Email = "//input[@id='editThirdPartySection_licUkAuthCnsigneeMailIdValues_0__itemDesc']";
	public static final String OCR_OtherPartySection_Telephone = "//input[@id='editThirdPartySection_licUkAuthCnsigneePhoneValues_0__itemDesc']";
	public static final String OCR_OtherPartySection_DescriptionofRole = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsRole']";
	public static final String OCR_OtherPartySection_TypesofRecipient_Consignee = "//input[@id='consignee']";
	public static final String OCR_OtherPartySection_TypesofRecipient_EndUser = "//input[@id='endUser']";
	public static final String OCR_OtherPartySection_TypesofRecipient_OtherInfoTextBox = "//textarea[@id='editThirdPartySection_authorisationConsigneeValue_licConsOtherInfo']";
	public static final String OCR_OtherPartySection_TypesofRecipient_ConsigneeEmailId = "//input[@id='editThirdPartySection_licUkAuthCnsigneeMailIdValues_0__itemDesc']";
	public static final String OCR_OtherPartySection_TypesofRecipient_ConsigneePhoneNo = "//input[@id='editThirdPartySection_licUkAuthCnsigneePhoneValues_0__itemDesc']";
	public static final String OCR_OtherPartySection_OrganizationRadioBtn = "//input[@id='typeFlagO']";
	public static final String OCR_OtherPartySection_OrganizationLink = "//b[contains(text(),'Organization')]";
	public static final String OCR_OtherPartySection_NatureofBusiness = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsBusinessNature']";
	public static final String OCR_OtherPartySection_Save = "//button[@id='save']";
	public static final String OCR_OtherPartySection_EditIcon = "//i[@class='fa fa-edit']";
	public static final String OCR_OtherPartySection_DeleteIcon = "//i[@class='fa fa-trash-o']";
	public static final String OCR_OtherPartySection_SaveandReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_OtherPartySection_AddMore = "//button[@id='AddMore']";
	public static final String OCR_OtherPartySection_CloseBtn = "//input[@id='cancelPopup']";

	/* ************************ Constructor ********************** */

	public OtherThirdPartyDocumentsUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	public void clickOnOtherThirdPartyTab() {
		clickElement(driver, test, OCR_OtherThirdPartyTab, "Click on Other Third Party Tab");
	}

	// click on other third party
	public void clickonotherthirdparty() {
		clickElement(driver, test, OCR_OtherPartySection_AddOtherPartySectionBtn, "click on other third parties");
	}

	// select individual radio button
	public void selectIndividual(String OtherPartySelectType, String OtherPartyIndivConsigneeCode,
			String OtherPartyTitle, String OtherPartySurname, String OtherPartyEmail, String OtherPartyTelephone,
			String OtherPartyOrgConsigneeCode, String NatureofBusiness, String OtherPartyDescriptionOfRole,
			String OtherPartyOtherInfo) {
		if (OtherPartySelectType.contains("Individual")) {
			clickElement(driver, test, OCR_OtherPartySection_IndividualRadioBtn, "select individual as type");
			clickElement(driver, test, OCR_OtherPartySection_Individuallink, "click on individual link");
			searchConsignee(OtherPartyIndivConsigneeCode);
			typeText(driver, test, OCR_OtherPartySection_Title, "enter the Other Party title : ", OtherPartyTitle);
			typeText(driver, test, OCR_OtherPartySection_Surname, "enter the Other Party surname", OtherPartySurname);
			typeText(driver, test, OCR_OtherPartySection_Email, "Enter the Other Party  Email Address ",
					OtherPartyEmail);
			typeText(driver, test, OCR_OtherPartySection_Telephone, "Enter the Other Party Telephone No ",
					OtherPartyTelephone);
			Wait.waitfor(2);
			addOtherDetails(OtherPartyDescriptionOfRole, OtherPartyOtherInfo);
		} else {
			clickElement(driver, test, OCR_OtherPartySection_OrganizationRadioBtn, "select Organization as type");
			clickElement(driver, test, OCR_OtherPartySection_OrganizationLink, "click on Organization link");
			searchConsignee(OtherPartyOrgConsigneeCode);
			typeText(driver, test, OCR_OtherPartySection_NatureofBusiness, "Add nanature of business : ",
					NatureofBusiness);
			addOtherDetails(OtherPartyDescriptionOfRole, OtherPartyOtherInfo);
		}
	}

	// selecting the search Consignee pop up and add value to title, surname &
	public void searchConsignee(String consigneeCode) {
		typeText(driver, test, OCR_OtherPartySection_ConsigneeCode, "Enter the consignee code : ", consigneeCode);
		clickElement(driver, test, OCR_OtherPartySection_ConsigneeSearchBtn, "click on search button");
		String consignee = "//td[contains(text(),'" + consigneeCode + "')]";
		clickElement(driver, test, consignee, "Selected Consignee Code :" + consigneeCode);
		clickElement(driver, test, OCR_OtherPartySection_ConsigneeSelectBtn, "Click on Select Button");
		Wait.waitfor(3);
	}

	// Description of Role
	public void addOtherDetails(String DescriptionofRole, String OtherInfo) {
		typeText(driver, test, OCR_OtherPartySection_DescriptionofRole, "Enter description of role : ",
				DescriptionofRole);
		typeText(driver, test, OCR_OtherPartySection_TypesofRecipient_OtherInfoTextBox, "Add OtherInfo : ", OtherInfo);
	}

	// Perform save & return for Individual
	public void click_SaveAndReturn() {
		clickElement(driver, test, OCR_OtherPartySection_SaveandReturn, "save and return");
	}

	// validations in Other Third Party Tab
	public void validateOtherThirdPartyTypeError() {
		try {
			Wait.waitfor(3);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Type is required']")) {
					test.log(LogStatus.INFO, "Type is required");
				}
				if (isDisplayed(driver, "//li[text()='Description of Role is required.']")) {
					test.log(LogStatus.INFO, "Description of Role is required.");
				}
				clickElement(driver, test, OCR_OtherPartySection_CloseBtn, "Close Other Third Party Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_OtherPartySection_CloseBtn, "Close Other Third Party Pop up");
		}
	}

	// validations in Other Third Party Tab
	public void validateOtherThirdPartyIndividualError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_OtherPartySection_IndividualRadioBtn, "Click on Individual radio Button");
			clickElement(driver, test, OCR_OtherPartySection_SaveandReturn, "Click on Save and Return");
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
				if (isDisplayed(driver, "//li[text()='Description of Role is required.']")) {
					test.log(LogStatus.INFO, "Description of Role is required.");
				}
				clickElement(driver, test, OCR_OtherPartySection_CloseBtn, "Close Other Third Party Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_OtherPartySection_CloseBtn, "Close Other Third Party Pop up");
		}
	}

	// validations in Other Third Party Tab
	public void validateOtherThirdPartyOrganizationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_OtherPartySection_OrganizationRadioBtn, "Click on Organisation Button");
			clickElement(driver, test, OCR_OtherPartySection_SaveandReturn, "Click on Save and Return");
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
				if (isDisplayed(driver, "//li[text()='Description of Role is required.']")) {
					test.log(LogStatus.INFO, "Description of Role is required.");
				}
				clickElement(driver, test, OCR_OtherPartySection_CloseBtn, "Close Other Third Party Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_OtherPartySection_CloseBtn, "Close Other Third Party Pop up");
		}
	}

}
