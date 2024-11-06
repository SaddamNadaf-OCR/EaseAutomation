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

public class AddNewExemptionUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddExemptionStatement", excel);
	}

	@Test(dataProvider = "getData")
	public void AddNewExemptionStatement(String Testcase, String RunMode, String SBU, String Country, String ExempCode, String ExempDescr) {
		
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
					searchExempt.click_AddNewExemption();
					addNewExempt.enterCountry(Country);
					addNewExempt.enter_exemptionCode(ExempCode);
					addNewExempt.enter_ExempDescription(ExempDescr);
					addNewExempt.save();
				//	String No = addNewExempt.getNo();
					String exemptDesText = addNewExempt.getExemptDescription();
					System.out.println(exemptDesText);
				//	System.out.println(addNewExempt);
					addNewExempt.cancelbtn();
					searchExempt.enter_ExemptDescription(exemptDesText);
					searchExempt.click_Search();
					listExempt.DescIsDisplayed(exemptDesText);
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
