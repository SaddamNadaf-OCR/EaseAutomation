package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

import vmsClasses.AddVTemplatePage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;

public class AddVisitorTemplate extends SeleniumTestBase {



	@Test(dataProvider = "getData")
	public void repidRegtn(String Testcase, String RunMode, String SBU, String TemplateName, String TemplateRequestd , String HostSBU,
			String MeetinglocationSBU, String StartDate, String EndDate, String StartTime, String EndTime, String RequestDate, String Site,
			String BuildingName, String ClassificationLevel, String VisitPurpose) throws Exception {
		
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		AddVTemplatePage AddVRT =new AddVTemplatePage(driver, test);

		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Files();
					AddVRT.select_VisitorRequestTemplate();
					AddVRT.Click_AddTemplate();
					Wait.waitfor(2);
					AddVRT.Add_TemplateName(TemplateName);
					AddVRT.Add_TemplateRequestId(TemplateRequestd);
					AddVRT.Select_HostSBU(HostSBU);
					AddVRT.Select_MeetinglocationSBU(MeetinglocationSBU);
					Wait.waitfor(2);
					AddVRT.Add_VisitDates(StartDate, EndDate);
					AddVRT.Add_VisitTime(StartTime, EndTime);
					AddVRT.Add_RequestDate(RequestDate);
					AddVRT.Click_247Access();
					//AddVRT.Click_AddDayAccess();
					AddVRT.Click_LocalHost();
					AddVRT.Click_PrimaryHost();
					AddVRT.Click_AdministrativeContact();
					Wait.waitfor(2);
					AddVRT.Click_SaveButton();
					AddVRT.select_Site(Site);
					AddVRT.type_BuildingName(BuildingName);
					AddVRT.clickAddSite();
					
					Wait.waitfor(3);
					AddVRT.Add_MeetingInformation(ClassificationLevel, VisitPurpose);
					//AddVRT.select_MeetingCategory(MeetingCategory);
					
					AddVRT.Click_Exit();
					Wait.waitfor(3);
					AddVRT.Click_NoButton();
					
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
			return Utility.getData("AddVisitorTemplate", excel);
}
	}
		

