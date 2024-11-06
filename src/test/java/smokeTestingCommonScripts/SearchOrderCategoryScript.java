package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultOrderCategoryPage;
import filesClasses.SearchOrderCategoryPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchOrderCategoryScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchOrderCategory", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchOrderCategory(String Testcase, String RunMode, String SBU, String sbu, String OrderCategoryType, String OrderCategoryName, String Status, String CreatedBy, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchOrderCategoryPage searchpage=new SearchOrderCategoryPage(driver,test);
		ResultOrderCategoryPage OrderCategoryTitle=new ResultOrderCategoryPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoOrderCategory();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, OrderCategoryType, OrderCategoryName, Status, CreatedBy, SortBy, direction);
					searchpage.searchbutton();
					OrderCategoryTitle.ResultListOrderCategoryIsDisplayed();
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
