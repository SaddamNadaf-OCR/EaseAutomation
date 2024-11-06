package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EndUseDetailsUKPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/****************** Locators *************/

	public static final String OCR_EndUseDetailsTab = "//i[@id='EUSE']";
	public static final String OCR_EndUseDetails_PromotionApprovals_NRadioBtn = "//input[@id='modRefFlagN']";
	public static final String OCR_EndUseDetails_PromotionApprovals_YRadioBtn = "//input[@id='modRefFlagY']";
	public static final String OCR_EndUseDetails_PromotionApprovals_MODF680Refernce = "//input[@id='licAddrDescNo']";
	public static final String OCR_EndUseDetails_WMDUseControls_Scroll = "//label[contains(text(),'WMD End Use Control')]";
	public static final String OCR_EndUseDetails_WMDUseControls_YRadioBtn = "//input[@id='wmdCapableFlagY']";
	public static final String OCR_EndUseDetails_WMDUseControls_NRadioBtn = "//input[@id='wmdCapableFlagN']";
	public static final String OCR_EndUseDetails_WMDUseControls_ECOReference = "//input[@id='ecoReferenceId']";
	public static final String OCR_EndUseDetails_WMDUseControls_1NRadioBtn = "//input[@id='suspectingFlagN']";
	public static final String OCR_EndUseDetails_WMDUseControls_1YRadioBtn = "//input[@id='suspectingFlagY']";
	public static final String OCR_EndUseDetails_WMDUseControls_SuspectingDtls = "//textarea[@id='suspectingDtl']";
	public static final String OCR_EndUseDetails_WMDUseControlsText = "//textarea[@id='suspectingDtl']";
	public static final String OCR_EndUseDetails_MilitaryEndUse_Scroll = "//label[contains(text(),'Military End Use Control')]";
	public static final String OCR_EndUseDetails_MilitaryEndUse_NRadioBtn = "//input[@id='letterFromEcoFlagN']";
	public static final String OCR_EndUseDetails_MilitaryEndUse_YRadioBtn = "//input[@id='letterFromEcoFlagY']";
	public static final String OCR_EndUseDetails_MilitaryEndUse_ECOReference = "//input[@id='militoryEndUseRef']";
	public static final String OCR_EndUseDetails_EuropeanMilitaryGoods_Scroller = "//label[contains(text(),'European Military Items')]";
	public static final String OCR_EndUseDetails_EuropeanMilitaryGoods_NRadioBtn = "//input[@id='europianMilitaryFlagN']";
	public static final String OCR_EndUseDetails_EuropeanMilitaryGoods_YRadioBtn = "//input[@id='europianMilitaryFlagY']";
	public static final String OCR_EndUseDetails_EuropeanMilitaryGoods_NARadioBtn = "//input[@id='europianMilitaryFlagU']";
	public static final String OCR_EndUseDetails_EuropeanMilitaryGoods_PleaseExplainTextArea = "//textarea[@id='europianMilitoryDtl']";
	public static final String OCR_EndUseDetails_ItendedEndUse_Scroller = "//label[contains(text(),'Intended End Use')]";
	public static final String OCR_EndUseDetails_ItendedEndUse_TextArea = "//textarea[@id='intendedEndUseDesc']";
	public static final String OCR_EndUseDetails_ItendedEndUse_NRadioBtn = "//input[@id='proposedExpoertFlagN']";
	public static final String OCR_EndUseDetails_ItendedEndUse_YRadioBtn = "//input[@id='proposedExpoertFlagY']";
	public static final String OCR_EndUseDetails_ItendedEndUse_ProposeDesc = "//textarea[@id='proposedExpoertDescId']";
	public static final String OCR_EndUseDetails_OtherInfo_Scroller = "//label[contains(text(),'Other Information')]";
	public static final String OCR_EndUseDetails_OtherInfo = "//textarea[@id='abcd']";
	public static final String OCR_EndUseDetails_Save = "//input[@id='submitAppl']";
	public static final String OCR_GoodsLocationIcon = "//i[@id='GLS']";

	/************ Constructor ****************/
	public EndUseDetailsUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*************** Actions ****************** */

	public void clickOnEndUseDetailsTab() {
		clickElement(driver, test, OCR_EndUseDetailsTab, "Click on End Use Details Tab");
	}

	public void addpromotionalApprovals(String SelectPromotionAns, String F680Reference) {
		Wait.waitfor(2);
		if (SelectPromotionAns.contains("Yes")) {
			clickElement(driver, test, OCR_EndUseDetails_PromotionApprovals_YRadioBtn, "Click on Yes radio button");
			typeText(driver, test, OCR_EndUseDetails_PromotionApprovals_MODF680Refernce, "Enter F680 Reference : ",
					F680Reference);
		} else {
			clickElement(driver, test, OCR_EndUseDetails_PromotionApprovals_NRadioBtn, "click on No");
		}
	}

	public void addWMDEndUseControl(String SelectWMDAnsw1, String ECOReference1, String SelectWMDAnsw2,
			String ECOReference2) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_EndUseDetails_WMDUseControls_Scroll, "click on WMD Scroller");
		Wait.waitfor(2);
		if (SelectWMDAnsw1.contains("Yes")) {
			clickElement(driver, test, OCR_EndUseDetails_WMDUseControls_YRadioBtn, "Click on Yes radio button");
			typeText(driver, test, OCR_EndUseDetails_WMDUseControls_ECOReference, "Enter WMD ECOReference1 : ",
					ECOReference1);
		} else {
			clickElement(driver, test, OCR_EndUseDetails_WMDUseControls_NRadioBtn, "click on No ");
		}
		if (SelectWMDAnsw2.contains("Yes")) {
			Wait.waitfor(3);
			scrollToBottom(driver);
			clickElement(driver, test, OCR_EndUseDetails_WMDUseControls_1YRadioBtn, "Click on Yes radio button");
			typeText(driver, test, OCR_EndUseDetails_WMDUseControls_SuspectingDtls, "Enter WMD ECOReference2 :  ",
					ECOReference2);
		} else {
			clickElement(driver, test, OCR_EndUseDetails_WMDUseControls_1NRadioBtn, "click on No ");
		}
	}

	public void addMilitaryEndUSeControl(String SelectMilitaryAnsw, String MilitaryReference) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EndUseDetails_MilitaryEndUse_Scroll, "click on Military End Use Scroller");
		Wait.waitfor(2);
		if (SelectMilitaryAnsw.contains("Yes")) {
			scrollToBottom(driver);
			clickElement(driver, test, OCR_EndUseDetails_MilitaryEndUse_YRadioBtn, "Click on Yes radio button");
			typeText(driver, test, OCR_EndUseDetails_MilitaryEndUse_ECOReference, "Enter WMD Military Reference : ",
					MilitaryReference);
		} else {
			clickElement(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_NRadioBtn, "click on No ");
		}
	}

	public void addEuropeanMilitaryItems(String SelectEuropeanMilAnsw, String EuropeanMilExplain) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_Scroller, "click on scroller");
		Wait.waitfor(2);
		scrollToBottom(driver);
		if (SelectEuropeanMilAnsw.contains("NA")) {
			clickElement(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_NARadioBtn, "Click on NA radio button");
			typeText(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_PleaseExplainTextArea,
					"Enter EuropeanMilitary NA Reference : ", EuropeanMilExplain);
		} else if (SelectEuropeanMilAnsw.contains("No")) {
			clickElement(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_NRadioBtn, "click on No ");
			typeText(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_PleaseExplainTextArea,
					"Enter EuropeanMilitary No Reference : ", EuropeanMilExplain);
		} else {
			clickElement(driver, test, OCR_EndUseDetails_EuropeanMilitaryGoods_YRadioBtn, "Click on Yes Radio Button");
		}
	}

	public void addIntendedEndUse(String IntendDescription, String SelectIntendedEndUseAnsw,
			String IntendPropDescription) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EndUseDetails_ItendedEndUse_Scroller, "click on Intended Scroller");
		typeText(driver, test, OCR_EndUseDetails_ItendedEndUse_TextArea, "Add Text in description : ",
				IntendDescription);
		scrollToBottom(driver);
		if (SelectIntendedEndUseAnsw.contains("Yes")) {
			clickElement(driver, test, OCR_EndUseDetails_ItendedEndUse_YRadioBtn, "click on Yes Radio Button");
			typeText(driver, test, OCR_EndUseDetails_ItendedEndUse_ProposeDesc, "Enter Intend Text in description : ",
					IntendPropDescription);
		} else {
			clickElement(driver, test, OCR_EndUseDetails_ItendedEndUse_NRadioBtn, "click on No Radio Button");
		}
	}

	public void addOtherInfo(String EndUseOtherInfo) {
		scrollToBottom(driver);
		clickElement(driver, test, OCR_EndUseDetails_OtherInfo_Scroller, "click on Intended Scroller");
		typeText(driver, test, OCR_EndUseDetails_OtherInfo, "Add other Info : ", EndUseOtherInfo);
	}

	public void saveEndUseDetails() {
		scrollToElement(driver, OCR_EndUseDetails_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_EndUseDetails_Save, "Click on Save Button");
	}

	public void clickonGoodsLocation() {
		clickElement(driver, test, OCR_GoodsLocationIcon, "click on Goods Location Icon");
	}
}
