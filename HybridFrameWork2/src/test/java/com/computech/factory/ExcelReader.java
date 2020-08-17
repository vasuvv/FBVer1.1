package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	public ExcelReader() {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"\\TestData\\ProjectData.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public ExcelReader(String XLfileName) {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(XLfileName)));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void demo() {
		
	}
	public int getRowCount(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	public int getColumCount(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	public int getColumCount(String sheetName, int rowNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getPhysicalNumberOfCells();
	}
	public String getStringData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public String getStringData(int sheetIndex, int rowNo, int colNo) {
		return wb.getSheetAt(sheetIndex).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public double getDoubleData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public int getIntegerData(String sheetName, int rowNo, int colNo) {
		return (int)wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public boolean getBooleanData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getBooleanCellValue();
	}
}
