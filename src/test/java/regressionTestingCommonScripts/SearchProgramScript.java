package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultProgramPage;
import filesClasses.SearchProgramPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class SearchProgramScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchProgram", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchProgram(String Testcase, String RunMode, String SBU, String sbu, String ProgramCode, String Description, String Status, String CreatedBy, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchProgramPage searchpage=new SearchProgramPage(driver,test);
		ResultProgramPage ProgramTitle=new ResultProgramPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoProgram();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,ProgramCode,Description,Status,CreatedBy,SortBy,direction);
					searchpage.searchbutton();
					ProgramTitle.ResultProgramIsDisplayed();
					Wait.waitfor(2);
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


