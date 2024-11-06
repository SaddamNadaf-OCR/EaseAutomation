package authorizationManagementScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleLogin {
	
	@Test
	public void login() throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "D:\\SELENIUM_SCRIPTS\\EaseAutomation\\drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://easetest.ocr-inc.com/user/loginDefault.ocr");
		Thread.sleep(3000);
		
		WebElement username= driver.findElement(By.id("login_username"));
		System.out.println(username);
		username.sendKeys("saddam");
		WebElement password=driver.findElement(By.id("login_password"));
		System.out.println(password);
		password.sendKeys("123");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		driver.quit();
	}

}
