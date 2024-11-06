package smokeTestingEOUSScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchShipmentProcessingStatisticsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchShipmentProcessingStatisticsReportUS extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("StatisticsReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void ShipStatisticsReport(String TestCases, String RunMode, String SBU, String SBUCode, String workStatus, String country ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentProcessingStatisticsReportPage statsReport = new SearchShipmentProcessingStatisticsReportPage(driver, test);
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.click_MISReports();
					HGExport.statisticsReport();
					statsReport.selectSBU(SBUCode);
					statsReport.selectWorkStatus(workStatus);
					statsReport.selectCountry(country);
					statsReport.searchBtn();
					Wait.waitfor(2);
					statsReport.validateHeading();
					Wait.waitfor(2);
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


