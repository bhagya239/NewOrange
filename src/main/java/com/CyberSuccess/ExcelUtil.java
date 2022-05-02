package com.CyberSuccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static final String filePath = "C://CyberSuccess//Java_Selenium_Nov_Batch//InputTestData.xlsx";

	Workbook wb;
	Sheet sheet;
	Row row;
	Cell cell;
	Object[][] cellData = null;

	/**
	 * 
	 * This method will return the extension of the provided file
	 */
	private String getFileExtension(String filePath) {

		return filePath.substring(filePath.indexOf("."));

	}

	/**
	 * 
	 * This method will return object of two dimensional array of excel file data
	 */
	@SuppressWarnings("null")
	public Object[][] getExcelData() throws IOException {

		FileInputStream input;

		try {
			input = new FileInputStream(filePath);

			if (getFileExtension(filePath).equals(".xlsx")) {

				wb = new XSSFWorkbook(input);
			} else {

				wb = new HSSFWorkbook(input);
			}

			sheet = wb.getSheet("Sheet3");
			row = sheet.getRow(0);

			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalColumns = row.getPhysicalNumberOfCells();

			cellData = new Object[totalRows][totalColumns];

			for (int i = 0; i <= totalRows - 1; i++) {

				for (int j = 0; j <= totalColumns - 1; j++) {

					cell = sheet.getRow(i).getCell(j);
//					cellData[i][j]=	getCellData(cell.getCellType(),i,j) ;

					switch (cell.getCellType()) {

					case STRING:

						cellData[i][j] = cell.getStringCellValue();

						break;
					case NUMERIC:

						cellData[i][j] = cell.getNumericCellValue();
						break;

					case BLANK:
						cellData[i][j] = null;
						break;

					case BOOLEAN:

						cellData[i][j] = cell.getBooleanCellValue();
						break;

					case ERROR:

						cellData[i][j] = cell.getErrorCellValue();
						break;

					case FORMULA:

						cellData[i][j] = cell.getCellFormula();
						break;

					case _NONE:

						cellData[i][j] = null;
						break;
					}

				}

			}
		} catch (IOException e) {
		} finally {
			wb.close();
		}
		return cellData;
	}

	public void writeDataInExcel(String filePath, int rowIndex, int cellIndex, Object setValue)
			throws FileNotFoundException {

		FileInputStream input = new FileInputStream(filePath);

		try {

			if (getFileExtension(filePath).equals(".xlsx")) {

				wb = new XSSFWorkbook(input);
			} else {

				wb = new HSSFWorkbook(input);
			}
			
			sheet=(wb.getSheet("TestInputData")!=null)?  wb.getSheet("TestInputData"):wb.createSheet("TestInputData");
			
			row= (sheet.getRow(rowIndex)!=null)?sheet.getRow(rowIndex): sheet.createRow(rowIndex);

			if (setValue instanceof String) {

				row.createCell(cellIndex).setCellValue(setValue.toString());
			} else if (setValue instanceof Integer) {

				row.createCell(cellIndex).setCellValue((int) setValue);

			} else if (setValue.toString().isEmpty()) {

				row.createCell(cellIndex).setCellValue(" ");

			}
			FileOutputStream output = new FileOutputStream(filePath);

			wb.write(output);

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
