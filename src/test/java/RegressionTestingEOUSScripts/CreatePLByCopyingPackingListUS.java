package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewPackingListItemPage;
import globalExportClasses.CreateNewPackingListPage;
import globalExportClasses.CreatePackingListPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultPackingListPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreatePLByCopyingPackingListUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyPackingList", excel);
	}

	@Test(dataProvider = "getData")
	public void PLFromShipStatusApproved(String Testcase, String RunMode, String SBU, String SbuCode, String PackListNo,
			String shipmentNo, String AirCarrierCode) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);

		PackingListPage PL = new PackingListPage(driver, test);
		CreatePackingListPage Create_PL = new CreatePackingListPage(driver, test);
		CreateNewPackingListPage Create_NewPL = new CreateNewPackingListPage(driver, test);
		ResultPackingListPage ResultPL = new ResultPackingListPage(driver, test);
		CreateNewPackingListItemPage PLItem = new CreateNewPackingListItemPage(driver, test);
		ShipmentPage ShipPage = new ShipmentPage(driver, test);
		ResultShipmentPage ResultShipPage = new ResultShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PL.sbu(SbuCode);
					PL.searchBtn();
					ResultPL.copyPL();
					Wait.waitfor(3);
					Create_NewPL.createNewpackingList_GeneralInfo(PackListNo, "", "", "", shipmentNo);
					Create_NewPL.airCarrier(AirCarrierCode);
					Create_NewPL.saveBtn();

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
