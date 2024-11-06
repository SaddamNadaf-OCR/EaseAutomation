/* 
 * Module : VMS
 * Author  : Nancy
 * created date : Feb 2019
 * Descriptions : Creating Standard Request
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.ChangeRequestPage;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.DocumentPage;
import vmsClasses.HomePage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewerPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;
import initializer.SeleniumTestBase;

public class StandardRequestCreation extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void standardrequest(String Testcase, String RunMode, String CheckList, String SBU, String SelectSBU,
			String HostSBU, String MeetingLocationSBU, String VisitDateFrom, String VisitDateTo,
			String RequestorFirstName, String Email, String Phone, String EmployeeId, String LocalHost,
			String PrimaryHost, String AddHostUserFirstName, String HostName, String HostEmail,
			String LastCompliancedate, String Site, String BuildingName, String EntranceLobby, String RoomNoDescription,
			String ClassificationLevel, String VisitPurpose, String DescriptionOfVisit, String MeetingCategories,
			/*String Program, String Segment, String ProductFamily, String ProductLine,*/ String ChargeNumber,
			String OnLoanDepartment, String OrgName, String OrgType, String Address, String Address2, String Address3,
			String City, String Zip, String Country, String State, String CountryOfIncorporation, String USAgency,
			String DLISCageCode, String DUNS_EIN, String Title, String FirstName, String MiddleName, String LastName,
			String Company, String VisitorEmail, String PhoneNumber, String VAddress, String VAddress2,
			String VAddress3, String VCity, String VCountry, String VState, String VZip, String TypeOfPerson,
			String CountryofResidence, String VisitorCategory, String CountryofCitizenship,
			String OtherCountriesofCitizenship, String RepresentingForeignInterest, String DateofBirth,
			String PlaceofBirth, String CountryofBirth, String Gender, String IdentifyingDocuments,
			String DocumentNumber, String ExpirationDate, String IssuingState, String IssuingCountry,
			String EquipDescription, String EquipJustification, String DomesticOrForeign, String QuestionnairreTab,
			String Questionnairre, String DocumentType, String DocumentDescription, String UploadFile,
			String DocKeywords, String SourceSystemDocNumber, String Notes, String HostUserFirstName,
			String TDFPUserFirstName, String ExportUserFirstName, String SecurityUserFirstName, String ReviewerType,
			String ReviewerName, String WithSelectedBadgeType, String OverallDecision, String Reason,
			String ChangeRequest, String DateFrom, String DateTo, String ReasonForChange) throws Exception {

		// *********** Objects Creation ******************************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);
		ChangeRequestPage changereq = new ChangeRequestPage(driver, test);

		// **************Test steps execution ***************************

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Features();
					searchVR.click_VisitorRequests();
					searchVR.click_VisitorRequest();
					searchVR.click_AddNewVisitorRequest();
					create.select_sbu(SelectSBU);
					create.select_HostSbu(HostSBU);
					create.select_MeetingLocationSBU(MeetingLocationSBU);
					
					//create.select_RequestorName(RequestorFirstName);
					create.type_Email(Email);
					create.type_Phone(Phone);
					create.type_EmployeeId(EmployeeId);
					if (LocalHost.length() > 0 && PrimaryHost.length() > 0) {
						create.check_LocalHost(LocalHost);
						create.check_PrimaryHost(PrimaryHost);
					}
					create.click_Create();
					String vid = visitorInfo.get_RequestID();
					Wait.waitfor(2);
					create.select_VisitDateFrom(VisitDateFrom);
					create.select_VisitDateTo(VisitDateTo);
					detail.enable_AllDayAcess();
					detail.select_247();
					detail.select_WeekendAccess();
					if (HostName.length() > 0) {
						detail.add_Host(HostName, HostEmail, LastCompliancedate,Phone);
					}
					Wait.waitfor(3);
					detail.add_Site(Site, BuildingName, EntranceLobby, RoomNoDescription);
					detail.select_classificationlevel(ClassificationLevel);
					detail.select_visitpurpose(VisitPurpose);
					detail.select_descriptionofvisit(DescriptionOfVisit);
					detail.select_meetingcategories(MeetingCategories);
					/*detail.select_program(Program);
					detail.select_segment(Segment);*/
					/*detail.select_productfamily(ProductFamily);
					detail.select_productline(ProductLine);*/
					detail.select_chargenumber(ChargeNumber);
					detail.select_onloandepartment(OnLoanDepartment);
					visitors.addOrganisation(OrgName, OrgType, Address, Address2, Address3, City, Zip, Country, State,
							CountryOfIncorporation, USAgency, DLISCageCode, DUNS_EIN);
					visitors.add_Individual(Title, FirstName, MiddleName, LastName,  VisitorEmail, PhoneNumber);
					visitors.add_AddressDetails(VAddress, VAddress2, VAddress3, VCity, VCountry, VState, VZip);
					visitors.add_Citizenship(TypeOfPerson, CountryofResidence, VisitorCategory, CountryofCitizenship,
							RepresentingForeignInterest, OtherCountriesofCitizenship);
					visitors.add_AdditionalDetails(DateofBirth, PlaceofBirth, CountryofBirth, Gender);
					visitors.add_IdentifyingDocuments(IdentifyingDocuments, DocumentNumber, ExpirationDate,
							IssuingState, IssuingCountry);
					visitors.add_AddEquipment(EquipDescription, EquipJustification);
					visitors.saveAndReturnBtn();
					Wait.waitfor(3);
					visitors.click_DplStatus();
					detail.forwardToQuestionnaire();
					Wait.waitfor(3);
					questionnairre.add_questions(Questionnairre);
					Wait.waitfor(3);
					questionnairre.click_saveBtn();
					Wait.waitfor(7);
					questionnairre.movetonextpage();
					Wait.waitfor(3);
					document.add_Document(DocumentType, DocumentDescription, UploadFile, DocKeywords,
							SourceSystemDocNumber);
					Wait.waitfor(5);
					/*document.Forword();
					Wait.waitfor(3);*/
					notes.click_AddNoteBtn();
					notes.add_notes(Notes);
					detail.forwardToSubmit();
					Wait.waitfor(3);
					if (HostUserFirstName.length() > 0) {
						submit.add_HostReviewer(HostUserFirstName);
					}
					if (TDFPUserFirstName.length() > 0) {
						submit.add_TDFPReviewer(TDFPUserFirstName);

					}
					if (ExportUserFirstName.length() > 0) {
						submit.add_ExportControlReviewer(ExportUserFirstName);
					}
					if (SecurityUserFirstName.length() > 0) {
						submit.add_SecurityReviewer(SecurityUserFirstName);
					}
					submit.save();
					submit.submitforreview();
					Wait.waitfor(3);
					if (CheckList.equalsIgnoreCase("Y")) {
						reviewer.click_CheckList();
					}
					reviewer.click_SelectAllBtn();
					reviewer.click_ApproveBtn();
					reviewer.overDecision(OverallDecision, Reason);
					Wait.waitfor(3);
					if (ChangeRequest.length() > 0) {
						detail.forwardToChangeRequestTab();
						Wait.waitfor(3);
						changereq.addchangerequest();
						Wait.waitfor(3);
						changereq.selectchangerequest(ChangeRequest, DateFrom, DateTo, ReasonForChange);
						Wait.waitfor(3);
						changereq.submitchange();
						Wait.waitfor(3);
						if (ChangeRequest.contains("D")) {
							detail.forwardToSubmit();
							submit.submitforreview();
							reviewer.overDecision(OverallDecision, Reason);
							Wait.waitfor(3);
						} else if (ChangeRequest.contains("A")) {
							detail.forwardToSubmit();
							submit.submitforreview();
							reviewer.overDecision(OverallDecision, Reason);
							Wait.waitfor(3);
						} else if (ChangeRequest.contains("O")) {
							detail.forwardToSubmit();
							submit.submitforreview();
							reviewer.overDecision(OverallDecision, Reason);
							Wait.waitfor(3);
						}
					}
					String status = visitorInfo.get_RequestStatus();
					if (status.contains("Approved")) {
						searchVR.moveTo_Features();
						searchVR.click_VisitorFrontDesk();
						visitorFD.click_AdvSearchBtn();
						visitorFD.searchVReqID(vid);
						visitorFD.clickSearch();
						visitorFD.clickCheckIN();
						visitorFD.click_AdvSearchBtn();
						visitorFD.searchVReqID(vid);
						visitorFD.clickSearch();
						visitorFD.clickCheckOut();
						Wait.waitfor(3);
						homePage.returnPage();
					} else if (status.contains("Disapproved")) {
						homePage.returnPage();
					} else if (status.contains("Returned For Rework")) {
						homePage.returnPage();
					}

					/*
					 * if (ReviewerType.length() > 0) { submit.add_additionalreviewer(ReviewerType,
					 * ReviewerName); Wait.waitfor(3); submit.get_errormessage(); } else {
					 * Wait.waitfor(3); submit.submitforreview();
					 * review.multiplereviewersprocess(WithSelectedBadgeType, OverallDecision,
					 * ReasonForDisapprovalOrRoR); String status1 = visitorInfo.get_RequestStatus();
					 * if (ChangeRequest.length() > 0) { detail.forwardToChangeRequestTab();
					 * Wait.waitfor(3); changereq.addchangerequest(); Wait.waitfor(3);
					 * changereq.selectchangerequest(ChangeRequest, DateFrom, DateTo,
					 * ReasonForChange); Wait.waitfor(3); changereq.submitchange(); Wait.waitfor(3);
					 * if (ChangeRequest.contains("D")) { detail.forwardToSubmit();
					 * submit.submitforreview(); // detail.forwardToReviewTab();
					 * review.multiplereviewersprocess(WithSelectedBadgeType, OverallDecision,
					 * ReasonForDisapprovalOrRoR); // review.approverequest(OverallDecision); //
					 * review.saveandfinalize(); Wait.waitfor(5); } else if
					 * (ChangeRequest.contains("A")) { driver.switchTo().alert().accept();
					 * Wait.waitfor(3);
					 * 
					 * } else if (ChangeRequest.contains("O")) { detail.forwardToSubmit();
					 * submit.submitforreview(); review.approverequest(OverallDecision);
					 * review.saveandfinalize(); } } Wait.waitfor(3); if
					 * (status.contains("Approved")) { Wait.waitfor(2); searchVR.moveTo_Features();
					 * searchVR.click_VisitorFrontDesk(); visitorFD.click_AdvSearchBtn();
					 * visitorFD.searchVReqID(vid); visitorFD.clickSearch();
					 * visitorFD.clickCheckOut(); Wait.waitfor(5); homePage.returnPage(); } else if
					 * (status.contains("Disapproved")) { homePage.returnPage(); } else if
					 * (status.contains("Returned For Rework")) { homePage.returnPage(); } }
					 */
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("StandardRequest", excel);
	}
}
