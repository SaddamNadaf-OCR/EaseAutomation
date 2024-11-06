package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class FTAdditionalInfoEquipmentPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_NotApplicable = "//input[@id='editForeignTravelGeneralInfo_equtNotApplicable']";
	public static final String OCR_Button_Save = "//button[@name='saveGenInfo']";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_NotApplicable1 = "//input[@name='notApplicable']";
	
	/* ******************************** Constructor ******************************** */
	public FTAdditionalInfoEquipmentPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	//Click on Not Applicable CheckBox
	public void click_notapplicable(){		
		clickElement(driver, test, OCR_NotApplicable,"Clicked on Not Applicable CheckBox For Equipment Tab :");
		Wait.waitfor(3);
		scrollToBottom(driver);
	}
	
	// Click on all not applicable checkbox
	public void notapplicable1() {
		scrollToElement(driver, OCR_NotApplicable1);
		List<WebElement> notapplicable = driver.findElements(By.xpath(OCR_NotApplicable1));
		for (int i = 1; i <= notapplicable.size(); i++) {
			Wait.waitfor(3);
			scrollToElement(driver, "(//input[@name='notApplicable'])" + "[" + i + "]");
			Wait.waitfor(3);
			clickElement(driver, test, "(//input[@name='notApplicable'])" + "[" + i + "]", "Click on Not Applicable :");
		}
		scrollToTop(driver);
	}

	//Click on Save Button
	public void save() {
		scrollToElement(driver, OCR_Button_Save);
		clickElement(driver, test, OCR_Button_Save,"Clicking on Save Button :");		
	}
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	} 
	
	//Click 
	public void clickonlabel() {
		clickElement(driver, test, "//input[@name='foreignTravelEquipmentsValue.laptopModel']", "");
	}

}
