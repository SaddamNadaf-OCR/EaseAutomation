package regressionTestingGlobalProduct;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import productClasses.ECHASCIPDatabaseReportPage;
import productClasses.HomePageProduct;
import productClasses.ProductManufacturerReportResultpage;
import productClasses.SearchProductExportClassReport;
import productClasses.SearchProductImportClassiReport;
import productClasses.SearchProductManufacturerReport;
import productClasses.SearchReports;
import utilities.Utility;
import utilities.Wait;

public class ProdReportScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("productreport", excel);
	}

	@Test(dataProvider = "getData")
		public void productreport(String Testcase, String RunMode, String SBU, String ReportType,
				String SBUCodeforMan, String PartNoforMan, String ManufacturerCode, String CountryOFOrigin,
				String SBUCodeforImp, String PartNoforImp,String ImpClassountry, String ImportClassification, String SBUCodeforExp,  
				String PartNoforExp, String ExpClassCountry ,String ExportClassification  ) {
		HomePageProduct home = new HomePageProduct(driver, test);
		SearchReports search= new SearchReports(driver,test);
		SearchProductManufacturerReport searchmanu = new SearchProductManufacturerReport (driver, test);
		ProductManufacturerReportResultpage resultmanu = new ProductManufacturerReportResultpage(driver, test);
		SearchProductImportClassiReport impclass= new SearchProductImportClassiReport(driver, test);
		SearchProductExportClassReport expclass = new SearchProductExportClassReport(driver, test);
		ECHASCIPDatabaseReportPage echaclass=new ECHASCIPDatabaseReportPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoFiles();
					Wait.waitfor(10);
					search.ReportSearchdetails(ReportType);
					if(ReportType.equalsIgnoreCase("Manufacturer")) {
			searchmanu.ReportSearchmanufacturer(SBUCodeforMan, PartNoforMan, ManufacturerCode, CountryOFOrigin);
					}else if(ReportType.equalsIgnoreCase("Import Classification")) {
						impclass.ReportSearchImportClassification(SBUCodeforImp, PartNoforImp,ImpClassountry, ImportClassification);
				//	}else if(ReportType.equalsIgnoreCase("ECHA-SCIP Database Report"))
					//{echaclass.ReportSearchEChaSCIP(SBUCodeforEcha, PartNoforEcha);
					}else {
						expclass.ReportSearchexportClassification(SBUCodeforExp, PartNoforExp,  ExpClassCountry,ExportClassification);
					}
					search.clickonsearh();
			resultmanu.displayOfTitle();
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

		
	
