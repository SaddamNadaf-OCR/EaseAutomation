package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;
import filesClasses.ResultContractsPage;
import filesClasses.SearchContractsPage;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchContractsScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchContracts", excel);

	}

	@Test(dataProvider = "getData")
	public void SearchContracts(String Testcase, String RunMode, String SBU, String sbu, String ContractNo,
			String Status) {
		HomePage homepage = new HomePage(driver, test);
		SearchContractsPage searchpage = new SearchContractsPage(driver, test);
		ResultContractsPage ContractsTitle = new ResultContractsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionAM(SBU);
					homepage.movetoContracts();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, ContractNo, Status);
					searchpage.searchbutton();
					ContractsTitle.ResultContractsIsDisplayed();
					Wait.waitfor(4);
					homepage.returnToAMHomePage();

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
			homepage.returnToAMHomePage();
			Assert.assertTrue(false);
		}

	}

}
