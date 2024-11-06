package nrcLicensingScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import nrcLicensingClasses.CreateForm7GeneralInformationPage;
import nrcLicensingClasses.EditForm7DetailsPage;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.ResultExportSupplierPage;
import nrcLicensingClasses.ResultIntermediateForeignConsigneePage;
import nrcLicensingClasses.ResultUltimateForeignConsigneePage;
import utilities.Utility;
import utilities.Wait;

public class CreateNRCForm7 extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddApplication", excel);
	}

	@Test(dataProvider = "getData")

	public void AddApplication(String Testcase, String RunMode, String SBU, String TransactionId,
			String StatusChangeDate, String Phone, String TypeofAction, String USGDateSubmitted, String ProgramCode,
			String Segment, String Department, String SiteID, String RequestorUserFirstName,
			String ReviewerUserFirstName, String ApplicantExporterCode, String PartBAttention, String NameUserFirstName,
			String ContractNo, String FAX, String FirstShipmentDate, String LastShipmentDate,
			String ProposedExpirationDate, String ExportConsigneeCode, String ExportAttention,
			String FunctionsPerformed, String IForeignConsigneeCode, String ForeignAttention,
			String IntermediatePerformed, String UltimateConsigneeCode, String UltimateAttention,
			String UltimateEndUser, String DescriptionRadioactive, String TotalActivity, String Enrichmen,
			String Isotope, String ForeignObligations, String AdditionalInformation, String Recipients,
			String AInformation, String NameTitle, String AuthDate, String SecureNote, String Attachments,
			String DocumentType, String UploadfileName, String SupplierConsigneeCode, String InterConsigneeCode,
			String UFConsigneeCode, String Status, String ChangeStatus, String ChangeStatusUSG,
			String ChangeStatusApproved, String licenseNo, String IssueDate, String ExpiryDate) throws Exception {

		// ********* Objects Creation ************************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);
		ResultExportSupplierPage exportSup = new ResultExportSupplierPage(driver, test);
		ResultIntermediateForeignConsigneePage ifc = new ResultIntermediateForeignConsigneePage(driver, test);
		ResultUltimateForeignConsigneePage ufc = new ResultUltimateForeignConsigneePage(driver, test);

		// ******* Test steps execution *******************

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					nrchome.moveTo_SBUSelection(SBU);

					nrchome.click_AddApplication();
					nrchome.clickNew();
					generalInfo.addFormDetails(TransactionId, StatusChangeDate, Phone, TypeofAction, USGDateSubmitted,
							ProgramCode, Segment, Department, SiteID, RequestorUserFirstName, ReviewerUserFirstName);

					Wait.waitfor(3);
					generalInfo.clickSave();
					generalInfo.clickForm7Details();
					form7Details.addApplicantPartB(ApplicantExporterCode, PartBAttention, NameUserFirstName, ContractNo,
							Phone, FAX, FirstShipmentDate, LastShipmentDate, ProposedExpirationDate);
					form7Details.clickSave();
					form7Details.addPartCSuppliers(ExportConsigneeCode, ExportAttention, FunctionsPerformed);

					form7Details.addPartCIntermediate(IForeignConsigneeCode, ForeignAttention, IntermediatePerformed);

					form7Details.addPartCUltimate(UltimateConsigneeCode, UltimateAttention, UltimateEndUser,
							DescriptionRadioactive, TotalActivity, Enrichmen, Isotope, ForeignObligations);
					form7Details.clickSave();
					form7Details.clickAddParty();
					exportSup.clickAddSupplier();
					exportSup.addSupplier(SupplierConsigneeCode);
					exportSup.clickForm7Details();
					form7Details.clickInterAddConsignee();
					ifc.addInterConsignee(InterConsigneeCode);
					exportSup.clickForm7Details();
					form7Details.clickUltimateAddConsignee();
					ufc.addUFC(UFConsigneeCode);
					exportSup.clickForm7Details();
					form7Details.partEDetails(AdditionalInformation, Recipients, AInformation, NameTitle, AuthDate);
					form7Details.clickSave();
					form7Details.addNote(SecureNote);
					form7Details.clickBackToForm();
					form7Details.addAttachments(Attachments, DocumentType, UploadfileName);

					form7Details.clickComplete();
					form7Details.clickSave();
					form7Details.clickBackGF();
					generalInfo.selectStatus(Status, ChangeStatus, ChangeStatusUSG, ChangeStatusApproved, licenseNo,
							IssueDate, ExpiryDate);

					nrchome.NrcreturnPage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}

	}
}