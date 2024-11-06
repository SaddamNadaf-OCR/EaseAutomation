package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ITARExemptionDetailReportPage;
import authorizationManagementClasses.SearchExportsUnderITARExemptionDetailsReportPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ExportsUnderITARExemptionDetailsReportUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ITARExempDetailsReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void exportsUnderITARExemptionDetailsReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String shipmentNo, String DestinationCountry, String ShipmentWorkStatus, String UltimateConsignee, 
			String AuthorizationType, String CreatedDateFrom, String CreatedDateTo, String DateOfExportFrom, String DateOfExportTo, String PartNo) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchExportsUnderITARExemptionDetailsReportPage search = new SearchExportsUnderITARExemptionDetailsReportPage(driver, test);
		ITARExemptionDetailReportPage report = new ITARExemptionDetailReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_ITARExemptionReport();
					HGExport.click_DetailsReports();
					search.searchByAllParameters(SBUCode, shipmentNo, DestinationCountry, ShipmentWorkStatus, 
							UltimateConsignee, AuthorizationType, CreatedDateFrom, CreatedDateTo, DateOfExportFrom, DateOfExportTo, PartNo);
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