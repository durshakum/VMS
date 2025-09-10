package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;


public class DataExcel {
	
	
	

    @DataProvider(name = "oneRowPerThread")
    public Object[][] excelling(Method method) throws IOException {
        String filePath = "C:\\Users\\admin\\eclipse-workspace\\selenium-java\\src\\test\\resources\\data\\testdata.xlsx";

        List<Map<String, String>> allRows = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            // Read headers
            Row headerRow = sheet.getRow(0);
            String[] headers = new String[colCount];
            for (int j = 0; j < colCount; j++) {
                headers[j] = formatter.formatCellValue(headerRow.getCell(j));
            }

            // Read data rows into Hashtable
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowData = new Hashtable<>();
                for (int j = 0; j < colCount; j++) {
                    String value = formatter.formatCellValue(row != null ? row.getCell(j) : null);
                    rowData.put(headers[j], value);
                }
                allRows.add(rowData);
            }
        }


			
		
        // Convert list to Object[][] for TestNG
//        Object[][] data = new Object[allRows.size()][1];
//        for (int i = 0; i < allRows.size(); i++) {
//            data[i][0] = allRows.get(i);
//        }
      //System.out.println(allRows.get(2).get("username"));
//      return data;
        
     
		// Assign 1st row to supplierCreate and 2nd row to workerCreate, can add more if needed
        if ("supplierCreate".equals(method.getName())) {
            return new Object[][] { { allRows.get(0) } }; // First row user
        } else if ("workerCreate".equals(method.getName())) {
            return new Object[][] { { allRows.get(1) } }; // Second row user
        } else {
            // Default return all users or throw Exception as needed 
            return null;
    
        }
        
        

    }

//    @Test(dataProvider = "oneRowPerThread", threadPoolSize = 5, invocationCount = 5, singleThreaded = false)
//    public void testingData(Hashtable<String, String> rowData) {
//        String mName = rowData.get("Middlename");
//        String address = rowData.get("Address");
//
//        System.out.println("Thread: " + Thread.currentThread().getId() + " - Middlename: " + mName);
//        System.out.println("Thread: " + Thread.currentThread().getId() + " - Address: " + address);
//    }
}
