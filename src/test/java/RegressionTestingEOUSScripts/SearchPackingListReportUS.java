package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : 
 * created date : 
 * Descriptions : Search Packing List Report Script
 * changed by : Saddam
 * changed date : 14/05/2024
 * Purpose of change : Added in Regression Testcases
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultReportPage;
import globalExportClasses.SearchPackingListReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchPackingListReportUS extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("PackingListReport", excel);
	}

	@Test(dataProvider = "getData")
	public void PLReport(String Testcase, String RunMode, String SBU, String SbuCode, String PL, String ExporterCode, String DateOfExport, 
			String ConsigneeName, String DateOfArrival, String ShpNo, String Status, String CreatedBy, String SortBy, String Direction) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchPackingListReportPage PLReport = new SearchPackingListReportPage(driver, test);
		ResultReportPage result = new ResultReportPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.PackingList();
					PLReport.searchByParameters(SbuCode, PL, ExporterCode, DateOfExport, ConsigneeName, DateOfArrival, ShpNo, Status, 
							CreatedBy, SortBy, Direction);
					PLReport.SearchBtn();
					PLReport.validateHeading();
					result.titleIsDisplayed();
				//	result.IconsDisplay();

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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}


}
