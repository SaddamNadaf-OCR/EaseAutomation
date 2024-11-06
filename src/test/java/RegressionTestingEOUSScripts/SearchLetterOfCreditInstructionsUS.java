package RegressionTestingEOUSScripts;

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

public class SearchLetterOfCreditInstructionsUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchLetterOfCredit", excel);
	}

	@Test(dataProvider = "getData")
	public void searchLetterOfCredit(String Testcase, String RunMode, String SBU, String SBUCode, String LCIID,
			String LCIConsigneeCode, String LCIConsigneeName, String LCIExporterCode, String LCIExporterName,
			String InvoiceNo, String InvDate, String Status, String Createdby, String serialNum) throws Exception {

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
					LCI.searchLCI(SBUCode, LCIID, LCIConsigneeCode, LCIConsigneeName, LCIExporterCode, LCIExporterName,
							InvoiceNo, InvDate, Status, Createdby);
					LCI.clickSearchBtn();
					resultLIC.titleDisplayedLCI();
					Wait.waitfor(3);
					//resultLIC.verifyResultDisplayed(serialNum);
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
