package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ImportResultsImportRequestPage;
import crsClasses.ImportSearchImportRequestPage;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ImportRequestSearchResults extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ImportSearchResults", excel);
	}

	@Test(dataProvider = "getData")
	public void ImportReq(String Testcase, String RunMode, String SbuID, String AuthorizationID, String RequestID,
			String LicenseAppNo, String Status, String Determination, String RequestorName, String ReviewerName,
			String RequestorDateFrom, String RequestorDateTo, String ReviewDateFrom, String ReviewDateTo, 
			String ActivityType, String AutorizationType, String AuthorizationNo, String Segment, String Site,
			String ProductLine, String ProductFamily, String Program, String Country, String Customer, 
			String OSRnumber, String Priority, String SubmitDateFrom, String SubmitDateTo, String SalesOrderNo)
			throws Exception {

		HomePageCRs						home     = new HomePageCRs(driver, test);
		SearchExportRequestPage     	searchER = new SearchExportRequestPage(driver, test);
		ImportSearchImportRequestPage 	searchIR = new ImportSearchImportRequestPage(driver, test);
		ImportResultsImportRequestPage	resultIR = new ImportResultsImportRequestPage(driver, test);

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
					searchIR.searchParameters(SbuID, AuthorizationID, RequestID, LicenseAppNo, Status, Determination,
							RequestorName, ReviewerName, RequestorDateFrom, RequestorDateTo, ReviewDateFrom, ReviewDateTo,
							ActivityType, AutorizationType, AuthorizationNo, Segment, Site, ProductLine, ProductFamily, 
							Program, Country, Customer, OSRnumber, Priority, SubmitDateFrom, SubmitDateTo, SalesOrderNo);
					searchIR.click_SearchBtn();
					resultIR.titleIsDisplayed();
					Wait.waitfor(3);
					home.returnToCRPage();
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