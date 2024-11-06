package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AddClassifiedReportsUSGReportsPage;
import authorizationManagementClasses.ClassifiedLicenseReportsPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchClassifiedLicenseReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ClassifiedReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ClassifiedReportScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void classifiedReports(String TestCases, String RunMode,String SBU,String transactionID, String USGOfficer, 
			String USGTitle, String EmpoweredOfficer, String EmpoweredTitle, String Exporter, String DDTCCode,
			String Submitdate, String Reportdate, String ReportText, String Remark) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver,test);
		SearchClassifiedLicenseReportPage sclr=new SearchClassifiedLicenseReportPage(driver,test);
		AddClassifiedReportsUSGReportsPage addclassifeid=new AddClassifiedReportsUSGReportsPage(driver,test);
		ClassifiedLicenseReportsPage report=new ClassifiedLicenseReportsPage(driver,test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickOnClassifiedReports();
					sclr.addclassifiedliecance();
					addclassifeid.addClassifiedReport(transactionID);
					addclassifeid.addcreateClssifiedButton();
					report.classifiedReport(USGOfficer, USGTitle, EmpoweredOfficer, EmpoweredTitle, Exporter,
							DDTCCode, Submitdate, Reportdate, ReportText, Remark);
					report.save();
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
