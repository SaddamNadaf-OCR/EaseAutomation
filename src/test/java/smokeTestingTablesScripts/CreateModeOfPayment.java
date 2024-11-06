package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;

import tablesClasses.CreateModeOfPaymentPage;
import tablesClasses.HomePageTables;

import tablesClasses.SearchModeOfPaymentPage;
import utilities.Utility;


public class CreateModeOfPayment extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddModeOfPayment", excel);
		
	}
	@Test(dataProvider = "getData")
	public void AddModeOfPayment(String Testcase, String RunMode, String SBU, String PaymentCode, String Description, String CountryCode, String Qualifier, String Notes) {
		
		HomePageTables homepage=new HomePageTables(driver,test);
		SearchModeOfPaymentPage searchpage=new SearchModeOfPaymentPage(driver,test);
		CreateModeOfPaymentPage CreatePage=new CreateModeOfPaymentPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoModeOfPayment();
					
					searchpage.AddMOP();
					CreatePage.enter_MOPCode(PaymentCode,Description, CountryCode, Qualifier, Notes);
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
