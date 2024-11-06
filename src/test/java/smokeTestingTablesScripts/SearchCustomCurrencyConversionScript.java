package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CustomCurrencyConversionPage;
import tablesClasses.HomePageTables;
import tablesClasses.ResultCustomCurrencyConversion;

import utilities.Utility;
import utilities.Wait;

public class SearchCustomCurrencyConversionScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCustCurrConv", excel);
	}
	@Test(dataProvider = "getData")
	public void SearchCustCurrConv(String Testcase, String RunMode, String SBU,String Country, String RateType,  String Status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		CustomCurrencyConversionPage searchpage=new CustomCurrencyConversionPage(driver,test);
		ResultCustomCurrencyConversion SearchCurrency=new ResultCustomCurrencyConversion(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(2);
					homepage.clickonCustomCurrencyConversion();
					Wait.waitfor(4);
					searchpage.searchbyParameters(Country ,RateType, Status);
					searchpage.searchbutton();
					SearchCurrency.CustomCurrencyConversionIsDisplayed();
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
