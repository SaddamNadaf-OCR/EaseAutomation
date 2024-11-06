package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;

import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;

import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyShipmentUsingSysGenNumUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShpUsingSysGenNum", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyShipmentUsingSGNUS(String Testcase, String RunMode, String SBU, String SBUcode,
			String ShipNumber, String UltDestination, String DateOfExport, String Region, String SLIDate, String SiteID,
			String Segment, String Program, String ProductFamily, String MotId, String ExporterCode, String ConsigneeId,
			String FFCode, String IntConsigneePartyType) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);

		CreatShipmentPage CreateShip = new CreatShipmentPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShip = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipmentItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage Orderitem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage reviewDetails = new EditShipmentReviewerDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					Shipment.click_AddShipment();
					CreatShip.select_SBUcode(SBUcode);
//					CreateNewShip.shipmentNum(ShipNumber);
//					CreateNewShip.shipHeaderInfo(UltDestination, DateOfExport, Region, SLIDate, SiteID, Segment,
//							Program, ProductFamily, MotId);
					CreateNewShip.partyToTheTransaction(ExporterCode, ConsigneeId, FFCode, IntConsigneePartyType);
					CreateNewShip.click_SaveBtn();
					CreateNewShip.get_shipmentStatus();
					String shipStatus = CreateNewShip.get_shipmentStatus();
					//
					//
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
