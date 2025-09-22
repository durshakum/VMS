package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelData {

	public static List<Hashtable<String,String>> excelling() throws IOException {
		List<Hashtable<String,String>> lst = new ArrayList<>();
//		int arr[];
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\admin\\eclipse-workspace\\selenium-java\\src\\test\\resources\\data\\testdata.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();
			String[] headers = new String[colCount];
			Row firstRow = sheet.getRow(0);
			for(int i=0;  i<colCount;i++) {
				
				headers[i] = formatter.formatCellValue(firstRow.getCell(i));
			}
			
			for(int i=1;i<rowCount;i++) {
				Hashtable<String, String> rowData = new Hashtable<>();
				Row row = sheet.getRow(i);
				for(int j=0;j<colCount;j++) {
					
					Cell cell = row.getCell(j);
					String value = formatter.formatCellValue(cell);
					rowData.put(headers[j], value);
					
				}
				lst.add(rowData);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(lst);
			return lst;
		}
			
			
	


	
	public static void getData(Hashtable<String,String> row) throws IOException {
		
		String mName = row.get("Middlename");
		String address = row.get("Address");
		
//		for(Hashtable<String,String> row:excelling()) {
//			
//			System.out.println(row.get("Middlename"));
//		}
//		
		System.out.println(excelling());	
		System.out.println("Thread: " + Thread.currentThread().getId() + " - Middlename: " + mName);
		System.out.println("Thread: " + Thread.currentThread().getId() + " - Address: " + address);
	}

	public static void main(String[] args) throws IOException {

		getData(null);
	}

}
