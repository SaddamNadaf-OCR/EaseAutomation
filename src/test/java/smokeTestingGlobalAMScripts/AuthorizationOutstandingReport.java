package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizationOutstandingReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.OutStandingReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationOutstandingReport extends SeleniumTestBase{
	
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
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		AuthorizationOutstandingReportPage search = new AuthorizationOutstandingReportPage(driver, test);
		OutStandingReportPage report = new OutStandingReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationOutstanding();
					search.searchByParameters(SBUCode, ActivityType, OriginatingTransaction, AuthorizationType, AuthorizationNo, 
							ReferanceNo, EntryNo, PartyName, TravelerName, TransactionDateFrom, TransactionDateTo, ExpiryDateFrom, 
							ExpiryDateTo, CountryShippedFrom, PortOfExport, CountryShippedTo, PortOfImport, PartNo, SerialNo, 
							ExportClassification, ImportClassification, ExportShipmentNo, ExpiresIn, IncludeLicense, OrderNo, Program,
							Segment, Site, Region, SortBy, Direction);
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