package com.baizhi;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCe {
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        List<Admin> admins = adminService.queryAll();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
    @Test
    public void test2(){
        Admin admin = adminService.queryOne("1", "1");
        System.out.println(admin);
    }
    @Test
    public  void test3(){
        adminService.add(new Admin(UUID.randomUUID().toString(),"1","1"));
    }
}
