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
import vmsClasses.CheckInVerifyDetailsPage;
import vmsClasses.HomePage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;

public class VisitorcheckinbeforeRequestDate extends SeleniumTestBase {

	@Test
	public void validatePolicyDoc() throws Exception {

		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		CheckInVerifyDetailsPage Checkinverify = new CheckInVerifyDetailsPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);
		
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
				visitorInfo.select_FromDate(propVMs.getProperty("RapidFromDate"));
				visitorInfo.select_ToDate(propVMs.getProperty("RapidToDate"));
				visitorInfo.select_Site(propVMs.getProperty("RRSite"));
				visitorInfo.type_BuildingName(propVMs.getProperty("RRBuildingName"));
				visitorInfo.click_AddHost();
				visitorInfo.type_HostName(propVMs.getProperty("RRHostName"));
				visitorInfo.type_HostEmail(propVMs.getProperty("RREmailAddress"));
				visitorInfo.click_HostAdd();
				String vid = visitorInfo.get_RequestID();
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
				addVisitor.select_Person(propVMs.getProperty("RRTypeofPerson"));
				addVisitor.select_Category(propVMs.getProperty("RRCategory"));
				addVisitor.select_Citizenship(propVMs.getProperty("RRContryOfcitizenShip"));
				addVisitor.type_IdentifyingDocs("");
				addVisitor.click_SaveAndReturn();
				Wait.waitfor(3);
				visitorInfo.click_DplStatus();
				Wait.waitfor(2);
				visitorInfo.get_RequestStatusFinal();
				Wait.waitfor(2);
				searchVR.moveTo_Features();
				searchVR.click_VisitorFrontDesk();
				visitorFD.click_AdvSearchBtn();
				visitorFD.searchVReqID(vid);
				visitorFD.clickSearch();
				visitorFD.clickCheckIN();
				Checkinverify.Disable_CheckIn();
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
}
