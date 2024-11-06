package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateNewCurrencyExchangeRateRulesPage;
import tablesClasses.HomePageTables;
import tablesClasses.SearchCurrencyExchangeRateRulesPage;

import utilities.Utility;
import utilities.Wait;

public class CreateCurrencyExchangeRateRules extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CurrencyRateRules", excel);
		
	}
	@Test(dataProvider = "getData")
	public void CurrencyRateRules(String Testcase, String RunMode, String SBU, String CustomCountry, String StandardRateType, String RateAsOn, String Type) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCurrencyExchangeRateRulesPage searchpage=new SearchCurrencyExchangeRateRulesPage(driver,test);
		CreateNewCurrencyExchangeRateRulesPage CreatePage=new CreateNewCurrencyExchangeRateRulesPage(driver,test);
		
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
					searchpage.addCurrencyRules();
					CreatePage.enter_Country(CustomCountry,StandardRateType, RateAsOn, Type );
					CreatePage.saveandReturn();
					
				
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
