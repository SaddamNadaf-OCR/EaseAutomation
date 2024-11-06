package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify whether documents can be attached to EEI transactions in the Shipment Approved Status Page
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
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultElectronicExportInformationTransactionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifydocumentscanbeattachedtoEEItransactionsintheShipmentApprovedStatus extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifyDocumentAttached", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyshipmentnumberfieldlengtharevalidation(String Testcase, String RunMode, String SBU, String ShipmentWorkStatus, 
			String DocType, String DocDesc, String UploadfileName) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EETranPage = new ElectronicExportInformationTransactionsPage(driver,test);
		ResultElectronicExportInformationTransactionsPage result = new ResultElectronicExportInformationTransactionsPage(driver, test);
		EditElectronicExportInformationTransactionsPage edit = new EditElectronicExportInformationTransactionsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.CustomsFiling();
					EETranPage.searchShipmentStatus(ShipmentWorkStatus);
					EETranPage.clickSearch();
					result.openShipment();
					edit.uploadFileAttachment();
					edit.uploadDoc(DocType, DocDesc, UploadfileName);
					String Document = edit.getDocName();
					System.out.println(Document);
					try {
						if(Document.equalsIgnoreCase("Capture.PNG")) {
							test.log(LogStatus.PASS, "Added Document is Displaying in the Grid :");
						}
					}catch(Exception e) {
						testFail();
						test.log(LogStatus.FAIL, "Added Document is Not Displaying in the Grid :");
					}

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
