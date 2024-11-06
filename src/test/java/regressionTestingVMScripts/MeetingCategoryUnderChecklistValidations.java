package regressionTestingVMScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.DocumentPage;
import vmsClasses.HomePage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewerPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;
import vmsClasses.WorkflowConfigurationDetailsPage;

public class MeetingCategoryUnderChecklistValidations extends SeleniumTestBase {

	@Test(priority = 17)
	public void validateMeetingCategoryField() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		WorkflowConfigurationDetailsPage workConfig = new WorkflowConfigurationDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.clickNotification();
				vmct.click_WorkFlowConfig();
				workConfig.VmctCofigSelect(propVMs.getProperty("SBU"), "1");
				String metting = workConfig.getMeetingCategory();
				if (metting.equals("Meeting Category")) {
					test.log(LogStatus.PASS, "Meeting Category field is added");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Meeting Category field is not added");
				}
				Wait.waitfor(4);
				homePage.returnPage();
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 18)
	public void validateStandardReqMeetingCatgDirectApprovel() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.type_Phone("23231232134");
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				String vid = visitorInfo.get_RequestID();
				Wait.waitfor(4);
				detail.enable_AllDayAcess();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_meetingcategories("Technical Discussions");
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				Wait.waitfor(3);
				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
						/*propVMs.getProperty("Company"),*/ propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));
				visitors.select_OrgzAssociated("Representing Self");
				visitors.add_AddressDetails(propVMs.getProperty("Vaddress"), propVMs.getProperty("Vaddress2"),
						propVMs.getProperty("Vaddress3"), propVMs.getProperty("VCity"), propVMs.getProperty("VCountry"),
						propVMs.getProperty("VState"), propVMs.getProperty("VZip"));

				visitors.add_Citizenship(propVMs.getProperty("TypeOfPerson"), propVMs.getProperty("CountryofResidence"),
						propVMs.getProperty("Visitorcategory"), propVMs.getProperty("CountryofCitizenship"),
						propVMs.getProperty("RepresentingForeignInterest"),
						propVMs.getProperty("OtherCountriesofCitizenship"));

				visitors.add_AdditionalDetails(propVMs.getProperty("DateofBirth"), propVMs.getProperty("PlaceofBirth"),
						propVMs.getProperty("Countryofbirth"), propVMs.getProperty("Gender"));

				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),
						propVMs.getProperty("DocumentNumber"), propVMs.getProperty("ExpirationDate"),
						propVMs.getProperty("IssuingState"), propVMs.getProperty("IssuingCountry"));

				visitors.add_AddEquipment(propVMs.getProperty("EquipDescription"),
						propVMs.getProperty("EquipJustification"));
				visitors.saveAndReturnBtn();
				visitors.click_DplStatus();
				Wait.waitfor(4);
				Wait.waitfor(4);
				detail.forwardToQuestionnaire();
				Wait.waitfor(3);

				questionnairre.add_questions(propVMs.getProperty("Questionnairre"));
				detail.forwardToDocument();
				document.add_Document(propVMs.getProperty("DocumentType"), propVMs.getProperty("DocumentDescription"),
						propVMs.getProperty("UploadFile"), propVMs.getProperty("DocKeywords"),
						propVMs.getProperty("SourceSystemDocNumber"));

				notes.click_AddNoteBtn();
				notes.add_notes(propVMs.getProperty("Notes"));
				detail.forwardToSubmit();
				Wait.waitfor(3);
				submit.submitforreviewerAndApproved();
				String status = visitorInfo.get_RequestStatus1();
				if (status.contains("Approved")) {
					test.log(LogStatus.PASS, "Visitor request is Direct Approved");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Visitor request is  not Direct Approved");
				}
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
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 19)
	public void validateStandardReqMeetingCatgWithCheckList() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.type_Phone("23231232134");
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				Wait.waitfor(4);
				detail.enable_AllDayAcess();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_meetingcategories("Security Review");
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
						/*propVMs.getProperty("Company"),*/ propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));
				visitors.select_OrgzAssociated("Representing Self");
				visitors.add_AddressDetails(propVMs.getProperty("Vaddress"), propVMs.getProperty("Vaddress2"),
						propVMs.getProperty("Vaddress3"), propVMs.getProperty("VCity"), propVMs.getProperty("VCountry"),
						propVMs.getProperty("VState"), propVMs.getProperty("VZip"));

				visitors.add_Citizenship(propVMs.getProperty("TypeOfPerson"), propVMs.getProperty("CountryofResidence"),
						propVMs.getProperty("Visitorcategory"), propVMs.getProperty("CountryofCitizenship"),
						propVMs.getProperty("RepresentingForeignInterest"),
						propVMs.getProperty("OtherCountriesofCitizenship"));

				visitors.add_AdditionalDetails(propVMs.getProperty("DateofBirth"), propVMs.getProperty("PlaceofBirth"),
						propVMs.getProperty("Countryofbirth"), propVMs.getProperty("Gender"));

				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),
						propVMs.getProperty("DocumentNumber"), propVMs.getProperty("ExpirationDate"),
						propVMs.getProperty("IssuingState"), propVMs.getProperty("IssuingCountry"));

				visitors.add_AddEquipment(propVMs.getProperty("EquipDescription"),
						propVMs.getProperty("EquipJustification"));
				visitors.saveAndReturnBtn();
				visitors.click_DplStatus();
				Wait.waitfor(4);
				detail.forwardToQuestionnaire();
				Wait.waitfor(3);

				questionnairre.add_questions(propVMs.getProperty("Questionnairre"));
				detail.forwardToDocument();
				document.add_Document(propVMs.getProperty("DocumentType"), propVMs.getProperty("DocumentDescription"),
						propVMs.getProperty("UploadFile"), propVMs.getProperty("DocKeywords"),
						propVMs.getProperty("SourceSystemDocNumber"));

				notes.click_AddNoteBtn();
				notes.add_notes(propVMs.getProperty("Notes"));
				detail.forwardToSubmit();
				submit.add_SecurityReviewer(propVMs.getProperty("SecurityUserFirstName"));
				submit.save();
				submit.submitforreview();
				Wait.waitfor(3);
				//reviewer.click_CheckList();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision(propVMs.getProperty("OverallDecision"), "Reason");
				Wait.waitfor(3);
				homePage.returnPage();
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 20)
	public void validateStandardReqMultipleMeetingCatgWithCheckList() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.type_Phone("23231232134");
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				Wait.waitfor(4);
				detail.enable_AllDayAcess();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				ArrayList<String> meeting = GenericMethods.stringtoken("Security Review");
				for (int i = 0; i < meeting.size(); i++) {
					detail.select_meetingcategories(meeting.get(i));
				}
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
						/*propVMs.getProperty("Company"),*/ propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));
				visitors.select_OrgzAssociated("Representing Self");
				visitors.add_AddressDetails(propVMs.getProperty("Vaddress"), propVMs.getProperty("Vaddress2"),
						propVMs.getProperty("Vaddress3"), propVMs.getProperty("VCity"), propVMs.getProperty("VCountry"),
						propVMs.getProperty("VState"), propVMs.getProperty("VZip"));

				visitors.add_Citizenship(propVMs.getProperty("TypeOfPerson"), propVMs.getProperty("CountryofResidence"),
						propVMs.getProperty("Visitorcategory"), propVMs.getProperty("CountryofCitizenship"),
						propVMs.getProperty("RepresentingForeignInterest"),
						propVMs.getProperty("OtherCountriesofCitizenship"));

				visitors.add_AdditionalDetails(propVMs.getProperty("DateofBirth"), propVMs.getProperty("PlaceofBirth"),
						propVMs.getProperty("Countryofbirth"), propVMs.getProperty("Gender"));

				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),
						propVMs.getProperty("DocumentNumber"), propVMs.getProperty("ExpirationDate"),
						propVMs.getProperty("IssuingState"), propVMs.getProperty("IssuingCountry"));

				visitors.add_AddEquipment(propVMs.getProperty("EquipDescription"),
						propVMs.getProperty("EquipJustification"));
				visitors.saveAndReturnBtn();
				visitors.click_DplStatus();
				Wait.waitfor(4);
				detail.forwardToQuestionnaire();
				Wait.waitfor(3);

				questionnairre.add_questions(propVMs.getProperty("Questionnairre"));
				detail.forwardToDocument();
				document.add_Document(propVMs.getProperty("DocumentType"), propVMs.getProperty("DocumentDescription"),
						propVMs.getProperty("UploadFile"), propVMs.getProperty("DocKeywords"),
						propVMs.getProperty("SourceSystemDocNumber"));

				notes.click_AddNoteBtn();
				notes.add_notes(propVMs.getProperty("Notes"));
				detail.forwardToSubmit();
				submit.add_SecurityReviewer(propVMs.getProperty("SecurityUserFirstName"));
				submit.save();
				submit.submitforreview();
				Wait.waitfor(3);
				//reviewer.click_CheckList();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision(propVMs.getProperty("OverallDecision"), "Reason");
				Wait.waitfor(3);
				homePage.returnPage();
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

}
