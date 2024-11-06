package bulkUpdateClassificationScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bulkUpdateClassificationClasses.HomePageBulkProduct;
import bulkUpdateClassificationClasses.SearchBulkProductPage;
import bulkUpdateClassificationClasses.SearchImportClassificationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchImportClassification extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchImportClassificationPage", excel);
	}
	
	@Test(dataProvider = "getData")
	public void searchImportClassificationDetails(String Testcase, String RunMode, String SBU, String SBUCode, String ImportClassificationCountry, String CheckboxListInvalidClassification, 
			String ChangeEffectiveDate, String ConversionType, String Status, String SortBy, String Direction) throws Exception {

		HomePageBulkProduct home = new HomePageBulkProduct(driver, test);
		SearchImportClassificationPage importClass = new SearchImportClassificationPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					Wait.waitfor(3);
					home.moveTo_SBUSelection(SBU);
					Wait.waitfor(2);
					home.movetoTools();
					importClass.click_RegulatoryUpdate();
					Wait.waitfor(2);
					importClass.searchImportClassificationDetails(SBUCode, ImportClassificationCountry, 
							CheckboxListInvalidClassification, ChangeEffectiveDate, ConversionType, Status, SortBy, Direction);
					Wait.waitfor(2);
					importClass.click_ImportClassificationSearch();
					home.returnToBulkUpdateClassificationPage();
					Wait.waitfor(2);
					}
				else {
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
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
