package regressionTestingVMScripts;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorsPage;
import initializer.SeleniumTestBase;

public class VerifyCombinationEscortNoEscortRequired extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	
	public void verifyCombinationEscortNoEscortRequired(String Testcase, String RunMode, String SBU, String SelectSBU, String HostSBU,
			String MeetingLocationSBU, String VisitDateFrom, String VisitDateTo, String RequestorFirstName,
			String Email, String Phone, String EmployeeId, String LocalHost, String PrimaryHost,
			String AddHostUserFirstName, String Site, String BuildingName, String EntranceLobby,
			String RoomNoDescription, String ClassificationLevel, String VisitPurpose, String DescriptionOfVisit,
			String MeetingCategories, String ChargeNumber, String OnLoanDepartment, String Title,
			String FirstName, String MiddleName, String LastName, String Company, String VisitorEmail,
			String PhoneNumber, String VAddress, String VAddress2, String VAddress3, String VCity, String VCountry,
			String VState, String VZip, String TypeOfPerson, String CountryofResidence, String VisitorCategory,
			String CountryofCitizenship, String Escort, String OtherCountriesofCitizenship, String RepresentingForeignInterest,
			String DateofBirth, String PlaceofBirth, String CountryofBirth, String Gender, String IdentifyingDocuments,
			String DocumentNumber, String ExpirationDate, String IssuingState, String IssuingCountry,
			String EquipDescription, String EquipJustification) throws Exception {

		// ********** Objects Creation *********************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		
	
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
					//create.select_RequestorName(RequestorFirstName);
					create.type_Email(Email);
					create.type_Phone(Phone);
					create.type_EmployeeId(EmployeeId);
					create.check_LocalHost(LocalHost);
					create.check_PrimaryHost(PrimaryHost);
					create.click_Create();
					detail.enable_AllDayAcess();
					
					detail.select_247();
					detail.select_WeekendAccess();
					detail.add_Site(Site, BuildingName, EntranceLobby, RoomNoDescription);
					detail.select_classificationlevel(ClassificationLevel);
					detail.select_visitpurpose(VisitPurpose);
					detail.select_descriptionofvisit(DescriptionOfVisit);
					detail.select_meetingcategories(MeetingCategories);
					detail.select_chargenumber(ChargeNumber);
					detail.select_onloandepartment(OnLoanDepartment);
					
					Wait.waitfor(3);
					visitors.add_Individual(Title, FirstName, MiddleName, LastName, VisitorEmail, PhoneNumber);
					visitors.select_OrgzAssociated( Company);
					visitors.add_AddressDetails(VAddress, VAddress2, VAddress3, VCity, VCountry, VState, VZip);
					visitors.add_Citizenship(TypeOfPerson, CountryofResidence,VisitorCategory,  CountryofCitizenship, RepresentingForeignInterest, OtherCountriesofCitizenship);
					Wait.waitfor(2);
					
					
					visitors.add_AdditionalDetails(DateofBirth, PlaceofBirth, CountryofBirth, Gender);
					Wait.waitfor(2);
					
					
					visitors.add_IdentifyingDocuments(IdentifyingDocuments, DocumentNumber, ExpirationDate, IssuingState, IssuingCountry);
					visitors.add_AddEquipment(EquipDescription, EquipJustification);
					
					visitors.saveAndReturnBtn();				
					Wait.waitfor(3);
					
					visitors.add_Individual(Title, FirstName, MiddleName, LastName, VisitorEmail, PhoneNumber);
					visitors.select_OrgzAssociated( Company);
					visitors.add_AddressDetails(VAddress, VAddress2, VAddress3, VCity, VCountry, VState, VZip);
					visitors.add_Citizenship(TypeOfPerson, CountryofResidence, VisitorCategory, CountryofCitizenship, RepresentingForeignInterest, OtherCountriesofCitizenship);
					Wait.waitfor(2);
					
					visitors.add_AdditionalDetails(DateofBirth, PlaceofBirth, CountryofBirth, Gender);
					visitors.add_IdentifyingDocuments(IdentifyingDocuments, DocumentNumber, ExpirationDate, IssuingState, IssuingCountry);
					visitors.add_AddEquipment(EquipDescription, EquipJustification);
					Wait.waitfor(2);
					visitors.Select_EscortRequired();
					Wait.waitfor(2);
					visitors.Click_SaveButton();
					Wait.waitfor(2);
					visitors.validating_EscortRequired();
					Wait.waitfor(2);
					homePage.returnPage();
					
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
		return Utility.getData("CombinationEscortNoEscort", excel);
	}
}
