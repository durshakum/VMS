package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateSupplierPage {
	
	public WebDriver driver;
	String navigation1 = "//*[@id='navbar']/ul/li[4]/a";
	String navigation2 = "//*[@id='navbar']/ul/li[4]/ul/li[5]";
	String supplierName = "//*[@id='supplierName']";
	String activeStatus = "//*[@id='activeStatus']";
	String statusSel = "//*[@id='activeStatus']/option[2]";
	String submit = "//button[@type='submit']";
	

	
	public CreateSupplierPage(WebDriver driver) {
		this.driver = driver;
		
		
	}
   
	public String createSupplier() throws InterruptedException,Exception {
		System.out.println("Into Supplier Page");
		System.out.println(driver);
		Thread.sleep(3000);
		try {
		driver.findElement(By.xpath("//*[@id='navbar']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='navbar']/ul/li[4]/ul/li[5]")).click();
		Thread.sleep(10000);
		
		Faker faker = new Faker(); 
		String firstName = faker.name().firstName();
	    System.out.println("First Name: " + firstName);
	    String cellPhoneNumber = faker.phoneNumber().cellPhone();
	    System.out.println("Cell Phone Number: " + cellPhoneNumber);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(supplierName)).sendKeys(firstName);
	    driver.findElement(By.xpath(activeStatus)).click();
	    driver.findElement(By.xpath(statusSel)).click();
	    driver.findElement(By.xpath(submit)).click();
	    Thread.sleep(3000);
	    System.out.println(driver.getTitle());
		} catch(Exception e) {
			
			System.out.println(e);
		}
		return driver.getTitle();
	}
}
