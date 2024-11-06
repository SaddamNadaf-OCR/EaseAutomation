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

public class CreateNewAESCorrectionCodeUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddAESCode", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateAESCorrectionCode(String Testcase, String RunMode, String SBU, String AESCode, String Desc) {
		
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
					ListAES.click_AddAESCorrectionCode();
					CreateAES.enter_AESCorrectionCode(AESCode);
					CreateAES.enter_Description(Desc);
					CreateAES.click_Save();
					CreateAES.getAESCode();
					CreateAES.click_Cancel();
					ListAES.validateAddAES(AESCode);
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