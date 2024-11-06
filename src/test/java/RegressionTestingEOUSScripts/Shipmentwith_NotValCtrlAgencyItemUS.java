package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class Shipmentwith_NotValCtrlAgencyItemUS extends SeleniumTestBase {

		@DataProvider
		public Object[][] getData() {
			return Utility.getData("ShipNotValCtrlAgencyItemUS", excel);
		}

		@Test(dataProvider = "getData")
		public void Shipment (String Testcase, String RunMode, String SBU, String SBUcode, String ShipmentNo,
				String UltDestination, String DateOfExport, String ProductFamily, String MotId, String ExporterCode, String AddPartyConsigneeID, 
				String FFCode, String PartNo, String SalesOrderNo, String Remarks, String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice, 
				String ItemUnitPriceCurrency, String ControllingAgencycode, String ExportClassificationItem, String HtsAndPrimaryUMO, 
				String USExportECCN, String BISLicenseException, String AuthorisationNo, String AuthorisationItemNo, String InternalAuthNo, 
				String AuthorisationExpiryDate, String MLCategoryCode, String SMEIndicator, String PrCoo, String ControllingAgencycode1, 
				String ExportClassificationItem1, String HtsAndPrimaryUMO1)
				throws Exception {
			HomeGExportPage HGExport = new HomeGExportPage(driver, test);
			ShipmentPage Shipment = new ShipmentPage(driver, test);
			CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
			CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
			EditShipmentItemsPage ShipItem = new EditShipmentItemsPage(driver, test);
			CreateNewOrderItemPage NewItem = new CreateNewOrderItemPage(driver, test);
			
			try {
				if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
					throw new SkipException("Skipping the test");
				} else {
					if (RunMode.equalsIgnoreCase("y")) {
						test.log(LogStatus.INFO, Testcase);
						HGExport.moveTo_SBUSelection(SBU);
						HGExport.featuresShippingTrans();
						HGExport.click_shipments();
						Shipment.click_AddShipment();
						CreatShip.select_SBUcode(SBUcode);
						CreateNewShp.shipHeaderInfo(ShipmentNo, UltDestination, DateOfExport, "", "", "","", "", ProductFamily, MotId, "", "", "","", "", "");
						CreateNewShp.partiesToTheTransaction(ExporterCode, AddPartyConsigneeID, FFCode, "");
						String shipmnetID = CreateNewShp.get_shipmentID();
						CreateNewShp.select_additems();
						ShipItem.click_AddItem();
						// NewItem.typeDesc(ProductDescription);
						NewItem.AddGeneralInformation(PartNo, "", "", "","", "", "", SalesOrderNo, "","", "", "", "", "", "", "","", Remarks, "");
					//	NewItem.enterPrCoo(PrCoo);
						NewItem.addQuantityAndPricingInfo(CustomsInvoiceQuantity, QuantityUOM, ItemUnitPrice,ItemUnitPriceCurrency, "", "", "");
					//	NewItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO,"", "", "", "", "","");
						NewItem.ExportClassification(ControllingAgencycode,ExportClassificationItem,HtsAndPrimaryUMO);
					//	NewItem.addExportAuthorizationInfoUS(BISLicenseException, AuthorisationNo, AuthorisationItemNo,InternalAuthNo, AuthorisationExpiryDate, MLCategoryCode, "", SMEIndicator);
						NewItem.click_SaveBtn();
						Wait.waitfor(2);
					//	NewItem.enterPrCoo(PrCoo);
					//	NewItem.removeSME(SMEIndicator);
						String Error=NewItem.InvaildAgencyError();
						try {
							if (Error.equalsIgnoreCase("Selected Controlling Agency is not valid for AES submission.")){
								test.log(LogStatus.PASS, "Error message Displayed");
							}
						}catch(Exception a) {
							testFail();
							test.log(LogStatus.FAIL, "Error message is not displayed");
						}
						//NewItem.addClassifacationInfo(ControllingAgencycode, ExportClassificationItem, HtsAndPrimaryUMO,"", "", "", "", "","");
						NewItem.ExportClassificationWithoutVal(ControllingAgencycode1,ExportClassificationItem1,HtsAndPrimaryUMO1);
						NewItem.click_SaveBtn();
					
					Wait.waitfor(3);
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
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
				

} 

