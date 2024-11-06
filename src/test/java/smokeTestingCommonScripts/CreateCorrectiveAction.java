package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.CreateNewCorrectiveActionPage;
import filesClasses.HomePage;


import filesClasses.SearchCorrectiveActionPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateCorrectiveAction extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateNewCorrectiveAction", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateNewCorrectiveAction(String Testcase, String RunMode, String SBU,String SBUCode, String Code, String Description, String Title ) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchCorrectiveActionPage searchpage=new SearchCorrectiveActionPage(driver,test);
		CreateNewCorrectiveActionPage CreatePage=new CreateNewCorrectiveActionPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIM(SBU);
					homepage.movetoCorrectiveAction();
					searchpage.addCode();
					CreatePage.enterSBUCode(SBUCode,Code,Description,Title);
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
			homepage.returnToIOHomePage();
			Assert.assertTrue(false);
		}
	}


}
