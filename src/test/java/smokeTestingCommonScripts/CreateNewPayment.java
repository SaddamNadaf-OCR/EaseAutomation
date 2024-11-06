package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreatePaymentPage;
import filesClasses.HomePage;
import filesClasses.ResultPaymentPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class CreateNewPayment extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatePayment", excel);

	}

	@Test(dataProvider = "getData")
	public void CreatePayment(String Testcase, String RunMode, String SBU, String PaymentID, String PaymentDesc) {

		HomePage homepage = new HomePage(driver, test);
		CreatePaymentPage CreatePage = new CreatePaymentPage(driver, test);
		ResultPaymentPage Result=new ResultPaymentPage(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoPayment();
					Result.AddPayment();
					Wait.waitfor(3);
					CreatePage.enterPaymentID(PaymentID, PaymentDesc);
					CreatePage.saveandReturn();
					homepage.returnToIOHomePage();

				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homepage.returnToIOHomePage();
			Assert.assertTrue(false);
		}
	}

}
