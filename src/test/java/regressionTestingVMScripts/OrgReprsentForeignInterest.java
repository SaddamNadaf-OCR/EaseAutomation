package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorsPage;

public class OrgReprsentForeignInterest extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void OrgForeignInterest(String Testcase, String RunMode, String CheckList, String SBU, String SelectSBU,
			String HostSBU, String MeetingLocationSBU, String VisitDateFrom, String VisitDateTo,
			String RequestorFirstName, String Email, String Phone, String EmployeeId, String LocalHost,
			String PrimaryHost, String AddHostUserFirstName, String HostName, String HostEmail,
			String LastCompliancedate, String Site, String BuildingName, String EntranceLobby, String RoomNoDescription,
			String ClassificationLevel, String VisitPurpose, String DescriptionOfVisit, String MeetingCategories,	
			String ChargeNumber,String OnLoanDepartment, String OrgName, String OrgType, String Address, String Address2, String Address3,
			String City, String Zip, String Country, String State, String CountryOfIncorporation, String USAgency,
			String DLISCageCode, String DUNS_EIN, String OrgRepresentingForeignInterest, String Title, String FirstName, String MiddleName, String LastName,
			String Company, String VisitorEmail, String PhoneNumber, String VAddress, String VAddress2,
			String VAddress3, String VCity, String VCountry, String VState, String VZip, String TypeOfPerson,
			String CountryofResidence, String VisitorCategory, String CountryofCitizenship,
			String OtherCountriesofCitizenship, String RepresentingForeignInterest, String DateofBirth,
			String PlaceofBirth, String CountryofBirth, String Gender, String IdentifyingDocuments,
			String DocumentNumber, String ExpirationDate, String IssuingState, String IssuingCountry,
			String EquipDescription, String EquipJustification, String DomesticOrForeign) throws Exception {

		// *********** Objects Creation ******************************
		
		
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		
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
					detail.select_chargenumber(ChargeNumber);
					detail.select_onloandepartment(OnLoanDepartment);
					visitors.addForOrganisation(OrgName, OrgType, VAddress, VAddress2, VAddress3, VCity, VZip, IssuingCountry, IssuingState, CountryOfIncorporation, USAgency, 
					DLISCageCode, DUNS_EIN, OrgRepresentingForeignInterest);
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
		return Utility.getData("OrgRepresentForeignInterest", excel);
	}
}