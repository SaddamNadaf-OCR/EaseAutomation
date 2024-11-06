package regressionTestingComplianceRequestScripts;

//Added By Saddam
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import crsClasses.HomePageCRs;
import crsClasses.ProductReportPage;
import crsClasses.ProductReportResultPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ProductReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ProductReports", excel);
	}
	
	@Test(dataProvider="getData")
	public void productReport(String TestCases, String RunMode, String SBUCode, String Status, String PartNo, 
			String SKNNo, String PartNoManufNo, String SourceSystemNo, String Description, String ModelNo, 
			String ProductName, String CommodityType, String MaterialType, String ProductLine, String Program, 
			String Site, String Hazardous, String FlagReason, String NationalStockNumber, String CreatedBy, 
			String CreatedDateFrom, String CreatedDateTo, String ModifiedBy, String ModifiedDateFrom, 
			String ModifiedDateTo, String SortBy, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		ProductReportPage search = new ProductReportPage(driver, test);
		ProductReportResultPage report = new ProductReportResultPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.productReport();
					search.searchByParameters(SBUCode, Status, PartNo, SKNNo, PartNoManufNo, SourceSystemNo, 
							Description, ModelNo, ProductName, CommodityType, MaterialType, ProductLine, 
							Program, Site, Hazardous, FlagReason, NationalStockNumber, CreatedBy, CreatedDateFrom, 
							CreatedDateTo, ModifiedBy, ModifiedDateFrom, ModifiedDateTo, SortBy, Direction);
					Wait.waitfor(3);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					Wait.waitfor(3);
					homePage.returnToCRPage();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnToCRPage();
			testFail();
		}
	}
}