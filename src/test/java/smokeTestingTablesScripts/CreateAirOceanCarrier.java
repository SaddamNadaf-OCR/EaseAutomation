package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateAirOceanCarrierPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchAirOceanCarrierPage;
import utilities.Utility;
import utilities.Wait;

public class CreateAirOceanCarrier extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddCarrier", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddCarrier(String Testcase, String RunMode, String SBU, String Code, String SCACIATACode, String Descriptions) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAirOceanCarrierPage searchpage=new SearchAirOceanCarrierPage(driver,test);
		CreateAirOceanCarrierPage CreatePage=new CreateAirOceanCarrierPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAirOceanCarrier();
					Wait.waitfor(10);
					searchpage.addCarrier();
					CreatePage.enter_Code(Code,SCACIATACode, Descriptions);
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
