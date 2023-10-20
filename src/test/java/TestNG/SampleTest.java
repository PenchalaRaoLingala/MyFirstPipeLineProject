package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("https://demo.guru99.com/V4/index.php");
		driver.findElement(By.name("uid")).sendKeys("mngr532098");
		driver.findElement(By.name("password")).sendKeys("mebApUg");
		driver.findElement(By.name("btnLogin")).click();

		System.out.println(driver.getTitle());

		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage", "Logged in successfully");

	}
	@BeforeTest
	//This method will execute before the test method
	public void beforeTest() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
