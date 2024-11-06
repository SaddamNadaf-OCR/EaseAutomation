package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultTempAuthorizationCloseOutPage;
import authorizationManagementClasses.TempAuthorizationCloseOUTPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class TempAuthorizationCloseOutSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData() {
		return Utility.getData("TempAuthCloseOutSearch", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchBySBU(String TestCases,String RunMode, String SBU, String sbu, String ShipmentFlagExport, 
			String ShipmentFlag, String CountryOfAuthorization, String ActivityType, String AuthorizationNo, 
			String AuthorizationType, String ReferanceID, String TransactionID, String ExportShipmentNo, 
			String CustomRefNo, String EntryNo, String InternalRefNo, String PartyName, String TravelerName, 
			String TransactionDate, String TransactionDateTo, String StopTracking, String CountryShippedFrom, 
			String PortOfExport, String CountryShippedTo, String PortOfImport, String PartNo, String SerialNo, 
			String ExportClassification, String ImportClassification, String OrderNo, String Program, String Segment, 
			String Site, String Region, String SortBy, String Direction) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		TempAuthorizationCloseOUTPage search=new TempAuthorizationCloseOUTPage(driver, test);
		ResultTempAuthorizationCloseOutPage result=new ResultTempAuthorizationCloseOutPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(2);
					homePage.move_to_moduleSelection(SBU);
					Wait.waitfor(2);
					homePage.moduleSelection();
					Wait.waitfor(2);
					homePage.click_on_TempAuthoCloseOut();
					search.searchByParameters(sbu, ShipmentFlagExport, ShipmentFlag, CountryOfAuthorization, 
							ActivityType, AuthorizationNo, AuthorizationType, ReferanceID, TransactionID, 
							ExportShipmentNo, CustomRefNo, EntryNo, InternalRefNo, PartyName, TravelerName, 
							TransactionDate, TransactionDateTo, StopTracking, CountryShippedFrom, PortOfExport,
							CountryShippedTo, PortOfImport, PartNo, SerialNo, ExportClassification, ImportClassification,
							OrderNo, Program, Segment, Site, Region, SortBy, Direction);
					search.search();
					result.titleIsDisplayed();
					homePage.returnTomoduleSelection();
					//homePage.logOut();
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
