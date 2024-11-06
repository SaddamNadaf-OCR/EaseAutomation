package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultClassifiedLicenseReportPage;
import authorizationManagementClasses.SearchClassifiedLicenseReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ClassifiedReportSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ClassifiedReportSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void authCloseOut(String TestCases,String RunMode, String SBU, String sbu, String Type, String TransactionID, 
			String LicenseNO, String Status, String Segment, String Program, String ProductLine, String ProductFamily, 
			String ReportDateFrom, String ReportDateTo, String ClassificationLevel, String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchClassifiedLicenseReportPage search = new SearchClassifiedLicenseReportPage(driver, test);
		ResultClassifiedLicenseReportPage result = new ResultClassifiedLicenseReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickOnClassifiedReports();
					search.searchByParameters(sbu, Type, TransactionID, LicenseNO, Status, Segment, Program, 
							ProductLine, ProductFamily, ReportDateFrom, ReportDateTo, ClassificationLevel, SortBy, Direction);
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
		}
		catch(Exception e) {
			testFail();
			homePage.returnTomoduleSelection();
			e.printStackTrace();
		}
	}
}
