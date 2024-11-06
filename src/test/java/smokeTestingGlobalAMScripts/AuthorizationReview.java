package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.AuthorizationReviewPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorizationReviewPage;
import authorizationManagementClasses.SelectAuthorizationNumberPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AuthorizationReview extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AuthorizationReviewScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void authorizationReview(String TestCases,String RunMode, String SBU, String transactionId,
			String InternalStatus, String Internaldate, String ApprovarName, String TelecomNo, String Email, 
			String dateProvided, String CurrentAuthOwner, String CurrentAuthPOC, String CPOwner, String NotificationSubject, 
			String NotificationText, String AddUser, String Role, String UserEmail, String Submitdate, 
			String ContractSubmitdate, String ProvisoNotes) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchAuthorizationReviewPage searchPage=new SearchAuthorizationReviewPage(driver, test);
		SelectAuthorizationNumberPage numberPage=new SelectAuthorizationNumberPage(driver, test);
		AuthorizationReviewPage review = new AuthorizationReviewPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					Wait.waitfor(3);
					homePage.move_to_moduleSelection(SBU);
					Wait.waitfor(3);
					homePage.moduleSelection();
					Wait.waitfor(3);
					homePage.click_on_AutorizationReview();
					Wait.waitfor(3);
					searchPage.addAuthorizationReview();
					Wait.waitfor(3);
					numberPage.authorizationNo(transactionId);
					review.authorizationDetails(InternalStatus, Internaldate, ApprovarName, TelecomNo,
							Email, dateProvided, CurrentAuthOwner, CurrentAuthPOC, CPOwner);
					review.save();
					review.notification(NotificationSubject, NotificationText, AddUser, Role, UserEmail);
					review.save();
					review.provisos(Submitdate, ContractSubmitdate, ProvisoNotes);
					review.save();
					review.saveandreturn();
					homePage.logOut();
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
