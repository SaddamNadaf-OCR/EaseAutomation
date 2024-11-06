package RegressionTestingEOUSScripts;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify SBU Configuration parameter CONFIG_IMPORT_INVOICE_PARTIES_TO_SHIPMENT by setting parameter value as Y and N
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
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditInvoiceItemsPage;
import globalExportClasses.EditSBUFormConfigurationPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoicePage;
import globalExportClasses.SBUConfigurationParametersPage;
import globalExportClasses.SearchSBUConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifySBUConfigurationparameterCONFIG_IMPORT_INVOICE_PARTIES_TO_SHIPMENTbysettingparametervalueasYandN extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("Conf_Imp_Inv_Parties", excel);
	}

	@Test(dataProvider = "getData")
	public void verifytheinvoicelineitemlevellicensevalidation(String Testcase, String RunMode, String SBU, String Text, 
			String ParameterName, String ParameterValue, String SBUCode, String orderNo, String ultDest, String ModeOfTransport, 
			String EntityType, String entityCode, String Status, String ShipmentApproved) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchSBUConfigurationPage sbuconfi = new SearchSBUConfigurationPage(driver, test);
		SBUConfigurationParametersPage sbuParameters = new SBUConfigurationParametersPage(driver, test);
		EditSBUFormConfigurationPage editSBU = new EditSBUFormConfigurationPage(driver, test);
		InvoicePage create = new InvoicePage(driver, test);
		CreateInvoicePage createInvoice = new CreateInvoicePage(driver, test);
		CreateNewInvoicePage createInvoicePage = new CreateNewInvoicePage(driver, test);
		CreatShipmentPage createShipment = new CreatShipmentPage(driver, test);
		ResultInvoicePage result = new ResultInvoicePage(driver, test);

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
					HGExport.OCR_HomePage_Invoice_Order();
					create.click_AddInvoiceBtn();
					createInvoice.select_SBUCode(SBUCode);
					createInvoicePage.invoice_Details(orderNo, ultDest, ModeOfTransport);
					createInvoicePage.addPartiesToTheTransaction(EntityType, entityCode, Status);
					createInvoicePage.saveBtn();
					String InvOrderNo=createInvoicePage.gettingInvoiceOrderNo();
					createInvoicePage.changeStatusToShipmentApproved(ShipmentApproved);
					createInvoicePage.addShipmentButton();
					createShipment.configuredPartyValidation();
					HGExport.return_ExportHome();
					String parametervalue = "N";
					HGExport.tools(Text);
					HGExport.sbuConfiguration();
					sbuconfi.parameterName(ParameterName);
					sbuconfi.search();
					sbuParameters.clickonParameterValue(ParameterName);
					editSBU.parameterValue(parametervalue);
					editSBU.saveandReturn();
					HGExport.OCR_HomePage_Invoice_Order();
					create.enter_InvoiceOrderNo(InvOrderNo);
					create.click_SearchButton();
					result.clickInvoiceNo(InvOrderNo);
					Wait.waitfor(2);
					createInvoicePage.addShipmentButton();
					createShipment.configuredPartyValidationN();
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
