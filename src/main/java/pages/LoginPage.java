package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username,String password) throws InterruptedException {
		
		System.out.println("Login page "+ username);
		
		driver.get("http://qa.launch-sandbox.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
