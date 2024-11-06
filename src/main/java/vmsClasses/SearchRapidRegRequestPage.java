package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchRapidRegRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_RapidRegReq_AddNewVstrReqt = "//button[contains(text(),'Add New Rapid Request')]";
	public static final String OCR_RapidRegReq_BusinessUint = "//select[@id='resultVisitorRapidRegistration_visitorGeneralInfoValue_sbuCode']";
	public static final String OCR_RapidRegReq_VisitFromDate = "//input[@id='resultVisitorRapidRegistration_visitDateFrom']";
	public static final String OCR_RapidRegReq_VisitToDate = "//input[@id='resultVisitorRapidRegistration_visitDateTo']";
	public static final String OCR_RapidRegReq_Status = "//select[@id='resultVisitorRapidRegistration_visitorGeneralInfoValue_requestStatus']";
	public static final String OCR_RapidRegReq_startTime = "//select[@id='resultVisitorRapidRegistration_visitorGeneralInfoValue_scheduledTimeFrom']";
	public static final String OCR_RapidRegReq_EndTime = "//select[@id='resultVisitorRapidRegistration_visitorGeneralInfoValue_scheduledTimeTo']";
	public static final String OCR_RapidRegReq_VisitPurpose = "//select[@id='resultVisitorRapidRegistration_visitorGeneralInfoValue_visitPurpose']";
	public static final String OCR_RapidRegReq_Site = "//div[@class='ms-trigger']";
	public static final String OCR_RapidRegReq_BuildingName = "//input[@name='visitorLocationValue.buildingName']";
	public static final String OCR_RapidRegReq_EntranceLobby = "//input[@id='resultVisitorRapidRegistration_visitorLocationValue_lobbyOrEntrance']";
	public static final String OCR_RapidRegReq_RoomNo = "//input[@id='resultVisitorRapidRegistration_visitorLocationValue_description']";
	public static final String OCR_RapidRegReq_SButton = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchRapid_HostVisitorDetails = "//label[contains(text(),'Host and Visitor Details')]";
	public static final String OCR_SearchRapid_KioskVisitorCode = "//input[@id='resultVisitorRapidRegistration_visitorPersonValue_visitorCode']";
	public static final String OCR_SearchRapid_Search = "//button[@type='submit']";
	public static final String OCR_SearchRapid_GrantAccess = "//input[@id='grantBuilding1']";
	public static final String OCR_SearchRapid_SelectVisitorCheckbox= "//input[@id='jqg_gridPerson_4']";

	/* ******************** Constructor ***************************** */

	public SearchRapidRegRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Clicking on Add Visitor request
	public void click_AddNewVisitorRequest(){	
		clickElement(driver, test, OCR_RapidRegReq_AddNewVstrReqt, "Clicking on Add New Visitor Request ");
	}
	
	// Clicking on Add Visitor request
		public void click_SelectCheckboxvisitor(){
			Wait.waitfor(2);
			scrollToElement(driver, OCR_SearchRapid_SelectVisitorCheckbox);
			clickElement(driver, test, OCR_SearchRapid_SelectVisitorCheckbox, "Clicking on Checkbox of  visitors from visitor grid ");
		}
		
	// Clicking check box for Grant Access
	public void click_GrantAccess(){	
		Wait.waitfor(2);
		scrollToElement(driver, OCR_SearchRapid_GrantAccess);
		clickElement(driver, test, OCR_SearchRapid_GrantAccess, "Clicking check box for Grant Access ");
	}

	//Search Rapid Registration Req visitor Details as per the Date Send From Excel and click on search button.
	public void searchRapidRegReq(String SBU,String SBUCount,String VisitFromDate,String VisitToDate, String Status,
			String StartTime,String EndTime,String VisitPurpose,String Site,String BuildingName,String EntranceLobby,
			String RoomNo) {
		//sortDropDown(driver, test, OCR_RapidRegReq_BusinessUint, "-ALL-");
		if(SBUCount.length()>0) {
			int count = dropDownCount(driver, OCR_RapidRegReq_BusinessUint);
			if(count == Integer.parseInt(SBUCount)) {
				test.log(LogStatus.PASS, "No of options are equal to SBUCount :  " +SBUCount);			
			}else {
				test.log(LogStatus.FAIL, "No of options are not equal to SBUCount :  " +SBUCount);
			}	
		}	
		selectByVisibleText(driver, test, OCR_RapidRegReq_BusinessUint, "Selected SBU CODE : ", SBU);
		selectByVisibleText(driver, test, OCR_RapidRegReq_Status, "Select Status :  ", Status);
		if(VisitFromDate.length()>0) {
			clickElement(driver, test, OCR_RapidRegReq_VisitFromDate, "Click on VFrom Date");
			date(driver, test, "Selecting the VTo date : " , VisitFromDate);
		}if(VisitToDate.length()>0) {
			clickElement(driver, test, OCR_RapidRegReq_VisitToDate, "Click on VTo Date");
			date(driver, test, "Selecting the Visit To date : " , VisitToDate);
		}
		selectByVisibleText(driver, test, OCR_RapidRegReq_startTime, "Select Start time : ", StartTime);
		selectByVisibleText(driver, test, OCR_RapidRegReq_EndTime, "Select End time : ", EndTime);
		selectByVisibleText(driver, test, OCR_RapidRegReq_VisitPurpose, "Select Visit Purpose : ", VisitPurpose);
		if(Site.length()>0) {
			clickElement(driver, test, OCR_RapidRegReq_Site, "click on Site down arrow");
			String site = "//div[contains(text(),'"+ Site +"')]";
			clickElement(driver, test, site, "click on Required Site : " + Site);
		}
		typeText(driver, test, OCR_RapidRegReq_BuildingName, "Enter vistor Building Name : ", BuildingName);
		typeText(driver, test, OCR_RapidRegReq_EntranceLobby, "Enter vistor Entrance / Lobby : ", EntranceLobby);
		typeText(driver, test, OCR_RapidRegReq_RoomNo, "Enter vistor Room No / Description : ", RoomNo);
		clickElement(driver, test, OCR_RapidRegReq_SButton, "clicking on search button in Search Rapid VR");
	}
	
	//select to visit Date From
		public void select_VisitDateFrom(String visitDateFrom) {
			clickElement(driver, test, OCR_RapidRegReq_VisitFromDate, "Clicking on From date");		
			date(driver, test, "Selecing the visit date : " , visitDateFrom);
		}

		//select to visit Date To
		public void select_VisitDateTo(String visitDateTo) {
			clickElement(driver, test, OCR_RapidRegReq_VisitToDate, "Clicking on To date");		
			date(driver, test, "Selecing the visit date  To: " , visitDateTo);
		}
		
		// Clicking on Search Button 
		public void click_SearchButn() {
			scrollToElement(driver, "//div[@class='form-content top-empty-row']");
			clickElement(driver, test, OCR_SearchRapid_Search, "Clicking on Search Button");
		}
		
		// Validating Visit Date To must occur after the Visit Date From message in Rapid request search screen
		
		public void validating_RapidVisitDate() throws Exception {
			try {
				if (isDisplayed(driver,"//div[@class= 'row ocr-error']//h4[contains(text(),'Error')]")) {
					test.log(LogStatus.PASS, "Visit Date To must occur after the Visit Date From for the selected Visit Date");
				}

			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Error message is not displayed for the selected Visit Date");
				testFailSshot(driver, test);		
			}
		}

	// Clicking on Host and Visitor Details
	public void click_SearchRapidHostVisitorDetails(){
		Wait.waitfor(2);		
		clickElement(driver, test, OCR_SearchRapid_HostVisitorDetails,"Expanding 'Host and Visitor Details' in Search Rapid Registration Request ");
	}

	//Enter Kiosk Visitor code in Search rapid page
	public void type_KReqVisitorCode(String VisitorCode){
		Wait.waitfor(3);
		typeText(driver, test, OCR_SearchRapid_KioskVisitorCode, "Enter Visitor code in Search Rapid Registration Request page : ", VisitorCode);
	}	

	//Clicking on Search in Search Rapid page
	public void click_SearchRapidSearch(){		
		clickElement(driver, test, OCR_SearchRapid_Search,"Clicking on Search in Search Rapid page");
	}

}
