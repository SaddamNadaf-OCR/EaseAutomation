package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchShipmentSummaryBySBUReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchShipmentSummaryBySBUReportUS extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ShipSummSBUReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void ShipSummarySBUReport(String TestCases, String RunMode, String SBU, String SBUCode, String country, String UltDest ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentSummaryBySBUReportPage sbuReport = new SearchShipmentSummaryBySBUReportPage(driver, test);
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_MISReports();
					HGExport.ShipSummarySBU();
					sbuReport.selectSBU(SBUCode);
					sbuReport.selectCountry(country);
					sbuReport.UltDestCountry(UltDest);
					sbuReport.searchBtn();
					sbuReport.validateHeading();
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
