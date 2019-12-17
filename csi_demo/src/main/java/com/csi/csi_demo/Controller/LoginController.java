package com.csi.csi_demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/18 0018
 * @since 1.0.0
 */
@RestController
//@RequestMapping("/")
public class LoginController {


    //@CrossOrigin
    @RequestMapping("/loginmain")
    public String login(@RequestParam(value = "loginname")String loginname,@RequestParam(value = "password")String password){

        System.out.println(loginname+password);
        return "ok";
    }

    //public ModelAndView
}
