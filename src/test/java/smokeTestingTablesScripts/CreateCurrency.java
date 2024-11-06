package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateCurrencyPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchCurrencyPage;
import utilities.Utility;
import utilities.Wait;

public class CreateCurrency extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddCurrency", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddCurrency(String Testcase, String RunMode, String SBU, String CurrencyCode, String Description, String CountryCode, String CustomCountryCode, String CustomCurrencyCode) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCurrencyPage searchpage=new SearchCurrencyPage(driver,test);
		CreateCurrencyPage CreatePage=new CreateCurrencyPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(2);
					homepage.clickonCurrency();
					Wait.waitfor(4);
					searchpage.addCurrency();
					CreatePage.enter_CurrencyCode(CurrencyCode,Description, CountryCode, CustomCountryCode, CustomCurrencyCode);
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
