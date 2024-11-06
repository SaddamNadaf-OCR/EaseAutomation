package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.Search3rdCountryDualNationalSummaryReportPage;
import authorizationManagementClasses.ThirdCountryDualNationalSummaryReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Search3rdCountryDualNationalSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData(){
		return Utility.getData("NationalSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void NDADelinquencyReport(String TestCases,String RunMode, String SBU, String sbuCode, String AgreementNo, 
			String TransactionId, String AuthOwner, String licencePoc, String NDAName, String NDAcompany, String NDADatesFrom, 
			String NDADatesTo, String ReviewerName, String producrLineID, String ProductFamily, String AuthType, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		Search3rdCountryDualNationalSummaryReportPage search=new Search3rdCountryDualNationalSummaryReportPage(driver, test);
		ThirdCountryDualNationalSummaryReportPage report=new ThirdCountryDualNationalSummaryReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)){
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_3rdCountryDualNationalSummary();
					search.searchParameters(sbuCode, AgreementNo, TransactionId, AuthOwner, licencePoc, NDAName, NDAcompany, 
							NDADatesFrom, NDADatesTo, ReviewerName, producrLineID, ProductFamily, AuthType, SortBy, Direction);
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