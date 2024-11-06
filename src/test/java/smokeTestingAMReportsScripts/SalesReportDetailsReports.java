package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AnnualSalesDetailReportResultPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAnnualSalesDetailReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SalesReportDetailsReports extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AnnualSalesDetailReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualSalesDetailReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String AuthorizationType, String Status, String SalesreportType, 
			String AgreementNumber, String specialExportProgram, String Programme, String Poc, String Segment, 
			String Company, String ProductLine, String ProductFamily, String RelatedToDisclosure, String Amended, 
			String AgreementType, String Rebeselined, String AgreementExecuteDateFrom, String AgreementExecuteDateTo, 
			String SalesReportYear, String reportDateFrom, String reportDateTo, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAnnualSalesDetailReportPage search = new SearchAnnualSalesDetailReportPage(driver, test);
		AnnualSalesDetailReportResultPage report = new AnnualSalesDetailReportResultPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_SalesReportDetailReports();
					search.searchBYParameters(SBUCode, TransactionID, AuthorizationType, Status, SalesreportType, AgreementNumber, 
							specialExportProgram, Programme, Poc, Segment, Company, ProductLine, ProductFamily, RelatedToDisclosure, 
							Amended, AgreementType, Rebeselined, AgreementExecuteDateFrom, AgreementExecuteDateTo, SalesReportYear, 
							reportDateFrom, reportDateTo, SortBy, direction);
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
					homePage.returnTomoduleSelection();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnTomoduleSelection();
			testFail();
		}
	}
}
