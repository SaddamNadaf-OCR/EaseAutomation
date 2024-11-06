package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ContactSectionUKPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/********************************************
	 * Locators
	 ***********************************************/
	public static final String OCR_ContactSectionTab = "//i[@id='CONTACT']";
	public static final String OCR_ContactSection_IndividualRadio = "//input[@id='typeFlagCLI']";
	public static final String OCR_ContactSection_ContactLink = "//fieldset[@id='individuals']//a[contains(text(),'Contact')]";
	public static final String OCR_ContactSection_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_ContactSection_ExporterSearchButton = "//button[@name='Search']";
	public static final String OCR_ContactSection_ExporterSelectButton = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ContactSection_ExporterEmailAddress = "//input[@id='editUKcontactDetails_licUkAuthCnsigneeMailIdValues_0__indItemDesc']";
	public static final String OCR_ContactSection_ExporterTelephoneNo = "//input[@id='editUKcontactDetails_licUkAuthCnsigneePhoneValues_0__indItemDesc']";
	public static final String OCR_ContactSection_ExporterotherInfo = "//textarea[@id='editUKcontactDetails_authorisationAddressValue_licOwnerOtherInfo']";
	public static final String OCR_ContactSection_IndivotherInfoScroller = "//fieldset[@id='individuals']//label[contains(text(),'Other Details')]";
	public static final String OCR_ContactSection_IndivOtherDetails = "//textarea[@id='editUKcontactDetails_authorisationAddressValue_licOwnerOtherInfo']";
	public static final String OCR_ContactSection_ExporterSaveBtn = "//input[@id='submitAppl']";
	public static final String OCR_ContactSection_ExporterStatus = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_ContactSection_ExporterOrganisationWithContactRadioBtn = "//input[@id='typeFlagCLO']";
	public static final String OCR_ContactSection_ExporterOrganisationWithContactLink = "//a[contains(text(),'Organisation With Contact')]";
	public static final String OCR_ContactSection_ExporterOrganisation_NatureOfBusiness = "//input[@id='natureToolTip']";
	public static final String OCR_ContactSection_ExporterOrganisation_WebSiteAddress = "//input[@id='editUKcontactDetails_authorisationAddressValue_licAddrWebsite']";
	public static final String OCR_ContactSection_IndividualTitle = "//input[@id='editUKcontactDetails_authorisationAddressValue_licAddrPostionTitle']";
	public static final String OCR_ContactSection_IndividualMiddleInitials = "//input[@id='editUKcontactDetails_authorisationAddressValue_licAddrMName']";
	public static final String OCR_ContactSection_IndividualSurName = "//input[@id='editUKcontactDetails_authorisationAddressValue_licAddrLastName']";
	public static final String OCR_ContactSection_IndividualEmail = "//input[@id='editUKcontactDetails_licUkAuthCnsigneeMailIdValues_0__indItemDesc']";
	public static final String OCR_ContactSection_IndividualTelephone = "//input[@id='editUKcontactDetails_licUkAuthCnsigneePhoneValues_0__indItemDesc']";
	public static final String OCR_ContactSection_OrganPersonDetailScroll = "//a[@class='accordion-toggle']//label[contains(text(),'Person Details')]";
	public static final String OCR_ContactSection_ExporterOrganisation_ContactLink = "//a[@id='contactIdLink']";
	public static final String OCR_ContactSection_Exporter_ContactSearchBtn = "//button[@name='Search']";
	public static final String OCR_ContactSection_Exporter_ContactSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ContactSection_Exporter_ContactTitle = "//input[@id='editUKcontactDetails_authorisationAddressValue_licOwnerOrgRegAddressPostionTitle']";
	public static final String OCR_ContactSection_Exporter_ContactJobTitle = "//input[@id='editUKcontactDetails_authorisationAddressValue_licOwnerOrgRegAddressJob']";
	public static final String OCR_ContactSection_Exporter_ContactAddress = "//input[@id='editUKcontactDetails_authorisationAddressValue_licOwnerOrgRegAddress1']";
	public static final String OCR_ContactSection_Exporter_Country = "//input[@id='editUKcontactDetails_authorisationAddressValue_licOwnerOrgRegAddressCountryName']";
	public static final String OCR_ContactSection_Exporter_Telephone = "//input[@id='editUKcontactDetails_licUkAuthCnsigneePhoneValuesOrg_0__orgItemDesc']";
	public static final String OCR_ContactSection_Exporter_ContactEmailAddress = "//input[@id='editUKcontactDetails_licUkAuthCnsigneeMailIdValuesOrg_0__orgItemDesc']";
	public static final String OCR_ContactSection_Exporter_ContactTelephoneNo = "//input[@id='editUKcontactDetails_licUkAuthCnsigneePhoneValuesOrg_0__orgItemDesc']";
	public static final String OCR_ContactSection_OrganisationotherInfoScroller = "(//label[contains(text(),'Other Details')])[1]";
	public static final String OCR_ContactSection_OrganisationOtherDetails = "//textarea[@id='editUKcontactDetails_authorisationAddressValue_licAddrOthInfo']";
	public static final String OCR_ContactSection_ExportGoodSection = "//li[@id='5']//a";

	/************************* Constructor ***********************/
	public ContactSectionUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/********************** Actions **************************/

	public void clickOnContactSectionTab() {
		clickElement(driver, test, OCR_ContactSectionTab, "Click on Contact Section Tab");
	}

	public void selectContactType(String ContactSelectType, String ContactIndivStatus, String ContactIndivExporterCode,
			String ContactIndivTitle, String ContactIndivMidIntials, String ContactIndivSurName,
			String ContactIndivEmailAddress, String ContactIndivTelephone, String ContactIndivotherInfo,
			String ContactOrganisationStatus, String ContactOrganisationExporterCode, String ContactNatureOfBusines,
			String ContactWebAddress, String PersonalOrganisationContact, String ContactOrganisationTitle,
			String ContactOrganisationAddress, String ContactOrganisationJobTitle, String ContactOrganisationEmailId,
			String ContactOrganisationCountry, String ContactOrganisationTelephone,
			String ContactOrganisationotherInfo) {
		if (ContactSelectType.contains("Individual")) {
			clickElement(driver, test, OCR_ContactSection_IndividualRadio, "Click on Individual Radio Button");
			clickElement(driver, test, OCR_ContactSection_ContactLink, "Click on Contact Link");
			Wait.waitfor(3);
			addExporterPopUp(ContactIndivStatus, ContactIndivExporterCode);
			typeText(driver, test, OCR_ContactSection_IndividualTitle, "Add Individual Title : ", ContactIndivTitle);
			typeText(driver, test, OCR_ContactSection_IndividualMiddleInitials, "Add Individual Midle Initials : ",
					ContactIndivMidIntials);
			typeText(driver, test, OCR_ContactSection_IndividualSurName, "Add Individual Surname : ",
					ContactIndivSurName);
			typeText(driver, test, OCR_ContactSection_IndividualEmail, "Add Individual Email Address : ",
					ContactIndivEmailAddress);
			typeText(driver, test, OCR_ContactSection_IndividualTelephone, "Add Individual Email Address :  ",
					ContactIndivTelephone);
			Wait.waitfor(3);
			addIndivOtherInfo(ContactIndivotherInfo);
		} else {
			clickElement(driver, test, OCR_ContactSection_ExporterOrganisationWithContactRadioBtn,
					"click on Organization Radio Button");
			clickElement(driver, test, OCR_ContactSection_ExporterOrganisationWithContactLink,
					"Click Organisation Contact Link");
			addExporterPopUp(ContactOrganisationStatus, ContactOrganisationExporterCode);
			Wait.waitfor(3);
			typeText(driver, test, OCR_ContactSection_ExporterOrganisation_NatureOfBusiness,
					"Add Nature of Business : ", ContactNatureOfBusines);
			typeText(driver, test, OCR_ContactSection_ExporterOrganisation_WebSiteAddress, "Add Website Address : ",
					ContactWebAddress);
			organisationwithContactPersonalDetails(PersonalOrganisationContact, ContactOrganisationTitle,
					ContactOrganisationAddress, ContactOrganisationJobTitle, ContactOrganisationEmailId,
					ContactOrganisationCountry, ContactOrganisationTelephone);
			addOrganisationOtherInfo(ContactOrganisationotherInfo);
		}
	}

	public void addExporterPopUp(String ContactIndivStatus, String ContactIndivExporterCode) {

		try {
			typeText(driver, test, OCR_ContactSection_ExporterCode, "Enter the Exporter Code : ",
					ContactIndivExporterCode);
			selectByVisibleText(driver, test, OCR_ContactSection_ExporterStatus, "Select Status as : ",
					ContactIndivStatus);
			clickElement(driver, test, OCR_ContactSection_ExporterSearchButton, "Click on search button");
			String Ecode = "//td[contains(text(),'" + ContactIndivExporterCode + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, Ecode, "Select Exporter : " + ContactIndivExporterCode);
			clickElement(driver, test, OCR_ContactSection_ExporterSelectButton, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@class='close']", "Close POP Up");
		}
	}

	public void organisationwithContactPersonalDetails(String PersonalOrganisationContact,
			String ContactOrganisationTitle, String ContactOrganisationAddress, String ContactOrganisationJobTitle,
			String ContactOrganisationEmailId, String ContactOrganisationCountry, String ContactOrganisationTelephone) {
		clickElement(driver, test, OCR_ContactSection_OrganPersonDetailScroll, "click on personal details scroll bar");
		if (PersonalOrganisationContact.length() > 0) {
			clickElement(driver, test, OCR_ContactSection_ExporterOrganisation_ContactLink, "click on Contact Link");
			Wait.waitfor(3);
			try {
				clickElement(driver, test, OCR_ContactSection_Exporter_ContactSearchBtn, "click on Search Button");
				String Cont = "//td[contains(text(),'" + PersonalOrganisationContact + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, Cont, "Select Exporter : " + PersonalOrganisationContact);
				clickElement(driver, test, OCR_ContactSection_Exporter_ContactSelectBtn, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//button[@class='close']", "Click on Close");
			}
		}
		typeText(driver, test, OCR_ContactSection_Exporter_ContactTitle, "Add Contact Title : ",
				ContactOrganisationTitle);
		typeText(driver, test, OCR_ContactSection_Exporter_ContactAddress, "Add Contact Address :  ",
				ContactOrganisationAddress);
		typeText(driver, test, OCR_ContactSection_Exporter_ContactJobTitle, "Add Contact Job Title :  ",
				ContactOrganisationJobTitle);
		typeText(driver, test, OCR_ContactSection_Exporter_ContactEmailAddress, "Add Contact Email Address :  ",
				ContactOrganisationEmailId);
		typeText(driver, test, OCR_ContactSection_Exporter_Country, "Add Contact Country :  ",
				ContactOrganisationCountry);
		typeText(driver, test, OCR_ContactSection_Exporter_Telephone, "Add Contact Telephone :  ",
				ContactOrganisationTelephone);
	}

	public void addIndivOtherInfo(String ContactIndivotherInfo) {
		clickElement(driver, test, OCR_ContactSection_IndivotherInfoScroller, "Add other Info Scroller");
		Wait.waitfor(2);
		typeText(driver, test, OCR_ContactSection_IndivOtherDetails, "Add other info : ", ContactIndivotherInfo);
	}

	public void addOrganisationOtherInfo(String ContactOrganisationotherInfo) {
		clickElement(driver, test, OCR_ContactSection_OrganisationotherInfoScroller, "Add other Info Scroller");
		Wait.waitfor(2);
		typeText(driver, test, OCR_ContactSection_OrganisationOtherDetails, "Add other info : ",
				ContactOrganisationotherInfo);
	}

	public void clickOnExportGoodListSection() {
		clickElement(driver, test, OCR_ContactSection_ExportGoodSection, "Click on Export Goods List Section");
	}

	public void saveContactSection() {
		clickElement(driver, test, OCR_ContactSection_ExporterSaveBtn, "click on Save Button");
	}

	// validations in Contact Section Tab
	public void validateContactSectionTypeIndividualError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ContactSection_IndividualRadio, "Click on Individual radio Button");
			clickElement(driver, test, OCR_ContactSection_ExporterSaveBtn, "Click on Save and Return");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Title  is required.']")) {
					test.log(LogStatus.INFO, "Title is required");
				}
				if (isDisplayed(driver, "//li[text()='Forename  is required.']")) {
					test.log(LogStatus.INFO, "Forename is required");
				}
				if (isDisplayed(driver, "//li[text()='Surname  is required.']")) {
					test.log(LogStatus.INFO, "Surname is required");
				}
				if (isDisplayed(driver, "//li[text()='Address  is required.']")) {
					test.log(LogStatus.INFO, "Address is required");
				}
				if (isDisplayed(driver, "//li[text()='Country  is required.']")) {
					test.log(LogStatus.INFO, "Country is required");
				}
				if (isDisplayed(driver, "//li[text()='Email Address  is required.']")) {
					test.log(LogStatus.INFO, "Email Address is  required");
				}
				if (isDisplayed(driver, "//li[text()='Telephone No  is required.']")) {
					test.log(LogStatus.INFO, "Telephone No is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

	// validations in Contact Section Tab
	public void validateContactSectionTypeOrganizationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ContactSection_ExporterOrganisationWithContactRadioBtn,
					"Click on Organisation Button");
			clickElement(driver, test, OCR_ContactSection_ExporterSaveBtn, "Click on Save and Return");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Organisation Name  is required.']")) {
					test.log(LogStatus.INFO, "Organization Name is required");
				}
				if (isDisplayed(driver, "//li[text()='Nature of Business  is required.']")) {
					test.log(LogStatus.INFO, "Nature of Business  is required");
				}
				if (isDisplayed(driver, "//li[text()='Title  is required.']")) {
					test.log(LogStatus.INFO, "Title is required");
				}
				if (isDisplayed(driver, "//li[text()='Forename  is required.']")) {
					test.log(LogStatus.INFO, "Forename is required");
				}
				if (isDisplayed(driver, "//li[text()='Surname  is required.']")) {
					test.log(LogStatus.INFO, "Surname is required");
				}
				if (isDisplayed(driver, "//li[text()='Address  is required.']")) {
					test.log(LogStatus.INFO, "Address is required");
				}
				if (isDisplayed(driver, "//li[text()='Country  is required.']")) {
					test.log(LogStatus.INFO, "Country is required");
				}
				if (isDisplayed(driver, "//li[text()='Email Address is required.']")) {
					test.log(LogStatus.INFO, "Email Address is  required");
				}
				if (isDisplayed(driver, "//li[text()='Telephone No is required.']")) {
					test.log(LogStatus.INFO, "Telephone No is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

}
