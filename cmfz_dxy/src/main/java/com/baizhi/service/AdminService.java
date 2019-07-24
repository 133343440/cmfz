package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin>queryAll();
    Admin queryOne(String username,String password);
    void add(Admin admin);
}
