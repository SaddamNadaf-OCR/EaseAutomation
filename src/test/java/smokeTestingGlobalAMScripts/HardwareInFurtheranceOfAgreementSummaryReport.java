package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HardwareInFurtheranceOfAgreementSummaryReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchHardwareInFurtheranceOfAgreementReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class HardwareInFurtheranceOfAgreementSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("HardwareAgreementSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void agreementValuationSummaryReportScripts(String TestCases, String RunMode, String SBU, String SBUCode, 
			String TransactionID, String AgreementNumber, String FormType, String Status, String Programme, 
			String Segment, String ProductLine, String ProductFamily, String AuthPurpose, String specialExportProgram, 
			String Disclosure, String agreementType, String ExecutedDateFrom, String ExecutedDateTo, String rebaselined, 
			String amended, String SortBy, String direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchHardwareInFurtheranceOfAgreementReportPage search = new SearchHardwareInFurtheranceOfAgreementReportPage(driver, test);
		HardwareInFurtheranceOfAgreementSummaryReportPage report = new HardwareInFurtheranceOfAgreementSummaryReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_HardwareInFurtheranceOfAgreementReports();
					search.searchBYParameters(SBUCode, TransactionID, AgreementNumber, FormType, Status, Programme, Segment, ProductLine, 
							ProductFamily, AuthPurpose, specialExportProgram, Disclosure, agreementType, ExecutedDateFrom, ExecutedDateTo, 
							rebaselined, amended, SortBy, direction);
					search.search();
					Wait.waitfor(3);
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
