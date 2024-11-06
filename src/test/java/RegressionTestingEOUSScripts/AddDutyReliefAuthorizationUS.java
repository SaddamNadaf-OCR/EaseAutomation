package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewDutyReliefAuthorizationDetailsPage;
import globalExportClasses.CreateNewDutyReliefAuthorizationsActivityLog;
import globalExportClasses.DutyReliefAuthorizationItemDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchDutyReliefActivityLogPage;
import globalExportClasses.SearchDutyReliefAuthorizationDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddDutyReliefAuthorizationUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDutyReliefAuthorization", excel);
	}

	@Test(dataProvider = "getData")
	public void addDutyRAuth(String Testcase, String RunMode, String SBU, String RefID, String DRType, String Category,
			String AuthNo, String ValidFrDate, String ValidToDate, String AuthItem, String ReliefDate, String PartNo,
			String Qty, String UOM,String ReliefType, String DRANo, String AuthItemNo, String ShipType, String ReferenceNo,
			String CustomDeclarationNo, String TransactionDate, String RefItemNo, String CDItemNo, String DueDate,
			String PartNum, String ItemQty, String ItemUOM) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDutyReliefAuthorizationDetailsPage SearchDRAuth = new SearchDutyReliefAuthorizationDetailsPage(driver,
				test);
		CreateNewDutyReliefAuthorizationDetailsPage CreateNewDRAuth = new CreateNewDutyReliefAuthorizationDetailsPage(
				driver, test);
		DutyReliefAuthorizationItemDetailsPage DRAuthItem = new DutyReliefAuthorizationItemDetailsPage(driver, test);
		SearchDutyReliefActivityLogPage SearchDRALog = new SearchDutyReliefActivityLogPage(driver, test);
		CreateNewDutyReliefAuthorizationsActivityLog CreateDRAActivityLog = new CreateNewDutyReliefAuthorizationsActivityLog(
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
					SearchDRAuth.clickAddDutyReliefAuth();
					CreateNewDRAuth.headerDetailsInfo(RefID, DRType, Category, AuthNo, ValidFrDate, ValidToDate,
							AuthItem, ReliefDate);
					Wait.waitfor(3);
					CreateNewDRAuth.saveBtn();
					CreateNewDRAuth.lineItemDetails();
					DRAuthItem.addItemBtn();
					DRAuthItem.itemDetails(PartNo, Qty, UOM);
					Wait.waitfor(3);
					DRAuthItem.saveReturnBtn();
					DRAuthItem.activityLog();
					SearchDRALog.addActivity();
					CreateDRAActivityLog.selectReliefType(ReliefType);
					CreateDRAActivityLog.addItemDetails(DRANo, AuthItemNo, ShipType, ReferenceNo, CustomDeclarationNo,
							TransactionDate, RefItemNo, CDItemNo, DueDate, PartNum, ItemQty, ItemUOM);
					CreateDRAActivityLog.saveReturn();
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
