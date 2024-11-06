package nrcLicensingScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.NrcAdhocApplicationReportPage;
import utilities.Utility;
import utilities.Wait;

public class NrcSearchAdhocApplicationReportResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("NRCAdhocApplicationReport", excel);
	}

	@Test(dataProvider = "getData")
	public void searchpage(String Testcase, String RunMode, String SBU, String SBUCode, String TransactionId,
			String Status, String TypeOfAction, String ContractNo, String PoaEmailId, String ProgramCode,
			String SegmentName, String SiteName, String Department, String RequestorEmailId, String ReviewerEmailId,
			String Notes, String ConsigneeId, String DateInitiatedFrom, String DateInitiatedTo, String DateUsgFrom,
			String DateUsgTo, String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo,
			String SortBy, String Direction) throws Exception {

		// *********** Objects Creation *************//

		NrcAdhocApplicationReportPage adhocsearch = new NrcAdhocApplicationReportPage(driver, test);
		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);

		// ********* Test steps execution *****************//

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					nrchome.moveTo_SBUSelection(SBU);
					nrchome.movetoAdhocApplicationReport();
					Wait.waitfor(2);
					adhocsearch.nrcAdhocSearch(SBUCode, TransactionId, Status, TypeOfAction, ContractNo, PoaEmailId,
							ProgramCode, SegmentName, SiteName, Department, RequestorEmailId, ReviewerEmailId, Notes,
							ConsigneeId, DateInitiatedFrom, DateInitiatedTo, DateUsgFrom, DateUsgTo, IssueDateFrom,
							IssueDateTo, ExpiryDateFrom, ExpiryDateTo, SortBy, Direction);
					adhocsearch.click_NrcLicenseSearch();
					Wait.waitfor(3);
					adhocsearch.adhocReportDisplayOfTitle();
					nrchome.NrcreturnPage();
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
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}
	}
}
