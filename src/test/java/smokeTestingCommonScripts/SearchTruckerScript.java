package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultTruckersPage;
import filesClasses.SearchTruckerPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class SearchTruckerScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchTrucker", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchProgram(String Testcase, String RunMode, String SBU, String sbu,String Name,String Id,String Status,String CreatedBy,String SortBy,String Direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchTruckerPage searchpage=new SearchTruckerPage(driver,test);
		ResultTruckersPage ResultTruckerTitle=new ResultTruckersPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionWLS(SBU);
					homepage.movetoTruckers();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,Name,Id,Status,CreatedBy,SortBy,Direction);
					searchpage.searchbutton();
					ResultTruckerTitle.ResultTruckerIsDisplayed();
					Wait.waitfor(2);
					
					homepage.returnToWLSHomePage();
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
			homepage.returnToWLSHomePage();
			Assert.assertTrue(false);
		}
	}

}
