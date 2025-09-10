package test;
import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import data.DataExcel;
import utils.ExtentReportListener;
import pages.CreateSupplierPage;
import pages.InvokeBrowser;
import pages.LoginPage;


@Listeners(ExtentReportListener.class)
public class TestSupplierCreate extends InvokeBrowser{
	
	
	@Test(dataProviderClass = DataExcel.class,dataProvider = "oneRowPerThread")
	public void supplierCreate(Hashtable<String, String> rowData) throws Exception  {
		
	 	LoginPage page = new LoginPage(getDriver());
		
		
			String uName = rowData.get("username");
	        String pwd = rowData.get("password");
	        
	        System.out.println("Thread: " + Thread.currentThread().getId() + " - Supplier username: " + uName);
	        System.out.println("Thread: " + Thread.currentThread().getId() + " - Supplier Password: " + pwd);
	        page.login(uName, pwd);
		
		CreateSupplierPage csp = new CreateSupplierPage(driver);
		String actTitle = csp.createSupplier();
		SoftAssert sassert =  new SoftAssert();
		sassert.assertEquals(actTitle, "Launch VMS - View Supplier Detail");
		sassert.assertAll();

//		Launch VMS - View Supplier Details
	}

	
}
