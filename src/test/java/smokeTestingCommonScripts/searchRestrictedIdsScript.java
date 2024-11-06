package smokeTestingCommonScripts;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultRestrictedValuesPage;
import filesClasses.searchRestrictedIdsPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

	
@Test
public class searchRestrictedIdsScript extends  SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchRestrictedIds", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchRestrictedIds(String Testcase, String RunMode, String SBU, String sbu, String DataBaseName,String Createdby, String SortBy) {
		HomePage homepage=new HomePage(driver,test);
		searchRestrictedIdsPage searchpage=new searchRestrictedIdsPage(driver,test);
		ResultRestrictedValuesPage ResultSearchRestrictedIdsTitle=new ResultRestrictedValuesPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoRestrictedValues();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, DataBaseName, Createdby, SortBy);
					searchpage.searchbutton();
					ResultSearchRestrictedIdsTitle.ResultSearchRestrictedIdsIsDisplayed();
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


		
		
		
		
		
		

		

		
		




