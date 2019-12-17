package com.csi.csi_demo.Controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csi.csi_demo.Service.UserService;
import com.csi.csi_demo.mapper.UserMapper;
import com.csi.csi_demo.pojo.User;
import com.csi.csi_demo.utils.CsiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/16 0016
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public CsiResult add(@RequestParam(value="user")User user){

        //根据前台传过来的user添加
        try {
            userService.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);

        return cr;
    }
    @RequestMapping(value = "/update")
    public CsiResult update_id(@RequestParam(value="user")User user,@RequestParam(value="id")int id){
        //根据前台传过来的id修改对应user
        try {
            user.setId(id);
            userService.updateById(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);

        return cr;
    }
    @RequestMapping("/delete")
    public CsiResult delete_id(@RequestParam(value="id")int id){


        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);
        //根据前台传过来的id删除对应user
        try {
            userService.removeById(id);
        }catch (Exception e){
            //组装返回值
            cr=new CsiResult(null,"nook",1);
            e.printStackTrace();

        }

        return cr;
    }

    @RequestMapping("/select/query")
    public CsiResult select_query(@RequestParam(value="username",defaultValue="0")String username,@RequestParam(value="status")Integer status){

        //条件构造器
        QueryWrapper<User> qwu=new QueryWrapper<>();
        //如果没有勾选status
        if(status==null)
        {

            qwu.like("username","username");
            //通过条件构造器查询得到返回列表
            List<User> lu=userService.list(qwu);
            //输出验证
            System.out.println(lu.get(0).toString());
            //组装返回对象
            //对象，返回信息，状态码
            CsiResult cr=new CsiResult(lu,"ok",1);

            return cr;
        }
        //勾选了状态则添加状态的查询
        qwu.like("username","username").eq("status",status);
        //通过条件构造器查询得到返回列表
        List<User> lu=userService.list(qwu);
        //输出验证
        System.out.println(lu.get(0).toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(lu,"ok",1);

        return cr;
    }

    @RequestMapping("/select/id")
    //value值对应前台的字段
    public CsiResult select_id(@RequestParam(value="id",defaultValue="0")int id){


        //通过id查询得到返回对象
        User user=userService.getById(id);
        //输出验证
        System.out.println(user.toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(user,"ok",1);

        return cr;
    }

    @RequestMapping("/select/all")
    public CsiResult select_all(){

        //条件构造器
        QueryWrapper<User> qwu=new QueryWrapper<>();
        //通过条件构造器查询得到返回列表
        List<User> lu=userService.list(qwu);
        //输出验证
        System.out.println(lu.get(0).toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(lu,"ok",1);

        return cr;
    }

    @RequestMapping("/select/page")
    public CsiResult select_page(@RequestParam(value="page",defaultValue="1")int page,
                                 @RequestParam(value="limit",defaultValue="10")int size){

        //条件构造器
        QueryWrapper<User> qwu=new QueryWrapper<>();

        //通过条件构造器查询得到返回列表
        List<User> lu=userService.list(qwu);

        //分页
        List<User> rlu=lu.subList((page-1)*size,(page-1)*size+size+1);
        //输出验证
        //System.out.println(rlu.get(0).toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(rlu,"ok",1);

        return cr;
    }

    @RequestMapping("/test")
    public List<User> test(){

        //条件构造器
        QueryWrapper<User> qwu=new QueryWrapper<>();
        //通过条件构造器查询得到返回列表
        List<User> lu=userService.list(qwu);

        lu.get(0).setId(0);

        //根据前台传过来的user添加
        try {
            userService.save(lu.get(0));
        }catch (Exception e){
            e.printStackTrace();
        }

        return lu;
    }
}
