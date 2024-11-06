package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.DataGroupCodes;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import tablesClasses.StaticDataConfiguration;
import utilities.Utility;
import utilities.Wait;

public class AddStaticdataConfiguration extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddStaticdataConfig", excel);
	}

	@Test(dataProvider = "getData")
	public void countrygroups(String Testcase, String RunMode, String SBU, String Country, String StaticDataType, String ConfigurationValue) {
		
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		StaticDataConfiguration statconfig= new StaticDataConfiguration(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocommondata();
					Wait.waitfor(2);
					homepage.clickonstaticdataconfig();
					Wait.waitfor(2);
					statconfig.addstaticdata();
					Wait.waitfor(2);
					statconfig.addcountry(Country);
					statconfig.otherdetails(StaticDataType, ConfigurationValue);	
					Wait.waitfor(2);
					statconfig.savebutton();
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

	