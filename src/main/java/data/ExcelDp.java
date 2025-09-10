package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDp {

	public static String excelling() throws IOException {
	
		String newData = null;
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\admin\\eclipse-workspace\\selenium-java\\src\\test\\resources\\data\\testdata.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();
			Object data[][] = new Object[rowCount - 1][colCount];
			

			for (int i = 1; i < rowCount; i++) {
					Hashtable<String, String> rowData = new Hashtable<>();

					Row rows = sheet.getRow(i);

					if (rows != null) {

						for (int j = 0; j < colCount; j++) {
							Cell cell = rows.getCell(j);
							if (cell != null) {
								
								
								data[i - 1][j] = cell.getStringCellValue();
//								String newData = (String) data[i - 1][j];
								newData = (String) Arrays.deepToString(data);


							}
							else {
								data[i-1] [j]= "";
								
							}
						}
					}

				}
		
				System.out.println("Array data is  "+newData);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return newData; 
			
	}
	
	public static void main(String[] args) throws IOException {

		excelling();
	}

}