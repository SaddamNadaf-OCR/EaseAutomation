package crsClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.openqa.selenium.remote.server.handler.GetAlertText;

import com.gargoylesoftware.htmlunit.AlertHandler;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchExportRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchExportReq_SBUCode = "//select[@id='resultExportRequest_exportRequestValue_sbuCode']";
	public static final String OCR_SearchExportReq_Features = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_SearchExportReq_Requests = "//a[contains(text(),'Requests')]/i";
	public static final String OCR_SearchExportReq_AgreementReq = "(//a[contains(text(),'Agreement Request')])[1]";
	public static final String OCR_SearchExportReq_ExportReq = "(//a[contains(text(),'Export Authorization Request')])[1]";
	public static final String OCR_SearchExportReq_ForeignTravelReq = "(//a[contains(text(),'Foreign Travel')])[1]";
	public static final String OCR_SearchExportReq_AddRequest = "//button[@id='mybutton']";
	public static final String OCR_SearchExportReq_ImportReq = "(//a[contains(text(),'Import Request')])[1]";
	public static final String OCR_SearchExportReq_AuthorizationId = "//input[@id='resultExportRequest_exportRequestValue_expAuthId']";
	public static final String OCR_SearchExportReq_RequestId = "//input[@id='resultExportRequest_exportRequestValue_expReqId']";
	public static final String OCR_SearchExportReq_LicenseAppNo = "//input[@id='resultExportRequest_exportRequestValue_licenseTransactionId']";
	public static final String OCR_SearchExportReq_CaseNo = "//input[@id='resultExportRequest_exportRequestValue_caseNo']";
	public static final String OCR_SearchExportReq_PurposeDropdwn = "//select[@id='resultExportRequest_exportRequestValue_licPurpose']";
	public static final String OCR_SearchExportReq_StatusDropdwn = "//select[@name='exportRequestValue.status']";
	public static final String OCR_SearchExportReq_DeterminationDropdwn = "//select[@name='exportRequestValue.disposition']";
	public static final String OCR_SearchExportReq_RequestorNamePopUp = "//a[contains(text(),'Requestor Name')]";
	public static final String OCR_SearchExportReq_RequestorUserPopUpFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_SearchExportReq_RequestorUserPopSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_RequestorUserPopSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_ExportFocalPointLink = "//a[contains(text(),'Export Focal Point')]";
	public static final String OCR_SearchExportReq_ExportFocalPointEmailId = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR_SearchExportReq_ExportFocalPointSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_ExportFocalPointSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_SearchExportReq_RequestDateFrom = "//input[@id='resultExportRequest_exportDateFrom']";
	public static final String OCR_SearchExportReq_RequestDateTo = "//input[@id='resultExportRequest_exportDateTo']";
	public static final String OCR_SearchExportReq_ReviewDateFrom = "//input[@id='resultExportRequest_reviewDateFrom']";
	public static final String OCR_SearchExportReq_ReviewDateTo = "//input[@id='resultExportRequest_reviewDateTo']";
	public static final String OCR_SearchExportReq_ActivityTypeDropdwn = "//select[@id='activityId']";
	public static final String OCR_SearchExportReq_AuthorizationTypeLink = "//a[@id='authorizationTypePopup']";
	public static final String OCR_SearchExportReq_AuthTypeTextBox = "//input[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_SearchExportReq_AuthSearchBtn = "//div[@id='searchDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_AuthSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_AuthCloseIcon = "//button[@class='close']";
	public static final String OCR_SearchExportReq_AuthNoPopUpLink = "//a[@id='authorizationNoPopup']";
	public static final String OCR_SearchExportReq_AuthNoTextBx = "//input[@id='searchForm_dosGeneralInfoDTO_licenseNo']";
	public static final String OCR_SearchExportReq_AuthNoSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_AuthNoSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_AuthNoCloseBtn = "//button[@class='btn-close']";
	public static final String OCR_SearchExportReq_SegmentPopUpLink = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_SearchExportReq_SegmentSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_SitePopUpLink = "(//a[contains(text(),'Site')])[2]";
	public static final String OCR_SearchExportReq_SiteSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_ProductLinePopUp = "(//a[contains(text(),'Product Line')])[2]";
	public static final String OCR_SearchExportReq_ProductLineSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_ProductFamilyPopUp = "(//a[contains(text(),'Product Family')])[2]";
	public static final String OCR_SearchExportReq_ProductFamilySelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_ProgramPopUpLink = "(//a[contains(text(),'Program')])[2]";
	public static final String OCR_SearchExportReq_ProgramCodeTextBox = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_SearchExportReq_ProgramSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_ProgramSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_Country = "//input[@id='resultExportRequest_countryCode']";
	public static final String OCR_SearchExportReq_customerConsigneePopUp = "//a[contains(text(),'Customer/Consignee')]";
	public static final String OCR_SearchExportReq_ConsigneeNameTextBox = "//input[@id='searchForm_exportConsigneeDTO_consigneeName']";
	public static final String OCR_SearchExportReq_ConsigneeSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_ConsigneeSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_OSRNumberPopUplink = "//a[contains(text(),'OSR Number')]";
	public static final String OCR_SearchExportReq_OSRNumber = "//input[@id='searchForm_dosGeneralInfoDTO_OfosirNo']";
	public static final String OCR_SearchExportReq_OSRSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_OSRSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_ReasonOfReturnPopUp = "//a[contains(text(),' Reason for Return')]";
	public static final String OCR_SearchExportReq_ReasonForReturnTextBox = "//input[@id='searchForm_turnbackCategoryValue_turnbackCode']";
	public static final String OCR_SearchExportReq_ReasonForReturnSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_ReasonForReturnSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_TechnicalFocalPointPopUplink = "//a[contains(text(),'Technical Focal Point')]";
	public static final String OCR_SearchExportReq_TechnicalFocalPointEmailId = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR_SearchExportReq_TechnicalFocalPointSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchExportReq_TechnicalFocalPointSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchExportReq_PriorityDropDwn = "//select[@name='exportRequestValue.priority']";
	public static final String OCR_SearchExportReq_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SearchExportReq_SubmittedDateFrom = "//input[@id='resultExportRequest_submitDate']";
	public static final String OCR_SearchExportReq_SubmittedDateTo = "//input[@id='resultExportRequest_submitDateTo']";
	public static final String OCR_SearchExportReq_SalesOrderNo = "//input[@id='resultExportRequest_exportRequestValue_salesOrderNo']";
	public static final String OCR_SearchExportReq_SalesOrderLineItemTextBox = "//input[@id='resultExportRequest_exportItemValue_salesOrderLineItem']";
	public static final String OCR_SearchExportReq_SalesOrderNoItem = "//input[@id='resultExportRequest_exportItemValue_salesOrderNo']";
	public static final String OCR_SearchExportReq_CopyAlertMsg = "//span[contains(text(),'Proceed to Copy without Invalid data')]";

	/* ******************** Constructor ***************************** */
	public SearchExportRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to features and click Compliance Request
	public void moveTo_Features() {
		mouseOverAndClick(driver, test, OCR_SearchExportReq_Features, "Mouse over on Features");
	}
	
	public void moveTo_Tools() {
		mouseOver(driver, test, "//header/div[1]/div[1]/nav[1]/div[2]/ul[2]/li[4]/a[1]/i[1]", "Mouse over on Tools");
		//Wait.waitfor(5);
		mouseOverAndClick(driver, test, "//header/div[1]/div[1]/nav[1]/div[2]/ul[2]/li[4]/ul[1]/li[20]/a[1]","Click on System");
	}
	
	public void click_configureapp() {
		Wait.waitfor(3);
		clickElement(driver, test,"//a[contains(text(),'Configure Application')]","Click on Configure Application");
	}

	// click on Requests
	public void click_Requests() throws InterruptedException {
		//Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_SearchExportReq_Requests, "Clicking on Requests");
	}

	// click on Agreement Request
	public void click_AgreementReq() {	
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_SearchExportReq_AgreementReq, "Clicking on Agreement Request under Requests");
		//Wait.waitfor(3);
        //clickElement(driver, test,"//label[contains(text(),'Authorization ID')]", "Click Outside to remove Module list");
	}

	// click on Export Authorization Request
	public void click_ExportAuthReqlink() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchExportReq_ExportReq, "Click on Export Authorization Request");
		//clickElement(driver, test,"//label[contains(text(),'Authorization ID')]", "Click Outside to remove Module list");
	}

	// click on Foreign Travel Request
	public void click_FTRReqlink() {
		 Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchExportReq_ForeignTravelReq, "Click on Foreign Travel Request");
		//clickElement(driver, test,"//label[contains(text(),'Foreign Travel Id')]", "Click Outside to remove Module list");
	}
	// click on Add Request

	public void click_AddRequestBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchExportReq_AddRequest, "Click on Add Request");
	}

	// click on Import Request
	public void click_ImportReq() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchExportReq_ImportReq, "Clicking on Import Request under Requests");
	}

	// Search Export request results(Smoke Level Test Cases)
	public void SearchExportReqDetails(String SBUCode, String AuthorizationID, String RequestID, String LicenseAppNo,
			String Status) {

		selectByVisibleText(driver, test, OCR_SearchExportReq_SBUCode, "Select SBU code : ", SBUCode);
		typeText(driver, test, OCR_SearchExportReq_AuthorizationId, "Enter Authorization ID : ", AuthorizationID);
		typeText(driver, test, OCR_SearchExportReq_RequestId, "Enter Request ID : ", RequestID);
		typeText(driver, test, OCR_SearchExportReq_LicenseAppNo, "Enter License App No", LicenseAppNo);
		selectByVisibleText(driver, test, OCR_SearchExportReq_StatusDropdwn, "Select the Status : ", Status);
		
	}
	
	// Search Export request results(For Regression Level Test Cases)
		public void SearchExportReqDetails(String SBUCode, String AuthorizationID, String RequestID, String LicenseAppNo,
				String CaseNo, String Purpose, String Status, String Determination, String RequestorName,
				String ExportFocalPoint, String RequestDateFrom, String RequestDateTo, String ReviewDateFrom,
				String ReviewDateTo, String Activity, String AuthorizationNo, String Segment, String Site,
				String ProductLine, String ProductFamily, String Program, String Customer, String OSRNumber,
				String ReasonforReturn, String TechnicalFocalPoint, String Country, String Priority, String SortBy,
				String SubmitDateFrom, String SubmitDateTo, String SalesOrderNo) {

			selectByVisibleText(driver, test, OCR_SearchExportReq_SBUCode, "Select SBU code : ", SBUCode);
			typeText(driver, test, OCR_SearchExportReq_AuthorizationId, "Enter Authorization ID : ", AuthorizationID);
			typeText(driver, test, OCR_SearchExportReq_RequestId, "Enter Request ID : ", RequestID);
			typeText(driver, test, OCR_SearchExportReq_LicenseAppNo, "Enter License App No", LicenseAppNo);
			typeText(driver, test, OCR_SearchExportReq_CaseNo, "Enter Case No : ", CaseNo);
			selectByVisibleText(driver, test, OCR_SearchExportReq_PurposeDropdwn, "Select the Purpose : ", Purpose);
			selectByVisibleText(driver, test, OCR_SearchExportReq_StatusDropdwn, "Select the Status : ", Status);
			selectByVisibleText(driver, test, OCR_SearchExportReq_DeterminationDropdwn, "Select the Determination : ",
					Determination);
			if (RequestorName.length() > 0) {
				clickElement(driver, test, OCR_SearchExportReq_RequestorNamePopUp, "Click on Requestor Name Link");
				try {
					typeText(driver, test, OCR_SearchExportReq_RequestorUserPopUpFirstName,
							"Enter the RequstorFirstName : ", RequestorName);
					clickElement(driver, test, OCR_SearchExportReq_RequestorUserPopSearchBtn, "Click on Search button");
					clickElement(driver, test, "(//td[contains(text(),'" + RequestorName + "')])[1]",
							"select the RequestorName : " + RequestorName);
					clickElement(driver, test, OCR_SearchExportReq_RequestorUserPopSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in Requstor Name");
			}
		}
		if (ExportFocalPoint.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_ExportFocalPointLink, "Click on Export Focal Point Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_ExportFocalPointEmailId,
						"Enter the ExportFocalPoint Email : ", ExportFocalPoint);
				clickElement(driver, test, OCR_SearchExportReq_ExportFocalPointSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + ExportFocalPoint + "')])[1]",
						"select the Export Focal Point : " + ExportFocalPoint);
				clickElement(driver, test, OCR_SearchExportReq_ExportFocalPointSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in Export Focal Point");
			}
		}
		if(SubmitDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_RequestDateFrom, "Clicking on Request Date From");
			if (SubmitDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Request Date From : ", RequestDateFrom);
				}
		}
		if(SubmitDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_RequestDateTo, "Clicking on Request Date To");
			if (SubmitDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Request Date To : ", RequestDateTo);
				}
		}
		if(ReviewDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_ReviewDateFrom, "Clicking on Review Date From");
			if (ReviewDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Date From : ", ReviewDateFrom);
				}
		}
		if(ReviewDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_ReviewDateTo, "Clicking on Review Date To");
			if (ReviewDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Date To : ", ReviewDateTo);
				}
		}
		
		selectByVisibleText(driver, test, OCR_SearchExportReq_ActivityTypeDropdwn, "Select the Activity : ", Activity);
		if (AuthorizationNo.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_AuthNoPopUpLink, "Click on Authorization No Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_AuthNoTextBx, "Enter the Authorization No : ",
						AuthorizationNo);
				selectByVisibleText(driver, test, "//select[@id='searchForm_dosGeneralInfoDTO_sbuCode']", "Select the sbu : ", "-ALL-");
				clickElement(driver, test, OCR_SearchExportReq_AuthNoSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + AuthorizationNo + "')])[1]",
						"select the Authorization No : " + AuthorizationNo);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in Authorization No");
			}
		}
		if (Segment.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_SegmentPopUpLink, "Click on Segment Link");
			try {
				clickElement(driver, test, "(//td[contains(text(),'" + Segment + "')])[1]",
						"select the Segment : " + Segment);
				clickElement(driver, test, OCR_SearchExportReq_SegmentSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn, "Click on PopUp close icon in Segment");
			}
		}
		if (Site.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_SitePopUpLink, "Click on Site Link");
			try {
				clickElement(driver, test, "(//td[contains(text(),'" + Site + "')])[1]", "select the Site : " + Site);
				clickElement(driver, test, OCR_SearchExportReq_SiteSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn, "Click on PopUp close icon in Site");
			}
		}
		if (ProductLine.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_ProductLinePopUp, "Click on ProductLine Link");
			try {
				clickElement(driver, test, "(//td[contains(text(),'" + ProductLine + "')])[1]",
					"select the ProductLine : " + ProductLine);
				clickElement(driver, test, OCR_SearchExportReq_ProductLineSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in ProductLine");
			}
		}
		if (ProductFamily.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_ProductFamilyPopUp, "Click on Product Family Link");
			try {
				clickElement(driver, test, "(//td[contains(text(),'" + ProductFamily + "')])[1]",
						"select the Product Family : " + ProductFamily);
				clickElement(driver, test, OCR_SearchExportReq_ProductFamilySelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in ProductFamily");
			}
		}
		if (Program.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_ProgramPopUpLink, "Click on Program Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_ProgramCodeTextBox, "Enter the Program code : ", Program);
				clickElement(driver, test, OCR_SearchExportReq_ProgramSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + Program + "')])[1]",
						"select the Export Focal Point : " + Program);
				clickElement(driver, test, OCR_SearchExportReq_ProgramSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn, "Click on PopUp close icon in Program");
			}
		}
		if (Customer.length() > 0) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchExportReq_customerConsigneePopUp, "Click on Customer/Consignee Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_ConsigneeNameTextBox, "Enter the Customer  : ", Customer);
				clickElement(driver, test, OCR_SearchExportReq_ConsigneeSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + Customer + "')])[1]",
						"select the Customer/Consignee : " + Customer);
				clickElement(driver, test, OCR_SearchExportReq_ConsigneeSelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in Customer/Consignee");
			}
		}
		if (OSRNumber.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_OSRNumberPopUplink, "Click on OSR Number Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_OSRNumber, "Enter the OSR Number : ", OSRNumber);
				clickElement(driver, test, OCR_SearchExportReq_OSRSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + OSRNumber + "')])[1]",
						"select the OSR Number : " + OSRNumber);
				clickElement(driver, test, OCR_SearchExportReq_OSRSelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in OSR Number");
			}
		}
		if (ReasonforReturn.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_ReasonOfReturnPopUp, "Click on Reason for Return Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_ReasonForReturnTextBox, "Enter the Reason for Return : ",
						ReasonforReturn);
				clickElement(driver, test, OCR_SearchExportReq_ReasonForReturnSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + ReasonforReturn + "')])[1]",
						"select the Reason for Return : " + ReasonforReturn);
				clickElement(driver, test, OCR_SearchExportReq_ReasonForReturnSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in Reason for Return");
			}
		}
		if (TechnicalFocalPoint.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchExportReq_TechnicalFocalPointPopUplink,
					"Click on Technical Focal Point Link");
			try {
				typeText(driver, test, OCR_SearchExportReq_TechnicalFocalPointEmailId,
						"Enter the Technical Focal Point Email : ", TechnicalFocalPoint);
				clickElement(driver, test, OCR_SearchExportReq_TechnicalFocalPointSearchBtn, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + TechnicalFocalPoint + "')])[1]",
						"select the Technical Focal Point : " + TechnicalFocalPoint);
				clickElement(driver, test, OCR_SearchExportReq_TechnicalFocalPointSelectBtn, "Click on Select  button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchExportReq_AuthNoCloseBtn,
						"Click on PopUp close icon in Technical Focal Point Name");
			}
		}
		typeText(driver, test, OCR_SearchExportReq_Country, "Enter Country : ", Country);
		selectByVisibleText(driver, test, OCR_SearchExportReq_PriorityDropDwn, "Select the Priority : ", Priority);
		selectByVisibleText(driver, test, OCR_SearchExportReq_SortBy, "Select the SortBy option : ", SortBy);
		
		if(SubmitDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_SubmittedDateFrom, "Clicking on Submit Date From");
			if (SubmitDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Submit Date From : ", SubmitDateFrom);
				}
			}
		
		if(SubmitDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchExportReq_SubmittedDateTo, "Clicking on Submit Date To");
			if (SubmitDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Submit Date To : ", SubmitDateFrom);
				}
			}
		
		typeText(driver, test, OCR_SearchExportReq_SalesOrderNo, "Enter the Sales Order No : ", SalesOrderNo);
	}

	// Search Export Request item Details
	public void searchExpReqItemDetails(String SalesOrderitems, String SalesOrderLineItem) {
		typeText(driver, test, OCR_SearchExportReq_SalesOrderNoItem, "Enter the Sales Order No items : ",
				SalesOrderitems);
		typeText(driver, test, OCR_SearchExportReq_SalesOrderLineItemTextBox, "Enter the Sales order Line Item : ",
				SalesOrderLineItem);
	}
	
	// Select sbu and Request ID
	public void typeRequestID(String SBU, String RequestID) {
		selectByVisibleText(driver, test, "//select[@id='resultExportRequest_exportRequestValue_sbuCode']",
				"select the sbu : ", SBU);
		typeText(driver, test, "//input[@id='resultExportRequest_exportRequestValue_expReqId']",
				"Enter the request ID : ", RequestID);
	}
	
	// Select sbu and Request ID
		public void RequestID(String RequestID) {
			typeText(driver, test, "//input[@id='resultExportRequest_exportRequestValue_expReqId']",
					"Enter the request ID : ", RequestID);
		}
	
	// Select sbu and Request ID
	public void SBUSearch(String SBU, String Status) {
		selectByVisibleText(driver, test, "//select[@id='resultExportRequest_exportRequestValue_sbuCode']",
					"select the sbu : ", SBU);
		selectByVisibleText(driver, test, OCR_SearchExportReq_StatusDropdwn, "Selecting Status :", Status);
	}
		
	// Click on Request ID
	public void click_RequestID() {
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//td[@aria-describedby='grid_expReqId'])[1]", "Clicking on First Request ID :");
	}
		
	// Click on Copy Icon
	public void click_CopyIcon() {
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//td[@aria-describedby='grid_copy'])[1]", "Clicking on Copy Icon :");
		Wait.waitfor(6);
		AlertPopUp(driver, test, "Would you like to copy the existing attachments to the new form?");
		String alertmsg = "Proceed to Copy without Invalid data";
		//String alertmsg = getText(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Alert Msg :");
		try {
			if(alertmsg.equalsIgnoreCase("Proceed to Copy without Invalid data")) {
				clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Clicking on Proceed Without Invalid Data Button :");
				}
			else {
				clickElement(driver, test, "//span[contains(text(),'Abort Copying')]", "Clicking on Abort Copying :");
			}
		}catch(Exception e) {
				test.log(LogStatus.INFO, "Clicked on Copy Icon without Alert Msg :");
			}
	}

	// Click on Search button
	public void click_SearchBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'Search')]", "Click on Search button");
	}
	
	public void editrequest() {
		clickElement(driver, test, "//tbody/tr[@id='1']/td[3]","Click on Request");
	}
	
	//Click on General info tab
	public void geninfoTab() {
		clickElement(driver, test, "//a[@class='genInfo']", "Clicking on General Info tab :");
		Wait.waitfor(3);
		clickElement(driver, test, "//span[contains(text(),'Requestor Details')]", "Clicking on Requester Details sub Tab");
	}
}
