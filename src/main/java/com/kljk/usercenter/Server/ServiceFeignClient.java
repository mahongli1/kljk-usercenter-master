package com.kljk.usercenter.Server;
import com.kljk.usercenter.entity.Users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@Component
@FeignClient( name = "db-server",url = "106.54.157.101:9115/")
public interface ServiceFeignClient {
    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/db/login")
Users Login(@RequestParam("username") String username, @RequestParam("password") String password);
    /**
     * 判断用户是否存在
     * @param users
     * @return
     */
    @RequestMapping(value = "/db/registerone" )
    Map UserRregisterOne(Users users);
    /**
     * 用户注册
     * @param users
     * @return
     */
    @RequestMapping(value = "/db/register")
    int UserRregister(Users users);


    @RequestMapping(value = "/db/status")
   int UserStatus(@RequestParam("id") int id,@RequestParam("status") int status);
}
