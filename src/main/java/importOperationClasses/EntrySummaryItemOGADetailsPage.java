package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class EntrySummaryItemOGADetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "//li[@class='dropdown sbu-list']";
	

	/* ******************** Constructor ***************************** */

	public EntrySummaryItemOGADetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	
}
