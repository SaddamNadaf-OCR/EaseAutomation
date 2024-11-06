package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizationAgainstAgreementReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizationAgainstAgreementReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationAgainstAgreementReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthoAgainstAgreeReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void AuthorizationAgainstAgreementReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String AgreementNumber, String Status, String Programme, String Segment, String ProductLine, 
			String ProductFamily) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationAgainstAgreementReportPage search = new SearchAuthorizationAgainstAgreementReportPage(driver, test);
		AuthorizationAgainstAgreementReportPage report = new AuthorizationAgainstAgreementReportPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationAgainstAgreementReports();
					search.searchBYParameters(SBUCode, TransactionID, AgreementNumber, Status, Programme, Segment, ProductLine, ProductFamily);
					search.search();
					report.getText();
					Wait.waitfor(3);
					report.downloadPdf();
					Wait.waitfor(3);
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
