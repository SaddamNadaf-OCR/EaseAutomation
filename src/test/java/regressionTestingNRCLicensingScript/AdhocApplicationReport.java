package regressionTestingNRCLicensingScript;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.ResultAdhocApplicationReportPage;
import nrcLicensingClasses.SearchAdhocApplicationReportPage;
import utilities.Utility;
import utilities.Wait;

public class AdhocApplicationReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AdhocApplicationReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void adhocApplicationReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String Status, String TypeOfAction, String ContractNo, String POA_Name, 
			String Program, String Segment, String Site, String Department, String Requester, String Reviewer, 
			String Notes, String Consignee, String InitiatedDateFrom, String InitiatedDateTo, String SubmitedDateFrom, 
			String SubmitedDateTo, String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo, 
			String SortBy, String Direction) {
		
		HomePageNrcLicense homePage=new HomePageNrcLicense(driver, test);
		SearchAdhocApplicationReportPage search = new SearchAdhocApplicationReportPage(driver, test);
		ResultAdhocApplicationReportPage report = new ResultAdhocApplicationReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.moveTo_SBUSelection(SBU);
					homePage.movetoAdhocApplicationReport();
					search.searchbyParameters(SBUCode, TransactionID, Status, TypeOfAction, ContractNo, 
							POA_Name, Program, Segment, Site, Department, Requester, Reviewer, Notes, 
							Consignee, InitiatedDateFrom, InitiatedDateTo, SubmitedDateFrom, SubmitedDateTo, 
							IssueDateFrom, IssueDateTo, ExpiryDateFrom, ExpiryDateTo, SortBy, Direction);
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
