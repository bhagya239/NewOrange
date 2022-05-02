package com.CyberSuccess;

import java.io.FileNotFoundException;

public class TestCode {

	public static void main(String[] args) throws FileNotFoundException {
			
		ExcelUtil util=new ExcelUtil();
		
		String filePath="C://CyberSuccess//Java_Selenium_Nov_Batch//InputTestData.xlsx";
		
		util.writeDataInExcel(filePath, 0, 0, "");

	}

}
