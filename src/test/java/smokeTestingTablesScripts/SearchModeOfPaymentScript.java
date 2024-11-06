package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.HomePageTables;

import tablesClasses.ResultModeOfPaymentPage;

import tablesClasses.SearchModeOfPaymentPage;
import utilities.Utility;
import utilities.Wait;

public class SearchModeOfPaymentScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchModeOfPayment", excel);
		
	}
	@Test(dataProvider = "getData")
	public void SearchModeOfPayment(String Testcase, String RunMode, String SBU, String PaymentCode, String Description, String status) {
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchModeOfPaymentPage searchpage=new SearchModeOfPaymentPage(driver,test);
		ResultModeOfPaymentPage ResultPage=new ResultModeOfPaymentPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoModeOfPayment();
					Wait.waitfor(2);
					searchpage.searchbyParameters(PaymentCode ,Description, status);
					searchpage.searchbutton();
					ResultPage.ModeOfPaymentIsDisplayed();
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
