package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewPackingListItemPage;
import globalExportClasses.CreateNewPackingListPage;
import globalExportClasses.CreatePackingListPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultPackingListPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreatePackingListUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatePackingList", excel);
	}

	@Test(dataProvider = "getData")
	public void PackingList(String Testcase, String RunMode, String SBU, String PackListNo, String exporterCode,
			String ExporterStatus, String shipmentNo, String dateOfExport, String OrderNo,
			String dateOfDelivery, String packingListTitle, String NoOfPackage, String BillOfLading, String grossWeight,
			String HouseAWBNo, String UltConsigneeCode, String AirCarrierCode, String specialInstruction, String terms, String Header, 
			String Footer, String partNo, String SerialNum, String shipQty, String orderQty, String GrsWeight, String unit, String caseNum, 
			String dimension, String emailID) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		PackingListPage PL = new PackingListPage(driver, test);
		CreatePackingListPage Create_PL = new CreatePackingListPage(driver, test);
		CreateNewPackingListPage Create_NewPL = new CreateNewPackingListPage(driver, test);
		ResultPackingListPage ResultPL = new ResultPackingListPage(driver, test);
		CreateNewPackingListItemPage PLItem = new CreateNewPackingListItemPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PL.addPackingList();
					Create_PL.create_packingList();
					Create_NewPL.createNewpackingList_GeneralInfo(PackListNo, exporterCode, ExporterStatus, shipmentNo, 
							dateOfExport, OrderNo, dateOfDelivery, packingListTitle, NoOfPackage, BillOfLading, 
							grossWeight, HouseAWBNo);
					Create_NewPL.ultimateConsignee(UltConsigneeCode);
					Create_NewPL.airCarrier(AirCarrierCode);
					Create_NewPL.specialInstructions(specialInstruction);
					Create_NewPL.terms(terms);
					Create_NewPL.header(Header);
					Create_NewPL.footer(Footer);
					Create_NewPL.save();
					String PList = Create_NewPL.get_PackingListNo();
					Create_NewPL.moveToItems();
					PLItem.partNum(partNo);
					PLItem.moreItemDetails(SerialNum, shipQty, orderQty, GrsWeight, unit, caseNum, dimension);
					PLItem.saveBtn();
					PLItem.saveReturnBtn();
					Create_NewPL.pagination();
					Create_NewPL.entityScreeningIcon();
					Create_NewPL.generateDocIcon();
					Create_NewPL.sendEmailWithLink(emailID);
//					Create_NewPL.saveAndReturn();
//					PL.enter_PackingListNo(PList);
//					PL.search();
//					ResultPL.click_PLNo(PList);
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
