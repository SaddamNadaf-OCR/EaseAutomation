package dpssScripts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import utilities.excel_reader;

public class DJScreening extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DJScreening", excel);
	}

	@Test(dataProvider = "getData") 

	public void DJScreeningFunctionality(String TestCaseID,String Testcase,String RunMode,String EntityName,
			String Agency) 
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
				Wait.waitfor(2);
				
				String DPLUpdatedon = Adhoc.get_DPLUpdatedasof();
				
				String[] text =DPLUpdatedon.split(" : ");
				CompareDate(text[1]);
				
				ArrayList<String> EName = GenericMethods.stringtoken(EntityName);

					for(int i=0;i<3;i++) {
					
						Adhoc.enter_Name(EName.get(i));
						Adhoc.click_Screen();
						Wait.waitfor(5);
						AdhocResults.verify_NameFieldinTable(EName.get(i));
						AdhocResults.verify_AgencyFieldinTable(Agency);
						AdhocResults.verify_PDFIcon();
						AdhocResults.verify_EmailIcon();
						AdhocResults.verify_PrintIcon();
						AdhocResults.click_NewScreen();
						Wait.waitfor(3);
						
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
	
		public void CompareDate(String DPLDate) throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String SystemDate = formatter.format(date);  
			
			Date date1 = formatter.parse(DPLDate);  
			Date date2 = formatter.parse(SystemDate);  
			//prints dates  
			System.out.println("Date 1: " + formatter.parse(DPLDate));  
			System.out.println("Date 2: " + formatter.parse(SystemDate));  
			//comparing dates  
			
			long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			if (diff<2) {
				test.log(LogStatus.PASS,"DPL List updated successfully");	
			}else {
				test.log(LogStatus.FAIL,"DPL List not updated");
			}
			
		}
			
			
		
		
	
	
	
}
