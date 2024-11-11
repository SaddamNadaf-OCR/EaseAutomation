package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;
import tablesClasses.ResultITARExemptionPage;

import tablesClasses.SearchITARExemptionsPage;

import utilities.Utility;
import utilities.Wait;

public class SearchITARExemptionsScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchITARExemption", excel);
		
	}
	@Test(dataProvider = "getData")
	public void SearchITARExemption(String Testcase, String RunMode, String SBU, String Country, String Description, String Status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchITARExemptionsPage searchpage=new SearchITARExemptionsPage(driver,test);
		ResultITARExemptionPage ResultPage=new ResultITARExemptionPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoITARExemptions();
					Wait.waitfor(2);
					searchpage.searchbyParameters(Country ,Description, Status);
					searchpage.searchbutton();
					ResultPage.ITARExemptionIsDisplayed();
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
