package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.ActivityReportPage;
import authorizationManagementClasses.AuthorizationActivityReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationActivityReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ActivityReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void productReport(String TestCases, String RunMode, String SBU, String SBUCode, String Status, String ActivityType, 
			String AuthorizationType, String AuthorizationNo, String OriginatingTransaction, String ReferanceNo, String EntryNo, 
			String PartyName, String TransactionDateFrom, String TransactionDateTo, String ExpiryDateFrom, String ExpiryDateTo, 
			String CountryShippedFrom, String PortOfExport, String CountryShippedTo, String PortOfImport, String PartNo, 
			String SerialNo, String ExportClassification, String ImportClassification, String TravelerName, String ExportShipmentNo, 
			String ExpiresIn, String IncludeLicense, String Program, String Segment, String Site, String Region, String OrderNo, 
			String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		AuthorizationActivityReportPage search = new AuthorizationActivityReportPage(driver, test);
		ActivityReportPage report = new ActivityReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_Authorization_Activity();
					search.searchByParameters(SBUCode, Status, ActivityType, AuthorizationType, AuthorizationNo, OriginatingTransaction, 
							ReferanceNo, EntryNo, PartyName, TransactionDateFrom, TransactionDateTo, ExpiryDateFrom, ExpiryDateTo, 
							CountryShippedFrom, PortOfExport, CountryShippedTo, PortOfImport, PartNo, SerialNo, ExportClassification, 
							ImportClassification, TravelerName, ExportShipmentNo, ExpiresIn, IncludeLicense, Program, Segment, Site, Region, 
							OrderNo, SortBy, Direction);
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