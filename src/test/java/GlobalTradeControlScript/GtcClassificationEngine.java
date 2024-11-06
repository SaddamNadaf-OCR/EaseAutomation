package GlobalTradeControlScript;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalTradeControlClasses.GtcClassificationEnginePage;
import globalTradeControlClasses.GtcHomePage;
import globalTradeControlClasses.GtcNewScreeningPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class GtcClassificationEngine extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("GtcClassificationEngine", excel);
	}

	@Test(dataProvider = "getData")

	public void createClassificationEngine(String Testcase, String RunMode, String Country, String SearchText,
			String SearchType, String SearchBasedOn) throws Exception {

		// **************** Objects Creation *******************************************

		GtcHomePage gtchome = new GtcHomePage(driver, test);
		GtcClassificationEnginePage gtcengine = new GtcClassificationEnginePage(driver, test);

		// **********Test steps execution ***************************

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					gtchome.moveTo_GtcListScreening();
					gtcengine.moveTo_GtcClassificationEngine(Country, SearchText, SearchType, SearchBasedOn);
					Wait.waitfor(5);
					gtchome.GtcreturnPage();
				}
				else {
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
			Assert.assertTrue(false);
		}
	}

}
