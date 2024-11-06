package smokeTestingTablesScripts;
/* 
* Module : Common & User
* Author  : Rakesh
* created date : April 2024
* Descriptions : SmokeTest of Tables "SearchAESDirectInvalidHTSCodes"
* changed by : Nil
* changed date : Nil
* Purpose of change : Nil 
* Reviewed by : Nil 
*/
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAESDirectInvalidHTSCodesPage;
import tablesClasses.SearchAESDirectInvalidHTSCodePage;
import utilities.Utility;
import utilities.Wait;

public class SearchAESDirectInvalidHTSCodesScripts extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchInvalidHTS", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchAESDirectInvalidHTSCodes(String Testcase, String RunMode, String SBU, String HTSNo, String Description, String status, String SortBy, String direction) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchAESDirectInvalidHTSCodePage searchpage=new SearchAESDirectInvalidHTSCodePage(driver,test);
		ResultAESDirectInvalidHTSCodesPage SearchAESDirectInvalidHTS=new ResultAESDirectInvalidHTSCodesPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAESIvalidHTSCodes();
					Wait.waitfor(4);
					searchpage.searchbyParameters(HTSNo, Description, status, SortBy, direction);
					searchpage.searchbutton();
					SearchAESDirectInvalidHTS.AESDirectInvalidHTSIsDisplayed();
					Wait.waitfor(2);
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
