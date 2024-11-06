/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Nov 2023
 * Descriptions : Creating Agreement Request through Template
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil
*/
package regressionTestingComplianceRequestScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.AgreementReqReviewPage;
import crsClasses.AgreementReqSubmitPage;
import crsClasses.AgreementReqTypeOfExportPage;
import crsClasses.AgreementResultsAgreementRequestPage;
import crsClasses.AgreementSelectSBUPage;
import crsClasses.AgreementTemplatePage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgrReqCreationThroughTemplate extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AgreementReqTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void agrreqthrutemplate(String Testcase, String RunMode, String SBU, String Template, String ReviewerName, String Status,
			String Phone, String Determination) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqTypeOfExportPage typeofexport = new AgreementReqTypeOfExportPage(driver, test);
		AgreementReqSubmitPage submit = new AgreementReqSubmitPage(driver, test);
		AgreementReqReviewPage review = new AgreementReqReviewPage(driver, test);
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
					Wait.waitfor(3);
					searchER.click_AgreementReq();
					Wait.waitfor(3);
					searchAR.click_AddRequestBtn();
					Wait.waitfor(3);
					}
				if (SBU.length() > 0) {
					selectsbu.SelectSBU(SBU);
					selectsbu.clickSelect();
				}
				Wait.waitfor(3);
				template.select_Template(Template);
				Wait.waitfor(3);
				template.click_Select();
				Wait.waitfor(3);
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				String requestID = generalinfo.get_RequestID();
				Wait.waitfor(3);
				generalinfo.moveForward();
				Wait.waitfor(4);
				typeofexport.click_SaveButton();
				Wait.waitfor(3);
				typeofexport.movetoSubmitPage();
				Wait.waitfor(3);
				submit.addreviewer(ReviewerName);
				submit.save();
				submit.submitforreview();
				Wait.waitfor(3);
				submit.moveForward();
				Wait.waitfor(3);
				review.select_status(Status);
				Wait.waitfor(3);
				review.enter_phoneno(Phone);
				Wait.waitfor(3);
				review.select_determination(Determination);
				review.add_agreementno();
				Wait.waitfor(3);
				review.save();
				Wait.waitfor(5);
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
