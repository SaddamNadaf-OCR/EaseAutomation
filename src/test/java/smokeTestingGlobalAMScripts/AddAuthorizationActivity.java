package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateNewAuthorizationActivityPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizationActivityPage;
import authorizationManagementClasses.SelectSBUAddActivityPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class AddAuthorizationActivity extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddAuthorizationActivity", excel);
	}
	
	@Test(dataProvider="getData")
	public void addvieweditAuthorization(String TestCases,String RunMode, String SBU, String activityType, String authorizationType, 
			String AuthorizationNo, String itemNo, String requestID, String shipmentFlag, String transactiondate, String referenceNo, 
			String referenceItemNo, String entryNo, String exportShipmentNo, String internalRefNo, String CustomsReferenceNo, 
			String CountryShippedFrom, String CountryShippedTo, String PortOfExport, String PortOfImport, String PartyName, 
			String TravelerName, String PartyType, String OrderNo, String OrderItemNo, String ImportClassification, 
			String Value, String Quentity, String SalesOrderNO, String SalesOrderLineItem, String SerialNo,
			String SubCompLicenses, String Remarks) {
		
		HomePage_AMPage homePageAm=new HomePage_AMPage(driver, test);
		SearchAuthorizationActivityPage searchAM=new SearchAuthorizationActivityPage(driver, test);
		SelectSBUAddActivityPage selectSBU=new SelectSBUAddActivityPage(driver, test);
		CreateNewAuthorizationActivityPage create=new CreateNewAuthorizationActivityPage(driver, test);
	
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePageAm.move_to_moduleSelection(SBU);
					homePageAm.moduleSelection();
					homePageAm.AuthorizationActivity();
					searchAM.addActivity();
					selectSBU.submit();
					create.authorizationDetails(activityType, authorizationType, AuthorizationNo, itemNo, requestID);
					create.ShipmentDetails(shipmentFlag, transactiondate, referenceNo, referenceItemNo, entryNo, exportShipmentNo, 
							internalRefNo, CustomsReferenceNo, CountryShippedFrom, CountryShippedTo, PortOfExport, PortOfImport, 
							PartyName, TravelerName, PartyType);
					create.itemDetails(OrderNo, OrderItemNo, ImportClassification, Value, Quentity, 
							SalesOrderNO, SalesOrderLineItem, SerialNo, SubCompLicenses, Remarks);
					create.saveandReturn();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			testFail();
		}	
	}

}
