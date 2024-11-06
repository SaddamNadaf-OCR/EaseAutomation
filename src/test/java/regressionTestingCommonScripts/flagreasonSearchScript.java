package regressionTestingCommonScripts;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import filesClasses.AuthorizationMgmtHomepagePage;
import filesClasses.ResultsearchFlagRsnPage;
import filesClasses.SearchflagReasonPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class flagreasonSearchScript extends SeleniumTestBase {

	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("flagreasonSearchScript", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPage(String testcases, String RunMode, String SBU, String SBUCode, String ReasonCode,
			String FlagIcon, String FlagColor, String FlagDescription) {

		AuthorizationMgmtHomepagePage hpAuthOwner = new AuthorizationMgmtHomepagePage(driver, test);
		SearchflagReasonPage srchFlagrsn=new SearchflagReasonPage(driver, test);
		ResultsearchFlagRsnPage rsltflgsearch=new ResultsearchFlagRsnPage(driver, test);
	
	
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					hpAuthOwner.moveTo_SBUSelection(SBU);
					Wait.waitfor(2);
					hpAuthOwner.movetoFlagReason();
					Wait.waitfor(2);
			srchFlagrsn.SearchFlagReasn(SBUCode, ReasonCode, FlagIcon, FlagColor, FlagDescription);
					Wait.waitfor(2);
					srchFlagrsn.clickonSearch();
					Wait.waitfor(2);
					rsltflgsearch.displayOfTitle();
					Wait.waitfor(2);
				
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
			hpAuthOwner.logout();

		}
	}
}
