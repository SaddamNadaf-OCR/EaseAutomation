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

public class VerifyDupFuncOfInBondCodeUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DupFuncInBondCode", excel);
	}

	@Test(dataProvider = "getData")
	public void DuplicateFuncInBondCode(String Testcase, String RunMode, String SBU, String InBondCode) {
		
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
					ListInBond.copy_inBondCode();
					CreateInBond.InBondCode(InBondCode);
					
					CreateInBond.click_Save();
					Wait.waitfor(2);
					CreateInBond.validateDupErrorMsg();
					
				// String exportCode =	CreateExportInfo.getExportInfoCode();
//				String inBondCode= CreateInBond.getInBondCode();
//			System.out.println(inBondCode);
				CreateInBond.click_Cancel();
				
				
			//ListInBond.validateInBondCode(inBondCode);
				
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
