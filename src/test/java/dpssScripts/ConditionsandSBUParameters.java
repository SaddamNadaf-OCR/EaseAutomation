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
import dpssClasses.SBUConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class ConditionsandSBUParameters extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ConditionsandSBUParameters", excel);
	}

	@Test(dataProvider = "getData") 

	public void ConditionsandSBUParametersCheck(String TestCaseID,String Testcase,String RunMode,String UseSearch,
			String EntityName,String SBUValue,String Checklist) 
					throws Exception {


		// ******************************** Objects Creation *******************************************

		HomePage							homePage		 = new HomePage(driver, test);		
		AdhocScreeningPage					Adhoc            = new AdhocScreeningPage(driver,test);
		AdHocScreeningResultsPage			AdhocResults     = new AdHocScreeningResultsPage(driver,test);
		SBUConfigurationPage				SBUConfig		 = new SBUConfigurationPage(driver,test);
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
				
				
				
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> USearch = GenericMethods.stringtoken(UseSearch);

					if(TestCaseID.equals("WLS_ADHOC_TC_030")) {
						homePage.moveTo_Features();
						homePage.click_AdhocScreening();
						Adhoc.click_ChooseSearchCriteria();
						Adhoc.select_UseSearch(USearch.get(0));	
						Adhoc.enter_Name(EName.get(0));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NoMatchFoundmessage();
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						Adhoc.click_ChooseSearchCriteria();
						Adhoc.select_UseSearch(USearch.get(1));	
						Adhoc.enter_Name(EName.get(0));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(Checklist);
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						Adhoc.click_ChooseSearchCriteria();
						Adhoc.select_UseSearch(USearch.get(1));	
						Adhoc.enter_Name(EName.get(1));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NoMatchFoundmessage();
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						Adhoc.click_ChooseSearchCriteria();
						Adhoc.select_UseSearch(USearch.get(2));	
						Adhoc.enter_Name(EName.get(1));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(Checklist);
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
					}else if(TestCaseID.equals("WLS_ADHOC_TC_031")||TestCaseID.equals("WLS_ADHOC_TC_032")) {
						homePage.moveTo_Tools();
						homePage.click_SBUConfig();
						SBUConfig.select_Module("Watch List Screening");
						SBUConfig.click_Search();
						SBUConfig.click_INCREMENT();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue(SBUValue);
						SBUConfig.click_Save();
						
						homePage.moveTo_Features();
						homePage.click_AdhocScreening();	
						Adhoc.enter_Name(EName.get(0));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(EName.get(0));
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						Adhoc.enter_Name(EName.get(1));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(EName.get(0));
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
							
						Adhoc.enter_Name(EName.get(2));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NoMatchFoundmessage();
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						Adhoc.enter_Name(EName.get(3));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(EName.get(0));
						
						
						homePage.moveTo_Tools();
						homePage.click_SBUConfig();
						SBUConfig.select_Module("Watch List Screening");
						SBUConfig.click_Search();
						SBUConfig.click_INCREMENT();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue("");
						SBUConfig.click_Save();
						Wait.waitfor(2);
						
						
					}else if(TestCaseID.equals("WLS_ADHOC_TC_033")) {
						ArrayList<String> Check = GenericMethods.stringtoken(Checklist);
						ArrayList<String> Value = GenericMethods.stringtoken(SBUValue);
						
						homePage.moveTo_Tools();
						homePage.click_SBUConfig();
						SBUConfig.select_Module("Watch List Screening");
						SBUConfig.click_Search();
						SBUConfig.click_SYMMETRIC();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue(Value.get(0));
						SBUConfig.click_SaveAndReturn();
						Wait.waitfor(1);
						SBUConfig.click_EXTRA_WORD_DEDUCTION();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue(Value.get(1));
						SBUConfig.click_Save();
						
						
						homePage.moveTo_Features();
						homePage.click_AdhocScreening();
						Adhoc.enter_Name(EntityName);
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(Check.get(0));
						AdhocResults.verify_ScoreFieldinTable(Check.get(1));
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
						homePage.moveTo_Tools();
						homePage.click_SBUConfig();
						SBUConfig.select_Module("Watch List Screening");
						SBUConfig.click_Search();
						SBUConfig.click_SYMMETRIC();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue("");
						SBUConfig.click_SaveAndReturn();
						Wait.waitfor(1);
						SBUConfig.click_EXTRA_WORD_DEDUCTION();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue("");
						SBUConfig.click_Save();			
						
					}else if(TestCaseID.equals("WLS_ADHOC_TC_034")||TestCaseID.equals("WLS_ADHOC_TC_035")) {

						ArrayList<String> Check = GenericMethods.stringtoken(Checklist);
						ArrayList<String> Value = GenericMethods.stringtoken(SBUValue);
						
						homePage.moveTo_Tools();
						homePage.click_SBUConfig();
						SBUConfig.select_Module("Watch List Screening");
						SBUConfig.click_Search();
						SBUConfig.click_SYMMETRIC();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue(Value.get(0));
						SBUConfig.click_SaveAndReturn();
						Wait.waitfor(1);
						SBUConfig.click_BASE_DEDUCTION();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue(Value.get(1));
						SBUConfig.click_SaveAndReturn();
						Wait.waitfor(1);
						
						if(Value.get(0).equals("N"))
						{
							SBUConfig.click_EXTRA_WORD_DEDUCTION();
							Wait.waitfor(3);
							SBUConfig.enter_SBUValue(Value.get(3));
							SBUConfig.click_SaveAndReturn();
							Wait.waitfor(1);
						}
						
						SBUConfig.click_WORD_DROP_FACTOR();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue(Value.get(2));
						SBUConfig.click_Save();
						
						
						homePage.moveTo_Features();
						homePage.click_AdhocScreening();
						Adhoc.enter_Name(EName.get(0));
						Adhoc.click_Screen();
						Wait.waitfor(4);
						AdhocResults.verify_NameFieldinTable(Check.get(0));
						AdhocResults.verify_ScoreFieldinTable(Check.get(1));
						
						
						if(Value.get(0).equals("N"))
						{
							AdhocResults.click_NewScreen();
							Wait.waitfor(2);
							Adhoc.enter_Name(EName.get(1));
							Adhoc.click_Screen();
							Wait.waitfor(4);
							AdhocResults.verify_NameFieldinTable(Check.get(0));
							AdhocResults.verify_ScoreFieldinTable(Check.get(2));
							
						}
						
						
						homePage.moveTo_Tools();
						homePage.click_SBUConfig();
						SBUConfig.select_Module("Watch List Screening");
						SBUConfig.click_Search();
						SBUConfig.click_SYMMETRIC();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue("");
						SBUConfig.click_SaveAndReturn();
						Wait.waitfor(1);
						SBUConfig.click_BASE_DEDUCTION();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue("");
						SBUConfig.click_SaveAndReturn();
						Wait.waitfor(1);

						if(Value.get(0).equals("N"))
						{
							SBUConfig.click_EXTRA_WORD_DEDUCTION();
							Wait.waitfor(3);
							SBUConfig.enter_SBUValue("");
							SBUConfig.click_SaveAndReturn();
							Wait.waitfor(1);
						}
						
						SBUConfig.click_WORD_DROP_FACTOR();
						Wait.waitfor(3);
						SBUConfig.enter_SBUValue("");
						SBUConfig.click_Save();			
						
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
			
				homePage.moveTo_Tools();
				homePage.click_SBUConfig();
				SBUConfig.select_Module("Watch List Screening");
				SBUConfig.click_Search();
				SBUConfig.click_INCREMENT();
				Wait.waitfor(3);
				SBUConfig.enter_SBUValue("");
				SBUConfig.click_SaveAndReturn();
				Wait.waitfor(1);
				
				SBUConfig.click_SYMMETRIC();
				Wait.waitfor(3);
				SBUConfig.enter_SBUValue("");
				SBUConfig.click_SaveAndReturn();
				Wait.waitfor(1);
				
				SBUConfig.click_BASE_DEDUCTION();
				Wait.waitfor(3);
				SBUConfig.enter_SBUValue("");
				SBUConfig.click_SaveAndReturn();
				Wait.waitfor(1);
				
				SBUConfig.click_EXTRA_WORD_DEDUCTION();
				Wait.waitfor(3);
				SBUConfig.enter_SBUValue("");
				SBUConfig.click_SaveAndReturn();
				Wait.waitfor(1);
				
				SBUConfig.click_WORD_DROP_FACTOR();
				Wait.waitfor(3);
				SBUConfig.enter_SBUValue("");
				SBUConfig.click_Save();	
				
			testFail();			
			e.printStackTrace();
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}		
	
	
}
