package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;

public class RapidReqCreationExcelUpload extends SeleniumTestBase {

	@Test(dataProvider = "getData")

	public void rapidReqCreationExcelUpload(String Testcase, String RunMode, String SBU, String FromDate, String ToDate, String Site,
			String BuildingName, String HostName, String EmailAddress, String HostPhone, String VisitHost) throws Exception {

		// ************* Objects Creation ******************************

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

		// ****************Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Features();
					searchVR.click_VisitorRequests();
					searchVR.click_RapidRegistaration();
					rapid.click_AddNewVisitorRequest();
			
					visitorInfo.select_Site(Site);
					visitorInfo.type_BuildingName(BuildingName);
					if (HostName.length() > 0) {
						visitorInfo.click_AddHost();
						visitorInfo.type_HostName(HostName);
						visitorInfo.type_HostEmail(EmailAddress);
						visitorInfo.type_HostPhNo(HostPhone);
						visitorInfo.click_HostAdd();
					} else {
						visitorInfo.Select_HostAdd(VisitHost);
					}
					visitorInfo.get_RequestStatus();
					visitorInfo.get_RequestID();
					String vid = visitorInfo.get_RequestID();
					Wait.waitfor(3);
					visitorInfo.addfromexcel();
					Wait.waitfor(3);
				
				   String RS=visitorInfo.get_RequestStatusAfterAddingVisitor();
					Wait.waitfor(4);					
					if(RS.equalsIgnoreCase("WLS On Hold")) {
							visitorInfo.checkNotifyWLSReview();	
							visitorInfo.click_DplStatus();
							visitorInfo.changeStatus();
							Wait.waitfor(4);
							
					} 
					String RS1=visitorInfo.get_RequestStatusAfterAddingVisitor();
					
					if(RS1.equalsIgnoreCase("FV On Hold")) {
							visitorInfo.checkNotifyFVReview();
							Wait.waitfor(2);
							visitorInfo.changeStatus();
					} 					
					visitorInfo.get_RequestStatusFinal();
					Wait.waitfor(2);					
					visitorInfo.validate_VisitorName();
					Wait.waitfor(2);
					searchVR.moveTo_Features();
					Wait.waitfor(2);
					searchVR.click_VisitorFrontDesk();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckIN();
					visitorFD.click_AdvSearchBtn();
					visitorFD.searchVReqID(vid);
					visitorFD.clickSearch();
					visitorFD.clickCheckOut();
					Wait.waitfor(4);
					homePage.returnPage();
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			Wait.waitfor(3);
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("rapidReqExcelUpload", excel);
	}


}
