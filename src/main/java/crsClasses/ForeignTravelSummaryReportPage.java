package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ForeignTravelSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
		public static final String CRS_Report_Search ="//button[contains(text(),'Search')]";
		public static final String CRS_Report_Reset ="//button[contains(text(),'Reset')]";
		public static final String CRS_Report_SBUCode ="//select[@name='foreignTravelGeneralInfoValue.sbuCode']";
		public static final String CRS_Report_foreignTravelId ="//input[@name='foreignTravelGeneralInfoValue.foreignTravelId']";
		public static final String CRS_Report_status ="//select[@name='status']";
		public static final String CRS_Report_determination ="//select[@name='determination']";
		public static final String CRS_Report_RequesterName = "//input[@name='foreignTravelGeneralInfoValue.requesterName']";
		public static final String CRS_Reports_ExportReviewer = "//a[contains(text(),'Export Reviewer')]";
		public static final String CRS_Report_UserFirstName = "//input[@name='userProfile.userFirstname']";
		public static final String CRS_Report_SearchPopup = "//button[@name='Search']";
		public static final String CRS_Report_SelectPopup = "(//button[@name='Ok'])[1]";
		public static final String CRS_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
		public static final String CRS_Reports_SecurityReviewer = "//a[contains(text(),'Security Reviewer')]";
		public static final String CRS_Report_ManagerReviewer ="//a[contains(text(),'Manager Reviewer')]";
		public static final String CRS_Reports_DirectorReviewer = "//a[contains(text(),'Director Reviewer')]";
		public static final String CRS_Report_initiatedDateFrom = "//input[@name='initiatedDateFrom']";
		public static final String CRS_Reports_initiatedDateTo = "//input[@name='initiatedDateTo']";
		public static final String CRS_Reports_FinalActionDateFrom = "//input[@name='finalDecisionDateFrom']";
		public static final String CRS_Reports_FinalActionDateTo = "//input[@name='finalDecisionDateTo']";
		public static final String CRS_Reports_travelDateFrom = "//input[@name='travelDateFrom']";
		public static final String CRS_Reports_travelDateTo = "//input[@name='travelDateTo']";
		public static final String CRS_Reports_Segment = "//a[contains(text(),' Segment')]";
		public static final String CRS_Reports_SegmentTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.segment']";
		public static final String CRS_Reports_Site = "(//a[contains(text(),'Site')])[2]";
		public static final String CRS_Reports_SiteTextbox = "//textarea[@name='foreignTravelGeneralInfoValue.site']";
		public static final String CRS_Reports_ProductLine = "(//a[contains(text(),'Product Line')])[2]";
		public static final String CRS_Reports_ProductLineTextbox = "//textarea[@name='foreignTravelGeneralInfoValue.productLine']";
		public static final String CRS_Reports_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
		public static final String CRS_Reports_ProductFamilyTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.productFamily']";
		public static final String CRS_Reports_Program = "(//a[contains(text(),'Program')])[2]";
		public static final String CRS_Reports_ProgramCode = "//input[@name='programTab.programCode']";
		public static final String CRS_Reports_ProgramTextbox = "//textarea[@name='foreignTravelGeneralInfoValue.program']";
		public static final String CRS_Reports_Country = "//input[@name='country']";
		public static final String CRS_Reports_CitiesVisiting = "//input[@name='cities']";
		public static final String CRS_Reports_DepartureCity = "//input[@name='port']";
		public static final String CRS_Reports_Company = "//input[@name='company']";
		public static final String CRS_Reports_ExportAuthority = "//select[@name='exportAuthority']";		
		public static final String CRS_Reports_sortBy = "//select[@name='sortBy']";
		public static final String CRS_Reports_direction = "//select[@name='direction']";
		
	
	//..................................Constructors..................................//
	public ForeignTravelSummaryReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, CRS_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, CRS_Report_Reset, "Clicking on Reset Button :");
	}
	
	//....................................Search By Parameters...................................//
	public void searchByParameters(String SBUCode, String ForeignTravelID, String Status, String Determination, 
			String RequesterName, String ExportReviewer, String SecurityReviewer, String ManagerReviewer, 
			String DirectorReviewer, String InitialDateFrom, String InitialDateTo, String FinalActionDateFrom, 
			String FinalActionDateTo, String TravelDateFrom, String TravelDateTo, String Segment, String Site, 
			String ProductLine, String ProductFamily, String Program, String Country, String CitiesVisiting, 
			String DepartureCity, String Company, String ExportAuthority, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, CRS_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, CRS_Report_foreignTravelId, "Entering Foreign Travel ID :", ForeignTravelID);
		selectByVisibleText(driver, test, CRS_Report_status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, CRS_Report_determination, "Selecting Determination :", Determination);
		typeText(driver, test, CRS_Report_RequesterName, "Entering Requester Name :", RequesterName);
		if(ExportReviewer.length() > 0) {
		clickElement(driver, test, CRS_Reports_ExportReviewer, "Clicking on Export Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Export Reviewer Name :", ExportReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportReviewer+"')]", "Selecting Export Reviewer :"+ExportReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(SecurityReviewer.length() > 0) {
			clickElement(driver, test, CRS_Reports_SecurityReviewer, "Clicking on Security Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Security Reviewer Name :", SecurityReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+SecurityReviewer+"')]", "Selecting Security Reviewer :"+SecurityReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(ManagerReviewer.length() > 0) {
			clickElement(driver, test, CRS_Report_ManagerReviewer, "Clicking on Manager Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Manager Reviewer Name :", ManagerReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ManagerReviewer+"')]", "Selecting Manager Reviewer :"+ManagerReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(DirectorReviewer.length() > 0) {
			clickElement(driver, test, CRS_Reports_DirectorReviewer, "Clicking on Director Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Director Reviewer Name :", DirectorReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+DirectorReviewer+"')]", "Selecting Director Reviewer :"+DirectorReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(InitialDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Report_initiatedDateFrom, "Clicking on Initial Date From :");
			dateOfMonthName(driver, test, "Selecting Initial Date From :", InitialDateFrom);
		}
		if(InitialDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_initiatedDateTo, "Clicking on Initial date To :");
			dateOfMonthName(driver, test, "Selecting Initial Date To :", InitialDateTo);
		}
		if(FinalActionDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_FinalActionDateFrom, "Clicking on Final Action Date From :");
			dateOfMonthName(driver, test, "Selecting Final Action Date From :", FinalActionDateFrom);
		}
		if(FinalActionDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_FinalActionDateTo, "Clicking on Final Action Date To :");
			dateOfMonthName(driver, test, "Selecting Final Action Date To :", FinalActionDateTo);
		}
		if(TravelDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_travelDateFrom, "Clicking on Travel Date From :");
			dateOfMonthName(driver, test, "Selecting Travel Date From :", TravelDateFrom);
		}
		if(TravelDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_travelDateTo, "Clicking on Travel Date To :");
			dateOfMonthName(driver, test, "Selecting Travel Date To :", TravelDateTo);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, CRS_Reports_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :"+Segment);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_SegmentTextBox, "Entering Segment :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, CRS_Reports_Site, "Clicking on Site :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :"+Site);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_SiteTextbox, "Entering Site :", Site);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, CRS_Reports_ProductLine, "Clicking on ProductLine :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting ProductLine :"+ProductLine);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ProductLineTextbox, "Entering ProductLine :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, CRS_Reports_ProductFamily, "Clicking on Product Family :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :"+ProductFamily);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ProductFamilyTextBox, "Entering Product Family :", ProductFamily);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, CRS_Reports_Program, "Clicking on Program :");
			try {
				typeText(driver, test, CRS_Reports_ProgramCode, "Entering Program Name :", Program);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :"+Program);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ProgramTextbox, "Entering Program :", Program);
		}
		typeText(driver, test, CRS_Reports_Country, "Entering Country :", Country);
		typeText(driver, test, CRS_Reports_CitiesVisiting, "Entering Cities Visiting :", CitiesVisiting);
		typeText(driver, test, CRS_Reports_DepartureCity, "Entering Departure City :", DepartureCity);
		typeText(driver, test, CRS_Reports_Company, "Entering Company :", Company);
		selectByVisibleText(driver, test, CRS_Reports_ExportAuthority, "Selecting Export Authority :", ExportAuthority);
		selectByVisibleText(driver, test, CRS_Reports_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CRS_Reports_direction, "Selecting Direction :", Direction);
	}
}
