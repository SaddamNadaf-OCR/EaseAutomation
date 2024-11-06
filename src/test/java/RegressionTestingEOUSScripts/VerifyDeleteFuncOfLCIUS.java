package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewLetterOfCreditInstructionsPage;
import globalExportClasses.EditLetterOfCreditInstructionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.LetterOfCreditInstructionsPage;
import globalExportClasses.ResultLetterOfCreditInstructionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyDeleteFuncOfLCIUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DeleteLCI", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyDeleteFuncLCI(String Testcase, String RunMode, String SBU, String SbuCode, String DelLCI) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		LetterOfCreditInstructionsPage LCIPage = new LetterOfCreditInstructionsPage(driver, test);
		ResultLetterOfCreditInstructionsPage resultLIC = new ResultLetterOfCreditInstructionsPage(driver, test);
		EditLetterOfCreditInstructionsPage EditLCI = new EditLetterOfCreditInstructionsPage(driver, test);
		CreateNewLetterOfCreditInstructionsPage CreateLCI = new CreateNewLetterOfCreditInstructionsPage(driver, test);

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
					LCIPage.sbu(SbuCode);
					LCIPage.LCIID(DelLCI);
					LCIPage.clickSearchBtn();
					resultLIC.titleDisplayedLCI();
					Wait.waitfor(3);
				//	resultLIC.fetchLCI(DelLCI);
					
					resultLIC.deleteIcon();
					resultLIC.newSearchBtn();
					LCIPage.LCIID(DelLCI);
					LCIPage.clickSearchBtn();
					resultLIC.noResultMsg();
					
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


