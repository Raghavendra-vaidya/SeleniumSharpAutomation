package org.rvaidya.utilities.excelUtilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelFile {
    public static synchronized Workbook loadFileAndGetWorkbook(String filePath) {
        Workbook workbook = null;
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static synchronized Sheet loadFileAndGetSheet(String filePath, String sheetName) {
        Sheet sheet = null;
        try {
            Workbook workbook = loadFileAndGetWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheet;
    }

    public static synchronized Row getEntireRowFromSheet(String filePath, String sheetName, int rindex) {
        Row requiredRow = null;
        try {
            Sheet sheet = loadFileAndGetSheet(filePath, sheetName);
            requiredRow = sheet.getRow(rindex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requiredRow;
    }

    public static synchronized Cell getCellFromSheet(String filePath, String sheetName, int rIndex, int cIndex) {
        Cell requiredCell = null;
        try {
            Row row = getEntireRowFromSheet(filePath, sheetName, rIndex);
            requiredCell = row.getCell(cIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requiredCell;
    }
    
    public synchronized static String getDataFromCell(String filePath, String sheetName, int rIndex, int cIndex) {
        String data = null;
        try {
            Cell cell = getCellFromSheet(filePath, sheetName, rIndex, cIndex);
            data = new DataFormatter().formatCellValue(cell);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public synchronized static ArrayList<String> getAllCellDataFromRow(String filePath, String sheetName, int rIndex {
        ArrayList<String> data = null;
        try {
            Row row = getEntireRowFromSheet(filePath,sheetName,rIndex);
            row.forEach(cell -> data.add(new DataFormatter().formatCellValue(cell)) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
