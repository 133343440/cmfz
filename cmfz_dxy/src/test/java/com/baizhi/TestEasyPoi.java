package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEasyPoi {
    @Autowired
    private UserService service;
    @Test
    public  void test1() throws IOException {
        List<User> users = service.queryAll();
        for (User user : users) {
             user.setProfile("src/main/webapp/img/1.png");
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("所有用户","用户表"),
                User.class, users);
        workbook.write(new FileOutputStream("F:第一个EasyPOIExcel文档.xls"));
        workbook.close();
    }
}
