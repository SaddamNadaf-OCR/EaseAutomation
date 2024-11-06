package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultImportersPage;

import filesClasses.SearchImportersPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchImportersScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchImporter", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchImporter(String Testcase, String RunMode, String SBU, String sbu, String ImporterName, String Status, String CreatedBy, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchImportersPage searchpage=new SearchImportersPage(driver,test);
		ResultImportersPage ResultListImporterTitle=new ResultImportersPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoImporters();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,ImporterName,Status,CreatedBy,SortBy,direction);
					searchpage.searchbutton();
					ResultListImporterTitle.ResultListImporterIsDisplayed();
					Wait.waitfor(2);
				
					homepage.returnToIOHomePage();
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
			homepage.returnToIOHomePage();
			Assert.assertTrue(false);
		}
		
	}

}
