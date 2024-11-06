package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultOffshoreProcurementReportDSP5Page;
import authorizationManagementClasses.SearchOffshoreProcurementReportDSP_5Page;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class DSP5OffshoreProcurementReportSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("DSP5SearchResult", excel);
	}
	
	@Test(dataProvider="getData")
	public void dsp5SearchResult(String TestCases,String RunMode, String SBU, String SelectSBU, String type, 
			String transactionID, String LicenseNo, String Owner, String POC, String Status, String ReportDateFrom, 
			String ReportDateTo, String ReportCompleted,String SubmittedToDOS,String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchOffshoreProcurementReportDSP_5Page search = new SearchOffshoreProcurementReportDSP_5Page(driver, test);
		ResultOffshoreProcurementReportDSP5Page result = new ResultOffshoreProcurementReportDSP5Page(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonDSP5Reports();
					search.searchByParameters(SelectSBU, type, transactionID, LicenseNo, Owner, 
							POC, Status, ReportDateFrom, ReportDateTo,ReportCompleted,SubmittedToDOS, SortBy, Direction);
					search.search();
					result.titleIsDisplayed();
					Wait.waitfor(3);
					homePage.returnTomoduleSelection();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}
		catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		}
		catch(Exception e) {
			testFail();
			homePage.returnTomoduleSelection();
			e.printStackTrace();
		}
	}
}
