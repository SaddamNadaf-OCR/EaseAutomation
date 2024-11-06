package smokeTestingAMReportsScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchTransactionsMeetingPart130Page;
import authorizationManagementClasses.TRANSACTIONSMEETINGPART130Page;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class TransactionsMeetingPart130 extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("TransactionsMeetingPart130", excel);
	}
	
	@Test(dataProvider="getData")
	public void transactionsMeetingPart130(String TestCases, String RunMode, String SBU, String SBUCode, String FormType, 
			String Status, String selectCompliance, String TransactionID, String LicenseNo, String AssociatedAGMT, String AssociatedLicense, 
			String Part130Required, String Part12613Submitted, String LicenseHardware, String LicenseTechnicalData, String LicenseDefenceService, 
			String LicenseEmployee, String SubmittedDateFrom, String SubmittedDateTo, String IssueDateFrom, String IssueDateTo, 
			String ExpiryDateFrom, String ExpiryDateTo, String CloseOutDateFrom, String CloseOutDateTo, String Programme, String Segment, 
			String Site, String Department, String ProductLine, String ProductFamily, String AuthorizationOwner, String licenseManager, 
			String LicenseRequester, String Reviewer, String PreparedBy, String CorparateREP, String EmpoweredOfficial, String Part130POC) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchTransactionsMeetingPart130Page search = new SearchTransactionsMeetingPart130Page(driver, test);
		TRANSACTIONSMEETINGPART130Page report = new TRANSACTIONSMEETINGPART130Page(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_TransactionsMeetingPart130Reports();
					search.searchByAllParameters(SBUCode, FormType, Status, selectCompliance, TransactionID, LicenseNo, 
							AssociatedAGMT, AssociatedLicense, Part130Required, Part12613Submitted, LicenseHardware, 
							LicenseTechnicalData, LicenseDefenceService, LicenseEmployee, SubmittedDateFrom, SubmittedDateTo, 
							IssueDateFrom, IssueDateTo, ExpiryDateFrom, ExpiryDateTo, CloseOutDateFrom, CloseOutDateTo, 
							Programme, Segment, Site, Department, ProductLine, ProductFamily, AuthorizationOwner, licenseManager, 
							LicenseRequester, Reviewer, PreparedBy, CorparateREP, EmpoweredOfficial, Part130POC);
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