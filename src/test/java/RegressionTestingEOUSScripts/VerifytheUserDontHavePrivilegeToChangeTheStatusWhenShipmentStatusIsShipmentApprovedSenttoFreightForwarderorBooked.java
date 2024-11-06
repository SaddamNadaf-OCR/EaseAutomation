package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CopyShipmentPage;
import globalExportClasses.CreatShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import globalExportClasses.ShipmentWorkQueuePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifytheUserDontHavePrivilegeToChangeTheStatusWhenShipmentStatusIsShipmentApprovedSenttoFreightForwarderorBooked extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShipmentWorkQueueFun", excel);
	}

	@Test(dataProvider = "getData")
	public void verifytheUserDontHavePrivilegeToChangeTheStatusWhenShipmentStatusIsShipmentApprovedSenttoFreightForwarderorBooked(String Testcase, 
			String RunMode, String SBU, String ShipWorkStatus) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage shipment = new ShipmentPage(driver, test);
		ResultShipmentPage result = new ResultShipmentPage(driver, test);
		CopyShipmentPage create = new CopyShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					shipment.shipworkStatus(ShipWorkStatus);
					shipment.click_Search();
					result.copyIcon();
					Wait.waitfor(3);
					create.save();
					String ShipmentNo = create.ShipmentNo();
					create.additionalTransaction();
					create.itemsection();
					
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
