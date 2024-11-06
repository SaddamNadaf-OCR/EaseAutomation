package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Dec 2023
 * Descriptions : Export Request Details Report
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.ExportRequestDetailsReportPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchExportRequestDetailsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportRequestDetailsReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ExportReqDetailsReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualStatusDelinquencyReportScripts(String TestCases, String RunMode, String SBUCode, String RequestID, 
			String RequesterName, String Approver, String Status, String Determination, String Consignee_Customer, 
			String USParty, String PartyCountry, String ExportAuthID, String STALetterObtained, String Purpose, 
			String RequestDateFrom, String RequestDateTo, String Segment, String Site, String Program, String Department, 
			String ProductFamily, String ProductDescription, String SalesOrderNo, String PurchaseOrderNo, String SortBy, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		SearchExportRequestDetailsReportPage search = new SearchExportRequestDetailsReportPage(driver, test);
		ExportRequestDetailsReportPage report = new ExportRequestDetailsReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.exportRequestDetailsReport();
					search.searchByParameters(SBUCode, RequestID, RequesterName, Approver, Status, Determination, 
							Consignee_Customer, USParty, PartyCountry, ExportAuthID, STALetterObtained, Purpose, 
							RequestDateFrom, RequestDateTo, Segment, Site, Program, Department, ProductFamily, 
							ProductDescription, SalesOrderNo, PurchaseOrderNo, SortBy, Direction);
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
