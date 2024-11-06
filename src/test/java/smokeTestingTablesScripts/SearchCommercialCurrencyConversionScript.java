package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.HomePageTables;
import tablesClasses.ResultCommercialCurrencyConversion;

import tablesClasses.SearchCommercialCurrencyConversionPage;
import utilities.Utility;
import utilities.Wait;

public class SearchCommercialCurrencyConversionScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCommCurrConv", excel);
	}
	@Test(dataProvider = "getData")
	public void SearchCommCurrConv(String Testcase, String RunMode, String SBU,String Currency, String Status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCommercialCurrencyConversionPage searchpage=new SearchCommercialCurrencyConversionPage(driver,test);
		ResultCommercialCurrencyConversion SearchCurrency=new ResultCommercialCurrencyConversion(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(2);
					homepage.clickonCommercialCurrencyConversion();
					Wait.waitfor(4);
					searchpage.NewSearchbutton();
					Wait.waitfor(4);
					searchpage.searchbyParameters(Currency ,Status);
					searchpage.searchbutton();
					SearchCurrency.CommercialCurrencyConversionIsDisplayed();
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
