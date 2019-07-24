package com.baizhi;

import com.baizhi.entity.User;
import javafx.concurrent.Worker;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class TestPOIImport  {
    @Test
    public void test1(MultipartFile file) throws IOException {
        //创建excel文件
        Workbook workbook = new HSSFWorkbook(file.getInputStream());
        //获取第一个表
        Sheet sheet = workbook.createSheet("第一张表");
        //获取一共有多少行
        int lastRowNum = sheet.getLastRowNum();
        //创建一个集合去接收
        List<User> list = new ArrayList<>();
        //遍历行数
        for (int i = 0; i < lastRowNum; i++) {
            User user = new User();
            Row row = sheet.getRow(i + 1);
            Cell cell = row.getCell(0);
            String id = cell.getStringCellValue();
            user.setId(id);
            Cell cell1 = row.getCell(1);
            user.setPhone(cell1.getStringCellValue());
            Cell cell2 = row.getCell(2);
            user.setPassword(cell2.getStringCellValue());
            Cell cell3 = row.getCell(3);
            user.setDharmaName(cell3.getStringCellValue());
            Cell cell4 = row.getCell(4);
            user.setProvince(cell4.getStringCellValue());
            Cell cell5 = row.getCell(5);
            user.setCity(cell5.getStringCellValue());
            Cell cell6 = row.getCell(6);
            user.setGender(cell6.getStringCellValue());
            Cell cell7 = row.getCell(7);
            user.setPersonalSign(cell7.getStringCellValue());
            Cell cell8 = row.getCell(8);
            user.setProfile(cell8.getStringCellValue());
            Cell cell9 = row.getCell(9);
            user.setStatus(cell9.getStringCellValue());
            Cell cell10 = row.getCell(10);
            user.setRegistTime(cell10.getDateCellValue());
            list.add(user);
        }
        workbook.write(new FileOutputStream("F://testPOI/第一个excel文档.xls"));
        for (User user : list) {
            System.out.println(user);
        }

    }
}
