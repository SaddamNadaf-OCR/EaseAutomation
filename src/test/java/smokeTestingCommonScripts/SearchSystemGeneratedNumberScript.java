package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultSystemGeneratedNumberPage;
import filesClasses.SearchSystemGeneratedNumberPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class SearchSystemGeneratedNumberScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchSystemGeneratedNumber", excel);

	}

	@Test(dataProvider = "getData")
	public void SearchSystemGeneratedNumber(String Testcase, String RunMode, String SBU, String sbu,
			String DatabaseName, String Template, String defaultFlag, String CreatedBy, String SortBy,
			String Direction) {
		HomePage homepage = new HomePage(driver, test);
		SearchSystemGeneratedNumberPage searchpage = new SearchSystemGeneratedNumberPage(driver, test);
		ResultSystemGeneratedNumberPage ResultSystemGeneratedNumberTitle = new ResultSystemGeneratedNumberPage(driver,
				test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoSystemGeneratedNumber();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, DatabaseName, Template, defaultFlag, CreatedBy, SortBy,
							Direction);
					searchpage.searchbutton();
					ResultSystemGeneratedNumberTitle.ResultSystemGeneratedNumberIsDisplayed();
					Wait.waitfor(2);

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
