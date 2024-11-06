package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.ResultPart130ReportsPage;
import authorizationManagementClasses.SearchPart130ReportsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class Part130ReportsSearchResult extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData() {
		return Utility.getData("Part130ReportSearchR", excel);
	}
	
	@Test(dataProvider="getData")
	public void searchByParameters(String TestCases,String RunMode, String SBU, String sbu, String Part130RefID, 
			String status, String POA, String ContractNo, String Recipient, String AgreementNo, String Country, 
			String SubmitReport, String ReportDateFrom, String ReportDateTo, String Program, String Segment, String Site, String Department) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchPart130ReportsPage search=new SearchPart130ReportsPage(driver, test);
		ResultPart130ReportsPage result=new ResultPart130ReportsPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonPart130Reports();
					search.searchByParameters(sbu, Part130RefID, status, POA, ContractNo, Recipient, AgreementNo, Country,
							SubmitReport, ReportDateFrom, ReportDateTo, Program, Segment, Site, Department);
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
