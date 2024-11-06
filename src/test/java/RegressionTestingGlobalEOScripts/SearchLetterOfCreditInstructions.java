package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.LetterOfCreditInstructionsPage;
import globalExportClasses.ResultLetterOfCreditInstructionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchLetterOfCreditInstructions extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchLetterOfCredit", excel);
	}

	@Test(dataProvider = "getData")
	public void searchLetterOfCredit(String Testcase, String RunMode, String SBU, String LCIID, String LCIConsigneeCode,
			String LCIExporterCode, String InvoiceNo, String Status) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		LetterOfCreditInstructionsPage LCI = new LetterOfCreditInstructionsPage(driver, test);
		ResultLetterOfCreditInstructionsPage resultLIC = new ResultLetterOfCreditInstructionsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresOrdersDeliveries();
					HGExport.clickLetterOfCredit();
					LCI.searchLCI(LCIID, LCIConsigneeCode, LCIExporterCode, InvoiceNo, Status);
					LCI.clickSearchBtn();
					resultLIC.titleDisplayedLCI();
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
