package regressionTestingGlobalProduct;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import productClasses.HomePageProduct;
import productClasses.ResultProductSearchPage;
import productClasses.SearchProductPage;
import utilities.Utility;
import utilities.Wait;

public class ProductSearchResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ProductSearch", excel);
	}

	@Test(dataProvider = "getData")

	public void searchpage(String Testcase, String RunMode, String SBU, String SBUCode, String SourceSystemPartNo,
			String PartNo, String SKUNo, String Description, String ModelNo, String ProductLineName, String ProgramCode,
			String SiteName, String Hazardous, String FlagReasonCode, String NationalStockNumber, String MaterialType,
			String Type, String ProductCreatedByUser, String ProductCreatedDateFrom, String ProductCreatedDateTo,
			String ProductModifiedByUser, String ProductModifiedDateFrom, String ProductModifiedDateTo, String SortBy,
			String Direction, String ManufacturerUserName, String DomesticForeign, String CountryOfOrigin,
			String ManfPartNo, String SpecialTradeProgramName, String CageCode, String ManufacturerCreatedByUser,
			String ManufacturerCreatedDateFrom, String ManufacturerCreatedDateTo, String ManufacturerModifiedByUser,
			String ManufacturerModifiedDateFrom, String ManufacturerModifiedDateTo,
			String ExportCountryOfClassification, String ExportProductClassification, String ECRReviewCompleted,
			String ATFForm9Required, String Sme, String TechDataReferenceNumber, String AssociatedProductClassification,
			String ExportCreatedByUser, String ExportCreatedDateFrom, String ExportCreatedDateTo,
			String ExportModifiedByUser, String ExportModifiedDateFrom, String ExportModifiedDateTo,
			String ImportClassificationCountry, String ImportClassification, String ConfidenceLevel, String InvalidHSCode,
			String StatisticalClassification,String USMILClassification, String InvalidStatisticalReportingClassification, String CustomCreatedByUser,
			String CustomCreatedDateFrom, String CustomCreatedDateTo, String CustomModifiedByUser,
			String CustomModifiedDateFrom, String CustomModifiedDateTo, String Classification, String DrawingNumber,
			String Test) throws Exception {

		// ******************************** Objects Creation
		// *******************************************

		SearchProductPage productsearch = new SearchProductPage(driver, test);
		ResultProductSearchPage result = new ResultProductSearchPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);

		// ******************************************** Test steps execution
		// ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoFiles();
					Wait.waitfor(10);
					productsearch.searchProductDetails(SBUCode, SourceSystemPartNo, PartNo, SKUNo, Description, ModelNo,
							ProductLineName, ProgramCode, SiteName, Hazardous, FlagReasonCode, NationalStockNumber,
							MaterialType, Type, ProductCreatedByUser, ProductCreatedDateFrom, ProductCreatedDateTo,
							ProductModifiedByUser, ProductModifiedDateFrom, ProductModifiedDateTo, SortBy, Direction);
					productsearch.searchManufacturerDetails(ManufacturerUserName, DomesticForeign, CountryOfOrigin,
							ManfPartNo, SpecialTradeProgramName, CageCode, ManufacturerCreatedByUser,
							ManufacturerCreatedDateFrom, ManufacturerCreatedDateTo, ManufacturerModifiedByUser,
							ManufacturerModifiedDateFrom, ManufacturerModifiedDateTo);
					productsearch.searchExportClassification(ExportCountryOfClassification, ExportProductClassification,
							ECRReviewCompleted, ATFForm9Required, Sme, TechDataReferenceNumber,
							AssociatedProductClassification, ExportCreatedByUser, ExportCreatedDateFrom,
							ExportCreatedDateTo, ExportModifiedByUser, ExportModifiedDateFrom, ExportModifiedDateTo);
					productsearch.searchImportClassification(ImportClassificationCountry, ImportClassification,
							ConfidenceLevel, InvalidHSCode, StatisticalClassification,USMILClassification, InvalidStatisticalReportingClassification,
							CustomCreatedByUser, CustomCreatedDateFrom, CustomCreatedDateTo, CustomModifiedByUser,
							CustomModifiedDateFrom, CustomModifiedDateTo);
					productsearch.click_ProductSearch();
					result.displayOfTitle();
					Wait.waitfor(4);
					home.returnToSearchProductPage();
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
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}
}
