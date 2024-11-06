package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewInBondPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListInBondCodePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ValidateMandatoryChecksInBondCodeUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ValidateMandateCheckIBCode", excel);
	}

	@Test(dataProvider = "getData")
	public void validateMandatoryChecksInBondCode(String Testcase, String RunMode, String SBU) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		CreateNewInBondPage CreateInBond = new CreateNewInBondPage(driver, test);
		ListInBondCodePage ListInBond = new ListInBondCodePage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.click_InBondCode();
					ListInBond.click_AddInBond();
					CreateInBond.click_Save();
					Wait.waitfor(2);
					CreateInBond.validateMandatoryChecks();
					CreateInBond.click_Cancel();
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
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}


}
