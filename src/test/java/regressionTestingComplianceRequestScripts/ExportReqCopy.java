package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Feb 2024
 * Descriptions : Copy Export Request
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.ExportResultsExportRequestPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportReqCopy extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExportReqCopy", excel);
	}

	@Test(dataProvider = "getData")
	public void copyExportRequestForm(String Testcase, String RunMode, String RequestID) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage generalinfo = new ExportAddRequestorDetailsPage(driver, test);
		ExportResultsExportRequestPage result = new ExportResultsExportRequestPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);

				home.moveTo_ListScreening();
				home.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_ExportAuthReqlink();
				searchER.RequestID(RequestID);
				searchER.click_SearchBtn();
				Wait.waitfor(3);
				searchER.click_CopyIcon();
				Wait.waitfor(3);
				generalinfo.saveExportRequest();
				Wait.waitfor(3);
				String requestID = generalinfo.get_RequestID();
				home.returnToCRPage();
				Wait.waitfor(3);
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(3);
				searchER.click_ExportAuthReqlink();		
				searchER.RequestID(requestID);
				searchER.click_SearchBtn();
				result.titleIsDisplayed();
				result.requestIDIsDisplayed(requestID);
				Wait.waitfor(5);
				home.returnToCRPage();
			}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			home.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
}
