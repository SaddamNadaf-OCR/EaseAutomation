package regressionTestingComplianceRequestScripts;

import org.testng.Assert;
//Added By Saddam
//On 25/03/2024
//Import Request Copy Page
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ImportRequestPage;
import crsClasses.ImportResultsImportRequestPage;
import crsClasses.ImportSearchImportRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ImportReqCopy extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ImportReqCopy", excel);
	}

	@Test(dataProvider = "getData")
	public void copyAgreementRequestForm(String Testcase, String RunMode, String SbuID, String RequestID) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		ImportRequestPage generalinfo = new ImportRequestPage(driver, test);
		ImportResultsImportRequestPage result = new ImportResultsImportRequestPage(driver, test);
		ImportSearchImportRequestPage searchIR = new ImportSearchImportRequestPage(driver, test);
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
				searchER.click_ImportReq();
				searchIR.selectSbuID(SbuID, RequestID);
				searchIR.click_SearchBtn();
				Wait.waitfor(3);
				searchER.click_CopyIcon();
				Wait.waitfor(3);
				generalinfo.click_Save();
				Wait.waitfor(3);
				String requestID = generalinfo.get_RequestID();
				home.returnToCRPage();
				Wait.waitfor(3);
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(3);
				searchER.click_ImportReq();	
				searchIR.selectSbuID(SbuID, requestID);
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
