package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CountryConfigurationPage;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class AddCountryConfigurations extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCountryConfg", excel);
	}

	@Test(dataProvider = "getData")
	public void CountryConfigurations(String Testcase, String RunMode, String SBU, String CountryGrpCode, String ConfigType,
			String Effecivedate, String configurationvalue) {

		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		CountryConfigurationPage cntryconf = new CountryConfigurationPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocommondata();

					Wait.waitfor(2);
					homepage.clickoncoutryconfig();
					Wait.waitfor(2);
					cntryconf.addCountryCofig();
					Wait.waitfor(2);
					if (CountryGrpCode.length() > 0) {
						cntryconf.click_countrygrpcode();
						cntryconf.addcountrygroupcode(CountryGrpCode);
					}
					
					Wait.waitfor(2);
					if (CountryGrpCode.length() > 0) {
						cntryconf.click_confgtype();
						cntryconf.addconfigtype(ConfigType);
					}
					cntryconf.effectiveDate(Effecivedate);

					cntryconf.configvalue(configurationvalue);
					Wait.waitfor(2);

					cntryconf.save();
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
