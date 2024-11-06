package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.ChangeRequestPage;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.DocumentPage;
import vmsClasses.HomePage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewPage;
import vmsClasses.ReviewerPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;

public class StandardReqErrorValidations extends SeleniumTestBase {

	@Test(priority = 7)
	public void validateCreatNewVR() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);

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
				create.click_Create();
				create.validate_CreatNewVR(propVMs.getProperty("HostSBU"), prop.getProperty("MeetingLocationSBU"));
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8)
	public void validateVisitDetails() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
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
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.click_Create();
				detail.enable_AllDayAcess();
				detail.click_Savebtn();
				detail.validate_VisitDetailsMeetingInfo();
				detail.validate_AddSite();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.click_Savebtn();
				detail.validate_OtherDetails();
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);

		}
	}

	@Test(priority = 9)
	public void validateAddOrganizationsAndAddVisitor() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
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
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.click_Create();
				detail.enable_AllDayAcess();
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.forwardToVisitors();
				visitors.validate_addOrganizationError();
				visitors.validate_addOrganizationWarning(propVMs.getProperty("OrgName"), propVMs.getProperty("OrgType"),
						propVMs.getProperty("City"), propVMs.getProperty("Country"),
						propVMs.getProperty("CountryOfIncorporation"), propVMs.getProperty("Zip"),
						propVMs.getProperty("State"));
				visitors.validate_addEditIndividualError();
				visitors.validate_addEditIndividualWarning(propVMs.getProperty("Title"),
						propVMs.getProperty("FirstName"), propVMs.getProperty("MiddleName"),
						propVMs.getProperty("LastName"), propVMs.getProperty("Company"),
						propVMs.getProperty("VisitorEmail"), propVMs.getProperty("PhoneNumber"),
						propVMs.getProperty("VCountry"), propVMs.getProperty("TypeOfPerson"),
						propVMs.getProperty("CountryofCitizenship"), propVMs.getProperty("DateofBirth"),
						propVMs.getProperty("PlaceofBirth"));
				Wait.waitfor(3);
				visitors.validate_IdentityDocWarning(propVMs.getProperty("IdentifyingDocuments"));
				Wait.waitfor(3);
				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),
						propVMs.getProperty("DocumentNumber"), propVMs.getProperty("ExpirationDate"),
						propVMs.getProperty("IssuingState"), propVMs.getProperty("IssuingCountry"));
				visitors.saveAndReturnBtn();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 10)
	public void validate_QuestionnaireAndNotesAndReviewer() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		ReviewPage review = new ReviewPage(driver, test);

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
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.click_Create();
				detail.enable_AllDayAcess();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToQuestionnaire();
				Wait.waitfor(5);
				questionnairre.click_saveBtn();
				questionnairre.validate_Questions();
				detail.forwardToNotes();
				notes.click_AddNoteBtn();
				notes.click_save();
				notes.validate_Notes();
				notes.add_notes(propVMs.getProperty("Notes"));
				detail.forwardToSubmit();
				review.visitorSubmSave();
				review.validate_VisitorSubmissionReview();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 11)
	public void validate_ReviewerAndChangeRequest() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		ReviewPage review = new ReviewPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		ChangeRequestPage changereq = new ChangeRequestPage(driver, test);

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
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.click_Create();
				detail.enable_AllDayAcess();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				visitors.addOrganisation(propVMs.getProperty("OrgName"), propVMs.getProperty("OrgType"),
						propVMs.getProperty("Address"), propVMs.getProperty("Address2"),
						propVMs.getProperty("Address3"), propVMs.getProperty("City"), propVMs.getProperty("Zip"),
						propVMs.getProperty("Country"), propVMs.getProperty("State"),
						propVMs.getProperty("CountryOfIncorporation"), propVMs.getProperty("UsAgency"),
						propVMs.getProperty("DLISCageCode"), propVMs.getProperty("DUNS_EIN"));

				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
						/*propVMs.getProperty(""),*/ propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));

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
				if (propVMs.getProperty("HostUserFirstName").length() > 0) {
					submit.add_HostReviewer(propVMs.getProperty("HostUserFirstName"));
				}
				if (propVMs.getProperty("TDFPUserFirstName").length() > 0) {
					submit.add_TDFPReviewer(propVMs.getProperty("TDFPUserFirstName"));

				}
				if (propVMs.getProperty("ExportUserFirstName").length() > 0) {
					submit.add_ExportControlReviewer(propVMs.getProperty("ExportUserFirstName"));
				}
				if (propVMs.getProperty("SecurityUserFirstName").length() > 0) {
					submit.add_SecurityReviewer(propVMs.getProperty("SecurityUserFirstName"));
				}
				submit.submitforreview();
				review.saveandfinalize();
				review.validate_SaveAndFinalize();
				Wait.waitfor(5);
				review.click_ApprovedDisapprovedBtn();
				review.validate_VisitorAcknowledgmnt();
				review.approverequest(propVMs.getProperty("OverallDecision"));
				review.saveandfinalize();
				detail.forwardToChangeRequestTab();
				changereq.addchangerequest();
				changereq.submitchange();
				changereq.validate_ChangeRequest(propVMs.getProperty("ReasonForChange"));
				changereq.submitchange();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 12)
	public void validate_PolicyDocument() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
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
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.type_Phone(propVMs.getProperty("PhoneNo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				detail.enable_AllDayAcess();
				String vid = visitorInfo.get_RequestID();
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				visitors.addOrganisation(propVMs.getProperty("OrgName"), propVMs.getProperty("OrgType"),
						propVMs.getProperty("Address"), propVMs.getProperty("Address2"),
						propVMs.getProperty("Address3"), propVMs.getProperty("City"), propVMs.getProperty("Zip"),
						propVMs.getProperty("Country"), propVMs.getProperty("State"),
						propVMs.getProperty("CountryOfIncorporation"), propVMs.getProperty("UsAgency"),
						propVMs.getProperty("DLISCageCode"), propVMs.getProperty("DUNS_EIN"));

				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
						/*propVMs.getProperty("Company"), */propVMs.getProperty("VisitorEmail"),
						propVMs.getProperty("PhoneNumber"));

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
				submit.submitforreview();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision(propVMs.getProperty("OverallDecision"), "Reason");
				Wait.waitfor(3);
				searchVR.moveTo_Features();
				
				searchVR.click_VisitorFrontDesk();
				visitorFD.click_AdvSearchBtn();
				visitorFD.searchVReqID(vid);
				visitorFD.clickSearch();
				visitorFD.clickCheckIN();
				
				
				
	//			frontDeskResult.withSelectDropDownCheckIn(propVMs.getProperty("Select1"));
				Wait.waitfor(3);
	//			frontDeskResult.validating_PolicyDocError(propVMs.getProperty("FirstName"),
	//					propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"), vid);
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
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
