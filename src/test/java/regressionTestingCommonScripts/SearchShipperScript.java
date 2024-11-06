package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultShippersPage;
import filesClasses.SearchShipperPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class SearchShipperScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchShipperData", excel);

	}

	@Test(dataProvider = "getData")
	public void SearchProgram(String Testcase, String RunMode, String SBU, String sbu, String Name, String Country,
			String ManufacturerID, String Status, String SortBy, String Direction, String CreatedBy, String Code,
			String Zip) {
		HomePage homepage = new HomePage(driver, test);
		SearchShipperPage searchpage = new SearchShipperPage(driver, test);
		ResultShippersPage ResultShipperDataTitle = new ResultShippersPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionWLS(SBU);
					homepage.movetoShippers();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, Name, Country, ManufacturerID, Status, SortBy, Direction,
							CreatedBy, Code, Zip);
					searchpage.searchbutton();
					ResultShipperDataTitle.ResultShipperDataIsDisplayed();
					Wait.waitfor(2);

					homepage.returnToWLSHomePage();
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
			homepage.returnToWLSHomePage();
			Assert.assertTrue(false);
		}
	}

}
