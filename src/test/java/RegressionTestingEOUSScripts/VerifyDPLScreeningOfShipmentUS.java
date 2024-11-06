package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyDPLScreeningOfShipmentUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DPLScreenOfShipment", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyDPLScreeningOfShipment(String Testcase, String RunMode, String SBU, String SBUcode,
			String ShipmentNo, String UltDestination, String DateOfExport, String SLIDate, String ProductFamily,
			String MotId, String DateofArrival, String ReportMonthAndYear, String DutyReliefType,
			String ReliefAuthorizationNo, String ReliefActivityType, String DueDate, String ExporterCode, String ConsigneeId, String UltCons) {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		EditElectronicExportInformationTransactionsPage EEInfo = new EditElectronicExportInformationTransactionsPage(driver, test);
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
					CreatShip.selectSBUcode(SBUcode);
					Wait.waitfor(2);
					CreatShip.create_Shp();
					CreateNewShp.shipHeaderInfo(ShipmentNo, UltDestination, DateOfExport, "", SLIDate, "", "", "",
							ProductFamily, MotId, DateofArrival, ReportMonthAndYear, DutyReliefType,
							ReliefAuthorizationNo, ReliefActivityType, DueDate);
//					CreateNewShp.partyToTheTransaction(ExporterCode);
					CreateNewShp.click_SaveBtn();
					String shipmnetID = CreateNewShp.get_shipmentID();
					CreateNewShp.get_shipmentStatus();
//					CreateNewShp.PartiesUltCons(ConsigneeId);
					CreateNewShp.click_SaveBtn();
					CreateNewShp.get_shipmentStatus();
					CreateNewShp.select_CustomsFilingView();
					EEInfo.get_ShipmentStatus();
					EEInfo.AdditionalTransaction();
					EEInfo.ShipDetails();
//					CreateNewShp.UltCons(UltCons);
					CreateNewShp.click_SaveBtn();
					CreateNewShp.get_shipmentStatus();
					CreateNewShp.select_CustomsFilingView();
					EEInfo.get_ShipmentStatus();
					
					
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
			testFail();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
