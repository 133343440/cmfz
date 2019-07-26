package com.baizhi;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class TestSalt {
    @Test
    public void m1(){
        Md5Hash qwer = new Md5Hash("123456", "qwer", 1024);
        String s = qwer.toHex();
        System.out.println(s);
    }
}
