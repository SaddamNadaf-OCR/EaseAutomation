package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ResultProductSubComponentPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddProductSubComponent = "//button[contains(text(),'Add Product Sub Component')]";


	/* ******************** Constructor ***************************** */
	public ResultProductSubComponentPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}

	public void click_addprodsubcomp() {
		clickElement(driver, test,  OCR_Button_AddProductSubComponent, "Click on ADD Product subcomponent Button");
	}

	public void moveto_hazmat() {
    clickElement(driver, test,"//a[contains(text(),'HAZMAT')]","Clicking on Hazmat Tab");
	}
}
