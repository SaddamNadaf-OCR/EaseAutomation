package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CreateNewCloseOutPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizationCloseOutPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewCloseOut extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("NewCloseOutReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void createNewCloseOut(String TestCases,String RunMode, String SBU, String closeOutid, String authorizationNo, 
			String transactionId, String expirydate, String CloseOutdate) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationCloseOutPage searchCloseOut=new SearchAuthorizationCloseOutPage(driver, test);
		CreateNewCloseOutPage create=new CreateNewCloseOutPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping The Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_on_AutorizationCloseOut();
					searchCloseOut.addCloseOut();
					create.newCloseOut(closeOutid, authorizationNo, transactionId, expirydate, CloseOutdate);
					create.saveandreturn();
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
