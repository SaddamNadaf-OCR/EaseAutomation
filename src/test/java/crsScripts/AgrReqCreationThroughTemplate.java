/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Aug 2019
 * Descriptions : Creating Agreement Request through Template
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil
*/
package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.AgreementReqReviewPage;
import crsClasses.AgreementReqSubmitPage;
import crsClasses.AgreementReqTypeOfExportPage;
import crsClasses.AgreementSelectSBUPage;
import crsClasses.AgreementTemplatePage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgrReqCreationThroughTemplate extends SeleniumTestBase {

	@Test
	public void agrreqthrutemplate() throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqTypeOfExportPage typeofexport = new AgreementReqTypeOfExportPage(driver, test);
		AgreementReqSubmitPage submit = new AgreementReqSubmitPage(driver, test);
		AgreementReqReviewPage review = new AgreementReqReviewPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {

				home.moveTo_ListScreening();
				home.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(3);
				searchER.click_AgreementReq();
				Wait.waitfor(3);
				searchAR.click_AddRequestBtn();
				Wait.waitfor(3);
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(3);
				template.select_Template(propCRs.getProperty("AgrTemplateName"));
				Wait.waitfor(3);
				template.click_Select();
				Wait.waitfor(3);
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveForward();
				Wait.waitfor(4);
				typeofexport.click_SaveButton();
				Wait.waitfor(3);
				typeofexport.movetoSubmitPage();
				Wait.waitfor(3);
				submit.addreviewer(propCRs.getProperty("ReviewerName"));
				submit.save();
				submit.submitforreview();
				Wait.waitfor(3);
				submit.moveForward();
				Wait.waitfor(3);
				review.select_status(propCRs.getProperty("AgrStatus"));
				Wait.waitfor(3);
				review.enter_phoneno(propCRs.getProperty("AgrPhone"));
				Wait.waitfor(3);
				review.select_determination(propCRs.getProperty("Determination"));
				review.add_agreementno();
				Wait.waitfor(3);
				review.save();
				Wait.waitfor(5);
				home.returnToCRPage();
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
