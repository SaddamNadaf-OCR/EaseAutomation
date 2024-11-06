package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreatePLFromShipNo extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatePLShipNo", excel);
	}

	@Test(dataProvider = "getData")
	public void createPLFromShipmentNo(String Testcase, String RunMode, String SBU) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		PackingListPage PLPage = new PackingListPage(driver, test);
		ShipmentPage ShipPage = new ShipmentPage(driver, test);
		ResultShipmentPage ResultShipPage = new ResultShipmentPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PLPage.addPLFromShipment();
					ShipPage.shipment_SearchBtn();
				//	ResultShipPage.select_ShipmentNo();
					Wait.waitfor(2);
					ResultShipPage.click_PLFromShipNo();

					Wait.waitfor(2);
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
