package smokeTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import crsClasses.ExportRequestReferenceReportPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultExportRequestReferenceReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestReferenceReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ExportReqRefReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void exportRequestReferenceReportScripts(String TestCases, String RunMode, String SBUID, String RequestID, 
			String RequesterName, String Approver, String Status, String Determination, String Consignee_Customer, 
			String USParty, String PartyCountry, String ExportAuthID, String RequestDateFrom, String RequestDateTo, 
			String Segment, String Site, String Program, String Department, String ProductFamily, String ProductDescription, 
			String SalesOrderNo, String PurchaseOrderNo, String SortBy, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		ExportRequestReferenceReportPage search = new ExportRequestReferenceReportPage(driver, test);
		ResultExportRequestReferenceReportPage report = new ResultExportRequestReferenceReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.exportRequestReferenceReport();
					search.searchByParameters(SBUID, RequestID, RequesterName, Approver, Status, Determination, 
							Consignee_Customer, USParty, PartyCountry, ExportAuthID, RequestDateFrom, RequestDateTo, 
							Segment, Site, Program, Department, ProductFamily, ProductDescription, SalesOrderNo, 
							PurchaseOrderNo, SortBy, Direction);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					homePage.returnToCRPage();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnToCRPage();
			testFail();
		}
	}
}
