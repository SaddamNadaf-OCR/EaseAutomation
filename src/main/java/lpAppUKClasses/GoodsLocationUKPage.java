package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class GoodsLocationUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/********************* Locators **********************************/
	public static final String OCR_GoodsLocationTab = "//i[@id='GLS']";
	public static final String OCR_GoodsLocationSection_CountryScroller = "//a[@id='a']";
	public static final String OCR_GoodsLocationSection_AddCountryButton = "//button[@id='addCountryBtn']";
	public static final String OCR_GoodsLocationSection_SelectCountry = "//select[@id='createNewCountry_totalCountries']";
	public static final String OCR_GoodsLocationSection_MoveCountryRight = "//button[@name='move-right']";
	public static final String OCR_GoodsLocationSection_MoveCountryLeft = "//button[@name='move-left']";
	public static final String OCR_GoodsLocationSection_CountrySaveandReturnButton = "//button[@name='saveAndReturn']";
	public static final String OCR_GoodsLocationSection_CountrySaveBtn = "//button[@name='save']";
	public static final String OCR_GoodsLocationSection_CountryCancelBtn = "//button[@id='cancelPopup']";
	public static final String OCR_GoodsLocationSection_AddIndividualOrganisationBtn = "//button[@id='addIndividualOrganization']";
	public static final String OCR_GoodsLocationSection_AddIndividualOrganisation_IndividualTypeRadioBtn = "//input[@id='typeFlagI']";
	public static final String OCR_GoodsLocationSection_AddIndividualOrganisation_OrganizationTypeRadioBtn = "//input[@id='typeFlagO']";
	public static final String OCR_GoodsLocationSection_IndividualLink = "//b[contains(text(),'Individual')]";
	public static final String OCR_GoodsLocationSection_IndividualStatus = "//select[@id='searchForm_consignee_status']";
	public static final String OCR_GoodsLocationSection_IndividualConsigneeIdCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_GoodsLocationSection_IndividualTitle = "//input[@id='licConsTitle']";
	public static final String OCR_GoodsLocationSection_IndividualForename = "//input[@id='licIndConsName']";
	public static final String OCR_GoodsLocationSection_IndividualSurname = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsSurname']";
	public static final String OCR_GoodsLocationSection_IndividualAddress = "//div[@id='personalDetails']//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsAddr1']";
	public static final String OCR_GoodsLocationSection_IndividualCountry = "//div[@id='personalDetails']//input[@id='country']";
	public static final String OCR_GoodsLocationSection_IndividualSearchBtn = "//form[@id='searchForm']//button[@name='Search'][contains(text(),'Search')]";
	public static final String OCR_GoodsLocationSection_IndividualSelectBtn = "//div[@id='content-cont']//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GoodsLocationSection_IndividualEmailIdField = "//input[@id='editThirdPartySection_licUkAuthCnsigneeMailIdValues_0__itemDesc']";
	public static final String OCR_GoodsLocationSection_IndividualTelephoneNo = "//input[@id='editThirdPartySection_licUkAuthCnsigneePhoneValues_0__itemDesc']";
	public static final String OCR_GoodsLocationSection_IndividualotherInfo = "//textarea[@id='editThirdPartySection_authorisationConsigneeValue_licConsOtherInfo']";
	public static final String OCR_GoodsLocationSection_IndividualSaveandReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_GoodsLocationSection_IndividualSaveBtn = "//button[@id='save']";
	public static final String OCR_GoodsLocationSection_IndividualCloseBtn = "//input[@id='cancelPopup']";
	public static final String OCR_GoodsLocationSection_IndividualAddMoreBtn = "//button[@id='AddMore']";
	public static final String OCR_GoodsLocationSection_OrganizationLink = "//b[contains(text(),'Organization')]";
	public static final String OCR_GoodsLocationSection_OrganizationConsigneeIdCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_GoodsLocationSection_OrganizationSearchBtn = "//button[@name='Search']";
	public static final String OCR_GoodsLocationSection_OrganizationSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GoodsLocationSection_OrganizationNatureofBusiness = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsBusinessNature']";
	public static final String OCR_GoodsLocationSection_OrganizationWebsiteAddress = "//input[@id='editThirdPartySection_authorisationConsigneeValue_licConsWebsite']";
	public static final String OCR_GoodsLocationSection_OrganizationotherInfo = "//textarea[@id='editThirdPartySection_authorisationConsigneeValue_licConsOtherInfo']";
	public static final String OCR_GoodsLocationSection_OrganizationSave = "//button[@id='save']";
	public static final String OCR_GoodsLocationSection_OrganizationSaveandReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_GoodsLocationSection_OrganizationAddMore = "//button[@id='AddMore']";
	public static final String OCR_GoodsLocationSection_OrganizationCloseBtn = "//button[@id='btnClose']";
	public static final String OCR_GoodsLocationSection_GoodsRecipient = "//i[@id='GRS']";

	/********** constructor **********/
	public GoodsLocationUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickGoodsLocationTab() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_GoodsLocationTab, "Click on Goods Location Tab");
	}

	public void clickOnAddCountry() {
		clickElement(driver, test, OCR_GoodsLocationSection_AddCountryButton, "click on Add Country Button");
	}

	// Add country details
	public void addCountry(String GoodsLocationCountryName) {
		Wait.waitfor(4);
		try {
			String country = "//option[contains(text(),'" + GoodsLocationCountryName + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, country, "Select Goods Location Country : " + GoodsLocationCountryName);
			Wait.waitfor(4);
			clickElement(driver, test, OCR_GoodsLocationSection_MoveCountryRight, "Click on move Right");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsLocationSection_CountrySaveandReturnButton,
					"click on Create new country Save and return");
			Wait.waitfor(4);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GoodsLocationSection_CountryCancelBtn, "click on country Cancel button");
		}
	}

	public void clickOnAddIndvidualOrganisation() {
		clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisationBtn,
				"Click on Add Individual Organisation Button");
	}

	public void selectType(String GoodsLocationSelectType, String GoodsLocIndConsigneeCode, String GoodsLocIndStatus,
			String GoodsLocTitle,String GoodsForeName, String GoodsLocSurname, String GoodsLocEmail, String GoodsLocTelephone,
			String GoodsLocIndivotherInfo, String GoodsLocOrgConsigneeCode, String GoodsLocOrgStatus,
			String GoodsLocNatureofBusiness, String GoodsLocWebAddress, String GoodsLocOrgotherInfo) {
		try {
			if (GoodsLocationSelectType.contains("Individual")) {
				clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisation_IndividualTypeRadioBtn,
						"Click on Individual radio Button");
				clickElement(driver, test, OCR_GoodsLocationSection_IndividualLink, "click on Individual Link");
				addConsignee(GoodsLocIndConsigneeCode, GoodsLocIndStatus);
				Wait.waitfor(3);
				typeText(driver, test, OCR_GoodsLocationSection_IndividualTitle, "Enter Individual Title ",
						GoodsLocTitle);
				typeText(driver, test, OCR_GoodsLocationSection_IndividualForename, "Enter the ForeName : ", GoodsForeName);
				typeText(driver, test, OCR_GoodsLocationSection_IndividualSurname, "Enter Individual Surname ",
						GoodsLocSurname);
				typeText(driver, test, OCR_GoodsLocationSection_IndividualEmailIdField,
						"Enter Individual Email Address ", GoodsLocEmail);
				typeText(driver, test, OCR_GoodsLocationSection_IndividualTelephoneNo, "Enter Individual Telephone No ",
						GoodsLocTelephone);
				Wait.waitfor(2);
				addOtherDetails(GoodsLocIndivotherInfo);
			} else {
				clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisation_OrganizationTypeRadioBtn,
						"Click on Organisation Button");
				clickElement(driver, test, OCR_GoodsLocationSection_OrganizationLink, "click on Organisation Link");
				addConsignee(GoodsLocOrgConsigneeCode, GoodsLocOrgStatus);
				Wait.waitfor(3);
				typeText(driver, test, OCR_GoodsLocationSection_OrganizationNatureofBusiness, "Add Nature of Business",
						GoodsLocNatureofBusiness);
				typeText(driver, test, OCR_GoodsLocationSection_OrganizationWebsiteAddress, "Add Website Address",
						GoodsLocWebAddress);
				addOtherDetails(GoodsLocOrgotherInfo);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GoodsLocationSection_OrganizationCloseBtn, "click on Pop up close");
		}
	}

	public void addConsignee(String ConsigneeCode, String Status) {
		typeText(driver, test, OCR_GoodsLocationSection_IndividualConsigneeIdCode, "Enter Consignee Code",
				ConsigneeCode);
		selectByVisibleText(driver, test, OCR_GoodsLocationSection_IndividualStatus, "select status from dropdown",
				Status);
		clickElement(driver, test, OCR_GoodsLocationSection_IndividualSearchBtn, "click on Search Button");
		String Ccode = "//td[contains(text(),'" + ConsigneeCode + "')]";
		clickElement(driver, test, Ccode, "Enter Consignee Code" + ConsigneeCode);
		clickElement(driver, test, OCR_GoodsLocationSection_IndividualSelectBtn, "Click on select Button");
		Wait.waitfor(3);
	}

	public void addOtherDetails(String otherInfo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_GoodsLocationSection_IndividualotherInfo, "Enter other details", otherInfo);
	}

	public void clickOnsaveReturnButton() {
		scrollToBottom(driver);
		clickElement(driver, test, OCR_GoodsLocationSection_OrganizationSaveandReturn,
				"Click on Save and Return Button");
	}

	public void clickOnGoodsRecipient() {
		clickElement(driver, test, OCR_GoodsLocationSection_GoodsRecipient, "Click on Good Recipient Icon");
	}

	// validations in Goods Location Country Tab
	public void validateGoodsLocationCountryError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsLocationSection_AddCountryButton, "Click on Add Country Button");
			clickElement(driver, test, OCR_GoodsLocationSection_CountrySaveBtn, "Click on Save Button");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Error!  Please select at least one country']")) {
					test.log(LogStatus.INFO, "Please select at least one country");
				}
				clickElement(driver, test, OCR_GoodsLocationSection_CountryCancelBtn, "Click on Cancel Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

	// validations in Goods Location Tab
	public void validateGoodsLocationtTypeError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisationBtn,
					"Click on Add Individual Organisation Button");
			clickElement(driver, test, OCR_GoodsLocationSection_IndividualSaveBtn, "Click on Save Button");
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Type is required']")) {
					test.log(LogStatus.INFO, "Type is required");
				}
				clickElement(driver, test, OCR_GoodsLocationSection_IndividualCloseBtn, "Close Good Recipient Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_GoodsLocationSection_IndividualCloseBtn, "Close Good Recipient Pop up");
		}
	}

	// validations in Goods Location Tab
	public void validateGoodsLocationTypeIndividualError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisationBtn,
					"Click on Add Individual Organisation Button");
			clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisation_IndividualTypeRadioBtn,
					"Click on Individual radio Button");
			clickElement(driver, test, OCR_GoodsLocationSection_IndividualSaveBtn, "Click on Save and Return");
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
				clickElement(driver, test, OCR_GoodsLocationSection_IndividualCloseBtn, "Close Goods Location Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_GoodsLocationSection_IndividualCloseBtn, "Close Goods Location Pop up");
		}
	}

	// validations in Goods Location Tab
	public void validateGoodsLocationTypeOrganizationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisationBtn,
					"Click on Add Individual Organisation Button");
			clickElement(driver, test, OCR_GoodsLocationSection_AddIndividualOrganisation_OrganizationTypeRadioBtn,
					"Click on Organization radio Button");
			clickElement(driver, test, OCR_GoodsLocationSection_IndividualSaveBtn, "Click on Save and Return");
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
				clickElement(driver, test, OCR_GoodsLocationSection_IndividualCloseBtn, "Close Goods Location Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_GoodsLocationSection_IndividualCloseBtn, "Close Goods Location Pop up");
		}
	}

}
