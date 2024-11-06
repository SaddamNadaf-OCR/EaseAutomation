package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CreateLocationDetailsPage;

import tablesClasses.HomePageTables;
import tablesClasses.SearchLocationDetailsPage;

import utilities.Utility;

public class CreateLocationDetails extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddLocationDetails", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddLocationDetails(String Testcase, String RunMode, String SBU, String CountryGroupCode, String LocationType, String LocationCode, String LanguageCode) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchLocationDetailsPage searchpage=new SearchLocationDetailsPage(driver,test);
		CreateLocationDetailsPage CreatePage=new CreateLocationDetailsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoLocationDetails();
					
					searchpage.AddLocationDetails();
					CreatePage.enter_LocationCode(CountryGroupCode,LocationType, LocationCode, LanguageCode);
					CreatePage.saveandReturn();
					
				
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
