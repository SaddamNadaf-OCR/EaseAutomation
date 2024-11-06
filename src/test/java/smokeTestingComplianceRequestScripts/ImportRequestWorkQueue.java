package smokeTestingComplianceRequestScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AgreementRequestPage;
import crsClasses.HomePageCRs;
import crsClasses.ImportRequestWorkQueuePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ImportRequestWorkQueue extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ImportWorkQueue", excel);
	}

	@Test(dataProvider = "getData")
	public void ExportworkQueue(String Testcase, String RunMode, String MyQueue, String MyQueue1) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		ImportRequestWorkQueuePage irWorkQueue = new ImportRequestWorkQueuePage(driver, test);
		AgreementRequestPage request = new AgreementRequestPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.importWorkQueue();
					if(MyQueue.length() > 0) {
						irWorkQueue.myQueue(MyQueue);
					}else {
						irWorkQueue.generalQueue(MyQueue1);
					}
					request.titleIsDisplayed();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
	}catch (Exception e) {
		e.printStackTrace();
		testFail();
		Assert.assertTrue(false);
	}
}

}
