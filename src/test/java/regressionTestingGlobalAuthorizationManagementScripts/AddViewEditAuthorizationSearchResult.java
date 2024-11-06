package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultAuthorisationPage;
import authorizationManagementClasses.SearchAuthorisationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddViewEditAuthorizationSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData() {
		return Utility.getData("AddViewEditSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchBySBU(String TestCases,String RunMode, String SBU, String AuthGrantedCountry, String sbuCode, String AuthorizationNo,
			String authorizationStatus, String caseNo, String ContactNumber, String refNo, String RequestID, String authorizationType,
			String ActivityType, String Site, String AuthExpiry, String Commodity, String IssueDateFrom, String IssueDateTo, 
			String ExpirationDateFrom, String ExpirationDateTo, String folderID, String PartyName, String Parties, String Country, 
			String Agency, String AuthOwner, String TECC, String Segment, String Originator, String CreatedBy, String SortBy, 
			String Direction, String ItemNo, String PartNo, String ExportClassification, String Description, String Quantity,
			String Value, String AuthQunatityUsed, String AuthValueUsed, String SBUCODE, String CREATEDBY, String SortBy1, String Direction1) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorisationPage searchAuth=new SearchAuthorisationPage(driver, test);
		ResultAuthorisationPage result=new ResultAuthorisationPage(driver, test);
		
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
					homePage.clickonAddViewEdit();
					searchAuth.searchByParameters(AuthGrantedCountry, sbuCode, AuthorizationNo, authorizationStatus,
							caseNo, ContactNumber, refNo, RequestID, authorizationType, ActivityType, Site, AuthExpiry, 
							Commodity, IssueDateFrom, IssueDateTo, ExpirationDateFrom, ExpirationDateTo, folderID, 
							PartyName, Parties, Country, Agency, AuthOwner, TECC, Segment, Originator, CreatedBy, 
							SortBy, Direction, ItemNo, PartNo, ExportClassification, Description, Quantity, Value, 
							AuthQunatityUsed, AuthValueUsed, SBUCODE, CREATEDBY, SortBy1, Direction1);
					searchAuth.search();
					result.titleIsDisplayed();
					homePage.returnTomoduleSelection();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}
		catch (SkipException s) {
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
