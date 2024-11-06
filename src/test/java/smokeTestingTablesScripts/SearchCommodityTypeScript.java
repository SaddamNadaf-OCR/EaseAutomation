package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultCommodityTypePage;

import tablesClasses.SearchCommodityTypePage;
import utilities.Utility;
import utilities.Wait;

public class SearchCommodityTypeScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCommodityType", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchCommodityType(String Testcase, String RunMode, String SBU, String CommodityTypeCode, String CommodityTypeDescription, String TechDataType,String status,String CreatedBy,String SortBy,String direction) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCommodityTypePage searchpage=new SearchCommodityTypePage(driver,test);
		ResultCommodityTypePage SearchCommodityType=new ResultCommodityTypePage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoCommodityType();
					Wait.waitfor(4);
					searchpage.searchbyParameters(CommodityTypeCode , CommodityTypeDescription, TechDataType, status,CreatedBy, SortBy, direction);
					searchpage.searchbutton();
					SearchCommodityType.CommodityTypeIsDisplayed();
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
