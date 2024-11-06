package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchProductReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchProductReportUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ProductReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ProdReport(String Testcase, String RunMode, String SBU, String SbuCode, String PartNo, String ManufacturerLink, String Manufacturer) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchProductReportPage ProdReport = new SearchProductReportPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.ProductReport();
					ProdReport.selectSBU(SbuCode);
					ProdReport.enterPartNo(PartNo);
					ProdReport.selectManufacturer(ManufacturerLink, Manufacturer);
					ProdReport.searchBtn();
					ProdReport.validateHeading();
					
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
