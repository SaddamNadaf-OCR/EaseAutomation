
package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardExportAuthorisationsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ExportClassificationo_ECCNLink = "//a[text()='ECCN']";
	public static final String OCR_ExportClassificationo_AuthorisationNoLink = "//a[@id='licenseNo-Popup']";
	public static final String OCR_ExportClassificationo_MLCategoryLink = "//a[contains(text(),'ML Category')]";
	public static final String OCR_ExportClassificationo_RegistrationNo = "//input[@id='registrationNo']";
	public static final String OCR_ExportClassificationo_LicenseExceptionLink = "(//a[contains(text(),'License Exception')])[2]";
	public static final String OCR_ExportClassificationo_ITARExemptionLink = "(//a[contains(text(),'ITAR Exemption')])[2]";
	public static final String OCR_ExportClassificationo_RegulatoryCitationLink = "//a[@id='regulatoryCitation']";
	public static final String OCR_ExportClassificationo_ECCNApplyBtn = "//button[@id='applyEccn']";
	public static final String OCR_ExportClassificationo_AuthrstionNoApplyBtn = "//button[@id='applyLic']";
	public static final String OCR_ExportClassificationo_MLCategoryApplyBtn = "//button[@id='applyUsml']";
	public static final String OCR_ExportClassificationo_LicenseExptnApplyBtn = "//button[@id='applyExp']";
	public static final String OCR_ExportClassificationo_ITARExemptionApplyBtn = "//button[@id='applyItar']";
	public static final String OCR_ExportClassificationo_RegulatoryApplyBtn = "//button[@id='applyRegCitation']";
	public static final String OCR_ExportClassificationo_RegNoApplyBtn = "//button[@id='applyRegNo']";
	public static final String OCR_ExportClassificationo_ExportClasfctnECCN = "//input[@id='searchForm_ukItemsDTO_prodClassification']";
	public static final String OCR_ExportClassificationo_ExportClasfctnECCNUS = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_ExportClassificationo_SearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportClassificationo_SelectBtn = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_ExportClassificationo_PopUpclose = "//div[@id='ocrModal']//button[@class='cancelPopup']";
	public static final String OCR_ExportClassificationo_AuthorizationNo = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_ExportClassificationo_SelectAllItems = "//input[@id='selectAll']";
	public static final String OCR_ExportClassificationo_Save= "//button[@name='save']";
	public static final String OCR_ExportClassificationo_SaveAndProceed = "//button[@name='proceed']";

	/* ******************************* Constructor ****************************** */

	public ShipWizardExportAuthorisationsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Select All Items
	public void Click_SelectAllItems() {
		clickElement(driver, test, OCR_ExportClassificationo_SelectAllItems, "Click on Select All Items Check Box");
	}

	// Adding the Authorisation And Export Classification/ML Category Code
	// Information
	public void addExportClassifications(String ExportClasfctnECCN, String AuthorizationNo, String MLCategory,
			String RegistrationNo, String LicenseException, String ITARExemption, String RegulatoryCitation) {
		if (ExportClasfctnECCN.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_ECCNLink, "Click on ECCN Link");
			try {
				typeText(driver, test, OCR_ExportClassificationo_ExportClasfctnECCN,
						"Enter the Export Classification : ", ExportClasfctnECCN);
				clickElement(driver, test, OCR_ExportClassificationo_SearchBtn, "Click on Search Button");
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + ExportClasfctnECCN + "')]",
						"click on itmes code : " + ExportClasfctnECCN);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_ECCNApplyBtn, "Click on ECCN Apply Button");
		}
		if (AuthorizationNo.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_AuthorisationNoLink, "Click on Authorisation No Link");
			try {
				typeText(driver, test, OCR_ExportClassificationo_AuthorizationNo, "Enter the Authorization No : ",
						AuthorizationNo);
				clickElement(driver, test, OCR_ExportClassificationo_SearchBtn, "Click on Search Button");
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + AuthorizationNo + "')]",
						"click on itmes code : " + AuthorizationNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_AuthrstionNoApplyBtn,
					"Click on Authrstion No Apply Button");
		}
		if (MLCategory.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_MLCategoryLink, "Click on ML Category Link ");
			try {
				typeText(driver, test, OCR_ExportClassificationo_ExportClasfctnECCN,
						"Enter the Export Classification : ", MLCategory);
				clickElement(driver, test, OCR_ExportClassificationo_SearchBtn, "Click on Search Button");
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + MLCategory + "')]",
						"click on itmes code : " + MLCategory);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_MLCategoryApplyBtn,
					"Click on ML Category Apply Button");
		}
		if (RegistrationNo.length() > 0) {
			typeText(driver, test, OCR_ExportClassificationo_RegistrationNo, "Enter the Registration No : ",
					RegistrationNo);
			clickElement(driver, test, OCR_ExportClassificationo_RegulatoryApplyBtn,
					"Click on Regulatory Apply Button");
		}
		if (LicenseException.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_LicenseExceptionLink,
					"Click on License Exception Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + LicenseException + "')]",
						"Click on License Exception : " + LicenseException);
				clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_LicenseExptnApplyBtn,
					"Click on License Exception Apply Button");
		}
		if (ITARExemption.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_ITARExemptionLink, "Click on ITAR Exemption Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ITARExemption + "')]",
						"Click on ITAR Exception : " + ITARExemption);
				clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_ITARExemptionApplyBtn,
					"Click on ITAR Exception Apply Button");
		}
		if (RegulatoryCitation.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_RegulatoryCitationLink,
					"Click on Regulatory Citation Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + RegulatoryCitation + "')]",
						"Click on Regulatory Citation : " + RegulatoryCitation);
				clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportClassificationo_RegulatoryApplyBtn,
					"Click on ITAR Exception Apply Button");
		}

	}
	
	// Adding the Authorisation And Export Classification/ML Category Code
		// Information
		public void addExportClassificationsUS(String ExportClasfctnECCN, String AuthorizationNo, String MLCategory,
				String RegistrationNo, String LicenseException, String ITARExemption, String RegulatoryCitation) {
			if (ExportClasfctnECCN.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_ECCNLink, "Click on ECCN Link");
				try {
					typeText(driver, test, OCR_ExportClassificationo_ExportClasfctnECCNUS,
							"Enter the Export Classification : ", ExportClasfctnECCN);
					clickElement(driver, test, OCR_ExportClassificationo_SearchBtn, "Click on Search Button");
					Wait.waitfor(3);
					clickElement(driver, test, "//td[contains(text(),'" + ExportClasfctnECCN + "')]",
							"click on itmes code : " + ExportClasfctnECCN);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_ECCNApplyBtn, "Click on ECCN Apply Button");
			}
			if (AuthorizationNo.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_AuthorisationNoLink, "Click on Authorisation No Link");
				try {
					typeText(driver, test, OCR_ExportClassificationo_AuthorizationNo, "Enter the Authorization No : ",
							AuthorizationNo);
					clickElement(driver, test, OCR_ExportClassificationo_SearchBtn, "Click on Search Button");
					Wait.waitfor(3);
					clickElement(driver, test, "//td[contains(text(),'" + AuthorizationNo + "')]",
							"click on itmes code : " + AuthorizationNo);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");

				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_AuthrstionNoApplyBtn,
						"Click on Authrstion No Apply Button");
			}
			if (MLCategory.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_MLCategoryLink, "Click on ML Category Link ");
				try {
					clickElement(driver, test, "//td[contains(text(),'" + MLCategory + "')]",
							"click on itmes code : " + MLCategory);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
				}
				Wait.waitfor(3);
			/*	clickElement(driver, test, OCR_ExportClassificationo_MLCategoryApplyBtn,
						"Click on ML Category Apply Button");*/
			}
			if (RegistrationNo.length() > 0) {
				typeText(driver, test, OCR_ExportClassificationo_RegistrationNo, "Enter the Registration No : ",
						RegistrationNo);
				clickElement(driver, test, OCR_ExportClassificationo_RegulatoryApplyBtn,
						"Click on Regulatory Apply Button");
			}
			if (LicenseException.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_LicenseExceptionLink,
						"Click on License Exception Link");
				try {
					clickElement(driver, test, "//td[contains(text(),'" + LicenseException + "')]",
							"Click on License Exception : " + LicenseException);
					clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_LicenseExptnApplyBtn,
						"Click on License Exception Apply Button");
			}
			if (ITARExemption.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_ITARExemptionLink, "Click on ITAR Exemption Link");
				try {
					clickElement(driver, test, "//td[contains(text(),'" + ITARExemption + "')]",
							"Click on ITAR Exception : " + ITARExemption);
					clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_ITARExemptionApplyBtn,
						"Click on ITAR Exception Apply Button");
			}
			if (RegulatoryCitation.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_RegulatoryCitationLink,
						"Click on Regulatory Citation Link");
				try {
					clickElement(driver, test, "//td[contains(text(),'" + RegulatoryCitation + "')]",
							"Click on Regulatory Citation : " + RegulatoryCitation);
					clickElement(driver, test, OCR_ExportClassificationo_SelectBtn, "Click on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportClassificationo_PopUpclose, "Click on POP up close");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassificationo_RegulatoryApplyBtn,
						"Click on ITAR Exception Apply Button");
			}

		}
	
	//Click on Save Button
	public void click_SaveBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportClassificationo_Save, "Click on Save");
	}
	
	//Click on Save and Proceed
	public void click_SaveAndProceed() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportClassificationo_SaveAndProceed, "Click on Save And Proceed");
	}
}
