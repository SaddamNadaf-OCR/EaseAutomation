package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Search Authorization Outstanding Report US
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil 
 */
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AuthorizationOutstandingReportPage;
import authorizationManagementClasses.OutStandingReportPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationOutstandingReportUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("OutStandingReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void productReport(String TestCases, String RunMode, String SBU, String SBUCode, String ActivityType, String OriginatingTransaction, 
			String AuthorizationType, String AuthorizationNo, String ReferanceNo, String EntryNo, String PartyName, String TravelerName, 
			String TransactionDateFrom, String TransactionDateTo, String ExpiryDateFrom, String ExpiryDateTo, String CountryShippedFrom, 
			String PortOfExport, String CountryShippedTo, String PortOfImport, String PartNo, String SerialNo, String ExportClassification, 
			String ImportClassification, String ExportShipmentNo, String ExpiresIn, String IncludeLicense, String OrderNo, String Program, 
			String Segment, String Site, String Region, String SortBy, String Direction) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		AuthorizationOutstandingReportPage search = new AuthorizationOutstandingReportPage(driver, test);
		ResultReportPage result = new ResultReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_AuthorizationOutstanding();
					search.searchByParameters(SBUCode, ActivityType, OriginatingTransaction, AuthorizationType, AuthorizationNo, 
							ReferanceNo, EntryNo, PartyName, TravelerName, TransactionDateFrom, TransactionDateTo, ExpiryDateFrom, 
							ExpiryDateTo, CountryShippedFrom, PortOfExport, CountryShippedTo, PortOfImport, PartNo, SerialNo, 
							ExportClassification, ImportClassification, ExportShipmentNo, ExpiresIn, IncludeLicense, OrderNo, Program,
							Segment, Site, Region, SortBy, Direction);
					search.search();
					Wait.waitfor(3);
					result.titleIsDisplayed();
					Wait.waitfor(3);
					HGExport.return_ExportHome();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			HGExport.return_ExportHome();
			testFail();
		}
	}
}