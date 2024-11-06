package vmsClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Wait;

public class AddOrEditIndividualPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddEditInd_OrgAssociated = "//div[@class='item']";
	public static final String OCR_AddEditInd_Title = "//input[@id='VMM_FLD_122']";
	public static final String OCR_AddEditInd_FirstName = "//input[@id='VMM_FLD_123']";
	public static final String OCR_AddEditInd_MiddleName = "//input[@id='VMM_FLD_124']";
	public static final String OCR_AddEditInd_LastName = "//input[@id='VMM_FLD_125']";
	public static final String OCR_AddEditInd_Freqntvistor = "//input[@id='VMM_FLD_126']";	
	public static final String OCR_AddEditInd_VisitorEmail = "//input[@id='VMM_FLD_127']";
	public static final String OCR_AddEditInd_VisitorPhone = "//input[@id='VMM_FLD_128']";
	public static final String OCR_AddEditInd_BadgeType ="//select[@id='VMM_FLD_129']";
	public static final String OCR_AddEditInd_BadgeNo ="//input[@id='VMM_FLD_130']";
	public static final String OCR_AddEditInd_EscortReq ="//input[@id='VMM_FLD_131']";
	public static final String OCR_AddEditInd_ACSBadgeId = "//input[@name='visitorPersonValue.acsBadgeId']";
	public static final String OCR_AddEditInd_TypeOfPerson ="//select[@id='VMM_FLD_132']";
	public static final String OCR_AddEditInd_VisCategory = "//select[@id='VMM_FLD_187']";
	public static final String OCR_AddEditInd_countryOfcitz ="//input[@id='VMM_FLD_133']";
	public static final String OCR_AddEditInd_Address ="//input[@id='VMM_FLD_134']";
	public static final String OCR_AddEditInd_Address2 ="//input[@id='VMM_FLD_135']";
	public static final String OCR_AddEditInd_Address3 ="//input[@id='VMM_FLD_136']";
	public static final String OCR_AddEditInd_City ="//input[@id='VMM_FLD_137']";
	public static final String OCR_AddEditInd_State ="//input[@id='VMM_FLD_138']";
	public static final String OCR_AddEditInd_Zip ="//input[@id='VMM_FLD_139']";
	public static final String OCR_AddEditInd_Country ="//input[@id='VMM_FLD_140']";
	public static final String OCR_AddEditInd_OtherCountryOfCitz = "//input[@id='VMM_FLD_141']";
	public static final String OCR_AddEditInd_NoIdentifyingDocReq = "//input[@id='VMM_FLD_142']";
	public static final String OCR_AddEditInd_IdentifyingDocs = "//select[@id='VMM_FLD_143']";	
	public static final String OCR_AddEditInd_DocumentNo = "//input[@id='editVisitorRapidCheckInPerson_visitorPersonDocumentValue_docNo']";
	public static final String OCR_AddEditInd_IssuingState  = "//input[@id='editVisitorRapidCheckInPerson_visitorPersonDocumentValue_docIssState']";
	public static final String OCR_AddEditInd_IssuingCountry = "//input[@id='editVisitorRapidCheckInPerson_docIssCountry']";
	public static final String OCR_AddEditInd_ExpirationDate = "//input[@id='editVisitorRapidCheckInPerson_docExpDate']";
	public static final String OCR_VisitorInfo_DatePickerYear ="//select[@class='ui-datepicker-year']";  
	public static final String OCR_VisitorInfo_DatePickerMonth="//select[@class='ui-datepicker-month']";
	public static final String OCR_AddEditInd_ReqVisitorLaptops = "//input[@id='VMM_FLD_144']";
	public static final String OCR_AddEditInd_ReqVisitorCellPhone = "//input[@id='VMM_FLD_146']";
	public static final String OCR_AddEditInd_ReqVisitorStorageMedia = "//input[@id='VMM_FLD_148']"; 
	public static final String OCR_AddEditInd_ReqVisitorPDA = "//input[@id='VMM_FLD_145']";
	public static final String OCR_AddEditInd_ReqVisitorCmPhone = "//input[@id='VMM_FLD_147']";
	public static final String OCR_AddEditInd_ReqVisitorCamera = "//input[@id='VMM_FLD_149']";
	public static final String OCR_AddEditInd_ReqOtherRestrictedItem = "//input[@id='VMM_FLD_150']";
	public static final String OCR_AddEditInd_EquipmentDescription = "//textarea[@id='VMM_FLD_151']";
	public static final String OCR_AddEditInd_ReqVisitorJustification = "//textarea[@id='VMM_FLD_152']";
	public static final String OCR_AddEditInd_UploadImg = "//a[@id='uploadImageFiles']";
	public static final String OCR_AddEditInd_UploadImgButn = "//button[@id='uploadImageBtn']";
	public static final String OCR_AddEditInd_SelectButn = "//button[contains(text(),'Select')]";
	public static final String OCR_AddEditInd_SaveBtn = "//button[@class='primary-btn changeable']";
	public static final String OCR_AddEditInd_SaveAndReturnBtn = "//button[contains(text(),'Save & Return')]"; //button[@class='primary-btn changeable'][2]";
	public static final String OCR_AddEditInd_BackBtn = "//button[contains(text(),'Back')]";
	public static final String OCR_AddEditInd_AddOrganization = "//button[contains(text(),'Add Organization')]";

	/* ******************** Constructor ***************************** */

	public AddOrEditIndividualPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// select Organization Associated
	public void select_OrgAssociated(String OrgAssociated) throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddEditInd_FirstName, "");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_AddEditInd_OrgAssociated, "click on Organization Associated");		
		Wait.waitfor(3);
		String OrgAsscted = "//div[contains(text(),'"+OrgAssociated.trim()+"')]";			
		clickElement(driver, test, OrgAsscted, "Selected Organization Associated as : "+OrgAssociated);
	}	

	// Enter Title
	public void type_Title(String Title) {		
		typeText(driver, test, OCR_AddEditInd_Title, "Enter Title : ", Title);		
	}

	// Enter First Name
	public void type_FirstName(String FirstName) {
		typeText(driver, test, OCR_AddEditInd_FirstName, "Enter First Name : ", FirstName);
	}

	// Enter Middle Name
	public void type_MiddleName(String MiddleName) {
		typeText(driver, test, OCR_AddEditInd_MiddleName, "Enter Middle Name : ", MiddleName);
	}

	// Enter Last Name
	public void type_LastName(String LastName) {		
		typeText(driver, test, OCR_AddEditInd_LastName, "Enter Last Name : ", LastName);		
	}

	// click Frequent Visitor
	public void select_FreqntVisitor() {
		clickElement(driver, test, OCR_AddEditInd_Freqntvistor,  "Clicking on Frequent Visitor");
	}	

	// Enter Email
	public void type_VisitorEmail(String VisitorEmail){
		typeText(driver, test, OCR_AddEditInd_VisitorEmail,"Enter Visitor Email : ", VisitorEmail);			
	}

	// Enter Visitor Phone
	public void type_VisitorPhone(String VisitorPhone) throws InterruptedException  {
		typeText(driver, test, OCR_AddEditInd_VisitorPhone,"Enter Visitor Phone : ", VisitorPhone);
	}

	//Select badge Type
	public void select_BadgeType(String BadgeType) {		
		selectByVisibleText(driver, test, OCR_AddEditInd_BadgeType,  "Select Badge type : ", BadgeType);	
	}

	//Enter Badge no
	public void type_BadgeNo(String BadgeNo) {
		typeText(driver, test, OCR_AddEditInd_BadgeNo,"Enter Badge no : ", BadgeNo);
	}

	//Enter Escort Required
	public void escortRequired() throws Exception {
		try {
			isSelected(driver, OCR_AddEditInd_EscortReq);
			test.log(LogStatus.PASS, "Escort Required is selected ");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Escort Required is not selected ");
			SeleniumTestBase stb = new  SeleniumTestBase();
			stb.testFail();
		}
	}

	//Enter ACS Badge ID
	public void type_ACSBadgeId(String ACSBadgeId) {
		typeText(driver, test, OCR_AddEditInd_ACSBadgeId, "Enter ACS Badge ID : ", ACSBadgeId);
	}

	// Select type of person
	public void select_Person(String TypeofPerson) {
		selectByVisibleText(driver, test, OCR_AddEditInd_TypeOfPerson, "Select Person : ", TypeofPerson);
	}

	//Select visitor Category
	public void select_Category(String Category) {
		selectByVisibleText(driver, test, OCR_AddEditInd_VisCategory,"Select Category : ", Category);
	}

	//select country of Citizenship
	public void select_Citizenship(String ContryOfcitizenShip) throws InterruptedException {
		try {
			scrollToElement(driver, OCR_AddEditInd_VisitorEmail);
			Wait.waitfor(5);
			clickElement(driver, test, "//button[@id='cancel']", "Click on No");
		} catch (Exception e) {
			
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddEditInd_countryOfcitz, " ");
		typeText(driver, test, OCR_AddEditInd_countryOfcitz, "Enter ContryOfcitizenShip :", ContryOfcitizenShip);
		Wait.waitfor(3);
		String locator="//div[contains(text(),'"+ContryOfcitizenShip.trim()+"')]";
		clickElement(driver, test, locator, "Select Contry Of citizenShip : " +ContryOfcitizenShip);
	}	

	//Enter address
	public void type_Address(String Address) {
		Wait.wait(driver,OCR_AddEditInd_Address);
		clickElement(driver, test, OCR_AddEditInd_Address, " ");
		typeText(driver, test, OCR_AddEditInd_Address, "Enter Address : ", Address);
	}

	//Enter Address2
	public void type_Address2(String Address2) {
		typeText(driver, test,OCR_AddEditInd_Address2 , "Enter Address2 : ", Address2);
	}

	//Enter Address3
	public void type_Address3(String Address3) {
		typeText(driver, test,OCR_AddEditInd_Address3 ,"Enter Address3 : ", Address3);
	}

	//Enter City
	public void type_City(String City) {
		typeText(driver, test,OCR_AddEditInd_City ,"Enter City : ", City);
	}

	//Enter State
	public void type_State(String State) {		
		typeText(driver, test,OCR_AddEditInd_State ,"Enter State : ", State);
		String loc1="//div[contains(text(),'"+State.trim()+"')]";
		Wait.fluwait(driver,loc1);
		//clickElement(driver, test, loc1, "Click State : "+State);
	}

	//Enter Zip
	public void type_Zip(String Zip) {
		typeText(driver, test,OCR_AddEditInd_Zip ,"Enter Zip : ", Zip);
	}

	//Enter Country
	public void type_Country(String Country) {
		typeText(driver, test,OCR_AddEditInd_Country ,"Enter Country : ", Country);
	}

	//Enter Other Country Of Citz
	public void type_OtherCountryOfCitz(String OtherCountryOfCitz) {
		typeText(driver, test,OCR_AddEditInd_OtherCountryOfCitz ,"Enter OtherCountryOfCitz : ", OtherCountryOfCitz);
	}

	//Clicking on No Identifying Doc Required
	public void select_NoIdentifyingDocReq() {
		clickElement(driver, test, OCR_AddEditInd_NoIdentifyingDocReq, "Clicking on NoIdentifyingDocReq");
	}

	//Select identifying Document 
	public void type_IdentifyingDocs(String IdentifyingDocs) {		
		String scroll = "(//a[@class='accordion-toggle'])[3]";
		GenericMethods.scrollToElement(driver, scroll);		
		if(IdentifyingDocs.length()==0) {
			select_NoIdentifyingDocReq();
		}else {
			selectByVisibleText(driver, test, OCR_AddEditInd_IdentifyingDocs, "Select IdentifyingDocs : ", IdentifyingDocs);
		}
	}

	//Enter Document Number
	public void type_DocumentNo(String DocumentNo) {
		typeText(driver, test, OCR_AddEditInd_DocumentNo, "Enter Document Number : ", DocumentNo);		
	}

	//Enter Issuing State
	public void type_IssuingState(String IssuingState) throws InterruptedException {		
		if(IssuingState.length()==0) {
			test.log(LogStatus.PASS, " Issuing State not required ");
		}else {
			typeText(driver, test, OCR_AddEditInd_IssuingState, "Enter Issuing State : ", IssuingState);
			String loc2	= "(//div[contains(text(),'"+IssuingState.trim()+"')])";		
			Wait.fluwait(driver,loc2);
			Wait.waitfor(4);
			System.out.println(loc2);
			//clickElement(driver, test, loc2, "Click Issuing State : "+IssuingState);	

		}
	}

	
	
	
	
	
	//Enter Issuing State locator is different
	public void type_IssuingState2(String IssuingState) throws InterruptedException {		
		if(IssuingState.length()==0) {
			test.log(LogStatus.PASS, " Issuing State not required ");
		}else {
			typeText(driver, test, OCR_AddEditInd_IssuingState, "Enter Issuing State : ", IssuingState);
			String loc2	= "//div[contains(text(),'"+IssuingState.trim()+"')]";		
			Wait.fluwait(driver,loc2);
			Wait.waitfor(2);
			clickElement(driver, test, loc2, "Click Issuing State : "+IssuingState);
		}
	}

	//Enter Issuing Country
	public void type_IssuingCountry(String IssuingCountry) throws InterruptedException {		
		typeText(driver, test, OCR_AddEditInd_IssuingCountry, "Enter Issuing Country : ", IssuingCountry);	
	}

	//Enter Expiration Date
	public void select_ExpiratiponDate(String ExpiratiponDate) {
		clickElement(driver, test, OCR_AddEditInd_ExpirationDate,"Clicking on Expiration date" );
		Wait.waitfor(3);
		date(driver, test, "Select the Expiration date : " , ExpiratiponDate);
	}

	// click on Request Visitor Laptops
	public void select_ReqVisitorLaptop() throws InterruptedException {
		clickElement(driver, test, OCR_AddEditInd_ReqVisitorLaptops, "Clicking on Request Visitor Laptops");
	}

	// click on Request Visitor CellPhone
	public void select_ReqVisitorCellPhone() {
		clickElement(driver, test, OCR_AddEditInd_ReqVisitorCellPhone,"Clicking on Request Visitor CellPhone");
	}

	// click on Request Visitor Storage Media
	public void select_ReqVisitorStorageMedia() {
		clickElement(driver, test, OCR_AddEditInd_ReqVisitorStorageMedia, "Clicking on Request Visitor Storage Media");
	}

	// click on Request Visitor PDA
	public void select_ReqVisitorPDA() {
		clickElement(driver, test, OCR_AddEditInd_ReqVisitorPDA,"Clicking on Request Visitor PDA");
	} 

	// click on Request Visitor Camera Phone
	public void select_ReqVisitorCmPhone() {
		clickElement(driver, test, OCR_AddEditInd_ReqVisitorCmPhone, "Clicking on Request Camera Phone");
	}

	// click on Request Visitor Camera 
	public void select_ReqVisitorCamera() {
		clickElement(driver, test, OCR_AddEditInd_ReqVisitorCamera,"Clicking on Request Camera");
	}

	// click on Request Other Restricted Item  
	public void select_ReqOtherRestrictedItem() {
		clickElement(driver, test, OCR_AddEditInd_ReqOtherRestrictedItem, "Clicking on Request Other Restricted Item");
	}

	// Enter Description
	public void type_Description(String Description) {
		typeText(driver, test, OCR_AddEditInd_EquipmentDescription, "Enter Description : ", Description);
	}

	// Enter Justification
	public void type_Justification (String Justification) throws InterruptedException {
		typeText(driver, test, OCR_AddEditInd_ReqVisitorJustification,  "Enter Justification : ", Justification);
	}

	// click on Upload Image Icon
	public void click_UploadImage() throws InterruptedException{
		Wait.waitfor(5);
		Wait.fluwait(driver,OCR_AddEditInd_UploadImg);		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_AddEditInd_UploadImg)));
		test.log(LogStatus.PASS, "Clicking on Upload Image Icon");
		Wait.waitfor(3);
	}	

	// click on Upload Image Button
	public void click_UploadImageButn() throws InterruptedException {
		Wait.waitfor(3);
		driver.manage().window().maximize();
		clickElement(driver, test, OCR_AddEditInd_UploadImgButn,  "Clicking on Upload Image Button");
	}

	// Click on Select Button
	public void click_SelectButn() throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddEditInd_SelectButn,  "Clicking on Select Button");
	}	

	// Image upload method
	public void ImgUpload() throws FileNotFoundException, IOException, InterruptedException{

		// Store the current window handle
		String winHandleParent = driver.getWindowHandle();

		// Perform the click operation that opens new window		
		click_UploadImage();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		click_UploadImageButn();
		String str = driver.toString();
		//System.out.println(str);
		if(str.contains("internet")) {
			Wait.waitfor(3);
			Runtime.getRuntime().exec("D:\\AutoIT\\uploadIE.exe");
			Wait.waitfor(3);
			System.out.println("select");
		}
		else {
			Runtime.getRuntime().exec("D:\\AutoIT\\uploadchrome.exe");
		}
		click_SelectButn();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleParent);		
	}		

	// click on save  
	public void click_save() throws InterruptedException {
		Wait.wait(driver,OCR_AddEditInd_SaveBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_AddEditInd_SaveBtn)));
		Wait.fluwait(driver,OCR_AddEditInd_SaveBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddEditInd_SaveBtn, "Clicking on Save");
	}

	// click on save and return
	public void click_SaveAndReturn() {	
		scrollToElement(driver, OCR_AddEditInd_SaveAndReturnBtn);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddEditInd_SaveAndReturnBtn,"Clicking on SaveAndReturn");
	}

	// click on back button
	public void click_BackBtn() {
		scrollToElement(driver, OCR_AddEditInd_BackBtn);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddEditInd_BackBtn,"Clicking on Back button");		
	}

	// click on back button
	public void click_AddOrganizationBtn() {
		Wait.waitfor(5);
		clickElement(driver, test, "//h3[@class='page-heading']", "");
		clickElement(driver, test, OCR_AddEditInd_AddOrganization,"Clicking on Add Organization button");
	}

	/* ******************  Validations in Add/Edit individual ***************************** */

	//  Validate Add visitor save buttton
	public void validate_AddVisitorSaveBtn() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'First Name is required.')]")) {
					test.log(LogStatus.PASS, "First Name is required.");
				}
				if(isDisplayed(driver, "//li[contains(text(),'Last Name is required.')]")) {
					test.log(LogStatus.PASS, "Last Name is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Add Visitor save buttton");
		}
	}

	//  Validate Add visitor save  and return buttton
	public void validate_AddVisitorSaveAndReturnBtn() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver,"//li[contains(text(),'First Name is required.')]")) {
					test.log(LogStatus.PASS, "First Name is required.");
				}
				if(isDisplayed(driver,"//li[contains(text(),'Last Name is required.')]")) {
					test.log(LogStatus.PASS, "Last Name is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Type of Person is required.')]")) {
					test.log(LogStatus.PASS, "Type of Person is required.");
				}			

			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Add Visitor save  and return buttton");
		}
	}

	//  Validate Add Identity Documents
	public void validate_AddIdentity() throws InterruptedException {

		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver,"//li[contains(text(),'Document No. is required.')]")) {
					test.log(LogStatus.PASS, "Document No. is required.");
				}
				if(isDisplayed(driver,"//li[contains(text(),'Document Issuing State is required.')]")) {
					test.log(LogStatus.PASS, "Document Issuing State is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Document Issuing Country is required.')]")) {
					test.log(LogStatus.PASS, "Document Issuing Country is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),"
						+ "'Document validity will be expired before the last day of Visit.')]")) {
					test.log(LogStatus.PASS, "Document validity will be expired before the last day of Visit.");
				}			

			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Add Identifying Document");
		}
	}

}
