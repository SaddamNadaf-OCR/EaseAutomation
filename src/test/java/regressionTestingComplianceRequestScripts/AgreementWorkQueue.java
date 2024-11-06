package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Dec 2023
 * Descriptions : Agreement Work Queue
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
import crsClasses.AgreementRequestPage;
import crsClasses.ComplianceRequestWorkQueuePage;
import crsClasses.HomePageCRs;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class AgreementWorkQueue extends SeleniumTestBase{
	
		@DataProvider
		public Object[][] getData() {
			return Utility.getData("AgreementWorkQueue", excel);
		}

		@Test(dataProvider = "getData")
		public void AgreementReq(String Testcase, String RunMode, String MyQueue, String MyQueue1) {
			
			HomePageCRs homepage = new HomePageCRs(driver, test);
			ComplianceRequestWorkQueuePage crsWorkQues = new ComplianceRequestWorkQueuePage(driver, test);
			AgreementRequestPage request = new AgreementRequestPage(driver, test);
			
			try {
				if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
					throw new SkipException("Skipping the test");
				} else {
					if (RunMode.equalsIgnoreCase("y")) {
						test.log(LogStatus.INFO, Testcase);
						homepage.agreementWorkQueue();
						if(MyQueue.length() > 0) {
							crsWorkQues.myQueue(MyQueue);
						}else {
							crsWorkQues.generalQueue(MyQueue1);
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
