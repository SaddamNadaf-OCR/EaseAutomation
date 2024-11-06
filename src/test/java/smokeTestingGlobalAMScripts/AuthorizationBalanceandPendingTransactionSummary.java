package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizationBalanceandPendingTransactionSummaryPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorizationBalanceandPendingTransactionSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationBalanceandPendingTransactionSummary extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthBalancePendingTransSummary", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationBalanceandPendingTransactionSummary(String TestCases, String RunMode, String SBU, String SBUCode, 
			String AuthorizationType, String AuthorizationNo, String Status, String CaseNo, String UltimateConsignee, String ContractNo, 
			String Country, String ReferanceNo, String TECC) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		AuthorizationBalanceandPendingTransactionSummaryPage search = new AuthorizationBalanceandPendingTransactionSummaryPage(driver, test);
		ResultAuthorizationBalanceandPendingTransactionSummaryPage report = new ResultAuthorizationBalanceandPendingTransactionSummaryPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AUTHBalance_PendingTransactionReports();
					search.searchByParameters(SBUCode, AuthorizationType, AuthorizationNo, Status, CaseNo, UltimateConsignee, 
							ContractNo, Country, ReferanceNo, TECC);
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