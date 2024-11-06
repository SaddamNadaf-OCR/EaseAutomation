package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ImportAddPartyPage;
import crsClasses.ImportRequestPage;
import crsClasses.ImportResultsImportRequestPage;
import crsClasses.ImportSearchImportRequestPage;
import crsClasses.ImportSelectSBUPage;
import crsClasses.ImportTemplatePage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;


public class ImportRequestCreationsFromTemplate extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ImportReqCreationFromTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void ImportReq(String Testcase, String RunMode,String SBU, String selectTemplate, String BusinessUnit,
			String ImportRequiredDate, String LOSameAsRequestor, String LMSameAsRequestor,String PartiesStatus,
			String PartiesCode,	String ImportRepresentative, String ImportStatus, String Determination,
			String ApproverPhone, String Priority, String SbuID)throws Exception {

		HomePageCRs							home          = new HomePageCRs(driver, test);
		SearchExportRequestPage     		searchER      = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage 		searchIR      = new ImportSearchImportRequestPage(driver, test);
		ImportTemplatePage					template      = new ImportTemplatePage(driver, test);
		ImportRequestPage					importReq     = new ImportRequestPage(driver, test);	
		ImportAddPartyPage 					addParty      = new ImportAddPartyPage(driver, test);
		ImportResultsImportRequestPage		resultIR	  = new ImportResultsImportRequestPage(driver, test);
		SoftAssert 							softAssertion = new SoftAssert();
		ImportSelectSBUPage                 selectsbu     = new ImportSelectSBUPage(driver,test);

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
					Wait.waitfor(3);
					if(SBU.length()>0) {
						selectsbu.SelectSBU(SBU);
						selectsbu.clickSelect();
					}
					Wait.waitfor(3);
					template.select_template(selectTemplate);
					template.click_SelectBtn();					
					String Status = importReq.get_Status();
					if(Status.equalsIgnoreCase("In Progress")) {
						test.log(LogStatus.PASS, "Expected Status : "+Status);
					}else {
						test.log(LogStatus.FAIL, "Expected Status : "+Status);
						testFail();
						softAssertion.assertTrue(false);
					}					
					importReq.addImportRequest(BusinessUnit, ImportRequiredDate);
					importReq.addLicenseOwner(LOSameAsRequestor, "", "", "", "", "");
					importReq.addLicenseManager(LMSameAsRequestor, "", "", "", "");			
					importReq.click_Save();		
					/*Wait.waitfor(3);
					importReq.click_ImportInfoTab();	
					Wait.waitfor(3);
					importReq.click_PartiesTab();
					importReq.click_AddPartiesBtn();
					addParty.addParty(PartiesStatus, PartiesCode);
					addParty.click_PartySaveAndReturn();
					importReq.addPartiesToResultsGrid(PartiesCode);					
					importReq.click_AdditionalInfoTab();*/
					importReq.click_SubmitReqTab();
					importReq.click_SubmitTab();
					importReq.select_ImportRep(ImportRepresentative);
					importReq.click_SubmitForReview();					
					importReq.click_ImportStatusTab();
					importReq.addImportStatusInfo(ImportStatus, Determination, ApproverPhone, Priority);
					importReq.click_ImportStatusSaveButton();
					Wait.waitfor(3);
					String requestID = importReq.get_RequestID();
					String finalStatus = importReq.get_Status();
					if(finalStatus.equalsIgnoreCase(ImportStatus)) {
						test.log(LogStatus.PASS, "Expected Status : "+ImportStatus);
					}else {
						test.log(LogStatus.FAIL, "Expected Status : "+ImportStatus);
						testFail();
						softAssertion.assertTrue(false);
					}				
					importReq.click_ImportStatusCancleButton();
					searchER.moveTo_Features();
					searchER.click_ImportReq();					
					searchIR.selectSbuID(SbuID,requestID);
					searchIR.click_SearchBtn();
					resultIR.titleIsDisplayed();
					resultIR.requestIDIsDisplayed(requestID);			
					Wait.waitfor(5);
					home.returnToCRPage();
					softAssertion.assertAll();
					} else {
						test.log(LogStatus.SKIP, "Please check the run mode");
						throw new SkipException("Skipping the test");
					}
				}
			} catch (SkipException s) {				
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