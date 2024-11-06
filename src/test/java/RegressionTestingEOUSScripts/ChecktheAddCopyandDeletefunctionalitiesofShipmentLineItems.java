package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ChecktheAddCopyandDeletefunctionalitiesofShipmentLineItems extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCopyDeleteLineItem", excel);
	}

	@Test(dataProvider = "getData")
	public void checktheAddCopyandDeletefunctionalitiesofShipmentLineItems(String Testcase, String RunMode, String SBU, 
			String ShipmentNumber, String PartNo, String SourceSystemPartNumber, String SerialNumbers, String PONumber, 
			String CustomerPartNumber, String SalesOrderNo, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo, 
			String ManufacturerID, String CountryOfOrigin, String CountryOfOriginType, String FTAApplicable, String NetworkOrderNumber, 
			String EngineLine, String MTFNumber, String Remarks, String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, 
			String ItemUnitPriceCurrency, String RepairValue, String DiscountRate, String WholesaleRate) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage shipWizardSearch = new ShipmentWizardPage(driver, test);
		ResultShipmentPage resultPage = new ResultShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage infoPage = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardShipmentItemsPage itemPage = new ShipWizardShipmentItemsPage(driver, test);
		CreateNewOrderItemPage addItempage = new CreateNewOrderItemPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					shipWizardSearch.type_ShipmentByShipmentNo(ShipmentNumber);
					shipWizardSearch.click_search();
					resultPage.shipmentNoClick();
					infoPage.clickLineItemsIcon();
					itemPage.click_AddItem();
					addItempage.AddGeneralInformation(PartNo, SourceSystemPartNumber, SerialNumbers, PONumber, CustomerPartNumber, 
							SalesOrderNo, SalesOrderItemNo, DeliveryOrderNo, DeliveryOrderItemNo, ManufacturerID, CountryOfOrigin, 
							CountryOfOriginType, FTAApplicable, NetworkOrderNumber, EngineLine, MTFNumber, Remarks);
					addItempage.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice, ItemUnitPriceCurrency, 
							RepairValue, DiscountRate, WholesaleRate);
					addItempage.click_SaveAndReturn();
					itemPage.click_ItemCopyIcon();
					addItempage.click_SaveAndReturn();
					itemPage.click_ItemCopyIcon();
					HGExport.return_ExportHome();

				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
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
