package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultProductLinesPage;
import filesClasses.SearchProductLinesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchProductLinesScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchProductLine", excel);
	}
	
	@Test(dataProvider = "getData")
	public void SearchProductLine(String Testcase, String RunMode, String SBU, String sbu, String ProductLineId, String ProductLineName, String CreatedBy, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchProductLinesPage searchpage=new SearchProductLinesPage(driver,test);
		ResultProductLinesPage ProductLineTitle=new ResultProductLinesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoProductLines();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,ProductLineId,ProductLineName,CreatedBy,SortBy,direction);
					searchpage.searchbutton();
					ProductLineTitle.ResultSearchProductLineIsDisplayed();
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
