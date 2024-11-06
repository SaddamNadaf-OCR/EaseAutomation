package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.AddNewExemptionStatementPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListExemptionStatementsPage;
import globalExportClasses.SearchExemptionStatementPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchCustomFilingExemptionStatementUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchExemptionStatement", excel);
	}

	@Test(dataProvider = "getData")
	public void SearchExemptionStatement(String Testcase, String RunMode, String SBU, String country, String ExemptionDesc, 
			String CreatedFrom, String CreatedTo, String Status) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchExemptionStatementPage searchExempt = new SearchExemptionStatementPage(driver, test);
		AddNewExemptionStatementPage addNewExempt = new AddNewExemptionStatementPage(driver, test);
		ListExemptionStatementsPage	listExempt = new ListExemptionStatementsPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.customFilingExemptionStatement();
					searchExempt.searchByParameters(country, "", ExemptionDesc, CreatedFrom, CreatedTo, Status);
					searchExempt.click_Search();
					listExempt.titleIsDisplayed();
					listExempt.verifyRecordDisplay();
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
	
	


