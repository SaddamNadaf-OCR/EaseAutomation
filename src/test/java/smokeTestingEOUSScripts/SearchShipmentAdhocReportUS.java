package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchShipmentAdhocReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchShipmentAdhocReportUS extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShpAdhocReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipAdhocReport(String Testcase, String RunMode, String SBU, String sbu, String ShpNo, String WorkStatus ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentAdhocReportPage ShpAdhocReport = new SearchShipmentAdhocReportPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.ShipAdhocReport();
					ShpAdhocReport.selectSBU(sbu);
					
					ShpAdhocReport.enterShpNo(ShpNo);
					ShpAdhocReport.workStatus(WorkStatus);
					ShpAdhocReport.SearchBtn();
					ShpAdhocReport.validateHeading();
				
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
