package crsScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.DOSListAgreementPage;
import crsClasses.HomePageCRs;
import crsClasses.ImportAddCountryPage;
import crsClasses.ImportAddPartyPage;
import crsClasses.ImportHardwareTechDataImportFreightForwarderPage;
import crsClasses.ImportHardwareTechDataPortPage;
import crsClasses.ImportHardwareTechDataServicesItemsPage;
import crsClasses.ImportNotesPage;
import crsClasses.ImportRequestPage;
import crsClasses.ImportRequestQuestionnairePage;
import crsClasses.ImportSearchImportRequestPage;
import crsClasses.ImportSelectToImportPage;
import crsClasses.ImportTemplatePage;
import crsClasses.SearchDSP5Page;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class ImportRequestInToAuthorizationManagement extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ImportReqImportInToAM", excel);
	}

	@Test(dataProvider = "getData")
	public void ImportReq(String Testcase, String RunMode, String BusinessUnit, String ImportRequiredDate,
			String RequestorUserFirstName, String Licensepurpose, String SummaryPurposeImpReq, String AddCountry,
			String CountryType, String PartNo, String Quantity, String UnitPrice, String UnitType,
			String CommodityDescription, String CommodityClassification, String CommodityCode, String ArticleType,
			String SalesOrderLineItem, String PurchaseOrderLineItem, String ItemContractNo, String ContractLineItem,
			String SourceSystem, String SourcePartNo, String Remark1, String Remark2, String Notes,
			String PartiesStatus, String PartiesCode, String FFStatus, String SearchFFcode, String PortID,
			String PortType, String DocumentType, String UploadfileName, String DocumentLocationPath,
			String Questionnaire, String QuestionnaireAnswer, String ContractQuestions, String ContractAnswer,
			String FeesQuestions, String FeesAnswer, String SecureNote, String AccessLevelNote,
			String ImportRepresentative, String ImportStatus, String Determination, String ApproverPhone,
			String Priority, String SbuID, String LicenseType, String TemplateName) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage searchIR = new ImportSearchImportRequestPage(driver, test);
		ImportTemplatePage template = new ImportTemplatePage(driver, test);
		ImportRequestPage importReq = new ImportRequestPage(driver, test);
		ImportAddCountryPage addCountry = new ImportAddCountryPage(driver, test);
		ImportHardwareTechDataServicesItemsPage htsItems = new ImportHardwareTechDataServicesItemsPage(driver, test);
		ImportAddPartyPage addParty = new ImportAddPartyPage(driver, test);
		ImportHardwareTechDataImportFreightForwarderPage freightforwd = new ImportHardwareTechDataImportFreightForwarderPage(
				driver, test);
		ImportHardwareTechDataPortPage port = new ImportHardwareTechDataPortPage(driver, test);
		ImportRequestQuestionnairePage questionnaire = new ImportRequestQuestionnairePage(driver, test);
		ImportNotesPage notes = new ImportNotesPage(driver, test);
		ImportSelectToImportPage importImp = new ImportSelectToImportPage(driver, test);
		SearchDSP5Page searchdsp5 = new SearchDSP5Page(driver, test);
		DOSListAgreementPage list = new DOSListAgreementPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		// **********Test steps execution ***************************
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
					searchER.click_ImportReq();
					searchIR.click_AddRequest();
					template.click_NewRequest();
					String Status = importReq.get_Status();
					if (Status.equalsIgnoreCase("In Progress")) {
						test.log(LogStatus.PASS, "Expected Status : " + Status);
					} else {
						test.log(LogStatus.FAIL, "Expected Status : " + Status);
						testFail();
						softAssertion.assertTrue(false);
					}
					importReq.addImportRequest(BusinessUnit, ImportRequiredDate);
					importReq.addRequestor(RequestorUserFirstName, "", "", "");
					importReq.addLicenseOwner("Yes", "", "", "", "", "");
					importReq.addLicenseManager("Yes", "", "", "", "");
					importReq.licensePurpose(Licensepurpose, SummaryPurposeImpReq);
					importReq.click_Save();
					importReq.click_TypeOfExport();
					importReq.get_RequestID();
					importReq.get_Status();
					importReq.click_typeOfImport();
					importReq.technicalDataImport();
					importReq.click_saveTypeOfImport();
					importReq.click_GeneralDescription();
					importReq.click_ImportInfoTab();
					importReq.click_AddCountry();
					addCountry.selectAddcountry(AddCountry, CountryType);

					ArrayList<String> country = GenericMethods.stringtoken(AddCountry);
					for (int i = 0; i < country.size(); i++) {
						importReq.addcountryToResultsGrid(country.get(i).trim());
					}
					importReq.click_ItemsTab();
					importReq.click_AddItemsBtn();
					htsItems.addItem(PartNo, Quantity, UnitPrice, UnitType, CommodityDescription,
							CommodityClassification, CommodityCode, ArticleType, SalesOrderLineItem,
							PurchaseOrderLineItem, ItemContractNo, ContractLineItem, SourceSystem, SourcePartNo,
							Remark1, Remark2, Notes);
					htsItems.click_ItemSaveAndReturnBtn();
					importReq.addItemToResultsGrid(PartNo);
					importReq.click_PartiesTab();
					importReq.click_AddPartiesBtn();
					addParty.addParty(PartiesStatus, PartiesCode);
					addParty.click_PartySaveAndReturn();
					importReq.addPartiesToResultsGrid(PartiesCode);
					importReq.click_FreightForwardersTab();
					importReq.click_AddFreightForwdBtn();
					freightforwd.addFreightForwarder(FFStatus, SearchFFcode);
					freightforwd.click_FFSaveAndReturnBtn();
					importReq.addFreightForwarderToResultsGrid(SearchFFcode);
					importReq.click_PortsTab();
					importReq.click_AddPortsBtn();
					port.addport(PortID, PortType);
					port.click_ItemSaveBtn();
					port.click_ItemSaveAndReturnBtn();
					importReq.addPortToResultsGrid(PortID);
					importReq.click_DocumentTab();
					importReq.click_AddDocumentBtn();
					importReq.addDocument(DocumentType, UploadfileName, DocumentLocationPath);
					importReq.click_AdditionalInfoTab();
					if (Questionnaire.length() > 0) {
						ArrayList<String> questions = GenericMethods.stringtoken(Questionnaire);
						ArrayList<String> questionnaireAnswer = GenericMethods.stringtoken(QuestionnaireAnswer);
						for (int i = 0; i < questions.size(); i++) {
							questionnaire.addQuestionnaire(questions.get(i), questionnaireAnswer.get(i));
						}
						questionnaire.click_SaveQuestion();
					} else {
						test.log(LogStatus.INFO, "Questionnaire is skipped");
					}
					importReq.click_ContractsTab();
					if (ContractQuestions.length() > 0) {
						ArrayList<String> contractque = GenericMethods.stringtoken(ContractQuestions);
						ArrayList<String> contAns = GenericMethods.stringtoken(ContractAnswer);
						for (int i = 0; i < contractque.size(); i++) {
							questionnaire.contractsQuestions(contractque.get(i), contAns.get(i));
						}
						questionnaire.click_SaveContract();
					} else {
						test.log(LogStatus.INFO, "Contract Questions is skipped");
					}
					if (FeesQuestions.length() > 0) {
						ArrayList<String> feesque = GenericMethods.stringtoken(FeesQuestions);
						ArrayList<String> feesAns = GenericMethods.stringtoken(FeesAnswer);
						for (int i = 0; i < feesque.size(); i++) {
							questionnaire.feesQuestions(feesque.get(i), feesAns.get(i));
						}
						questionnaire.click_SaveContract();
					} else {
						test.log(LogStatus.INFO, "Fees Questions is skipped");
					}
					importReq.click_SubmitReqTab();
					importReq.click_AddNoteBtn();
					notes.add_SecureNote(SecureNote, AccessLevelNote);
					notes.click_SaveAndReturn();
					notes.addNoteToResultsGrid(SecureNote);
					importReq.click_SubmitTab();
					importReq.select_ImportRep(ImportRepresentative);
					importReq.click_SubmitForReview();
					importReq.click_ImportStatusTab();
					/*
					 * importReq.addImportStatusInfo(ImportStatus, Determination, ApproverPhone,
					 * Priority); importReq.click_ImportStatusSaveButton();
					 */
					Wait.waitfor(3);
					String requestID = importReq.get_RequestID();
					importReq.importIntoLicenseApp();
					importReq.addImportIntoLA(LicenseType, TemplateName);
					importReq.click_saveImportInfo();
					String TransationID1 = importReq.get_TransationID();
					if (TransationID1.equalsIgnoreCase(requestID)) {
						test.log(LogStatus.PASS, "Expected Status : " + requestID);
					} else {
						test.log(LogStatus.FAIL, "Expected Status : " + requestID);
						testFail();
						softAssertion.assertTrue(false);
					}
					importReq.click_ImportAllBtn();
					importImp.click_selectAll();
					importImp.click_Import();
					importImp.validate_SelectToImport();
					Wait.waitfor(5);
					home.moveTo_ListScreening();
					home.click_DOSLicensing();
					Wait.waitfor(3);
					searchdsp5.moveTo_Features();
					searchdsp5.select_SBU(SbuID, TransationID1);
					searchdsp5.click_SearchBtn();
					list.transationIdIsDisplayed(TransationID1);
					Wait.waitfor(3);
					home.moveTo_ListScreening();
					home.click_ComplianceRequest();
					softAssertion.assertAll();
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
