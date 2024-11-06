package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewDutyReliefAuthorizationsActivityLogPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchDutyReliefAuthorizationDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddDutyReliefActivityUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDutyReliefActivity", excel);
	}

	@Test(dataProvider = "getData")
	public void addDutyRActivity(String Testcase, String RunMode, String SBU, String ReliefType, String DutyReliefAuthorizationNo, 
			String AutorizationsNo, String ShipmentType, String TransactionDate, String ReferenceNo, String ReferenceItemNo, 
			String DueDate, String Description, String Quantity, String UOM) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDutyReliefAuthorizationDetailsPage SearchDutyRAD = new SearchDutyReliefAuthorizationDetailsPage(driver,
				test);
		CreateNewDutyReliefAuthorizationsActivityLogPage createDRAA = new CreateNewDutyReliefAuthorizationsActivityLogPage(
				driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.clickDutyRAuth();
					SearchDutyRAD.clickAddDFActivity();
					createDRAA.addItemDetails(ReliefType, DutyReliefAuthorizationNo, AutorizationsNo, ShipmentType,
							TransactionDate, ReferenceNo, ReferenceItemNo, DueDate, Description, Quantity, UOM);
					createDRAA.clickSaveReturn();
					Wait.waitfor(3);
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
