package regressionTestingLicensePermitScript;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import lpAppBelgiumClasses.CreateNewAuthorizationPage;
import lpAppBelgiumClasses.HomeLpPage;
import lpAppBelgiumClasses.SearchAuthorizationsPage;
import lpAppBelgiumClasses.SearchAuthorizationsResultsPage;
import utilities.Utility;
import utilities.Wait;

public class LpBelgiumAddFromTemplate extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LpBelgiumAddFromTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void creatingTransation(String Testcase, String RunMode, String SBU,
			String TemplateName,String HDstatusReviewer, String ReviewerUserFirstName,
			String HDstatusApprovedForSub, String HDstatusAgency, String HDstatusAgencyApproved,
			String AgencyIssueDate, String AgencyExpiryDate) throws Exception {

		HomeLpPage 								 homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage 			 searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage 			 createAuth = new CreateNewAuthorizationPage(driver, test);			
		SearchAuthorizationsResultsPage searchAuthResults = new SearchAuthorizationsResultsPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homelp.moveTo_SBUSelection(SBU);
					searchAuth.addfromTemplate(TemplateName);
					String refId = createAuth.typereferenceid();
					createAuth.click_Save();
					createAuth.select_status(HDstatusReviewer);
					createAuth.click_reviewerlink(ReviewerUserFirstName);				
					createAuth.click_Save();
					createAuth.select_status(HDstatusApprovedForSub);
					createAuth.checkCircle();
					createAuth.click_Save();
					createAuth.select_status(HDstatusAgency);
					createAuth.click_Save();
					createAuth.select_status(HDstatusAgencyApproved);
					createAuth.click_Save();
					createAuth.agencyAuthoNo("", AgencyIssueDate, AgencyExpiryDate);
					createAuth.click_Save();
					Wait.waitfor(5);
					homelp.moveTo_SBUSelection(SBU);
					searchAuth.referenceID(refId);
					searchAuth.click_SearchBtn();
					searchAuthResults.displayOfRefID(refId);	
					Wait.waitfor(3);
					homelp.returnHomepageLP();
					Wait.waitfor(3);	
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
			homelp.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}   
}
