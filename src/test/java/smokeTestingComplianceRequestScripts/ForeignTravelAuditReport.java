package smokeTestingComplianceRequestScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import crsClasses.ForeignTravelAuditReportPage;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelAuditReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ForeignTravelAuditReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ForeignTravelAuditReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void completedForeignTravelRequestsReport(String TestCases, String RunMode, String ForeignTravelID, String SortBy, String Direction) {
		
		HomePageCRs homePage=new HomePageCRs(driver, test);
		ForeignTravelAuditReportPage search = new ForeignTravelAuditReportPage(driver, test);
		ResultForeignTravelAuditReportPage report = new ResultForeignTravelAuditReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_ListScreening();
					homePage.click_ComplianceRequest();
					homePage.foreignTravelAuditReport();
					search.searchByParameters(ForeignTravelID, SortBy, Direction);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
					homePage.returnToCRPage();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnToCRPage();
			testFail();
		}
	}
}
