package regressionTestingLicensePermitScript;
/* 
 * Module : LP
 * Author  : Saddam
 * created date : April 2024
 * Descriptions : Add General Form For Belgium Country
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;

import crsClasses.ExportInfoCountryPage;
import initializer.SeleniumTestBase;
import lpAppBelgiumClasses.ApplicationReferencePage;
import lpAppBelgiumClasses.CreateNewAuthorizationPage;
import lpAppBelgiumClasses.DomesticPartyDetailsPage;
import lpAppBelgiumClasses.EndUseSpecificPurposePage;
import lpAppBelgiumClasses.ExporterDetailsPage;
import lpAppBelgiumClasses.ForeignPartyDetailsPage;
import lpAppBelgiumClasses.HomeLpPage;
import lpAppBelgiumClasses.ItemsSectionPage;
import lpAppBelgiumClasses.SearchAuthorizationsPage;
import lpAppBelgiumClasses.SearchAuthorizationsResultsPage;
import lpAppBelgiumClasses.ViewEditAuthorizationDetailsPage;
import utilities.Utility;
import utilities.Wait;

public class LpBelgiumGeneralFormTransaction extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LpBelgiumGeneralForm", excel);
	}

	@Test(dataProvider = "getData")
	public void AddLpBelgium(String Testcase, String RunMode, String SBU, String AuthGrantByCountry, String AuthorizationCode, 
			String RefrenceId, String ProgramCode, String SegmentCode, String AuthPurposeStatus, String AuthorizationPurposeId, 
			String Agency, String DocumentType, String UploadfileName, String DocumentLocationPath, String ProviosDescription, 
			String Notes, String Status, String ExporterCode, String ApplicantStatus, String Aname, String Aaddress, String Acountry, 
			String Astate, String Acity, String Apincode, String Aphone, String CountryType, String AddCountry, String UploadItemExcel,
			String PartNo, String UnitOfMeasure, String Quantity, String Description, String TypeOfModification, String SalesOrderNo, 
			String SalesOrderLineItemNo, String Classification, String UnitValue, String Remark, String classification, 
			String UploadForeignPartyExcel, String consigneeCode, String consigneeType, String UploadDomesticPartyExcel, String exporterCode, 
			String ExporterStatus, String partyType, String EndUse, String EndUserType, String EndUserTextbox, String HDstatusReviewer, 
			String ReviewerUserFirstName, String HDstatusApprovedForSub, String HDstatusAgency, String HDstatusAgencyApproved, 
			String AgencyAuthorizationsNo, String AgencyIssueDate, String AgencyExpiryDate, String CheckSnapShot) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ApplicationReferencePage applicationRef = new ApplicationReferencePage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();
		ViewEditAuthorizationDetailsPage view_edit = new ViewEditAuthorizationDetailsPage(driver, test);
		ItemsSectionPage item = new ItemsSectionPage(driver, test);
		ForeignPartyDetailsPage foreignParty = new ForeignPartyDetailsPage(driver, test);
		DomesticPartyDetailsPage domesticparty = new DomesticPartyDetailsPage(driver, test);
		EndUseSpecificPurposePage enduser = new EndUseSpecificPurposePage(driver, test);
		SearchAuthorizationsResultsPage searchAuthResults = new SearchAuthorizationsResultsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homelp.moveTo_SBUSelection(SBU);
					searchAuth.click_AddAuthorization();
					createAuth.headerDetails(AuthGrantByCountry, AuthorizationCode, RefrenceId, ProgramCode,
							SegmentCode);
/*					createAuth.headerDetailsUnMandatory(AuthPurposeStatus, AuthorizationPurposeId);
					String wlsStatus = createAuth.wlsStatus();
					if (wlsStatus.equalsIgnoreCase("To Be Screened")) {
						test.log(LogStatus.PASS, "WLS Status : " + wlsStatus);
					} else {
						test.log(LogStatus.FAIL, "WLS Status : " + wlsStatus);
						testFail();
						softAssertion.assertTrue(false);
					}
					String Actual = createAuth.agencyAuthorization();
					if (Actual.equals(Agency)) {
						test.log(LogStatus.PASS, "Expected Agency : " + Agency);
					} else {
						test.log(LogStatus.FAIL, "Expected Agency : " + Agency);
						testFail();
						softAssertion.assertTrue(false);
					}*/
					Wait.waitfor(1);
					createAuth.click_Save();
					Wait.waitfor(1);
					//createAuth.pdfFile();
					createAuth.addDocument(DocumentType, UploadfileName, DocumentLocationPath);
					createAuth.add_ProviosConditions(ProviosDescription);
					createAuth.add_Note(Notes);
					createAuth.click_Save();
					createAuth.click_ApplicationDetails();
					/*String ReferenceID = exportDetails.ReferenceIDText();
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-IND")) {
						String YourReferenceID = applicationRef.get_yourRefID();
						applicationRef.licenceType(AuthorizationCode);
						String ReferenceIDs = exportDetails.ReferenceIDText();
						if (YourReferenceID.equalsIgnoreCase(ReferenceIDs)) {
							test.log(LogStatus.PASS, "Your Reference ID is equal to ReferenceID " + YourReferenceID);
						} else {
							test.log(LogStatus.FAIL,
									"Your Reference ID is not equal to ReferenceID " + YourReferenceID);
							testFail();
							softAssertion.assertTrue(false);
						}
						String StatusED = exportDetails.statusText();
						if (StatusED.equalsIgnoreCase("Status: In Progress")) {
							test.log(LogStatus.PASS, StatusED);
						} else {
							test.log(LogStatus.FAIL, StatusED);
							testFail();
							softAssertion.assertTrue(false);
						}
						Wait.waitfor(3);*/
						view_edit.applicationDetailsLabel(ExporterCode, ApplicantStatus, Aname, Aaddress, Acountry, 
								Astate, Acity, Apincode, Aphone);
						view_edit.Save();
						view_edit.addCountry(CountryType, AddCountry);
						view_edit.addItems(UploadItemExcel);
						Wait.waitfor(2);
						item.partNoLink(PartNo, UnitOfMeasure, Quantity, Description, TypeOfModification, SalesOrderNo, 
								SalesOrderLineItemNo, Classification, UnitValue, Remark);
						item.saveandreturn();
						item.itemGridDisplayed(PartNo);
						view_edit.addClassification(classification);
						view_edit.foreignPartyDetails(UploadForeignPartyExcel);
						foreignParty.addForeignParty();
						foreignParty.searchConsignee(consigneeCode);
						try {
							foreignParty.validateForigenPartyDetailsError();
						}catch(Exception e) {
							testFail();
						}
						foreignParty.validateForigenPartyDetailsErrorofSameCType(consigneeType);
						foreignParty.saveForeignParty(consigneeType);
						try {
							foreignParty.validate_addParties(consigneeType);
						}catch(Exception e) {
							testFail();
						}
						view_edit.domesticPartyDetails(UploadDomesticPartyExcel);
						domesticparty.searchparty(exporterCode, ExporterStatus);
						domesticparty.validateForigenPartyDetailsError();
						domesticparty.validateForigenPartyDetailsErrorofSameCType(partyType);
						domesticparty.saveDomesticParty(partyType);
						domesticparty.validate_addParties(partyType);
						view_edit.endUserDetails();
						enduser.endUserData(EndUse, EndUserType, EndUserTextbox);
						view_edit.BacktoHeader();
						Wait.waitfor(4);
						createAuth.select_status(HDstatusReviewer);
						createAuth.click_reviewerlink(ReviewerUserFirstName);
						createAuth.click_Save();
						createAuth.select_status(HDstatusApprovedForSub);
						createAuth.checkCircle();
						createAuth.click_Save();
						createAuth.select_status(HDstatusAgency);
						createAuth.click_Save();
						createAuth.select_status(HDstatusAgencyApproved);
						createAuth.click_Save();
						createAuth.agencyAuthoNo(AgencyAuthorizationsNo, AgencyIssueDate, AgencyExpiryDate);
						createAuth.click_Save();
						Wait.waitfor(4);
						/*if (CheckSnapShot.equalsIgnoreCase("Yes")) {
							createAuth.validateSnapshot(ReferenceID, AuthorizationCode, HDstatusAgencyApproved);
							Wait.waitfor(3);
						}
						homelp.moveTo_SBUSelection(SBU);
						searchAuth.referenceID(ReferenceID);
						searchAuth.click_SearchBtn();
						searchAuthResults.displayOfRefID(ReferenceID);*/
						softAssertion.assertAll();
						homelp.returnHomepageLP();
						Wait.waitfor(3);
					} else {
						test.log(LogStatus.SKIP, "Please check the run mode");
						throw new SkipException("Skipping the test");
					}
				}
		//	}
			}catch(Exception e) {
				testFail();
				test.log(LogStatus.SKIP, "Please check the run mode");
			}
	}
}
