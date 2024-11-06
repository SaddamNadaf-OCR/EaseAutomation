package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : August 2024
 * Descriptions : Verify item description field in shipment wizard accepts special characters page
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
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipWizardRequestorInformationPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Verifyitemdescriptionfieldinshipmentwizardacceptsspecialcharacters extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ItemsDescAcceptSpecialChar", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyitemdescriptionfieldinshipmentwizardacceptsspecialcharacters(String Testcase, String RunMode, String SBU, 
			String SBUcode, String TrackingNo, String UltDestination, String ExporterCode, String ConsigneeId, String ProductDescription, 
			String CustomsInvoiceQuantity, String ItemUnitPrice) {

		HomeGExportPage HGExport 		= new HomeGExportPage(driver, test);
		ShipmentWizardPage shipWizard   = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequestInfoPage   = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage InfoPage = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardShipmentItemsPage shipmentItems = new ShipWizardShipmentItemsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					shipWizard.select_SBUcode(SBUcode);
					shipWizard.click_GoBtn();
					RequestInfoPage.click_SaveAndProceed();
					Wait.waitfor(3);
					InfoPage.addShipmentInfo(TrackingNo, UltDestination);
					InfoPage.partiesToTheTransaction(ExporterCode, ConsigneeId, "", "", "");
					InfoPage.clickSaveAndProceedBtn();
					InfoPage.clickSaveAndProceedBtn();
					shipmentItems.click_AddItem();
					shipmentItems.addMandatoryItemDetails(ProductDescription, CustomsInvoiceQuantity, ItemUnitPrice);
					shipmentItems.clickSaveAndReturn();					
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
