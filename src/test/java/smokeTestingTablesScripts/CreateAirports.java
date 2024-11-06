package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateAirportsPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchAirportsPage;
import utilities.Utility;
import utilities.Wait;

public class CreateAirports extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddAirports", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddAirports(String Testcase, String RunMode, String SBU, String AirportCode, String CountryCode, String AirportName) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAirportsPage searchpage=new SearchAirportsPage(driver,test);
		CreateAirportsPage CreatePage=new CreateAirportsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAirports();
					Wait.waitfor(10);
					searchpage.addAirports();
					CreatePage.enter_AirportCode(AirportCode,CountryCode, AirportName);
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