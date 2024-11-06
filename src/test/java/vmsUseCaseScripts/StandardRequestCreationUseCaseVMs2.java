package vmsUseCaseScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CheckInVerifyDetailsPage;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.DocumentPage;
import vmsClasses.HomePage;
import vmsClasses.LoginPage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewerPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorRequestReviewPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;
import vmsClasses.WorkQueuePage;
import initializer.SeleniumTestBase;

public class StandardRequestCreationUseCaseVMs2 extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void standardrequest(String Testcase, String RunMode, String SBU, String SelectSBU, String HostSBU,
			String MeetingLocationSBU, String VisitDateFrom, String VisitDateTo, String RequestorFirstName,
			String Email, String Phone, String EmployeeId, String LocalHost, String PrimaryHost,
			String AddHostUserFirstName, String HostName, String HostEmail, String LastCompliancedate, String Site,
			String BuildingName, String EntranceLobby, String RoomNoDescription, String ClassificationLevel,
			String VisitPurpose, String DescriptionOfVisit, String MeetingCategories, String Program, String Segment,
			String ProductFamily, String ProductLine, String ChargeNumber, String OnLoanDepartment, String OrgName,
			String OrgType, String Address, String Address2, String Address3, String City, String Zip, String Country,
			String State, String CountryOfIncorporation, String USAgency, String DLISCageCode, String DUNS_EIN,
			String Title, String FirstName, String MiddleName, String LastName, String Company, String VisitorEmail,
			String PhoneNumber, String VAddress, String VCountry, String VState, String VZip, String TypeOfPerson,
			String CountryofResidence, String VisitorCategory, String CountryofCitizenship,
			String RepresentingForeignInterest, String EscortRequired, String DateofBirth, String PlaceofBirth,
			String CountryofBirth, String Gender, String IdentifyingDocuments, String DocumentNumber,
			String ExpirationDate, String IssuingState, String IssuingCountry, String EquipmentRequired,
			String EquipDescription, String EquipJustification, String DomesticOrForeign, String QuestionnairreTab,
			String Questionnairre, String DocumentType, String DocumentDescription, String UploadFile,
			String DocKeywords, String SourceSystemDocNumber, String Notes, String SecurityUserFirstName,
			String SecurityUserName, String SecurityUserPassword, String ExportUserName, String ExportUserPassword,
			String OverallDecision, String Reason, String PolicyFirstName, String DocumentDetails, String BusinessUnit)
			throws Exception {

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
		WorkQueuePage workQue = new WorkQueuePage(driver, test);
		VisitorRequestReviewPage reqReview = new VisitorRequestReviewPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);
		CheckInVerifyDetailsPage checkInVerify = new CheckInVerifyDetailsPage(driver, test);
		LoginPage login = new LoginPage(driver, test);

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
					create.select_VisitDateFrom(VisitDateFrom);
					create.select_VisitDateTo(VisitDateTo);
					create.select_RequestorName(RequestorFirstName);

					create.type_Email(Email);
					create.type_Phone(Phone);
					create.type_EmployeeId(EmployeeId);
					if (LocalHost.length() > 0 && PrimaryHost.length() > 0) {
						create.check_LocalHost(LocalHost);
						create.check_PrimaryHost(PrimaryHost);
					}
					create.click_Create();
					String vid = visitorInfo.get_RequestID();
					detail.select_VisitDateFrom(VisitDateFrom);
					detail.select_VisitDateTo(VisitDateTo);
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
					detail.select_program(Program);
					detail.select_segment(Segment);
					detail.select_productfamily(ProductFamily);
					detail.select_productline(ProductLine);
					detail.select_chargenumber(ChargeNumber);
					detail.select_onloandepartment(OnLoanDepartment);
					visitors.addOrganisation(OrgName, OrgType, Address, Address2, Address3, City, Zip, Country, State,
							CountryOfIncorporation, USAgency, DLISCageCode, DUNS_EIN);

					ArrayList<String> policyFirstName = GenericMethods.stringtoken(PolicyFirstName);

					visitors.add_Individual(Title, FirstName, MiddleName, LastName,  VisitorEmail, PhoneNumber);
					visitors.add_AddressDetails(VAddress, "", "", "", VCountry, VState, VZip);
					visitors.add_Citizenship(TypeOfPerson, CountryofResidence, VisitorCategory, CountryofCitizenship,
							RepresentingForeignInterest, "");
					visitors.click_EscortRequied(EscortRequired);
					visitors.add_AdditionalDetails(DateofBirth, PlaceofBirth, CountryofBirth, Gender);
					visitors.add_IdentifyingDocuments(IdentifyingDocuments, DocumentNumber, ExpirationDate,
							IssuingState, IssuingCountry);
					if (EquipmentRequired.equalsIgnoreCase("Yes")) {
						visitors.add_AddEquipment(EquipDescription, EquipJustification);
					}
					visitors.saveAndReturnBtn();
					Wait.waitfor(3);
					visitors.click_DplStatus();
					visitors.movetonextpage();
					Wait.waitfor(3);
					questionnairre.add_questions(Questionnairre);
					questionnairre.click_saveBtn();
					questionnairre.movetonextpage();
					document.add_Document(DocumentType, DocumentDescription, UploadFile, DocKeywords,
							SourceSystemDocNumber);
					Wait.waitfor(5);
					notes.click_AddNoteBtn();
					notes.add_notes(Notes);
					notes.movetonextpage();
					Wait.waitfor(3);
					submit.save();
					submit.add_SecurityReviewer(SecurityUserFirstName);
					submit.submitforreview();
					Wait.waitfor(3);
					homePage.clickLogOut();

					login.login(SecurityUserName, SecurityUserPassword);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Features();
					searchVR.click_WorkQueue();
					workQue.securityReviewerQueue(BusinessUnit, vid);
					reqReview.clickReviewerRequest();
					reviewer.click_SelectAllBtn();
					reviewer.click_ApproveBtn();
					reviewer.overDecision(OverallDecision, Reason);
					Wait.waitfor(3);
					reviewer.click_Back();
					reqReview.click_Cancle();
					Wait.waitfor(3);
					homePage.clickLogOut();

					login.login(ExportUserName, ExportUserPassword);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Features();
					searchVR.click_WorkQueue();
					workQue.exportReviewerQueue(BusinessUnit, vid);
					reqReview.clickReviewerRequest();
					reviewer.click_SelectAllBtn();
					reviewer.click_ApproveBtn();
					reviewer.exportOverDecision(OverallDecision, Reason);
					Wait.waitfor(3);
					reviewer.click_Back();
					reqReview.click_Cancle();
					Wait.waitfor(3);
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					Wait.waitfor(3);
					for (int i = 0; i < policyFirstName.size(); i++) {
						visitorFD.click_AdvSearchBtn();
						visitorFD.searchVReqID(vid);
						visitorFD.clickSearch();
						Wait.waitfor(3);
						visitorFD.clickVisitorLink(policyFirstName.get(i));
						checkInVerify.acceptingPolicy(DocumentDetails);
						checkInVerify.click_CheckIn();
						Wait.waitfor(3);
					}
					searchVR.moveTo_Features();
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(3);
					homePage.returnPage();
					Wait.waitfor(3);
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
		return Utility.getData("UseCase2", excel);
	}
}