package com.baizhi.controller;

import com.baizhi.dto.CarouselPageDto;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Carousel;
import com.baizhi.service.AdminService;
import com.baizhi.service.CarouselService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("p1")
public class controller {
    @Autowired
    private CarouselService service1;
    @Autowired
    private AdminService service;
    @RequestMapping("login")
    public String login(Admin admin){
        //获取主题
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken authenticationToken = new UsernamePasswordToken(admin.getUsername(),admin.getPassword());
        try {
            subject.login(authenticationToken);
            return "jsp/main";
        } catch (UnknownAccountException e) {
            System.out.println("账号不正确");
            return "jsp/login";
        }catch (IncorrectCredentialsException i){
            System.out.println("密码不正确");
            return "jsp/login";
        }
    }


    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "jsp/login";
    }


    @RequestMapping("queryByPage")
    @ResponseBody
    public CarouselPageDto queryByPage(Integer page,Integer rows){
    return service1.queryAllByPage(page,rows);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(Carousel carousel, String oper,String[] id) throws IOException {
        if("add".equals(oper)) {

            String s = service1.insert(carousel);
            return s;
        }else if("edit".equals(oper)) {

            String s = service1.update(carousel);
            return s;
        } else
            if(id!=null){
                for (String s : id) {
                    service1.delete(s);
                }
            }
        return null;

    }
@ResponseBody
@RequestMapping("upload")
    public void fileiupload(MultipartFile imgPath, String id, HttpServletRequest request , HttpServletResponse response) {

                String filename = imgPath.getOriginalFilename();
                 if(!(filename==null||"".equals(filename))) {
                String path = request.getSession().getServletContext().getRealPath("upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdir();
                }
                try {
                    //修改数据库路径
                    imgPath.transferTo(new File(path, filename));
                    Carousel carousel = new Carousel();
                    carousel.setId(id);
                    carousel.setImgPath(filename);
                    service1.modifyImgPath(carousel);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
    }
}
