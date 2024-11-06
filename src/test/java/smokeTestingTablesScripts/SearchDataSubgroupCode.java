package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CountryGroups;

import tablesClasses.DataGroupSubCodes;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class SearchDataSubgroupCode extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDataSubGoupCode", excel);

	}

	@Test(dataProvider = "getData")
	public void SearchContrygroup(String Testcase, String RunMode, String SBU, String GroupCode, String Subcode, String status, String SortBy, String direction) {

HomePageTables homepage = new HomePageTables(driver, test);
ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
CountryGroups cntrygrp = new CountryGroups(driver, test);
DataGroupSubCodes datasbgrpcode = new DataGroupSubCodes(driver, test);

try {
	if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
		throw new SkipException("Skipping the test");
	} else {
		if (RunMode.equalsIgnoreCase("y")) {
			test.log(LogStatus.INFO, Testcase);
			homepage.moveTo_SBUSelectionEO(SBU);
			homepage.movetocommondata();

			Wait.waitfor(2);
			homepage.clickondatasubgrpcodes();
			datasbgrpcode.searchbyParameters(GroupCode, Subcode, status, SortBy, direction);
			datasbgrpcode.searchbutton();
			SearchAirports.countryconfigsrchpage();
			Wait.waitfor(2);
			SearchAirports.searchresultIsDisplayed();
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
