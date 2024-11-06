package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateLetterOfCreditInstructionsPage;
import globalExportClasses.CreateNewLetterOfCreditInstructionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.LetterOfCreditInstructionsPage;
import globalExportClasses.ResultLetterOfCreditInstructionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateLCIByCopyingExistingLCIUS extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateLCIFromExistingLCI", excel);
	}

	@Test(dataProvider = "getData")
	public void CopyLCI(String Testcase, String RunMode, String SBU, String LCI, String SbuCode, String LCIID, String InvDate, String LCIId) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		LetterOfCreditInstructionsPage LCIPage = new LetterOfCreditInstructionsPage(driver, test);
		CreateLetterOfCreditInstructionsPage CLCI = new CreateLetterOfCreditInstructionsPage(driver, test);
		CreateNewLetterOfCreditInstructionsPage createLCI = new CreateNewLetterOfCreditInstructionsPage(driver, test);
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
					LCIPage.LCIID(LCI);
					LCIPage.sbu(SbuCode);
					LCIPage.clickSearchBtn();
					resultLIC.copyLCI();
					createLCI.addHeaderLCI(LCIID, "");
					createLCI.addHeaderInvDate(InvDate);
					createLCI.clickSave();
					String ResultLCI = createLCI.getValueLCI();
					createLCI.cancelBtn();	
					resultLIC.newSearchBtn();
					LCIPage.LCIID(ResultLCI);
					LCIPage.clickSearchBtn();
					resultLIC.clickLCIID(LCIId);
					
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


