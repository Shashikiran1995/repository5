package com.tp.vTiger.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetname,int rowno,int cellno) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("./testScriptData/vTiger_testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue().toString();
		return data;
	}

}
