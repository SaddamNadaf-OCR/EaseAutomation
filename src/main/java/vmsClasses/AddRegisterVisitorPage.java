package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddRegisterVisitorPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;
	
	public static final String OCR_Files_RegisterVisitors="(//a[contains(text(),'Registered Visitors')])";
	public static final String OCR_ARVisitor_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_ARVisitor_Reset="//button[contains(text(),'Reset')]";
	public static final String OCR_ARVisitor_AddRegisterVisitor="//button[contains(text(),'Add Registered Visitors')]";
	public static final String OCR_ARVisitor_AddFromExcel="//button[contains(text(),'Add From Excel')]";
	public static final String OCR_ARVisitor_Save="(//button[@name='save'])[1]";
	public static final String OCR_ARVisitor_SaveAndReturn="(//button[@name='ok'])[1]";
	public static final String OCR_ARVisitor_Cancel="//button[@name='cancel']";
	//-------------------------------------------------------------Individual-------------
	public static final String OCR_ARVisitor_Title="//input[@id='editRegisteredVisitors_visitorRegistrationValue_title']";
	public static final String OCR_ARVisitor_FirstName="//input[@id='editRegisteredVisitors_visitorRegistrationValue_firstName']";
	public static final String OCR_ARVisitor_MiddleName="//input[@id='editRegisteredVisitors_visitorRegistrationValue_middleName']";
	public static final String OCR_ARVisitor_LastName="//input[@id='editRegisteredVisitors_visitorRegistrationValue_lastName']";
	public static final String OCR_ARVisitor_Email="//input[@id='editRegisteredVisitors_visitorRegistrationValue_email']";
	public static final String OCR_ARVisitor_PhoneNumber="//input[@id='editRegisteredVisitors_visitorRegistrationValue_phone']";
	//-------------------------------------------------------------Address details--------------
	public static final String OCR_ARVisitor_Address="//input[@id='editRegisteredVisitors_visitorRegistrationValue_address1']";
	public static final String OCR_ARVisitor_City="//input[@id='editRegisteredVisitors_visitorRegistrationValue_city']";
	public static final String OCR_ARVisitor_State="//input[@id='editRegisteredVisitors_visitorRegistrationValue_state']";
	public static final String OCR_ARVisitor_Zip="//input[@id='editRegisteredVisitors_visitorRegistrationValue_zip']";
	public static final String OCR_ARVisitor_Country="//input[@id='editRegisteredVisitors_visitorRegistrationValue_country']";
	//-------------------------------------------------------------Citizen--------------
	public static final String OCR_ARVisitor_TypeOfPerson="//select[@id='editRegisteredVisitors_visitorRegistrationValue_typeOfPerson']";
	public static final String OCR_ARVisitor_COR="//input[@id='editRegisteredVisitors_visitorRegistrationValue_countryOfResidence']";
	public static final String OCR_ARVisitor_RFIntress="//input[@id='editRegisteredVisitors_visitorRegistrationValue_repCountry']";
	public static final String OCR_ARVisitor_ViisitorCategory="//select[@id='editRegisteredVisitors_visitorRegistrationValue_visitorCategoryId']";
	public static final String OCR_ARVisitor_Coc="//input[@id='editRegisteredVisitors_visitorRegistrationValue_countryOfCitizenship']";
	public static final String OCR_ARVisitor_Ococ="//input[@id='editRegisteredVisitors_visitorRegistrationValue_otherCountryOfCitizenship']";
	//-------------------------------------------------------------Additional Details---------------
	public static final String OCR_ARVisitor_DateOfBirth="//input[@id='editRegisteredVisitors_dateOfBirth']";
	public static final String OCR_ARVisitor_PlaceOfBirth="//input[@id='editRegisteredVisitors_visitorRegistrationValue_placeOfBirth']";
	public static final String OCR_ARVisitor_CountryofBirth="//input[@id='editRegisteredVisitors_visitorRegistrationValue_countryOfBirth']";
	public static final String OCR_ARVisitor_Male="//input[@id='editRegisteredVisitors_visitorRegistrationValue_maleOrFemaleM']";
	public static final String OCR_ARVisitor_Female="//input[@id='editRegisteredVisitors_visitorRegistrationValue_maleOrFemaleF']";
	//--------------------------------No Identifying document---------------------
	public static final String OCR_ARVisitor_NoIdentifyingDocument="//input[@id='idDocCheck']";
	public static final String OCR_ARVisitor_IdentifyingDocument="//select[@id='editRegisteredVisitors_docTypeId']";
	public static final String OCR_ARVisitor_DocumentNumber="//input[@id='editRegisteredVisitors_registrationDocumentValue_docNo']";
	public static final String OCR_ARVisitor_IssState="//input[@name='registrationDocumentValue.docIssState']";
	public static final String OCR_ARVisitor_IssCountry="//input[@name='docIssCountry']";
	public static final String OCR_ARVisitor_ExpirationDate="//input[@id='editRegisteredVisitors_docExpDate']";
	public static final String OCR_ARVisitor_AddID="//button[contains(text(),'Add ID')]";
	public static final String OCR_ARVisitor_Delate="//button[contains(text(),'Delete')]";
	
	/*--------------------------------Constructor------------------------------------------*/

	public AddRegisterVisitorPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	//-------------------------------------------Click on search------------------
		public void click_search() {
			clickElement(driver, test, OCR_ARVisitor_Search, "Click on search button");
		}
		
		public void select_RegisterVisitor() {
			clickElement(driver, test, OCR_Files_RegisterVisitors, "Click on Register Visitor");
		
		}
		public void Click_Save() {
			
			clickElement(driver, test, OCR_ARVisitor_Save, "Click on Save button");
		}
		
		public void Click_SaveAndReturn() {
			
			clickElement(driver, test, OCR_ARVisitor_SaveAndReturn, "Click on Save and Return button");
		}
		
		public void Click_Cancle() {
			clickElement(driver, test, OCR_ARVisitor_Cancel, "Click On Cancle Button");
		}
		
		//----------------Click on Add registration----------------
		public void Click_AddRegisterVisitor() {
			clickElement(driver, test, OCR_ARVisitor_AddRegisterVisitor, "Click on Add Register Visitor");
		}
		
		//--------------------Add Individual----------------------
		public void Add_Individual(String Title, String FirstName, String MiddleName, String LastName, String Email, String PhoneNumber) {
			typeText(driver, test, OCR_ARVisitor_Title, "Add title", Title);
			typeText(driver, test, OCR_ARVisitor_FirstName, "Add FirstName", FirstName);
			typeText(driver, test, OCR_ARVisitor_MiddleName, "Add MiddleName", MiddleName);
			typeText(driver, test, OCR_ARVisitor_LastName, "Add LastName", LastName);
			typeText(driver, test, OCR_ARVisitor_Email, "Add Email", Email);
			typeText(driver, test, OCR_ARVisitor_PhoneNumber, "Add PhoneNumber", PhoneNumber);
		}
		//--------------------------Add Address-----------------------
		public void Add_AddressDetails(String Country, String State, String Zip, String City, String Address) {
			
			typeText(driver, test, OCR_ARVisitor_Country, "Add country", Country);
			typeText(driver, test, OCR_ARVisitor_State, "Add State", State);
			typeText(driver, test, OCR_ARVisitor_Zip, "Add Zip", Zip);
			typeText(driver, test, OCR_ARVisitor_City, "Add City", City);
			typeText(driver, test, OCR_ARVisitor_Address, "Add Address", Address);	
		}
		
		//-----------------------Add CitizenShip-------------
		public void Add_CitizenShip(String TypeOfPerson, String VisitorCategory, String COC, String OCOC) {
			typeText(driver, test, OCR_ARVisitor_TypeOfPerson, "Add TypeOfPerson", TypeOfPerson);
			selectByVisibleText(driver, test, OCR_ARVisitor_ViisitorCategory, "Select Visitor Category", VisitorCategory);
			typeText(driver, test, OCR_ARVisitor_Ococ, "Add OCOC", OCOC);
			typeText(driver, test, OCR_ARVisitor_Coc, "Add COC", COC);
			
		}
		
		
		//-----------------------------Add Additional Details------------------
		public void Add_AdditionalDetails(String DateOfBirth, String PlaceOfBirth, String CountryOfBirth) {
			//scrollToElement(driver, OCR_ARVisitor_DateOfBirth);
	    	scrollToBottom(driver);
	    	Wait.waitfor(2);
			clickElement(driver, test, OCR_ARVisitor_DateOfBirth, "Add date of birth");
			date(driver, test, "Select the Birth date : " , DateOfBirth);
			typeText(driver, test, OCR_ARVisitor_PlaceOfBirth, "Add place of Birth", PlaceOfBirth);
			typeText(driver, test, OCR_ARVisitor_CountryofBirth, "Add Country of Birth", CountryOfBirth);
		}
			
		public void Add_IdentifyingDocument(String IdentifyingDocument, String DocumentNumber) {
			selectByVisibleText(driver, test, OCR_ARVisitor_IdentifyingDocument, "Select Identifying Document", IdentifyingDocument);
			typeText(driver, test, OCR_ARVisitor_DocumentNumber, "Add Document Number", DocumentNumber);
			
		
			//typeText(driver, test, OCR_ARVisitor_ExpirationDate, "Add Expiration date", ExpirationDate);
			
		}
		public void Add_IssCountry(String IssCountry) {
			typeText(driver, test, OCR_ARVisitor_IssCountry, "Select Issuing Country", IssCountry);
			
		}
		
		public void Add_IssState(String IssState) {
			typeText(driver, test, OCR_ARVisitor_IssState, "Select State", IssState);
		}
		
		public void select_ExpirationDate(String ExpiratiponDate) {
			clickElement(driver, test, OCR_ARVisitor_ExpirationDate,"Clicking on Expiration date" );
			Wait.waitfor(3);
			date(driver, test, "Select the Expiration date : " , ExpiratiponDate);
			scrollToElement(driver, OCR_ARVisitor_AddID);
		}
			
		public void Add_AddID() {
			
			clickElement(driver, test, OCR_ARVisitor_AddID, "Click on Add ID");
			scrollToElement(driver, OCR_ARVisitor_Save);
		}
}
