package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchDebriefIncidentsReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

		//------------------------------Locators------------------------------------
		
		public static final String OCR_DebrifIncident_Search = "//button[contains(text(),'Search')]";
		public static final String OCR_DebrifIncident_Reset = "//button[contains(text(),'Reset')]";
		public static final String OCR_DebrifIncident_SBUcode = "//select[@id='sbuCode']";
		public static final String OCR_DebrifIncident_VisitorRequestId = "//input[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_visitorId']";
		public static final String OCR_DebrifIncident_VisitorName = "//input[@id='visitorDebriefIncidentForm_visitorName']";
		public static final String OCR_DebrifIncident_VisitRequestFrom = "//input[@id='visitorDebriefIncidentForm_visitDateFrom']";
		public static final String OCR_DebrifIncident_VisitDateTo = "//input[@id='visitorDebriefIncidentForm_visitDateTo']";
		public static final String OCR_DebrifIncident_CountryOfCitizenship = "//input[@id='visitorDebriefIncidentForm_visitorPersonVal_countryOfCitizenship']";
		public static final String OCR_DebrifIncident_VisitPurpose = "//select[@id='visitorDebriefIncidentForm_visitPurpose']";
		public static final String OCR_DebrifIncident_ClassificationLevel = "//select[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_classification']";
		public static final String OCR_DebrifIncident_TypeOfperson = "//select[@id='visitorDebriefIncidentForm_typeOfPerson']";
		public static final String OCR_DebrifIncident_VisitorRequestStatus = "//option[contains(text(),'VRequestStatus')]";
		public static final String OCR_DebrifIncident_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
		public static final String OCR_DebrifIncident_VisitorCategory = "//select[@id='visitorDebriefIncidentForm_visitCategory']";
		// public static final String OCR_DebrifIncident_MeetingCategory =
		// "//div[@class='ms-trigger'][1])";
		public static final String OCR_DebrifIncident_CompanyName = "//input[@id='visitorDebriefIncidentForm_visitorCompanyValue_companyName']";
		public static final String OCR_DebrifIncident_ORGtype = "//select[@id='visitorDebriefIncidentForm_orgType']";
		public static final String OCR_DebrifIncident_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
		public static final String OCR_DebrifIncident_Country = "//input[@id='visitorDebriefIncidentForm_visitorCompanyValue_country']";
		public static final String OCR_DebrifIncident_CountryOfIncorporation = "//input[@id='visitorDebriefIncidentForm_visitorCompanyValue_countryIncorp']";
		public static final String OCR_DebrifIncident_SecurityReviewer = "//input[@id='securityUserFullName']";
		public static final String OCR_DebrifIncident_ExportReviewer = "//input[@id='exportUserFullName']";
		public static final String OCR_DebrifIncident_TDFPReviewer = "//input[@id='tdfpUserFullName']";
		public static final String OCR_DebrifIncident_ManagerReviewer = "//input[@id='managerUserFullName']";
		public static final String OCR_DebrifIncident_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
		public static final String OCR_DebrifIncident_RequesterName = "//input[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_requestorName']";
		public static final String OCR_DebrifIncident_BuildingName = "//input[@name='building']";
		public static final String OCR_DebrifIncident_Programs = "//textarea[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_program']";
		public static final String OCR_DebrifIncident_TDYSegment = "//textarea[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_segment']";
		public static final String OCR_DebrifIncident_ProductFamily = "//textarea[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_productFamily']";
		public static final String OCR_DebrifIncident_ProductLine = "//textarea[@id='visitorDebriefIncidentForm_visitorGeneralInfoValue_productLine']";
		public static final String OCR_DebrifIncident_Sites = "//div[@class='ms-trigger'][1])";
		public static final String OCR_DebrifIncident_ActivityType = "//select[@id='activityId']";
		public static final String OCR_DebrifIncident_AuthorizationType = "//textarea[@id='visitorDebriefIncidentForm_visitorAdditionalInfoValue_exemptionNo']";
		public static final String OCR_DebrifIncident_AuthorizationNo = "//input[@id='visitorDebriefIncidentForm_visitorAdditionalInfoValue_expAuthority']";
		public static final String OCR_DebrifIncident_AgreementNo = "//input[@id='visitorDebriefIncidentForm_visitorAdditionalInfoValue_agreementNo']";
		public static final String OCR_DebrifIncident_ExportAuthority = "//select[@id='visitorDebriefIncidentForm_exportAuthority']";
		public static final String OCR_DebrifIncident_VISITREQUESTCreatedDateFrom = "//input[@id='visitorDebriefIncidentForm_visitRequestCreatedDateFrom']";
		public static final String OCR_DebrifIncident_VISITREQUESTCreatedDateTo = "//input[@id='visitorDebriefIncidentForm_visitRequestCreatedDateTo']";
		public static final String OCR_DebrifIncident_VISITREQUESTSubmittedDateFrom = "//input[@id='visitorDebriefIncidentForm_visitRequestSubmittedDateFrom']";
		public static final String OCR_DebrifIncident_VISITREQUESTSubmittedDateTo = "//input[@id='visitorDebriefIncidentForm_visitRequestSubmittedDateTo']";
		public static final String OCR_DebrifIncident_visitorRequestApprovedDateFrom = "//input[@id='visitorDebriefIncidentForm_visitorRequestApprovedDateFrom']";
		public static final String OCR_DebrifIncident_visitorRequestApprovedDateTo = "//input[@id='visitorDebriefIncidentForm_visitorRequestApprovedDateTo']";
		public static final String OCR_DebrifIncident_SortBy = "//select[@name='sortBy']";
		public static final String OCR_DebrifIncident_Direction = "//select[@name='direction']";
		public static final String OCR_DebrifIncident_SiteTextBox="//input[@xpath='1']";
		public static final String OCR_DebrifIncident_TitleofReport ="//h3[contains(text(),'Debrief Incidents Report')]";

		/* ******************** Constructor ***************************** */

		public SearchDebriefIncidentsReportPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
		/* ******************** Actions ********************************* */

		public void clickSearchbutton() {
			scrollToElement(driver, OCR_DebrifIncident_Search);
			clickElement(driver, test, OCR_DebrifIncident_Search, "Click on search button");
		}

		public void clickResetButton() {
			clickElement(driver, test, OCR_DebrifIncident_Reset, "Click on reset button");
		}

		public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
				String VisitRequestTo, String VisitPurpose, String ClassificationLevel, String TypeOfPerson, String VisitorCategory, String site,
				String FromDate, String ToDate, String SToDate, String SFromDate, String AFromDate, String AToDate,
				String SortBy, String Direction)

		{
			selectByVisibleText(driver, test, OCR_DebrifIncident_SBUcode, "Select SBU code", SBUCode);
			Wait.waitfor(4);
			typeText(driver, test, OCR_DebrifIncident_VisitorRequestId, "Add Visitor request ID", RequestID);

			Wait.waitfor(2);
			typeText(driver, test, OCR_DebrifIncident_VisitorName, "Add visitor name", VisitorName);

			// Add Visit request from (mm-dd-yyyy)
			Wait.waitfor(2);
			if (VisitRequestFrom.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_VisitRequestFrom, "Click on from date");
				date(driver, test, "select date", VisitRequestFrom);
			}

			// typeText(driver, test, OCR_DebrifIncident_VisitRequestFrom, "Add visit from date",
			// VisitRequestFrom);

			Wait.waitfor(2);
			if (VisitRequestTo.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_VisitDateTo, "Click on from date");
				// typeText(driver, test,OCR_DebrifIncident_VisitDateTo, "Add visit from date",
				// VisitRequestTo);
				date(driver, test, "select date", VisitRequestTo);
			}
			Wait.waitfor(2);

			selectByVisibleText(driver, test, OCR_DebrifIncident_VisitPurpose, "", VisitPurpose);
			Wait.waitfor(2);

			selectByVisibleText(driver, test, OCR_DebrifIncident_ClassificationLevel, "Add Classification Level",
					ClassificationLevel);

			Wait.waitfor(2);

			
			selectByVisibleText(driver, test, OCR_DebrifIncident_TypeOfperson , "Add Type of person",
					TypeOfPerson);

			Wait.waitfor(2);
			
			selectByVisibleText(driver, test, OCR_DebrifIncident_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
			scrollToBottom(driver);
			if (site.length() > 0) {
				typeText(driver, test, OCR_DebrifIncident_SiteTextBox, "Type site name", site);
				
				
				/*clickElement(driver, test, OCR_DebrifIncident_Sites, "click on Site down arrow");
				site = "//div[contains(text(),'" + site + "')]";
				clickElement(driver, test, site, "click on Required Site : " + site);*/
			}

			Wait.waitfor(2);
			if (FromDate.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_VISITREQUESTCreatedDateFrom, "Click on from date");
				// typeText(driver, test,OCR_DebrifIncident_VISITREQUESTCreatedDateFrom , "Add visit from
				// date", FromDate);
				date(driver, test, "select date", FromDate);
			}

			Wait.waitfor(2);
			if (ToDate.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_VISITREQUESTCreatedDateTo, "Click on from date");
				// typeText(driver, test,OCR_DebrifIncident_VISITREQUESTCreatedDateTo , "Add visit to
				// date", ToDate);
				date(driver, test, "select date", ToDate);
			}

			Wait.waitfor(2);
			if (SToDate.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_VISITREQUESTSubmittedDateTo, "Click on from date");
				// typeText(driver, test, OCR_DebrifIncident_VISITREQUESTSubmittedDateTo , "Add visit To
				// date", SToDate);
				date(driver, test, "select date", SToDate);
			}

			Wait.waitfor(2);
			if (SFromDate.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_VISITREQUESTSubmittedDateFrom, "Click on from date");
				// typeText(driver, test, OCR_DebrifIncident_VISITREQUESTSubmittedDateFrom , "Add visit
				// from date", SFromDate);
				date(driver, test, "select date", SFromDate);
			}

			Wait.waitfor(2);

			if (AFromDate.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_visitorRequestApprovedDateFrom, "Click on from date");
				// typeText(driver, test, OCR_DebrifIncident_visitorRequestApprovedDateFrom , "Add visit
				// from date", AFromDate);
				date(driver, test, "select date", AFromDate);
			}

			Wait.waitfor(2);
			if (AToDate.length() > 0) {
				clickElement(driver, test, OCR_DebrifIncident_visitorRequestApprovedDateTo, "Click on from date");
				// typeText(driver, test, OCR_DebrifIncident_visitorRequestApprovedDateTo , "Add visit to
				// date", AToDate);
				date(driver, test, "select date", AToDate);
			}

			selectByVisibleText(driver, test, OCR_DebrifIncident_SortBy, "Add SortBy ", SortBy);

			selectByVisibleText(driver, test, OCR_DebrifIncident_Direction, "select Direction ", Direction);
			scrollToElement(driver, OCR_DebrifIncident_Search);

		}
		
	}


