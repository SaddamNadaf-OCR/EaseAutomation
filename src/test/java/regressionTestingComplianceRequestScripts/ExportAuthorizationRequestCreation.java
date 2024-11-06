package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Oct 2023
 * Descriptions : Export Authorization Request Creation
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AgreementReqGeneralQuestionsPage;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.ExportGeneralDescriptionPage;
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
import crsClasses.ExportResultsExportRequestPage;
import crsClasses.FTAdditionalInfoAdditionalQuestionsPage;
import crsClasses.HomePageCRs;
import crsClasses.ImportSelectSBUPage;
import crsClasses.SearchExportRequestPage;
import crsClasses.TypeOfExportPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class ExportAuthorizationRequestCreation extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExportRequestTransactionAdding", excel);
	}

	@Test(dataProvider = "getData")
	public void AddExportAuthRequest(String Testcase, String RunMode,String SBU1, String RequestorUserFirstName,
			String RequestorName, String RequestorEmail, String RequestorPhone, String LOSameAsRequestor,
			String LOFirstName, String LicenseOwner, String LOEmpID, String LOEmail, String LOPhone,
			String LMSameAsRequestor, String LMFirstName, String LicenseManager, String LMEmail, String LMPhone,
			String ExpoterStatus, String ExporterCode, String Purpose, String Summary, String SiteId, String Department,
			String Program, String Segment, String ProductFamily, String ProductLines, String SalesNO,
			String PurchaseNo, String ContractNo, String FMSCaseNo, String InternalTrackingNo, String CountryType,
			String AddCountry, String PartNo, String Quantity, String UnitPrice, String UnitType, String ArticleType,
			String SalesOrderLineItem, String PurchaseOrderLineItem, String ItemContractNo, String ContractLineItem,
			String SourceSystem, String SourcePartNo, String Remark1, String Remark2, String Notes,
			String CustomerStatus, String customer, String FFStatus, String SearchFFcode, String PortID,
			String PortType, String sourcetype, String ManufacturerType, String ManufacturerCode, String Approvestatus,
			String DocType, String DocDesc, String UploadfileName, String Questionnaire, String QuestionnaireAnswer,
			String ContractQuestions, String ContractAnswer, String FeesQuestions, String FeesAnswer, String SecureNote,
			String AccessLevelNote, String ExportFocalUserName, String Decision, String Determination, String SBU)
			throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage exportAddRequestorDetails = new ExportAddRequestorDetailsPage(driver, test);
		TypeOfExportPage typeOfExport = new TypeOfExportPage(driver, test);
		ExportGeneralDescriptionPage exportGeneralDescription = new ExportGeneralDescriptionPage(driver, test);
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
		ExportResultsExportRequestPage exportResults = new ExportResultsExportRequestPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();
		ImportSelectSBUPage      selectsbu     = new ImportSelectSBUPage(driver,test);
		FTAdditionalInfoAdditionalQuestionsPage ft =new FTAdditionalInfoAdditionalQuestionsPage(driver,test);
		AgreementReqGeneralQuestionsPage question = new AgreementReqGeneralQuestionsPage(driver, test);

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
					Wait.waitfor(3);
					exportAddRequestorDetails.addNewRequest();
					exportAddRequestorDetails.addRequestor(RequestorUserFirstName, RequestorName, RequestorEmail,
							RequestorPhone);
					exportAddRequestorDetails.addLicenseOwner(LOSameAsRequestor, LOFirstName, LicenseOwner, LOEmpID,
							LOEmail, LOPhone);
					exportAddRequestorDetails.addLicenseManager(LMSameAsRequestor, LMFirstName, LicenseManager, LMEmail,
							LMPhone);
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
					Wait.waitfor(3);
					exportGeneralDescription.select_Site(SiteId);
					exportGeneralDescription.select_Department(Department);
					exportGeneralDescription.select_Program(Program);
					exportGeneralDescription.select_Segment(Segment);
					exportGeneralDescription.select_ProductFamily(ProductFamily);
					exportGeneralDescription.select_ProductLines(ProductLines);
					exportGeneralDescription.add_GeneralDesc(SalesNO, PurchaseNo, ContractNo, FMSCaseNo,
							InternalTrackingNo);
					exportGeneralDescription.clickOnSaveBtn();
					exportAddRequestorDetails.click_ExportInfo();
					exportAddRequestorDetails.clickOnCountryLink();
					addcountry.addCountry(CountryType, AddCountry);
					Wait.waitfor(3);
					addcountry.countryGrid();
					Wait.waitfor(3);
					exportAddRequestorDetails.addItemLink();
					Wait.waitfor(3);
					items.addItems(PartNo, Quantity, UnitPrice, UnitType, ArticleType, SalesOrderLineItem,
							PurchaseOrderLineItem, ItemContractNo, ContractLineItem, SourceSystem, SourcePartNo,
							Remark1, Remark2, Notes);
					Wait.waitfor(10);
					items.click_ItemSaveandReturn();
					Wait.waitfor(3);
					exportAddRequestorDetails.exportInfoAddItemToResultsGrid(PartNo);
					exportAddRequestorDetails.addPartiesLink();
					party.addPartyCustomer(CustomerStatus, customer);
					Wait.waitfor(3);
					party.saveAndReturn();
					Wait.waitfor(3);
					exportAddRequestorDetails.exportInfoaddPartiesToResultsGrid(customer);
					exportAddRequestorDetails.addFreightFowarders();
					freightForward.addFreightForwarder(FFStatus, SearchFFcode);
					Wait.waitfor(3);
					freightForward.click_FFSaveAndReturnBtn();
					exportAddRequestorDetails.exportInfoaddFreightForwarderToResultsGrid(SearchFFcode);
					Wait.waitfor(3);
					exportAddRequestorDetails.addPorts();
					Wait.waitfor(3);
					port.addport(PortID, PortType);
					Wait.waitfor(3);
					port.click_PortSaveAndReturnBtn();
					exportAddRequestorDetails.exportInfoaddPortToResultsGrid(PortID);
					exportAddRequestorDetails.addSourceManufacturer();
					sourceManfture.addSourceInfo(sourcetype, ManufacturerType, ManufacturerCode, Approvestatus);
					Wait.waitfor(3);
					sourceManfture.clickSaveandReturn();
					exportAddRequestorDetails.exportInfoSourceManfturToResultsGrid(ManufacturerCode);
					exportAddRequestorDetails.addDocument();
					document.uploadDoc(DocType, DocDesc, UploadfileName);
					exportAddRequestorDetails.exportInfoDocumentToResultsGrid(UploadfileName);
					exportAddRequestorDetails.addAdditionalInfo();
					if (Questionnaire.length() > 0) {
						ArrayList<String> questions = GenericMethods.stringtoken(Questionnaire);
						ArrayList<String> questionnaireAnswer = GenericMethods.stringtoken(QuestionnaireAnswer);
						for (int i = 0; i < questions.size(); i++) {
							questionnaire.addQuestionnaire(questions.get(i), questionnaireAnswer.get(i));
						}
						Wait.waitfor(3);
						try {
							questionnaire.notapplicable();
						}catch(Exception e) {
							test.log(LogStatus.INFO, "Additional Questionnaire is Skiped :");
						}
						Wait.waitfor(3);
						questionnaire.click_SaveQuestion();
					} else {
						test.log(LogStatus.INFO, "Questionnaire is skipped");
					}
					questionnaire.moveForward();
					Wait.waitfor(3);
					//exportAddRequestorDetails.addContracts();
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
					Wait.waitfor(5);
					if (FeesQuestions.length() > 0) {
						ArrayList<String> Feesque = GenericMethods.stringtoken(FeesQuestions);
						ArrayList<String> FeesAns = GenericMethods.stringtoken(FeesAnswer);
						for (int i = 0; i < Feesque.size(); i++) {
							contractQustn.feesQuestions(Feesque.get(i), FeesAns.get(i));
						}
						contractQustn.click_SaveContract();
					} else {
						test.log(LogStatus.INFO, "Fees Questions is skipped");
					}
					Wait.waitfor(3);
					exportAddRequestorDetails.addAdditionalQuestions();
					Wait.waitfor(3);
					/*exportAddRequestorDetails.submitRequest();
					Wait.waitfor(3);
					exportAddRequestorDetails.addAdditionalInfo();
					Wait.waitfor(3);
					exportAddRequestorDetails.addAdditionalQuestions();
					Wait.waitfor(3);*/
					ft.click_notapplicable();
					ft.save();
					/*if (FeesQuestions.length() > 0) {
						ArrayList<String> feesque = GenericMethods.stringtoken(FeesQuestions);
						ArrayList<String> feesAns = GenericMethods.stringtoken(FeesAnswer);
						for (int i = 0; i < feesque.size(); i++) {
							contractQustn.feesQuestions(feesque.get(i), feesAns.get(i));
						}
						contractQustn.click_SaveContract();
					} else {
						test.log(LogStatus.INFO, "Fees Questions is skipped");
					}*/
					exportAddRequestorDetails.submitRequest();
					Wait.waitfor(3);
					exportAddRequestorDetails.addNotesBtn();
					Wait.waitfor(3);
					notes.add_SecureNote(SecureNote, AccessLevelNote);
					Wait.waitfor(3);
					notes.clickSavandReturn();
					Wait.waitfor(3);
					notes.addNoteToResultsGrid(SecureNote);
					Wait.waitfor(3);
					exportAddRequestorDetails.click_submitTab();
					Wait.waitfor(3);
					Boolean technicalFocalPoint = exportAddRequestorDetails.technicalFocalPoint();
					if(technicalFocalPoint.equals(true)) {
						exportAddRequestorDetails.Add_TechnicalFocalPoint(ExportFocalUserName);
					}else {
						exportAddRequestorDetails.Add_ExportFocalPoint(ExportFocalUserName);
					}
					exportAddRequestorDetails.click_submitForReview();
					exportAddRequestorDetails.click_ExportStatus();
					String requestID = exportAddRequestorDetails.get_RequestID();
					Boolean enabledsaveButton = exportAddRequestorDetails.saveandFinalizedEnabled();
					if(enabledsaveButton.equals(true)) {
						exportAddRequestorDetails.Add_ExportFocalPoint(ExportFocalUserName);
						exportAddRequestorDetails.techFocusDecion(Decision);
					}else {
						exportAddRequestorDetails.Add_TechnicalFocalPoint(ExportFocalUserName);
						exportAddRequestorDetails.add_ExportStatus(Decision, Determination);
					}					
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
					homeCRs.returnToCRPage();
					searchExportRequest.moveTo_Features();
					searchExportRequest.click_Requests();
					searchExportRequest.click_ExportAuthReqlink();
					searchExportRequest.typeRequestID(SBU, requestID);
					searchExportRequest.click_SearchBtn();
					exportResults.titleIsDisplayed();
					Wait.waitfor(4);
					homeCRs.returnToCRPage();
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
