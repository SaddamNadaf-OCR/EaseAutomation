package dpssScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dpssClasses.AdHocScreeningResultsPage;
import dpssClasses.AdhocScreeningPage;
import dpssClasses.HomePage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class EntityTypesAndECR extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("EntityTypesAndECR", excel);
	}

	@Test(dataProvider = "getData") 

	public void EntityTypesAndECRFunctionality(String TestCaseID,String Testcase,String RunMode,String EntityType,String EntityName,String EntityCountry) 
					throws Exception {


		// ******************************** Objects Creation *******************************************

		HomePage							homePage		 = new HomePage(driver, test);		
		AdhocScreeningPage					Adhoc            = new AdhocScreeningPage(driver,test);
		AdHocScreeningResultsPage			AdhocResults     = new AdHocScreeningResultsPage(driver,test);
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
				
				homePage.moveTo_Features();
				homePage.click_AdhocScreening();
				
				
				if(TestCaseID.equals("WLS_ADHOC_TC_025")) {
					
					
					ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);

					for(int i=0;i<4;i++) {
						
						Adhoc.click_ChooseSearchCriteria();
						Adhoc.select_EntityType(EType.get(i));
						
						
						Adhoc.enter_Name(EName.get(i));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(EName.get(i));
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						Adhoc.click_ChooseSearchCriteria();
						Adhoc.select_EntityType(EType.get(i));
						
						
						Adhoc.enter_Name(EName.get(i+1));
						Adhoc.click_Screen();
					
						Wait.waitfor(4);
						AdhocResults.verify_NoMatchFoundmessage();
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);		
						
					}
					
					Adhoc.enter_Name(EName.get(3));
					Adhoc.click_Screen();
					Wait.waitfor(4);
					AdhocResults.verify_NameFieldinTable(EName.get(3));
					AdhocResults.verify_PDFIcon();
					AdhocResults.verify_EmailIcon();
					AdhocResults.verify_PrintIcon();
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
																
				}else if(TestCaseID.equals("WLS_ADHOC_TC_026")) {
					
					Adhoc.enter_Name(EntityName);
					Adhoc.enter_Country(EntityCountry);
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NameFieldinTable("*ENTIRE COUNTRY*");
					AdhocResults.verify_CountryFieldinTable(EntityCountry);
					AdhocResults.verify_PDFIcon();
					AdhocResults.verify_EmailIcon();
					AdhocResults.verify_PrintIcon();
					AdhocResults.click_NewScreen();
					Wait.waitfor(4);
					
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
					
					Adhoc.enter_Name(EntityName);
					Adhoc.enter_Country(EntityCountry);
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();			
					
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
			testFail();			
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}	
	
	


}
