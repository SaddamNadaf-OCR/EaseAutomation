package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify the Country code in Shipment for Country Shipped From when parameter COUNTRY_SHIPPED_FROM set to Y Page
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
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifytheCountrycodeinShipmentforCountryShippedFromwhenparameterCOUNTRY_SHIPPED_FROMsettoY extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CountryShipFromSameasConfi", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyCountryShippedFromisSameasConfigured(String Testcase, String RunMode, String SBU, 
			String SBUcode) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage shipment = new ShipmentPage(driver, test);
		CreatShipmentPage createShipPage = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage create = new CreateNewShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					shipment.click_AddShipment();
					createShipPage.select_SBUcode(SBUcode);
					String CountryShippedFrom = create.get_CountryShippedFrom();
					try {
						if(CountryShippedFrom.equalsIgnoreCase("UNITED STATES")) {
							test.log(LogStatus.PASS, "Country Shipped From is the same country configured in the System Variables :");
						}
					}catch(Exception e) {
						testFail();
						test.log(LogStatus.FAIL, "Country Shipped From is Not the same country configured in the System Variables :");
					}
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
