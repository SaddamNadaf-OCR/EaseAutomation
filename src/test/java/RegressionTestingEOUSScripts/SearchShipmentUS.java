package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchShipmentUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchShipment", excel);
	}

	@Test(dataProvider = "getData")
	public void searchshipmentResult(String Testcase, String RunMode, String SBU, String ShipmentNo,
			String ExporterCountry, String ShipmentWorkStatus, String UltDestination, String DateOfExportFrom,
			String ModeofTransport, String LSStatus, String OrderNo, String SalesOrderNo, String PartNo,
			String AuthorisationNo, String ExportClassification) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		ResultShipmentPage resultShip = new ResultShipmentPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					Shipment.searchShipmentDetails(ShipmentNo, ExporterCountry, ShipmentWorkStatus, UltDestination,
							DateOfExportFrom, ModeofTransport, LSStatus);
					Shipment.SearchAssociatedLinkedOrders(OrderNo, SalesOrderNo);
					Shipment.SearchAssociatedLinkedOrdersItems(PartNo, AuthorisationNo, ExportClassification);
					Shipment.click_Search();
					Wait.waitfor(3);
					resultShip.shipmentResult();
					Wait.waitfor(3);
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
