package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateModeOfTransportPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchModeOfTransportPage;
import utilities.Utility;

public class CreateModeOfTransport extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddModeOfTransport", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddModeOfTransport(String Testcase, String RunMode, String SBU, String MOTCode, String Country, String MOTID, String MOTDesc, String MOTType) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchModeOfTransportPage searchpage=new SearchModeOfTransportPage(driver,test);
		CreateModeOfTransportPage CreatePage=new CreateModeOfTransportPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoModeofTransport();
					
					searchpage.AddMOT();
					CreatePage.enter_MOTCode(MOTCode,Country, MOTID, MOTDesc, MOTType);
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
