package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CreateCustomCurrencyConversionPage;

import tablesClasses.CustomCurrencyConversionPage;
import tablesClasses.HomePageTables;

import utilities.Utility;
import utilities.Wait;

public class CreateCustomCurrencyConversion extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddCustCurrConv", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddCustCurrConv(String Testcase, String RunMode, String SBU, String CurrencyFrom, String CurrencyTo, String CountryCode, String ConversionRate, String RateType, String ValidFrom, String ValidTo ) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		CustomCurrencyConversionPage searchpage=new CustomCurrencyConversionPage(driver,test);
		CreateCustomCurrencyConversionPage CreatePage=new CreateCustomCurrencyConversionPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetocurrency();
					Wait.waitfor(4);
					homepage.clickonCustomCurrencyConversion();
					Wait.waitfor(4);
					searchpage.addCustomCurrencyConversion();
					CreatePage.enter_Code(CurrencyFrom,CurrencyTo, CountryCode, ConversionRate, RateType, ValidFrom, ValidTo);
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
