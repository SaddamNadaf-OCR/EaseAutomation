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

public class VerifySysAutoGeneratesShipNumUsingTemplateUS extends SeleniumTestBase {

	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShpSysGenNumUsingTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void verifySysGenNumUsingTemplate(String Testcase, String RunMode, String SBU, String SBUcode,
			String ShipmentTemplate, String ShipNumber, String UltDestination, String DateOfExport, String Region,
			String SLIDate, String SiteID, String Segment, String Program, String ProductFamily, String MotId,
			String ExporterCode, String ConsigneeId, String FFCode, String IntConsigneePartyType, String PartNo,
			String SourceSystemPartNumber, String POLineNo, String ScheduleAgreement, String SerialNumbers,
			String PONumber, String CustomerPartNumber, String SalesOrderNo, String SalesOrderItemNo,
			String DeliveryOrderNo, String DeliveryOrderItemNo, String Vendor, String VendorPN, String NetOrderNo,
			String EngineLine, String WBS, String MTFNumber, String Remarks, String OrgPONo,
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ItemUnitPriceCurrency,
			String RepairValue, String DiscountRate, String WholesaleRate, String ControllingAgencycode,
			String ExportClassificationItem, String HtsAndPrimaryUMO, String SecondaryCustomsQuantity,
			String SecondaryCustomsQuantityUOM, String ImportHTS, String ImportUOM, String USExportECCN, String StatisticalCode, String BISLicenseException, String AuthorisationNo, String AuthorisationItemNo, String InternalAuthNo, String AuthorisationExpiryDate, String MLCategoryCode, String EUSNo, String SMEIndicator, String PrCoo) {

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
					CreatShip.selectSBUcode(SBUcode);
					CreatShip.createshipmentwithtemplate(ShipmentTemplate);
					CreatShip.click_CreateShipmentBtn();
//					CreateNewShip.shipmentNum(ShipNumber);
//					CreateNewShip.shipHeaderInfo(UltDestination, DateOfExport, Region, SLIDate, SiteID, Segment,
//							Program, ProductFamily, MotId);
					CreateNewShip.partyToTheTransaction(ExporterCode, ConsigneeId, FFCode, IntConsigneePartyType);
					CreateNewShip.click_SaveBtn();

					CreateNewShip.get_shipmentID();
					String shipNo = CreateNewShip.get_shipmentID();

					CreateNewShip.get_shipmentStatus();
					String shipStatus = CreateNewShip.get_shipmentStatus();
					CreateNewShip.select_additems();
					ShipmentItem.click_AddItem();

					Orderitem.AddGeneralInformation(PartNo, SourceSystemPartNumber, POLineNo, ScheduleAgreement,
							SerialNumbers, PONumber, CustomerPartNumber, SalesOrderNo, SalesOrderItemNo,
							DeliveryOrderNo, DeliveryOrderItemNo, Vendor, VendorPN, NetOrderNo, EngineLine, WBS,
							MTFNumber, Remarks, OrgPONo);

					Orderitem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,
							ItemUnitPriceCurrency, RepairValue, DiscountRate, WholesaleRate);
					Orderitem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO,
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN,
							StatisticalCode);
					Orderitem.addExportAuthorizationInfoUS(BISLicenseException, AuthorisationNo, AuthorisationItemNo,
							InternalAuthNo, AuthorisationExpiryDate, MLCategoryCode, EUSNo, SMEIndicator);
					Orderitem.click_SaveBtn();
					Orderitem.enterPrCoo(PrCoo);
					Orderitem.click_SaveBtn();
					Orderitem.addExportAuthorizationInfoUS();
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
