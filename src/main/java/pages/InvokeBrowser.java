package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Platform;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;



public class InvokeBrowser{
//	 RemoteWebDriver driver;
	public WebDriver driver;
	
	
	@BeforeClass
	public void browsersetup() throws InterruptedException, MalformedURLException {
		
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\eclipse-workspace\\selenium-java\\msedgedriver.exe");
//		EdgeOptions options = new EdgeOptions();
//		options.setAcceptInsecureCerts(true);
////		options.addArguments("--headless");
//		driver = new EdgeDriver(options);
		
		URL gridUrl = new URL("http://localhost:4444/wd/hub"); // Or the IP/hostname of your hub

        // Define browser options (e.g., ChromeOptions)
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");

        // Add any specific capabilities if needed, e.g., chromeOptions.addArguments("--headless");

        // Instantiate RemoteWebDriver
//        driver = new RemoteWebDriver(gridUrl, chromeOptions);
        driver = new ChromeDriver();
        
        if (driver != null) {
        	System.out.println("Driver object created");
        }
	
//		driver.get("http://qa.launch-sandbox.com");
//		driver.manage().window().maximize();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("qasankar.kumar@yopmail.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Test1234");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();

//		return driver;
	}
	
	
	  public WebDriver getDriver() {
	        return driver;
	    }
@AfterClass
	public void tearDown() {
		driver.close();
	}
}
