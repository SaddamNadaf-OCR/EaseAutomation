package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : August 2024
 * Descriptions : Verify the work flow for shipment review by setting for SHIPMENT_REVIEW_LEVEL values as 4 page
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
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditSBUFormConfigurationPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.SBUConfigurationParametersPage;
import globalExportClasses.SearchSBUConfigurationPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifytheworkflowforshipmentreviewbysettingforSHIPMENT_REVIEW_LEVELvaluesas4 extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LicesnceScreeningStatusasScreen", excel);
	}

	@Test(dataProvider = "getData")
	public void verifytheworkflowforshipmentreviewbysettingforSHIPMENT_REVIEW_LEVELvaluesas4(String Testcase, String RunMode, 
			String SBU, String Text, String ParameterName, String ParameterValue, String SBUcode, String ShipmentNo, 
			String UltDestination, String ExporterCode, String ConsigneeId, String FFCode, String IntConsigneePartyType, String PartNo) {

		HomeGExportPage HGExport 		= new HomeGExportPage(driver, test);
		SearchSBUConfigurationPage sbuconfi = new SearchSBUConfigurationPage(driver, test);
		SBUConfigurationParametersPage sbuParameters = new SBUConfigurationParametersPage(driver, test);
		EditSBUFormConfigurationPage editSBU = new EditSBUFormConfigurationPage(driver, test);
		ShipmentPage shipmentPage = new ShipmentPage(driver, test);
		CreatShipmentPage createShipPage = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage createNewShipment = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage itemPage = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage createItemPage = new CreateNewOrderItemPage(driver, test);

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
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					shipmentPage.click_AddShipment();
					createShipPage.select_SBUcode(SBUcode);
					createNewShipment.shipHeaderInfo(ShipmentNo, UltDestination, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
					createNewShipment.partiesToTheTransaction(ExporterCode, ConsigneeId, FFCode, IntConsigneePartyType);
					createNewShipment.select_additems();
					itemPage.click_AddItem();
					createItemPage.AddGeneralInformation(PartNo, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
					
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
