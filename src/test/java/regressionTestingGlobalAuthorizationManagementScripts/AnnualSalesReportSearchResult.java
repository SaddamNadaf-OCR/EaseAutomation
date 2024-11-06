package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AnnualSalesReportSearchPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAnnualSalesReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AnnualSalesReportSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData() {
		return Utility.getData("AnnualSalesSearchResult", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchBySBU(String TestCases,String RunMode, String SBU, String sbu, String TransactionID,
			String AuthorizationType, String Status, String SalesReportType, String AgreementNo, String Program,
			String POC, String Segment, String Company, String ProductLine, String ProductFamily, String SalesReportYear, 
			String ReportDateFrom, String ReportDateTo, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		AnnualSalesReportSearchPage search=new AnnualSalesReportSearchPage(driver, test);
		ResultAnnualSalesReportPage result=new ResultAnnualSalesReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickOnAnnualSalesReport();
					search.searchByParameters(sbu, TransactionID, AuthorizationType, Status, 
							SalesReportType, AgreementNo, Program, POC, Segment, Company, ProductLine, 
							ProductFamily, SalesReportYear, ReportDateFrom, ReportDateTo, SortBy, Direction);
					search.search();
					result.titleIsDisplayed();
					Wait.waitfor(3);
					homePage.returnTomoduleSelection();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch (SkipException s) {
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
