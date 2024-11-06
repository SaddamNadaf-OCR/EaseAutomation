package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.DS_4071TechDataUSGReportPage;
import authorizationManagementClasses.Ds4071TemplateUSGReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchDS4071TechDataUSGReportsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class DS4071TechDataReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("DS4071TechDataReportScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void ds4071report(String TestCases,String RunMode,String SBU, String referanceID, String exportID,String exportdate,
			String USGReportDate,String Approveddate,String RequiestedDate, String exportCode, String referanceNumber, String email,
			String telephone, String reviewerName, String empowerdeOfficier) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchDS4071TechDataUSGReportsPage search=new SearchDS4071TechDataUSGReportsPage(driver, test);
		Ds4071TemplateUSGReportPage dstemplate=new Ds4071TemplateUSGReportPage(driver, test);
		DS_4071TechDataUSGReportPage techData=new DS_4071TechDataUSGReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonDS4071Reports();
					search.add4071();
					dstemplate.newTemp();
					techData.exportActivity(referanceID, exportID, exportdate,USGReportDate,Approveddate, RequiestedDate,
							exportCode,referanceNumber, email, telephone, 
							reviewerName, empowerdeOfficier);
					techData.save();
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
