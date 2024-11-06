package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateBondedCarrierDetailsPage;
import filesClasses.HomePage;


import filesClasses.SearchBondedCarrierPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateBondedCarrier extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateNewBondedCarrier", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateNewBondedCarrier(String Testcase, String RunMode, String SBU,String CarrierCode, String CarrierName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchBondedCarrierPage searchpage=new SearchBondedCarrierPage(driver,test);
		CreateBondedCarrierDetailsPage CreatePage=new CreateBondedCarrierDetailsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionFTZ(SBU);
					homepage.movetoFiles();
					searchpage.addCarrierName();
					CreatePage.enterCarrierCode(CarrierCode,CarrierName);
					CreatePage.saveandReturn();
					
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
			homepage.returnToProductReportPage();
			Assert.assertTrue(false);
		}
	}


}
