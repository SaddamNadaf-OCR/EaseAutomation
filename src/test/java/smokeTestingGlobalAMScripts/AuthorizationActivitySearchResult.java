package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorisationPage;
import authorizationManagementClasses.SearchAuthorizationActivityPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationActivitySearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthoActivitySearch", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationActivitySearch(String TestCases,String RunMode, String SBU, String AuthGrantCountry, String SBUCode, 
			String CreatedBy, String ShipmentType, String ShipmentSubType, String CountryOfAuth, String ActivityType, String AuthType,
			String AuthorizarationNo, String ReferanceNo, String AuthLineItemNo, String ActivityID, String RequestID, String ExportShipNo,
			String CustomRefNo, String EntryNo, String InternalRefNo, String PartyName, String TravelerName, String TransactionDateFrom, 
			String TransactionDateTo, String TransactionType, String CountryShippedFrom, String PortOfExport, String CountryShippedTo, 
			String PortOfImport, String PartNo, String SerialNo, String ExportClassification, String ImportClassification, String OriginalRefNo, 
			String OrderNo, String Program, String Segment, String Site, String Region, String Owner, String StopTracking, String SubComponenetLicense, 
			String SortBy, String Direction) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchAuthorizationActivityPage search = new SearchAuthorizationActivityPage(driver, test);
		ResultAuthorisationPage result = new ResultAuthorisationPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.AuthorizationActivity();
					search.searchByParameters(AuthGrantCountry, SBUCode, CreatedBy, ShipmentType, ShipmentSubType, CountryOfAuth, 
							ActivityType, AuthType, AuthorizarationNo, ReferanceNo, AuthLineItemNo, ActivityID, RequestID, ExportShipNo, 
							CustomRefNo, EntryNo, InternalRefNo, PartyName, TravelerName, TransactionDateFrom, TransactionDateTo, 
							TransactionType, CountryShippedFrom, PortOfExport, CountryShippedTo, PortOfImport, PartNo, SerialNo, 
							ExportClassification, ImportClassification, OriginalRefNo, OrderNo, Program, Segment, Site, Region, Owner, 
							StopTracking, SubComponenetLicense, SortBy, Direction);
					search.Search();
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
