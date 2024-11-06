package regressionTestingLicensePermitScript;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import lpreports.HomePageReport;
import lpreports.ProductReportPage;
import utilities.Utility;
import utilities.Wait;

public class ProductReportSearchResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ProductSearch", excel);
	}

	@Test(dataProvider = "getData")
	public void productsearchpage(String Testcase, String RunMode, String SBU, String SBUCode, String Status, String PartNo, 
			String SKUNo, String ManufacturerPartNo, String SourceSystemPartNo, String Description, String ModelNo, String ProductName, 
			String MaterialType, String ProductLineName, String ProgramCode, String SiteName, String Hazardous, String FlagReasonCode, 
			String NationalStockNumber, String ProductCreatedByUser, String ProductCreatedDateFrom, String ProductCreatedDateTo, 
			String ProductModifiedByUser, String ProductModifiedDateFrom, String ProductModifiedDateTo, String SortBy, String Direction) throws Exception {

		// *************** Objects Creation  ** ***************************

		ProductReportPage productreport = new ProductReportPage(driver, test);
		HomePageReport home = new HomePageReport(driver, test);

		// ********************* Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoProductReports();
					productreport.searchProductDetails(SBUCode, Status, PartNo, SKUNo, ManufacturerPartNo,
							SourceSystemPartNo, Description, ModelNo, ProductName, MaterialType, ProductLineName, 
							ProgramCode, SiteName, Hazardous, FlagReasonCode, NationalStockNumber, ProductCreatedByUser, 
							ProductCreatedDateFrom, ProductCreatedDateTo, ProductModifiedByUser, ProductModifiedDateFrom, 
							ProductModifiedDateTo, SortBy, Direction);
					Wait.waitfor(3);
					productreport.click_ReportSearch();
					Wait.waitfor(3);
					productreport.displayOfTitle();
					Wait.waitfor(3);
					home.returnHomepageLP();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}
}
