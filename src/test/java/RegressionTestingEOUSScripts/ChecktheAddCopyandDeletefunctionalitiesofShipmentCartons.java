package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipWizardInvoicePartyDetailsPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ChecktheAddCopyandDeletefunctionalitiesofShipmentCartons extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCopyDeleteShipCartons", excel);
	}

	@Test(dataProvider = "getData")
	public void checktheAddCopyandDeletefunctionalitiesofShipmentLineItems(String Testcase, String RunMode, String SBU, 
			String ShipmentNumber, String CartonDimensionUOM, String CartonLenghtWidthHight, String CartonWeightUOM, String CartonGrossNet) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage shipWizardSearch = new ShipmentWizardPage(driver, test);
		ResultShipmentPage resultPage = new ResultShipmentPage(driver, test);
		ShipWizardShipmentNoInformationPage infoPage = new ShipWizardShipmentNoInformationPage(driver, test);
		ShipWizardInvoicePartyDetailsPage invoicePage = new ShipWizardInvoicePartyDetailsPage(driver, test);

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
					infoPage.clickInvoiceAndPartyDetailsIcon();
					invoicePage.addCartonButton();
					invoicePage.addCartonDetails(CartonDimensionUOM, CartonLenghtWidthHight, CartonWeightUOM, CartonGrossNet);
					invoicePage.click_ItemCopyIcon();
					invoicePage.saveAndReturn();
					invoicePage.click_ItemDeleteIcon();
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
