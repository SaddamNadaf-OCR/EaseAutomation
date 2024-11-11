package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CreateITARExemptionsPage;

import tablesClasses.HomePageTables;
import tablesClasses.SearchITARExemptionsPage;

import utilities.Utility;

public class CreateITARExemption extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateITAR", excel);
		
	}
	@Test(dataProvider = "getData")
	public void CreateITAR(String Testcase, String RunMode, String SBU, String Country, String Activity, String Authorization, String Description, String TransactionType) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchITARExemptionsPage searchpage=new SearchITARExemptionsPage(driver,test);
		CreateITARExemptionsPage CreatePage=new CreateITARExemptionsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoITARExemptions();
					
					searchpage.AddITARExemption();
					CreatePage.enter_ITARCode(Country,Activity, Authorization, Description, TransactionType);
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
