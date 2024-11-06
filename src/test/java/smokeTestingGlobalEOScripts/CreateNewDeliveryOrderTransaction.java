package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateDeliveryOrderPage;
import globalExportClasses.CreateNewDeliveryOrderPage;
import globalExportClasses.DeliveryOrderCreateNewOrderItemPage;
import globalExportClasses.DeliveryOrderEditOrderItemHazmatDetailsPage;
import globalExportClasses.DeliveryOrderPage;
import globalExportClasses.EditDeliveryOrderItemsPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewDeliveryOrderTransaction extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DeliveryOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void deliveryOrder(String Testcase, String RunMode, String SBU, String SBUCode, String OrderNo,
			String UserFirstName, String UltDestination, String ModeOfTransport, String EntityType,
			String ConsigneeCode, String MarkingsContainerID, String ConsolidatedPackNumber, String Hazardous,
			String RadioActivityAmnt, String GrossCartonWeight, String PackageType, String DimensionUOM,
			String LenghtWidthHight, String WeightUOM, String GrossNet, String PartNo, String CustomsInvoiceQuantity,
			String RepairValue, String DiscountRate, String ControllingAgencycode, String ExportClassificationItem,
			String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM,
			String ImportHTS, String ImportUOM, String USExportECCN, String StatisticalCode,
			String AdditionalAuthorisationNo, String AdditionalAuthorisationItemNo, String HUNoContainerID,
			String BatchNumber, String BatchInfoCountryOfOrigin, String SearchHazardClassorDivision) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		DeliveryOrderPage delivery = new DeliveryOrderPage(driver, test);
		CreateDeliveryOrderPage createDO = new CreateDeliveryOrderPage(driver, test);
		CreateNewDeliveryOrderPage createNewDO = new CreateNewDeliveryOrderPage(driver, test);
		EditDeliveryOrderItemsPage editDOItem = new EditDeliveryOrderItemsPage(driver, test);
		DeliveryOrderCreateNewOrderItemPage item = new DeliveryOrderCreateNewOrderItemPage(driver, test);
		DeliveryOrderEditOrderItemHazmatDetailsPage hazmat = new DeliveryOrderEditOrderItemHazmatDetailsPage(driver,
				test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresOrdersDeliveries();
					HGExport.clickDeliveryOrder();
					delivery.clickAddDeliveryOrder();
					createDO.selectSBUcode(SBUCode);
					createDO.clickCreateDO();
					createNewDO.addDeliveryOrderDetails(OrderNo, UserFirstName, UltDestination, ModeOfTransport);
					createNewDO.addParty(EntityType, ConsigneeCode);
					createNewDO.addContainerPackingDetails(MarkingsContainerID, "", ConsolidatedPackNumber, Hazardous,
							RadioActivityAmnt, "", GrossCartonWeight, PackageType, "", "", DimensionUOM,
							LenghtWidthHight, WeightUOM, GrossNet);
					createNewDO.clickSave();
					createNewDO.select_additems();
					editDOItem.clickAddItem();
					item.AddGeneralInformation(PartNo, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
					item.addQuantityAndPricingInfo(CustomsInvoiceQuantity, "", "", "", RepairValue, DiscountRate, "");
					item.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO,
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN,
							StatisticalCode);
					item.addAdditionalAuthorization(AdditionalAuthorisationNo, AdditionalAuthorisationItemNo);
					item.addPackingDetails(HUNoContainerID, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
					item.addBatchInfo(BatchNumber, BatchInfoCountryOfOrigin, "");
					Wait.waitfor(3);
					item.click_SaveBtn();
					item.select_HazmatDetails();
					hazmat.add_HazmatInformation(SearchHazardClassorDivision);
					hazmat.click_SaveAndReturn();
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
