package com.kljk.usercenter.controller;
import com.kljk.usercenter.Server.ServiceFeignClient;
import com.kljk.usercenter.entity.Users;
import feign.Param;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private ServiceFeignClient serviceFeignClient;
    @Autowired
    private HttpSession session;
    @GetMapping ("login")
    @ApiOperation(value = "用户登陆")
    public  Object login(@RequestParam String username, @RequestParam String password){

        Users user=  serviceFeignClient.Login(username,password);
    Map<String,Object> maps=new HashMap<String,Object>();
    if (username==null){
        maps.put("msg","用户名不能为空");
        return maps;
    }else if (password==null)
    {maps.put("msg","密码不能为空");
    return maps;
    }else {
        if (user==null){
            maps.put("msg","用户名密码错误");
            maps.put("code",0);
            return maps;
        }else {
            if(user.getStatus()==1){
                session.setAttribute("userid",user.getId());
                maps.put("id",session.getAttribute("userid"));
                maps.put("msg","登陆成功");
                maps.put("code",1);
                return maps;
            }else {
                maps.put("msg","已离职");
                maps.put("code",2);
                return maps;
                }
            }
        }
    }
    @GetMapping("register")
    @ApiOperation(value = "用户注册")
    public Object Resigter(@Param("user")  Users users){
            Map map=serviceFeignClient.UserRregisterOne(users);
            Map<String,Object> maps=new HashMap<String,Object>();
            if(users.getUsername()==null){
                maps.put("msg", "用户名不能为空");
                maps.put("code", 0);
                return maps;
            }else {
                if (map != null) {
                    maps.put("msg", "用户已存在");
                    maps.put("code", 0);
                    return maps;
                } else {
                    maps.put("msg", "注册成功");
                    maps.put("code", 1);
                    serviceFeignClient.UserRregister(users);
                    return maps;
                }
            }
    };
    @GetMapping ("status")
    @ApiOperation(value = "改变用户状态")
    public Object UserStatus(@RequestParam("id") int id,@RequestParam("status") int status){
        return serviceFeignClient.UserStatus(id,status);
    };
}
