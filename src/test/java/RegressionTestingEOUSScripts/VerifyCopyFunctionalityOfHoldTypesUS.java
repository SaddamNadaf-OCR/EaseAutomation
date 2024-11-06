package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewHoldTypesPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.UserHoldTypesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyCopyFunctionalityOfHoldTypesUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyHoldType", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyCopyFuncOfHoldTypes(String Testcase, String RunMode, String SBU, String HoldName, String Description) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		UserHoldTypesPage UserHT = new UserHoldTypesPage(driver, test);
		CreateNewHoldTypesPage CreateNewHT = new CreateNewHoldTypesPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.HoldTypes();
					UserHT.copy();
					CreateNewHT.enter_HoldName(HoldName);
					CreateNewHT.enter_Description(Description);
					CreateNewHT.click_Save();
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

