package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.OrderConsolidationPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateShipmentThroughOrderConsolidation extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("OrderConsolidation", excel);
	}

	@Test(dataProvider = "getData")
	public void OrderConsolidation(String Testcase, String RunMode, String SBU, String billToLink, String SelectInv,
			String ShipmentNo, String ExporterCode) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		OrderConsolidationPage OrderCons = new OrderConsolidationPage(driver, test);
		CreatShipmentPage Create_Shp = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage Create_NewShp = new CreateNewShipmentPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		ResultShipmentPage Result_Shp = new ResultShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_OrderConsolidation();
					OrderCons.search_BillToCode(billToLink);
					OrderCons.searchBtn();
					OrderCons.selectInvoice(SelectInv);
					OrderCons.addShipment();
					Create_Shp.create_Shp();
					Create_NewShp.shipHeaderInfo(ShipmentNo, "", "", "", "", "", "", "", "", "", "", "", "", "", "",
							"");
					Create_NewShp.partiesToTheTransaction(ExporterCode, "", "", "");
					Create_NewShp.click_SaveBtn();
					String ShipNO = Create_NewShp.get_shipmentID();
					Create_NewShp.click_SaveReturn();
					HGExport.return_ExportHome();
					// HGExport.type_ShipmentNo(ShipNO);
					Shipment.enter_ShpNo(ShipNO);
					Shipment.click_Search();
					Result_Shp.click_ShipmentNo(ShipNO);
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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
