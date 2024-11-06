package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify the line items on the transaction allow different entry number across all the items Page
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
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class Verifythelineitemsonthetransactionallowdifferententrynumberacrossalltheitems extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AllowDiffEntryNumber", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyUnitofMeasurefieldvalueisautopopulatingonsavingacopieditem(String Testcase, String RunMode, String SBU, 
			String ShipmentNo, String UltDestination, String ExporterCode, String ConsigneeId, String FFCode, String ProductDescription, 
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ControllingAgencycode, 
			String ExportClassificationItem, String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM, 
			String ImportHTS, String ImportUOM, String USExportECCN, String StatisticalCode, String ImportShipmentType, String InbondCode, 
			String EntryNo, String ItemNO, String ImportIdentificationNo, String RateofYield, String ReliefAuthorizationNo, String importShipmentType, String inbondCode, String entryNo) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EETranPage = new ElectronicExportInformationTransactionsPage(driver,test);
		CreateElectronicExportInformationTransactionsPage create = new CreateElectronicExportInformationTransactionsPage(driver, test);
		CreateNewElectronicExportInformationTransactionsPage createEEIT = new CreateNewElectronicExportInformationTransactionsPage(driver, test);
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
					additem.itemDetailsMandatory(ProductDescription, CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice);
					additem.click_SaveBtn();
					additem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO, 
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN, StatisticalCode);
					additem.addReExportInfo(ImportShipmentType, InbondCode, EntryNo, ItemNO, ImportIdentificationNo, RateofYield, 
							ReliefAuthorizationNo);					
					additem.click_SaveAndReturn();
//					createEEIT.additemDetails();
					itemPage.click_AddItem();
					additem.itemDetailsMandatory(ProductDescription, CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice);
					additem.click_SaveBtn();
					additem.entryNumber(importShipmentType, inbondCode, entryNo);			
					additem.click_SaveAndReturn();
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
