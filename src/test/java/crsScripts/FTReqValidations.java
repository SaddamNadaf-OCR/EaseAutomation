/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Oct 2019
 * Descriptions : Validating Foreign Travel Request 
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
import crsClasses.FTAdditionalInfoAdditionalQuestionsPage;
import crsClasses.FTAdditionalInfoDocumentsPage;
import crsClasses.FTAdditionalInfoQuestionnairePage;
import crsClasses.FTNotesPage;
import crsClasses.FTReviewPage;
import crsClasses.FTSubmitPage;
import crsClasses.FTTemplatePage;
import crsClasses.FTTravelDetailsPage;
import crsClasses.FTTravelInfoCompanyPage;
import crsClasses.FTTravelInfoCountryPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestPage;
import crsClasses.SearchForeignTravelPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FTReqValidations extends SeleniumTestBase {

	// Error validations for Foreign Travel General Info Page

	@Test(priority = 1)
	public void FTGeneralInfoError() throws Exception {

		HomePageCRs					           homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	       searchER            = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                searchFTR   		   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                         template            = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                    generalinfo         = new FTTravelDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.save();
				generalinfo.validate_FTRGeneralInfoError();
				Wait.waitfor(4);
				homecrs.returnToCRPage();

			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 2)
	public void FTRCompanyError() throws Exception {

		HomePageCRs					           homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	       searchER            = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                searchFTR   		   = new SearchForeignTravelPage(driver, test);
		FTTravelInfoCountryPage                country             = new FTTravelInfoCountryPage(driver, test);
		FTTemplatePage                         template            = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                    generalinfo         = new FTTravelDetailsPage(driver, test);
		FTTravelInfoCompanyPage                company            = new FTTravelInfoCompanyPage(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetotravelinfo();
				Wait.waitfor(4);
				generalinfo.movetotravelinfo();
				Wait.waitfor(3);
				country.moveForward();
				Wait.waitfor(4);
				company.addcompany();
				Wait.waitfor(3);
				company.saveandreturn();
				Wait.waitfor(3);
				company.validateFTRCompanyError();
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
	@Test(priority=3)
	public void FTRAdditionalQuestionsError() throws Exception {

		HomePageCRs					           homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	       searchER            = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                searchFTR   		   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                         template            = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                    generalinfo         = new FTTravelDetailsPage(driver, test);
		FTAdditionalInfoQuestionnairePage      question            = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTAdditionalInfoAdditionalQuestionsPage addtnquestion      = new FTAdditionalInfoAdditionalQuestionsPage(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetoadditionalinfo();
				Wait.waitfor(4);
				try {						
					question.movetoadditionalquestn();
				} catch (Exception e) {
					System.out.println("Additional Questionnairre Tab is not Present");
				}

				Wait.waitfor(4);
				addtnquestion.save();
				Wait.waitfor(4);
				addtnquestion.validate_additionalquestnerror();
				Wait.waitfor(4);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}

	}



	@Test(priority = 4)
	public void FTRDocumentError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTAdditionalInfoQuestionnairePage       question           = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTAdditionalInfoDocumentsPage           document           = new FTAdditionalInfoDocumentsPage(driver,test); 

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetoadditionalinfo();
				Wait.waitfor(4);
				question.movetodocument();
				Wait.waitfor(4);
				document.click_viewadddocument();
				Wait.waitfor(4);
				document.save();
				Wait.waitfor(3);
				document.validate_documenterror();
				Wait.waitfor(3);
				document.cancel();
				Wait.waitfor(3);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}


	@Test(priority = 5)
	public void FTRNotesError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTNotesPage                             note               = new FTNotesPage(driver,test); 

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetosubmitreq();
				Wait.waitfor(4);
				note.click_additionalnotes();
				Wait.waitfor(4);
				note.savendreturn();
				Wait.waitfor(4);
				note.validatenoteserror();
				Wait.waitfor(4);
				note.cancel();
				Wait.waitfor(3);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 6)
	public void FTRSubmitPageError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTNotesPage                             note               = new FTNotesPage(driver,test); 
		FTSubmitPage                            submit              = new FTSubmitPage(driver,test); 

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetosubmitreq();
				Wait.waitfor(4);
				note.moveforward();
				Wait.waitfor(4);
				submit.save();
				Wait.waitfor(4);
				submit.validate_submitpageerror();
				Wait.waitfor(4);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 7)
	public void FTRExpReviewPageError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTTravelInfoCountryPage                 country            = new FTTravelInfoCountryPage(driver, test);
		FTSubmitPage                            submit             = new FTSubmitPage(driver,test); 
		FTAdditionalInfoQuestionnairePage       question           = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTNotesPage                             note               = new FTNotesPage(driver,test); 
		FTAdditionalInfoAdditionalQuestionsPage addtnquestion      = new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		FTReviewPage                            review                 = new FTReviewPage(driver,test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetotravelinfo();
				Wait.waitfor(4);
				country.addcountry();
				Wait.waitfor(4);
				country.selectcountry(propCRs.getProperty("FTCountry"));
				Wait.waitfor(3);
				country.addright();
				country.saveandreturn();
				Wait.waitfor(3);
				country.movetoadditionalinfo();
				Wait.waitfor(4);
				try {
					question.movetoadditionalquestn();
					Wait.waitfor(4);
					addtnquestion.click_notapplicable();
					Wait.waitfor(3);
					addtnquestion.save();
					Wait.waitfor(4);
					addtnquestion.movetosubmitreq();
										
				} catch (Exception e) {
					question.movetoSubmittab();	
				}
				Wait.waitfor(4);
				note.moveforward();
				Wait.waitfor(4);
				submit.click_exportname();
				submit.select_record(propCRs.getProperty("ExpUserFirstName"));
				Wait.waitfor(3);
				submit.click_securityname();
				submit.select_record(propCRs.getProperty("SecUserFirstName"));
				Wait.waitfor(3);
				submit.click_managername();
				submit.select_record(propCRs.getProperty("MangUserFirstName"));
				Wait.waitfor(3);
				try {
					submit.click_directorname();
					submit.select_record(propCRs.getProperty("DirUserFirstName"));
				} catch (Exception e) {
				System.out.println("Director Tab is Disabled");
				}
				Wait.waitfor(3);
				submit.save();
				Wait.waitfor(3);
				submit.submit();
				Wait.waitfor(3);
				submit.moveforward();
				Wait.waitfor(4);
				review.click_exp_saveandfinalize();
				Wait.waitfor(4);
				review.validate_expreviewerror();
				Wait.waitfor(4);
//				review.exportdecision(propCRs.getProperty("ExpDecision"), propCRs.getProperty("ExpDetermination"));
//				Wait.waitfor(5);
//				review.click_exp_saveandfinalize();
//				Wait.waitfor(7);
//				review.validate_exp_authorizationerror();
//				Wait.waitfor(4);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8)
	public void FTRSecReviewPageError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTTravelInfoCountryPage                 country            = new FTTravelInfoCountryPage(driver, test);
		FTSubmitPage                            submit             = new FTSubmitPage(driver,test); 
		FTAdditionalInfoQuestionnairePage       question           = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTNotesPage                             note               = new FTNotesPage(driver,test); 
		FTAdditionalInfoAdditionalQuestionsPage addtnquestion      = new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		FTReviewPage                            review                 = new FTReviewPage(driver,test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetotravelinfo();
				Wait.waitfor(4);
				country.addcountry();
				Wait.waitfor(4);
				country.selectcountry(propCRs.getProperty("FTCountry"));
				Wait.waitfor(3);
				country.addright();
				country.saveandreturn();
				Wait.waitfor(3);
				country.movetoadditionalinfo();
				Wait.waitfor(4);
				try {
					question.movetoadditionalquestn();
					Wait.waitfor(4);
					addtnquestion.click_notapplicable();
					Wait.waitfor(3);
					addtnquestion.save();
					Wait.waitfor(4);
					addtnquestion.movetosubmitreq();
					
				} catch (Exception e) {
					question.movetoSubmittab();	
				}
				Wait.waitfor(4);
				note.moveforward();
				Wait.waitfor(4);
				submit.click_exportname();
				submit.select_record(propCRs.getProperty("ExpUserFirstName"));
				Wait.waitfor(3);
				submit.click_securityname();
				submit.select_record(propCRs.getProperty("SecUserFirstName"));
				Wait.waitfor(3);
				submit.click_managername();
				submit.select_record(propCRs.getProperty("MangUserFirstName"));
				Wait.waitfor(3);
				try {
					submit.click_directorname();
					submit.select_record(propCRs.getProperty("DirUserFirstName"));
				} catch (Exception e) {
				System.out.println("Director Tab is Disabled");
				}
				
				Wait.waitfor(3);
				submit.save();
				Wait.waitfor(3);
				submit.submit();
				Wait.waitfor(3);
				submit.moveforward();
				Wait.waitfor(4);
				review.exportdecision(propCRs.getProperty("ExpDecision"), propCRs.getProperty("ExpDetermination"));
				review.enter_agreementno(propCRs.getProperty("AgreementNo"));
				Wait.waitfor(4);
				review.click_exp_saveandfinalize();
				Wait.waitfor(4);
				review.click_sec_saveandfinalize();
				Wait.waitfor(4);
				review.validate_secreviewerror();
				Wait.waitfor(4);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 9)
	public void FTRManagReviewPageError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTTravelInfoCountryPage                 country            = new FTTravelInfoCountryPage(driver, test);
		FTSubmitPage                            submit             = new FTSubmitPage(driver,test); 
		FTAdditionalInfoQuestionnairePage       question           = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTNotesPage                             note               = new FTNotesPage(driver,test); 
		FTAdditionalInfoAdditionalQuestionsPage addtnquestion      = new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		FTReviewPage                            review                 = new FTReviewPage(driver,test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetotravelinfo();
				Wait.waitfor(4);
				country.addcountry();
				Wait.waitfor(4);
				country.selectcountry(propCRs.getProperty("FTCountry"));
				Wait.waitfor(3);
				country.addright();
				country.saveandreturn();
				Wait.waitfor(3);
				country.movetoadditionalinfo();
				Wait.waitfor(4);
				try {
					question.movetoadditionalquestn();
					Wait.waitfor(4);
					addtnquestion.click_notapplicable();
					Wait.waitfor(3);
					addtnquestion.save();
					Wait.waitfor(4);
					addtnquestion.movetosubmitreq();
					
				} catch (Exception e) {
					question.movetoSubmittab();	
				}
				Wait.waitfor(4);
				note.moveforward();
				Wait.waitfor(4);
				submit.click_exportname();
				submit.select_record(propCRs.getProperty("ExpUserFirstName"));
				Wait.waitfor(3);
				submit.click_securityname();
				submit.select_record(propCRs.getProperty("SecUserFirstName"));
				Wait.waitfor(3);
				submit.click_managername();
				submit.select_record(propCRs.getProperty("MangUserFirstName"));
				Wait.waitfor(3);
				try {
					submit.click_directorname();
					submit.select_record(propCRs.getProperty("DirUserFirstName"));
				} catch (Exception e) {
				System.out.println("Director Tab is Disabled");
				}
				Wait.waitfor(3);
				submit.save();
				Wait.waitfor(3);
				submit.submit();
				Wait.waitfor(3);
				submit.moveforward();
				Wait.waitfor(4);
				review.exportdecision(propCRs.getProperty("ExpDecision"), propCRs.getProperty("ExpDetermination"));
				review.enter_agreementno(propCRs.getProperty("AgreementNo"));
				Wait.waitfor(4);
				review.click_exp_saveandfinalize();
				Wait.waitfor(4);
				review.securitydecision(propCRs.getProperty("SecDecision"));
				Wait.waitfor(4);
				review.click_sec_saveandfinalize();
				Wait.waitfor(4);
				review.click_man_saveandfinalize();
				Wait.waitfor(4);
				review.validate_manreviewerror();
				Wait.waitfor(4);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled=false)
	public void FTRDirReviewPageError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		FTTravelDetailsPage                     generalinfo        = new FTTravelDetailsPage(driver, test);
		FTTravelInfoCountryPage                 country            = new FTTravelInfoCountryPage(driver, test);
		FTSubmitPage                            submit             = new FTSubmitPage(driver,test); 
		FTAdditionalInfoQuestionnairePage       question           = new FTAdditionalInfoQuestionnairePage(driver,test);
		FTNotesPage                             note               = new FTNotesPage(driver,test); 
		FTAdditionalInfoAdditionalQuestionsPage addtnquestion      = new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		FTReviewPage                            review                 = new FTReviewPage(driver,test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_newrequest();                  
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("FTBusinessUnit")); 
				generalinfo.enter_TravelDateFrom(propCRs.getProperty("TravelDatefrom"));
				Wait.waitfor(3);
				generalinfo.enter_TravelDateTo(propCRs.getProperty("TravelDateTo"));
				Wait.waitfor(3);
				generalinfo.enter_TravelerName(propCRs.getProperty("TravelerName"));
				generalinfo.enter_TravelerEmail(propCRs.getProperty("TravelerEmail"));
				generalinfo.enter_COC(propCRs.getProperty("CountryOfCitizenship"));
				generalinfo.select_primarypurpose();
				generalinfo.save();
				Wait.waitfor(4);
				generalinfo.movetotravelinfo();
				Wait.waitfor(4);
				country.addcountry();
				Wait.waitfor(4);
				country.selectcountry(propCRs.getProperty("FTCountry"));
				Wait.waitfor(3);
				country.addright();
				country.saveandreturn();
				Wait.waitfor(3);
				country.movetoadditionalinfo();
				Wait.waitfor(4);
				try {
					question.movetoadditionalquestn();
					Wait.waitfor(4);
					addtnquestion.click_notapplicable();
					Wait.waitfor(3);
					addtnquestion.save();
					Wait.waitfor(4);
					addtnquestion.movetosubmitreq();
					
				} catch (Exception e) {
					question.movetoSubmittab();	
				}
				Wait.waitfor(4);
				note.moveforward();
				Wait.waitfor(4);
				submit.click_exportname();
				submit.select_record(propCRs.getProperty("ExpUserFirstName"));
				Wait.waitfor(3);
				submit.click_securityname();
				submit.select_record(propCRs.getProperty("SecUserFirstName"));
				Wait.waitfor(3);
				submit.click_managername();
				submit.select_record(propCRs.getProperty("MangUserFirstName"));
				Wait.waitfor(3);
				submit.click_directorname();
				submit.select_record(propCRs.getProperty("DirUserFirstName"));
				Wait.waitfor(3);
				submit.save();
				Wait.waitfor(3);
				submit.submit();
				Wait.waitfor(3);
				submit.moveforward();
				Wait.waitfor(4);
				review.exportdecision(propCRs.getProperty("ExpDecision"), propCRs.getProperty("ExpDetermination"));
				review.enter_agreementno(propCRs.getProperty("AgreementNo"));
				Wait.waitfor(4);
				review.click_exp_saveandfinalize();
				Wait.waitfor(4);
				review.securitydecision(propCRs.getProperty("SecDecision"));
				Wait.waitfor(4);
				review.click_sec_saveandfinalize();
				Wait.waitfor(4);
				review.managerdecision(propCRs.getProperty("ManagerDecision"));
				Wait.waitfor(4);
				review.click_man_saveandfinalize();
				Wait.waitfor(4);
				review.click_dir_saveandfinalize();
				Wait.waitfor(4);
				review.validate_dirreviewerror();
				Wait.waitfor(4);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 10)
	public void FTRTemplateError() throws Exception {

		HomePageCRs					            homecrs			   = new HomePageCRs(driver, test);
		SearchExportRequestPage     	        searchER           = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage                 searchFTR   	   = new SearchForeignTravelPage(driver, test);
		FTTemplatePage                          template           = new FTTemplatePage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_FTRReqlink();
				Wait.waitfor(5);
				searchFTR.click_AddRequestBtn();
				Wait.waitfor(5);
				template.click_select();
				Wait.waitfor(5);
				template.validate_templateError();
				Wait.waitfor(5);
				homecrs.returnToCRPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			homecrs.returnToCRPage();
			Assert.assertTrue(false);
		}

	}
}

