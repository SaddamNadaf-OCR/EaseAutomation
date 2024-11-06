package RegressionTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentSummaryBySiteReport;
import globalExportClasses.SearchShipmentSummaryBySiteReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchShipmentSummaryBySiteReportUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShipSummSiteReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipSummarySBUReport(String TestCases, String RunMode, String SBU, String SbuCode, String country,
			String UltConsName, String IntConsName, String FwdAgentName, String Region, String Site,
			String CountryofUltDest, String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentSummaryBySiteReportPage SiteReport = new SearchShipmentSummaryBySiteReportPage(driver, test);
		ResultShipmentSummaryBySiteReport resultSite = new ResultShipmentSummaryBySiteReport(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_MISReports();
					HGExport.ShipSummarySite();
					SiteReport.searchByParameters(SbuCode, country, UltConsName, IntConsName, FwdAgentName, Region,
							Site, CountryofUltDest, CreatedFrom, CreatedTo, ExportFrom, ExportTo);
					SiteReport.searchBtn();
					Wait.waitfor(2);
					resultSite.titleIsDisplayed();
					//resultSite.IconsDisplay();
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
