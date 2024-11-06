package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultPriorityPage;

import filesClasses.SearchPriorityPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchPriorityScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchPriority", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchPriority(String Testcase, String RunMode, String SBU, String sbu,String PriorityType,String PriorityName,String Status,String CreatedBy,String SortBy,String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchPriorityPage searchpage=new SearchPriorityPage(driver,test);
		ResultPriorityPage ListPriorityTitle=new ResultPriorityPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetopriority();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, PriorityType, PriorityName, Status, CreatedBy, SortBy, direction);
					searchpage.searchbutton();
					ListPriorityTitle.ResultListPriorityIsDisplayed();
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
