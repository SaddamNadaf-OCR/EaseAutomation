/* 
 * Module : VMS
 * Author  : Nancy
 * created date : April 2019
 * Descriptions : Creating Standard Request with Multiple Organizations and Visitors
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package vmsScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
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

public class StandardReqWithMultipleOrgandVisitors extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void standardrequestmultiple(String Testcase, String RunMode, String SBU, String SelectSBU, String HostSBU,
			String MeetingLocationSBU, String VisitDateFrom, String VisitDateTo, String RequestorFirstName,
			String Email, String Phone, String EmployeeId, String LocalHost, String PrimaryHost,
			String AddHostUserFirstName, String Site, String BuildingName, String EntranceLobby,
			String RoomNoDescription, String ClassificationLevel, String VisitPurpose, String DescriptionOfVisit,
			String MeetingCategories, String Program, String Segment, String ProductFamily, String ProductLine,
			String ChargeNumber, String OnLoanDepartment, String OrgName, String OrgType, String Address,
			String Address2, String Address3, String City, String Zip, String Country, String State,
			String CountryOfIncorporation, String USAgency, String DLISCageCode, String DUNS_EIN, String Title,
			String FirstName, String MiddleName, String LastName, String Company, String VisitorEmail,
			String PhoneNumber, String VAddress, String VAddress2, String VAddress3, String VCity, String VCountry,
			String VState, String VZip, String TypeOfPerson, String CountryofResidence, String VisitorCategory,
			String CountryofCitizenship, String OtherCountriesofCitizenship, String RepresentingForeignInterest,
			String DateofBirth, String PlaceofBirth, String CountryofBirth, String Gender, String IdentifyingDocuments,
			String DocumentNumber, String ExpirationDate, String IssuingState, String IssuingCountry,
			String EquipDescription, String EquipJustification, String Questionnairre, String DocumentType,
			String DocumentDescription, String DocKeywords, String UploadFile, String SourceSystemDocNumber,
			String Notes, String HostUserFirstName, String TDFPUserFirstName, String ExportUserFirstName,
			String SecurityUserFirstName, String WithSelectedBadgeType, String OverallDecision,
			String ReasonForDisapprovalOrRoR, String ChangeRequest, String DateFrom, String DateTo,
			String ReasonForChange, String Select1, String Select2) throws Exception {

		// ********** Objects Creation *********************

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

		// ************ Test steps execution ***************************

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
					create.check_LocalHost(LocalHost);
					create.check_PrimaryHost(PrimaryHost);
					create.click_Create();
					detail.enable_AllDayAcess();
					String vid = visitorInfo.get_RequestID();
					detail.select_247();
					detail.select_WeekendAccess();
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
					ArrayList<String> orgName = GenericMethods.stringtoken(OrgName);
					ArrayList<String> orgType = GenericMethods.stringtoken(OrgType);
					ArrayList<String> address = GenericMethods.stringtoken(Address);
					ArrayList<String> address2 = GenericMethods.stringtoken(Address2);
					ArrayList<String> address3 = GenericMethods.stringtoken(Address3);
					ArrayList<String> city = GenericMethods.stringtoken(City);
					ArrayList<String> zip = GenericMethods.stringtoken(Zip);
					ArrayList<String> state = GenericMethods.stringtoken(State);
					ArrayList<String> country = GenericMethods.stringtoken(Country);
					ArrayList<String> countryOfIncorporation = GenericMethods.stringtoken(CountryOfIncorporation);
					ArrayList<String> usAgency = GenericMethods.stringtoken(USAgency);
					ArrayList<String> dLISCageCode = GenericMethods.stringtoken(DLISCageCode);
					ArrayList<String> dUNS_EIN = GenericMethods.stringtoken(DUNS_EIN);
					for (int i = 0; i < orgName.size(); i++) {
						visitors.addOrganisation(orgName.get(i), orgType.get(i), address.get(i), address2.get(i),
								address3.get(i), city.get(i), zip.get(i), country.get(i), state.get(i),
								countryOfIncorporation.get(i), usAgency.get(i), dLISCageCode.get(i), dUNS_EIN.get(i));
					}
					ArrayList<String> title = GenericMethods.stringtoken(Title);
					ArrayList<String> fname = GenericMethods.stringtoken(FirstName);
					// ArrayList<String> mname = GenericMethods.stringtoken(MiddleName);
					ArrayList<String> lname = GenericMethods.stringtoken(LastName);
					ArrayList<String> company = GenericMethods.stringtoken(Company);
					// ArrayList<String> vemail = GenericMethods.stringtoken(VisitorEmail);
					// ArrayList<String> phoneno= GenericMethods.stringtoken(PhoneNumber);
					ArrayList<String> vaddress = GenericMethods.stringtoken(VAddress);
					ArrayList<String> vaddress2 = GenericMethods.stringtoken(VAddress2);
					ArrayList<String> vaddress3 = GenericMethods.stringtoken(VAddress3);
					ArrayList<String> typeofperson = GenericMethods.stringtoken(TypeOfPerson);
					ArrayList<String> visitorcategory = GenericMethods.stringtoken(VisitorCategory);
					ArrayList<String> coc = GenericMethods.stringtoken(CountryofCitizenship);
					ArrayList<String> dateofbirth = GenericMethods.stringtoken(DateofBirth);
					ArrayList<String> placeofbirth = GenericMethods.stringtoken(PlaceofBirth);
					ArrayList<String> countryofbirth = GenericMethods.stringtoken(CountryofBirth);
					ArrayList<String> gender = GenericMethods.stringtoken(Gender);
					ArrayList<String> identifyingdocuments = GenericMethods.stringtoken(IdentifyingDocuments);
					ArrayList<String> documentnumber = GenericMethods.stringtoken(DocumentNumber);
					for (int i = 0; i < title.size(); i++) {
						visitors.add_Individual(title.get(i), fname.get(i), MiddleName, lname.get(i), 
								VisitorEmail, PhoneNumber);
						visitors.add_AddressDetails(vaddress.get(i), vaddress2.get(i), vaddress3.get(i), VCity,
								VCountry, VState, VZip);
						visitors.add_Citizenship(typeofperson.get(i), CountryofResidence, visitorcategory.get(i),
								coc.get(i), RepresentingForeignInterest, OtherCountriesofCitizenship);
						visitors.add_AdditionalDetails(dateofbirth.get(i), placeofbirth.get(i), countryofbirth.get(i),
								gender.get(i));
						visitors.add_IdentifyingDocuments(identifyingdocuments.get(i), documentnumber.get(i),
								ExpirationDate, IssuingState, IssuingCountry);
						visitors.add_AddEquipment(EquipDescription, EquipJustification);
						visitors.saveAndReturnBtn();
					}
					Wait.waitfor(3);
					visitors.click_DplStatus();
					visitors.movetonextpage();
					Wait.waitfor(3);
					questionnairre.add_questions(Questionnairre);
					questionnairre.click_saveBtn();
					questionnairre.movetonextpage();
					document.add_Document(DocumentType, DocumentDescription, UploadFile, DocKeywords,
							SourceSystemDocNumber);
					// document.Forword();

					notes.click_AddNoteBtn();
					notes.add_notes(Notes);
					notes.movetonextpage();
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
					submit.submitforreview();
					reviewer.click_SelectAllBtn();
					
					reviewer.click_ApproveBtn();
					reviewer.overDecision(OverallDecision, ReasonForDisapprovalOrRoR);
					Wait.waitfor(3);
					String status = visitorInfo.get_RequestStatus();
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
							reviewer.overDecision(OverallDecision, ReasonForChange);
							Wait.waitfor(3);
						} else if (ChangeRequest.contains("A")) {
							detail.forwardToSubmit();
							submit.submitforreview();
							reviewer.overDecision(OverallDecision, ReasonForChange);
							Wait.waitfor(3);
						} else if (ChangeRequest.contains("O")) {
							detail.forwardToSubmit();
							submit.submitforreview();
							reviewer.overDecision(OverallDecision, ReasonForChange);
							Wait.waitfor(3);
						}
					}
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
		return Utility.getData("StandardReqwithMultiple", excel);
	}
}
