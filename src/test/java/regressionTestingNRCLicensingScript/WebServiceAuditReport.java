package regressionTestingNRCLicensingScript;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.ResultWebServiceAuditReportPage;
import nrcLicensingClasses.SearchWebServiceAuditReportPage;
import utilities.Utility;
import utilities.Wait;

public class WebServiceAuditReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("WebServiceAuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void webServiceAuditReport(String TestCases, String RunMode, String SBU, String SBUCode, String UserID, 
			String RequestType, String RequestDateFrom, String MessageType, String RequestDateTo, String Status, 
			String ReferanceNo, String AuditID) {
		
		HomePageNrcLicense homePage=new HomePageNrcLicense(driver, test);
		SearchWebServiceAuditReportPage search = new SearchWebServiceAuditReportPage(driver, test);
		ResultWebServiceAuditReportPage report = new ResultWebServiceAuditReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_SBUSelection(SBU);
					homePage.movetoWebserviceAuditApplicationReport();
					search.searchbyParameters(SBUCode, UserID, RequestType);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					homePage.NrcreturnPage();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.NrcreturnPage();
			testFail();
		}
	}
}
