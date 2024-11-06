package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewSpecialInstructionNotesPage;
import filesClasses.HomePage;


import filesClasses.SearchSpecialInstructionNotesPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewSpecialInstructionNotes extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateNewNotes", excel);
		
	}
	@Test(dataProvider = "getData")
	public void CreateNewNotes(String Testcase, String RunMode, String SBU,String Category, String Notes) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchSpecialInstructionNotesPage searchpage=new SearchSpecialInstructionNotesPage(driver,test);
		CreateNewSpecialInstructionNotesPage CreatePage=new CreateNewSpecialInstructionNotesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoSpecialInstructionNotes();
					searchpage.addNotes();
					CreatePage.enterCategory(Category,Notes);
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
