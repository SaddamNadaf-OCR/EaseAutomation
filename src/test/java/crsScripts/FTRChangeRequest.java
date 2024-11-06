/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Nov 2019
 * Descriptions : Change Request for Foreign Travel Request 
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil
 */

package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.FTAdditionalInfoAdditionalQuestionsPage;
import crsClasses.FTAdditionalInfoDocumentsPage;
import crsClasses.FTAdditionalInfoEquipmentPage;
import crsClasses.FTAdditionalInfoQuestionnairePage;
import crsClasses.FTChangeRequestPage;
import crsClasses.FTNotesPage;
import crsClasses.FTReviewPage;
import crsClasses.FTSubmitPage;
import crsClasses.FTTemplatePage;
import crsClasses.FTTravelDetailsPage;
import crsClasses.FTTravelInfoCompanyPage;
import crsClasses.FTTravelInfoCountryPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchForeignTravelPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FTRChangeRequest extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FTRChangeRequest", excel);
	}

	@Test(dataProvider = "getData") 
	public void FTRChangeReq(String Testcase,String RunMode, String BuisnessUnit, String TravelDateFrom, String TravelDateTo, String TravelerName,
			String TravelerEmail, String CountryOfCitizenship, String FTCountry, String ConsigneeId, String DocumentType, String DocumentDescription,
			String UploadFile, String DocKeywords, String SourceSystemDocNumber, String Notes, String UserFirstName,
			String EDecision,String Determination,String ActivityType,String AuthorizationType,String AgreementNo, String SDecision, String MDecision, String DDecision,
			String ReasonForChange, String ChangeRequest) throws Exception {

		// ******************************** Objects Creation *******************************************
		HomePageCRs					            home			       = new HomePageCRs(driver, test);
		SearchForeignTravelPage                 searchFT               = new SearchForeignTravelPage (driver, test);
		FTTemplatePage                          template               = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo            = new FTTravelDetailsPage(driver, test);
		FTTravelInfoCountryPage                 country                = new FTTravelInfoCountryPage(driver, test);
		FTTravelInfoCompanyPage                 company                = new FTTravelInfoCompanyPage(driver,test);
		FTAdditionalInfoQuestionnairePage       questionnairre         = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTAdditionalInfoEquipmentPage           equipment              = new FTAdditionalInfoEquipmentPage(driver,test);
		FTAdditionalInfoAdditionalQuestionsPage additional             = new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		FTAdditionalInfoDocumentsPage           document               = new FTAdditionalInfoDocumentsPage(driver,test);             
		FTNotesPage                             notes                  = new FTNotesPage(driver,test);
		FTSubmitPage                            submit                 = new FTSubmitPage(driver,test);
		FTReviewPage                            review                 = new FTReviewPage(driver,test);
		FTChangeRequestPage                     change                 = new FTChangeRequestPage(driver,test);
		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{
				throw new SkipException("Skipping the test");
			}else {	
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.click_ComplianceRequest();
					searchFT.moveTo_Features();
					Wait.waitfor(3);
					searchFT.click_Requests();
					Wait.waitfor(3);
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
					generalinfo.movetotravelinfo();
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
					questionnairre.click_notapplicable();
					questionnairre.save();
					Wait.waitfor(3);
					questionnairre.moveForward();
					Wait.waitfor(3);
					equipment.click_notapplicable();
					equipment.save();
					Wait.waitfor(3);
					equipment.moveForward();
					Wait.waitfor(3);
					try {
						additional.click_notapplicable();
						Wait.waitfor(3);
						additional.save();
						Wait.waitfor(3);
						additional.moveForward();
					} catch (Exception e) {
						test.log(LogStatus.INFO, "Skipped: Additional Questions Tab as it is not Present");
					}					
					Wait.waitfor(3);
					document.add_Document(DocumentType, DocumentDescription, UploadFile, DocKeywords, SourceSystemDocNumber);
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
					review.exportdecision(EDecision,Determination);
					if(ActivityType.length()>0){
						review.selectactivitytype(ActivityType);
					}
					if(Determination.contains("Approved under ITAR Exemption")) {
						review.enter_authorizationtype(AuthorizationType);	
					}

					if(Determination.contains("Approved under Current Agreement")||Determination.contains("Approved under ITAR Exemption")) {
						review.enter_agreementno(AgreementNo);
					}
					review.click_exp_saveandfinalize();
					Wait.waitfor(3);
					if(EDecision.contains("Approved")){
						review.securitydecision(SDecision);
						review.click_sec_saveandfinalize();
					}
					Wait.waitfor(3);
					if(SDecision.contains("Approved")){
						review.managerdecision(MDecision);
						review.click_man_saveandfinalize();
					}
					Wait.waitfor(3);
					if(MDecision.contains("Approved")){
						review.directordecision(DDecision);
						review.click_dir_saveandfinalize();
					}
					Wait.waitfor(3);
					review.moveToChangeReqTab();
					Wait.waitfor(3);
					change.click_addchangerequest();
					Wait.waitfor(3);
					change.enter_reasonforchange(ReasonForChange);
					if(ChangeRequest.contains("D")) {
						change.select_modifytraveldate();	
					}
					else if(ChangeRequest.contains("G")) {
						change.select_modifytravellerinformation();	
					}
					else if(ChangeRequest.contains("Q")) {
						change.select_modifyquestionnairre();	
					}
					change.submit();
					Wait.waitfor(3);
					home.returnToCRPage();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			testFail();
			home.returnToCRPage();
			Assert.assertTrue(false);
		}

	}
}


