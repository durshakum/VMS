package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshots{
	
	public WebDriver driver;
	
	public Screenshots(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String pageScreenshot() throws IOException {
		LocalDateTime  d = LocalDateTime.now();
	    DateTimeFormatter ff = DateTimeFormatter.ofPattern("yyyy-mm-dd HHMMSS");
		System.out.println("Into Screenshots");
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String desPath  =System.getProperty("user.dir")+"\\test-output\\screenshots\\image"+"_"+(d.format(ff))+".png" ;
//		System.out.println("Destiniation path is "+desPath);
		FileUtils.copyFile(file,new File(desPath));
		return desPath;
	}

}
