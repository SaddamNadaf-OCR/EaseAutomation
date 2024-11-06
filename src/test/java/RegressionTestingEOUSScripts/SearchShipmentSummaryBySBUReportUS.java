package RegressionTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentSummarybySBUReportPage;
import globalExportClasses.SearchShipmentSummaryBySBUReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchShipmentSummaryBySBUReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShipSummSBUReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipSummarySBUReport(String TestCases, String RunMode, String SBU, String SbuCode, String country,
			String UltConsName, String IntConsName, String FwdAgentName, String Region, String Site,
			String CountryofUltDest, String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentSummaryBySBUReportPage sbuReport = new SearchShipmentSummaryBySBUReportPage(driver, test);
		ResultShipmentSummarybySBUReportPage resultShip = new ResultShipmentSummarybySBUReportPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_MISReports();
					HGExport.ShipSummarySBU();
					sbuReport.searchByParameters(SbuCode, country, UltConsName, IntConsName, FwdAgentName, Region, Site,
							CountryofUltDest, CreatedFrom, CreatedTo, ExportFrom, ExportTo);
					Wait.waitfor(2);
					sbuReport.searchBtn();
					Wait.waitfor(2);
					resultShip.titleIsDisplayed();
					//resultShip.IconsDisplay();
					Wait.waitfor(2);

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
