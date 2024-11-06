package dmsClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class DMSFormConfigurationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_NewSearch = "//button[@name='Search']";

	/* ******************************* Constructor ****************************** */

	public DMSFormConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void returntosearchpage() {
		clickElement(driver, test, OCR_Button_NewSearch, "Return to searchpage");
	}

	public void deletedmsformconfig() {
		clickElement(driver, test, "//tbody/tr[@id='1']/td[9]/a[1]/i[1]", "Click on Delete icon");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
