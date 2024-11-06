package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewExportInfoCodePage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListExportInfoCodePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ValidateMandatoryChecksExportInfoCodeUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("MandatoryCheckExportInfoCode", excel);
	}

	@Test(dataProvider = "getData")
	public void validateMandatoryChecksExportInfoCode(String Testcase, String RunMode, String SBU) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ListExportInfoCodePage ListExportInfo =  new ListExportInfoCodePage(driver, test);
		CreateNewExportInfoCodePage CreateExportInfo = new CreateNewExportInfoCodePage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.codes_ExportInformation();
					ListExportInfo.create_NewExportInfoCode();
					CreateExportInfo.click_Save();
					Wait.waitfor(2);
					CreateExportInfo.validateMandatoryChecks();
					
				// String exportCode =	CreateExportInfo.getExportInfoCode();
//				String exportCode= CreateExportInfo.getExportInfoCode();
//			System.out.println(exportCode);
//			CreateExportInfo.click_Cancel();
				
				
			//	ListExportInfo.validateExportCode(exportCode);
				
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
