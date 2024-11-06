package consignees;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class EditConsigneePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_Consignee_overrideDenyButton="(//button[@type='button'])[6]";
	
	/* ******************** Constructor ***************************** */

	public EditConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickonDeny() {
		clickElement(driver, test, OCR_Consignee_overrideDenyButton, "....");
	}

}
