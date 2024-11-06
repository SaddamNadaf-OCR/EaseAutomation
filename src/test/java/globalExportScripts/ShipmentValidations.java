package globalExportScripts;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemHazmatDetailsPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewOrderItemSubComponentPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.EditShipmentBookingDeatilsPage;
import globalExportClasses.EditShipmentHazmatDetailsPage;
import globalExportClasses.EditShipmentInstructionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentQuestionnairePage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultLicenseDecisionPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.SearchLicenseDecisionTablePage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ShipmentValidations extends SeleniumTestBase {

	@Test(priority = 1)
	public void headerInformationValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.click_SaveBtn();
				CreateNewShp.validateHeaderInfo();
				HGExport.return_ExportHome();
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

	@Test(priority = 2)
	public void ultConsigneeApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdApproved"), "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusApproved"), "Ult. Consignee");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusApproved"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				Wait.waitfor(5);
				HGExport.return_ExportHome();
			//	HGExport.return_ExportHome();
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

	@Test(priority = 3)
	public void ultConsigneeOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOnHold"), "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOnHold"), "Ult. Consignee");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOnHold"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 4)
	public void ultConsigneeOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOverridden"), "Ult. Consignee");
					Wait.waitfor(2);
			//		CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOverridden"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 5)
	public void freightForwarderApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "",propEO.getProperty("MotIdAir"), "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "",
						propEO.getProperty("FFIdApproved"), "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusApproved"), "Freight Forwarder");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusApproved"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 6)
	public void freightForwarderOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "",propEO.getProperty("MotIdAir"), "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "",
						propEO.getProperty("FFIdOnHold"), "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOnHold"), "Freight Forwarder");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOnHold"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 7)
	public void freightForwarderOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "",propEO.getProperty("MotIdAir"), "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "",
						propEO.getProperty("FFIdOverridden"), "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOverridden"), "Freight Forwarder");
					Wait.waitfor(2);
				//	CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOverridden"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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
	
	@Test(priority = 8)
	public void InterConsigneeIdApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdApproved"), "", propEO.getProperty("InterConsigneeIdApproved"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusApproved"), "Intermediate Consignee");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusApproved"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 9)
	public void InterConsigneeIdOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOnHold"), "", propEO.getProperty("InterConsigneeIdOnHold"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOnHold"), "Intermediate Consignee");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOnHold"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 10)
	public void InterConsigneeIdOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "",
						propEO.getProperty("InterConsigneeIdOverridden"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOverridden"),
							"Intermediate Consignee");
					Wait.waitfor(2);
			//		CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOverridden"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 11)
	public void endUserApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.addPartiesEndUser(propEO.getProperty("EndUserApproved"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusApproved"), "End User");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusApproved"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 12)
	public void endUserOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.addPartiesEndUser(propEO.getProperty("EndUserOnHold"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOnHold"), "End User");
					Wait.waitfor(2);
					CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOnHold"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 13)
	public void endUserOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.addPartiesEndUser(propEO.getProperty("EndUserOverridden"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
					CreateNewShp.validateEntityScreeing(propEO.getProperty("StatusOverridden"), "End User");
					Wait.waitfor(2);
		//			CreateNewShp.validateComplianceSummary(propEO.getProperty("StatusOverridden"));
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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
	
	@Test(priority = 14)
	public void itemDetailsValidation(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.click_SaveBtn();
				NewItem.validateItemDetails();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 15)
	public void ValidatingCountryOfOriginDomestic(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("CountryTypeDomestic"), "", "", "", "", "", "", "", "",
						"", "", "", "", "", "", "", "");
				NewItem.click_SaveBtn();
				String countryType = NewItem.validateCountryOfOrigin();
				if (!countryType.equalsIgnoreCase("Domestic")) {
					test.log(LogStatus.FAIL, "Auto populate Country of origin is Domestic");
					testFail();
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 16)
	public void ValidatingCountryOfOriginForeign(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("CountryTypeForeign"), "", "", "", "", "", "", "", "",
						"", "", "", "", "", "", "", "");
				NewItem.click_SaveBtn();
				String countryType = NewItem.validateCountryOfOrigin();
				if (!countryType.equalsIgnoreCase("Foreign")) {
					test.log(LogStatus.FAIL, "Auto populate Country of origin is Foreign");
					testFail();
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 17)
	public void ValidatingCustomFilinginformation(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
			//	NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveBtn();
				if (NewItem.getExportClassfictn().equals(NewItem.validateCustomsExportClassfictn()))
					test.log(LogStatus.PASS, "Export Classfications equal to Customs Filing Export Classfications");
				else
					test.log(LogStatus.FAIL,
							"Export Classfications is not equal to Customs Filing Export Classfications");
				if (NewItem.getAutorizationNo().equals(NewItem.validateCustomsExportAuth()))
					test.log(LogStatus.PASS, "Export Autorization No equal to Customs Filing Export Autorization");
				else
					test.log(LogStatus.FAIL,
							"Export Autorization No is not equal to Customs Filing Export Autorization");
				if (NewItem.getQuantityUnits().equals(NewItem.validateQuantityUnits()))
					test.log(LogStatus.PASS, "Item Quantity Units equal to Customs Filing Item Quantity Units");
				else
					test.log(LogStatus.FAIL, "Item Quantity Units is not equal to Customs Filing Item Quantity Units");
				if (NewItem.getTotalStatisticalValue().equals(NewItem.validateTotalStatisticalValue()))
					test.log(LogStatus.PASS, "Item Total Statistical Value equal to Customs Filing Statistical Value");
				else
					test.log(LogStatus.FAIL,
							"Item Total Statistical Value is not equal to Customs Filing Statistical Value");
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 18)
	public void ValidatingAuthorizationNo(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		SearchLicenseDecisionTablePage SearchLicense = new SearchLicenseDecisionTablePage(driver, test);
		ResultLicenseDecisionPage ResultLicense = new ResultLicenseDecisionPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.select_LicenseDecisionTable();
				Wait.waitfor(3);
				SearchLicense.type_AuthorizationNo(propEO.getProperty("AuthorizationNo"));
				SearchLicense.Click_SearchBtn();
				ResultLicense.checkStatus();
				Wait.waitfor(3);
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				String shipmnetID = CreateNewShp.get_shipmentID();
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
			//	NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveBtn();
				NewItem.click_ExportAuthScreeningIconGreen();
				if (NewItem.getExportAuth().equals(propEO.getProperty("AuthorizationNo"))) {
					test.log(LogStatus.PASS, "Export Authorization from Export Control Screening is Active");
					if (NewItem.getScreeningDetermination().equals("Valid License")) {
						test.log(LogStatus.PASS, "Screening Determination is Valid License");
					} else {
						test.log(LogStatus.FAIL, "Screening Determination is  not Valid License");
					}
				} else
					test.log(LogStatus.FAIL, "Export Authorization from Export Control Screening is InActive");
				NewItem.click_PopUpClose();
				HGExport.select_LicenseDecisionTable();
				Wait.waitfor(3);
				SearchLicense.type_AuthorizationNo(propEO.getProperty("AuthorizationNo"));
				SearchLicense.Click_SearchBtn();
				ResultLicense.changeStatusActive();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				HGExport.type_ShipmentNo(shipmnetID);
				HGExport.click_Search();
				result.click_ShipmentNo(shipmnetID);
				CreateNewShp.select_additems();
				ShipItem.click_OrderNo(shipmnetID);
				NewItem.click_ExportAuthScreeningIconRed();
				if (NewItem.getExportAuth().equals("")) {
					test.log(LogStatus.PASS, "Export Authorization from Export Control Screening is InActive");
					if (NewItem.getScreeningDetermination().equals("License Required")) {
						test.log(LogStatus.PASS, "Screening Determination is License Required");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Screening Determination is not License Required");
					}
				} else
					test.log(LogStatus.FAIL, "Export Authorization from Export Control Screening is Active");
				Wait.waitfor(3);
				NewItem.click_PopUpClose();

				HGExport.select_LicenseDecisionTable();
				Wait.waitfor(3);
				SearchLicense.type_AuthorizationNo(propEO.getProperty("AuthorizationNo"));
				SearchLicense.Click_SearchBtn();
				ResultLicense.changeStatusInActive();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				HGExport.type_ShipmentNo(shipmnetID);
				HGExport.click_Search();
				result.click_ShipmentNo(shipmnetID);
				CreateNewShp.select_additems();
				ShipItem.click_OrderNo(shipmnetID);

				NewItem.click_ExportAuthScreeningIconGreen();

				if (NewItem.getExportAuth().equals(propEO.getProperty("AuthorizationNo"))) {
					test.log(LogStatus.PASS, "Export Authorization from Export Control Screening is Active");
					if (NewItem.getScreeningDetermination().equals("Valid License")) {
						test.log(LogStatus.PASS, "Screening Determination is Valid License");
					} else {
						test.log(LogStatus.FAIL, "Screening Determination is  not Valid License");
					}
				} else
					test.log(LogStatus.FAIL, "Export Authorization from Export Control Screening is InActive");
				NewItem.click_PopUpClose();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 19)
	public void ValidatingAdditionalAuthorizationNo(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		SearchLicenseDecisionTablePage SearchLicense = new SearchLicenseDecisionTablePage(driver, test);
		ResultLicenseDecisionPage ResultLicense = new ResultLicenseDecisionPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.select_LicenseDecisionTable();
				Wait.waitfor(3);
				SearchLicense.type_ClassificationCode(propEO.getProperty("UltDestination"),
						propEO.getProperty("ClassificationCode"));
				SearchLicense.Click_SearchBtn();
				ResultLicense.checkStatus();
				Wait.waitfor(3);
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				String shipmnetID = CreateNewShp.get_shipmentID();
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
		//		NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveBtn();
				NewItem.click_ExportAuthScreeningIconGreen();

				if (NewItem.getAdditionalExportAuthorization()
						.equals(propEO.getProperty("AdditionalExportAuthorization"))) {
					test.log(LogStatus.PASS, "Additional Export Authorization from Export Control Screening is Active");
					if (NewItem.getAdditionalScreeningDetermination().equals("Valid License Exception")) {
						test.log(LogStatus.PASS, "Screening Determination is Valid License Exception");
					} else {
						test.log(LogStatus.FAIL, "Screening Determination is  not Valid License Exception");
					}
				} else
					test.log(LogStatus.FAIL,
							"Additional Export Authorization from Export Control Screening is InActive");
				NewItem.click_PopUpClose();

				HGExport.select_LicenseDecisionTable();
				Wait.waitfor(3);
				SearchLicense.type_ClassificationCode(propEO.getProperty("UltDestination"),
						propEO.getProperty("ClassificationCode"));
				SearchLicense.Click_SearchBtn();
				ResultLicense.changeStatusActive();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				HGExport.type_ShipmentNo(shipmnetID);
				HGExport.click_Search();
				result.click_ShipmentNo(shipmnetID);
				CreateNewShp.select_additems();
				ShipItem.click_OrderNo(shipmnetID);
				NewItem.click_ExportAuthScreeningIconRed();
				if (NewItem.getAdditionalExportAuthorization().equals("")) {
					test.log(LogStatus.PASS,
							"Additional Export Authorization from Export Control Screening is InActive");
					if (NewItem.getAdditionalScreeningDetermination().equals("No License Required")) {
						test.log(LogStatus.PASS, "Additional Screening Determination is No License Required");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Additional Screening Determination is not Displayed"
								+ NewItem.getAdditionalScreeningDetermination());
					}
				} else
					test.log(LogStatus.FAIL, "Additional Export Authorization from Export Control Screening is Active");
				Wait.waitfor(3);
				NewItem.click_PopUpClose();

				HGExport.select_LicenseDecisionTable();
				Wait.waitfor(3);
				SearchLicense.type_ClassificationCode(propEO.getProperty("UltDestination"),
						propEO.getProperty("ClassificationCode"));
				SearchLicense.Click_SearchBtn();
				ResultLicense.changeStatusInActive();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				HGExport.type_ShipmentNo(shipmnetID);
				HGExport.click_Search();
				result.click_ShipmentNo(shipmnetID);
				CreateNewShp.select_additems();
				ShipItem.click_OrderNo(shipmnetID);
				NewItem.click_ExportAuthScreeningIconGreen();
				if (NewItem.getAdditionalExportAuthorization()
						.equals(propEO.getProperty("AdditionalExportAuthorization"))) {
					test.log(LogStatus.PASS, "Additional Export Authorization from Export Control Screening is Active");
					if (NewItem.getAdditionalScreeningDetermination().equals("Valid License Exception")) {
						test.log(LogStatus.PASS, "Screening Determination is Valid License Exception");
					} else {
						test.log(LogStatus.FAIL, "Screening Determination is  not Valid License Exception");
					}
				} else
					test.log(LogStatus.FAIL,
							"Additional Export Authorization from Export Control Screening is InActive");
				NewItem.click_PopUpClose();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 20)
	public void ValidatingHazmatDetails(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		CreateNewOrderItemHazmatDetailsPage ItemHazmat = new CreateNewOrderItemHazmatDetailsPage(driver, test);
		EditShipmentHazmatDetailsPage HazmatDetails = new EditShipmentHazmatDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
	//		NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveBtn();
				NewItem.select_HazmatDetails();
				Wait.waitfor(3);
				ItemHazmat.select_HazamatDetailsSwitch("", "", "", "Yes");
				Wait.waitfor(3);
				ItemHazmat.click_SaveItemHazmatDetails();
				ItemHazmat.click_SaveAndReturn();
				CreateNewShp.select_HazmatDetails();
				String hazmatValue = HazmatDetails.getHazardous();
				if (hazmatValue.equalsIgnoreCase("Yes")) {
					test.log(LogStatus.PASS, "Hazardous vaule is selected to Yes");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Hazardous vaule is selected to No");
				}
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 21)
	public void ValidatingSubComponent(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		CreateNewOrderItemSubComponentPage ItemSubComponent = new CreateNewOrderItemSubComponentPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);

				CreateNewShp.select_additems();
				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
		//		NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveBtn();
				Wait.waitfor(3);
				NewItem.select_SubComponent();
				ItemSubComponent.click_AddSubComponent();
				ItemSubComponent.click_SaveAndReturnBtn();
				ItemSubComponent.validateSubComponent();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
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

	@Test(priority = 22)
	public void ValidatingBookingDetails(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentBookingDeatilsPage BookingDetails = new EditShipmentBookingDeatilsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));

				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", propEO.getProperty("MotIdInland"), "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				CreateNewShp.select_BookingDetails();
			//	BookingDetails.validateAirOcean();
				Wait.waitfor(3);
				CreateNewShp.select_ShipmentForm();
				CreateNewShp.shipHeaderInfo("", "", "", "", "", "", "", "", "", propEO.getProperty("MotIdAir"), "", "",
						"", "", "", "");
				Wait.waitfor(3);
				CreateNewShp.click_SaveBtn();
				CreateNewShp.select_BookingDetails();
				BookingDetails.validateInlandCarrier();
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 23)
	public void ValidatingInstructions(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentInstructionsPage Instruction = new EditShipmentInstructionsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				CreateNewShp.click_SaveBtn();
				CreateNewShp.select_Instructions();
				HGExport.select_Help();
				String email = HGExport.getEmail();
				String userID = HGExport.getUserID();
				HGExport.clickPopClose();
				Wait.waitfor(3);
				if (userID.equals(Instruction.getEmployee())) {
					test.log(LogStatus.PASS,
							"Signature of Duly authorized officer or employee is matching with User Name");
				} else {
					test.log(LogStatus.FAIL,
							"Signature of Duly authorized officer or employee is Not matching with User Name :"
									+ userID);
				}
				if (email.equals(Instruction.getEmail())) {
					test.log(LogStatus.PASS, "Signature of Email is matching with User Email");
				} else {
					test.log(LogStatus.FAIL, "Signature of Email is Not matching with User Email : " + email);
				}
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 24)
	public void ValidatingQuenstionnario(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentQuestionnairePage questionnaire = new EditShipmentQuestionnairePage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				CreateNewShp.click_SaveBtn();
				CreateNewShp.select_Questionnaire();
				questionnaire.click_save();
				questionnaire.validateQuestionnaire();
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 25)
	public void ValidatingShippingReviewerDetails(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentReviewerDetailsPage Reviewer = new EditShipmentReviewerDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				CreateNewShp.click_SaveBtn();
				CreateNewShp.select_ReviewerDetails();
				Reviewer.add_ShipReviewDetails("", propEO.getProperty("ShippingDeptReviewer"),
						propEO.getProperty("ExportComplianceReviewer"),
						propEO.getProperty("TransportGatekeeperExportOps"));
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Submitted for Shipping Review");
				Reviewer.click_save();
				String shippingNote = Reviewer.addingShippingReviewer(propEO.getProperty("ShippingReson"),
						propEO.getProperty("ShippingRemark"));
				if (shippingNote.contains(propEO.getProperty("ShippingDeptReviewer"))) {
					test.log(LogStatus.PASS, "Shipping reviewer note is added");
				} else {
					test.log(LogStatus.FAIL, "Shipping reviewer note is not added");
				}
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Shipping Approved");
				Reviewer.click_save();

				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 26)
	public void ValidatingTransportationReviewerDetails(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentReviewerDetailsPage Reviewer = new EditShipmentReviewerDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "");
				Wait.waitfor(3);
				CreateNewShp.click_SaveBtn();
				CreateNewShp.select_ReviewerDetails();
				Reviewer.add_ShipReviewDetails("", propEO.getProperty("ShippingDeptReviewer"), "",
						propEO.getProperty("TransportGatekeeperExportOps"));
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Submitted for Shipping Review");
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Shipping Approved");
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Submitted For Transport Review");
				Reviewer.click_save();
				String TransportNote = Reviewer.addingTransportationReviewer(propEO.getProperty("TransportationReson"),
						propEO.getProperty("TransportationRemark"));
				if (TransportNote.contains(propEO.getProperty("ShippingDeptReviewer"))) {
					test.log(LogStatus.PASS, "Transportation reviewer note is added");
				} else {
					test.log(LogStatus.FAIL, "Transportation reviewer note is not added");
				}
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Transportation Approved");
				Reviewer.click_save();

				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 27)
	public void ValidatingExportReviewerDetails(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentReviewerDetailsPage Reviewer = new EditShipmentReviewerDetailsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		EditInvoiceOrderFormPage Invoice = new EditInvoiceOrderFormPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "");
				CreateNewShp.select_additems();

				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
		//		NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveAndReturn();
				String shipmnetID = CreateNewShp.get_shipmentID();
				Wait.waitfor(3);
				CreateNewShp.select_AssociatedLinked();
				Wait.waitfor(3);
				Invoice.click_InvoiceNo(shipmnetID);
				Invoice.addPartiesToTransaction(propEO.getProperty("EntityType"),
						propEO.getProperty("AddPartyConsigneeID"));
				Wait.waitfor(3);
				Invoice.click_InvoiceSave();
				Invoice.click_InoviceSaveAndReturn();
				CreateNewShp.select_additems();
				ShipItem.click_OrderNo(shipmnetID);
				NewItem.click_SaveAndReturn();

				CreateNewShp.select_ReviewerDetails();
				Reviewer.add_ShipReviewDetails("", propEO.getProperty("ShippingDeptReviewer"),
						propEO.getProperty("ExportComplianceReviewer"), "");
				Reviewer.click_save();

				CreateNewShp.click_ChangeStatus("Submitted for Shipping Review");
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Shipping Approved");
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Submitted For Export Review");
				Reviewer.click_save();
				String exportNote = Reviewer.addingExportReviewer(propEO.getProperty("TransportationReson"),
						propEO.getProperty("TransportationRemark"));
				if (exportNote.contains(propEO.getProperty("ShippingDeptReviewer"))) {
					test.log(LogStatus.PASS, "Transportation reviewer note is added");
				} else {
					test.log(LogStatus.FAIL, "Transportation reviewer note is not added");
				}
				Reviewer.click_save();
				CreateNewShp.click_ChangeStatus("Export Approved");
				Reviewer.click_save();
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 27)
	public void ValidatingLinkedInvoice(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		EditInvoiceOrderFormPage Invoice = new EditInvoiceOrderFormPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");

				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdApproved"), "", "");

				Wait.waitfor(4);
				String UltConsignee = CreateNewShp.getUltConsignee();
				String UltConsigneeName = CreateNewShp.getUltConsigneeName();
				CreateNewShp.select_additems();

				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
		//		NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveAndReturn();
				Wait.waitfor(3);
				CreateNewShp.select_AssociatedLinked();
				Wait.waitfor(3);
				String InvoiceNo = Invoice.getInvoiceNo();
				String Status = Invoice.getInvoiceStatus();
				Invoice.click_InvoiceIcon();
				try {
					if (Invoice.getShipmentNo().equals(InvoiceNo)) {
						test.log(LogStatus.PASS, "Consolidate Invoices Shipment NO is equal to the Invoice");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Consolidate Invoices Shipment NO is not equal to the Invoice");
					}
					if (Invoice.getUltConsigneeCode().equals(UltConsignee)) {
						test.log(LogStatus.PASS,
								"Consolidate Invoices UltConsignee code is equal to the Invoice UltConsignee");
					} else {
						testFail();
						test.log(LogStatus.FAIL,
								"Consolidate Invoices UltConsignee code is not equal to the UltConsignee");
					}
					if (Invoice.getStatus().equals(Status)) {
						test.log(LogStatus.PASS, "Consolidate Invoices Status is equal to the Invoice Status");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Consolidate Invoices Status is not equal to the Status");
					}
					if (Invoice.getUltConsigneeName().equals(UltConsigneeName)) {
						test.log(LogStatus.PASS,
								"Consolidate Invoices Ult. Consignee Name is equal to the Invoice UltConsigneeName");
					} else {
						testFail();
						test.log(LogStatus.FAIL,
								"Consolidate Invoices Ult. Consignee Name is not equal to the Invoice UltConsigneeName");
					}
					Wait.waitfor(4);
					String partno = Invoice.selectLinkedInvoice(Invoice.getShipmentNo() + " " + UltConsigneeName);
					if (partno.equals(propEO.getProperty("PartNo"))) {
						test.log(LogStatus.PASS, "Consolidate Invoices Part No is equal to the Invoice Part No");
					} else {
						testFail();
						test.log(LogStatus.FAIL, "Consolidate Invoices Part No is equal to the Invoice Part No");
					}
					Invoice.popclose();
				} catch (Exception e) {
					Invoice.popclose();
				}
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 28)
	public void ValidatingDocument(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		EditInvoiceOrderFormPage Invoice = new EditInvoiceOrderFormPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "");
				CreateNewShp.select_additems();

				ShipItem.click_AddItem();
				NewItem.AddGeneralInformation(propEO.getProperty("PartNo"), "", "", "", "", "", "", "", "", "", "", "",
						"", "", "", "", "");
		//		NewItem.click_SaveBtn();
				NewItem.addQuantityAndPricingInfo(propEO.getProperty("CustomsInvoiceQuantity"), "", "", "", "", "", "");
				NewItem.addExportAuthorisationInfo("", "", "", "", "19/11/2020", "", "");
				NewItem.click_SaveAndReturn();
				String shipmnetID = CreateNewShp.get_shipmentID();
				Wait.waitfor(3);
				CreateNewShp.select_AssociatedLinked();
				Wait.waitfor(3);
				Invoice.click_InvoiceNo(shipmnetID);
				Invoice.addPartiesToTransaction(propEO.getProperty("EntityType"),
						propEO.getProperty("AddPartyConsigneeID"));
				Wait.waitfor(3);
				Invoice.click_InvoiceSave();
				Invoice.click_InoviceSaveAndReturn();
				CreateNewShp.select_additems();
				ShipItem.click_OrderNo(shipmnetID);
				NewItem.click_SaveAndReturn();
				CreateNewShp.Click_GenerateDocument();
				CreateNewShp.validateDocument(propEO.getProperty("EmailGroup"), propEO.getProperty("EmailDocumentTo"));
				Wait.waitfor(3);
//				CreateNewShp.clickSendEmailWithLink();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 28)
	public void ValidatingWarningOfComplianceSummary(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_shipments();
				Shipment.click_AddShipment();
				CreatShip.select_SBUcode(propEO.getProperty("SBUcode"));
				CreateNewShp.shipHeaderInfo(propEO.getProperty("ShipmentNo"), propEO.getProperty("UltDestination"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "");
				CreateNewShp.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "");
				CreateNewShp.select_additems();

				ShipItem.click_AddItem();
				NewItem.itemDetailsMandatory(propEO.getProperty("ProductDescription"),propEO.getProperty("CustomsInvoiceQuantity") ,
						propEO.getProperty("QuantityUOM"), propEO.getProperty("ItemUnitPrice"));
				NewItem.click_SaveAndReturn();
				ShipItem.clickComplianceSummaryIcon();
				Wait.waitfor(3);
				String partNo = CreateNewShp.getPartNumberStatus();
				if (partNo.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of Part Number details is : " + partNo);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of Part Number details is : " + partNo);
				}
				String hts = CreateNewShp.getHTSNumber();
				if (hts.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of HTS/ScheduleB Number details is : " + hts);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of HTS/ScheduleB Number details is : " + hts);
				}
				String primaryUnit = CreateNewShp.getPrimaryUnits();
				if (primaryUnit.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of Primary Unit details is : " + primaryUnit);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of Primary Unit details is : " + primaryUnit);
				}
				String eccn = CreateNewShp.getECCN();
				if (eccn.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of USML/ECCN is : " + eccn);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of USML/ECCN is :" + eccn);
				}
				String usECCN = CreateNewShp.getUSECCN();
				if (usECCN.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of US ECCN is : " + usECCN);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of US ECCN is :" + usECCN);
				}
				ShipItem.click_POPupClose();
				Wait.waitfor(3);
				HGExport.return_ExportHome();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
