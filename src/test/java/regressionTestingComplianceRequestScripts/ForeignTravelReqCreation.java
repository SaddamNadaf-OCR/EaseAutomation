/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Sep 2019
 * Descriptions : Creating Foreign Travel Request 
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

import crsClasses.FTAdditionalInfoAdditionalQuestionsPage;
import crsClasses.FTAdditionalInfoDocumentsPage;
import crsClasses.FTAdditionalInfoEquipmentPage;
import crsClasses.FTAdditionalInfoQuestionnairePage;
import crsClasses.FTGeneralDescriptionsPage;
import crsClasses.FTNotesPage;
import crsClasses.FTReviewPage;
import crsClasses.FTSubmitPage;
import crsClasses.FTTemplatePage;
import crsClasses.FTTravelDetailsPage;
import crsClasses.FTTravelInfoCompanyPage;
import crsClasses.FTTravelInfoCountryPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelPage;
import crsClasses.SearchForeignTravelPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ForeignTravelReqCreation extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ForeignTravel", excel);
	}

	@Test(dataProvider = "getData")
	public void FTRReq(String Testcase, String RunMode, String BuisnessUnit, String TravelDateFrom, String TravelDateTo,
			String TravelerName, String TravelerEmail, String SiteId, String Program, String Segment,
			String ProductFamily, String ProductLines, String CountryOfCitizenship, String FTCountry,
			String ConsigneeId, String Questionnaire, String QuestionnaireAnswer, String DocumentType, String DocumentDescription, 
			String UploadFile, String DocKeywords, String SourceSystemDocNumber, String Notes, String UserFirstName, String EDecision, 
			String Determination, String ActivityType, String AuthorizationType, String AgreementNo, String SDecision, String MDecision,
			String DDecision, String SbuID) throws Exception {

		// *************** Objects Creation **********************

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchForeignTravelPage searchFT = new SearchForeignTravelPage(driver, test);
		FTTemplatePage template = new FTTemplatePage(driver, test);
		FTTravelDetailsPage generalinfo = new FTTravelDetailsPage(driver, test);
		FTGeneralDescriptionsPage generaldesc = new FTGeneralDescriptionsPage(driver, test);
		FTTravelInfoCountryPage country = new FTTravelInfoCountryPage(driver, test);
		FTTravelInfoCompanyPage company = new FTTravelInfoCompanyPage(driver, test);
		FTAdditionalInfoQuestionnairePage questionnairre = new FTAdditionalInfoQuestionnairePage(driver, test);
		FTAdditionalInfoEquipmentPage equipment = new FTAdditionalInfoEquipmentPage(driver, test);
		FTAdditionalInfoAdditionalQuestionsPage additional = new FTAdditionalInfoAdditionalQuestionsPage(driver, test);
		FTAdditionalInfoDocumentsPage document = new FTAdditionalInfoDocumentsPage(driver, test);
		FTNotesPage notes = new FTNotesPage(driver, test);
		FTSubmitPage submit = new FTSubmitPage(driver, test);
		FTReviewPage review = new FTReviewPage(driver, test);
		ResultForeignTravelPage resultFTR = new ResultForeignTravelPage(driver, test);

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
					template.click_newrequest();
					Wait.waitfor(3);
					generalinfo.select_BuisnessUnit(BuisnessUnit);
					generalinfo.enter_TravelDateFrom(TravelDateFrom);
					Wait.waitfor(3);
					generalinfo.enter_TravelDateTo(TravelDateTo);
					Wait.waitfor(3);
					generalinfo.enter_TravelerName(TravelerName);
					generalinfo.enter_TravelerEmail(TravelerEmail);
					generalinfo.enter_COC(CountryOfCitizenship);
					generalinfo.select_primarypurpose();
					generalinfo.save();
					Wait.waitfor(3);
					String RequestID = generalinfo.get_RequestID();
					generalinfo.movetogeneraldesc();
					if (SiteId.length() > 0) {
						generaldesc.select_Site(SiteId);
					}
					if (Program.length() > 0) {

						generaldesc.select_Program(Program);
					}
					if (Segment.length() > 0) {
						generaldesc.select_Segment(Segment);
					}
					if (ProductFamily.length() > 0) {
						generaldesc.select_ProductFamily(ProductFamily);
					}
					if (ProductLines.length() > 0) {
						generaldesc.select_ProductLines(ProductLines);
					}
					generaldesc.clickOnSaveBtn();
					Wait.waitfor(3);
					generaldesc.movetotravelinfo();
					Wait.waitfor(3);
					country.addcountry();
					country.selectcountry(FTCountry);
					Wait.waitfor(3);
					country.addright();
					Wait.waitfor(3);
					country.saveandreturn();
					Wait.waitfor(3);
					country.statusLabel();
					country.moveForward();
					Wait.waitfor(3);
					company.addcompany();
					Wait.waitfor(3);
					company.enter_CompanyCode(ConsigneeId);
					Wait.waitfor(3);
					company.statusLabel();
					company.moveForward();
					Wait.waitfor(3);
					//questionnairre.addQuestionnaire(Questionnaire, QuestionnaireAnswer);
					Wait.waitfor(3);
					try {
						questionnairre.notapplicable1();
						questionnairre.save();
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Skipped: Standard Questions Tab as it is not Present: ");
					}
					questionnairre.clicklable();
					questionnairre.moveForward();
					equipment.clickonlabel();
					try {
						equipment.click_notapplicable();
						Wait.waitfor(3);
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Skipped Equipment Questions Tab as it is not Present: ");
					}
					try {
						equipment.notapplicable1();
						equipment.save();	
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Skipped Additional Equipment Questions Tab as it is not Present: ");
					}
					equipment.moveForward();
					try { 
						additional.click_notapplicable();
						additional.save();
						}
					catch(Exception e) { 
						test.log(LogStatus.INFO,"Skipped: Additional Questions Tab as it is not Present: ");
					}
					additional.clicklable();
					additional.moveForward();
					Wait.waitfor(3);
					document.add_Document(DocumentType, DocumentDescription, UploadFile, DocKeywords,
							SourceSystemDocNumber);
					Wait.waitfor(3);
					document.Forword();
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
					try {
						submit.click_exportname();
						submit.select_record(UserFirstName);
						Wait.waitfor(3);
					}catch (Exception e) {
						test.log(LogStatus.INFO, "Exporter Field is disabled");
					}
					try {
						submit.click_securityname();
						submit.select_record(UserFirstName);
						Wait.waitfor(3);
					}catch (Exception e) {
						test.log(LogStatus.INFO, "Security Field is disabled");
					}
					try {
						submit.click_managername();
						submit.select_record(UserFirstName);
						Wait.waitfor(3);
					}catch (Exception e) {
						test.log(LogStatus.INFO, "Manager Field is disabled");
					}					
					try {
						submit.click_directorname();
						submit.select_record(UserFirstName);
					} catch (Exception e) {
						test.log(LogStatus.INFO, "Director Field is disabled");
					}
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
					try {
						if (EDecision.contains("Approved")) {
							review.securitydecision(SDecision);
							review.click_sec_saveandfinalize();
						}
						Wait.waitfor(3);
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Exporter Decision is Disabled :");
					}
					try {
						if (SDecision.contains("Approved")) {
							review.managerdecision(MDecision);
							review.click_man_saveandfinalize();
						}
						Wait.waitfor(3);
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Security Decision is Disabled :");
					}
					try {
						if (MDecision.contains("Approved")) {
							review.directordecision(DDecision);
							review.click_dir_saveandfinalize();
						}
						Wait.waitfor(4);
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Manager Decision is Disabled :");
					}
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
