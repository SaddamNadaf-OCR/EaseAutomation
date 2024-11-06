package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ProposedLicensesUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/************************** Locators **************************/
	public static final String OCR_ProposedLicenseeTab = "//i[@id='PROP']";
	public static final String OCR_PropLicensPage_TypeIndivRadioBtn = "//input[@id='typeFlagPLI']";
	public static final String OCR_PropLicensPage_ProposeLicenseLink = "//a[contains(text(),'Proposed Licensee')]";
	public static final String OCR_PropLicensPage_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_PropLicensPage_ExporterSearchBtn = "//button[@name='Search']";
	public static final String OCR_PropLicensPage_ExporterStatusDropdwn = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_PropLicensPage_ExporterSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_PropLicensPage_ExporterSaveBtn = "//input[@id='submitAppl']";
	public static final String OCR_PropLicensPage_ExporterOtherInfo = "//textarea[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOtherInfo']";
	public static final String OCR_PropLicensPage_ExporterUKCHRegisteredNumber = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrUkChNo']";
	public static final String OCR_PropLicensPage_ExporterUKVATNo = "//input[@id='vatNo']";
	public static final String OCR_PropLicensPage_OrganisationCompanyRegNo = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrOverseasRegNo']";
	public static final String OCR_PropLicensPage_OrganisationEORINumber = "//input[@id='eoriNoId']";
	public static final String OCR_PropLicensPage_ExporterTelephoneNo = "//input[@id='editUKproposedLicensee_licUkAuthCnsigneePhoneValues_0__indItemDesc']";
	public static final String OCR_PropLicensPage_ExporterEmailAddress = "//input[@id='editUKproposedLicensee_licUkAuthCnsigneeMailIdValues_0__indItemDesc']";
	public static final String OCR_PropLicensPage_OtherDetailsdragger = "(//label[contains(text(),'Other Details')])[1]";
	public static final String OCR_PropLicensPage_OtherDetailsdragger1 = "(//label[contains(text(),'Other Details')])[2]";
	public static final String OCR_PropLicensPage_OtherDeatilsOtherInfo = "//textarea[@id='editUKproposedLicensee_authorisationAddressValue_licAddrOthInfo']";
	public static final String OCR_PropLicensPage_OtherDeatilsOtherInfo1 = "//textarea[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOtherInfo']";
	public static final String OCR_PropLicensPage_IndividualTitle = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrPostionTitle']";
	public static final String OCR_PropLicensPage_IndividualMiddleInitials = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrMName']";
	public static final String OCR_PropLicensPage_IndividualSurName = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrLastName']";
	public static final String OCR_PropLicensPage_IndividualEmail = "//input[@id='editUKproposedLicensee_licUkAuthCnsigneeMailIdValues_0__indItemDesc']";
	public static final String OCR_PropLicensPage_TypeOrganRadioBtn = "//input[@id='typeFlagPLO']";
	public static final String OCR_PropLicensPage_TypeOrganisationLink = "//a[contains(text(),'Organisation')]";
	public static final String OCR_PropLicensPage_TypeOrg_NatureofBusiness = "//input[@id='natureToolTip']";
	public static final String OCR_PropLicensPage_TypOrgWebAddress = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrWebsite']";
	public static final String OCR_PropLicensPage_SiteDetailsSectionScroll = "//label[contains(text(),'Site Details')]";
	public static final String OCR_PropLicensPage_SiteName = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licAddrSiteName']";
	public static final String OCR_PropLicensPage_SiteAddress = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOrgSiteAddress1']";
	public static final String OCR_PropLicensPage_SiteEORINo = "//input[@id='siteEoriNoId']";
	public static final String OCR_PropLicensPage_SiteCity = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOrgSiteAddressCity']";
	public static final String OCR_PropLicensPage_SiteZIPCode = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOrgSiteAddressZipCode']";
	public static final String OCR_PropLicensPage_SiteState = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOrgSiteAddressStateName']";
	public static final String OCR_PropLicensPage_SiteCountry = "//input[@id='editUKproposedLicensee_authorisationAddressValue_licOwnerOrgSiteAddressCountryName']";
	public static final String OCR_PropLicensPage_SiteSameAsOrg = "//input[@id='sameASorganisationFlag']";
	public static final String OCR_PropLicensPage_ParentCompaniesScroll = "//label[contains(text(),'Parent Companies')]";
	public static final String OCR_PropLicensPage_ParentCompanyQuestion = "//select[@id='authorisationAddressValue.licAddrMain']";
	public static final String OCR_PropLicensPage_AddParentCompany = "//button[contains(text(),'Add Parent Company')]";
	public static final String OCR_PropLicensPage_ParentCompanyLink = "//a[contains(text(),'Parent Company')]";
	public static final String OCR_PropLicensPage_ParentCompanyExpCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_PropLicensPage_ParentCompanyExporterSearch = "//button[@name='Search']";
	public static final String OCR_PropLicensPage_ParentCompanySelectButton = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_PropLicensPage_ParentCompanyNatureBusiness = "//input[@id='pNatureToolTip']";
	public static final String OCR_PropLicensPage_ParentCompanyOtherDetailsScroller = "//div[@class='modal-body']//label[contains(text(),'Other Details')]";
	public static final String OCR_PropLicensPage_ParentCompanyOtherDetails = "//textarea[@id='saveParentCompany_authorisationAddressValue_licAddrOthInfo']";
	public static final String OCR_PropLicensPage_ParentCompanySaveAndReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_PropLicensPage_ContactIcon = "//i[@id='CONTACT']";

	/*********************** constructor *************************/
	public ProposedLicensesUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickOnProposedLicenseeTab() {
		clickElement(driver, test, OCR_ProposedLicenseeTab, "Click on Proposed Licensee Tab");
	}

	public void personalDetails(String SelectType, String IndividualExporterCode, String IndividualStatus,
			String IndivTitle, String IndivMidIntials, String IndivSurName, String EmailAddress,
			String IndividualotherInfo, String OrganizationExporterCode, String OrganizationStatus, String RegNo,
			String VATNo, String NatureOfBusines, String WebAdd, String OverseaRegNo, String EORINUmber,
			String SiteName, String SiteAddress, String SiteEORI, String SiteCity, String SiteState, String SiteCountry,
			String SiteZIPCode, String OrganizationotherInfo, String YesNoParent, String ParentCmpExporterCode,
			String ParentNatureOfBusiness, String ParentOtherDetails) {
		if (SelectType.contains("Individual")) {
			clickElement(driver, test, OCR_PropLicensPage_TypeIndivRadioBtn, "Click on Individual Radio Button");
			clickElement(driver, test, OCR_PropLicensPage_ProposeLicenseLink, "Click on Proposed Licensee Link");
			addExporterPopUp(IndividualExporterCode, IndividualStatus);
			typeText(driver, test, OCR_PropLicensPage_IndividualTitle, "Add Individual Title : ", IndivTitle);
			typeText(driver, test, OCR_PropLicensPage_IndividualMiddleInitials, "Add Individual Midle Initials : ",
					IndivMidIntials);
			typeText(driver, test, OCR_PropLicensPage_IndividualSurName, "Add Individual SurName : ", IndivSurName);
			typeText(driver, test, OCR_PropLicensPage_IndividualEmail, "Add Individual Email Address : ", EmailAddress);
			addIndividualType(IndividualotherInfo);
		} else {
			clickElement(driver, test, OCR_PropLicensPage_TypeOrganRadioBtn, "click on Organization Radio Button");
			clickElement(driver, test, OCR_PropLicensPage_TypeOrganisationLink, "click on Organization Link");
			addExporterPopUp(OrganizationExporterCode, OrganizationStatus);
			addOrganisationType(RegNo, VATNo, NatureOfBusines, WebAdd, OverseaRegNo, EORINUmber);
			addSiteDetails(SiteName, SiteAddress, SiteEORI, SiteCity, SiteState, SiteCountry, SiteZIPCode);
			addOtherDetails(OrganizationotherInfo);
			addParentCompanies(YesNoParent, ParentCmpExporterCode, ParentNatureOfBusiness, ParentOtherDetails);
		}
	}

	public void addIndividualType(String IndividualotherInfo) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_PropLicensPage_OtherDetailsdragger1, "click on other details");
		typeText(driver, test, OCR_PropLicensPage_OtherDeatilsOtherInfo1, "Add Other Info : ", IndividualotherInfo);
	}

	public void addExporterPopUp(String ExporterCode, String Status) {
		typeText(driver, test, OCR_PropLicensPage_ExporterCode, "Enter the Exporder Code : ", ExporterCode);
		selectByVisibleText(driver, test, OCR_PropLicensPage_ExporterStatusDropdwn, "Select the Status as : ", Status);
		clickElement(driver, test, OCR_PropLicensPage_ExporterSearchBtn, "Click on search button");
		String Ecode = "//td[contains(text(),'" + ExporterCode + "')]";
		Wait.waitfor(3);
		clickElement(driver, test, Ecode, "Select Exporter : " + ExporterCode);
		clickElement(driver, test, OCR_PropLicensPage_ExporterSelectBtn, "Click on Select Button");
	}

	public void addOrganisationType(String RegNo, String VATNo, String NatureOfBusines, String WebAdd,
			String OverseaRegNo, String EORINUmber) {
		typeText(driver, test, OCR_PropLicensPage_ExporterUKCHRegisteredNumber, "Enter the UK CH Registered No. : ", RegNo);
		typeText(driver, test, OCR_PropLicensPage_OrganisationCompanyRegNo, "Enter the UK Overseas Reg No. : ", OverseaRegNo);
		typeText(driver, test, OCR_PropLicensPage_OrganisationEORINumber, "Enter the EORI Number : ", EORINUmber);
		typeText(driver, test, OCR_PropLicensPage_ExporterUKVATNo, "Enter the UK VAT No : ", VATNo);
		typeText(driver, test, OCR_PropLicensPage_TypeOrg_NatureofBusiness, "Enter the Nature of Business : ",
				NatureOfBusines);
		typeText(driver, test, OCR_PropLicensPage_TypOrgWebAddress, "Enter Website Address : ", WebAdd);
	}

	public void addSiteDetails(String SiteName, String SiteAddress, String SiteEORI, String SiteCity, String SiteState,
			String SiteCountry, String SiteZIPCode) {
		scrollToBottom(driver);
		clickElement(driver, test, OCR_PropLicensPage_SiteDetailsSectionScroll, "click on Site Scroll Bar");
		typeText(driver, test, OCR_PropLicensPage_SiteName, "Enter the  Site Name : ", SiteName);
		typeText(driver, test, OCR_PropLicensPage_SiteAddress, "Enter the   Site Address : ", SiteAddress);
		typeText(driver, test, OCR_PropLicensPage_SiteEORINo, "Enter the  EORI Number : ", SiteEORI);
		typeText(driver, test, OCR_PropLicensPage_SiteCity, "Enter the  Site city : ", SiteCity);
		typeText(driver, test, OCR_PropLicensPage_SiteState, "Enter the  Site State : ", SiteState);
		typeText(driver, test, OCR_PropLicensPage_SiteCountry, "Enter the  Country Site : ", SiteCountry);
		Wait.waitfor(2);
		String country = "(//div[contains(text(),'" + SiteCountry + "')])[1]";
		clickElement(driver, test, country, "Click on country : " + SiteCountry);
		typeText(driver, test, OCR_PropLicensPage_SiteZIPCode, "Enter the Zip COde : ", SiteZIPCode);
	}

	public void addOtherDetails(String OrganizationotherInfo) {
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_PropLicensPage_OtherDetailsdragger, "click on other details");
		Wait.waitfor(2);
		typeText(driver, test, OCR_PropLicensPage_OtherDeatilsOtherInfo, "Enter the  Other Info : ", OrganizationotherInfo);
	}

	public void addParentCompanies(String YesNoParent, String ParentCmpExporterCode, String ParentNatureOfBusiness,
			String ParentOtherDetails) {
		clickElement(driver, test, OCR_PropLicensPage_ParentCompaniesScroll, "Click on Parent Companies Scroll");
		Wait.waitfor(4);
		if (YesNoParent.equalsIgnoreCase("Yes")) {
			selectByVisibleText(driver, test, OCR_PropLicensPage_ParentCompanyQuestion,
					"Select Yes or No from dropdown", YesNoParent);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_PropLicensPage_AddParentCompany, "Click on Add Parent Company");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_PropLicensPage_ParentCompanyLink, "Click on Parent Company Link");
			Wait.waitfor(4);
			typeText(driver, test, OCR_PropLicensPage_ParentCompanyExpCode, "Enter the Parent Exporter Code : ",
					ParentCmpExporterCode);
			clickElement(driver, test, OCR_PropLicensPage_ParentCompanyExporterSearch, "Click Search Button");
			String expCode = "//td[contains(text(),'" + ParentCmpExporterCode + "')]";
			clickElement(driver, test, expCode, "Selected Parent Exp Code : " + ParentCmpExporterCode);
			clickElement(driver, test, OCR_PropLicensPage_ParentCompanySelectButton, "Click on Select Button ");
			Wait.waitfor(3);
			typeText(driver, test, OCR_PropLicensPage_ParentCompanyNatureBusiness, "Enter the Company Nature Business : ",
					ParentNatureOfBusiness);
			Wait.waitfor(2);
			typeText(driver, test, OCR_PropLicensPage_ParentCompanyOtherDetails, "Enter the Parent Company OtherDetails : ",
					ParentOtherDetails);
			clickElement(driver, test, OCR_PropLicensPage_ParentCompanySaveAndReturn, "Click Save and Return");
		} else {
			selectByVisibleText(driver, test, OCR_PropLicensPage_ParentCompanyQuestion,
					"Select the Yes or No from dropdown : ", YesNoParent);
		}
	}

	public void saveProposedLicense() {
		scrollToElement(driver, OCR_PropLicensPage_ExporterSaveBtn);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_PropLicensPage_ExporterSaveBtn, "Click on Save Button");
		Wait.waitfor(15);
	}

	public void clickContactIcon() {
		clickElement(driver, test, OCR_PropLicensPage_ContactIcon, "Click on Cantact Button");
	}

	// validations in Proposed Licensee Tab
	public void validateProposedLicenseeTypeIndividualError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_PropLicensPage_ExporterSaveBtn, "Click on Save Button");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
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
				if (isDisplayed(driver, "//li[text()='Email Address cannot be blank.']")) {
					test.log(LogStatus.INFO, "Email Address is  required");
				}
				if (isDisplayed(driver, "//li[text()='Telephone No cannot be blank.']")) {
					test.log(LogStatus.INFO, "Telephone No is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

	// validations in Proposed Licensee Tab
	public void validateProposedLicenseeTypeOrganizationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_PropLicensPage_TypeOrganRadioBtn, "Click on Organisation Button");
			clickElement(driver, test, OCR_PropLicensPage_ExporterSaveBtn, "Click on Save Button");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Organisation Name  is required.']")) {
					test.log(LogStatus.INFO, "Organization Name is required");
				}
				if (isDisplayed(driver, "//li[text()='Registered Address  is required.']")) {
					test.log(LogStatus.INFO, "Registered Address  is required.");
				}
				if (isDisplayed(driver, "//li[text()='Country of Origin  is required.']")) {
					test.log(LogStatus.INFO, "Country of Origin  is required.");
				}
				if (isDisplayed(driver, "//li[text()='Nature of Business  is required.']")) {
					test.log(LogStatus.INFO, "Nature of Business  is required.");
				}
				if (isDisplayed(driver, "//li[text()='Site Name  is required.']")) {
					test.log(LogStatus.INFO, "Site Name  is required.");
				}
				if (isDisplayed(driver, "//li[text()='Address  is required.']")) {
					test.log(LogStatus.INFO, "Address  is required.");
				}
				if (isDisplayed(driver, "//li[text()='Country  is required.']")) {
					test.log(LogStatus.INFO, "Country  is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

}
