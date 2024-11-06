package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AgreementReqAmendmentMainPage;
import crsClasses.AgreementReqDocumentsOrNotesPage;
import crsClasses.AgreementReqExportsUnderAgreementPage;
import crsClasses.AgreementReqForeignPartiesPage;
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.AgreementReqGeneralQuestionsPage;
import crsClasses.AgreementReqMLAPage;
import crsClasses.AgreementReqSubmitPage;
import crsClasses.AgreementReqUSPartiesPage;
import crsClasses.AgreementSelectSBUPage;
import crsClasses.AgreementTemplatePage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgrReqValidations extends SeleniumTestBase {

	// Error validations for Agreement General Info Page

	@Test(priority = 1)
	public void AgrGeneralInfoError() throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_ListScreening();
				home.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				Wait.waitfor(3);
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.click_SaveButton();
				Wait.waitfor(4);
				generalinfo.validate_AgrGeneralInfoError();
				Wait.waitfor(4);
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

	// Error validations for Agreement General Info Page
	@Test(priority = 2)
	public void AgreementTypeError() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_MLA(propCRs.getProperty("MLA"));
				generalinfo.enter_AgreementType_TAA(propCRs.getProperty("TAA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(5);
				generalinfo.validate_AgreemenTypeError();
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

	// Error validations for Foreign Parties Page
	@Test(priority = 3)
	public void ForeignPartiesError() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqAmendmentMainPage amendmentmain = new AgreementReqAmendmentMainPage(driver, test);
		AgreementReqForeignPartiesPage foreignparty = new AgreementReqForeignPartiesPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_TAA(propCRs.getProperty("TAA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_AgreementDetailsPage();
				Wait.waitfor(3);
				amendmentmain.moveto_ForeignParties();
				Wait.waitfor(3);
				foreignparty.addForeignParty();
				foreignparty.save();
				Wait.waitfor(5);
				foreignparty.validate_ForeignPartiesError();
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

	// Error validations for Third Country Page
	@Test(priority = 4)
	public void thirdcountry() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqAmendmentMainPage amendmentmain = new AgreementReqAmendmentMainPage(driver, test);
		AgreementReqForeignPartiesPage foreignparty = new AgreementReqForeignPartiesPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_TAA(propCRs.getProperty("TAA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_AgreementDetailsPage();
				Wait.waitfor(3);
				amendmentmain.moveto_ForeignParties();
				Wait.waitfor(3);
				foreignparty.addThirdParty();
				foreignparty.save();
				Wait.waitfor(5);
				foreignparty.validate_thirdCountryError();
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

	@Test(priority = 5)
	public void usparties() throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqAmendmentMainPage amendmentmain = new AgreementReqAmendmentMainPage(driver, test);
		AgreementReqUSPartiesPage usparty = new AgreementReqUSPartiesPage(driver, test);

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
				// home.moveto_AgrReq();
				searchAR.click_AddRequestBtn();
				Wait.waitfor(3);
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_TAA(propCRs.getProperty("TAA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_AgreementDetailsPage();
				Wait.waitfor(3);
				amendmentmain.moveto_USParties();
				Wait.waitfor(3);
				usparty.addParty();
				usparty.save();
				Wait.waitfor(5);
				usparty.validate_USPartiesError();
				Wait.waitfor(4);
				// Wait.waitfor(4);
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

	@Test(priority = 6)
	public void generalquestions() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqGeneralQuestionsPage question = new AgreementReqGeneralQuestionsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_AgreementReq();
				Wait.waitfor(5);
				searchAR.click_AddRequestBtn();
				// template.click_NewRequest();
				// importReq.click_Save();
				// searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_TAA(propCRs.getProperty("TAA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_QuestionnairrePage();
				question.save();
				Wait.waitfor(7);
				question.validate_GeneralQuestionsError();
				Wait.waitfor(4);
				// Wait.waitfor(4);
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

	@Test(enabled = false)
	public void exportunderagreementquestions() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqGeneralQuestionsPage question = new AgreementReqGeneralQuestionsPage(driver, test);
		AgreementReqExportsUnderAgreementPage export = new AgreementReqExportsUnderAgreementPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_TAA(propCRs.getProperty("TAA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_QuestionnairrePage();
				Wait.waitfor(3);
				question.moveto_ExportUnderAgreement();
				Wait.waitfor(3);
				export.save();
				Wait.waitfor(7);
				export.validate_ExportUnderAgreementError();
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

	@Test(enabled = false)
	public void mlaquestions() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqGeneralQuestionsPage question = new AgreementReqGeneralQuestionsPage(driver, test);
		AgreementReqMLAPage mla = new AgreementReqMLAPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_AgreementReq();
				Wait.waitfor(5);
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(7);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_MLA(propCRs.getProperty("MLA"));
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_QuestionnairrePage();
				Wait.waitfor(3);
				question.moveto_MLA();
				Wait.waitfor(3);
				mla.save();
				Wait.waitfor(7);
				mla.validate_MLAQuestionsError();
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
	public void documents() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqDocumentsOrNotesPage document = new AgreementReqDocumentsOrNotesPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(3);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_WDA();
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_DocumentsPage();
				Wait.waitfor(3);
				document.click_view_add_Document();
				Wait.waitfor(5);
				document.click_save();
				Wait.waitfor(7);
				document.validate_DocumentError();
				Wait.waitfor(4);
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

	@Test(enabled = false)
	public void notes() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqDocumentsOrNotesPage notes = new AgreementReqDocumentsOrNotesPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(5);
				searchER.click_AgreementReq();
				Wait.waitfor(5);
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(3);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_WDA();
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_DocumentsPage();
				Wait.waitfor(3);
				notes.click_addnote();
				Wait.waitfor(3);
				notes.save();
				Wait.waitfor(7);
				notes.validate_NotesError();
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

	@Test(priority = 8)
	public void submit() throws Exception {

		HomePageCRs homecrs = new HomePageCRs(driver, test);
		SearchAgreementRequestPage searchAR = new SearchAgreementRequestPage(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		AgreementSelectSBUPage selectsbu = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage template = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqSubmitPage submit = new AgreementReqSubmitPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homecrs.moveTo_ListScreening();
				homecrs.click_ComplianceRequest();
				searchER.moveTo_Features();
				searchER.click_Requests();
				searchER.click_AgreementReq();
				searchAR.click_AddRequestBtn();
				if (propCRs.getProperty("AgrSBU").length() > 0) {
					selectsbu.SelectSBU(propCRs.getProperty("AgrSBU"));
					selectsbu.clickSelect();
				}
				Wait.waitfor(5);
				template.click_NewRequest();
				Wait.waitfor(3);
				generalinfo.select_BuisnessUnit(propCRs.getProperty("AgrBuisnessUnit"));
				Wait.waitfor(3);
				generalinfo.enter_RequiredByDate(propCRs.getProperty("AgrRequiredByDate"));
				Wait.waitfor(3);
				generalinfo.enter_RequestorDetails(propCRs.getProperty("AgrRequestorName"),
						propCRs.getProperty("AgrRequestorEmail"), propCRs.getProperty("AgrRequestorPhone"),
						propCRs.getProperty("AgrRequestorEMPId"));
				Wait.waitfor(5);
				generalinfo.enter_AgreementType_WDA();
				generalinfo.click_SaveButton();
				Wait.waitfor(3);
				generalinfo.moveto_SubmitPage();
				Wait.waitfor(3);
				submit.save();
				Wait.waitfor(7);
				submit.validate_SubmitError();
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

}
