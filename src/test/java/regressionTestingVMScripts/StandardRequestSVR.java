/* 
 * Module : VMs
 * Author  : Maheswara
 * created date : OCT 2018
 * Descriptions : Checking Standard Request Search Results in Multiple ways.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorRequestPage;

public class StandardRequestSVR extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("StandardsearchVReq", excel);
	}

	@Test(dataProvider = "getData")
	public void searchVisitorRequest(String Testcase, String RunMode, String SBU, String BusinessUnit, String SBUCount,
			String Site, String VisitorFName, String VisitorLName, String Status, String VisitorFor, String Org,
			String VFromDate, String VToDate, String ReqFromDate, String ReqToDate, String ReviewFromDate,
			String ReviewToDate, String TitleofPage) throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorRequestPage VRLog = new VisitorRequestPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		// ******************************************** Test steps execution
		// ***************************
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
					searchVR.searchVisitDetails(BusinessUnit, SBUCount, Site, VisitorFName, VisitorLName, Status, VisitorFor,
							Org, VFromDate, VToDate, ReqFromDate, ReqToDate, ReviewFromDate, ReviewToDate);
					String Actual = VRLog.getVRTitle();
					if (Actual.equals(TitleofPage)) {
						test.log(LogStatus.PASS, "Expected Page : " + TitleofPage);
						softAssertion.assertTrue(true);
					} else {
						test.log(LogStatus.FAIL, "Expected Page : " + TitleofPage);
						testFail();
						softAssertion.assertTrue(false);
					}
					softAssertion.assertAll();
					Wait.waitfor(3);
					homePage.returnPage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
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
