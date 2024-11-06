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
import vmsClasses.HomePage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRegReportPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorInformationPage;

public class VisitorRegistrationReport extends SeleniumTestBase {

	@Test

	public void repidRegtn() throws Exception {
		
		// ********* Objects Creation ***********************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRegReportPage SVRegReport = new SearchVisitorRegReportPage(driver, test);

		// *************** Test steps execution ***************************

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
				visitorInfo.click_AddHost();
				visitorInfo.type_HostName(propVMs.getProperty("RRHostName"));
				visitorInfo.type_HostEmail(propVMs.getProperty("RREmailAddress"));
				visitorInfo.click_HostAdd();
				Wait.waitfor(3);
				visitorInfo.get_RequestStatus();
				visitorInfo.get_RequestID();
				String vid = visitorInfo.get_RequestID();
				visitorInfo.click_AddOrganization();
				addOrganization.type_OrgName(propVMs.getProperty("RROrgName"));
				addOrganization.select_OrgType(propVMs.getProperty("RROrgType"));
				addOrganization.type_Orgcity(propVMs.getProperty("RROrgcity"));
				addOrganization.type_OrgZip(propVMs.getProperty("RROrgZip"));
				addOrganization.type_OrgCountry(propVMs.getProperty("RROrgCountry"));
				addOrganization.type_OrgState(propVMs.getProperty("RROrgState"));
				addOrganization.click_SaveAndReturn();
				Wait.waitfor(3);
				visitorInfo.click_AddVisitor();
				addVisitor.type_FirstName(propVMs.getProperty("RRFirstName"));
				addVisitor.type_LastName(propVMs.getProperty("RRLastName"));
				addVisitor.type_VisitorEmail(propVMs.getProperty("RREmailAddress"));
				addVisitor.select_Person(propVMs.getProperty("RRTypeofPerson"));
				addVisitor.select_Category(propVMs.getProperty("RRCategory"));
				addVisitor.select_Citizenship(propVMs.getProperty("RRContryOfcitizenShip"));
				addVisitor.type_IdentifyingDocs("");
				addVisitor.click_SaveAndReturn();
				Wait.waitfor(3);
				visitorInfo.click_DplStatus();
				visitorInfo.get_RequestStatus();
				visitorInfo.click_CheckIn();
				Wait.waitfor(3);
				searchVR.moveTo_Reports();
				searchVR.click_ReportsVReg();
				SVRegReport.ReportsVID(vid);
				SVRegReport.click_SearchReport();

				String ReportFname = SVRegReport.getFirstName(propVMs.getProperty("RRFirstName"));

				if (ReportFname.equalsIgnoreCase(propVMs.getProperty("RRFirstName"))) {
					test.log(LogStatus.PASS, "Matching the report first name : " + ReportFname);

				} else {
					test.log(LogStatus.FAIL, "Not Matching the report first name : " + ReportFname);
					testFail();
					Assert.assertTrue(false);
				}

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
