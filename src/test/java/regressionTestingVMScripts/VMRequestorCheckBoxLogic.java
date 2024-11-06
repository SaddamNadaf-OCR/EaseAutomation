package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import initializer.SeleniumTestBase;

public class VMRequestorCheckBoxLogic extends SeleniumTestBase {	
	@Test
	public void RequestorLogic() throws Exception {
		
		HomePage					homePage		 = new HomePage(driver, test); 
		SearchVisitorRequestPage	searchVR		 = new SearchVisitorRequestPage(driver, test);				
		CreateNewVisitorRequestPage create           = new CreateNewVisitorRequestPage(driver,test);
		VisitDetailsPage            detail           = new VisitDetailsPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu(propVMs.getProperty("SelectSBU"));
				create.select_HostSbu(propVMs.getProperty("HostSBU"));
				create.select_MeetingLocationSBU(propVMs.getProperty("MeetingLocationSBU"));
				create.select_VisitDateFrom(propVMs.getProperty("VisitDateFrom"));
				create.select_VisitDateTo(propVMs.getProperty("VisitDateTo"));
				//create.select_RequestorName(propVMs.getProperty("RequestorFirstName"));
				create.type_Email(propVMs.getProperty("RequestorEmail"));
				create.type_Phone(propVMs.getProperty("RequestorPhone"));
				create.check_LocalHost("Y");
				create.check_PrimaryHost("Y");
				create.click_Create();
				detail.enable_AllDayAcess();
				detail.click_AddHost();
				Wait.waitfor(3);
				detail.Displayed_Requestor();
				detail.add_PrimaryHost(propVMs.getProperty("HostName"),propVMs.getProperty("HostEmail"),propVMs.getProperty("HostPhone"));
				//detail.click_AddHostCancel();
				detail.Enabled_HostDeleteIcon();
				Wait.waitfor(3);
	}
		}
		catch (SkipException s) {
			s.printStackTrace();
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

	

