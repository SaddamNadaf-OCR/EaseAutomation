package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ExportRequestSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String CRS_Report_Search ="//button[contains(text(),'Search')]";
	public static final String CRS_Report_Reset ="//button[contains(text(),'Reset')]";
	public static final String CRS_Report_SBUCode ="//select[@name='exportRequestValue.sbuCode']";
	public static final String CRS_Report_Purpose ="//select[@name='exportRequestValue.licPurpose']";
	public static final String CRS_Report_RequestID ="//input[@name='exportRequestValue.expReqId']";
	public static final String CRS_Report_AuthorizationID ="//input[@name='exportRequestValue.expAuthId']";
	public static final String CRS_Reports_Status = "//select[@name='status']";
	public static final String CRS_Reports_Determination = "//select[@name='disposition']";
	public static final String CRS_Report_RequesterName = "//input[@name='exportRequestValue.nameOfRequestor']";
	public static final String CRS_Report_ExportFocalPoint ="//a[contains(text(),'Export Focal Point')]";
	public static final String CRS_Report_UserFirstName = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Report_SearchPopup = "//button[@name='Search']";
	public static final String CRS_Report_SelectPopup = "(//button[@name='Ok'])[1]";
	public static final String CRS_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String CRS_Reports_Department = "//input[@name='exportRequestValue.department']";
	public static final String CRS_Reports_RequestType = "//select[@name='exportRequestValue.expReqForms']";
	public static final String CRS_Reports_RequestDateFrom = "//input[@name='requestDateFrom']";
	public static final String CRS_Reports_RequestDateTo = "//input[@name='requestDateTo']";
	public static final String CRS_Report_finalActionDateFrom = "//input[@name='finalActionDateFrom']";
	public static final String CRS_Reports_finalActionDateTo = "//input[@name='finalActionDateTo']";
	public static final String CRS_Reports_Segment = "//a[contains(text(),' Segment')]";
	public static final String CRS_Reports_SegmentTextbox = "//textarea[@name='exportRequestValue.segment']";
	public static final String CRS_Reports_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String CRS_Reports_SiteTextbox = "//textarea[@name='exportRequestValue.site']";
	public static final String CRS_Reports_ProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String CRS_Reports_prodLineTextBox = "//textarea[@name='exportRequestValue.prodLine']";
	public static final String CRS_Reports_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String CRS_Reports_prodFamilyTextBox = "//textarea[@name='exportRequestValue.prodFamily']";
	public static final String CRS_Reports_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String CRS_Reports_programCode = "//input[@name='programTab.programCode']";
	public static final String CRS_Reports_ProgramTextBox = "//textarea[@name='exportRequestValue.program']";
	public static final String CRS_Reports_Country = "//input[@name='countryCode']";
	public static final String CRS_Reports_Consignee = "(//a[contains(text(),'Consignee')])[3]";
	public static final String CRS_Reports_consigneeName = "//input[@name='exportConsigneeDTO.consigneeName']";
	public static final String CRS_Reports_consigneeNameTextBox = "//input[@name='exportConsigneeValue.consigneeName']";
	public static final String CRS_Reports_exportAuthority = "//select[@name='exportAuthority']";
	public static final String CRS_Reports_ReasonforReturn = "(//a[contains(text(),'Reason for Return')])[2]";
	public static final String CRS_Reports_ReasonforReturnPopup = "//input[@name='turnbackCategoryValue.turnbackCode']";
	public static final String CRS_Reports_ReasonforReturnTextBox = "//input[@name='exportRequestValue.tdfpTurnbackDesc']";
	public static final String CRS_Reports_TechnicalFocalPoint = "(//a[contains(text(),'Technical Focal Point')])";
	public static final String CRS_Report_UserFirstNameTFP = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Reports_sortBy = "//select[@name='sortBy']";
	public static final String CRS_Reports_direction = "//select[@name='direction']";
	public static final String CRS_Reports_submitDateFrom = "//input[@name='submitDate']";
	public static final String CRS_Reports_submitDateTo = "//input[@name='submitDateTo']";
	public static final String CRS_Reports_Productdescription = "//input[@name='description']";
	
	
	//..................................Constructors..................................//
	public ExportRequestSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	
	//.....................................Search By Parameters.....................................//
	public void searchByParameters(String SBUCode, String Purpose, String RequestID, String AuthorizationID, 
			String Status, String Determination, String RequesterName, String ExportFocalPoint, String Department, 
			String RequestType, String RequestDateFrom, String RequestDateTo, String FinalActionDateFrom, 
			String FinalActionDateTo, String Segment, String Site, String ProductLine, String ProductFamily, 
			String Program, String Country, String Consignee, String ExportAuthority, String ReasonForReturn, 
			String TachnicalFocalPoint, String SortBy, String Direction, String SubmitDateFrom, String SubmitDateTo, String ProductDecription) {
		
		selectByVisibleText(driver, test, CRS_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, CRS_Report_Purpose, "Selecting Purpose :", Purpose);
		typeText(driver, test, CRS_Report_RequestID, "Entering Request ID :", RequestID);
		typeText(driver, test, CRS_Report_AuthorizationID, "Entering Authorization ID :", AuthorizationID);
		selectByVisibleText(driver, test, CRS_Reports_Status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, CRS_Reports_Determination, "Selecting Determination :", Determination);
		typeText(driver, test, CRS_Report_RequesterName, "Entering Requester Name :", RequesterName);
		if(ExportFocalPoint.length() > 0) {
			clickElement(driver, test, CRS_Report_ExportFocalPoint, "Clicking on Consignee_Customer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Consignee_Customer Name :", ExportFocalPoint);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportFocalPoint+"')]", "Selecting Consignee_Customer :"+ExportFocalPoint);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		typeText(driver, test, CRS_Reports_Department, "Entering Department :", Department);
		selectByVisibleText(driver, test, CRS_Reports_RequestType, "Selecting Request Type :", RequestType);
		if(RequestDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_RequestDateFrom, "Clicking on Request Date From :");
			dateOfMonthName(driver, test, "Selecting Request Date From :", RequestDateFrom);
		}
		if(RequestDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_RequestDateTo, "Clicking on Request Date To :");
			dateOfMonthName(driver, test, "Selecting Request Date To :", RequestDateTo);
		}
		if(FinalActionDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Report_finalActionDateFrom, "Clicking on Final Action Date From :");
			dateOfMonthName(driver, test, "Selecting Final Action Date From :", FinalActionDateFrom);
		}
		if(FinalActionDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_finalActionDateTo, "Clicking on Final Action Date To :");
			dateOfMonthName(driver, test, "Selecting Final Action Date To :", FinalActionDateTo);
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
			typeText(driver, test, CRS_Reports_SegmentTextbox, "Entering Segment In TextBox :", Segment);
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
			typeText(driver, test, CRS_Reports_SiteTextbox, "Entering Site In TextBox :", Site);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, CRS_Reports_ProductLine, "Clicking on Product Line :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line :"+ProductLine);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_prodLineTextBox, "Entering Product Line In TextBox :", Site);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, CRS_Reports_ProductLine, "Clicking on Product Family :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :"+ProductLine);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_prodLineTextBox, "Entering Product Family In TextBox :", ProductFamily);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, CRS_Reports_Program, "Clicking on Program :");
			try {
				typeText(driver, test, CRS_Reports_programCode, "Entering Program Name :", Program);
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
			typeText(driver, test, CRS_Reports_ProgramTextBox, "Entering Program :", Program);
		}
		typeText(driver, test, CRS_Reports_Country, "Entering Country :", Country);
		if(Consignee.length() > 0) {
			clickElement(driver, test, CRS_Reports_Consignee, "Clicking on Consignee :");
			try {
				typeText(driver, test, CRS_Reports_consigneeName, "Entering Consignee Name :", Consignee);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Consignee+"')]", "Selecting Consignee :"+Consignee);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_consigneeNameTextBox, "Entering Consignee :", Consignee);
		}
		selectByVisibleText(driver, test, CRS_Reports_exportAuthority, "Selecting Export Authority :", ExportAuthority);
		if(ReasonForReturn.length() > 0) {
			clickElement(driver, test, CRS_Reports_ReasonforReturn, "Clicking on Reason For Return :");
			try {
				typeText(driver, test, CRS_Reports_ReasonforReturnPopup, "Entering Reason For Return Name :", ReasonForReturn);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ReasonForReturn+"')]", "Selecting Reason For Return :"+ReasonForReturn);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ReasonforReturnTextBox, "Entering Reason For Return :", ReasonForReturn);
		}
		if(TachnicalFocalPoint.length() > 0) {
			clickElement(driver, test, CRS_Reports_TechnicalFocalPoint, "Clicking on Tachnical Focal Point :");
			try {
				typeText(driver, test, CRS_Report_UserFirstNameTFP, "Entering Tachnical Focal Point Name :", TachnicalFocalPoint);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TachnicalFocalPoint+"')]", "Selecting Tachnical Focal Point :"+TachnicalFocalPoint);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		selectByVisibleText(driver, test, CRS_Reports_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CRS_Reports_direction, "Selecting Direction :", Direction);
		if(SubmitDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_submitDateFrom, "Clicking on Submit Date From :");
			dateOfMonthName(driver, test, "Selecting Submit Date From :", SubmitDateFrom);
		}
		if(SubmitDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_submitDateTo, "Clicking on Submit Date To :");
			dateOfMonthName(driver, test, "Selecting Submit Date To :", SubmitDateTo);
		}
		typeText(driver, test, CRS_Reports_Productdescription, "Entering Product Description :", ProductDecription);
	}

}
