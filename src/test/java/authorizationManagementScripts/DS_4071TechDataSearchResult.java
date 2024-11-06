package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultDS_4071TechDataPage;
import authorizationManagementClasses.SearchDS4071TechDataUSGReportsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class DS_4071TechDataSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("DS4071TechSearchResult", excel);
	}
	
	@Test(dataProvider="getData")
	public void ds4071TechData(String TestCases,String RunMode, String SBU, String sbuCode, String ReferanceNo, String ExportAuthNo,
			String AuthorizationType, String AuthorizationNo, String ExemptionNo, String AgreementNo, String InitialShipment, String USGReport, 
			String Status, String Country, String ExportdateFrom, String ExportdateTo, String UsgReportDateFrom, String UsgReportDateto, 
			String Program, String EndUserName, String ShipmentMode, String PortOfExport, String ShipRefNo, String EmOfficer, String UserName, 
			String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchDS4071TechDataUSGReportsPage search = new SearchDS4071TechDataUSGReportsPage(driver, test);
		ResultDS_4071TechDataPage result = new ResultDS_4071TechDataPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonDS4071Reports();
					search.searchByParameters(sbuCode, ReferanceNo, ExportAuthNo, AuthorizationType,
							AuthorizationNo, ExemptionNo, AgreementNo, InitialShipment, USGReport, Status, Country, ExportdateFrom, 
							ExportdateTo, UsgReportDateFrom, UsgReportDateto, Program, EndUserName,
							ShipmentMode, PortOfExport, ShipRefNo, EmOfficer, UserName, SortBy, Direction);
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
