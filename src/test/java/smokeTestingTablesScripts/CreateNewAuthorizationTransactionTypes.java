package smokeTestingTablesScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import tablesClasses.CreateAuthorizationTransactionTypePage;
import tablesClasses.HomePageTables;
import tablesClasses.ResultAuthorizationTransactionTypesPage;
import utilities.Utility;
import utilities.Wait;

public class CreateNewAuthorizationTransactionTypes extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthTransactionTypes", excel);

	}

	@Test(dataProvider = "getData")
	public void AuthTransactionTypes(String Testcase, String RunMode, String SBU, String Sbu, String ShipmentType) {

		HomePageTables homepage = new HomePageTables(driver, test);
		CreateAuthorizationTransactionTypePage CreatePage = new CreateAuthorizationTransactionTypePage(driver, test);
		ResultAuthorizationTransactionTypesPage Result=new ResultAuthorizationTransactionTypesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoAuthorizationTransactionTypes();
					Result.AddAuthorizationTransaction();
					Wait.waitfor(3);
					CreatePage.enterSBU(Sbu, ShipmentType);
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
