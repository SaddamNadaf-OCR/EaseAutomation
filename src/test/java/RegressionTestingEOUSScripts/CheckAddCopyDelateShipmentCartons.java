package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardAdditionalChargesPage;
import globalExportClasses.ShipWizardInvoicePartyDetailsPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CheckAddCopyDelateShipmentCartons extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CheckAddCopyDelateShipCartons", excel);
	}

	@Test(dataProvider = "getData")
	public void checkAddCopyDelateShipInvoiceCharges(String Testcase, String RunMode, String SBU, String ShipmentNumber,
			String CartonDimensionUOM, String CartonLenghtWidthHight, String CartonWeightUOM,
			String CartonGrossNet ) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWiz = new ShipmentWizardPage(driver, test);
			ResultShipmentPage result = new ResultShipmentPage(driver, test);
			ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
			ShipWizardAdditionalChargesPage AdditionalCharge = new ShipWizardAdditionalChargesPage(driver, test);
			ShipWizardShipmentNoInformationPage ShipNoInfo = new ShipWizardShipmentNoInformationPage(driver, test);
			ShipWizardInvoicePartyDetailsPage InvoiceParty = new ShipWizardInvoicePartyDetailsPage(driver, test);
		
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
					ShipNoInfo.clickSaveAndProceedBtn();
					Wait.waitfor(5);
					InvoiceParty.addCartonDetails(CartonDimensionUOM, CartonLenghtWidthHight, CartonWeightUOM,
							CartonGrossNet);
					
					
					/*AdditionalCharge.click_ItemCopyIcon();
					Wait.waitfor(2);
					AdditionalCharge.click_ItemDeleteIcon();
					Wait.waitfor(2);*/
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