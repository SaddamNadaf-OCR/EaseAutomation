package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AnnualSalesDelinquencyReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAnnualSalesDelinquencyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AnnualSalesDelinquencyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AnnualSalesDelinquencyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void AnnualSalesDelinquencyReports(String TestCases, String RunMode, String SBU, String SBUCode, String TransactionID,
			String AuthorizationType, String Status, String SalesreportType, String AgreementNumber, String specialExportProgram, 
			String Programme, String Poc, String Segment, String Company, String ProductLine, String ProductFamily, String SalesReportYear,
			String reportDateFrom, String reportDateTo, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAnnualSalesDelinquencyReportPage search = new SearchAnnualSalesDelinquencyReportPage(driver, test);
		AnnualSalesDelinquencyReportPage report = new AnnualSalesDelinquencyReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_SalesReportDelinquencyReports();
					search.searchBYParameters(SBUCode, TransactionID, AuthorizationType, Status, SalesreportType, AgreementNumber, specialExportProgram,
							Programme, Poc, Segment, Company, ProductLine, ProductFamily, SalesReportYear, reportDateFrom, reportDateTo, SortBy, direction);
					search.search();
					report.getText();
					Wait.waitfor(3);
					report.downloadPdf();
					Wait.waitfor(5);
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
