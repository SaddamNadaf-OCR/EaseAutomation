package RegressionTestingEOUSScripts;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : June 2024
 * Descriptions : Verify addition of EEI Item falls under EAR99 and verify the System LS status Page
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
import utilities.Wait;

public class VerifyadditionofEEIItemfallsunderEAR99andverifytheSystemLSstatus extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifytheSystemLSstatus", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyadditionofEEIItemfallsunderEAR99andverifytheSystemLSstatus(String Testcase, String RunMode, String SBU, String ShipmentNo,
			String UltDestination, String ExporterCode, String ConsigneeId, String FFCode, String ProductDescription, 
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ItemUnitPriceCurrency, 
			String RepairValue, String DiscountRate, String WholesaleRate, String ControllingAgencycode, 
			String ExportClassificationItem, String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, 
			String SecondaryCustomsQuantityUOM, String ImportHTS, String ImportUOM, String USExportECCN, 
			String StatisticalCode) {

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
					additem.typeDesc(ProductDescription);
					additem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice, ItemUnitPriceCurrency, 
							RepairValue, DiscountRate, WholesaleRate);
					additem.click_SaveBtn();
					additem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO, 
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN, StatisticalCode);
					additem.click_SaveBtn();
					try {
						if(ExportClassificationItem.equalsIgnoreCase("EAR99")) {
							additem.click_ExportAuthScreeningIconRed();
							String status=additem.getStatus();
							if(status.equalsIgnoreCase("No License Required")) {
								test.log(LogStatus.PASS, "No License Required Status is Displayed :");
							}
						}else {
							additem.click_ExportAuthScreeningIconGreen();
							String status=additem.getStatus();
							if(status.equalsIgnoreCase("License Required :")) {
								test.log(LogStatus.FAIL, "No License Required is not Displaying :");
							}
						}
					}catch(Exception e) {
						testFail();
						test.log(LogStatus.FAIL, "Enabled to fetch the Export Authorization Screening Status :");
					}
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
