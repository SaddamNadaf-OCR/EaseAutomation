package regressionTestingComplianceRequestScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.FTTravelDetailsPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelPage;
import crsClasses.SearchExportRequestPage;
import crsClasses.SearchForeignTravelPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FTRCopy extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FTRCopy", excel);
	}

	@Test(dataProvider = "getData")
	public void copyFTRForm(String Testcase, String RunMode, String RequestID, String TravelDateFrom, 
			String TravelDateTo, String SbuID) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		FTTravelDetailsPage generalinfo = new FTTravelDetailsPage(driver, test);
		ResultForeignTravelPage result = new ResultForeignTravelPage(driver, test);
		SearchForeignTravelPage searchFTR = new SearchForeignTravelPage(driver, test);
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
				searchER.click_FTRReqlink();
				searchFTR.selectSbuID(SbuID, RequestID);
				searchFTR.click_SearchBtn();
				Wait.waitfor(3);
				result.click_CopyIcon();
				Wait.waitfor(3);
				generalinfo.enter_TravelDateFrom(TravelDateFrom);
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(TravelDateTo);
				generalinfo.save();
				Wait.waitfor(3);
				String requestID = generalinfo.get_RequestID();
				home.returnToCRPage();
				Wait.waitfor(3);
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(3);
				searchER.click_FTRReqlink();	
				searchFTR.selectSbuID(SbuID, requestID);
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
