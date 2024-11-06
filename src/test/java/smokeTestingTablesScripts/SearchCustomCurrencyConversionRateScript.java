package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;
import tablesClasses.ResultCustomCurrencyConversionRate;

import tablesClasses.SearchCustomCurrencyConversionRatepage;
import utilities.Utility;
import utilities.Wait;

public class SearchCustomCurrencyConversionRateScript extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCustCurrConvRate", excel);
	}
	@Test(dataProvider = "getData")
	public void SearchCustCurrConvRate(String Testcase, String RunMode, String SBU,String Country, String RateType,  String Status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCustomCurrencyConversionRatepage searchpage=new SearchCustomCurrencyConversionRatepage(driver,test);
		ResultCustomCurrencyConversionRate SearchCurrency=new ResultCustomCurrencyConversionRate(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(2);
					homepage.clickonCustomCurrencyConversionRate();
					Wait.waitfor(4);
					searchpage.searchbyParameters(Country ,RateType, Status);
					searchpage.searchbutton();
					SearchCurrency.CustomCurrencyConversionRateIsDisplayed();
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
