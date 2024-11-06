package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify the invoice line item level license validation will be skipped When SKIP_LICENSE_VALIDATION_FOR_LINEITEM is set to Y
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
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.SBUConfigurationParametersPage;
import globalExportClasses.SearchSBUConfigurationPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifytheinvoicelineitemlevellicensevalidationwillbeskippedWhenSKIP_LICENSE_VALIDATION_FOR_LINEITEMissettoY extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LineItemErroValidation", excel);
	}

	@Test(dataProvider = "getData")
	public void verifytheinvoicelineitemlevellicensevalidation(String Testcase, String RunMode, String SBU, String Text, 
			String ParameterName, String ParameterValue, String SBUcode, String ShipmentNo, String UltDestination, 
			String ExporterCode, String ConsigneeId, String FFCode, String IntConsigneePartyType, String ProductDescription, 
			String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, String ControllingAgencycode, 
			String ExportClassificationItem, String AuthorisationNo ) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage shipment = new ShipmentPage(driver, test);
		CreatShipmentPage createShipPage = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage create = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage item = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage createItem = new CreateNewOrderItemPage(driver, test);
		ResultShipmentPage resultPage = new ResultShipmentPage(driver, test);
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
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					shipment.click_AddShipment();
					createShipPage.select_SBUcode(SBUcode);
					create.shipHeaderInfo(ShipmentNo, UltDestination, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
					create.partiesToTheTransaction(ExporterCode, ConsigneeId, FFCode, IntConsigneePartyType);
					create.select_additems();
					item.click_AddItem();
					createItem.itemDetailsMandatory(ProductDescription, CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice);
					createItem.click_SaveBtn();
					String ShipNo=create.getShipNo();
					createItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, "", "", "", "", "", "", "");
					createItem.addExportAuthorizationInfoUS("", AuthorisationNo, "", "", "", "", "", "");
					createItem.click_SaveAndReturn();
					String Error=createItem.lineItemNoError();
					try {
						createItem.lineItemNoErrorValidation();
					}catch(Exception e) {
						testFail();
					}
					HGExport.tools(Text);
					HGExport.sbuConfiguration();
					sbuconfi.parameterName(ParameterName);
					sbuconfi.search();
					sbuParameters.clickonParameterValue(ParameterName);
					editSBU.parameterValue(ParameterValue);
					editSBU.saveandReturn();
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					shipment.enter_ShpNo(ShipNo);
					shipment.click_Search();
					resultPage.click_ShipmentNo(ShipNo);
					create.select_additems();
					
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
