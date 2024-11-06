package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultCustomCurrencyRateRulesPage;
import tablesClasses.SearchCurrencyExchangeRateRulesPage;

import utilities.Utility;
import utilities.Wait;

public class SearchCurrencyExchangeRateRulesScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCurrencyRateRules", excel);
	}
	@Test(dataProvider = "getData")
	public void SearchCurrencyRateRules(String Testcase, String RunMode, String SBU,String CustomsCountry, String status,  String Type) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCurrencyExchangeRateRulesPage searchpage=new SearchCurrencyExchangeRateRulesPage(driver,test);
		ResultCustomCurrencyRateRulesPage SearchCurrency=new ResultCustomCurrencyRateRulesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(2);
					homepage.clickonCurrencyExchangeRateRules();
					Wait.waitfor(4);
					searchpage.searchbyParameters(CustomsCountry ,status, Type);
					searchpage.searchbutton();
					SearchCurrency.CurrencyRulesIsDisplayed();
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
