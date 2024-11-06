
/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Aug 2021
 * Descriptions : Export Request Default Reviewer Creation
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil
 */
package crsScripts;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.GlobalConfigurationParametersPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestPage;
import crsClasses.SearchGlobalConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ERDefaultReviewerCreation extends SeleniumTestBase {


	@Test (priority=1)
	public void AddERTFPReviewer() throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();
		//ImportSelectSBUPage      selectsbu     = new ImportSelectSBUPage(driver,test);
		//FTAdditionalInfoAdditionalQuestionsPage ft =new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		SearchGlobalConfigurationPage   gcp  = new SearchGlobalConfigurationPage(driver,test);
		GlobalConfigurationParametersPage gc= new GlobalConfigurationParametersPage(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCRs.moveTo_ListScreening();
				Wait.waitfor(3);
				homeCRs.click_ComplianceRequest();
				searchExportRequest.moveTo_Tools();
				searchExportRequest.click_configureapp();
				gcp.enter_TFP_ParameterName();
				gc.Edit_TFP_Default();
				homeCRs.returnToCRPage();
				softAssertion.assertAll();
			} 
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homeCRs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=2)
	public void AddEREFPReviewer() throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();
		//ImportSelectSBUPage      selectsbu     = new ImportSelectSBUPage(driver,test);
		//FTAdditionalInfoAdditionalQuestionsPage ft =new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		SearchGlobalConfigurationPage   gcp  = new SearchGlobalConfigurationPage(driver,test);
		GlobalConfigurationParametersPage gc= new GlobalConfigurationParametersPage(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeCRs.moveTo_ListScreening();
				Wait.waitfor(3);
				homeCRs.click_ComplianceRequest();
				searchExportRequest.moveTo_Tools();
				searchExportRequest.click_configureapp();
				gcp.enter_EFP_ParameterName();
				gc.Edit_EFP_Default();
				homeCRs.returnToCRPage();
				softAssertion.assertAll();
			} 
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homeCRs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
}



