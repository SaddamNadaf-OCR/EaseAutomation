package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchSublicenseeNDADelinquencyReportPage;
import authorizationManagementClasses.SublicenseeNDADelinquencyReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SublicenseeNDADelinquencyReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("sublicenseeNDADelinquencyReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void sublicenseeNDADelinquencyReport(String TestCases, String RunMode, String SBU, String SBUCode, String AgreementNo, 
			String TransactionID, String AuthorizationOwner, String LicensePOC, String NDAName, String NDACompany, 
			String ndadateFrom, String ndadateTo, String ReviewerName, String ProductLine, String ProductFamily, String AuthType, 
			String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchSublicenseeNDADelinquencyReportPage search = new SearchSublicenseeNDADelinquencyReportPage(driver, test);
		SublicenseeNDADelinquencyReportPage report = new SublicenseeNDADelinquencyReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_SublicenceeNDADelinquencyReports();
					search.searchBYParameters(SBUCode, AgreementNo, TransactionID, AuthorizationOwner, LicensePOC, NDAName, NDACompany, 
							ndadateFrom, ndadateTo, ReviewerName, ProductLine, ProductFamily, AuthType, SortBy, direction);
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