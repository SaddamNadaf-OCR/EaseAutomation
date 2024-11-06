package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultSpecialInstructionNotesPage;
import filesClasses.SearchSpecialInstructionNotesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchSpecialInstructionNotesScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchNotes", excel);

	}

	@Test(dataProvider = "getData")
	public void SearchNotes(String Testcase, String RunMode, String SBU, String sbu, String Topic, String Category,
			String CreatedBy, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver, test);
		SearchSpecialInstructionNotesPage searchpage = new SearchSpecialInstructionNotesPage(driver, test);
		ResultSpecialInstructionNotesPage ResultSearchNotesTitle = new ResultSpecialInstructionNotesPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionIO(SBU);
					homepage.movetoSpecialInstructionNotes();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, Topic, Category, CreatedBy, SortBy, direction);
					searchpage.searchbutton();
					ResultSearchNotesTitle.ResultNotesIsDisplayed();
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
