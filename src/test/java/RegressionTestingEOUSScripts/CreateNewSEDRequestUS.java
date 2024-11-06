package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewSEDRequestUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateSEDRequest", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateSEDRequest(String Testcase, String RunMode, String SBU, String ShipmentNo, String UltDestination,
			String TransRefNum, String ExporterCode, String ConsigneeId, String FFCode, String Fname, String Lname,
			String Phone, String Mobile, String EmailId, String ConsType, String City, String State, String ConsFname,
			String ConsPhone, String ConsMobile, String ConsEmailId, String FFname, String FFPhone, String FFMobile,
			String FFEmailId, String MOT, String PortOfExport, String USPPI, String USPPIEIN, String FILER,
			String FILEREIN, String ForwarderID, String ForwarderEIN, String PartNo, String CustomsInvoiceQuantity,
			String QuantityUOM, String ControllingAgencycode, String ExportClassificationItem, String HtsAndPrimaryUMO,
			String AuthorisationNo, String AuthorisationItemNo, String CategoryDet, String ddtcUOM, String PrCoo,
			String ShippingDeptReviewer, String ShipRegion, String ShipSite, String ExportComplianceReviewer,
			String ExportRegion, String ExportSite, String TransportGatekeeperExportOps, String TransRegion,
			String TransSite, String ShippingReviewStat) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EEI = new ElectronicExportInformationTransactionsPage(driver, test);
		CreateElectronicExportInformationTransactionsPage create = new CreateElectronicExportInformationTransactionsPage(
				driver, test);
		CreateNewElectronicExportInformationTransactionsPage createEEIT = new CreateNewElectronicExportInformationTransactionsPage(
				driver, test);
		EditElectronicExportInformationTransactionsPage edit = new EditElectronicExportInformationTransactionsPage(
				driver, test);
		EditShipmentItemsPage itemPage = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage additem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage ReviewerDetails = new EditShipmentReviewerDetailsPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.CustomsFiling();
					EEI.clickAddEEI();
					create.newEEITRadioButton();
					create.createEEITransaction();
					createEEIT.enterShipNo(ShipmentNo);
					createEEIT.enterCountryDest(UltDestination);
					createEEIT.transportRefNum(TransRefNum);

					createEEIT.PartiesToTheTransaction(ExporterCode, ConsigneeId, FFCode);
					createEEIT.contactExporter(Fname, Lname, Phone, Mobile, EmailId);
					createEEIT.contactUltCons(ConsType, City, State, ConsFname, ConsPhone, ConsMobile, ConsEmailId);
					createEEIT.contactFF(FFname, FFPhone, FFMobile, FFEmailId);
					createEEIT.transportationDetails(MOT, "", "", PortOfExport, "", "", "", "");
					createEEIT.Savebutton();
					createEEIT.enterUSPPI(USPPI, USPPIEIN);
					createEEIT.enterFiler(FILER, FILEREIN);
					createEEIT.enterForwarderID(ForwarderID, ForwarderEIN);
					createEEIT.Savebutton();
					edit.additionalTransactionDetails();
					edit.selectItem();
					itemPage.click_AddItem();
					additem.AddGeneralInformation(PartNo, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
							"", "", "");
					additem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, "", "", "", "", "");
					additem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO, "",
							"", "", "", "", "");
					additem.click_SaveBtn();
//					additem.addExportAuthorizationInfoUS("", AuthorisationNo, AuthorisationItemNo, "", "", "", "", "");
//						additem.enterXXICategory(CategoryDet);
//					additem.DDTCUom(ddtcUOM);

					additem.click_SaveBtn();
					additem.enterPrCoo(PrCoo);
					additem.click_SaveAndReturn();
					Wait.waitfor(2);
					/*additem.click_Close();
					itemPage.click_AdditionalTransacDetails();

					additem.click_SaveBtn();
					ReviewerDetails.add_ShipReviewDetails(ShippingDeptReviewer, ShipRegion, ShipSite,
							ExportComplianceReviewer, ExportRegion, ExportSite, TransportGatekeeperExportOps,
							TransRegion, TransSite);
					ReviewerDetails.click_save();
					ReviewerDetails.addTransaction();

					CreateNewShp.changeStatusToShipReview(ShippingReviewStat);
					CreateNewShp.getShipNo();
					String shipNo = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipStatus = CreateNewShp.get_shipmentStatus();
					createEEIT.click_validationStatus();
					Wait.waitfor(3);
					HGExport.return_ExportHome();*/

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
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
}
