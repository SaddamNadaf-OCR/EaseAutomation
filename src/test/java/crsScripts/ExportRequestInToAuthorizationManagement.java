package crsScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.DOSListAgreementPage;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.ExportInfoCountryPage;
import crsClasses.ExportRequestAddNotesPage;
import crsClasses.ExportRequestContractsPage;
import crsClasses.ExportRequestDocumentsTabPage;
import crsClasses.ExportRequestFreightForwardersPage;
import crsClasses.ExportRequestItemsPage;
import crsClasses.ExportRequestPartiesPage;
import crsClasses.ExportRequestPortPage;
import crsClasses.ExportRequestQuestionnaireTabPage;
import crsClasses.ExportRequestSourceManufacturerPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchDSP5Page;
import crsClasses.SearchExportRequestPage;
import crsClasses.ExportSelectToImportPage;
import crsClasses.TypeOfExportPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestInToAuthorizationManagement extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExportReqImportInToAM", excel);
	}

	@Test(dataProvider = "getData")
	public void AddExportAuthRequest(String Testcase, String RunMode, String RequestorUserFirstName,
			String ExpoterStatus, String ExporterCode, String Purpose, String Summary, String CountryType,
			String AddCountry, String PartNo, String Quantity, String UnitPrice, String UnitType, String ArticleType,
			String SalesOrderLineItem, String PurchaseOrderLineItem, String ItemContractNo, String ContractLineItem,
			String SourceSystem, String SourcePartNo, String Remark1, String Remark2, String Notes,
			String CustomerStatus, String customer, String FFStatus, String SearchFFcode, String PortID,
			String PortType, String sourcetype, String ManufacturerType, String ManufacturerCode, String Approvestatus,
			String DocType, String DocDesc, String UploadfileName, String Questionnaire, String QuestionnaireAnswer,
			String ContractQuestions, String ContractAnswer, String FeesQuestions, String FeesAnswer, String SecureNote,
			String AccessLevelNote, String ExportFocalUserName, String Decision, String Determination, String SBU,
			String AuthorizationType) throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage exportAddRequestorDetails = new ExportAddRequestorDetailsPage(driver, test);
		TypeOfExportPage typeOfExport = new TypeOfExportPage(driver, test);
		ExportInfoCountryPage addcountry = new ExportInfoCountryPage(driver, test);
		ExportRequestItemsPage items = new ExportRequestItemsPage(driver, test);
		ExportRequestPartiesPage party = new ExportRequestPartiesPage(driver, test);
		ExportRequestFreightForwardersPage freightForward = new ExportRequestFreightForwardersPage(driver, test);
		ExportRequestPortPage port = new ExportRequestPortPage(driver, test);
		ExportRequestSourceManufacturerPage sourceManfture = new ExportRequestSourceManufacturerPage(driver, test);
		ExportRequestDocumentsTabPage document = new ExportRequestDocumentsTabPage(driver, test);
		ExportRequestQuestionnaireTabPage questionnaire = new ExportRequestQuestionnaireTabPage(driver, test);
		ExportRequestContractsPage contractQustn = new ExportRequestContractsPage(driver, test);
		ExportRequestAddNotesPage notes = new ExportRequestAddNotesPage(driver, test);
		ExportSelectToImportPage importExp = new ExportSelectToImportPage(driver, test);
		SearchDSP5Page searchdsp5 = new SearchDSP5Page(driver, test);
		DOSListAgreementPage list = new DOSListAgreementPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homeCRs.moveTo_ListScreening();
					homeCRs.click_ComplianceRequest();
					searchExportRequest.moveTo_Features();
					searchExportRequest.click_Requests();
					searchExportRequest.click_ExportAuthReqlink();
					searchExportRequest.click_AddRequestBtn();
					exportAddRequestorDetails.addNewRequest();
					exportAddRequestorDetails.addRequestor(RequestorUserFirstName, "", "", "");
					exportAddRequestorDetails.addLicenseOwner("Yes", "", "", "", "", "");
					exportAddRequestorDetails.addLicenseManager("Yes", "", "", "", "");
					exportAddRequestorDetails.addExporter(ExpoterStatus, ExporterCode);
					exportAddRequestorDetails.addPurpose(Purpose, Summary);
					exportAddRequestorDetails.saveExportRequest();
					exportAddRequestorDetails.clickTypeofExportLink();
					String Status = exportAddRequestorDetails.get_Status();
					if (Status.equalsIgnoreCase("In Progress")) {
						test.log(LogStatus.PASS, "Expected Status : " + Status);
					} else {
						test.log(LogStatus.FAIL, "Expected Status : " + Status);
						testFail();
						softAssertion.assertTrue(false);
					}
					typeOfExport.ExportRequestType();
					typeOfExport.AgreementReExportsReTransfers();
					typeOfExport.TechnicalDataExport();
					typeOfExport.Services();
					typeOfExport.saveTypeOfExport();
					exportAddRequestorDetails.clickOnGeneralDescription();
					exportAddRequestorDetails.click_ExportInfo();
					Wait.waitfor(5);
					if (AddCountry.length() > 0) {
						exportAddRequestorDetails.clickOnCountryLink();
						addcountry.addCountry(CountryType, AddCountry);
						Wait.waitfor(5);
					}
					if (PartNo.length() > 0) {
						exportAddRequestorDetails.addItemLink();
						items.addItems(PartNo, Quantity, UnitPrice, UnitType, ArticleType, SalesOrderLineItem,
								PurchaseOrderLineItem, ItemContractNo, ContractLineItem, SourceSystem, SourcePartNo,
								Remark1, Remark2, Notes);
						items.click_ItemSaveandReturn();
						exportAddRequestorDetails.exportInfoAddItemToResultsGrid(PartNo);
					}
					if (customer.length() > 0) {
						exportAddRequestorDetails.addPartiesLink();
						party.addPartyCustomer(CustomerStatus, customer);
						party.saveAndReturn();
						exportAddRequestorDetails.exportInfoaddPartiesToResultsGrid(customer);
					}
					if (SearchFFcode.length() > 0) {
						exportAddRequestorDetails.addFreightFowarders();
						freightForward.addFreightForwarder(FFStatus, SearchFFcode);
						freightForward.click_FFSaveAndReturnBtn();
						exportAddRequestorDetails.exportInfoaddFreightForwarderToResultsGrid(SearchFFcode);
					}
					if (PortID.length() > 0) {
						exportAddRequestorDetails.addPorts();
						port.addport(PortID, PortType);
						port.click_PortSaveAndReturnBtn();
						exportAddRequestorDetails.exportInfoaddPortToResultsGrid(PortID);
					}
					if (ManufacturerCode.length() > 0) {
						exportAddRequestorDetails.addSourceManufacturer();
						sourceManfture.addSourceInfo(sourcetype, ManufacturerType, ManufacturerCode, Approvestatus);
						sourceManfture.clickSaveandReturn();
						exportAddRequestorDetails.exportInfoSourceManfturToResultsGrid(ManufacturerCode);
					}
					if (UploadfileName.length() > 0) {
						exportAddRequestorDetails.addDocument();
						document.uploadDoc(DocType, DocDesc, UploadfileName);
						exportAddRequestorDetails.exportInfoDocumentToResultsGrid(UploadfileName);
					}
					exportAddRequestorDetails.addAdditionalInfo();
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
					Wait.waitfor(3);
					exportAddRequestorDetails.addContracts();
					if (ContractQuestions.length() > 0) {
						ArrayList<String> contractque = GenericMethods.stringtoken(ContractQuestions);
						ArrayList<String> contAns = GenericMethods.stringtoken(ContractAnswer);
						for (int i = 0; i < contractque.size(); i++) {
							contractQustn.contractsQuestions(contractque.get(i), contAns.get(i));
						}
						contractQustn.click_SaveContract();
					} else {
						test.log(LogStatus.INFO, "Contract Questions is skipped");
					}
					if (FeesQuestions.length() > 0) {
						ArrayList<String> feesque = GenericMethods.stringtoken(FeesQuestions);
						ArrayList<String> feesAns = GenericMethods.stringtoken(FeesAnswer);
						for (int i = 0; i < feesque.size(); i++) {
							contractQustn.feesQuestions(feesque.get(i), feesAns.get(i));
						}
						contractQustn.click_SaveContract();
					} else {
						test.log(LogStatus.INFO, "Fees Questions is skipped");
					}
					exportAddRequestorDetails.submitRequest();
					exportAddRequestorDetails.addNotesBtn();
					notes.add_SecureNote(SecureNote, AccessLevelNote);
					notes.clickSavandReturn();
					notes.addNoteToResultsGrid(SecureNote);
					exportAddRequestorDetails.click_submitTab();
					exportAddRequestorDetails.Add_ExportFocalPoint(ExportFocalUserName);
					exportAddRequestorDetails.click_submitForReview();
					exportAddRequestorDetails.click_ExportStatus();
					String requestID = exportAddRequestorDetails.get_RequestID();
					exportAddRequestorDetails.add_ExportStatus(Decision, Determination);
					if (Decision.contains("Returned For Rework")) {
						exportAddRequestorDetails.alertReturnedForRework();
						String finalStatus = exportAddRequestorDetails.get_Status();
						if (finalStatus.equalsIgnoreCase("Additional Information Request")) {
							test.log(LogStatus.PASS, "Expected Status : " + Decision);
						} else {
							test.log(LogStatus.FAIL, "Expected Status : " + Decision);
							testFail();
							softAssertion.assertTrue(false);
						}
						exportAddRequestorDetails.click_submitForReview();
						exportAddRequestorDetails.click_ExportStatus();
					} else if (Decision.contains("Disapproved")) {
						String finalStatus = exportAddRequestorDetails.get_Status();
						if (finalStatus.equalsIgnoreCase("Denied")) {
							test.log(LogStatus.PASS, "Expected Status : " + Decision);
						} else {
							test.log(LogStatus.FAIL, "Expected Status : " + Decision);
							testFail();
							softAssertion.assertTrue(false);
						}
					} else if (Decision.contains("Export Hold License Required")) {
						String finalStatus = exportAddRequestorDetails.get_Status();
						if (finalStatus.equalsIgnoreCase("Export Hold - License Required")) {
							test.log(LogStatus.PASS, "Expected Status : " + Decision);
						} else {
							test.log(LogStatus.FAIL, "Expected Status : " + Decision);
							testFail();
							softAssertion.assertTrue(false);
						}
					} else {
						String finalStatus = exportAddRequestorDetails.get_Status();
						if (finalStatus.equalsIgnoreCase(Decision)) {
							test.log(LogStatus.PASS, "Expected Status : " + Decision);
						} else {
							test.log(LogStatus.FAIL, "Expected Status : " + Decision);
							testFail();
							softAssertion.assertTrue(false);
						}
					}
					Wait.waitfor(4);
					exportAddRequestorDetails.click_importIntoAuthorizationApp();
					exportAddRequestorDetails.select_AuthorizationType(AuthorizationType);
					exportAddRequestorDetails.click_UseExportReqID();
					exportAddRequestorDetails.click_SaveImportInfo();
					String TransationID1 = exportAddRequestorDetails.get_TransationID();
					if (TransationID1.equalsIgnoreCase(requestID)) {
						test.log(LogStatus.PASS, "Expected Status : " + requestID);
					} else {
						test.log(LogStatus.FAIL, "Expected Status : " + requestID);
						testFail();
						softAssertion.assertTrue(false);
					}
					exportAddRequestorDetails.click_ImportAll();
					importExp.click_selectAll();
					importExp.click_Import();
					importExp.validate_SelectToImport();
					Wait.waitfor(5);
					homeCRs.moveTo_ListScreening();
					homeCRs.click_DOSLicensing();
					Wait.waitfor(3);
					searchdsp5.moveTo_Features();
					searchdsp5.select_SBU(SBU, TransationID1);
					searchdsp5.click_SearchBtn();
					list.transationIdIsDisplayed(TransationID1);
					homeCRs.moveTo_ListScreening();
					homeCRs.click_ComplianceRequest();
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
			homeCRs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
}
