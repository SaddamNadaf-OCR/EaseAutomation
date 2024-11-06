package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;
import tablesClasses.ResultComericialCurrencyConversionRatePage;

import tablesClasses.SearchCommercialCurrencyConversionRatePage;

import utilities.Utility;
import utilities.Wait;

public class SearchCommercialCurrencyConversionRateScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCommercialCurrency", excel);

	}
	@Test(dataProvider = "getData")
	public void SearchCommercialCurrency(String Testcase, String RunMode, String SBU,String Currency, String status, String SortBy) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCommercialCurrencyConversionRatePage searchpage=new SearchCommercialCurrencyConversionRatePage(driver,test);
		ResultComericialCurrencyConversionRatePage SearchCurrency=new ResultComericialCurrencyConversionRatePage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(2);
					homepage.clickonCommercialCurrencyConversionRate();
					Wait.waitfor(4);
					searchpage.searchbyParameters(Currency ,status, SortBy);
					searchpage.searchbutton();
					SearchCurrency.CommercialIsDisplayed();
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
