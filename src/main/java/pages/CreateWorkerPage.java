package pages;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import data.ExcelData;

public class CreateWorkerPage {
	public WebDriver driver;
	String workerFname = "//*[@id='firstName']";
	String workerMname = "//*[@id='middleName']";
	String workerLname = "//*[@id='lastName']";
	String email = "//*[@id='email']";
	String homeAdd = "//*[@id='address_1']";
	String submit = "//button[@type='submit']";
	ExcelData ex = new ExcelData();
	
	public CreateWorkerPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public String createWorker() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='navbar']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='navbar']/ul/li[4]/ul/li[4]")).click();
		Thread.sleep(10000);
		System.out.println("Into worker Page");
//		System.out.println(driver);
		Thread.sleep(3000);
		Faker faker = new Faker();
		String fname = faker.name().firstName();
		String mname = faker.name().nameWithMiddle();
		String lname = faker.name().lastName();
		String emailId = faker.internet().emailAddress();
		String city = faker.address().cityName();
		driver.findElement(By.xpath(workerFname)).sendKeys(fname);
		
		
		
		driver.findElement(By.xpath(workerMname)).sendKeys(mname);

		driver.findElement(By.xpath(workerLname)).sendKeys(lname);
		driver.findElement(By.xpath(email)).sendKeys(emailId);
		
		driver.findElement(By.xpath(homeAdd)).sendKeys(city);
		
		driver.findElement(By.xpath(submit)).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

	return driver.getTitle();


	}

}
