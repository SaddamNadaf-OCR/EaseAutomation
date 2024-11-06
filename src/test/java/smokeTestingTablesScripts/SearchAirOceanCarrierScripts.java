package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultAirOceanCarrierPage;
import tablesClasses.ResultAirportsPage;
import tablesClasses.SearchAirOceanCarrierPage;
import utilities.Utility;
import utilities.Wait;

public class SearchAirOceanCarrierScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchCarriers", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchCarriers(String Testcase, String RunMode, String SBU, String Code, String Description, String status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAirOceanCarrierPage searchpage=new SearchAirOceanCarrierPage(driver,test);
		ResultAirOceanCarrierPage SearchAirOceanCarrier=new ResultAirOceanCarrierPage(driver,test);
		ResultAirportsPage SearchAirports = new ResultAirportsPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAirOceanCarrier();
					Wait.waitfor(4);
					searchpage.searchbyParameters(Code , Description, status);
					searchpage.searchbutton();
					SearchAirOceanCarrier.AirOceanCarrierIsDisplayed();
					Wait.waitfor(2);
					SearchAirports.searchresultIsDisplayed();
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
