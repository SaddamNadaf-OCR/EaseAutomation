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

public class ValidateMandatoryChecksInHoldTypesUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ValidateMandatoryChecksHoldType", excel);
	}

	@Test(dataProvider = "getData")
	public void validateMandatoryChecksInHoldTypes(String Testcase, String RunMode, String SBU, String SBUCode) {
		
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
					UserHT.select_SBUCode(SBUCode);
					UserHT.click_AddHoldType();
					CreateNewHT.click_Save();
					CreateNewHT.validateMandatoryChecks();
					
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
	


