package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAgreementReportsPage;
import authorizationManagementClasses.USGAddAgreementReportsPage;
import authorizationManagementClasses.USGEditAgreementReportsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class AgreementReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AgreementReportScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void agreementReport(String TestCases,String RunMode,String SBU, String agreementNo, String usgOfficer, String usgTitle, 
			String empoweredOfficial, String title, String phone, String email, String exportor, String ddtcNumber, String reportYear,
			String reportDate, String referenceNo,String amendmentNo, String terminationdate, 
			String AdditionalReportText, String remarks) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver,test);
		SearchAgreementReportsPage usgAgree=new SearchAgreementReportsPage(driver,test);
		USGAddAgreementReportsPage usgAgreeReport=new USGAddAgreementReportsPage(driver,test);
		USGEditAgreementReportsPage usgEdit=new USGEditAgreementReportsPage(driver,test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickOnAgreementReport();
					usgAgree.addagreementreport();
					usgAgreeReport.agreementPopUp(agreementNo);
					usgAgreeReport.select();
					usgEdit.agreementReport(usgOfficer, usgTitle, empoweredOfficial, title, phone, email, 
							exportor, ddtcNumber, reportYear, reportDate, referenceNo,amendmentNo, 
							terminationdate, AdditionalReportText, remarks);
					usgEdit.save();
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