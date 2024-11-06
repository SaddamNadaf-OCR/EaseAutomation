package dpssScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dpssClasses.HomePage;
import dpssClasses.LoginPage;
import dpssClasses.SearchConsigneePage;
import dpssClasses.UploadFile;
import initializer.SeleniumTestBase;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class FileUpload extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FileUpload", excel);
	}

	@Test(dataProvider = "getData") 

	public void FileUploadFunctionality(String TestCaseID,String Testcase,String RunMode,String FileName,
			String EntityID,String EntityName,String Status,String Checklist) 
					throws Exception {


		// ******************************** Objects Creation *******************************************

		HomePage							homePage		 = new HomePage(driver, test);		
		SearchConsigneePage					Consignee		 = new SearchConsigneePage(driver,test);
		UploadFile					       	uploadfile		 = new UploadFile(driver,test);
		
		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("Y")) {
				test.log(LogStatus.INFO,TestCaseID);
				test.log(LogStatus.INFO, Testcase);
				
				homePage.moveTo_ListScreening();
				homePage.click_WatchListScreening();
				homePage.moveTo_Features();
				homePage.click_UploadFiles();
				uploadfile.click_UploadFile();
				uploadfile.click_AddFile();
				uploadfile.Upload_File(FileName);
				Wait.waitfor(2);
				uploadfile.click_Submit();
				Wait.waitfor(3);
				uploadfile.click_Save();
				Wait.waitfor(3);
				homePage.moveTo_Features();
				homePage.click_UploadFiles();
				uploadfile.enter_FileName(FileName);
				uploadfile.click_Search();
				Wait.waitfor(4);
				uploadfile.verify_StatusFieldinTable("Screened");
				
				ArrayList<String> ConsigneeID = GenericMethods.stringtoken(EntityID);
				
				homePage.moveTo_Files();
				homePage.click_Consignee();
				Consignee.enter_ConsigneeID(ConsigneeID.get(0));
				
				Consignee.click_Search();
				Wait.waitfor(5);	
				
				Consignee.verify_NameFieldinTable(EntityName);
				//Consignee.verify_StatusFieldinTable(Status);
				Consignee.click_Delete();
				driver.switchTo().alert().accept();
				Wait.waitfor(10);
				Consignee.verify_NoRecordsFoundmessage();
				Consignee.click_NewSearch();
				Consignee.enter_ConsigneeID(ConsigneeID.get(1));
				
				Consignee.click_Search();
				Wait.waitfor(5);
				Consignee.click_ConsigneeIDLink();
				Consignee.verify_AddressField(Checklist);
				Consignee.enter_ConsigneeAddress("For Selenium Test");
				Consignee.click_SaveAndReturn();
				Wait.waitfor(6);
				
		
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