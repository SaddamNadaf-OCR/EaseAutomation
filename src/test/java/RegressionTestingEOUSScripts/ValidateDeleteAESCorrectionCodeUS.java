package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewAESCorrectionCodePage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListAESCorrectionCodePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ValidateDeleteAESCorrectionCodeUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DeleteAESCode", excel);
	}

	@Test(dataProvider = "getData")
	public void DeleteAESCorrectionCode(String Testcase, String RunMode, String SBU) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ListAESCorrectionCodePage ListAES = new ListAESCorrectionCodePage(driver, test);
		CreateNewAESCorrectionCodePage CreateAES = new CreateNewAESCorrectionCodePage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.codes_AESCorrection();
					ListAES.deleteF_AESCode();
					ListAES.deleteZ_AESCode();
   
					ListAES.verifyDeletedItems_F();
					ListAES.verifyDeletedItem_Z();
					
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
