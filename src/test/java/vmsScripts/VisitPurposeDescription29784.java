package vmsScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitPurposePage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitPurposePage;

public class VisitPurposeDescription29784 extends SeleniumTestBase {

	@Test
	public void VisitPurpose() {
		HomePage homePage = new HomePage(driver, test);
		SearchVisitPurposePage searchVP = new SearchVisitPurposePage(driver, test);
		CreateNewVisitPurposePage createNewVP = new CreateNewVisitPurposePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				homePage.clickVisitPurpose();
				ArrayList<String> vpDesp = GenericMethods.stringtoken(propVMs.getProperty("VpPurposeDescription"));

				for (int i = 0; i < vpDesp.size(); i++) {
					searchVP.clickAddVisitPurpose();

					createNewVP.clickAddVisitPurpose(propVMs.getProperty("VpSBUcode"),
							propVMs.getProperty("VPID"), vpDesp.get(i),
							propVMs.getProperty("VpDetailedDescription"));
					createNewVP.clickSaveAndReturn();
					Wait.waitfor(3);
				}
				homePage.returnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

}
