package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultCorrectiveActionPage;
import filesClasses.SearchCorrectiveActionPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchCorrectiveActionScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCorrectiveAction", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchCorrectiveAction(String Testcase, String RunMode, String SBU, String sbu, String Code, String Status, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchCorrectiveActionPage searchpage=new SearchCorrectiveActionPage(driver,test);
		ResultCorrectiveActionPage CorrectiveActionTitle=new ResultCorrectiveActionPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIM(SBU);
					homepage.movetoCorrectiveAction();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, Code, Status, SortBy, direction);
					searchpage.searchbutton();
					CorrectiveActionTitle.ResultCorrectiveActionIsDisplayed();
					Wait.waitfor(2);
					homepage.returnToIMHomePage();

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
			homepage.returnToIMHomePage();
			Assert.assertTrue(false);
		}

	}


}
