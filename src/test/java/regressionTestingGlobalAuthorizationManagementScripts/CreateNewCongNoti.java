package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateNewCongressionalNotificationPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchCongressionalNotificationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewCongNoti extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewCongNotiScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void createCongressionNotification(String TestCases,String RunMode,String SBU,String referenaceNo,
			String congressionalNo,String caseNo,String Status,String submitDate,String segementNo,String commodityNo,
			String countryName,String value,String dateOfHill,String associatedLiecance,String  assoiciatedNL) {
		
		HomePage_AMPage homepage = new HomePage_AMPage(driver,test);
		SearchCongressionalNotificationPage searchCN=new SearchCongressionalNotificationPage(driver,test);
		CreateNewCongressionalNotificationPage createNCN=new CreateNewCongressionalNotificationPage(driver,test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(3);
					homepage.move_to_moduleSelection(SBU);
					Wait.waitfor(3);
					homepage.moduleSelection();
					Wait.waitfor(3);
					homepage.clickonCongNotification();
					Wait.waitfor(3);
					searchCN.addCongressionalNotification();
					Wait.waitfor(3);
					createNCN.addDataIntoCN(referenaceNo, congressionalNo, caseNo, Status, submitDate,
							segementNo, commodityNo, countryName, value, dateOfHill, associatedLiecance, assoiciatedNL);
					Wait.waitfor(3);
					createNCN.saveAndReturn();
					homepage.logOut();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			testFail();
		}
	}

}
