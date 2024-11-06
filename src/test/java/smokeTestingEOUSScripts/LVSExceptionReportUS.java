package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.LVSExceptionReportPage;
import authorizationManagementClasses.SearchLVSExceptionReportPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LVSExceptionReportUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("LVSExceptionReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void lVSExceptionReport(String TestCases, String RunMode, String SBU, String SBUCode, String ShipmentWorkStatus, 
			String CountrysOfUltDestination, String DateOfExportFrom, String DateOfExportTo, String ExporterCode, 
			String ExporterName, String shipmentNo, String SalesOrderNo, String ECCNCategory, String UltimateConsignee, String PartNo) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchLVSExceptionReportPage search = new SearchLVSExceptionReportPage(driver, test);
		LVSExceptionReportPage report = new LVSExceptionReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_LVSExceptionReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, CountrysOfUltDestination, DateOfExportFrom, 
							DateOfExportTo, ExporterCode, ExporterName, shipmentNo, SalesOrderNo, ECCNCategory, UltimateConsignee, PartNo);					
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
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