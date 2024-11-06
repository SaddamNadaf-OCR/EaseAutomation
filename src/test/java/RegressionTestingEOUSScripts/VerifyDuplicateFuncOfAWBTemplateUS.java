package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.AirwayBillNumberTemplatepage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchAirwayBillNumberTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyDuplicateFuncOfAWBTemplateUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DuplicateAWBTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void DuplicateAWBTemplate(String Testcase, String RunMode, String SBU) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAirwayBillNumberTemplatePage SearchAWB = new SearchAirwayBillNumberTemplatePage(driver, test);
		AirwayBillNumberTemplatepage AWB = new AirwayBillNumberTemplatepage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.AWBNumber();
					
					SearchAWB.SearchBtn();
					AWB.heading();
					AWB.copyAWB();
					AWB.saveBtn();
					AWB.duplicateErrorMsg();
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


