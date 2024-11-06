package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAgreementReportsPage;
import authorizationManagementClasses.SearchAgreementReportsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgreementReportsSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData() {
		return Utility.getData("AgreementReportSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void agreementSearchResult(String TestCases,String RunMode, String SBU, String sbu, String agreementNo, 
			String transactionNo, String AgreementType, String USGStatus, String ReportDateFrom, String ReportDateTo, 
			String AnnualStatusReport, String AgreementNonConclude, String AgreementConfirmed, String MLAConfirmed, 
			String AgreementAmendment, String AgreementTermination, String EmpoweredOfficial, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAgreementReportsPage search=new SearchAgreementReportsPage(driver, test);
		ResultAgreementReportsPage result=new ResultAgreementReportsPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickOnAgreementReport();
					search.searchBYParameters(sbu, agreementNo, transactionNo, AgreementType, USGStatus,
							ReportDateFrom, ReportDateTo, AnnualStatusReport, AgreementNonConclude, AgreementConfirmed,
							MLAConfirmed, AgreementAmendment, AgreementTermination, EmpoweredOfficial, SortBy, Direction);
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
		}catch(Exception e) {
			testFail();
			homePage.returnTomoduleSelection();
			e.printStackTrace();
		}
	}

}
