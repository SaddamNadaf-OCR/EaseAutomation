package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewChargesPage;
import filesClasses.HomePage;


import filesClasses.SearchChargesPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateCharges extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ChargeDetails", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void ChargeDetails(String Testcase, String RunMode, String SBU,String ChargeCode, String ChargeDescription, String ChargeIncurredAt) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchChargesPage searchpage=new SearchChargesPage(driver,test);
		CreateNewChargesPage CreatePage=new CreateNewChargesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoCharges();
					searchpage.addChargeCode();
					CreatePage.enterChargeCode(ChargeCode,ChargeDescription,ChargeIncurredAt);
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
