package dpssScripts;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dpssClasses.AdHocScreeningResultsPage;
import dpssClasses.AdhocScreeningPage;
import dpssClasses.HomePage;
import dpssClasses.SearchConsigneePage;
import dpssClasses.WatchListScreeningDefaultsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddToDatabase extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddToDatabase", excel);
	}

	@Test(dataProvider = "getData") 

	public void AddToDatabasefunctionality(String TestCaseID,String Testcase,String RunMode,
			String EntityName) 
					throws Exception {


		// ******************************** Objects Creation *******************************************

		HomePage							homePage		 = new HomePage(driver, test);		
		AdhocScreeningPage					Adhoc            = new AdhocScreeningPage(driver,test);
		AdHocScreeningResultsPage			AdhocResults     = new AdHocScreeningResultsPage(driver,test);
		WatchListScreeningDefaultsPage		WLSDefaults      = new WatchListScreeningDefaultsPage(driver,test);
		SearchConsigneePage					Consignee		 = new SearchConsigneePage(driver,test);
		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
				test.log(LogStatus.INFO,TestCaseID);
				test.log(LogStatus.INFO, Testcase);
				homePage.moveTo_ListScreening();
				homePage.click_WatchListScreening();
		
								
				if(TestCaseID.equals("WLS_ADHOC_TC_027")) {
					homePage.moveTo_Tools();
					homePage.click_WLSDefaults();
					WLSDefaults.click_WorkFlowSetting();
					WLSDefaults.click_AutoAddtoDB();
					WLSDefaults.select_AddToDatabase("Consignee");
					WLSDefaults.select_Cases("Only Approved Entities");
					WLSDefaults.click_Save();
					Wait.waitfor(5);
					homePage.moveTo_Features();
					homePage.click_AdhocScreening();
					Adhoc.enter_Name(EntityName);
					Adhoc.click_Screen();
					Wait.waitfor(4);			
					AdhocResults.verify_NoMatchFoundmessage();
							
				}else if(TestCaseID.equals("WLS_ADHOC_TC_028")) {	
					homePage.moveTo_Features();
					homePage.click_AdhocScreening();
					Adhoc.enter_Name(EntityName);
					Adhoc.click_Screen();
					Wait.waitfor(4);			
					AdhocResults.click_AddToFile();
					AdhocResults.select_EntityFile("Consignee");
					Wait.waitfor(5);
					AdhocResults.click_AddRecordToDatabasSave();
					Wait.waitfor(20);
					AdhocResults.click_AddRecordToDatabaseWindowClose();
						
				}
					
				homePage.moveTo_Files();
				homePage.click_Consignee();
				Consignee.enter_ConsigneeName(EntityName);
				Consignee.click_CreatedFromDate();
				Consignee.select_CreatedFromDate("Today");
				Consignee.click_Search();
				Wait.waitfor(5);
				Consignee.click_Delete();
				driver.switchTo().alert().accept();
				Wait.waitfor(20);
				Consignee.verify_NoRecordsFoundmessage();
				
				if(TestCaseID.equals("WLS_ADHOC_TC_027")) {
					homePage.moveTo_Tools();
					homePage.click_WLSDefaults();
					WLSDefaults.click_WorkFlowSetting();
					WLSDefaults.click_AutoAddtoDB();
					WLSDefaults.click_Save();
					Wait.waitfor(5);						
				}	
										
				Wait.waitfor(3);
				//homePage.returnPage();	
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException s) {
			//s.printStackTrace();
			test.log(LogStatus.SKIP,"Please check the run mode");
			throw s;
		} catch (Exception e) {
			
			if(TestCaseID.equals("WLS_ADHOC_TC_027")) {
				homePage.moveTo_ListScreening();
				homePage.click_WatchListScreening();
				homePage.moveTo_Tools();
				homePage.click_WLSDefaults();
				WLSDefaults.click_WorkFlowSetting();
				WLSDefaults.click_AutoAddtoDB();
				WLSDefaults.click_Save();
				Wait.waitfor(5);
			}
			
			testFail();			
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}	
	
	
}
