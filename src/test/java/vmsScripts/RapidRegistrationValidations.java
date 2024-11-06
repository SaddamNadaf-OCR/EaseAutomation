/* 
 * Module : VMs
 * Author  : Maheswara
 * created date : OCT 2018
 * Descriptions : Validations in Rapid Registration.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

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
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;

public class RapidRegistrationValidations extends SeleniumTestBase {

	@Test(priority = 1)
	public void validateVisitorInfo() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);

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
				visitorInfo.validate_AllDaysAccess();
				visitorInfo.select_Site("");
				visitorInfo.type_BuildingName("");
				visitorInfo.click_Save();
				visitorInfo.validations_AddHostBtn();
				visitorInfo.click_AddOrganization();
				visitorInfo.validations_AddHostBtn();
				visitorInfo.click_AddVisitor();
				visitorInfo.validations_AddHostBtn();
				Wait.waitfor(3);
				visitorInfo.click_Save();
				visitorInfo.validating_SaveBtn();
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

	@Test(priority = 2)
	public void validateAddHost() throws Exception {

		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
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
				visitorInfo.click_AddHost();
				visitorInfo.type_HostName("");
				visitorInfo.type_HostEmail("");
				visitorInfo.click_HostAdd();
				visitorInfo.validating_AddHostSave();
				visitorInfo.type_HostName(propVMs.getProperty("RRHostName"));
				visitorInfo.type_HostEmail(propVMs.getProperty("RRInvalidEmailAddress"));
				visitorInfo.click_HostAdd();
				Wait.waitfor(3);
				visitorInfo.validating_Email();
				visitorInfo.click_AddOrganization();
				visitorInfo.validating_SaveAndReturnBtn();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(3);
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

	@Test(priority = 3)
	public void validateAddOrginations() throws Exception {

		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
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
				visitorInfo.click_AddHost();
				visitorInfo.type_HostName(propVMs.getProperty("RRHostName"));
				visitorInfo.type_HostEmail(propVMs.getProperty("RREmailAddress"));
				visitorInfo.click_HostAdd();
				visitorInfo.click_AddOrganization();
				addOrganization.click_Save();
				addOrganization.validate_AddOrgSaveBtn();
				addOrganization.click_SaveAndReturn();
				addOrganization.validate_AddOrgSaveAndReturnBtn();
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

	@Test(priority = 4)
	public void validateAddVisitor() throws Exception {

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
				addVisitor.click_SaveAndReturn();
				addVisitor.validate_AddVisitorSaveAndReturnBtn();
				Wait.waitfor(3);
				// addVisitor.click_save();
				// addVisitor.validate_AddVisitorSaveBtn();
				addVisitor.type_FirstName(propVMs.getProperty("RRFirstName"));
				addVisitor.type_LastName(propVMs.getProperty("RRLastName"));
				addVisitor.type_VisitorEmail(propVMs.getProperty("RREmailAddress"));
				addVisitor.select_Person(propVMs.getProperty("RRTypeofPerson"));
				addVisitor.select_Category(propVMs.getProperty("RRCategory"));
				addVisitor.select_Citizenship(propVMs.getProperty("RRContryOfcitizenShip"));
				addVisitor.click_BackBtn();
				visitorInfo.validating_AddHostAndAddOrgCreated();
				homePage.returnPage();
				Wait.waitfor(3);
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

	@Test(priority = 4)
	public void validatePolicyDoc() throws Exception {

		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		AddOrEditOrganizationPage addOrganization = new AddOrEditOrganizationPage(driver, test);
		AddOrEditIndividualPage addVisitor = new AddOrEditIndividualPage(driver, test);
		HomePage homePage = new HomePage(driver, test);
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
				addVisitor.type_VisitorEmail(propVMs.getProperty("RREmailAddress"));
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
				// frontDeskResult.withSelectDropDownCheckIn(propVMs.getProperty("Select1"));
				// frontDeskResult.validating_PolicyDocError(propVMs.getProperty("RRFirstName"),propVMs.getProperty("RRMiddleName"),
				// propVMs.getProperty("RRLastName"), vid);
				Wait.waitfor(3);
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
