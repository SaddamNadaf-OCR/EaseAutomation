package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.ComplianceNotesTemplatePage;
import authorizationManagementClasses.CreateComplianceNotesPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchComplianceNotesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ComplianceNotes extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ComplianceNotesScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void complianceNotes(String TestCases, String RunMode, String SBU, String ReferanceNO, String date, String notesID,
			String code, String purpose, String contactType, String authorizationtype, String priority,String securityClassName, 
			String transactionID, String country, String productfamilyID,String Programcode,String programtextbox, String SegmentCode,
			String segmentTextbox,String ProductLineID,String usgOfficer, String usgPhoneNo,String usgEmail,String userFirstname,
			String userFirstname1,String selectList, String issueSummary,String description,String memo,String accessLevel) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver,test);
		SearchComplianceNotesPage searchCompNotes=new SearchComplianceNotesPage(driver,test);
		ComplianceNotesTemplatePage templates=new ComplianceNotesTemplatePage(driver,test);
		CreateComplianceNotesPage createCN=new CreateComplianceNotesPage(driver,test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonComplianceNotes();
					searchCompNotes.addComplianceNotes();
					templates.clickonNew();
					createCN.complianeNotes(ReferanceNO,date, notesID, code, purpose, contactType, authorizationtype, priority, 
							securityClassName, transactionID, country, productfamilyID, Programcode,programtextbox,
							SegmentCode,segmentTextbox,ProductLineID,usgOfficer,usgPhoneNo,usgEmail,userFirstname,
							userFirstname1,selectList,issueSummary,description,memo);
					createCN.saveTab();
				}else {
					testFail();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			testFail();
		}
	}

}
