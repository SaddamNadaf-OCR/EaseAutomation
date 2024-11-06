package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateEEITransactionsTemplatePage;
import globalExportClasses.CreateNewEEITransactionsTemplatePage;
import globalExportClasses.EEITemplatePage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ValidateMandatoryChecksInEEITemplateUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ValidateMandatoryChecksEEITemp", excel);
	}

	@Test(dataProvider = "getData")
	public void validateErroMsgEEITemplate(String Testcase, String RunMode, String SBU) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		EEITemplatePage EEI = new EEITemplatePage(driver, test);
		CreateEEITransactionsTemplatePage createEEITemp = new CreateEEITransactionsTemplatePage(driver, test);
		CreateNewEEITransactionsTemplatePage createNewEEITemp = new CreateNewEEITransactionsTemplatePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.EEI();
					EEI.addEEITemplateBtn();
					createEEITemp.createEEITemplate();
					
					createNewEEITemp.click_SaveBtn();
					createNewEEITemp.validateMandatoryChecks();	
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
	


