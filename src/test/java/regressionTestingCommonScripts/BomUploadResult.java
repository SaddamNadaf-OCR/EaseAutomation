package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AuthorizationMgmtHomepagePage;
import filesClasses.UploadBOMPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class BomUploadResult extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("BomUploadResult", excel);
	}

	@Test(dataProvider = "getData")
	
	public void Fileupload(String Testcase, String RunMode, String SBU, String RefNo, String BOMDesc) throws Exception {
		UploadBOMPage upldBOm= new UploadBOMPage(driver, test);
		AuthorizationMgmtHomepagePage hpAuthmngt= new AuthorizationMgmtHomepagePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
				hpAuthmngt.moveTo_SBUSelection(SBU);
				hpAuthmngt.movetoBOM();
				upldBOm.BOMFileupld();
			upldBOm.BOMInput(RefNo, BOMDesc);
			try {
				upldBOm.attachFile();
				
				Wait.waitfor(3);
			}
				catch(Exception e) {
					upldBOm.click_close();
				}
				Wait.waitfor(3);
			//	home.returnToSearchProductPage();				
				}}}
		 catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			hpAuthmngt.logout();
			Assert.assertTrue(false);
		}
	

}}
