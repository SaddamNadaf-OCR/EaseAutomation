package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateNewTIBPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchTIBPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class TIBAddPage extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("TIBAddPageScript", excel);
	}
	
	@Test(dataProvider="getData")
	public void addTIB(String TestCases,String RunMode, String SBU, String tibNumber,String LiqDamage, String issuedate,
			String extensionDate, String exiryDate, String penalityAmount, String mitigationAmount, 
			String cancelDetails, String notificationTo, String contactName, String contactPhone) {
		
		HomePage_AMPage homePageAM=new HomePage_AMPage(driver, test);
		SearchTIBPage tib=new SearchTIBPage(driver,test);
		CreateNewTIBPage create=new CreateNewTIBPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePageAM.move_to_moduleSelection(SBU);
					homePageAM.moduleSelection();
					homePageAM.click_on_TIB();
					tib.addTIB();
					create.newTIB(tibNumber, LiqDamage, issuedate, extensionDate, exiryDate, penalityAmount, 
							mitigationAmount, cancelDetails, notificationTo, contactName, contactPhone);
					create.saveAndreturn();
					homePageAM.logOut();
					
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
