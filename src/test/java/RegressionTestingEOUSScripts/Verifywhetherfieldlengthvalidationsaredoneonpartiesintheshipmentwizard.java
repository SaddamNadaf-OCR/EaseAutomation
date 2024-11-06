package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : August 2024
 * Descriptions : Verify whether field length validations are done on parties in the shipment wizard page
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
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Verifywhetherfieldlengthvalidationsaredoneonpartiesintheshipmentwizard extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FieldLengthValidationForParties", excel);
	}

	@Test(dataProvider = "getData")
	public void verifywhetherfieldlengthvalidationsaredoneonpartiesintheshipmentwizard(String Testcase, String RunMode, String SBU, 
			String SBUcode, String TrackingNo, String UltDestination, String ExporterCode, String UltimateConsigneeName, 
			String UltimateConsigneeAdd1) {

		HomeGExportPage HGExport 		= new HomeGExportPage(driver, test);
		ShipmentWizardPage shipWizard   = new ShipmentWizardPage(driver, test);
		ShipWizardRequestorInformationPage RequestInfoPage   = new ShipWizardRequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage InfoPage = new ShipWizardShipmentNoInformationPage(driver, test);

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
					InfoPage.partiesToTheTransaction(ExporterCode, "", "", "", "");
					InfoPage.addUltimateConsignee(UltimateConsigneeName, UltimateConsigneeAdd1, "", "", "", "", "", "");
					Wait.waitfor(3);
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
