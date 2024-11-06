
package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.SearchProgramPage;
import filesClasses.createNewProgramPage;
import initializer.SeleniumTestBase;

import utilities.Utility;


public class createNewProgram extends SeleniumTestBase{
	
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("createProgram", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void createProgram(String Testcase, String RunMode, String SBU, String ProgramCode, String Description) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchProgramPage searchpage=new SearchProgramPage(driver,test);
		createNewProgramPage CreatePage=new createNewProgramPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoProgram();
					searchpage.addProgram();
					CreatePage.enterProgramCode(ProgramCode,Description);
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


		


	
