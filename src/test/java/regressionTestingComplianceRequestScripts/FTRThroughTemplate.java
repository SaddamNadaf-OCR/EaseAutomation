package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import crsClasses.FTGeneralDescriptionsPage;
import crsClasses.FTNotesPage;
import crsClasses.FTReviewPage;
import crsClasses.FTSubmitPage;
import crsClasses.FTTemplatePage;
import crsClasses.FTTravelDetailsPage;
import crsClasses.FTTravelInfoCountryPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelPage;
import crsClasses.SearchForeignTravelPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FTRThroughTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FTRThroughTemplate", excel);
	}
	
	@Test(dataProvider = "getData")
	public void FTRReq(String Testcase, String RunMode, String Template, String TravelDateFrom, String TravelDateTo,
			String FTCountry, String Notes, String UserFirstName, String EDecision, String Determination,	String ActivityType, 
			String AuthorizationType, String AgreementNo, String SDecision, String MDecision, String DDecision, 
			String SbuID) throws Exception {

		// *************** Objects Creation **********************

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchForeignTravelPage searchFT = new SearchForeignTravelPage(driver, test);
		FTTemplatePage template = new FTTemplatePage(driver, test);
		FTTravelDetailsPage generalinfo = new FTTravelDetailsPage(driver, test);
		FTNotesPage notes = new FTNotesPage(driver, test);
		FTSubmitPage submit = new FTSubmitPage(driver, test);
		FTReviewPage review = new FTReviewPage(driver, test);
		ResultForeignTravelPage resultFTR = new ResultForeignTravelPage(driver, test);
		FTGeneralDescriptionsPage generaldesc = new FTGeneralDescriptionsPage(driver, test);
		FTTravelInfoCountryPage country = new FTTravelInfoCountryPage(driver, test);

		// ****************** Test steps execution **************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.click_ComplianceRequest();
					searchFT.moveTo_Features();
					searchFT.click_Requests();
					searchFT.click_ForeignTravel();
					Wait.waitfor(3);
					searchFT.click_AddRequestBtn();
					Wait.waitfor(3);
					template.template(Template);
					Wait.waitfor(3);
					generalinfo.enter_TravelDateFrom(TravelDateFrom);
					Wait.waitfor(3);
					generalinfo.enter_TravelDateTo(TravelDateTo);
					Wait.waitfor(3);
					generalinfo.save();
					Wait.waitfor(3);
					String RequestID = generalinfo.get_RequestID();
/*					generaldesc.movetotravelinfo();
					Wait.waitfor(3);
					country.addcountry();
					country.selectcountry(FTCountry);
					Wait.waitfor(3);
					country.addright();
					country.saveandreturn();
					Wait.waitfor(3);*/
					generalinfo.submitRequest();
					Wait.waitfor(3);
					try {
						notes.click_additionalnotes();
						notes.enter_notes(Notes);
						notes.savendreturn();
					} catch (Exception e) {
						test.log(LogStatus.INFO, "Additional Notes are not present");
					}
					Wait.waitfor(3);
					notes.moveforward();
					Wait.waitfor(3);
					submit.click_exportname();
					submit.select_record(UserFirstName);
					Wait.waitfor(3);
					try{
						submit.click_securityname();
						submit.select_record(UserFirstName);
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Director Tab is disabled");
					}
					Wait.waitfor(3);
					try {
						submit.click_managername();
						submit.select_record(UserFirstName);
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Director Tab is disabled");
					}
					Wait.waitfor(3);
					try {
						submit.click_directorname();
						submit.select_record(UserFirstName);
					} catch (Exception e) {
						test.log(LogStatus.INFO, "Director Tab is disabled");
					}
					Wait.waitfor(3);
					submit.save();
					Wait.waitfor(3);
					submit.submit();
					Wait.waitfor(3);
					submit.moveforward();
					Wait.waitfor(3);
					review.exportdecision(EDecision, Determination);
					if (ActivityType.length() > 0) {
						review.selectactivitytype(ActivityType);
					}
					if (Determination.contains("Approved under ITAR Exemption")) {
						review.enter_authorizationtype(AuthorizationType);
					}

					if (Determination.contains("Approved under Current Agreement")
							|| Determination.contains("Approved under ITAR Exemption")) {
						review.enter_agreementno(AgreementNo);
					}
					review.click_exp_saveandfinalize();
					Wait.waitfor(3);
					if (EDecision.contains("Approved")) {
						review.securitydecision(SDecision);
						review.click_sec_saveandfinalize();
					}
					Wait.waitfor(3);
					if (SDecision.contains("Approved")) {
						review.managerdecision(MDecision);
						review.click_man_saveandfinalize();
					}
					Wait.waitfor(3);
					if (MDecision.contains("Approved")) {
						review.directordecision(DDecision);
						review.click_dir_saveandfinalize();
					}
					Wait.waitfor(4);
					home.returnToCRPage();
					Wait.waitfor(3);
					searchFT.moveTo_Features();
					searchFT.click_Requests();
					searchFT.click_ForeignTravel();
					searchFT.selectSbuID(SbuID, RequestID);
					searchFT.click_SearchBtn();
					resultFTR.titleIsDisplayed();
					resultFTR.requestIDIsDisplayed(RequestID);
					Wait.waitfor(3);
					home.returnToCRPage();
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
			e.printStackTrace();
			testFail();
			home.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
}