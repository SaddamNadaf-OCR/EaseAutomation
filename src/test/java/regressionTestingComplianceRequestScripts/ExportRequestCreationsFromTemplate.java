package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Oct 2023
 * Descriptions : Export Request Creation From Template
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.ExportResultsExportRequestPage;
import crsClasses.HomePageCRs;
import crsClasses.ImportSelectSBUPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestCreationsFromTemplate extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExportReqCreationFromTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void exportReq(String Testcase, String RunMode,String SBU1, String TemplateName, String RequestorUserFirstName, String RequestorName, 
			String RequestorEmail, String RequestorPhone, String ExportFocalUserName, String Decision, String Determination, 
			String SBU) throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage exportAddRequestorDetails = new ExportAddRequestorDetailsPage(driver, test);
		ExportResultsExportRequestPage exportResults = new ExportResultsExportRequestPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();
		ImportSelectSBUPage            selectsbu     = new ImportSelectSBUPage(driver,test);

		// **********Test steps execution ***************************
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
					exportAddRequestorDetails.select_template(TemplateName);
					Wait.waitfor(3);
					exportAddRequestorDetails.addRequestor(RequestorUserFirstName, RequestorName, RequestorEmail,
							RequestorPhone);
					exportAddRequestorDetails.saveExportRequest();
					String Status = exportAddRequestorDetails.get_Status();
					if (Status.equalsIgnoreCase("In Progress")) {
						test.log(LogStatus.PASS, "Expected Status : " + Status);
					} else {
						test.log(LogStatus.FAIL, "Expected Status : " + Status);
						testFail();
						softAssertion.assertTrue(false);
					}
					exportAddRequestorDetails.submitRequest();
					exportAddRequestorDetails.click_submitTab();
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
					exportResults.requestIDIsDisplayed(requestID);
					Wait.waitfor(4);
					homeCRs.returnToCRPage();
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
			homeCRs.returnToCRPage();
			Assert.assertTrue(false);
		}
	}
}