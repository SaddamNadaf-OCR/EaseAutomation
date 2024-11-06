package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultModeOfTransportPage;

import tablesClasses.SearchModeOfTransportPage;
import utilities.Utility;
import utilities.Wait;

public class SearchModeOfTransportScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchModeOfTransport", excel);
		
	}
	@Test(dataProvider = "getData")
	public void SearchModeOfTransport(String Testcase, String RunMode, String SBU, String MOTCode, String Country, String status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchModeOfTransportPage searchpage=new SearchModeOfTransportPage(driver,test);
		ResultModeOfTransportPage ResultPage=new ResultModeOfTransportPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoModeofTransport();
					Wait.waitfor(2);
					searchpage.searchbyParameters(MOTCode ,Country, status);
					searchpage.searchbutton();
					ResultPage.ModeOfTransportIsDisplayed();
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
