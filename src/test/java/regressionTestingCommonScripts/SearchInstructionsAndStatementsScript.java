package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultInstructionsAndStatementsPage;
import filesClasses.SearchInstructionsAndStatementsPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchInstructionsAndStatementsScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchInstructionsAndStatements", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchInstructionsAndStatements (String Testcase, String RunMode, String SBU, String sbu, String InstructionId, String Type, String SortBy, String direction, String Country, String Description) {
		HomePage homepage=new HomePage(driver,test);
		SearchInstructionsAndStatementsPage searchpage=new SearchInstructionsAndStatementsPage(driver,test);
		ResultInstructionsAndStatementsPage ResultInstructionsAndStatementsTitle=new ResultInstructionsAndStatementsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoInstructionsAndStatements();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,InstructionId,Type,SortBy,direction,Country,Description);
					searchpage.searchbutton();
					ResultInstructionsAndStatementsTitle.ResultResultInstructionsAndStatementsIsDisplayed();
					Wait.waitfor(2);
				
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
