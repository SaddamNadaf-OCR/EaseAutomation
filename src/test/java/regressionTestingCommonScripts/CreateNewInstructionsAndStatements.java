package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewInstructionsAndStatementsPage;
import filesClasses.HomePage;

import filesClasses.SearchInstructionsAndStatementsPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewInstructionsAndStatements extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateInstructionsAndStatements", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateInstructionsAndStatements(String Testcase, String RunMode, String SBU,String InstructionsID, String Descriptions) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchInstructionsAndStatementsPage searchpage=new SearchInstructionsAndStatementsPage(driver,test);
		CreateNewInstructionsAndStatementsPage CreatePage=new CreateNewInstructionsAndStatementsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoInstructionsAndStatements();
					searchpage.addInstructionsAndStatements();
					CreatePage.enterInstructionsID(InstructionsID,Descriptions);
					CreatePage.saveandReturn();
					homepage.returnToIOHomePage();
					
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
