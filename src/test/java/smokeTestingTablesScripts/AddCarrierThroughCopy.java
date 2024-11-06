package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.HomePageTables;
import tablesClasses.ResultAirOceanCarrierPage;
import tablesClasses.SearchAirOceanCarrierPage;
import utilities.Utility;
import utilities.Wait;

public class AddCarrierThroughCopy extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CopyCarrier", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CopyCarrier(String Testcase, String RunMode, String SBU,String OldCode, String newCode) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAirOceanCarrierPage searchpage=new SearchAirOceanCarrierPage(driver,test);
		ResultAirOceanCarrierPage Resultpage=new ResultAirOceanCarrierPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAirOceanCarrier();
					Wait.waitfor(10);
					searchpage.add_OldCode(OldCode);
					searchpage.searchbutton();
					Resultpage.copyCarrier();
					Resultpage.enter_Code(newCode);
					Resultpage.saveandReturn();
					
				
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