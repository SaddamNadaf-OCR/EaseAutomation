/* 
 * Module : VMS
 * Author  : Nancy
 * created date : April 2019
 * Descriptions : Copying Standard Request
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */
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
import vmsClasses.VisitorRequestPage;

public class StandardReqCopy extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void standardrequestcopy(String Testcase, String RunMode, String SBU, String SBUCode, String HostSBU,
			String MeetingLocationSBU, String VisitDateFrom, String VisitDateTo, String Phone) throws Exception {
		// *********** Objects Creation ***************************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorRequestPage visitorreq = new VisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);

		// *********** Test steps execution ***************************

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
					searchVR.searchvisitorrequest(SBUCode);
					Wait.waitfor(3);
					visitorreq.copyrequest();
					create.select_HostSbu(HostSBU);
					create.select_MeetingLocationSBU(MeetingLocationSBU);
					create.select_VisitDateFrom(VisitDateFrom);
					create.select_VisitDateTo(VisitDateTo);
					create.type_Phone(Phone);
					create.click_Create();
					Wait.waitfor(3);
					Boolean result = detail.check_sitegrid();
					if (result.equals(true)) {
						test.log(LogStatus.PASS, "Site result grid is enable");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Site result grid is Disable");
					}
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
		return Utility.getData("StandardReqCopy", excel);
	}
}
