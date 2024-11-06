package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class VMCTOrgPreviewIcon extends SeleniumTestBase {

	@Test
	public void VMCTOrgPreview() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
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
				visitReqconfg.VmctCofigSelect(propVMs.getProperty("VMCTSBU"), propVMs.getProperty("VRScreenName"));
				visitReqconfg.click_VR_ModifyBlkList();
				visitReqconfg.select_VR_BlockList(propVMs.getProperty("VRBlockName"));
				visitReqconfg.click_VR_OrganizationPreviewIcon();
				visitReqconfg.click_VR_OrganizationPreviewIconCancel();
			}
		} catch (SkipException s) {
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
