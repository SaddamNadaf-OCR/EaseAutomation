package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify the Shipment work queue functionality Page
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
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentWorkQueuePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifytheShipmentworkqueuefunctionality extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShipmentWorkQueueFun", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyUnitofMeasurefieldvalueisautopopulatingonsavingacopieditem(String Testcase, String RunMode, String SBU, 
			String SelectSBU, String WorkQueue, String ShippingQueue) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWorkQueuePage shipworkQueue = new ShipmentWorkQueuePage(driver, test);
		CreateNewShipmentPage create = new CreateNewShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_TransactioWorkQueue();
					shipworkQueue.filterOptionLabel();
					shipworkQueue.selectSBU(SelectSBU);
					shipworkQueue.applyFilter();
					shipworkQueue.myQueue_Selection(WorkQueue);
					shipworkQueue.validate_WorkQueue();
					create.closeButton();
					shipworkQueue.shippingQueue_Selection(ShippingQueue);
					shipworkQueue.validate_WorkQueue();
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
