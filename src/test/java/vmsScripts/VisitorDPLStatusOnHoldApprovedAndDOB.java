package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorsPage;

public class VisitorDPLStatusOnHoldApprovedAndDOB extends SeleniumTestBase {

	@Test(priority = 7)
	public void validateVisitorDPLStatusAndDOB() throws Exception {
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
				create.type_Phone(propVMs.getProperty("RequestorPhone"));
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				detail.enable_AllDayAcess();
				Wait.waitfor(3);
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				Wait.waitfor(3);
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.click_Savebtn();
				detail.forwardToVisitors();
				visitors.click_AddOrganization();
				// visitors.validate_addOrganizationError();
				visitors.validate_addOrganizationWarning(propVMs.getProperty("OnHoldOrgName"),
						propVMs.getProperty("OrgType"), propVMs.getProperty("City"), propVMs.getProperty("Country"),
						propVMs.getProperty("CountryOfIncorporation"), propVMs.getProperty("Zip"),
						propVMs.getProperty("State"));
				// visitors.click_AddVisitor();
				visitors.validate_addEditIndividualError();
				visitors.validate_addEditIndividualWarning(propVMs.getProperty("Title"),
						propVMs.getProperty("OnHoldFName"), propVMs.getProperty("MiddleName"),
						propVMs.getProperty("OnHoldLastName"), propVMs.getProperty("Company"),
						propVMs.getProperty("VisitorEmail"), propVMs.getProperty("PhoneNumber"),
						propVMs.getProperty("VCountry"), propVMs.getProperty("TypeOfPerson"),
						propVMs.getProperty("CountryofCitizenship"), propVMs.getProperty("InValidDOB"),
						propVMs.getProperty("PlaceofBirth"));
				Wait.waitfor(3);
				visitors.validate_InvalidDOB(propVMs.getProperty("InValidDOB"), propVMs.getProperty("DateofBirth"));
				Wait.waitfor(3);
				// visitors.validate_addEditIndividualWarning(propVMs.getProperty("DateofBirth"));
				visitors.validate_IdentityDocWarning(propVMs.getProperty("IdentifyingDocuments"));
				Wait.waitfor(3);
				visitors.add_IdentifyingDocuments(propVMs.getProperty("IdentifyingDocuments"),
						propVMs.getProperty("DocumentNumber"), propVMs.getProperty("ExpirationDate"),
						propVMs.getProperty("IssuingState"), propVMs.getProperty("IssuingCountry"));
				visitors.saveAndReturnBtn();
				Wait.waitfor(3);
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
}
