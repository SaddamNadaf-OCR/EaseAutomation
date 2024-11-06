package bulkUpdateClassificationScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import bulkUpdateClassificationClasses.HomePageBulkProduct;
import bulkUpdateClassificationClasses.SearchBulkProductPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchBulkProduct extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchBulkProductPage", excel);
	}
	
	@Test(dataProvider = "getData")
	public void CreateProduct(String Testcase, String RunMode, String SBU, String SBUCode, String Status, String PartNo, String ModelNo,
			String PartDescription, String NationalStockNumber, String FlagReasonCode, String Manufacturer, String CreatedBy, 
			String CreatedDateFrom, String CreatedDateTo, String CountryOfClassification, String ModifiedDateFrom, String ModifiedDateTo,
			String SKUNo, String ExportClassificationEccnNo, String ExportClassification, 
			String ExportAuthorityCode,	String ImportClassificationHSNo, String ImportClassificationEffectiveDate, String ImportClassification, 
			String StatisticalClassificationHtsNo, String StatisticalClassification, String SortBy, String Direction, String UpdatePartNo, String UpdateCountryOfClassification, 
			String UpdateStatus, String UpdateNewExportClassificationEccnNo, String UpdateNewExportAuthorityCode, String UpdateNewImportClassificationHsNo, 
			String UpdateReasonForChange, String UpdateNewStatisticalClassificationHtsNo,
			String UpdatePartDescription, String UpdateFlagReasonCode) throws Exception {

		HomePageBulkProduct home = new HomePageBulkProduct(driver, test);
		SearchBulkProductPage bulkProduct = new SearchBulkProductPage(driver, test);

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
					bulkProduct.searchProductDetails(SBUCode, Status, PartNo, ModelNo, PartDescription, NationalStockNumber, FlagReasonCode, Manufacturer,
							CreatedBy, CreatedDateFrom, CreatedDateTo, CountryOfClassification, ModifiedDateFrom, ModifiedDateTo, SKUNo, ExportClassificationEccnNo,
							ExportClassification, ExportAuthorityCode, ImportClassificationHSNo, ImportClassificationEffectiveDate, 
							ImportClassification, StatisticalClassificationHtsNo, StatisticalClassification, SortBy, Direction);
					Wait.waitfor(2);
					bulkProduct.click_BulkProductSearch();
					Wait.waitfor(2);
					bulkProduct.updateProductDetails(UpdatePartNo, UpdateCountryOfClassification, UpdateStatus, UpdateNewExportClassificationEccnNo, UpdateNewExportAuthorityCode,
							UpdateNewImportClassificationHsNo, UpdateReasonForChange, UpdateNewStatisticalClassificationHtsNo, UpdatePartDescription, UpdateFlagReasonCode);
					bulkProduct.click_BulkProductUpdate(UpdatePartNo);
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
