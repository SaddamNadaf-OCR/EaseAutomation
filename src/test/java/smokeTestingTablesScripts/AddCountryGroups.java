package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CountryConfigurationPage;
import tablesClasses.CountryGroups;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class AddCountryGroups extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddCountrygroup", excel);
	}

	@Test(dataProvider = "getData")
	public void countrygroups(String Testcase, String RunMode, String SBU, String GroupType, String CountryGrpCode, String Effecivedate, String Country) {

		HomePageTables homepage = new HomePageTables(driver, test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		CountryGroups cntrygrp = new CountryGroups(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocommondata();

					Wait.waitfor(2);
					homepage.clickoncoutryGroups();
					Wait.waitfor(2);
					cntrygrp.click_Addcountrygrps();
					Wait.waitfor(2);
					
					if (GroupType.length() > 0) {
						cntrygrp.click_grouptype();
						cntrygrp.addgrouptype(GroupType);
							
					}
					
					Wait.waitfor(2);
					if (CountryGrpCode.length() > 0) {
						cntrygrp.click_countrygrpcode();
						cntrygrp.addcountrygroupcode(CountryGrpCode);
					
					}
					cntrygrp.effectiveDate(Effecivedate);

					cntrygrp.country(Country);
					Wait.waitfor(2);

					cntrygrp.save();
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
