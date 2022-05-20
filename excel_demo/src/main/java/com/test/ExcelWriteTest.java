package com.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName ExcelWriteTest
 * @Description
 * @Author alms
 * @Data 2022/5/19 18:50
 **/
public class ExcelWriteTest {

    String path = "D:\\Github-alms\\Road_To_Learning\\excel_demo";

    @Test
    public void writeTest03() throws IOException {
        //1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet =workbook.createSheet("狂神统计表");
        //3. 创建一个行
        Row row = sheet.createRow(0);
        //4.创建一个单元格
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("今日新增观众");
        Cell cell12 = row.createCell(1);
        cell12.setCellValue(666);

        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        Cell cell22 = row2.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(s);

        FileOutputStream outputStream = new FileOutputStream(path + "03.xls");
        workbook.write(outputStream);
        outputStream.close();

        System.out.println("03excel生成完毕");
    }
}
