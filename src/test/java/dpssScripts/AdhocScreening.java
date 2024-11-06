package dpssScripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dpssClasses.AdHocScreeningResultsPage;
import dpssClasses.AdhocScreeningPage;
import dpssClasses.HomePage;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class AdhocScreening extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AdhocScreening", excel);
	}

	@Test(dataProvider = "getData") 

	public void AdhocScreeningWithEntitySearchTypes(String TestCaseID,String Testcase,String RunMode,String EntitySearchType,
			String EntitySearchMethod,String EntityType,String EntityName,String EntityCountry,
			String EntityAddress) 
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
				
				
				if (TestCaseID.equals("WLS_ADHOC_TC_001")||TestCaseID.equals("WLS_ADHOC_TC_002")||
						TestCaseID.equals("WLS_ADHOC_TC_003")||TestCaseID.equals("WLS_ADHOC_TC_004")) {
//-----------------------------------------Name Only -----------------------------------------------------//		
					ArrayList<String> SearchMethod = GenericMethods.stringtoken(EntitySearchMethod);
					ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EType.get(0));
					Adhoc.enter_Name(EName.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(4);
					
					AdhocResults.verify_MatchFoundmessage();
					AdhocResults.verify_NameFieldinTable(EName.get(0));
					AdhocResults.verify_PDFIcon();
					AdhocResults.verify_EmailIcon();
					AdhocResults.verify_PrintIcon();
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EType.get(1));
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();
					AdhocResults.verify_PDFIcon();
					AdhocResults.verify_EmailIcon();
					AdhocResults.verify_PrintIcon();
					
//--------------------------------------------Name Only -----------------------------------------------------//		
									
				}else if(TestCaseID.equals("WLS_ADHOC_TC_005")||TestCaseID.equals("WLS_ADHOC_TC_006")||
						TestCaseID.equals("WLS_ADHOC_TC_007")||TestCaseID.equals("WLS_ADHOC_TC_008")) {
//------------------------------------------Name OR Country ----------------------------------------------//
					
					ArrayList<String> SearchMethod = GenericMethods.stringtoken(EntitySearchMethod);
					ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> ECountry = GenericMethods.stringtoken(EntityCountry);
					
			//-------------------Only Name having hit-------------------------------//		
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EType.get(0));
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.click_Screen();
					
					Wait.waitfor(4);
					
					AdhocResults.verify_MatchFoundmessage();
					AdhocResults.verify_NameFieldinTable(EName.get(0));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
			
			//-------------------Only Country having hit-------------------------------//			
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EType.get(1));
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Country(ECountry.get(1));
					Adhoc.click_Screen();
					
					Wait.waitfor(5);
					AdhocResults.verify_CountryFieldinTable(ECountry.get(1));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					

				//-------------------Both Name and Country having hit-------------------------------//			
							
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EType.get(2));
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
					
					Adhoc.enter_Name(EName.get(2));
					Adhoc.enter_Country(ECountry.get(2));
					Adhoc.click_Screen();
					
					Wait.waitfor(7);
					AdhocResults.verify_NameFieldinTable(EName.get(2));
					AdhocResults.verify_CountryFieldinTable(ECountry.get(2));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
			//-------------------Both Name and Country doesn't have hit-------------------------------//			
										
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EType.get(3));
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.click_Screen();
					
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();
					
//------------------------------------------Name OR Country ----------------------------------------------//
									
					
				}else if(TestCaseID.equals("WLS_ADHOC_TC_009")||TestCaseID.equals("WLS_ADHOC_TC_010")||
						TestCaseID.equals("WLS_ADHOC_TC_011")||TestCaseID.equals("WLS_ADHOC_TC_012")) {
   //-------------------------------------Name AND Country ----------------------------------------------//
					
										
					ArrayList<String> SearchMethod = GenericMethods.stringtoken(EntitySearchMethod);
					//ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> ECountry = GenericMethods.stringtoken(EntityCountry);
					

			//-------------------Both Name and Country having hit-------------------------------//			
							
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
					
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NameFieldinTable(EName.get(0));
					AdhocResults.verify_CountryFieldinTable(ECountry.get(0));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
			//------------------- Either Name or Country doesn't have hit-------------------------------//			
										
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
					
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Country(ECountry.get(1));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();
					
				}
	 //-------------------------------------Name AND Country ----------------------------------------------//
								
				
				else if(TestCaseID.equals("WLS_ADHOC_TC_013")||TestCaseID.equals("WLS_ADHOC_TC_014")||
						TestCaseID.equals("WLS_ADHOC_TC_015")||TestCaseID.equals("WLS_ADHOC_TC_016")) {

	//-------------------------------------Name OR Address ----------------------------------------------//
									
					ArrayList<String> SearchMethod = GenericMethods.stringtoken(EntitySearchMethod);
					//ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> EAddress = GenericMethods.stringtoken(EntityAddress);
					
			//-------------------Only Name having hit-------------------------------//		
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Address(EAddress.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(5);
					
					AdhocResults.verify_MatchFoundmessage();
					AdhocResults.verify_NameFieldinTable(EName.get(0));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
			
			//-------------------Only Address having hit-------------------------------//			
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Address(EAddress.get(1));
					Adhoc.click_Screen();
					Wait.waitfor(4);
					AdhocResults.verify_NameFieldinTable(EAddress.get(1));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					

				//-------------------Both Name and Address having hit-------------------------------//			
							
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(2));
					Adhoc.enter_Address(EAddress.get(2));
					Adhoc.click_Screen();
					Wait.waitfor(4);
					AdhocResults.verify_NameFieldinTable(EName.get(2));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
			//-------------------Both Name and Address doesn't have hit-------------------------------//			
										
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Address(EAddress.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(3);
					AdhocResults.verify_NoMatchFoundmessage();
					
				}
				
	//-------------------------------------Name OR Address ----------------------------------------------//
								
				else if(TestCaseID.equals("WLS_ADHOC_TC_017")||TestCaseID.equals("WLS_ADHOC_TC_018")||
						TestCaseID.equals("WLS_ADHOC_TC_019")||TestCaseID.equals("WLS_ADHOC_TC_020")) {
	//-------------------------------------Name AND Address ----------------------------------------------//
					
					
					ArrayList<String> SearchMethod = GenericMethods.stringtoken(EntitySearchMethod);
					//ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> EAddress = GenericMethods.stringtoken(EntityAddress);
					

			//-------------------Both Name and Address having hit-------------------------------//			
							
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Address(EAddress.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(2);

					if(SearchMethod.get(1).equals("Medium")||SearchMethod.get(1).equals("Wide")) {
						AdhocResults.verify_NameFieldinTable(EAddress.get(0));
					}else
					{
						AdhocResults.verify_NameFieldinTable(EName.get(0));
					}
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
			//-------------------Either Name and Address doesn't have hit-------------------------------//			
										
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Address(EAddress.get(1));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Address(EAddress.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					if(!SearchMethod.get(1).equals("")) {
						AdhocResults.verify_NoMatchFoundmessage();
					}else {
						AdhocResults.verify_MatchFoundmessage();
					}
					
					
				}
				
	//-------------------------------------Name AND Address ----------------------------------------------//
								
				
				else if(TestCaseID.equals("WLS_ADHOC_TC_021")||TestCaseID.equals("WLS_ADHOC_TC_022")||
						TestCaseID.equals("WLS_ADHOC_TC_023")||TestCaseID.equals("WLS_ADHOC_TC_024")) {
   //-------------------------------------(Name OR Address) AND Country ----------------------------------//
					
					ArrayList<String> SearchMethod = GenericMethods.stringtoken(EntitySearchMethod);
					//ArrayList<String> EType = GenericMethods.stringtoken(EntityType);
					ArrayList<String> EName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> EAddress = GenericMethods.stringtoken(EntityAddress);
					ArrayList<String> ECountry = GenericMethods.stringtoken(EntityCountry);

			//-------------------Both Name and Country combination having hit-------------------------------//			
							
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NameFieldinTable(EName.get(0));
					AdhocResults.verify_CountryFieldinTable(ECountry.get(0));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);

			//------------------- Name without Hits Address and Country combination having hits-------------------------------//			
									
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
							
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.enter_Address(EAddress.get(0));
					Adhoc.click_Screen();
					
					Wait.waitfor(2);
					AdhocResults.verify_NameFieldinTable(EAddress.get(0));
					AdhocResults.verify_CountryFieldinTable(ECountry.get(0));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);
					
			//------------------- Name,Address and Country combination having hits-------------------------------//			
					
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
							
					Adhoc.enter_Name(EName.get(0));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.enter_Address(EAddress.get(0));
					Adhoc.click_Screen();
					
					Wait.waitfor(3);
					AdhocResults.verify_NameFieldinTable(EName.get(0));
					AdhocResults.verify_CountryFieldinTable(ECountry.get(0));
					AdhocResults.click_NewScreen();
					Wait.waitfor(3);					
					
					
			//-------------------Both Name and Address doesn't have hit(Only country having hit)-------------------------------//			
										
					ConfigWLS( EntitySearchType,SearchMethod.get(0),SearchMethod.get(1),EntityType);
					Adhoc.click_ChooseSearchCriteria();
					Adhoc.click_EntireCountryRestrictionCheckox();
					Adhoc.enter_Name(EName.get(1));
					Adhoc.enter_Address(EAddress.get(1));
					Adhoc.enter_Country(ECountry.get(0));
					Adhoc.click_Screen();
					Wait.waitfor(2);
					AdhocResults.verify_NoMatchFoundmessage();
					
				}
				
	//-------------------------------------(Name OR Address) AND Country ----------------------------------//
																
						
				
				
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
	
	
	
	
	
	public void ConfigWLS(String SearchType,String SearchMethod,String UseSearch, String PartyType) throws InterruptedException {
		
		AdhocScreeningPage					Adhoc            = new AdhocScreeningPage(driver,test);
		
		
		Adhoc.click_ChooseSearchCriteria();
		
		Adhoc.select_EntitySearchType(SearchType);
		Adhoc.select_SearchMethod(SearchMethod);
		if(SearchMethod.equals("Fuzzy")) {
		Adhoc.select_UseSearch(UseSearch);
		}
		if(!PartyType.equals("")) {
			Adhoc.select_EntityType(PartyType);
			}
		
		
		Adhoc.click_ChooseSearchCriteria();
		
		
		
	}

}
