package RegressionTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentProcessingStatisticsReportPage;
import globalExportClasses.SearchShipmentProcessingStatisticsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchShipmentProcessingStatisticsReportUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("StatisticsReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipStatisticsReport(String TestCases, String RunMode, String SBU, String SbuCode, String WorkStatus,
			String Country, String Region, String Site, String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo,
			String ShipReviewFrom, String ShipReviewTo, String ExportReviewFrom, String ExportReviewTo,
			String TransReviewFrom, String TransReviewTo) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentProcessingStatisticsReportPage statsReport = new SearchShipmentProcessingStatisticsReportPage(
				driver, test);
		ResultShipmentProcessingStatisticsReportPage result = new ResultShipmentProcessingStatisticsReportPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_MISReports();
					HGExport.statisticsReport();
					statsReport.searchByParameters(SbuCode, WorkStatus, Country, Region, Site, CreatedFrom, CreatedTo,
							ExportFrom, ExportTo, ShipReviewFrom, ShipReviewTo, ExportReviewFrom, ExportReviewTo,
							TransReviewFrom, TransReviewTo);
					statsReport.searchBtn();
					Wait.waitfor(5);
					result.titleIsDisplayed();
					//result.IconsDisplay();				
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
