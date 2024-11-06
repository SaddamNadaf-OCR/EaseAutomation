package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class EditShipmentbyShipmentNo extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("EditShipmentbyShipmentNo", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipmentWizard(String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNumber, String PartNo, 
			String MLCategoryExportClassification, String TariffCode, String ExportClassification,String ReportingClassification, 
			String ImportHTSUOM, String USExportClassificationECCN, String SalesOrderNo, String SalesOrderItemNo, String DeliveryOrderNo, 
			String DeliveryOrderItemNo, String SerialNumbers, String CustomsInvoiceQuantity, String Units, String UnitPrice, 
			String QuantityOrdered, String TotalItemValue, String DiscountRate, String WholesaleRate, String GrossWeight, String NetWeight, 
			String MarksAndNos, String Dimensions, String NoOfPkgs, String AlternateUOM, String Skids, String PackingLenghtWidthHight,
			String PackingWeightExWeight, String Factor, String Cubic, String BatchNumber, String BatchCountryOfOrigin,
			String BatchQuantity, String BatchExpiryDate, String BatchSterilityDate) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWizd = new ShipmentWizardPage(driver, test);
		ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					ShipWizd.select_SBUcode(SBUcode);
					ShipWizd.Click_EditShipmentbyShipmentNo();
					ShipWizd.type_ShipmentByShipmentNo(ShipmentNumber);
					ShipWizd.click_GoBtn();
					//RequstorInfo.click_SaveAndProceed();
					Wait.waitfor(3);
					ShipNoInfo.clickLineItemsIcon();
					Wait.waitfor(3);
					Items.click_AddItem();
					Items.addItemGeneralInfo(PartNo, MLCategoryExportClassification, TariffCode, ExportClassification,ReportingClassification,
							ImportHTSUOM, USExportClassificationECCN, SalesOrderNo, SalesOrderItemNo, DeliveryOrderNo,
							DeliveryOrderItemNo, SerialNumbers);
					Items.clickSaveBtn();
					Items.addQuantityAndPricingInfo(CustomsInvoiceQuantity,Units,  UnitPrice ,QuantityOrdered, TotalItemValue, DiscountRate, WholesaleRate);
					Items.clickSaveBtn();
					Wait.waitfor(3);
					Items.addPackingInfo(GrossWeight, NetWeight, MarksAndNos, Dimensions, NoOfPkgs, AlternateUOM, Skids,
							PackingLenghtWidthHight, PackingWeightExWeight, Factor, Cubic);
					Wait.waitfor(3);
					Items.addBatchInfo(BatchNumber, BatchCountryOfOrigin, BatchQuantity, BatchExpiryDate, BatchSterilityDate);

					Items.clickSaveAndReturn();
					ShipNoInfo.clickShipmentTermsIcon();
					
					Wait.waitfor(3);
					HGExport.return_ExportHome();
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					ShipWizd.type_ShipmentNo(ShipmentNumber);
					ShipWizd.click_search();
					result.click_ShipmentNo(ShipmentNumber);
					Wait.waitfor(4);
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
