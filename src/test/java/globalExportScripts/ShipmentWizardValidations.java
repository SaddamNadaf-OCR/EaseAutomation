package globalExportScripts;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipWizardInvoicePartyDetailsPage;
import globalExportClasses.ShipWizardRequestorInformationPage;
import globalExportClasses.ShipWizardScreeningStatusPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipWizardSupportingDocumentationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ShipmentWizardValidations extends SeleniumTestBase {

	@Test(priority = 29)
	public void ShipWizardheaderInformationValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				ShipNoInfo.click_SaveBtn();
				ShipNoInfo.valdatingShipNoInfo();

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

	@Test(priority = 30)
	public void ShipWizardShipTORequiredValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardScreeningStatusPage ScreeningStatus = new ShipWizardScreeningStatusPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "", "");
				ShipNoInfo.click_SaveBtn();
				ShipNoInfo.clickScreeningValidationsIcon();
				Wait.waitfor(3);
				ScreeningStatus.click_Toggle();
				String satus = ScreeningStatus.getshipvalidate();
				if (satus.equalsIgnoreCase("Failure")) {
					test.log(LogStatus.PASS, "Screening Status  is Failure");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Status  is not Failure");
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

	@Test(priority = 31)
	public void ShipWizardInvoicePartyDetailsValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardInvoicePartyDetailsPage InvoiceParty = new ShipWizardInvoicePartyDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);

				ShipNoInfo.clickInvoiceAndPartyDetailsIcon();
				InvoiceParty.clearCustomsCurrencyAndConversionRate();
				ShipNoInfo.clickSaveAndProceedBtn();
				InvoiceParty.validateCustomsCurrencyConversionRate();
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

	@Test(priority = 32)
	public void ShipWizardultConsigneeApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), "UNITED STATES");
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdApproved"), "", "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();

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

	@Test(priority = 33)
	public void ShipWizardultultConsigneeOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOnHold"), "", "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 34)
	public void ShipWizardultConsigneeOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();

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

	@Test(priority = 35)
	public void ShipWizardfreightForwarderApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "",
						propEO.getProperty("FFIdApproved"), "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 36)
	public void ShipWizardfreightForwarderOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "",
						propEO.getProperty("FFIdOnHold"), "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 37)
	public void ShipWizardfreightForwarderOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "",
						propEO.getProperty("FFIdOverridden"), "", "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 38)
	public void ShipWizardInterConsigneeIdApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), "UNITED STATES");
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdApproved"), "", propEO.getProperty("InterConsigneeIdApproved"),
						"");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();

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

	@Test(priority = 39)
	public void ShipWizardInterConsigneeIdOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOnHold"), "", propEO.getProperty("InterConsigneeIdOnHold"), "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 40)
	public void ShipWizardInterConsigneeIdOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "",
						propEO.getProperty("InterConsigneeIdOverridden"), "");
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 41)
	public void ShipWizardendUserApprovedStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "",
						propEO.getProperty("EndUserApproved"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 42)
	public void ShipWizardendUserOnHoldStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "",
						propEO.getProperty("EndUserOnHold"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Red")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Red");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not RED");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 43)
	public void ShipWizardendUserOverriddenStatusValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"), "", "", "",
						propEO.getProperty("EndUserOverridden"));
				String color = CreateNewShp.gettingColor();
				if (color.equalsIgnoreCase("Green")) {
					test.log(LogStatus.PASS, "Screening Flag Colour is Green");
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Flag Colour is not Green");
				}
				ShipNoInfo.click_SaveBtn();
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

	@Test(priority = 44)
	public void ShipWizardShipToPartyDetailsAutoPopulate(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardInvoicePartyDetailsPage InvoiceParty = new ShipWizardInvoicePartyDetailsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				Wait.waitfor(3);
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "", "");
				ShipNoInfo.click_SaveBtn();
				String ultConsigneeEntityName = ShipNoInfo.getUltConsignee();
				ShipNoInfo.clickSaveAndProceedBtn();
				String entityName = InvoiceParty.getEntityType();
				if (entityName.equalsIgnoreCase(ultConsigneeEntityName)) {
					test.log(LogStatus.PASS,
							"Ship to details is same as Ult. Consigee and auto-populated in Invoice Parties to the Transaction ");
				} else {
					testFail();
					test.log(LogStatus.FAIL,
							"Ship to details is different as Ult. Consigee and not auto-populated in Invoice Parties to the Transaction ");
				}
				Wait.waitfor(3);
				InvoiceParty.PartiesIsThisADropShipment();
				InvoiceParty.clickPartiesDropShip();

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

	@Test(priority = 45)
	public void ShipWizardLineItemsValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "", "");
				ShipNoInfo.click_SaveBtn();
				ShipNoInfo.clickLineItemsIcon();
				Wait.waitfor(3);
				Items.click_AddItem();
				Items.clickSaveAndReturn();
				Items.validateLineItems();
				Items.validatingPackingDetails(propEO.getProperty("PartNo"),
						propEO.getProperty("CustomsInvoiceQuantity"));
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

	@Test(priority = 46)
	public void ShipWizardLineItemsWaringMessages(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
		ShipWizardScreeningStatusPage ScreeningStatus = new ShipWizardScreeningStatusPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "", "");
				ShipNoInfo.click_SaveBtn();
				ShipNoInfo.clickLineItemsIcon();
				Wait.waitfor(3);
				Items.click_AddItem();
				Items.addMandatoryItemDetails(propEO.getProperty("ProductDescription"),
						propEO.getProperty("CustomsInvoiceQuantity"), propEO.getProperty("ItemUnitPrice"));
				Items.clickSaveAndReturn();
				ShipNoInfo.clickScreeningValidationsIcon();
				Wait.waitfor(3);
				ScreeningStatus.click_Toggle();
				String partNo = ScreeningStatus.getPartNumberStatus();
				if (partNo.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of Part Number details is : " + partNo);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of Part Number details is : " + partNo);
				}
				String hts = ScreeningStatus.getHTSNumber();
				if (hts.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of HTS/ScheduleB Number details is : " + hts);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of HTS/ScheduleB Number details is : " + hts);
				}
				String primaryUnit = ScreeningStatus.getPrimaryUnits();
				if (primaryUnit.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of Primary Unit details is : " + primaryUnit);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of Primary Unit details is : " + primaryUnit);
				}
				String eccn = ScreeningStatus.getECCN();
				if (eccn.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of USML/ECCN is : " + eccn);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of USML/ECCN is :" + eccn);
				}
				String usECCN = ScreeningStatus.getUSECCN();
				if (usECCN.equalsIgnoreCase("Warning")) {
					test.log(LogStatus.INFO, "Screening Staus of US ECCN is : " + usECCN);
				} else {
					testFail();
					test.log(LogStatus.FAIL, "Screening Staus of US ECCN is :" + usECCN);
				}
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

	@Test(priority = 47)
	public void ShipWizardReviewerAndQuestionnaireValidations(Method method) throws Exception {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequstorInfo = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardSupportingDocumentationPage SupportDoc = new ShipWizardSupportingDocumentationPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				HGExport.moveTo_SBUSelection(propEO.getProperty("SBU"));
				HGExport.featuresShippingTrans();
				HGExport.click_ShipWizard();
				ShipWizd.select_SBUcode(propEO.getProperty("SBUcode"));
				ShipWizd.click_GoBtn();
				RequstorInfo.addRequestorInfo(propEO.getProperty("ShipmentNo"), "");
				RequstorInfo.click_SaveAndProceed();
				ShipNoInfo.addShipmentInfo(propEO.getProperty("TrackingNo"), propEO.getProperty("UltDestination"));
				ShipNoInfo.partiesToTheTransaction(propEO.getProperty("ExporterCode"),
						propEO.getProperty("ConsigneeIdOverridden"), "", "", "");
				ShipNoInfo.click_SaveBtn();
				ShipNoInfo.clickAttachDocsSubmitIcon();
				Wait.waitfor(3);
				SupportDoc.click_SubmitForReviewer();
				SupportDoc.validateReviwer();
				SupportDoc.submitShipReviewer(propEO.getProperty("ShippingDeptReviewer"),
						propEO.getProperty("ExportComplianceReviewer"),
						propEO.getProperty("TransportGatekeeperExportOps"));
				Wait.waitfor(3);
				SupportDoc.click_SubmitForReviewer();
				SupportDoc.validateQuestionnaire();
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

}