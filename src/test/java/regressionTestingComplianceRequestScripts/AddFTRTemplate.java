package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2024
 * Descriptions : Add Foreign Travel Request Template
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
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
import crsClasses.FTTravelDetailsPage;
import crsClasses.FTTravelInfoCompanyPage;
import crsClasses.FTTravelInfoCountryPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelPage;
import crsClasses.SearchForeignTravelTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddFTRTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddAFTRTemplates", excel);
	}
	
	@Test(dataProvider ="getData")
	public void ftrRequestTemplate(String Testcase, String RunMode, String templateName, String BuisnessUnit, String TravelDateFrom, 
			String TravelDateTo, String TravelerName, String TravelerEmail, String SiteId, String Program, String Segment,
			String ProductFamily, String ProductLines, String CountryOfCitizenship, String FTCountry,
			String ConsigneeId, String Questionnaire, String QuestionnaireAnswer, String DocumentType, String DocumentDescription, 
			String UploadFile, String DocKeywords, String SourceSystemDocNumber, String Notes, String UserFirstName, String EDecision, 
			String Determination, String ActivityType, String AuthorizationType, String AgreementNo, String SDecision, String MDecision,
			String DDecision, String SbuID) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		SearchForeignTravelTemplatePage searchPage = new SearchForeignTravelTemplatePage(driver, test);
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
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_ListScreening();
					homepage.click_ComplianceRequest();
					homepage.FTRReqTemplate();
					searchPage.AddTemplateButton();
					generalinfo.add_template(templateName);
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
					country.saveandreturn();
					Wait.waitfor(3);
					country.moveForward();
					Wait.waitfor(3);
					company.addcompany();
					Wait.waitfor(3);
					company.enter_CompanyCode(ConsigneeId);
					Wait.waitfor(3);
					company.saveandreturn();
					Wait.waitfor(3);
					company.moveForward();
					Wait.waitfor(3);
					questionnairre.addQuestionnaire(Questionnaire, QuestionnaireAnswer);
					Wait.waitfor(3);
					try {
						questionnairre.notapplicable1();
						Wait.waitfor(3);
						questionnairre.save();
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Skipped: Standard Questions Tab as it is not Present: ");
					}
					Wait.waitfor(3);
					questionnairre.moveForward();
					Wait.waitfor(3);
					equipment.click_notapplicable();
					Wait.waitfor(3);
					Wait.waitfor(3);
					try {
						equipment.notapplicable1();
						Wait.waitfor(3);
						equipment.save();	
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Skipped Additional Equipment Questions Tab as it is not Present: ");
					}
					Wait.waitfor(3);
					equipment.moveForward();
					Wait.waitfor(3);
					try { 
						additional.click_notapplicable();
						Wait.waitfor(3);
						additional.save();
						}
					catch(Exception e) { 
						test.log(LogStatus.INFO,"Skipped: Additional Questions Tab as it is not Present: ");
					}
					Wait.waitfor(3);
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
					submit.click_exportname();
					submit.select_record(UserFirstName);
					Wait.waitfor(3);
					submit.click_securityname();
					submit.select_record(UserFirstName);
					Wait.waitfor(3);
					submit.click_managername();
					submit.select_record(UserFirstName);
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
					homepage.returnToCRPage();
					Wait.waitfor(3);
					
					resultFTR.titleIsDisplayed();
					resultFTR.requestIDIsDisplayed(RequestID);
					Wait.waitfor(3);
					homepage.returnToCRPage();
					Wait.waitfor(3);
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(Exception e) {
			
		}
	}

}
