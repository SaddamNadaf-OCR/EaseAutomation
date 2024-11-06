package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultListOfAuthorizationsPage;
import authorizationManagementClasses.SearchListOfAuthorizationsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ListOfAuthorizations extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ListOfAuthorizations", excel);
	}
	
	@Test(dataProvider="getData")
	public void listOfAuthorizations(String TestCases, String RunMode, String SBU, String SBUCode, String AuthorizationType, 
			String AuthorizationNo, String Site, String ActivityType, String AuthorizationStatus, String ContractNo, 
			String Agency, String ReferanceID, String UltimateConsignee, String IssueDateFrom, String IssueDateTo, 
			String Country, String TECC, String AuthWillExpiry, String Segment, String ExpiryDateFrom, String ExpiryDateTo, 
			String Originator, String CreatedBy, String CaseNo, String SBUCode1, String ItemNo, String PartNo, String ECCNUSML, 
			String ActivityType1, String Quantity, String Value, String AuthQuantutyUsed, String AuthValueUsed, String CreatedBy1, 
			String SalesOrderNo, String SalesOrderLineItemNo, String Description, String Country1) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchListOfAuthorizationsPage search = new SearchListOfAuthorizationsPage(driver, test);
		ResultListOfAuthorizationsPage report = new ResultListOfAuthorizationsPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AuthorizationsReports();
					search.searchByParameters(SBUCode, AuthorizationType, AuthorizationNo, Site, ActivityType, 
							AuthorizationStatus, ContractNo, Agency, ReferanceID, UltimateConsignee, IssueDateFrom, 
							IssueDateTo, Country, TECC, AuthWillExpiry, Segment, ExpiryDateFrom, ExpiryDateTo, 
							Originator, CreatedBy, CaseNo, SBUCode1, ItemNo, PartNo, ECCNUSML, ActivityType1, 
							Quantity, Value, AuthQuantutyUsed, AuthValueUsed, CreatedBy1, SalesOrderNo, SalesOrderLineItemNo, Description, Country1);
					search.search();
					Wait.waitfor(5);
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