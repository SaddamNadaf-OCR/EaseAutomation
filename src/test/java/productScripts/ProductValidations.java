/* 
 * Module : Product
 * Author  : Nancy
 * Created date : June 2020
 * Descriptions : Validations in Product.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil */

package productScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import productClasses.AddNewProductImage;
import productClasses.ClassificationDetailsPage;
import productClasses.CreateNewNotesTab;
import productClasses.CreateNewProductGeneralInfoPage;
import productClasses.CreateNewProductManufacturerPage;
import productClasses.CreateNewProductSubComponentPage;
import productClasses.ExportClassificationPage;
import productClasses.HomePageProduct;
import productClasses.ImportClassificationPage;
import productClasses.ProductTemplatePage;
import productClasses.ResultProductDocumentPage;
import productClasses.ResultProductImagePage;
import productClasses.ResultProductManufacturerPage;
import productClasses.ResultProductNotesPage;
import productClasses.ResultProductSubComponentPage;
import productClasses.SearchProductPage;
import utilities.Utility;
import utilities.Wait;

public class ProductValidations extends SeleniumTestBase {
	@Test(priority = 1)
	public void ValidateGeneralInfoError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.save();
				generalInfo.validate_GeneralInfoError();
				Wait.waitfor(4);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void ValidateExpClassifDetailsError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ClassificationDetailsPage classdet = new ClassificationDetailsPage(driver, test);
		ExportClassificationPage expclass = new ExportClassificationPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//Wait.waitfor(3);
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
				//generalInfo.click_productline();
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
			//	Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				generalInfo.moveForward();
				classdet.click_addeditclassification("United States");
				expclass.save();
				expclass.validate_ExpClassifDetError();
				Wait.waitfor(4);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void ValidateImpClassifError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ClassificationDetailsPage classdet = new ClassificationDetailsPage(driver, test);
		ExportClassificationPage expclass = new ExportClassificationPage(driver, test);
		ImportClassificationPage imclass = new ImportClassificationPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
				Wait.waitfor(3);
			//	generalInfo.click_productline();
			//	Wait.waitfor(3);
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
			//	Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				Wait.waitfor(4);
				generalInfo.moveForward();
				classdet.click_addeditclassification("United States");
				Wait.waitfor(4);
				expclass.click_eclassification();
				Wait.waitfor(4);
				expclass.addEClassifToResultsGrid(propProd.getProperty("EClassification"));
				Wait.waitfor(4);
			expclass.enter_ocrcode(propProd.getProperty("OCRCode"));
				expclass.save();
				expclass.click_importclassification();
				Wait.waitfor(3);
				imclass.save();
				imclass.validate_ImpClassifError();
				Wait.waitfor(4);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void ValidateManufError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ResultProductManufacturerPage resultpm = new ResultProductManufacturerPage(driver, test);
		CreateNewProductManufacturerPage manuf = new CreateNewProductManufacturerPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
			//	generalInfo.click_productline();
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
			//	Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				generalInfo.movetomanufacturertab();
				resultpm.click_productmanufacturer();
				manuf.save();
				manuf.validatemanuferror();
				Wait.waitfor(4);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5)
	public void ValidateSubCompError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ResultProductSubComponentPage resultscp = new ResultProductSubComponentPage(driver, test);
		CreateNewProductSubComponentPage subcomp = new CreateNewProductSubComponentPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
		//		generalInfo.click_productline();
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
			//	Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				generalInfo.movetosubcomponenttab();
				resultscp.click_addprodsubcomp();
				subcomp.save();
				subcomp.validate_subcomperror();
				Wait.waitfor(3);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 6)
	public void ValidateDocError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ResultProductDocumentPage resultdoc = new ResultProductDocumentPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
			//	generalInfo.click_productline();
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
			//	Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				generalInfo.movetodocumenttab();
				resultdoc.click_viewadddocument();
				resultdoc.save();
				resultdoc.validate_documenterror();
				resultdoc.cancel();
				Wait.waitfor(3);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 7)
	public void ValidateNotesError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		ResultProductNotesPage resultnote = new ResultProductNotesPage(driver, test);
		CreateNewNotesTab notes = new CreateNewNotesTab(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
			//	generalInfo.click_productline();
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
				Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				generalInfo.movetonotestab();
				resultnote.addnote();
				notes.save();
				notes.validate_noteerror();
				Wait.waitfor(3);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8)
	public void ValidateImageError() throws Exception {

		SearchProductPage searchPr = new SearchProductPage(driver, test);
		ProductTemplatePage productTemp = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage generalInfo = new CreateNewProductGeneralInfoPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);
		AddNewProductImage image = new AddNewProductImage(driver, test);
		ResultProductImagePage resultimg = new ResultProductImagePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				home.moveTo_SBUSelection(propProd.getProperty("SBU"));
				home.movetoFiles();
				searchPr.clickAddProduct();
				//productTemp.click_blank();
				Wait.waitfor(3);
				generalInfo.enter_description(propProd.getProperty("Description"));
				//generalInfo.click_productline();
			//	generalInfo.addProductLineToResultsGrid(propProd.getProperty("ProductLine"));
				Wait.waitfor(3);
				generalInfo.click_program(propProd.getProperty("Program"));
				generalInfo.search();
				generalInfo.addProgramToResultsGrid(propProd.getProperty("Program"));
				generalInfo.click_site(propProd.getProperty("Site"));
				generalInfo.search();
				generalInfo.addSiteToResultsGrid(propProd.getProperty("Site"));
				generalInfo.save();
				generalInfo.movetoimagestab();
				resultimg.addimage();
				image.save();
				image.validate_imageerror();
				Wait.waitfor(3);
				home.returnToSearchProductPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}
}
