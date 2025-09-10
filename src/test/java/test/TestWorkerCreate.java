package test;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import data.DataExcel;
import pages.CreateWorkerPage;
import pages.InvokeBrowser;
import pages.LoginPage;
import utils.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class TestWorkerCreate extends InvokeBrowser{
	
	
	public String workerTitle;
//	@Test(dataProviderClass = DataExcel.class,dataProvider = "oneRowPerThread", threadPoolSize = 2, invocationCount = 2, singleThreaded = false)
	@Test(dataProviderClass = DataExcel.class,dataProvider = "oneRowPerThread")
	public void workerCreate(Map<String, String> rowData) throws Exception  {

		
    	LoginPage page = new LoginPage(getDriver());
		
		String uName = rowData.get("username");
        String pwd = rowData.get("password");
        System.out.println(Thread.activeCount());
        System.out.println("Thread: " + Thread.currentThread().getId() + " - Worker username: " + uName);
        System.out.println("Thread: " + Thread.currentThread().getId() + " - Worker Password: " + pwd);
        page.login(uName, pwd);
		CreateWorkerPage csp = new CreateWorkerPage(driver);
		workerTitle = csp.createWorker();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(workerTitle, "Launch VMS - View Worker Details");//		Launch VMS - View Supplier Details
		softassert.assertAll();
	}


	
}
