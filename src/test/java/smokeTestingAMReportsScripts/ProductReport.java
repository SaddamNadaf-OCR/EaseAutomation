package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ProductReportResultPage;
import authorizationManagementClasses.SearchProductReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ProductReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ProductReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void productReport(String TestCases, String RunMode, String SBU, String SBUCode, String Status, String PartNo, String SKNNo, 
			String PartNoManufNo, String SourceSystemNo, String Description, String ModelNo, String ProductName, String CommodityType, 
			String MaterialType, String ProductLine, String Program, String Site, String Hazardous, String FlagReason, String NationalStockNumber, 
			String CreatedBy, String CreatedDateFrom, String CreatedDateTo, String ModifiedBy, String ModifiedDateFrom, String ModifiedDateTo, 
			String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchProductReportPage search = new SearchProductReportPage(driver, test);
		ProductReportResultPage report = new ProductReportResultPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ProductReports();
					search.searchByParameters(SBUCode, Status, PartNo, SKNNo, PartNoManufNo, SourceSystemNo, Description, ModelNo, 
							ProductName, CommodityType, MaterialType, ProductLine, Program, Site, Hazardous, FlagReason, NationalStockNumber, 
							CreatedBy, CreatedDateFrom, CreatedDateTo, ModifiedBy, ModifiedDateFrom, ModifiedDateTo, SortBy, Direction);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					Wait.waitfor(3);
					homePage.returnTomoduleSelection();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnTomoduleSelection();
			testFail();
		}
	}
}