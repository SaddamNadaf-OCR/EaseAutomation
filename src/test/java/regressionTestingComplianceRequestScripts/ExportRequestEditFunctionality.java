package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2023
 * Descriptions : Export Request Edit Functionality
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.ExportAddRequestorDetailsPage;
import crsClasses.ExportResultsExportRequestPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestEditFunctionality extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExportReqEdit", excel);
	}

	@Test(dataProvider = "getData")
	public void editAgreementRequestForm(String Testcase, String RunMode, String SBU, String Status, String LOSameAsRequestor, 
			String LOFirstName, String LicenseOwner, String LOEmpID, String LOEmail, String LOPhone, String ExpoterStatus, 
			String ExporterCode, String Purpose, String Summary) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		ExportAddRequestorDetailsPage generalinfo = new ExportAddRequestorDetailsPage(driver, test);
		ExportResultsExportRequestPage result = new ExportResultsExportRequestPage(driver, test);
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
				searchER.click_ExportAuthReqlink();
				searchER.SBUSearch(SBU,Status);
				searchER.click_SearchBtn();
				Wait.waitfor(3);
				searchER.click_RequestID();
				Wait.waitfor(3);
				searchER.geninfoTab();
				generalinfo.addLicenseOwner(LOSameAsRequestor, LOFirstName, LicenseOwner, LOEmpID, LOEmail, LOPhone);
				generalinfo.addExporter(ExpoterStatus, ExporterCode);
				generalinfo.addPurpose(Purpose, Summary);
				generalinfo.saveExportRequest();
				Wait.waitfor(3);
				String requestID = generalinfo.get_RequestID();
				home.returnToCRPage();
				Wait.waitfor(3);
				searchER.moveTo_Features();
				searchER.click_Requests();
				Wait.waitfor(3);
				searchER.click_ExportAuthReqlink();		
				searchER.RequestID(requestID);
				searchER.click_SearchBtn();
				result.titleIsDisplayed();
				result.requestIDIsDisplayed(requestID);
				Wait.waitfor(5);
				home.returnToCRPage();
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
