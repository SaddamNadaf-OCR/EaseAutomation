
/* 
 * Module : Common
 * Author  : Nancy
 * created date : March 2020
 * Descriptions : Create New Product
 * changed by : Nancy
 * changed date : May 2021
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */

package regressionTestingGlobalProduct;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import productClasses.AddNewProductImage;
import productClasses.ClassificationDetailsPage;
import productClasses.CreateNewHazmatPage;
import productClasses.CreateNewNotesTab;
import productClasses.CreateNewProductGeneralInfoPage;
import productClasses.CreateNewProductManufacturerPage;
import productClasses.CreateNewProductSubComponentPage;
import productClasses.ExportClassificationPage;
import productClasses.HomePageProduct;
import productClasses.ImportClassificationPage;
import productClasses.ResultProductDocumentPage;
import productClasses.ResultProductImagePage;
import productClasses.ResultProductManufacturerPage;
import productClasses.ResultProductNotesPage;
import productClasses.ResultProductSubComponentPage;
import productClasses.SearchProductPage;
import utilities.Utility;
import utilities.Wait;

public class CreateNewProduct extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewProduct", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateProduct(String Testcase, String RunMode, String SBU, String PartNo, String SKUNo,
			String Description, String NationalStockNumber, String ProductName,String ProductLine,
			String SchedulingAgreement, String Program, String CommodityType, String Site, String PlantId,
			String ModelNo, String NetWeight, String UOMForPrice, String FlagReason, String MaterialType,
			String UnitPrice, String Currency, String SecurityClassification, String Segment, String HazardousMaterial,
			String CompIsDesAuth, String IsraelFTACertified, String SourceSystemId, String SourceSystemPartNo,
			String Tsca12bCode, String MSDSNumber, String CASNumber, String CountryName, String EClassification,
			String ExportclassDate, String Jurisdiction, String ControllingAgency, String prevECCNNO, String OCRCode,
			String NewECCNNO, String exclssDTofapplicab, String MethodOfDetermination,
			String RationaleForClassification, String ExpAuthority, String HSCode, String methodDETIpmort,
			String RationaleclassImport, String SchBClassification, String USMILClass, String Rationale, String GRI,
			String ChapterSectionNotes, String ExplanatoryNotes, String Remarks, String AcceptYes, String dateaccept,
			String ManufacturerCode, String CountryOfOrigin, String ContactName, String ContactEmail,
			String JurisdictionDet, String CountryOfClassification, String ExportClassification, String ScheduleB,
			String HTSUnit, String HTSCode, String ADCVDCountry, String ADCVDCaseType, String ADCVDCaseNo,
			String ADCVDEfDateFrom, String ADCVDEfDateTo, String CountryContent, String TradePrgCountry, String FTACode,
			String Eligible, String SubCompPartNo, String QuantCalcMethod, String QuantityUsed,
			String QuantityAppearing, String HazmatId,String HazIdInput, String FlashPointTemp, String HazContactName,
			String HazPhone,String IATAHazId,String IATAFlahTemp,String IATAContactname,String IATAcontactphone,
			String DocType, String DocDesc, String UploadfileName, String Notes, String Comments) {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ClassificationDetailsPage classdet = new ClassificationDetailsPage(driver, test);
		ExportClassificationPage expclass = new ExportClassificationPage(driver, test);
		ImportClassificationPage imclass = new ImportClassificationPage(driver, test);
		ResultProductManufacturerPage resultpm = new ResultProductManufacturerPage(driver, test);
		CreateNewProductManufacturerPage manuf = new CreateNewProductManufacturerPage(driver, test);
		ResultProductSubComponentPage resultscp = new ResultProductSubComponentPage(driver, test);
		CreateNewProductSubComponentPage subcomp = new CreateNewProductSubComponentPage(driver, test);
		CreateNewHazmatPage hazmat = new CreateNewHazmatPage(driver, test);
		ResultProductDocumentPage resultdoc = new ResultProductDocumentPage(driver, test);
		ResultProductNotesPage resultnote = new ResultProductNotesPage(driver, test);
		CreateNewNotesTab notes = new CreateNewNotesTab(driver, test);
		AddNewProductImage image = new AddNewProductImage(driver, test);
		ResultProductImagePage resultimg = new ResultProductImagePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoFiles();
					searchPr.clickAddProduct();
					Wait.waitfor(3);
					// productTemp.click_blank();
					// Wait.waitfor(3);
					generalInfo.enter_partno(PartNo);
					generalInfo.enter_skuno(SKUNo);
					generalInfo.enter_description(Description);
					generalInfo.enter_productname(ProductName);
					generalInfo.enter_nsNo(NationalStockNumber);
					// generalInfo.save();

					if (ProductLine.length() > 0) {
						generalInfo.click_productline();
						generalInfo.addProductLineToResultsGrid(ProductLine);
					}
					Wait.waitfor(3);
					if (Program.length() > 0) {
						generalInfo.click_program(Program);
						generalInfo.search();
						generalInfo.addProgramToResultsGrid(Program);
					}
					generalInfo.enter_type(CommodityType);
					if (Site.length() > 0) {
						generalInfo.click_site(Site);
						generalInfo.search();
						generalInfo.addSiteToResultsGrid(Site);
					}

					generalInfo.enter_plantid(PlantId);
					generalInfo.enter_ModelNo(ModelNo);
					generalInfo.enter_netweight(NetWeight);
					generalInfo.enter_schedulingagreement(SchedulingAgreement);
					generalInfo.enter_materialtype(MaterialType);
					generalInfo.enter_unitprice(UnitPrice);

					if (UOMForPrice.length() > 0) {
						generalInfo.click_uomforprice();
						generalInfo.addUOMToResultsGrid(UOMForPrice);
					}
					if (FlagReason.length() > 0) {
						generalInfo.click_flagreason(FlagReason);
						generalInfo.search();
						generalInfo.addFRToResultsGrid(FlagReason);
					}

					if (Currency.length() > 0) {
						generalInfo.click_currency();
						generalInfo.addCurrencyToResultsGrid(Currency);
					}
					generalInfo.ScrolltoSecurityClasiification();
					Wait.waitfor(3);
					generalInfo.ScrolltoProductOwner();
					Wait.waitfor(3);
					generalInfo.enter_securityclassification(SecurityClassification);
					generalInfo.segmentclick(Segment);
					Wait.waitfor(3);
					generalInfo.enter_hazardousmaterial(HazardousMaterial);
					Wait.waitfor(3);
					generalInfo.Scrolltobottom();
					generalInfo.ClickOnHeader();
					Wait.waitfor(3);

					// generalInfo.enter_approvedby(ApprovedBy);
					// generalInfo.enter_compisdesauth(CompIsDesAuth);
					// Wait.waitfor(3);
					// generalInfo.enter_IsraelFTACertified(IsraelFTACertified);
					generalInfo.enter_SourceSystemId(SourceSystemId);
					generalInfo.enter_SourceSystemPartNo(SourceSystemPartNo);
					generalInfo.enter_TSCA12bCode(Tsca12bCode);
					generalInfo.enter_MSDSNumber(MSDSNumber);
					generalInfo.enter_CASNumber(CASNumber);
					generalInfo.save();
					Wait.waitfor(15);

					generalInfo.moveForward();
					classdet.click_addeditclassification(CountryName);
					Wait.waitfor(6);
					if (EClassification.length() > 0) {
						Wait.waitfor(6);
						expclass.click_eclassification();
						Wait.waitfor(6);
						expclass.addEClassifToResultsGrid(EClassification);
						Wait.waitfor(6);
					}
					expclass.select_jurisdiction(Jurisdiction);
					Wait.waitfor(5);
					expclass.exportclassDate(ExportclassDate);
					Wait.waitfor(5);
					if (ControllingAgency.length() > 0) {
						expclass.click_controllingagencies();
						expclass.addcontrlagencyToResultsGrid(ControllingAgency);
					}

					expclass.previousexportclassfcn(prevECCNNO);
					Wait.waitfor(2);
					expclass.Newexportclassfcn(NewECCNNO);
					expclass.exclssdtofapplicab(exclssDTofapplicab);
					expclass.enter_ocrcode(OCRCode);
					Wait.waitfor(1);
					expclass.enter_MethodOfDetermination(MethodOfDetermination);
					Wait.waitfor(3);
					expclass.enter_RationaleForClassification(RationaleForClassification);
					Wait.waitfor(3);

					/*
					 * expclass.ScrolltoExpControldetails(); Wait.waitfor(3);
					 * expclass.ExportAuthority(ExpAuthority); Wait.waitfor(3);
					 * expclass.StatClassDetailheader(); Wait.waitfor(3);
					 */

					expclass.scrolltoTop();
					Wait.waitfor(3);
					expclass.save();
					Wait.waitfor(5);
					expclass.click_importclassification();
					Wait.waitfor(5);
					imclass.enter_HSCode(HSCode);
					Wait.waitfor(3);
					imclass.methodDEtImport(methodDETIpmort);
					Wait.waitfor(3);
					imclass.rationlforclassimp(RationaleclassImport);
					Wait.waitfor(3);
					imclass.enter_gri(GRI);
					Wait.waitfor(3);
					if (SchBClassification.length() > 0) {
						imclass.click_schBClassifdet();

						imclass.addschedulebToResultsGrid(SchBClassification);
					}
					imclass.USMILClassDetail();
					imclass.USMILClassAdd(USMILClass);
					// imclass.
					imclass.enter_rationale(Rationale);

					imclass.enter_chaptersecnotes(ChapterSectionNotes);
					imclass.enter_expnotes(ExplanatoryNotes);
					imclass.enter_remarks(Remarks);
					Wait.waitfor(3);
					imclass.savendreturn();
					Wait.waitfor(3);
					classdet.movetomanufacturertab();
					Wait.waitfor(5);
					resultpm.click_productmanufacturer();
					if (ManufacturerCode.length() > 0) {
						manuf.click_manufacturerid();
						manuf.addmanufacturerToResultsGrid(ManufacturerCode);
					}
					manuf.enter_countryoforigin(CountryOfOrigin);
					manuf.enter_contactname(ContactName);
					manuf.enter_contactemail(ContactEmail);
				
					//manuf.select_jurisdiction(JurisdictionDet);
					/*manuf.enter_countryofclassification(CountryOfClassification);
					Wait.waitfor(3);
					if (ExportClassification.length() > 0) {
						manuf.click_exportclassification();
						manuf.addexpclassifToResultsGrid(ExportClassification);
					
					if (ScheduleB.length() > 0) {
						manuf.save();
						driver.switchTo().alert().accept();
						manuf.click_scheduleb();
						manuf.addScheduleBToResultsGrid(ScheduleB);
					}
					manuf.enter_htscode(HTSCode);
					if (HTSUnit.length() > 0) {
						manuf.click_htsunit();
						manuf.addhtsunitToResultsGrid(HTSUnit);
					}*/
					manuf.scrolltotopofscrn();
					manuf.save();
					Wait.waitfor(3);
					manuf.scrolltoADVCbutton();
					
					if (ADCVDCountry.length() > 0) {
						manuf.addcvd();
						manuf.addAntiDumpingCountervailingCaseDetails(ADCVDCountry, ADCVDCaseType, ADCVDCaseNo,
								ADCVDEfDateFrom, ADCVDEfDateTo);
					}
					if (CountryContent.length() > 0) {
						manuf.addcountrycont();
						manuf.enter_countrycont(CountryContent);
					}
					if (TradePrgCountry.length() > 0) {
						manuf.click_addfta();
						manuf.addProductTradeProgram(TradePrgCountry, FTACode, Eligible);
						manuf.ftasavendreturn();
					
					}
					Wait.waitfor(3);
					manuf.movetosubcomponenttab();
				//	resultscp.click_addprodsubcomp();
					if (SubCompPartNo.length() > 0) {
						subcomp.click_subcomppartno();
						subcomp.addsubcomppartnoToResultsGrid(SubCompPartNo);
					}
					subcomp.select_quantitycalcmethod(QuantCalcMethod);
					subcomp.enter_quantused(QuantityUsed);
					subcomp.enter_quantapp(QuantityAppearing);
					subcomp.save();
					subcomp.savendreturn();
					Wait.waitfor(3);
					if (HazmatId.length() > 0)
						Wait.waitfor(3);{
						resultscp.moveto_hazmat();
						Wait.waitfor(3);
						if (HazmatId.length() > 0)
							Wait.waitfor(3);{
							hazmat.click_hazmat();
							Wait.waitfor(3);
							hazmat.HazIdInput(HazIdInput);
							//hazmat.click_ocrhazmatid();
							Wait.waitfor(3);
							//hazmat.addhazmatToResultsGrid(HazmatId);
							
						}
							Wait.waitfor(3);
						hazmat.enter_flashpointtemp(FlashPointTemp);
						hazmat.enter_contactname(HazContactName);
						hazmat.enter_phone(HazPhone);
						hazmat.save();
						Wait.waitfor(3);
						hazmat.scrolltoIATApacking(IATAHazId, IATAFlahTemp, IATAContactname, IATAcontactphone);
						Wait.waitfor(3);
						hazmat.save();
						Wait.waitfor(3);
					}
						Wait.waitfor(5);
					hazmat.movetodocumenttab();
					Wait.waitfor(3);
					resultdoc.click_viewadddocument();
					resultdoc.add_Document(DocType, DocDesc, UploadfileName);
					Wait.waitfor(3);
					resultdoc.movetonotestab();
					resultnote.addnote();
					notes.enter_notes(Notes);
					notes.save();
					notes.savendreturn();
					Wait.waitfor(3);
					resultnote.movetoimagestab();
					resultimg.addimage();
					image.attachimage();
					Wait.waitfor(6);
					image.uploadimage(UploadfileName, Comments);
					Wait.waitfor(6);
					home.returnToSearchProductPage();
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
			Assert.assertTrue(false);

		}
	}
}
