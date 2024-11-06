package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify SBU Configuration parameter SHIPMENT_PORTAL_VERSION by setting parameter value as 1
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateInvoicePage;
import globalExportClasses.CreateNewInvoicePage;
import globalExportClasses.EditSBUFormConfigurationPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoicePage;
import globalExportClasses.SBUConfigurationParametersPage;
import globalExportClasses.SearchSBUConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifySBUConfigurationparameterSHIPMENT_PORTAL_VERSIONbysettingparametervalueas1 extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("Conf_Ship_Portal_Parties", excel);
	}

	@Test(dataProvider = "getData")
	public void verifytheinvoicelineitemlevellicensevalidation(String Testcase, String RunMode, String SBU, String Text, 
			String ParameterName, String ParameterValue) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchSBUConfigurationPage sbuconfi = new SearchSBUConfigurationPage(driver, test);
		SBUConfigurationParametersPage sbuParameters = new SBUConfigurationParametersPage(driver, test);
		EditSBUFormConfigurationPage editSBU = new EditSBUFormConfigurationPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.tools(Text);
					HGExport.sbuConfiguration();
					sbuconfi.parameterName(ParameterName);
					sbuconfi.search();
					sbuParameters.clickonParameterValue(ParameterName);
					editSBU.parameterValue(ParameterValue);
					editSBU.saveandReturn();
					
					HGExport.return_ExportHome();

				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
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
