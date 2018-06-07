package readFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CocumberTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");
		System.out.println("ets");
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		driver.findElement(By.id("log")).sendKeys("testuser_1");

		driver.findElement(By.id("pwd")).sendKeys("Test@123");

		driver.findElement(By.id("login")).click();

		System.out.println("Login Successfully");

		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		System.out.println("LogOut Successfully");

		driver.quit();

	}

}
