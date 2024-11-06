package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateCommodityTypePage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchCommodityTypePage;
import utilities.Utility;
import utilities.Wait;

public class CreateCommodityType extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddCommodityType", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddCommodityType(String Testcase, String RunMode, String SBU, String CommodityTypeCode, String CommodityTypeDescription, String Status) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchCommodityTypePage searchpage=new SearchCommodityTypePage(driver,test);
		CreateCommodityTypePage CreatePage=new CreateCommodityTypePage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoCommodityType();
					Wait.waitfor(10);
					searchpage.addCommodityType();
					CreatePage.enter_CommodityTypeCode(CommodityTypeCode,CommodityTypeDescription, Status);
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
