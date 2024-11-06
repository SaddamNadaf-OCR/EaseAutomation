package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.EXPORTSUNDERITAREXEMPTIONSSUMMARYPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchExportsUnderITARExemptionSummaryPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportsUnderITARExemptionSummaryReportUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ExpUnderITARExempSummary", excel);
	}
	
	@Test(dataProvider="getData")
	public void exportsUnderITARExemptionSummary(String TestCases, String RunMode, String SBU, String SBUCode, 
			String ShipmentWorkStatus, String Exemption, String ExemptionDescription, String DateOfExportFrom, 
			String DateOfExportTo, String ExporterCode, String ExporterName, String shipmentNo, String SalesOrderNo, 
			String USMLCategory, String UltimateConsignee, String DestinationCountry, String TransactionType, String PartNo) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchExportsUnderITARExemptionSummaryPage search = new SearchExportsUnderITARExemptionSummaryPage(driver, test);
		EXPORTSUNDERITAREXEMPTIONSSUMMARYPage report = new EXPORTSUNDERITAREXEMPTIONSSUMMARYPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_ITARExemptionReport();
					HGExport.click_SummaryReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, Exemption, ExemptionDescription, DateOfExportFrom, 
							DateOfExportTo, ExporterCode, ExporterName, shipmentNo, SalesOrderNo, USMLCategory, UltimateConsignee, 
							DestinationCountry, TransactionType, PartNo);
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