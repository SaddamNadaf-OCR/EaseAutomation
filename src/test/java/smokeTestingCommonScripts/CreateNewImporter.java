package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewImporterPage;
import filesClasses.HomePage;


import filesClasses.SearchImportersPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewImporter extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateImporter", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateImporter(String Testcase, String RunMode, String SBU,String ImporterCode, String ImporterName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchImportersPage searchpage=new SearchImportersPage(driver,test);
		CreateNewImporterPage CreatePage=new CreateNewImporterPage(driver,test);
	
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoImporters();
					searchpage.addImportersName();
					CreatePage.enterImporterCode(ImporterCode,ImporterName);
					CreatePage.saveandReturn();
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
