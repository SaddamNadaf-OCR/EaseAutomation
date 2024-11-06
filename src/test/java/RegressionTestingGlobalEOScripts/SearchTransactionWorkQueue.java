package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentWorkQueuePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchTransactionWorkQueue extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("TransactionWorkQueue", excel);
	}

	@Test(dataProvider = "getData")
	public void TransactionWorkQueue(String Testcase, String RunMode, String SBU, String WorkQueue) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWorkQueuePage Workq = new ShipmentWorkQueuePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_TransactioWorkQueue();
					Workq.myQueue_Selection(WorkQueue);
					Workq.validate_WorkQueue();

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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
