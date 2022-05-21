package com.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName ExcelReadTest
 * @Description
 * @Author alms
 * @Data 2022/5/19 20:12
 **/
public class ExcelReadTest {
    String path = "D:\\Github-alms\\Road_To_Learning\\excel_demo";

    @Test
    public void testRead03() throws IOException {
        FileInputStream inputStream = new FileInputStream(path + "03.xls");

        Workbook workbook = new HSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        var celltype =cell.getCellType();
        System.out.println(cell.getStringCellValue());

        inputStream.close();
    }
}
