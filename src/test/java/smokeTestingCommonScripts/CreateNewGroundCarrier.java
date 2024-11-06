package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewGroundCarrierPage;
import filesClasses.HomePage;

import filesClasses.SearchGroundCarrierPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewGroundCarrier extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateGroundCarrier", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateGroundCarrier(String Testcase, String RunMode, String SBU, String GroundCarrierCode, String GroundCarriername, String IATACode) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchGroundCarrierPage searchpage=new SearchGroundCarrierPage(driver,test);
		CreateNewGroundCarrierPage CreatePage=new CreateNewGroundCarrierPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoGroundCarrier();
					Wait.waitfor(10);
					searchpage.addGroundCarrier();
					CreatePage.enter_GroundCarrierCode(GroundCarrierCode, GroundCarriername, IATACode);
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
