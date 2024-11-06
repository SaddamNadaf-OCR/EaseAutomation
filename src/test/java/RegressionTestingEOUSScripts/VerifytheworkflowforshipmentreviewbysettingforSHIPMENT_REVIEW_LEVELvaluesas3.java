package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify the work flow for shipment review by setting for SHIPMENT_REVIEW_LEVEL values as 3 Page
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
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.SBUConfigurationParametersPage;
import globalExportClasses.SearchSBUConfigurationPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import vmsClasses.LoginPage;

public class VerifytheworkflowforshipmentreviewbysettingforSHIPMENT_REVIEW_LEVELvaluesas3 extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("StatusShouldShipped", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyUnitofMeasurefieldvalueisautopopulatingonsavingacopieditem(String Testcase, String RunMode, 
			String SBU, String Text, String ParameterName, String ParameterValue, String SBUcode, String ShipmentNo, 
			String UltDestination, String ExporterCode, String ConsigneeId, 
			String FFCode, String IntConsigneePartyType, String ProductDescription, String CustomsInvoiceQuantity, 
			String QuantityUOM, String ItemUnitPrice, String ControllingAgencycode, String ExportClassificationItem, 
			String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM, String ImportHTS, 
			String ImportUOM, String USExportECCN, String StatisticalCode, String BISLicenseException, String AuthorisationNo, 
			String AuthorisationItemNo, String InternalAuthNo, String RequestorReviewer, String ShippingDeptReviewer, 
			String ExportComplianceReviewer, String TransportGatekeeperExportOps, String ShippingReviewStat, String uname, 
			String password, String ShipmentApproved, String Booked, String FrieghtForwarder, String Shipped ) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage shipment = new ShipmentPage(driver, test);
		CreatShipmentPage createShipPage = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage create = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage item = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage createItem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage reviewPage = new EditShipmentReviewerDetailsPage(driver, test);
		LoginPage login = new LoginPage(driver, test);
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
					createItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO, 
							SecondaryCustomsQuantity, SecondaryCustomsQuantityUOM, ImportHTS, ImportUOM, USExportECCN, StatisticalCode);
					createItem.addExportAuthorizationInfoUS(BISLicenseException, AuthorisationNo, AuthorisationItemNo, 
							InternalAuthNo, "", "", "", "");
					createItem.click_SaveAndReturn();
					create.select_ReviewerDetails();
					reviewPage.add_ShipReviewDetails(RequestorReviewer, ShippingDeptReviewer, ExportComplianceReviewer, TransportGatekeeperExportOps);
					reviewPage.click_save();
					reviewPage.addTransaction();
					create.changeStatusToShipReview(ShippingReviewStat);
					HGExport.logOut();
					login.login(uname, password);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					shipment.enter_ShpNo(ShipNo);
					shipment.click_Search();
					resultPage.click_ShipmentNo(ShipNo);
					create.changeStatusToShipmentApproved(ShipmentApproved);
					create.changeStatusToBooked(Booked);
					create.changeStatusToFreightForwarder(FrieghtForwarder);
					create.changeStatusToShipped(Shipped);
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
