package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateNewPart130ReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchPart130ReportsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class NewPart130Report extends SeleniumTestBase{
	
	@DataProvider
	public Object[][]getData(){
		return Utility.getData("NewPart130ReportScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void add130Part(String TestCases,String RunMode, String SBU, String contractNo, String AgreementNo, 
		 String Program, String Segment, String Site, String Department) {
		
		HomePage_AMPage homePage = new HomePage_AMPage(driver, test);
		SearchPart130ReportsPage searchPage = new SearchPart130ReportsPage(driver, test);
		CreateNewPart130ReportPage createNew = new CreateNewPart130ReportPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(3);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonPart130Reports();
					searchPage.addPart130report();
					createNew.createNewPart(contractNo, AgreementNo, Program, Segment, Site, Department);
					createNew.saveandreturn();
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
