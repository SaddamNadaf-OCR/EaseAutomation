/*
 * Module : VMs
 * Author  : Maheswara
 * created date : jan 2019
 * Descriptions : VMCT Other settings, Checking all days accesss in vmct other settings.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.OtherSettingsPage;
import vmsClasses.SearchRapidRegRequestPage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorInformationPage;
import vmsClasses.VisitorMangmentConfigToolPage;

public class VmctOtherSettings extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VmctOtherSettings", excel);
	}

	@Test(dataProvider = "getData")
	public void allDaysAccess(String Testcase, String RunMode, String SBU, String VisitFrom, String VisitTo,
			String StartTime, String EndTime) throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		OtherSettingsPage os = new OtherSettingsPage(driver, test);
		VisitorInformationPage visitorInfo = new VisitorInformationPage(driver, test);
		SearchRapidRegRequestPage rapid = new SearchRapidRegRequestPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Tools();
					searchVR.click_VMCT();
					vmct.click_OtherSetting();
					os.select_OS_SBUCode(SBU);
					os.click_OS_Search();
					os.click_OS_Edit();
					os.get_visitFrom(VisitFrom);
					Wait.waitfor(3);
					os.get_visitTo(VisitTo);
					os.click_OS_Update();
					Wait.waitfor(3);
					homePage.returnPage();
					searchVR.moveTo_Features();
					searchVR.click_VisitorRequests();
					searchVR.click_RapidRegistaration();
					rapid.click_AddNewVisitorRequest();
					visitorInfo.validate_AllDaysAccess();

					String Start = visitorInfo.get_StartTime();
					if (Start.contains(StartTime)) {
						test.log(LogStatus.PASS, "Expected Start Time: " + StartTime);
						softAssertion.assertTrue(true);
					} else {
						test.log(LogStatus.FAIL, "Expected Start Time: " + StartTime);
						testFail();
						softAssertion.assertTrue(false);
					}
					String End = visitorInfo.get_endTime();
					if (End.contains(EndTime)) {
						test.log(LogStatus.PASS, "Expected End Time : " + EndTime);
						softAssertion.assertTrue(true);
					} else {
						test.log(LogStatus.FAIL, "Expected End Time: " + EndTime);
						testFail();
						softAssertion.assertTrue(false);
					}
					Wait.waitfor(3);
					softAssertion.assertAll();
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
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}

}
