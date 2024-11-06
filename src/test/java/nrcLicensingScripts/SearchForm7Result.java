package nrcLicensingScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.SearchForm7Page;
import utilities.Utility;
import utilities.Wait;

public class SearchForm7Result extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("NRCSearch", excel);
	}

	@Test(dataProvider = "getData")

	public void searchpage(String Testcase, String RunMode, String SBU, String SBUCode, String Status,
			String TransactionId, String SegmentName, String WlsStatus, String ProgramCode, String PoaEmailId,
			String TypeOfAction, String AuhorizatonNo, String SiteName, String DateInitiatedFrom,
			String DateInitiatedTo, String DateUsgFrom, String DateUsgTo, String IssueDateFrom, String IssueDateTo,
			String ExpiryDateFrom, String ExpiryDateTo, String RequestorEmailId, String ReviewerEmailId, String SortBy,
			String Direction) throws Exception {

		// ********** Objects Creation ******************

		SearchForm7Page nrcsearch = new SearchForm7Page(driver, test);
		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);

		// **************** Test steps execution *******************

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					nrchome.moveTo_SBUSelection(SBU);
					nrcsearch.searchForm7(SBUCode, Status, TransactionId, SegmentName, WlsStatus, ProgramCode,
							PoaEmailId, TypeOfAction, AuhorizatonNo, SiteName, DateInitiatedFrom, DateInitiatedTo,
							DateUsgFrom, DateUsgTo, IssueDateFrom, IssueDateTo, ExpiryDateFrom, ExpiryDateTo,
							RequestorEmailId, ReviewerEmailId, SortBy, Direction);
					nrcsearch.click_NrcLicenseSearch();
					Wait.waitfor(3);
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
