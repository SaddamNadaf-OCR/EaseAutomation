package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchShipmentActivityReportPage;
import authorizationManagementClasses.ShipmentActivityReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ShipmentActivityReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ShipmentActivityReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void productReport(String TestCases, String RunMode, String SBU, String SBUCode, String serialNo, String PartNo, 
			String ReferenceNo, String LicenseNo, String LicenseType, String TransactionType, String CountryShippedFrom, 
			String CountryShippedTo, String CreatedBY, String SortBy) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchShipmentActivityReportPage search = new SearchShipmentActivityReportPage(driver, test);
		ShipmentActivityReportPage report = new ShipmentActivityReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ShipmentActivityReports();
					search.searchByParameters(SBUCode, serialNo, PartNo, ReferenceNo, LicenseNo, LicenseType, TransactionType, 
							CountryShippedFrom, CountryShippedTo, CreatedBY, SortBy);
					search.search();
					Wait.waitfor(3);
					report.titleIsDisplayed();
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