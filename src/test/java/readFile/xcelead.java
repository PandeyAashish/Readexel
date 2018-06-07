package readFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xcelead {

	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir") + "/src/main/resources/xcelfile";
		String fileConfigPath = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";
		System.out.println(filePath);
		String valueToWrite[] = {"Mr. Ashish" ,"005" ," Test Analyst","Pending Submission"};
		writeData(filePath , "ExcelXLSX.xlsx" , "EmployeeData" , valueToWrite );
		readexceldata(filePath, "ExcelXLSX.xlsx", "EmployeeData");

	}

	public static void readexceldata(String filePath, String FileName, String Filesheet) throws IOException {

		File file = new File(filePath + "/" + FileName);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtension = FileName.substring(FileName.indexOf("."));
		if (fileExtension.equals(".xls")) {

			workbook = new HSSFWorkbook(fis);

		} else if (fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(fis);
		}

		Sheet sheet = workbook.getSheet(Filesheet);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(rowcount);
		for (int i = 0; i <= rowcount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue() + "||");

			}

			System.out.println();

		}

	}

	public static void writeData(String filePath, String filename, String sheetname, String[] dataToWrite)
			throws IOException {

		File file = new File(filePath + "/" + filename);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtension = filename.substring(filename.indexOf("."));
		if (fileExtension.equals(".xls")) {

			workbook = new HSSFWorkbook(fis);

		} else if (fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(fis);

		}
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);
			fis.close();
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();

		}

	}

}
