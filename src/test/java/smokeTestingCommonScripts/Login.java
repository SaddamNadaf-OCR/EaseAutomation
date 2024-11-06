package smokeTestingCommonScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","D:\\WCT\\EaseAutomation\\drivers\\chromedriver.exe"); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://easedev.ocr-inc.com/");
	}

}
