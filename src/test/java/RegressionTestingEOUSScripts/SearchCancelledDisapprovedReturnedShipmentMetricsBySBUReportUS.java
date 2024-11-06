package RegressionTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultSearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage;
import globalExportClasses.SearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DissaprovalMetBySBUReport", excel);
	}

	@Test(dataProvider = "getData")
	public void dissaprovalMetricsBySBUReport(String TestCases, String RunMode, String SBU, String SbuCode,
			String WorkStatus, String Country, String region, String site, String CreatedFrom, String CreatedTo,
			String ExportFrom, String ExportTo) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage DisSBU = new SearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage(
				driver, test);

		ResultSearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage result = new ResultSearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage(
				driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_MISReports();
					HGExport.disapprovalMetricsBySBU();
					DisSBU.searchByParameters(SbuCode, WorkStatus, Country, region, site, CreatedFrom, CreatedTo,
							ExportFrom, ExportTo);
					DisSBU.searchBtn();
					Wait.waitfor(2);
					result.titleIsDisplayed();
					result.IconsDisplay();
					// result.backToSearchBtn();

					HGExport.return_ExportHome();
				} else {
					testFail();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			HGExport.return_ExportHome();
			testFail();
		}
	}

}
