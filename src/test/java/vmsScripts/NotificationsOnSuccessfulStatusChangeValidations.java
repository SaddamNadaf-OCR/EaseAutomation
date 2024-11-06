package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.AddOrEditIndividualPage;
import vmsClasses.AddOrEditOrganizationPage;
import vmsClasses.ChangeRequestPage;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.DocumentPage;
import vmsClasses.HomePage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewerPage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;

public class NotificationsOnSuccessfulStatusChangeValidations extends SeleniumTestBase {

	@Test(priority = 13)
	public void validateRapidReqNotificationsOnSuccessful() throws Exception {

		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		HomePage homePage = new HomePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_RapidRegistaration();
				rapid.click_AddNewVisitorRequest();
				visitorInfo.select_Site(propVMs.getProperty("RRSite"));
				visitorInfo.type_BuildingName(propVMs.getProperty("RRBuildingName"));
				visitorInfo.clickAddSite();
				String RequestID = visitorInfo.get_RequestID();
				Wait.waitfor(4);
				visitorInfo.alertReqIDCreated(RequestID);
				visitorInfo.click_AddHost();
				visitorInfo.type_HostName(propVMs.getProperty("RRHostName"));
				visitorInfo.type_HostEmail(propVMs.getProperty("RREmailAddress"));
				visitorInfo.click_HostAdd();
				visitorInfo.click_AddOrganization();
				addOrganization.type_OrgName(propVMs.getProperty("RROrgName"));
				addOrganization.select_OrgType(propVMs.getProperty("RROrgType"));
				addOrganization.type_Orgcity(propVMs.getProperty("RROrgcity"));
				addOrganization.type_OrgZip(propVMs.getProperty("RROrgZip"));
				addOrganization.type_OrgCountry(propVMs.getProperty("RROrgCountry"));
				addOrganization.type_OrgState(propVMs.getProperty("RROrgState"));
				addOrganization.click_SaveAndReturn();
				visitorInfo.click_AddVisitor();
				addVisitor.type_FirstName(propVMs.getProperty("RRFirstName"));
				addVisitor.type_MiddleName(propVMs.getProperty("RRMiddleName"));
				addVisitor.type_LastName(propVMs.getProperty("RRLastName"));
				addVisitor.type_VisitorEmail(propVMs.getProperty("RRVisitorEmail"));
				Wait.waitfor(3);
				addVisitor.select_Person(propVMs.getProperty("RRTypeofPerson"));
				addVisitor.select_Category(propVMs.getProperty("RRCategory"));
				addVisitor.select_Citizenship(propVMs.getProperty("RRContryOfcitizenShip"));
				addVisitor.type_IdentifyingDocs("");
				addVisitor.click_SaveAndReturn();
				Wait.waitfor(3);
				visitorInfo.click_DplStatus();
				Wait.waitfor(2);
				visitorInfo.get_RequestStatusFinal();
				visitorInfo.checkNotifyWLSReview();
				Wait.waitfor(4);
				homePage.returnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 14)
	public void validateStandardReqNotificationsOnSuccessful() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
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
				create.click_Create();
				String RequestID = visitorInfo.get_RequestID();
				Wait.waitfor(4);
				detail.alertReqIDCreated(RequestID);
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
						 propVMs.getProperty("VisitorEmail"),
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
				submit.submitforreviewer();
				submit.alertSubmitForReview();
				detail.forwardToReviewTab();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision(propVMs.getProperty("OverallDecision"), "Reason");
				Wait.waitfor(3);
				detail.forwardToChangeRequestTab();
				Wait.waitfor(3);
				changereq.addchangerequest();
				Wait.waitfor(3);
				changereq.selectchangerequest("D", "Today", propVMs.getProperty("ChangeDateTo"), "ReasonForChange");
				Wait.waitfor(3);
				changereq.submitchange();
				changereq.alertSubmitForChange(RequestID);
				detail.forwardToSubmit();
				submit.submitforreview();
				reviewer.overDecision("Disapproved", "Reason");
				Wait.waitfor(3);
				reviewer.alertDisApprovedReq();
				homePage.returnPage();
				Wait.waitfor(4);
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
	
	@Test(priority = 15)
	public void validateStandardReqNotificationsOnReturnForRework() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		
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
				create.click_Create();
				Wait.waitfor(4);
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
						 propVMs.getProperty("VisitorEmail"),
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
				submit.submitforreviewer();
				submit.alertSubmitForReview();
				detail.forwardToReviewTab();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision("Returned For Rework", "Reason");
				Wait.waitfor(3);
				reviewer.alertReturnForReworkReq();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(4);
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

	
	@Test(priority = 16)
	public void validateStandardReqNotificationsForMultipleReview() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorRequestNotesPage notes = new VisitorRequestNotesPage(driver, test);
		DocumentPage document = new DocumentPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection("TEST");
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu("DEMO");
				create.select_HostSbu("DEMOSBU");
				create.select_MeetingLocationSBU("DEMOSBU");
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				Wait.waitfor(4);
				detail.enable_AllDayAcess();
				detail.add_Site("AES TEST Site", propVMs.getProperty("BuildingName"),
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
						propVMs.getProperty("CountryOfIncorporation"), "Test",
						propVMs.getProperty("DLISCageCode"), propVMs.getProperty("DUNS_EIN"));
				visitors.add_Individual(propVMs.getProperty("Title"), propVMs.getProperty("FirstName"),
						propVMs.getProperty("MiddleName"), propVMs.getProperty("LastName"),
			             propVMs.getProperty("VisitorEmail"),
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

				visitors.add_IdentifyingDocuments("Passport",
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
				submit.submitforreviewer();
				submit.alertSubmitForReview();
				detail.forwardToReviewTab();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision("Returned For Rework", "Reason");
				Wait.waitfor(3);
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(4);
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
