package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateExportItemsPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchExportItemsPage;
import utilities.Utility;

public class CreateExportItemsScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddExportItems", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddExportItems(String Testcase, String RunMode, String SBU, String ECCN, String Descriptions, String ControllingAgency) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchExportItemsPage searchpage=new SearchExportItemsPage(driver,test);
		CreateExportItemsPage CreatePage=new CreateExportItemsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoExportItems();
					searchpage.AddExportItems();
					CreatePage.enter_ExportItemsCode(ECCN, Descriptions);
					CreatePage.Add_ControllingAgency(ControllingAgency);
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
