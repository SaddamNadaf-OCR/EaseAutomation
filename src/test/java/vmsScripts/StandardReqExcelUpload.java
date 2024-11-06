/* 
 * Module : VMS
 * Author  : Nancy
 * created date : May 2019
 * Descriptions : Uploading from Excel
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.CreateNewVisitorRequestPage;
import vmsClasses.HomePage;
import vmsClasses.QuestionnairrePage;
import vmsClasses.ReviewerPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitDetailsPage;
import vmsClasses.VisitorFrontDeskResultsPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorSubmissionPage;
import vmsClasses.VisitorsPage;

public class StandardReqExcelUpload extends SeleniumTestBase {

	@Test
	public void standardreqexcelupload() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitDetailsPage detail = new VisitDetailsPage(driver, test);
		VisitorsPage visitors = new VisitorsPage(driver, test);
		QuestionnairrePage questionnairre = new QuestionnairrePage(driver, test);
		VisitorSubmissionPage submit = new VisitorSubmissionPage(driver, test);
		ReviewerPage reviewer = new ReviewerPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		VisitorFrontDeskResultsPage visitorFD = new VisitorFrontDeskResultsPage(driver, test);

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
				create.type_Phone("655656546");
				create.check_LocalHost(propVMs.getProperty("LocalHost"));
				create.check_PrimaryHost(propVMs.getProperty("PrimaryHost"));
				create.click_Create();
				detail.enable_AllDayAcess();
				String vid = visitorInfo.get_RequestID();
				detail.select_247();
				detail.select_WeekendAccess();
				Wait.waitfor(3);
				detail.add_Site(propVMs.getProperty("Site"), propVMs.getProperty("BuildingName"),
						propVMs.getProperty("EntranceLobby"), propVMs.getProperty("RoomNoDescription"));
				detail.select_classificationlevel(propVMs.getProperty("ClassificationLevel"));
				detail.select_visitpurpose(propVMs.getProperty("VisitPurpose"));
				detail.select_descriptionofvisit(propVMs.getProperty("DescriptionOfVisit"));
				detail.select_meetingcategories(propVMs.getProperty("MeetingCategories"));
				/*detail.select_program(propVMs.getProperty("Program"));
				detail.select_segment(propVMs.getProperty("Segment"));
				detail.select_productfamily(propVMs.getProperty("ProductFamily"));
				detail.select_productline(propVMs.getProperty("ProductLine"));*/
				detail.select_chargenumber(propVMs.getProperty("ChargeNumber"));
				detail.select_onloandepartment(propVMs.getProperty("OnLoanDepartment"));
				visitors.addfromexcel();
				visitors.click_DplStatus();
				visitors.movetonextpage();
				questionnairre.noexportcontrolauthorityreq();
				questionnairre.click_saveBtn();
				Wait.waitfor(6);
				detail.forwardToSubmit();
				submit.add_SecurityReviewer(propVMs.getProperty("SecurityUserFirstName"));
				submit.save();
				Wait.waitfor(3);
				submit.submitforreview();
				reviewer.click_SelectAllBtn();
				reviewer.click_ApproveBtn();
				reviewer.overDecision(propVMs.getProperty("OverallDecision"),
						propVMs.getProperty("ReasonForDisapprovalOrRoR"));
				Wait.waitfor(3);
				searchVR.moveTo_Features();
				searchVR.click_VisitorFrontDesk();
				visitorFD.click_AdvSearchBtn();
				visitorFD.searchVReqID(vid);
				visitorFD.clickSearch();
				visitorFD.clickCheckIN();
				visitorFD.click_AdvSearchBtn();
				visitorFD.searchVReqID(vid);
				visitorFD.clickSearch();
				visitorFD.clickCheckOut();
				Wait.waitfor(3);
				homePage.returnPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
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
