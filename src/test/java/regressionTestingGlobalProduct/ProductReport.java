package regressionTestingGlobalProduct;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import productClasses.HomePageProduct;
import productClasses.ProductReportResultPage;
import productClasses.SearchProductReportPage;
import utilities.Utility;
import utilities.Wait;

public class ProductReport extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("Report", excel);
	}

	@Test(dataProvider = "getData")
	public void SearchThroughProductReport(String Testcase, String RunMode, String SBU, String SBUCode, String Status,
			String PartNo, String SKUNo, String PartNoManuf, String SourcePartNo, String Description, String ModelNo,
			String ProductName, String MaterialType, String ProductLine, String ProgramCode, String SiteId,
			String Hazardous, String ReasonCode, String NationalStockNumber, String CreatedByUN, String CreatedDateFrom,
			String CreatedDateTo, String ModifiedbyUN, String ModifiedDateFrom, String ModifiedDateTo, String SortBy,
			String Direction, String ManufacturerCode, String DomesticForeign, String CountryofOrigin,
			String ManfPartNo, String ManfCreatedBy, String ManfCrDateFrom,String ManfCrDateTo, String ManfModifiedBy,
			String ManfModDateFrom, String ManfModDateTo, String CountryofClassification,
			String ECCN, String TechDataRefNo, String AssExpClassifECCN, String ExpCreatedBy, String ExpCrDateFrom,
			String ExpCrDateTo, String ExpModifiedBy, String ExpModDateFrom, String ExpModDateTo,
			String CustCountryOfClassif, String ImpClassifHSNo, String CustCreatedBy, String CustCrDateFrom,
			String CustCrDateTo, String CustModifiedBy, String CustModDateFrom, String CustModDateTo) {

		HomePageProduct product = new HomePageProduct(driver, test);
		SearchProductReportPage searchp = new SearchProductReportPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ProductReportResultPage result = new ProductReportResultPage(driver, test);

		// **********Test steps execution *************************** //
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					product.movetoReports();
					Wait.waitfor(3);
					searchp.searchProductDetails(SBUCode, Status, ManfPartNo, SKUNo, PartNoManuf, SourcePartNo,
							Description, ModelNo, ProductName, MaterialType, ProductLine, ProgramCode, SiteId,
							Hazardous, ReasonCode, NationalStockNumber, CreatedByUN, CreatedDateFrom, CreatedDateTo,
							ModifiedbyUN, ModifiedDateFrom, ModifiedDateTo, SortBy, Direction);
					Wait.waitfor(3);
					searchp.searchmanufacturerdetails(ManufacturerCode, DomesticForeign, CountryofOrigin, ManfPartNo,
							ManfCreatedBy, ManfCrDateFrom, ManfCrDateTo, ManfModifiedBy, ManfModDateFrom,
							ManfModDateTo);
					Wait.waitfor(3);
					searchp.searchexportdetails(CountryofClassification, ECCN, TechDataRefNo, AssExpClassifECCN,
							ExpCreatedBy, ExpCrDateFrom, ExpCrDateTo, ExpModifiedBy, ExpModDateFrom, ExpModDateTo);
					searchp.searchcustumdetails(CustCountryOfClassif, ImpClassifHSNo, CustCreatedBy, CustCrDateFrom,
							CustCrDateTo, CustModifiedBy, CustModDateFrom, CustModDateTo);
					Wait.waitfor(3);
					searchp.search();
					Wait.waitfor(10);
					result.displayOfTitle();
					home.returnToProductReportPage();
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
			e.printStackTrace();
			home.returnToProductReportPage();
			Assert.assertTrue(false);
		}
	}
}
