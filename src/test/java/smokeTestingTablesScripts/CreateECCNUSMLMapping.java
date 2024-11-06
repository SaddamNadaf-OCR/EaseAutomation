package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateECCNUSMLMappingPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchECCNUSMLMappingPage;
import utilities.Utility;


public class CreateECCNUSMLMapping extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddECCNUSML", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddECCNUSML(String Testcase, String RunMode, String SBU, String USML, String ECCN) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchECCNUSMLMappingPage searchpage=new SearchECCNUSMLMappingPage(driver,test);
		CreateECCNUSMLMappingPage CreatePage=new CreateECCNUSMLMappingPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoECCNUSMLMapping();
					searchpage.ECCNUSMLMapping();
					CreatePage.enter_ECCNCode(USML,ECCN);
					
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
