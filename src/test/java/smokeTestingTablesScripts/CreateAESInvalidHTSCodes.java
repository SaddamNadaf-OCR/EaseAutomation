package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CreateAESDirectInvalidHTSCodesPage;
import tablesClasses.HomePageTables;
import tablesClasses.SearchAESDirectInvalidHTSCodePage;
import utilities.Utility;
import utilities.Wait;

public class CreateAESInvalidHTSCodes extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateHTSCodes", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateHTSCodes(String Testcase, String RunMode, String SBU, String HTSNo, String Descriptions) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAESDirectInvalidHTSCodePage searchpage=new SearchAESDirectInvalidHTSCodePage(driver,test);
		CreateAESDirectInvalidHTSCodesPage CreatePage=new CreateAESDirectInvalidHTSCodesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAESIvalidHTSCodes();
					Wait.waitfor(10);
					searchpage.addAESInvalidHTS();
					CreatePage.enter_HTSNo(HTSNo, Descriptions);
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
