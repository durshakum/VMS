package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.sun.jna.platform.linux.XAttr.size_t;

import java.util.*;

import javax.management.ListenerNotFoundException;

import pages.InvokeBrowser;

public class BrokenLinks extends InvokeBrowser{

	 WebDriver driver;
@Test(enabled=false)
public void hiturl() throws IOException { 

	 driver = getDriver();
	 driver.get("https://www.google.com");
	 List<WebElement> elements= driver.findElements(By.tagName("a"));
	 for(WebElement ele:elements) {
		 String url = ele.getAttribute("href");
		 System.out.println(url);
		 
		 URL link= new URL(url);
		 HttpURLConnection conn =  (HttpURLConnection) link.openConnection();
		 conn.setRequestMethod("HEAD");
		 conn.connect();
		 
		 if(conn.getResponseCode() >=400) {
			 System.out.println("Broken: " + url + " - " + conn.getResponseCode());
		 }
	 }
}

@Test(enabled=false)
public void dynamicWeb() throws InterruptedException {
	 driver = getDriver();
	 driver.get("https://www.google.com");
	 driver.manage().window().maximize();
	 Thread.sleep(30);
	WebElement textBoxElement=driver.findElement(By.xpath("//*[@id='APjFqb']"));
	textBoxElement.click();
	Thread.sleep(10);
	textBoxElement.sendKeys("mum");
	Thread.sleep(10);
	List<WebElement> lst= driver.findElements(By.xpath("//*[@id='Alh6id']/div[1]/div/ul/li"));
	for(WebElement ele:lst) {
		if(ele.getText().contains("Mumbai")) {
			System.out.println(ele.getText());
			ele.click();
		}
	}
	Thread.sleep(20);
	
}
@Test
public void name() throws InterruptedException {
	 driver = getDriver();
	 driver.get("https://www.google.com");
	 driver.manage().window().maximize();
	 String parentWindow = driver.getWindowHandle();
	 System.out.println("Parent Window    "+parentWindow);
	 driver.switchTo().newWindow(WindowType.WINDOW);
	 driver.switchTo().newWindow(WindowType.TAB);
	 Thread.sleep(3);
	 driver.switchTo().newWindow(WindowType.TAB);
	 Thread.sleep(10);
	 Set<String> handleSet =driver.getWindowHandles();
	 System.out.println("Size of window is "+handleSet.size());
	 Iterator iterator = handleSet.iterator();
	 while(iterator.hasNext()) {
		 Thread.sleep(20);
		 System.out.println("Title is  "+driver.getTitle());
		 String ws= (String) iterator.next();
		 System.out.println("Window handle is "+ws);
		 if(ws.equals(parentWindow)) {
			 driver.switchTo().window(parentWindow);
			 System.out.println("Parent Window Title is "+driver.getTitle());
		 }
		}
	
}
	
}
