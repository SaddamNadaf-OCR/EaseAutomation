package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CheckAddCopyDelateShipLineItems extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CheckAddCopyDelateShipLineItems", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipmentWizard(String Testcase, String RunMode, String SBU, String ShipmentNumber,String PartNo, String MLCategoryExportClassification, String TariffCode,
			String ExportClassification,String ReportingClassification, String ImportHTSUOM, String USExportClassificationECCN, String SalesOrderNo,
			String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo, String SerialNumbers,
			String CustomsInvoiceQuantity, String Units, String UnitPrice, String QuantityOrdered, String TotalItemValue, String DiscountRate,
			String WholesaleRate, String GrossWeight, String NetWeight, String MarksAndNos, String Dimensions,
			String NoOfPkgs, String AlternateUOM, String Skids, String PackingLenghtWidthHight,
			String PackingWeightExWeight, String Factor, String Cubic, String BatchNumber, String BatchCountryOfOrigin,
			String BatchQuantity, String BatchExpiryDate, String BatchSterilityDate) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWiz = new ShipmentWizardPage(driver, test);
			ResultShipmentPage result = new ResultShipmentPage(driver, test);
			ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					ShipWiz.type_ShipmentByShipmentNo(ShipmentNumber);
					Wait.waitfor(3);
					ShipWiz.click_search();	
					Wait.waitfor(3);
					result.select_ShipmentNolink();
					Wait.waitfor(5);
					Items.click_LineItems();
					Wait.waitfor(5);
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
					Wait.waitfor(2);
					Items.click_ItemCopyIcon();
					Wait.waitfor(2);
					Items.clickSaveAndReturn();
					Wait.waitfor(2);
					Items.click_ItemDeleteIcon();
					Wait.waitfor(2);
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
