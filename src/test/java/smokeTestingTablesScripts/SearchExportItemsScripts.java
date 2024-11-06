package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultExportItemsPage;

import tablesClasses.SearchExportItemsPage;
import utilities.Utility;
import utilities.Wait;

public class SearchExportItemsScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchExportItems", excel);
		
	}
	@Test(dataProvider = "getData")
	public void SearchExportItems(String Testcase, String RunMode, String SBU, String Country, String ExportClassification, String status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchExportItemsPage searchpage=new SearchExportItemsPage(driver,test);
		ResultExportItemsPage ResultPage=new ResultExportItemsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoExportItems();
					Wait.waitfor(2);
					searchpage.searchbyParameters(Country ,ExportClassification, status);
					searchpage.searchbutton();
					ResultPage.ExportItemsIsDisplayed();
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
