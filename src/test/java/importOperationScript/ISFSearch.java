package importOperationScript;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import importOperationClasses.ISFHomePage;
import importOperationClasses.ISFSearchSecurityFilingPage;
import importOperationClasses.ISFSearchSecurityFilingReaultPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ISFSearch extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchISF", excel);
	}

	@Test(dataProvider = "getData")
	public void ISFStatus(String Testcase, String RunMode, String SBU, String SBUCode, String Status, String ISFNo,
			String InternalRefNo, String MOT, String CarrierCode, String ShipmentType, String ShipmentSubType,
			String SubmissionType, String ActionReason, String CustomsTransactionNo, String PortID, String FilingStatus,
			String BillStatus, String CreatedBy, String CreateDateFrom, String CreateDateTo,
			String ImportCoordinatorReviewer, String CorpComplianceReviewer, String SortBy, String Direction,
			String BillNo, String BillType, String ParentBillNo, String PartyType, String PartyCodeType,
			String PartyCode, String IdentifierType, String IdentificationNo, String PartNo, String ProductName,
			String PartDescription, String HsNo, String CountryofOrigin, String BillNoLine, String Manufacture)
			throws Exception {

		ISFHomePage homeISF = new ISFHomePage(driver, test);
		ISFSearchSecurityFilingPage searchISF = new ISFSearchSecurityFilingPage(driver, test);
		ISFSearchSecurityFilingReaultPage searchISFResult = new ISFSearchSecurityFilingReaultPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("Y")) {
					test.log(LogStatus.INFO, Testcase);
					homeISF.moveTo_SBUSelection(SBU);
					Wait.waitfor(2);
					homeISF.SelectFeatureAndPreEntry();
					searchISF.commonSearch(SBUCode, Status, ISFNo, InternalRefNo, MOT, CarrierCode, ShipmentType,
							ShipmentSubType, SubmissionType, ActionReason, CustomsTransactionNo, PortID, FilingStatus,
							BillStatus, CreatedBy, CreateDateFrom, CreateDateTo, ImportCoordinatorReviewer,
							CorpComplianceReviewer, SortBy, Direction);
					searchISF.billDetailsSearch(BillNoLine, BillType, ParentBillNo);
					searchISF.partyDetailsSearch(PartyType, PartyCodeType, PartyCode, IdentifierType, IdentificationNo);
					searchISF.lineDetailsSearch(PartNo, ProductName, PartDescription, HsNo, CountryofOrigin, BillNoLine,
							Manufacture);
					searchISF.click_SearchBtn();
					Wait.waitfor(2);
					searchISFResult.searchISFResultDisplay();
					Wait.waitfor(2);
					searchISFResult.newSearch();
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
			testFail();
			homeISF.returnHomepageImport();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
