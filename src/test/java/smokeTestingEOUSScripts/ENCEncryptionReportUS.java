package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.ENCENCRYPTIONREPORTPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchENCEncryptionReportPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ENCEncryptionReportUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ENCEncryptionReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void eNCEncryptionReport(String TestCases, String RunMode, String SBU, String SBUCode, String ShipmentWorkStatus, 
			String shipmentNo, String ExporterCode, String DateOfExportFrom, String DateOfExportTo, String ECCNCategory, 
			String ProductFamily, String Program, String UltimateConsignee, String CountrysOfUltDestination, String Region, 
			String Site, String PartNo) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchENCEncryptionReportPage search = new SearchENCEncryptionReportPage(driver, test);
		ENCENCRYPTIONREPORTPage report = new ENCENCRYPTIONREPORTPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_ENCExceptionReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, shipmentNo, ExporterCode, DateOfExportFrom,
							DateOfExportTo, ECCNCategory, ProductFamily, Program, UltimateConsignee, CountrysOfUltDestination, Region, Site, PartNo);
					
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