/* 
 * Module : VMs
 * Author  : Venkat
 * created date : MAR 2020
 * * Descriptions : Creating Kiosk reception and Warehouse Request email phone number generation
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */
package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorRequestNotesPage;
import vmsClasses.VisitorsPage;


public class QuestionnaireCancelWrongScreen extends SeleniumTestBase {

	@Test
	public void validateFieldName() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitDetailsPage            detail           = new VisitDetailsPage(driver,test);
		VisitorsPage                visitors         = new VisitorsPage(driver, test);
		VisitorRequestNotesPage		notes            = new VisitorRequestNotesPage(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				Wait.waitfor(3);
				//searchVR.select_VisitorSbu(propVMs.getProperty("SelectSBU"));
				searchVR.select_VisitorSBUStatus(propVMs.getProperty("VisitorSBU"), propVMs.getProperty("VisitorStatus"));
				detail.forwardToVisitors();
				visitors.select_VisitorNameLink();
				visitors.click_Back();
				detail.forwardToNotes();
				notes.Enable_AddNotes();
				detail.forwardToQuestionnaire();
				//visitors.movetonextpage();
				visitors.click_QuestionnaireCancel();
				Wait.waitfor(3);
				searchVR.VisitorRequestHeader();
			}
		} catch (SkipException s) {
			//s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();			
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}	
}