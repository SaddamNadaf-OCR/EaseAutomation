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
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class EmployeeIdError29499 extends SeleniumTestBase {

	@Test
	public void standardrequest() throws Exception {
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		CreateNewVisitorRequestPage create = new CreateNewVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		VisitorRequestConfigPage visitReqconfg = new VisitorRequestConfigPage(driver, test);
		

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_VisitorRequest();
				visitReqconfg.VmctCofigSelect(propVMs.getProperty("SBU"), "");
				visitReqconfg.click_VR_ModifyBlkList();
				visitReqconfg.click_VR_ModifyFieldDetails();
				visitReqconfg.selectEmployeeID("M");
				visitReqconfg.click_Save();
				visitReqconfg.click_VR_ModifyFieldCancel();
				searchVR.moveTo_Features();
				searchVR.click_VisitorRequests();
				searchVR.click_VisitorRequest();
				searchVR.click_AddNewVisitorRequest();
				create.select_sbu("");
				create.click_Create();
				create.validate_EmployeeID();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_VisitorRequest();
				visitReqconfg.VmctCofigSelect(propVMs.getProperty("SBU"), "");
				visitReqconfg.click_VR_ModifyBlkList();
				visitReqconfg.click_VR_ModifyFieldDetails();
				visitReqconfg.selectEmployeeID("O");
				visitReqconfg.click_Save();
				visitReqconfg.click_VR_ModifyFieldCancel();
				Wait.waitfor(3);
				homePage.returnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			searchVR.moveTo_Tools();
			searchVR.click_VMCT();
			vmct.click_VisitorRequest();
			visitReqconfg.VmctCofigSelect(propVMs.getProperty("SBU"), "");
			visitReqconfg.click_VR_ModifyBlkList();
			visitReqconfg.click_VR_ModifyFieldDetails();
			visitReqconfg.selectEmployeeID("O");
			visitReqconfg.click_Save();
			visitReqconfg.click_VR_ModifyFieldCancel();
			Wait.waitfor(3);
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}
}
