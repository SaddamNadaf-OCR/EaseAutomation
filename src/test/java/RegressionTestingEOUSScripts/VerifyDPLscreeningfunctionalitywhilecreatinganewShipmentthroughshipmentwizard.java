package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : August 2024
 * Descriptions : Verify DPL screening functionality while creating a new Shipment through shipment wizard page
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
import globalExportClasses.RequestorInformationPage;
import globalExportClasses.ShipWizardShipmentNoInformationPage;
import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyDPLscreeningfunctionalitywhilecreatinganewShipmentthroughshipmentwizard extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DPLScreeningFunctionality", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyDPLscreeningfunctionalitywhilecreatinganewShipmentthroughshipmentwizard(String Testcase, String RunMode, 
			String SBU, String SBUcode, String TrackingNo, String UltDestination, String ExporterCode, 
			String ConsigneeId, String ConsigneeId1) {

		HomeGExportPage HGExport 		= new HomeGExportPage(driver, test);
		ShipmentWizardPage shipWizard   = new ShipmentWizardPage(driver, test);
		RequestorInformationPage requesterPage = new RequestorInformationPage(driver, test);
		ShipWizardShipmentNoInformationPage shipInfo = new ShipWizardShipmentNoInformationPage(driver, test);

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
					requesterPage.click_SaveAndProceed();
					shipInfo.addShipmentInfo(TrackingNo, UltDestination);
					shipInfo.partiesToTheTransaction(ExporterCode, ConsigneeId, "", "", "");
					shipInfo.click_SaveBtn();
					shipInfo.validationofConsigneeStatus();
					shipInfo.partiesToTheTransaction("", ConsigneeId1, "", "", "");
					shipInfo.click_SaveBtn();
					shipInfo.validationofConsigneeStatus();					
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
