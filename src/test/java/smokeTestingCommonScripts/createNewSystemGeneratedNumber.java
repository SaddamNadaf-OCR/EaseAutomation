package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.SearchSystemGeneratedNumberPage;
import filesClasses.createNewSystemGeneratedNumberpage;
import initializer.SeleniumTestBase;


import utilities.Utility;
import utilities.Wait;

public class createNewSystemGeneratedNumber extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateSystemGeneratedNumber", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateSystemGeneratedNumber(String Testcase, String RunMode, String SBU,String DatabaseName, String Template, String Width, String LastNumberGenerated) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchSystemGeneratedNumberPage searchpage=new SearchSystemGeneratedNumberPage(driver,test);
		createNewSystemGeneratedNumberpage CreatePage=new createNewSystemGeneratedNumberpage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoSystemGeneratedNumber();
					searchpage.addShipper();
					CreatePage.enterDatabaseName(DatabaseName,Template,Width,LastNumberGenerated);
					Wait.waitfor(3);
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
