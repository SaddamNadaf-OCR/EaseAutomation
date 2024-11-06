package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.Non_ConcludedAgreementsPage;
import authorizationManagementClasses.SearchNon_ConcludedAgreementsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Non_ConcludedAgreements extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("Non_ConcludedAgreementsReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualStatusDelinquencyReportScripts(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String AgreementNumber, String FormType, String Status, String Programme, String Segment,
			String ProductLine, String ProductFamily, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchNon_ConcludedAgreementsPage search = new SearchNon_ConcludedAgreementsPage(driver, test);
		Non_ConcludedAgreementsPage report = new Non_ConcludedAgreementsPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_NonConcludedAgreementsReports();
					search.searchBYParameters(SBUCode, TransactionID, AgreementNumber, FormType, Status, Programme, 
							Segment, ProductLine, ProductFamily, SortBy, direction);
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
