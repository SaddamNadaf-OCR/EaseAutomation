package regressionTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import filesClasses.AddflagreasonPage;
import filesClasses.AddflagresultPage;
import filesClasses.AuthorizationMgmtHomepagePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddFlagreason extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddFlagreason", excel);
	}

	@Test(dataProvider = "getData")
	public void AddflgReasonpage( String testcases,String RunMode, String SBU, String SBUCode,
			String ReasonCode, String FlagIcon, String FlagColor, String Desciption,
			String ImportExport, String SetID)

	{
// create objects
		AuthorizationMgmtHomepagePage hpAuthMngmt = new AuthorizationMgmtHomepagePage(driver, test);
		AddflagreasonPage addflrsn=new AddflagreasonPage(driver, test);
		AddflagresultPage addflgrslt=new AddflagresultPage(driver, test);
		

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					Wait.waitfor(3);
					hpAuthMngmt.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpAuthMngmt.movetoFlagReason();
					Wait.waitfor(2);
				addflrsn.AddFlagReason(SBUCode, ReasonCode, FlagIcon, FlagColor, Desciption, ImportExport, SetID);
					Wait.waitfor(3);
				addflrsn.clickonSave();
				Wait.waitfor(3);
					addflgrslt.displayOfTitle();
					Wait.waitfor(3);
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}

		} catch (SkipException s) {
			test.log(LogStatus.INFO, testcases);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			hpAuthMngmt.logout();

		}
	}
}

