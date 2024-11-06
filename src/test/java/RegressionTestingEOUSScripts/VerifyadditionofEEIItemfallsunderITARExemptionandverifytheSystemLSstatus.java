package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : June 2024
 * Descriptions : Verify addition of EEI Item falls under ITAR Exemption and verify the System LS status Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyadditionofEEIItemfallsunderITARExemptionandverifytheSystemLSstatus extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifytheITARSystemLSstatus", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyadditionofEEIItemfallsunderITARExemptionandverifytheSystemLSstatus(String Testcase, String RunMode, String SBU, 
			String ShipmentNo, String UltDestination, String ExporterCode, String ConsigneeId, String FFCode, String PartNo, 
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ItemUnitPriceCurrency, String RepairValue, 
			String DiscountRate, String WholesaleRate, String DDTCNumber, String ITARException) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EETranPage = new ElectronicExportInformationTransactionsPage(driver,test);
		CreateElectronicExportInformationTransactionsPage create = new CreateElectronicExportInformationTransactionsPage(driver, test);
		CreateNewElectronicExportInformationTransactionsPage createEEIT = new CreateNewElectronicExportInformationTransactionsPage(driver, test);
		EditElectronicExportInformationTransactionsPage edit = new EditElectronicExportInformationTransactionsPage(driver,test);
		EditShipmentItemsPage itemPage = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage additem = new CreateNewOrderItemPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.CustomsFiling();
					EETranPage.clickAddEEI();
					create.newEEITRadioButton();
					create.createEEITransaction();
					createEEIT.enterShipmentNo(ShipmentNo);
					createEEIT.enterCountryDest(UltDestination);
					createEEIT.PartiesToTheTransaction(ExporterCode, ConsigneeId, FFCode);
					createEEIT.Savebutton();
//					createEEIT.additemDetails();
					itemPage.click_AddItem();
					additem.searchpartNo(PartNo);	
					additem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice, ItemUnitPriceCurrency, 
							RepairValue, DiscountRate, WholesaleRate);
					additem.clickExportAuthLabel();
					additem.getUSMLCategory();
					additem.usmlValidation();
					additem.ddtcNumberITARException(DDTCNumber, ITARException);
					additem.click_SaveBtn();
					
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
