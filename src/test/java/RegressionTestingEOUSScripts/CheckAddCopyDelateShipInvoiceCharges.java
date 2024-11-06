package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardAdditionalChargesPage;
import globalExportClasses.ShipWizardShipmentItemsPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CheckAddCopyDelateShipInvoiceCharges extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CheckAddCopyDelateInvoiceCharge", excel);
	}

	@Test(dataProvider = "getData")
	public void checkAddCopyDelateShipInvoiceCharges(String Testcase, String RunMode, String SBU, String ShipmentNumber,
			String ChargeDescription, String Amount, String ChargingAccount, String GLACode, String ChargeToCustomer,
			String WholesalerCharge, String PrintOnDocuments) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWiz = new ShipmentWizardPage(driver, test);
			ResultShipmentPage result = new ResultShipmentPage(driver, test);
			ShipWizardShipmentItemsPage Items = new ShipWizardShipmentItemsPage(driver, test);
			ShipWizardAdditionalChargesPage AdditionalCharge = new ShipWizardAdditionalChargesPage(driver, test);
		
		
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
					AdditionalCharge.clickAddAdditionalCharges();
					Wait.waitfor(3);
					AdditionalCharge.clickAddMoreChargesBtn();
					Wait.waitfor(3);
					AdditionalCharge.addAdditionalCharges(ChargeDescription, Amount, ChargingAccount, GLACode,
							ChargeToCustomer, WholesalerCharge, PrintOnDocuments);
					Wait.waitfor(2);
					AdditionalCharge.click_ItemCopyIcon();
					Wait.waitfor(2);
					AdditionalCharge.click_ItemDeleteIcon();
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