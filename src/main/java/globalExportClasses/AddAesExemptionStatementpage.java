package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddAesExemptionStatementpage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_addesexemptionbutton="//button[@name='Add']";
	public static final String OCR_newsearch="//button[@name='Back']";
	public static final String OCR_save="//button[@name='save.x']";
	public static final String OCR_country="//input[@id='editAesExemptionStatement_countryName']";
	public static final String OCR_exemptioncode="//input[@id='editAesExemptionStatement_aesExemptionStatement_shortDesc']";
	public static final String OCR_exemptiondesc="//textarea[@id='editAesExemptionStatement_aesExemptionStatement_longDesc']";
	public static final String 	OCR_ValidateHeading="//h3[contains(text(),'Edit')]";
	public static final String OCR_HomePage_Files = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePageaesexemption = "(//a[contains(text(),'AES Exemption Statement')])[1]";
	
	/* ******************************* Constructor ****************************** */

	public AddAesExemptionStatementpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
public void exemptiondetails(String Country, String Exemptioncode, String ExemptionDesc) {
	typeText(driver, test, OCR_country, "enter country", Country);
	Wait.waitfor(2);
	typeText(driver, test, OCR_exemptioncode, "enter exemption code", Exemptioncode);
	Wait.waitfor(2);
	typeText(driver, test, OCR_exemptiondesc, "enter exemption description", ExemptionDesc);
	Wait.waitfor(2);
}
public void addexemption() {
	clickElement(driver, test, OCR_addesexemptionbutton, "click on add exemption");
}
	
	public void savebtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_save, "Click on save Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Edit exemption statement page is Displayed");
		Wait.waitfor(3);
		
	}
	// Click on Files
		public void movetoFiles() {
			mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
			Wait.waitfor(3);
			mouseOver(driver, test, OCR_HomePageaesexemption, "mousehover on product");
			clickElement(driver, test, OCR_HomePageaesexemption, "Click on Product");
		}

	}