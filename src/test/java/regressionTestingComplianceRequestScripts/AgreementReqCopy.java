package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2024
 * Descriptions : Copy Agreement Request
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
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.AgreementResultsAgreementRequestPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgreementReqCopy extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AgreementReqCopy", excel);
	}

	@Test(dataProvider = "getData")
	public void copyAgreementRequestForm(String Testcase, String RunMode, String RequestID, String SiteId, String Segment, 
			String Department, String ProductFamily, String Program, String ProductLines) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementResultsAgreementRequestPage result = new AgreementResultsAgreementRequestPage(driver, test);
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
					searchER.click_AgreementReq();
					searchAR.selectReqID(RequestID);
					searchAR.click_SearchBtn();
					Wait.waitfor(3);
					searchER.click_CopyIcon();
					Wait.waitfor(3);
					generalinfo.select_Site(SiteId);
					generalinfo.select_Segment(Segment);
					generalinfo.select_Department(Department);
					generalinfo.select_ProductFamily(ProductFamily);
					generalinfo.select_Program(Program);
					generalinfo.select_ProductLines(ProductLines);
					Wait.waitfor(3);
					generalinfo.click_SaveButton();
					Wait.waitfor(3);
					String requestID = generalinfo.get_RequestID();
					home.returnToCRPage();
					Wait.waitfor(3);
					searchER.moveTo_Features();
					searchER.click_Requests();
					Wait.waitfor(3);
					searchER.click_AgreementReq();			
					searchAR.selectReqID(requestID);
					searchAR.click_SearchBtn();
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