package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import initializer.SeleniumTestBase;
import utilities.GenericMethods;

public class RouteOfGoodsUKPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/************************************Locator*****************************/
	public static final String OCR_RouteOfGoodsTab = "//i[@id='ROG']";
	public static final String OCR_RoutesOfGoodsSection_AddRouteHopBtn="//button[@id='addRouteHop']";
	public static final String OCR_RoutesOfGoodsSection_FromCountry="//input[@id='countryOfOriginDes']";
	public static final String OCR_RoutesOfGoodsSection_ToCountry ="//input[@id='countryOfDestDes']";
	public static final String OCR_RoutesOfGoodsSection_MOTLink="//a[contains(text(),'Mode of Transport')]";
	public static final String OCR_RoutesOfGoodsSection_SelectMOT="//button[@name='Ok']";
	public static final String OCR_RoutesOfGoodsSection_SaveBtn ="//button[@id='submitAppl']";
	public static final String OCR_RoutesOfGoodsSection_GoodstoBeShipped ="//select[@id='billOfLadding']";

	/********************Constructor***************/
	public RouteOfGoodsUKPage(WebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test =test;

	}

	public void clickOnRouteOfGoodsTab() {
		clickElement(driver, test, OCR_RouteOfGoodsTab, "Click on Route Of Goods Tab");
	}

	public void billoflading(String BOL) {
		selectByVisibleText(driver, test, OCR_RoutesOfGoodsSection_GoodstoBeShipped, "select the BOL : ", BOL);
	}

	// click on save
	public void clicksavebtn() {
		clickElement(driver, test, OCR_RoutesOfGoodsSection_SaveBtn, "click on save option");

	}

	// validations in Route Of Goods Tab
	public void validateRouteOfGoodsError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//span[text()='Please select Yes or No.']")) {
					test.log(LogStatus.INFO, "Please select Yes or No");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}












}
