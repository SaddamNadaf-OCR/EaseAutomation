package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.LVSExceptionReportPage;
import authorizationManagementClasses.SearchLVSExceptionReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LVSExceptionReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("LVSExceptionReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void lVSExceptionReport(String TestCases, String RunMode, String SBU, String SBUCode, String ShipmentWorkStatus, 
			String CountrysOfUltDestination, String DateOfExportFrom, String DateOfExportTo, String ExporterCode, 
			String ExporterName, String shipmentNo, String SalesOrderNo, String ECCNCategory, String UltimateConsignee, String PartNo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchLVSExceptionReportPage search = new SearchLVSExceptionReportPage(driver, test);
		LVSExceptionReportPage report = new LVSExceptionReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_LVSExceptionReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, CountrysOfUltDestination, DateOfExportFrom, 
							DateOfExportTo, ExporterCode, ExporterName, shipmentNo, SalesOrderNo, ECCNCategory, UltimateConsignee, PartNo);					
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
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