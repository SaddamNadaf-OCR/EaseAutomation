package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.BondedCarrierPage;
import filesClasses.HomePage;
import filesClasses.SearchBondedCarrierPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchBondedCarrierDetailsScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchBondedCarrier", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchBondedCarrier(String Testcase, String RunMode, String SBU, String sbu, String CarrierName, String CarrierCode, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchBondedCarrierPage searchpage=new SearchBondedCarrierPage(driver,test);
		BondedCarrierPage BcTitle=new BondedCarrierPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionFTZ(SBU);
					homepage.movetoFiles();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,CarrierName,CarrierCode,SortBy,direction);
					searchpage.searchbutton();
					BcTitle.BondedCarrierIsDisplayed();
					Wait.waitfor(2);
					homepage.returnToFTZHomePage();
				
					
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
			homepage.returnToFTZHomePage();
			Assert.assertTrue(false);
		}
		
	}


}
