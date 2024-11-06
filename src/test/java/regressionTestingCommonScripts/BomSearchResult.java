package regressionTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AuthorizationMgmtHomepagePage;
import filesClasses.ResultSearchBomPage;
import filesClasses.SearchBOMPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class BomSearchResult extends SeleniumTestBase {

	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("BomSearchResult", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPage(String testcases, String RunMode, String SBU, String PartNO, String ManufacturerUserName) {

		AuthorizationMgmtHomepagePage hpAuthOwner = new AuthorizationMgmtHomepagePage(driver, test);
		ResultSearchBomPage rsltsecBOM = new ResultSearchBomPage(driver, test);
		SearchBOMPage srchBOM= new SearchBOMPage(driver, test);
	
	
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					hpAuthOwner.moveTo_SBUSelection(SBU);
					Wait.waitfor(2);
					hpAuthOwner.movetoBOM();
					Wait.waitfor(2);
				srchBOM.SearchBoM(PartNO, ManufacturerUserName);
					Wait.waitfor(2);
					srchBOM.Click_search();
					Wait.waitfor(2);
					rsltsecBOM.displayOfTitle();
				
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		
		} catch (SkipException s) {
			test.log(LogStatus.INFO, testcases);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			hpAuthOwner.logout();

		}
	}
}
