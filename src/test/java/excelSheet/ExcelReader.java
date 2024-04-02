package excelSheet;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook work = new XSSFWorkbook();
	XSSFSheet sheet;
	public ExcelReader(String XLFilePath) {
		try {
		File name = new File(XLFilePath);
		FileInputStream fis = new FileInputStream(name);
		work = new XSSFWorkbook(fis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getCellData(int Sheet1,int row, int cell) {
		System.out.println(Sheet1+" "+row+" "+cell);
		sheet= work.getSheetAt(Sheet1);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	public int getrowcount(int sheetindex) {
		int row = work.getSheetAt(0).getLastRowNum();
		return row;

	}

}
