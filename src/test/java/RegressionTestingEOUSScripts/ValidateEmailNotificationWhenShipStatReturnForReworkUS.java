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
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import globalExportClasses.ToolsConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.LoginPage;

public class ValidateEmailNotificationWhenShipStatReturnForReworkUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShipStatReturnReview", excel);
	}

	@Test(dataProvider = "getData")
	public void ValidateEmailNotificationForShipStatReturnForRework(String Testcase, String RunMode, String SBU,
			String parameter1, String paramvalue1, String SBUcode, String ShipmentNo, String UltDestination,
			String ProductFamily, String MotId, String ExporterCode, String AddPartyConsigneeID, String FFCode,
			String PartNo, String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice,
			String ItemUnitPriceCurrency, String ControllingAgencycode, String ExportClassificationItem, String PrCoo,
			String ShippingDeptReviewer, String ShipRegion, String ShipSite, String ShippingReviewStat, String uname, String password,
			String ShippingReason, String Shipremarks, String ReturnRework, String parameter2, String paramvalue2) {

		ToolsConfigurationPage Config = new ToolsConfigurationPage(driver, test);
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage ReviewerDetails = new EditShipmentReviewerDetailsPage(driver, test);
		LoginPage login = new LoginPage(driver, test);
		ShipmentPage shipment = new ShipmentPage(driver, test);
		ResultShipmentPage resultShip = new ResultShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					Config.select_SBUConfig(parameter1, paramvalue1);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					Shipment.click_AddShipment();
					CreatShip.select_SBUcode(SBUcode);
					CreateNewShp.shipHeaderInfo(ShipmentNo, UltDestination, "", "", "", "", "", "", ProductFamily,
							MotId, "", "", "", "", "", "");
					CreateNewShp.partyToTheTransaction(ExporterCode, AddPartyConsigneeID, FFCode, "");
					String shipmnetID = CreateNewShp.get_shipmentID();
					CreateNewShp.select_additems();
					ShipItem.click_AddItem();
					NewItem.AddGeneralInformation(PartNo, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
							"", "", "");

					NewItem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
							ItemUnitPriceCurrency, "", "", "");
					NewItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, "", "", "", "", "",
							"", "");
					// NewItem.addExportAuthorizationInfoUS(BISLicenseException, AuthorisationNo,
					// AuthorisationItemNo,
					// InternalAuthNo, AuthorisationExpiryDate, MLCategoryCode, EUSNo,
					// SMEIndicator);
					NewItem.click_SaveBtn();
					NewItem.enterPrCoo(PrCoo);
					NewItem.click_SaveBtn();
					NewItem.click_Close();
					ShipItem.click_AdditionalTransacDetails();

					ReviewerDetails.add_ShipReviewDetails(ShippingDeptReviewer, ShipRegion, ShipSite, "", "", "", "",
							"", "");
					ReviewerDetails.click_save();
					ReviewerDetails.addTransaction();

					CreateNewShp.changeStatusToShipReview(ShippingReviewStat);
					CreateNewShp.getShipNo();
					String shipNo = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipStatus = CreateNewShp.get_shipmentStatus();

					HGExport.logOut();
					login.login(uname, password);
					shipment.enter_ShpNo(shipNo);
					shipment.click_Search();
					resultShip.click_ShipmentNo(shipNo);
					CreateNewShp.select_ReviewerDetails();
					ReviewerDetails.addShippingReviewer(ShippingReason, Shipremarks);
					ReviewerDetails.addTransaction();
					CreateNewShp.changeStatusToReturnForRework(ReturnRework);
					CreateNewShp.get_shipmentStatus();
					String shipNewStatus = CreateNewShp.get_shipmentStatus();
					Config.select_SBUConfig(parameter2, paramvalue2);
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
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
