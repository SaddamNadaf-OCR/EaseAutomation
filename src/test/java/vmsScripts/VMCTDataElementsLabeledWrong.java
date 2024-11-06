package vmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorWorkFlowConfigPage;

public class VMCTDataElementsLabeledWrong extends SeleniumTestBase {

	@Test
	public void VMCTWorflowConfig() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		VisitorWorkFlowConfigPage workflowconfig = new VisitorWorkFlowConfigPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_WorkFlowConfig();
				workflowconfig.VmctCofigSelect(propVMs.getProperty("VMCTSBU"));
				Wait.waitfor(3);
				workflowconfig.selectGroupName(propVMs.getProperty("WorkFlowGroupName"),
						propVMs.getProperty("ScreenName"), propVMs.getProperty("Block"));
				workflowconfig.get_WorkFlowBlockdataelements(propVMs.getProperty("BlockName"));
				Wait.waitfor(3);
				workflowconfig.get_WorkFlowFielddataelements(propVMs.getProperty("FieldName"));
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
