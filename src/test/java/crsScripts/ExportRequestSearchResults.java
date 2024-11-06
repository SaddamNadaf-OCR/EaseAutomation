
package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import crsClasses.ExportResultsExportRequestPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestSearchResults extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ExportSearchResults", excel);
	}

	@Test(dataProvider = "getData")
	public void exportReq(String Testcase, String RunMode, String SBUCode, String AuthorizationID, String RequestID,
			String LicenseAppNo, String CaseNo, String Purpose, String Status, String Determination,
			String RequestorName, String ExportFocalPoint, String RequestDateFrom, String RequestDateTo,
			String ReviewDateFrom, String ReviewDateTo, String Activity, String AuthorizationNo, String Segment,
			String Site, String ProductLine, String ProductFamily, String Program, String Customer, String OSRNumber,
			String ReasonforReturn, String TechnicalFocalPoint, String Country, String Priority, String SortBy,
			String SubmitDateFrom, String SubmitDateTo, String SalesOrderNo, String SalesOrderitems,
			String SalesOrderLineItem) throws Exception {

		HomePageCRs homeCRs = new HomePageCRs(driver, test);
		SearchExportRequestPage searchExportRequest = new SearchExportRequestPage(driver, test);
		ExportResultsExportRequestPage exportResults = new ExportResultsExportRequestPage(driver, test);

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
					searchExportRequest.SearchExportReqDetails(SBUCode, AuthorizationID, RequestID, LicenseAppNo,
							CaseNo, Purpose, Status, Determination, RequestorName, ExportFocalPoint, RequestDateFrom,
							RequestDateTo, ReviewDateFrom, ReviewDateTo, Activity, AuthorizationNo, Segment, Site,
							ProductLine, ProductFamily, Program, Customer, OSRNumber, ReasonforReturn,
							TechnicalFocalPoint, Country, Priority, SortBy, SubmitDateFrom, SubmitDateTo, SalesOrderNo);
					searchExportRequest.searchExpReqItemDetails(SalesOrderitems,SalesOrderLineItem);
					searchExportRequest.click_SearchBtn();
					exportResults.titleIsDisplayed();
					Wait.waitfor(3);
					homeCRs.returnToCRPage();
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