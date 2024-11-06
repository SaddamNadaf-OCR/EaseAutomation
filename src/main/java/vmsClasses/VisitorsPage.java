/*-----------------------Page added by Nancy --------------------------*/
package vmsClasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class VisitorsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_Button_AddOrganisation = "//button[contains(text(),'Add Organization')]";
	public static final String OCR_OrgCode = "//a[@id='orgCode']";
	public static final String OCR_OrgName = "//input[@id='VMM_FLD_94']";
	public static final String OCR_OrgType = "//select[@id='VMM_FLD_96']";
	public static final String OCR_OrgAddress = "//input[@id='VMM_FLD_97']";
	public static final String OCR_OrgAddress2 = "//input[@id='VMM_FLD_100']";
	public static final String OCR_OrgAddress3 = "//input[@id='VMM_FLD_103']";
	public static final String OCR_OrgState = "//input[@id='VMM_FLD_95']";
	public static final String OCR_OrgZip = "//input[@id='VMM_FLD_98']";
	public static final String OCR_OrgCountry = "//input[@id='VMM_FLD_101']";
	public static final String OCR_OrgCity = "//input[@id='VMM_FLD_106']";
	public static final String OCR_OrgCountryOfIncorporation = "//input[@id='VMM_FLD_104']";
	public static final String OCR_Button_SaveReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Button_AddVisitor = "//button[contains(text(),'Add Visitor')]";
	public static final String OCR_USAgency = "//select[@id='VMM_FLD_99']";
	public static final String OCR_DLISCageCode = "//input[@id='VMM_FLD_105']";
	public static final String OCR_DUNS_EIN = "//input[@id='VMM_FLD_102']";
	public static final String OCR_OrgRepresentingForeignInterestToggle = "//div[@class='lcs_label lcs_label_off']";
	public static final String OCR_OrgRepresentingForeignInterest = "//input[@id='VMM_FLD_109']";	
	public static final String OCR_OrgRepForeignCountry = "//input[@id='VMM_FLD_109']";	
	public static final String OCR_VisitorTitle = "//input[@id='VMM_FLD_55']";
	public static final String OCR_VisitorFirstName = "//input[@id='VMM_FLD_56']";
	public static final String OCR_VisitorMiddleName = "//input[@id='VMM_FLD_57']";
	public static final String OCR_VisitorLastName = "//input[@id='VMM_FLD_58']";
	public static final String OCR_VisitorCompany = "//div[@xpath='1']"; //// select[@id='editVisitorPerson_personCompany']
	public static final String OCR_VisitorOrgAssociated = "//div[@xpath='1']";
	public static final String OCR_VisitorEmail = "//input[@id='VMM_FLD_59']";
	public static final String OCR_VisitorVEmail = "//input[@id='VMM_FLD_59']";	
	public static final String OCR_VisitorValidationmessage = "//li[contains(text(),'Invalid Email Address.')]";
	public static final String OCR_VisitorPhoneNo = "//input[@id='VMM_FLD_60']";
	public static final String OCR_VisitorAddress = "//input[@id='VMM_FLD_61']";
	public static final String OCR_VisitorAddress2 = "//input[@id='VMM_FLD_65']";
	public static final String OCR_VisitorAddress3 = "//input[@id='VMM_FLD_68']";
	public static final String OCR_VisitorCity = "//input[@id='VMM_FLD_71']";
	public static final String OCR_VisitorState = "//input[@id='VMM_FLD_74']";
	public static final String OCR_VisitorZip = "//input[@id='VMM_FLD_75']";
	public static final String OCR_VisitorCountry = "//input[@id='VMM_FLD_81']";
	public static final String OCR_TypeOfPerson = "//select[@id='VMM_FLD_62']";
	public static final String OCR_CountryOfResidence = "//input[@id='VMM_FLD_72']";
	public static final String OCR_VisitorRepresentingForeignInterestToggle = "//div[@class='lcs_label lcs_label_off']";
	public static final String OCR_VisitorRepresentingForeignInterest = "//input[@id='VMM_FLD_78']";
	public static final String OCR_VisitorCategory = "//select[@id='VMM_FLD_25']";
	public static final String OCR_CountryOfCitizenship = "//input[@id='VMM_FLD_66']";
	public static final String OCR_OtherCountryOfCitizenship = "//input[@id='VMM_FLD_69']";
	public static final String OCR_DateofBirth = "//input[@id='VMM_FLD_67']";
	public static final String OCR_DateofBirth_Datepicker = "//select[@class='ui-datepicker-year']";
	public static final String OCR_PlaceofBirth = "//input[@id='VMM_FLD_73']";
	public static final String OCR_CountryofBirth = "//input[@id='VMM_FLD_70']";
	public static final String OCR_Female = "//input[@id='VMM_FLD_64F']";
	public static final String OCR_Male = "//input[@id='VMM_FLD_63M']";
	public static final String OCR_VisitorIsAnEmployeeOfCompany = "//div[@class='lcs_label lcs_label_off']";
	public static final String OCR_EmployeeId = "//input[@id='VMM_FLD_80']";
	public static final String OCR_NoIdentifyingDocumentsRequired = "//input[@id='VMM_FLD_82']";
	public static final String OCR_IdentifyingDocuments = "//select[@id='VMM_FLD_83']";
	public static final String OCR_IDDocumentNumber = "//input[@id='editVisitorPerson_visitorPersonDocumentValue_docNo']";
	public static final String OCR_IDExpirationDate = "//input[@id='editVisitorPerson_docExpDate']";
	public static final String OCR_IDIssuingState = "//input[@id='editVisitorPerson_visitorPersonDocumentValue_docIssState']";
	public static final String OCR_IDIssuingCountry = "//input[@id='editVisitorPerson_docIssCountry']";
	public static final String OCR_EquipmentCheckBoxList = "//input[@id='VMM_FLD_84']";
	public static final String OCR_EquipmentDescription = "//textarea[@id='VMM_FLD_91']";
	public static final String OCR_EquipmentJustification = "//textarea[@id='VMM_FLD_92']";
	public static final String OCR_Button_SaveAddMore = "//button[contains(text(),'Save & Add More')]";
	public static final String OCR_Button_Back = "//button[contains(text(),'Back')]";
	public static final String OCR_Button_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn-upper']";
	public static final String OCR_VisitorInfo_ViewDetailOverride = "//button[contains(text(),'Override')]";
	public static final String OCR_VisitorInfo_DisptnReasonMatrix = "(//input[@name='dplreasons'])[5]";
	public static final String OCR_VisitorInfo_DisptnReasonMatxSave = "(//button[text()='Save'])[2]";
	public static final String OCR_loadinglocator = "//label[contains(text(),'Loading Content')]";
	public static final String OCR_VisitorInfo_DplStatusRed = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-red']";
	public static final String OCR_VisitorInfo_DplStatusGreen = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-green']";
	public static final String OCR_VisitorInfo_DRMclose = "//button[@class='close']";
	public static final String OCR_DomesticForeign = "//div[8]//div[1]//fieldset[1]//div[2]//table[1]//tbody[1]//tr[1]//td[5]";
	public static final String OCR_Button_AddFromExcel = "//button[contains(text(),'Add From Excel')]";
	public static final String OCR_Button_UploadFile = "//span[@class='btn fileinput-button']";
	public static final String OCR_Button_Ok = "//button[@id='submit-btn']";
	public static final String OCR_VisitorNameLink = "//a[contains(text(),'Deva S Patil')]";
	public static final String OCR_Button_QuestionnaireCancel = "//button[contains(text(), 'Exit')]";
	public static final String OCR_VisitorInfo_SendInvite = "//button[@id='sendInviteId']";
	public static final String OCR_VisitorInfo_Org = "//div[@class='selectize-input items has-options full has-items']";
	public static final String OCR_VisitorInfo_VisitorsWorkflowType = "//td[@aria-describedby='grid_domesticorForeign']";
	public static final String OCR_VisitorInfo_SaveButton = "(//button[@name='save'])[1]";
	public static final String OCR_VisitorInfo_Warning1 = "//h4[contains(text(),'Warning!')]";
	/*--------------------------------Constructor------------------------------------------*/

	public VisitorsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	
	
	// Get Visitor Full name
	
	public void get_VisitorFullname() {
		getText(driver, test, "//td[@aria-describedby='grid_firstName']", "Get Visitor full name");
	
	}
	
	// Verify request visitor confirmation popup working.
	public void validate_RequestVisitorInfo() {
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='cb_grid']", "Select the Visitor");
		clickElement(driver, test, OCR_VisitorInfo_SendInvite, "Click on Send Invite");

		try {
			
			Wait.waitfor(4);
			clickElement(driver, test, "//button[@id='sendMail']", "Click on Send button");
			Wait.waitfor(4);
			isDisplayed(driver, "//label[contains(text(),'Deva Patil')]");
			Wait.waitfor(4);
			clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
			}
	}
	
	// Validating send Email Button
	public void validating_EscortRequired() throws InterruptedException {
		try {
			Wait.fluwait(driver, OCR_VisitorInfo_Warning1);
			if (isDisplayed(driver, OCR_VisitorInfo_Warning1)) {
				if (isDisplayed(driver, "//span[contains(text(),'You cannot add a mixture of ESCORT REQUIRED and NO-ESCORT REQUIRED visitors under one visitor request.')]")) {
					test.log(LogStatus.PASS,"Warning is displayed for : Mixture Escort required and No Escort required ");
				}
			}
		}
				catch (Exception e) {
			test.log(LogStatus.FAIL, "Warning is not displayed for : Mixture Escort required and No Escort required");
			testFailSshot(driver, test);
		}
	}

	// Click on save button on visitor screen
	public void Click_SaveButton() {
		Wait.waitfor(3);
		scrollToElement(driver, "(//button[@name='save'])[1]");
		clickElement(driver, test, OCR_VisitorInfo_SaveButton, "Click on save button on visitor screen");
	}

	// validating the Visitor Workflow Type
	public String get_VisitorWorkflowType() {
		scrollToTop(driver);
		Wait.wait(driver, OCR_VisitorInfo_VisitorsWorkflowType);
		return getAttribute(driver, test, OCR_VisitorInfo_VisitorsWorkflowType, "innerText",
				" Get Visitor WorkFlow Type is : ");

	}

	// validating the Visitor Workflow Type as foreign
	public void validate_Foreign() {

		try {
			if (isDisplayed(driver, OCR_VisitorInfo_VisitorsWorkflowType)) {
				test.log(LogStatus.PASS, "Visitor WorkFlow Type is : Foreign");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Visitor WorkFlow Type is : Domestic");

		}
	}

	// validating the Visitor Workflow Type Domestic
	public void validate_Domestic() {

		try {
			if (isDisplayed(driver, OCR_VisitorInfo_VisitorsWorkflowType)) {
				test.log(LogStatus.PASS, "Visitor WorkFlow Type is : Domestic");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Visitor WorkFlow Type is : foreign");

		}
	}

	// Click on Visitor name link

	public void select_VisitorNameLink() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorNameLink, "Click on Visitor name link");
	}

	// Verify delete icon is disable or not in Add/Edit Individual
	public void Disable_DeleteIcon() {
		try {
			if (isDisplayed(driver, "//tbody[@class='text-center']//i[contains(@class,'fa fa-trash-o')]")) {
				Wait.waitfor(3);
				test.log(LogStatus.PASS,
						"Visitor Delete icon is Disabled and Not able to delete visitor when request is approved ");
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Visitor Delete icon is Enabled");
		}
	}

	// Click on Cancel button in add/edit individual page
	public void click_Back() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Back, "Click on Back button");
	}

	// Click on cancel button in Questionnaire screen
	public void click_QuestionnaireCancel() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_QuestionnaireCancel, "Click on Cancel button in Questionnaire screen");
	}

	// Add Organisation details
	public void addOrganisation(String OrgName, String OrgType, String Address, String Address2, String Address3,
			String City, String Zip, String Country, String State, String CountryOfIncorporation, String USAgency,
			String DLISCageCode, String DUNS_EIN) {

		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_AddOrganisation, "Clicking on Add Organisation Button");
		Wait.waitfor(3);
		typeText(driver, test, OCR_OrgName, "Enter Organisation Name : ", OrgName);
		selectByVisibleText(driver, test, OCR_OrgType, "Select Org Type : ", OrgType);
		typeText(driver, test, OCR_OrgAddress, "Enter address : ", Address);
		typeText(driver, test, OCR_OrgAddress2, "Enter address2 : ", Address2);
		typeText(driver, test, OCR_OrgAddress3, "Enter address3 : ", Address3);
		typeText(driver, test, OCR_OrgCity, "Enter City : ", City);
		typeText(driver, test, OCR_OrgZip, "Enter Zip : ", Zip);
		typeText(driver, test, OCR_OrgCountry, "Enter Country : ", Country);
		typeText(driver, test, OCR_OrgState, "Enter State : ", State);
		typeText(driver, test, OCR_OrgCountryOfIncorporation, "Enter CountryOfIncorporation : ",
				CountryOfIncorporation);
		selectByVisibleText(driver, test, OCR_USAgency, "Enter US Agency : ", USAgency);
		typeText(driver, test, OCR_DLISCageCode, "Enter DLIS Cage Code : ", DLISCageCode);
		typeText(driver, test, OCR_DUNS_EIN, "Enter DUNS/EIN : ", DUNS_EIN);
		clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");
		Wait.waitfor(5);
	}
	
	// Add Organisation details By Ajit Sharma
			public void addForOrganisation(String OrgName, String OrgType, String Address, String Address2, String Address3,
					String City, String Zip, String Country, String State, String CountryOfIncorporation, String USAgency,
					String DLISCageCode, String DUNS_EIN, String OrgRepresentingForeignInterest) {

				Wait.waitfor(3);
				clickElement(driver, test, OCR_Button_AddOrganisation, "Clicking on Add Organisation Button");
				Wait.waitfor(3);
				typeText(driver, test, OCR_OrgName, "Enter Organisation Name : ", OrgName);
				selectByVisibleText(driver, test, OCR_OrgType, "Select Org Type : ", OrgType);
				typeText(driver, test, OCR_OrgAddress, "Enter address : ", Address);
				typeText(driver, test, OCR_OrgAddress2, "Enter address2 : ", Address2);
				typeText(driver, test, OCR_OrgAddress3, "Enter address3 : ", Address3);
				typeText(driver, test, OCR_OrgCity, "Enter City : ", City);
				typeText(driver, test, OCR_OrgZip, "Enter Zip : ", Zip);
				typeText(driver, test, OCR_OrgCountry, "Enter Country : ", Country);
				typeText(driver, test, OCR_OrgState, "Enter State : ", State);
				typeText(driver, test, OCR_OrgCountryOfIncorporation, "Enter CountryOfIncorporation : ",
						CountryOfIncorporation);
				selectByVisibleText(driver, test, OCR_USAgency, "Enter US Agency : ", USAgency);
				typeText(driver, test, OCR_DLISCageCode, "Enter DLIS Cage Code : ", DLISCageCode);
				typeText(driver, test, OCR_DUNS_EIN, "Enter DUNS/EIN : ", DUNS_EIN);
				clickElement(driver, test, OCR_OrgRepresentingForeignInterestToggle, "Enable toggle button");
				typeText(driver, test, OCR_OrgRepresentingForeignInterest,
						"Enter Representing Foreign Interest Country : ", OrgRepresentingForeignInterest);
				clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");
				Wait.waitfor(5);
			}

	public void add_OrgAssociated(String Company) {
		clickElement(driver, test, OCR_VisitorOrgAssociated, "click on Organization Associated");
		Wait.waitfor(3);
		String OrgAsscted = "//div[contains(text(),'" + Company.trim() + "')]";
		clickElement(driver, test, OrgAsscted, "Selected Organization Associated as : " + Company);
	}

	// Add Individual details
	public void add_Individual(String Title, String FirstName, String MiddleName, String LastName, /* String Company */
			String VisitorEmail, String PhoneNumber) {
		Wait.wait(driver, OCR_Button_AddVisitor);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_AddVisitor, "Clicking on Add Visitor");
		// add_OrgAssociated(Company);
		typeText(driver, test, OCR_VisitorTitle, "Enter Title : ", Title);
		typeText(driver, test, OCR_VisitorFirstName, "Enter Visitor First Name : ", FirstName);
		typeText(driver, test, OCR_VisitorMiddleName, "Enter Visitor Middle Name : ", MiddleName);
		typeText(driver, test, OCR_VisitorLastName, "Enter Visitor Last Name : ", LastName);
		Wait.waitfor(3);
		// selectByVisibleText(driver, test, OCR_VisitorCompany, "Enter Visitor Company
		// : ", Company);
		typeText(driver, test, OCR_VisitorEmail, "Enter Visitor Email : ", VisitorEmail);
		typeText(driver, test, OCR_VisitorPhoneNo, "Enter Visitor Phone No : ", PhoneNumber);

		try {
			Wait.waitfor(5);
			clickElement(driver, test, "//button[@id='cancel']", "Click on No");
			Wait.waitfor(3);
		} catch (Exception e) {
			Wait.waitfor(3);
		}
	}

	// Add Individual details
		public void add_Individual1(String Title, String FirstName, String MiddleName, String LastName,  String Company1,
				String VisitorEmail, String PhoneNumber) {
			Wait.wait(driver, OCR_Button_AddVisitor);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_AddVisitor, "Clicking on Add Visitor");
			// add_OrgAssociated(Company);
			typeText(driver, test, OCR_VisitorTitle, "Enter Title : ", Title);
			typeText(driver, test, OCR_VisitorFirstName, "Enter Visitor First Name : ", FirstName);
			typeText(driver, test, OCR_VisitorMiddleName, "Enter Visitor Middle Name : ", MiddleName);
			typeText(driver, test, OCR_VisitorLastName, "Enter Visitor Last Name : ", LastName);
			Wait.waitfor(3);
			clickElement(driver, test, "//div[contains(text(), '-PLEASE SELECT / ADD ORGANIZATION-')]", "CLick on ORG dropdown");
			String LocatorCompany = "//div[contains(text(), '" + Company1 + "')]";
			System.out.println(LocatorCompany);
			clickElement(driver, test, LocatorCompany, "select Representing self");
			//selectByVisibleText(driver, test, LocatorCompany , "Enter Visitor Company : ", Company1);
			 
			 
			typeText(driver, test, OCR_VisitorEmail, "Enter Visitor Email : ", VisitorEmail);
			typeText(driver, test, OCR_VisitorPhoneNo, "Enter Visitor Phone No : ", PhoneNumber);

			try {
				Wait.waitfor(5);
				clickElement(driver, test, "//button[@id='cancel']", "Click on No");
				Wait.waitfor(3);
			} catch (Exception e) {
				Wait.waitfor(3);
			}
		}
	
	// select Organization Associated
	public void select_OrgzAssociated(String OrgAssociated) throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, "//div[@class='item']", "click on Organization Associated");
		Wait.waitfor(1);
		String OrgAsscted = "//div[contains(text(),'" + OrgAssociated.trim() + "')]";
		clickElement(driver, test, OrgAsscted, "Selected Organization Associated as : " + OrgAssociated);
	}

	// select Organization Associated
	public void select_Escort(String Escort) throws InterruptedException {
		Wait.waitfor(5);
		// clickElement(driver, test, "//div[@class='item']", "click on Organization
		// Associated");
		Wait.waitfor(3);
		String EscortRequired = "//div[contains(text(),'" + Escort.trim() + "')]";
		clickElement(driver, test, EscortRequired, "Selected Organization Associated as : " + Escort);
	}

	// Add Address Details
	public void add_AddressDetails(String VAddress, String VAddress2, String VAddress3, String VCity, String VCountry,
			String VState, String VZip) {
		typeText(driver, test, OCR_VisitorAddress, "Enter address : ", VAddress);
		typeText(driver, test, OCR_VisitorAddress2, "Enter address2 : ", VAddress2);
		typeText(driver, test, OCR_VisitorAddress3, "Enter address3 : ", VAddress3);
		typeText(driver, test, OCR_VisitorCity, "Enter City : ", VCity);
		typeText(driver, test, OCR_VisitorZip, "Enter Zip : ", VZip);
		typeText(driver, test, OCR_VisitorCountry, "Enter Country : ", VCountry);
		typeText(driver, test, OCR_VisitorState, "Enter State : ", VState);
	}

	// Add Citizenship details
	public void add_Citizenship(String TypeOfPerson, String CountryofResidence, String VisitorCategory,
			String CountryofCitizenship, String RepresentingForeignInterest, String OtherCountriesofCitizenship) {
		selectByVisibleText(driver, test, OCR_TypeOfPerson, "Select Type Of Person : ", TypeOfPerson);
		typeText(driver, test, OCR_CountryOfResidence, "Enter Country Of Residience : ", CountryofResidence);
		selectByVisibleText(driver, test, OCR_VisitorCategory, "Select Visitor Category : ", VisitorCategory);
		typeText(driver, test, OCR_CountryOfCitizenship, "Enter Country of Citizenship : ", CountryofCitizenship);
		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//button[@id='cancel']", "Click on No");
			Wait.waitfor(3);
		} catch (Exception e) {
			Wait.waitfor(3);
		}
		if (TypeOfPerson.contains("Foreign Person")) {
			clickElement(driver, test, OCR_VisitorRepresentingForeignInterestToggle, "Enable toggle button");
			typeText(driver, test, OCR_VisitorRepresentingForeignInterest,
					"Enter Representing Foreign Interest Country : ", RepresentingForeignInterest);
		}
		typeText(driver, test, OCR_OtherCountryOfCitizenship, "Enter  Other Country of Citizenship : ",
				OtherCountriesofCitizenship);
	}

	// Add Citizenship for excort required and no escort required test case details
	public void add_EscortCitizenship(String TypeOfPerson, String CountryofResidence, String VisitorCategory,
			String CountryofCitizenship, String Escort, String RepresentingForeignInterest,
			String OtherCountriesofCitizenship) {
		selectByVisibleText(driver, test, OCR_TypeOfPerson, "Select Type Of Person : ", TypeOfPerson);
		typeText(driver, test, OCR_CountryOfResidence, "Enter Country Of Residience : ", CountryofResidence);
		selectByVisibleText(driver, test, OCR_VisitorCategory, "Select Visitor Category : ", VisitorCategory);

		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//button[@id='cancel']", "Click on No");
			Wait.waitfor(3);
		} catch (Exception e) {
			Wait.waitfor(3);
		}

		String EscortRequired = "(//div[contains(text(),'" + Escort + "')])[2]";
		System.out.println(EscortRequired);
		if (EscortRequired.equalsIgnoreCase("(//div[contains(text(),'On')])[2]")) {
			clickElement(driver, test, EscortRequired, "Selected escort required as : " + Escort);
		}

		Wait.waitfor(3);
		typeText(driver, test, OCR_CountryOfCitizenship, "Enter Country of Citizenship : ", CountryofCitizenship);
		Wait.waitfor(3);
		if (TypeOfPerson.contains("Foreign Person")) {
			clickElement(driver, test, OCR_VisitorRepresentingForeignInterestToggle, "Enable toggle button");
			typeText(driver, test, OCR_VisitorRepresentingForeignInterest,
					"Enter Representing Foreign Interest Country : ", RepresentingForeignInterest);
		}
		typeText(driver, test, OCR_OtherCountryOfCitizenship, "Enter  Other Country of Citizenship : ",
				OtherCountriesofCitizenship);
	}

	public void Select_EscortRequired() {

		scrollToElement(driver, "//label[contains(text(), 'Escort Required')]");
		clickElement(driver, test, "(//div[@class='lcs_label lcs_label_off'])[2]", "Click on escort required");
		/*String EscortRequired = "(//div[contains(text(),'" + Escort + "')])[2]";
		System.out.println(EscortRequired);

		if (EscortRequired.equalsIgnoreCase("(//div[contains(text(),'On')])[2]")) {
			clickElement(driver, test, EscortRequired, "Selected escort required as : " + Escort);
		}*/
	}

	// Click on Escort required
	public void click_EscortRequied(String EscortRequired) {
		if (EscortRequired.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, "//label[contains(text(),'Type of Person')]", "");
			clickElement(driver, test, "(//div[@class = 'lcs_switch lcs_off lcs_checkbox_switch'])[2]",
					"Move Escort required to : " + EscortRequired);
		}
	}

	// Add Additional Details
	public void add_AdditionalDetails(String DateofBirth, String PlaceofBirth, String CountryofBirth, String Gender) {
		scrollToElement(driver, "//a[@class='accordion-toggle']//label[contains(text(),'Citizenship')]");
		clickElement(driver, test, OCR_DateofBirth, "Clicking on Date of Birth");
		date(driver, test, "Select the Date of Birth : ", DateofBirth);
		typeText(driver, test, OCR_PlaceofBirth, "Enter  Place of Birth : ", PlaceofBirth);
		typeText(driver, test, OCR_CountryofBirth, "Enter  Country of Birth : ", CountryofBirth);
		if (Gender.equalsIgnoreCase("Male")) {
			clickElement(driver, test, OCR_Male, "Select Male");
		} else {
			clickElement(driver, test, OCR_Female, "Select Female");
		}
	}

	// Add Identifying Documents
	public void add_IdentifyingDocuments(String IdentifyingDocuments, String DocumentNumber, String ExpirationDate,
			String IssuingState, String IssuingCountry) {
		scrollToElement(driver, "//a[@class='accordion-toggle']//label[contains(text(),'Citizenship')]");
		if (IdentifyingDocuments.length() > 0) {
			selectByVisibleText(driver, test, OCR_IdentifyingDocuments, "Select Identifying Documents : ",
					IdentifyingDocuments);
			typeText(driver, test, OCR_IDDocumentNumber, "Enter Document Number : ", DocumentNumber);
			clickElement(driver, test, OCR_IDExpirationDate, "Click on Expiration Date");
			date(driver, test, "Select the Expiration Date : ", ExpirationDate);
			typeText(driver, test, OCR_IDIssuingCountry, "Enter Passport Issuing Country : ", IssuingCountry);
			typeText(driver, test, OCR_IDIssuingState, "Enter Issuing State : ", IssuingState);
		} else {
			clickElement(driver, test, OCR_NoIdentifyingDocumentsRequired, "Select No Identifying Documents Required");
		}
	}

	// Add Equipments
	public void add_AddEquipment(String EquipDescription, String EquipJustification) {
		scrollToElement(driver, OCR_IdentifyingDocuments);
		List<WebElement> equipmentcheckboxes = driver.findElements(By.xpath(OCR_EquipmentCheckBoxList));
		for (int i = 0; i < equipmentcheckboxes.size(); i++) {
			WebElement checkboxes = equipmentcheckboxes.get(i);
			checkboxes.click();
		}
		typeText(driver, test, OCR_EquipmentDescription, "Enter Description : ", EquipDescription);
		typeText(driver, test, OCR_EquipmentJustification, "Enter Justification : ", EquipJustification);
	}

	// Getting the no of organization added in the result grid
	public int orgcount() {
		String orgtable = "//table[@id='gridOrg']/tbody/tr";
		List<WebElement> orgrows = driver.findElements(By.xpath(orgtable));
		if (orgrows.size() > 0) {
			return orgrows.size() - 1;
		} else {
			return 0;
		}
	}

	// change the DPL status if required
	public void click_DplStatus() throws InterruptedException {
		try {
			String flag = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-red' or @class='fa ocr-flag-field fa-flag ocr-flag-green']";
			String persontable = "//table[@id='grid']/tbody/tr";
			Wait.wait(driver, OCR_loadinglocator);
			Wait.waitfor(3);
			List<WebElement> flags = driver.findElements(By.xpath(flag));
			List<WebElement> personrows = driver.findElements(By.xpath(persontable));
			int flagcount = flags.size();
			int personcount = personrows.size() - 1;
			int rowscount = personcount + orgcount();
			if (rowscount == flagcount) {
				if (OCR_VisitorInfo_DplStatusRed != null) {
					List<WebElement> row = driver.findElements(By.xpath(OCR_VisitorInfo_DplStatusRed));
					Iterator<WebElement> i = row.iterator();
					while (i.hasNext()) {
						i.next();
						Wait.waitfor(2);
						Wait.wait(driver, OCR_VisitorInfo_DplStatusRed);
						Wait.waitfor(3);
						String scroll = "//button[contains(text(),'Add From Excel')]";
						GenericMethods.scrollToElement(driver, scroll);
						clickElement(driver, test, OCR_VisitorInfo_DplStatusRed, "Click DPL flag");
						Wait.waitfor(3);
						clickElement(driver, test, OCR_VisitorInfo_ViewDetailOverride, "Clicking on Override");
						Wait.waitfor(4);
						clickElement(driver, test, OCR_VisitorInfo_DisptnReasonMatrix,
								"Select the Disposition Reason Matrix");
						clickElement(driver, test, OCR_VisitorInfo_DisptnReasonMatxSave,
								"Clicking on Disposition Reason Matrix Save");
						test.log(LogStatus.PASS, "Change the DPL Status from Red to Green");
					}
				} else {
					isDisplayed(driver, OCR_VisitorInfo_DplStatusGreen);
					test.log(LogStatus.PASS, "DPL Status is Green");
				}
			} else {
				test.log(LogStatus.FAIL, "DPl Flag is missing");
				testFailSshot(driver, test);
			}
		} catch (Exception e) {
			e.printStackTrace();
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VisitorInfo_DRMclose, "click on cancle");
			test.log(LogStatus.FAIL, "Click on cancle");
		}
	}

	// click on move to next arrow
	public void movetonextpage() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_ForwardNavigation, "Click on forward navigation button");
	}

	// clicking on add organization button in visitor screen
	public void click_AddOrganization() {
		clickElement(driver, test, OCR_Button_AddOrganisation, "Clicking on Add Organisation Button");
		Wait.waitfor(3);
	}

	// validating the error in add orginations
	public void validate_addOrganizationError() {
		clickElement(driver, test, OCR_Button_AddOrganisation, "Clicking on Add Organisation Button");
		clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Org Name is required.')]")) {
					test.log(LogStatus.INFO, "Org Name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Org Type is required.')]")) {
					test.log(LogStatus.INFO, "Org Type is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Country is required.')]")) {
					test.log(LogStatus.INFO, "Country is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Country of Incorporation is required.')]")) {
					test.log(LogStatus.INFO, "Country of Incorporation is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'City is required.')]")) {
					test.log(LogStatus.INFO, "City is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation for organizations is not Displayed by clicking on SAVE & Return button");
		}
	}

	// add org Warning
	public void validate_addOrganizationWarning(String OrgName, String OrgType, String City, String Country,
			String CountryOfIncorporation, String Zip, String State) {

		typeText(driver, test, OCR_OrgName, "Enter Organisation Name : ", OrgName);
		selectByVisibleText(driver, test, OCR_OrgType, "Select Org Type : ", OrgType);
		typeText(driver, test, OCR_OrgCity, "Enter City : ", City);
		System.out.println(Country);
		typeText(driver, test, OCR_OrgCountry, "Enter Country : ", Country);
		typeText(driver, test, OCR_OrgCountryOfIncorporation, "Enter CountryOfIncorporation : ",
				CountryOfIncorporation);
		clickElement(driver, test, "//button[contains(text(),'Save')]", "Clicking on Save Button");
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Warning!')]")) {
				if (isDisplayed(driver, "//span[text()='Zip is required prior to submission.']")) {
					test.log(LogStatus.INFO, "Zip is required prior to submission.");
				}
				if (isDisplayed(driver, "//span[text()='State is required prior to submission.']")) {
					test.log(LogStatus.INFO, "State is required prior to submission.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Warning Vaildation for organizations is not Displayed by clicking on SAVE button");
		}
		typeText(driver, test, OCR_OrgZip, "Enter Zip :  ", Zip);
		typeText(driver, test, OCR_OrgState, "Enter State : ", State);
		String state = "//div[contains(text(),'" + State + "')]";
		Wait.waitfor(3);
		clickElement(driver, test, state, "click on State : " + State);
		clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");
	}

	// clicking on add visitor
	public void click_AddVisitor() {
		clickElement(driver, test, OCR_Button_AddVisitor, "Clicking on Add Visitor");
		Wait.waitfor(5);
	}

	// add/edit individual Error
	public void validate_addEditIndividualError() {
		clickElement(driver, test, OCR_Button_AddVisitor, "Clicking on Add Visitor");
		clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'First Name is required.')]")) {
					test.log(LogStatus.INFO, "First Name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Last Name is required.')]")) {
					test.log(LogStatus.INFO, "Last Name is required.");
				}
				/*
				 * if (isDisplayed(driver, "//li[contains(text(),'Company is required.')]")) {
				 * test.log(LogStatus.INFO, "Company is required."); }
				 */
			}
			clickElement(driver, test, OCR_Button_Cancel, "Clicking on Cancel Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation for  Add/Edit individual is not Displayed by clicking on SAVE button");
		}
	}

	// add/edit individual Warning
	public void validate_addEditIndividualWarning(String Title, String FirstName, String MiddleName, String LastName,
			String Company, String VisitorEmail, String PhoneNumber, String VCountry, String TypeOfPerson,
			String CountryofCitizenship, String DateofBirth, String PlaceofBirth) {

		add_Individual(Title, FirstName, MiddleName, LastName, VisitorEmail, PhoneNumber);
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Warning!')]")) {
				if (isDisplayed(driver, "//span[text()='Country of Citizenship is required prior to submission.']")) {
					test.log(LogStatus.INFO, "Country of Citizenship is required prior to submission.");
				}
				if (isDisplayed(driver, "//span[text()='Type of Person is required prior to submission.']")) {
					test.log(LogStatus.INFO, "Type of Person is required prior to submission.");
				}
				if (isDisplayed(driver, "//span[text()='Place of Birth is required prior to submission.']")) {
					test.log(LogStatus.INFO, "Place of Birth is required prior to submission.");
				}
				if (isDisplayed(driver, "//span[text()='Date of Birth is required prior to submission.']")) {
					test.log(LogStatus.INFO, "Date of Birth is required prior to submission.");
				}
				if (isDisplayed(driver, "//span[text()='Address Country is required prior to submission.']")) {
					test.log(LogStatus.INFO, "Address Country is required prior to submission.");
				}
				if (isDisplayed(driver, "//span[text()='One Identifying Document is required prior to submission.']")) {
					test.log(LogStatus.INFO, "One Identifying Document is required prior to submission.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Warning Vaildation for  Add/Edit individual is not Displayed by clicking on SAVE button");
		}
		typeText(driver, test, OCR_VisitorCountry, "Enter Country : ", VCountry);
		selectByVisibleText(driver, test, OCR_TypeOfPerson, "Enter Type Of Person : ", TypeOfPerson);
		typeText(driver, test, OCR_CountryOfCitizenship, "Enter Country of Citizenship : ", CountryofCitizenship);
		try {
			clickElement(driver, test, "//button[@id='cancel']", "Click on No");
		} catch (Exception e) {
			Wait.waitfor(3);
		}
		Wait.waitfor(3);
		scrollToElement(driver, "//a[@class='accordion-toggle']//label[contains(text(),'Citizenship')]");
		clickElement(driver, test, OCR_DateofBirth, "Clicking on Date of Birth");
		date(driver, test, "Select the Date of Birth : ", DateofBirth);
		typeText(driver, test, OCR_PlaceofBirth, "Enter  Place of Birth : ", PlaceofBirth);
		scrollToElement(driver, "//h3[@class='page-heading']");
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'Save')]", "Clicking on Save Button");
	}

	// Validate invalid DOB error message
	public void validate_InvalidDOB(String InValidDOB, String DateofBirth) {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'DOB can not be of future date.')]")) {
					test.log(LogStatus.PASS, "DOB can not be of future date");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "DOB accepting future date also");
		}
		clickElement(driver, test,
				"//div[@class='alert fade in alert-danger']//a[@class='close'][contains(text(),'×')]",
				"Clicking on cancle icon");
		clickElement(driver, test, OCR_DateofBirth, "Clicking on Date of Birth");
		date(driver, test, "Select the Date of Birth : ", DateofBirth);

	}

	// add/edit individual Warning for Identity document.
	public void validate_IdentityDocWarning(String IdentifyingDocuments) {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Warning!')]")) {
				if (isDisplayed(driver, "//span[text()='One Identifying Document is required prior to submission.']")) {
					test.log(LogStatus.INFO, "One Identifying Document is required prior to submission.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Warning Vaildation for  Add/Edit individual is not Displayed by clicking on SAVE button");
		}
		selectByVisibleText(driver, test, OCR_IdentifyingDocuments, "Select Identifying Documents : ",
				IdentifyingDocuments);
		scrollToElement(driver, "//h3[@class='page-heading']");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[text()='Document No. is required.']")) {
					test.log(LogStatus.INFO, "Document No. is required.");
				}
				if (isDisplayed(driver, "//li[text()='Document Issuing State is required.']")) {
					test.log(LogStatus.INFO, "Document Issuing State is required.");
				}
				if (isDisplayed(driver, "//li[text()='Document Issuing Country is required.']")) {
					test.log(LogStatus.INFO, "Document Issuing Country is required.");
				}
				if (isDisplayed(driver, "//li[text()='Document Expriation Date is required.']")) {
					test.log(LogStatus.INFO, "Document Expriation Date is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation for Identifying Document is not Displayed by clicking on SAVE button");
		}
		Wait.waitfor(3);
	}

	// Click on Save and Return Button
	public void saveAndReturnBtn() {
		scrollToElement(driver, "//h3[@class='page-heading']");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SaveReturn, "Clicking on Save and Return Button");

	}

	public String get_domestic_foreign() {
		return getText(driver, test, OCR_DomesticForeign, "Domestic/Foreign Value is : ");
	}

	// Adding data from excel
	public void addfromexcel() {
		clickElement(driver, test, OCR_Button_AddFromExcel, "Adding From Excel");
		Wait.waitfor(3);
		try {
			clickElement(driver, test, OCR_Button_UploadFile, " click on Uploading the excel");
			uploadFile(driver, test, "Add_Visitor_Info.xlsx", "Uploading the excel : Add_Visitor_Info.xlsx");
			Wait.waitfor(20);
			if (isEnabled(driver, OCR_Button_Ok)) {
				clickElement(driver, test, OCR_Button_Ok, "Clicking on Ok Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@class='close closet']", "Clicking on cancle icon");
		}
	}

	// Verify Send Invite is working fine
	public void verifySendInvite() {
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='cb_grid']", "Select the Visitor");
		clickElement(driver, test, OCR_VisitorInfo_SendInvite, "Click on Send Invite");
		clickElement(driver, test, "//button[@name='save']", "Click on Send Button");
		String email_text = driver.findElement(By.xpath(" //div[@class='form-group']/label")).getText();
		if (email_text.contains("A notification will be sent to the following individuals:")) {
			clickElement(driver, test, "//button[contains(text(),'OK')]", "Click on On Ok Button");
		} else {
			clickElement(driver, test, "(//button[@class='close'])[1]", "Unable to Send Email, Click on Cancel Button");
		}
	}

	// Verify the Send Invite of attach File
	public void verifyAttachFile() {
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='cb_grid']", "Select the Visitor");
		clickElement(driver, test, OCR_VisitorInfo_SendInvite, "Click on Send Invite");

		try {
			isDisplayed(driver, "//button[@id='attach']");
			test.log(LogStatus.PASS, "Send invite is Enable");
			clickElement(driver, test, "//button[@id='attach']", "Click on Attach file");
			Wait.waitfor(5);
			clickElement(driver, test, "//div//span[@class='btn fileinput-button']", "click on upload file");
			uploadFile(driver, test, "Capture.PNG", "Uploaded the File");
			Wait.waitfor(4);
			clickElement(driver, test, "//button[contains(text(),'Submit')]", "Click on Submit button");
			Wait.waitfor(4);
			isDisplayed(driver, "//span[contains(text(),'Capture.PNG')]");
			Wait.waitfor(4);
			clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
		}
	}

	// verify the send Invite of attach file is disable
	public void sendInviteDisable() {
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='cb_grid']", "Select the Visitor");
		clickElement(driver, test, OCR_VisitorInfo_SendInvite, "Click on Send Invite");
		try {
			isDisplayed(driver, "//button[@id='attach']");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Send invite is Enable");
		}
		clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
	}
	// Validating wrong Email and Update Email BY Ajit
			public void validateVEmail(String VEmail) {

				saveAndReturnBtn();
				Wait.waitfor(3);
				String sucessmesg = getText(driver, test, OCR_VisitorValidationmessage , "Get the Message : ");
				if (sucessmesg.equals("Invalid Email Address.")) {
					test.log(LogStatus.PASS, "Form heading  displayed ");
				} else {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Form heading is incorrect or not displayed");
				}
				clearText(driver, test, OCR_VisitorEmail, "Clear the Email");
				Wait.waitfor(3);
				typeText(driver, test, OCR_VisitorVEmail, "Enter the Email : ", VEmail);
				
				saveAndReturnBtn();
			}

	// Validating Edit Email
	public void validateEditEmail(String FirstName, String Email) {

		clickElement(driver, test, "//a[contains(text(),'" + FirstName + "')]", "Click on Visitor Name Link");
		Wait.waitfor(3);
		clearText(driver, test, OCR_VisitorEmail, "Clear the Email");
		typeText(driver, test, OCR_VisitorEmail, "Enter the Email : ", Email);
		saveAndReturnBtn();
		clickElement(driver, test, "//a[contains(text(),'" + FirstName + "')]", "Click on Visitor Name Link");
		Wait.waitfor(3);
		String email = getAttribute(driver, test, OCR_VisitorEmail, "value", "Get the value of Email ");
		if (email.equals(Email)) {
			test.log(LogStatus.PASS, "Email is update with " + Email);
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Email is update with " + Email);
		}
	}

	// Add the Representing Foreign Interest
	public void addRepresentingForeignInterest(String OrgName, String CountryName) {
		Wait.waitfor(3);
		clickElement(driver, test, "//a[contains(text(),'" + OrgName + "')]", "Click on Org Name");
		clickElement(driver, test, OCR_OrgRepresentingForeignInterest,
				"click on Representing Foreign Interest Check box");
		typeText(driver, test, OCR_OrgRepForeignCountry, "Enter the Country : ", CountryName);
		clickElement(driver, test, "//button[@name='save']", "Click on Save");
		Wait.waitfor(3);
		String country = getAttribute(driver, test, OCR_OrgRepForeignCountry, "value", "Get the Country Name : ");
		if (country.equals(CountryName)) {
			test.log(LogStatus.PASS, "Representing Foreign Interest Country is saved as : " + country);
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Representing Foreign Interest Country is saved as : " + country);
		}
	}

	// Validating Result Grid of Add Visitor
	public void validateAddVisitorGrid(String OrgName, String OrgType, String City, String Zip, String Country,
			String State, String CountryOfIncorporation, String Title, String FirstName, String MiddleName,
			String LastName, String VisitorEmail, String PhoneNumber) {
		Wait.wait(driver, OCR_Button_AddVisitor);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_AddVisitor, "Clicking on Add Visitor");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_AddOrganisation, "Clicking on Add Organisation Button");
		Wait.waitfor(5);
		typeText(driver, test, OCR_OrgName, "Enter Organisation Name : ", OrgName);
		selectByVisibleText(driver, test, OCR_OrgType, "Select Org Type : ", OrgType);
		typeText(driver, test, OCR_OrgState, "Enter State : ", State);
		typeText(driver, test, OCR_OrgCity, "Enter City : ", City);
		typeText(driver, test, OCR_OrgZip, "Enter Zip : ", Zip);
		typeText(driver, test, OCR_OrgCountry, "Enter Country : ", Country);
		Wait.waitfor(3);
		clickElement(driver, test, "(//div[contains(text(),'" + Country + "')])[1]", "Select the Country : " + Country);
		Wait.waitfor(3);
		typeText(driver, test, OCR_OrgCountryOfIncorporation, "Enter CountryOfIncorporation : ",
				CountryOfIncorporation);
		clickElement(driver, test, "(//button[contains(text(),'Save & Return')])[3]", "Click on Save and Return");
		Wait.waitfor(3);
		typeText(driver, test, OCR_VisitorTitle, "Enter Title : ", Title);
		typeText(driver, test, OCR_VisitorFirstName, "Enter Visitor First Name : ", FirstName);
		typeText(driver, test, OCR_VisitorMiddleName, "Enter Visitor Middle Name : ", MiddleName);
		typeText(driver, test, OCR_VisitorLastName, "Enter Visitor Last Name : ", LastName);
		typeText(driver, test, OCR_VisitorEmail, "Enter Visitor Email : ", VisitorEmail);
		typeText(driver, test, OCR_VisitorPhoneNo, "Enter Visitor Phone No : ", PhoneNumber);
		saveAndReturnBtn();
		try {
			Wait.waitfor(3);
			isDisplayed(driver, "//a[contains(text(),'" + FirstName + "')]");
			clickElement(driver, test, "//a[contains(text(),'" + FirstName + "')]", "Click on Visitor Name Link");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the visitor in Result Grid");
		}

	}

}