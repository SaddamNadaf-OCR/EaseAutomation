package RegressionTestingEOUSScripts;

import org.openqa.grid.web.servlet.handler.SeleniumBasedRequest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateInvoiceTemplatePage;
import globalExportClasses.CreateNewInvoiceTemplatePage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.OrderTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyCopyInvoiceTemplateUS extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyInvoiceTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyCopyInvoiceTemplate(String Testcase, String RunMode, String SBU, String tempName) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		OrderTemplatePage orderTemp = new OrderTemplatePage(driver, test);
		CreateInvoiceTemplatePage createInv = new CreateInvoiceTemplatePage(driver, test);
		CreateNewInvoiceTemplatePage createNewInv = new CreateNewInvoiceTemplatePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.Invoice();
					orderTemp.copyTemplate();
					orderTemp.copyAlertMsg();
					createNewInv.templatename(tempName);
					createNewInv.saveBtn();
					createNewInv.getInvTemplateID();
					String InvTempId = createNewInv.getInvTemplateID();
					HGExport.return_ExportHome();

				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		
	}
	

}
