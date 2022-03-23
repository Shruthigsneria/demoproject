package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAndLogoutTest {
	@Test
	public void loginlogoutscript() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = null;

		String browser = System.getProperty("browser");

		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = System.getProperty("url");
		driver.get(url);

		String username = System.getProperty("username");
		driver.findElement(By.name("user_name")).sendKeys(username);

		String password = System.getProperty("password");
		driver.findElement(By.name("user_password")).sendKeys(password);

		driver.findElement(By.id("submitButton")).click();

		Actions action = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		action.moveToElement(logout).perform();

		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
