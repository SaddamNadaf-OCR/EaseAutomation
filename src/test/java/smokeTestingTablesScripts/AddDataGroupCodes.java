package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CountryGroups;
import tablesClasses.DataGroupCodes;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class AddDataGroupCodes extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDatagroupCode", excel);
	}

	@Test(dataProvider = "getData")
	public void countrygroups(String Testcase, String RunMode, String SBU, String GroupCode, String Description, String Remarks) {
	
		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		DataGroupCodes datagrpcode= new DataGroupCodes(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocommondata();

					Wait.waitfor(2);
					homepage.clickondatagrpcodes();
					Wait.waitfor(2);
					datagrpcode.addbutton();
					Wait.waitfor(2);
					datagrpcode.AddbyParameters(GroupCode, Description, Remarks);
					
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
