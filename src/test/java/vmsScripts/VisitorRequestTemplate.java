package vmsScripts;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import initializer.SeleniumTestBase;

public class VisitorRequestTemplate extends SeleniumTestBase {

	@Test
	public void validate() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Files();
				searchVR.click_FilesVReqTemplate();
				Wait.waitfor(3);
				searchVR.click_AddVReqTemplate();
				Wait.waitfor(3);
				detail.select_Templatename(propVMs.getProperty("TemplateName"));
				Wait.waitfor(3);
				detail.click_TemplateSavebtn();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homePage.returnPage();
		}
	}

}
