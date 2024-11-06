package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : Dec 2023
 * Descriptions : Compliance Request Status Metrics Report
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.ComplianceRequestStatusMetricsReportPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultComplianceRequestMetricsReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ComplianceRequestStatusMetricsReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ComplianceReqStatusMatrics", excel);
	}
	
	@Test(dataProvider="getData")
	public void complianceRequestStatusMetricsReport(String TestCases, String RunMode, String SBUCode, 
			String RequestID, String Status, String Determination, String RequesterName, String ExportFocalPoint, 
			String ReasonForReturn, String TechnicalFocalPoint, String DateInitiatedFrom, String DateInitiatedTo, 
			String DateSubmittedFrom, String DateSubmittedTo, String DetermainationDateFrom, String DetermainationDateTo) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		ComplianceRequestStatusMetricsReportPage search = new ComplianceRequestStatusMetricsReportPage(driver, test);
		ResultComplianceRequestMetricsReportPage report = new ResultComplianceRequestMetricsReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.complianceRequestStatusmetrics();
					search.searchByParameters(SBUCode, RequestID, Status, Determination, RequesterName, ExportFocalPoint, 
							ReasonForReturn, TechnicalFocalPoint, DateInitiatedFrom, DateInitiatedTo, DateSubmittedFrom, 
							DateSubmittedTo, DetermainationDateFrom, DetermainationDateTo);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					Wait.waitfor(3);
					report.IconsDisplay();
					//Wait.waitfor(3);
					//report.downloadPdf();
					Wait.waitfor(3);
					homePage.returnToCRPage();
					Wait.waitfor(3);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnToCRPage();
			testFail();
		}
	}
}
