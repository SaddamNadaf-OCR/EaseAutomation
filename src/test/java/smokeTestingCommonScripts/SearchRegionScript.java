package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultRegionPage;
import filesClasses.SearchRegionPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchRegionScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchRegion", excel);

	}

	@Test(dataProvider = "getData")
	public void SearchRegion(String Testcase, String RunMode, String SBU, String sbu, String RegionId,
			String RegionName, String Status, String CreatedBy, String SortBy, String direction) {
		HomePage homepage = new HomePage(driver, test);
		SearchRegionPage searchpage = new SearchRegionPage(driver, test);
		ResultRegionPage RegionTitle = new ResultRegionPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoRegion();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, RegionId, RegionName, Status, CreatedBy, SortBy, direction);
					searchpage.searchbutton();
					RegionTitle.ResultListRegionIsDisplayed();
					Wait.waitfor(2);
					homepage.returnToGExportHomePage();
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
			homepage.returnToGExportHomePage();
			Assert.assertTrue(false);
		}

	}

}
