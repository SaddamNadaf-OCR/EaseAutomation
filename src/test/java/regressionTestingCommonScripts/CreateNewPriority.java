package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.CreateNewPriorityPage;
import filesClasses.HomePage;

import filesClasses.SearchPriorityPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewPriority extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreatePriority", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreatePriority(String Testcase, String RunMode, String SBU,String PriorityType, String PriorityName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchPriorityPage searchpage=new SearchPriorityPage(driver,test);
		CreateNewPriorityPage CreatePage=new CreateNewPriorityPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetopriority();
					searchpage.addPriority();
					CreatePage.enterPriorityType(PriorityType,PriorityName);
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
