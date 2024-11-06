/* 
 * Module : VMS
 * Author  : Venkat
 * created date : May 2019
 * Descriptions : To verify Send Invite button is disable at the time of Approved,Expired,Closed,Disapproved..
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;

public class StandardReqSendInviteDiasble extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("StandardReqStSendinviteDiasable", excel);
	}

	@Test(dataProvider = "getData")

	public void StandardReqStatus(String Testcase, String RunMode, String SBU, String SBUCode, String Status)
			throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);

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
					searchVR.searchthroughstatus(SBUCode, Status);
					Wait.waitfor(3);
					
					detail.click_SendInviteDisbled();
					Wait.waitfor(3);
					homePage.returnPage();
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
}
