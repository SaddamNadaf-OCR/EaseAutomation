package regressionTestingVMScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;
import vmsClasses.VisitorMangmentConfigToolPage;
import vmsClasses.VisitorRequestConfigPage;

public class FieldNameOverriddenwithCustomField extends SeleniumTestBase {

	@Test
	public void validateFieldName() throws Exception {

		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		VisitorMangmentConfigToolPage vmct = new VisitorMangmentConfigToolPage(driver, test);
		VisitorRequestConfigPage visitReqconfg = new VisitorRequestConfigPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homePage.moveTo_SBUSelection(propVMs.getProperty("SBU"));
				homePage.click_VisitorManagemtn();
				searchVR.moveTo_Tools();
				searchVR.click_VMCT();
				vmct.click_VisitorRequest();
				visitReqconfg.VmctCofigSelect(propVMs.getProperty("VMCTSBU"), propVMs.getProperty("VMCTScreenName"));
				visitReqconfg.click_VR_ModifyBlkList();
				visitReqconfg.select_VR_BlockList(propVMs.getProperty("VMCTBlockName"));
				visitReqconfg.click_VR_ModifyFieldDetails();
				String FieldName = visitReqconfg.getFiledname();
				String CustomFieldName = visitReqconfg.getcustomFiledname(propVMs.getProperty("VMCTCustomFieldName"));
				if (!CustomFieldName.equalsIgnoreCase(FieldName)) {
					test.log(LogStatus.PASS, "Expected FieldName : " + FieldName);
					test.log(LogStatus.PASS, "Expected CustomFieldName : " + CustomFieldName);
				} else {
					test.log(LogStatus.FAIL, "Expected FieldName : " + FieldName);
					test.log(LogStatus.FAIL, "Expected CustomFieldName : " + CustomFieldName);
					testFail();
					softAssertion.assertTrue(false);
				}
				visitReqconfg.click_VR_ModifyFieldCancel();
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
			softAssertion.assertAll();
		}
	}
}
