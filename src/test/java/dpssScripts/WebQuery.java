package dpssScripts;



import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import dpssClasses.HomePage;
import dpssClasses.LoginPage;
import dpssClasses.SearchConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WebQuery extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("WebQuery", excel);
	}

	@Test(dataProvider = "getData") 

	public void WebQueryFunctionality(String TestCaseID,String Testcase,String RunMode,String WebQuery,String WebQuery2, 
			String EntityID,String EntityName,String Status,String EntityAddress) 
					throws Exception {


		// ******************************** Objects Creation *******************************************

		HomePage							homePage		 = new HomePage(driver, test);		
		LoginPage 							login            = new LoginPage(driver, test);
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
				
				homePage.load_webquery(WebQuery);
				login.login("kottcorpadmin","QTPPassword!");
				Wait.waitfor(3);
				homePage.moveTo_ListScreening();
				homePage.click_WatchListScreening();
				
				homePage.moveTo_Files();
				homePage.click_Consignee();
				Consignee.enter_ConsigneeID(EntityID);
				
				Consignee.click_Search();
				Wait.waitfor(5);
				
				if(TestCaseID.equals("WLS_WEBQRY_TC_040")) {
					Consignee.verify_NoRecordsFoundmessage();
					
					homePage.load_webquery(WebQuery2);
					login.login("kottcorpadmin", "QTPPassword!");
					Wait.waitfor(3);
					homePage.moveTo_ListScreening();
					homePage.click_WatchListScreening();
					homePage.moveTo_Files();
					homePage.click_Consignee();
					Consignee.enter_ConsigneeID(EntityID);					
					Consignee.click_Search();
					Wait.waitfor(5);
					}
				else if(TestCaseID.equals("WLS_WEBQRY_TC_041")){
					Consignee.verify_IDFieldinTable(EntityID);
					Consignee.click_Delete();
					driver.switchTo().alert().accept();
					Wait.waitfor(8);
					Consignee.verify_NoRecordsFoundmessage();
					
					homePage.load_webquery(WebQuery2);
					login.login("kottcorpadmin", "QTPPassword!");
					Wait.waitfor(3);
					homePage.moveTo_ListScreening();
					homePage.click_WatchListScreening();
					homePage.moveTo_Files();
					homePage.click_Consignee();
					Consignee.enter_ConsigneeID(EntityID);					
					Consignee.click_Search();
					Wait.waitfor(5);
					
				}
				
												
				if(TestCaseID.equals("WLS_WEBQRY_TC_038")||TestCaseID.equals("WLS_WEBQRY_TC_040")||TestCaseID.equals("WLS_WEBQRY_TC_041")) {
					Consignee.verify_IDFieldinTable(EntityID);
					Consignee.verify_NameFieldinTable(EntityName);
					Consignee.verify_AddressFieldinTable(EntityAddress);
					Consignee.verify_StatusFieldinTable(Status);
					Consignee.click_Delete();
					driver.switchTo().alert().accept();
					Wait.waitfor(8);
				}
				
				Consignee.verify_NoRecordsFoundmessage();
										
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
			testFail();			
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}

		
	}	
	

}
