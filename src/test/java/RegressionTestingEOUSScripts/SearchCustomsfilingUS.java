package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultElectronicExportInformationTransactionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchCustomsfilingUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchCustomsfiling", excel);
	}

	@Test(dataProvider = "getData")
	public void Customsfiling(String Testcase, String RunMode, String SBU, String ExportCode, String ShipmentWorkStatus,
			String OrderNo, String SalesOrderNo, String PartNo, String AuthorizationNo) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage search = new ElectronicExportInformationTransactionsPage(driver,
				test);
		ResultElectronicExportInformationTransactionsPage result = new ResultElectronicExportInformationTransactionsPage(
				driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moduleselection();
					HGExport.CustomsFiling();
					Wait.waitfor(3);
					search.searchEEIT(SBU, ExportCode, ShipmentWorkStatus, OrderNo, SalesOrderNo, PartNo,
							AuthorizationNo);
					Wait.waitfor(3);
					search.clickSearch();
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
