package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultCustomsFilingPage;
import globalExportClasses.SearchCustomsfilingPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchCustomsfiling extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchCustomsfiling", excel);
	}

	@Test(dataProvider = "getData")
	public void Customsfiling(String Testcase, String RunMode, String SBU, String Sbu, String EXPORTERCODE,
			String CustomsFilingStatus, String UltimateConsigneeName, String PartyType, String PartNo,
			String ShipmentNo) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchCustomsfilingPage search = new SearchCustomsfilingPage(driver, test);
		ResultCustomsFilingPage result = new ResultCustomsFilingPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moduleselection();
					HGExport.CustomsFiling();
					Wait.waitfor(3);
					search.searchByParameter(Sbu, EXPORTERCODE, CustomsFilingStatus, UltimateConsigneeName, PartyType,
							PartNo, ShipmentNo);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					result.titleIsDisplayed();
					HGExport.return_ExportHome();

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
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
