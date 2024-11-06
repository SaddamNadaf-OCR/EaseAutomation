package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.LoginPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorManagementPage;

public class PortalUpdatedByIssue29676 extends SeleniumTestBase {

	@Test
	public void standardrequest() {
		
		LoginPage login = new LoginPage(driver, test);
		VisitorManagementPage visitorMagment = new VisitorManagementPage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.clickLogOut();
				login.click_CompliancePortal();
				visitorMagment.click_RapidVisitorRequest();
				visitorInfo.select_Site(propVMs.getProperty("RRSite"));
				visitorInfo.type_BuildingName(propVMs.getProperty("RRBuildingName"));
				visitorInfo.Select_HostAdd(propVMs.getProperty("RRVisitHost"));
				visitorInfo.click_Save();
				visitorInfo.select_Site(propVMs.getProperty("RRSite1"));
				visitorInfo.type_BuildingName(propVMs.getProperty("RRBuildingName"));
				visitorInfo.click_Save();
				Wait.waitfor(4);
				visitorInfo.validateCreatedByAndUpdatedBy();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
