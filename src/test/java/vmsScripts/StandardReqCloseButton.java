/* 
 * Module : VMS
 * Author  : Nancy
 * created date : April 2019
 * Descriptions : Creating Standard Request and then closing it
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package vmsScripts;
//above test scenario is use to approve request which is pending for review.

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.ReviewPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorRequestPage;

public class StandardReqCloseButton extends SeleniumTestBase {

	@Test(dataProvider = "getData")
	public void standardrequestclosebutton(String Testcase, String RunMode, String SBUCode, String Status,
			String WithSelectedBadgeType, String OverallDecision) throws Exception {
		// ************ Objects Creation **************************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		ReviewPage review = new ReviewPage(driver, test);
		VisitorRequestPage visitorreq = new VisitorRequestPage(driver, test);

		// *********** Test steps execution ***************************

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Features();
					searchVR.click_VisitorRequests();
					searchVR.click_VisitorRequest();
					searchVR.searchthroughstatus(SBUCode, Status);
					detail.forwardToReviewTab();
					review.ApproveorDissapproveVisitor(WithSelectedBadgeType);
					review.approverequest(OverallDecision);
					review.saveandfinalize();
					Wait.waitfor(3);
					//review.cancel();
					Wait.waitfor(3);
					String title = visitorreq.getVRTitle();
					if (title.contains("Visitor Request")) {
						test.log(LogStatus.PASS, "Expected title : Visitor Request");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Expected title : Visitor Request");
					}
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

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("StandardReqCloseButtonIssue", excel);
	}
}
