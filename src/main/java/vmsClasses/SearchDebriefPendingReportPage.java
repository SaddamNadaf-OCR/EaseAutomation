package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchDebriefPendingReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	//------------------------------Locators------------------------------------
	
			public static final String OCR_DebriefPending_Search = "//button[contains(text(),'Search')]";
			public static final String OCR_DebriefPending_Reset = "//button[contains(text(),'Reset')]";
			public static final String OCR_DebriefPending_SBUcode = "//select[@id='sbuCode']";
			public static final String OCR_DebriefPending_VisitorRequestId = "//input[@id='resultPendingReport_visitorGeneralInfoValue_visitorId']";
			public static final String OCR_DebriefPending_VisitorName = "////input[@id='resultPendingReport_visitorName']";
			public static final String OCR_DebriefPending_VisitRequestFrom = "//input[@id='resultPendingReport_visitDateFrom']";
			public static final String OCR_DebriefPending_VisitDateTo = "//input[@id='resultPendingReport_visitDateTo']";
			public static final String OCR_DebriefPending_CountryOfCitizenship = "//input[@id='resultPendingReport_visitorPersonVal_countryOfCitizenship']";
			public static final String OCR_DebriefPending_VisitPurpose = "//select[@id='resultPendingReport_visitPurpose']";
			public static final String OCR_DebriefPending_ClassificationLevel = "//select[@id='resultPendingReport_visitorGeneralInfoValue_classification']";
			public static final String OCR_DebriefPending_TypeOfperson = "//select[@id='resultPendingReport_typeOfPerson']";
			public static final String OCR_DebriefPending_VisitorRequestStatus = " //option[contains(text(),'-ALL-')]";
			public static final String OCR_DebriefPending_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
			public static final String OCR_DebriefPending_VisitorCategory = " //select[@id='resultPendingReport_visitCategory']";
			// public static final String OCR_DebriefPending_MeetingCategory =
			// "//div[@class='ms-trigger'][1])";
			public static final String OCR_DebriefPending_CompanyName = "//input[@id='resultPendingReport_visitorCompanyValue_companyName']";
			public static final String OCR_DebriefPending_ORGtype = "//select[@id='resultPendingReport_orgType']";
			public static final String OCR_DebriefPending_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
			public static final String OCR_DebriefPending_Country = "//input[@id='resultPendingReport_visitorCompanyValue_country']";
			public static final String OCR_DebriefPending_CountryOfIncorporation = "//input[@id='resultPendingReport_visitorCompanyValue_countryIncorp']";
			public static final String OCR_DebriefPending_SecurityReviewer = "//input[@id='resultPendingReport_securityReviewer']";
			public static final String OCR_DebriefPending_ExportReviewer = "//input[@id='resultPendingReport_exportReviewer']";
			public static final String OCR_DebriefPending_TDFPReviewer = "//input[@id='resultPendingReport_tdfpName']";
			public static final String OCR_DebriefPending_ManagerReviewer = "//input[@id='managerUserFullName']";
			public static final String OCR_DebriefPending_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
			public static final String OCR_DebriefPending_RequesterName = "//input[@id='resultPendingReport_visitorGeneralInfoValue_requestorName']";
			public static final String OCR_DebriefPending_BuildingName = "//input[@name='building']";//textarea[@id='resultPendingReport_visitorGeneralInfoValue_program']
			public static final String OCR_DebriefPending_Programs = "//textarea[@id='resultPendingReport_visitorGeneralInfoValue_program']";
			public static final String OCR_DebriefPending_TDYSegment = "//textarea[@id='resultPendingReport_visitorGeneralInfoValue_segment']";
			public static final String OCR_DebriefPending_ProductFamily = "//textarea[@id='resultPendingReport_visitorGeneralInfoValue_productFamily']";
			public static final String OCR_DebriefPending_ProductLine = "//textarea[@id='resultPendingReport_visitorGeneralInfoValue_productLine']";
			public static final String OCR_DebriefPending_Sites = "//div[@class='ms-trigger'][1])";
			public static final String OCR_DebriefPending_ActivityType = "//select[@id='activityId']";
			public static final String OCR_DebriefPending_AuthorizationType = "//textarea[@id='resultPendingReport_visitorAdditionalInfoValue_exemptionNo']";
			public static final String OCR_DebriefPending_AuthorizationNo = "//input[@id='resultPendingReport_visitorAdditionalInfoValue_expAuthority']";
			public static final String OCR_DebriefPending_AgreementNo = "//input[@id='resultPendingReport_visitorAdditionalInfoValue_agreementNo']";
			public static final String OCR_DebriefPending_ExportAuthority = "//select[@id='resultPendingReport_exportAuthority']";
			public static final String OCR_DebriefPending_VISITREQUESTCreatedDateFrom = "//input[@id='resultPendingReport_visitRequestCreatedDateFrom']";
			public static final String OCR_DebriefPending_VISITREQUESTCreatedDateTo = "//input[@id='resultPendingReport_visitRequestCreatedDateTo']";
			public static final String OCR_DebriefPending_VISITREQUESTSubmittedDateFrom = "//input[@id='resultPendingReport_visitRequestSubmittedDateFrom']";
			public static final String OCR_DebriefPending_VISITREQUESTSubmittedDateTo = "//input[@id='resultPendingReport_visitRequestSubmittedDateTo']";
			public static final String OCR_DebriefPending_visitorRequestApprovedDateFrom = "//input[@id='resultPendingReport_visitorRequestApprovedDateFrom']";
			public static final String OCR_DebriefPending_visitorRequestApprovedDateTo = "//input[@id='resultPendingReport_visitorRequestApprovedDateTo']";
			public static final String OCR_DebriefPending_SortBy = "//select[@name='sortBy']";
			public static final String OCR_DebriefPending_Direction = "//select[@name='direction']";
			public static final String OCR_DebriefPending_SiteTextBox="//input[@xpath='1']";
			public static final String OCR_DebriefPending_TitleofReport ="//h3[contains(text(),'Debrief Pending Report')]";

			/* ******************** Constructor ***************************** */

			public SearchDebriefPendingReportPage(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
			}
			/* ******************** Actions ********************************* */

			public void clickSearchbutton() {
				scrollToElement(driver, OCR_DebriefPending_Search);
				clickElement(driver, test, OCR_DebriefPending_Search, "Click on search button");
			}

			public void clickResetButton() {
				clickElement(driver, test, OCR_DebriefPending_Reset, "Click on reset button");
			}

			public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
					String VisitRequestTo, String VisitPurpose, String ClassificationLevel, String TypeOfPerson, String VisitorCategory, String site,
					String FromDate, String ToDate, String SToDate, String SFromDate, String AFromDate, String AToDate,
					String SortBy, String Direction)

			{
				selectByVisibleText(driver, test, OCR_DebriefPending_SBUcode, "Select SBU code", SBUCode);
				Wait.waitfor(4);
				typeText(driver, test, OCR_DebriefPending_VisitorRequestId, "Add Visitor request ID", RequestID);

				Wait.waitfor(2);
				typeText(driver, test, OCR_DebriefPending_VisitorName, "Add visitor name", VisitorName);

				// Add Visit request from (mm-dd-yyyy)
				Wait.waitfor(2);
				if (VisitRequestFrom.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_VisitRequestFrom, "Click on from date");
					date(driver, test, "select date", VisitRequestFrom);
				}

				// typeText(driver, test, OCR_DebriefPending_VisitRequestFrom, "Add visit from date",
				// VisitRequestFrom);

				Wait.waitfor(2);
				if (VisitRequestTo.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_VisitDateTo, "Click on from date");
					// typeText(driver, test,OCR_DebriefPending_VisitDateTo, "Add visit from date",
					// VisitRequestTo);
					date(driver, test, "select date", VisitRequestTo);
				}
				Wait.waitfor(2);

				selectByVisibleText(driver, test, OCR_DebriefPending_VisitPurpose, "", VisitPurpose);
				Wait.waitfor(2);

				selectByVisibleText(driver, test, OCR_DebriefPending_ClassificationLevel, "Add Classification Level",
						ClassificationLevel);

				Wait.waitfor(2);

				
				selectByVisibleText(driver, test, OCR_DebriefPending_TypeOfperson , "Add Type of person",
						TypeOfPerson);

				Wait.waitfor(2);
				
				selectByVisibleText(driver, test, OCR_DebriefPending_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
				scrollToBottom(driver);
				if (site.length() > 0) {
					typeText(driver, test, OCR_DebriefPending_SiteTextBox, "Type site name", site);
					
					
					/*clickElement(driver, test, OCR_DebriefPending_Sites, "click on Site down arrow");
					site = "//div[contains(text(),'" + site + "')]";
					clickElement(driver, test, site, "click on Required Site : " + site);*/
				}

				Wait.waitfor(2);
				if (FromDate.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_VISITREQUESTCreatedDateFrom, "Click on from date");
					// typeText(driver, test,OCR_DebriefPending_VISITREQUESTCreatedDateFrom , "Add visit from
					// date", FromDate);
					date(driver, test, "select date", FromDate);
				}

				Wait.waitfor(2);
				if (ToDate.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_VISITREQUESTCreatedDateTo, "Click on from date");
					// typeText(driver, test,OCR_DebriefPending_VISITREQUESTCreatedDateTo , "Add visit to
					// date", ToDate);
					date(driver, test, "select date", ToDate);
				}

				Wait.waitfor(2);
				if (SToDate.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_VISITREQUESTSubmittedDateTo, "Click on from date");
					// typeText(driver, test, OCR_DebriefPending_VISITREQUESTSubmittedDateTo , "Add visit To
					// date", SToDate);
					date(driver, test, "select date", SToDate);
				}

				Wait.waitfor(2);
				if (SFromDate.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_VISITREQUESTSubmittedDateFrom, "Click on from date");
					// typeText(driver, test, OCR_DebriefPending_VISITREQUESTSubmittedDateFrom , "Add visit
					// from date", SFromDate);
					date(driver, test, "select date", SFromDate);
				}

				Wait.waitfor(2);

				if (AFromDate.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_visitorRequestApprovedDateFrom, "Click on from date");
					// typeText(driver, test, OCR_DebriefPending_visitorRequestApprovedDateFrom , "Add visit
					// from date", AFromDate);
					date(driver, test, "select date", AFromDate);
				}

				Wait.waitfor(2);
				if (AToDate.length() > 0) {
					clickElement(driver, test, OCR_DebriefPending_visitorRequestApprovedDateTo, "Click on from date");
					// typeText(driver, test, OCR_DebriefPending_visitorRequestApprovedDateTo , "Add visit to
					// date", AToDate);
					date(driver, test, "select date", AToDate);
				}

				selectByVisibleText(driver, test, OCR_DebriefPending_SortBy, "Add SortBy ", SortBy);

				selectByVisibleText(driver, test, OCR_DebriefPending_Direction, "select Direction ", Direction);
				scrollToElement(driver, OCR_DebriefPending_Search);

			}
			
		}



