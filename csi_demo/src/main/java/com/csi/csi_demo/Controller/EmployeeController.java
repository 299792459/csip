package com.csi.csi_demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csi.csi_demo.Service.EmployeeService;
import com.csi.csi_demo.pojo.Employee;
import com.csi.csi_demo.utils.CsiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/add")
    public CsiResult add(@RequestParam(value="employee")Employee employee){

        //根据前台传过来的employee添加
        try {
            employeeService.save(employee);
        }catch (Exception e){
            e.printStackTrace();
        }

        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);

        return cr;
    }
    @RequestMapping("/update")
    public CsiResult update_id(@RequestParam(value="employee")Employee employee,@RequestParam(value="id")int id){
        //根据前台传过来的id修改对应employee
        try {
            employee.setId(id);
            employeeService.updateById(employee);
        }catch (Exception e){
            e.printStackTrace();
        }

        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);

        return cr;
    }
    @RequestMapping("/delete")
    public CsiResult delete_batch(@RequestParam(value="idlist")List idlist){

        //根据前台传过来的idlist删除对应employee
        try {
            employeeService.removeByIds(idlist);
        }catch (Exception e){
            e.printStackTrace();
        }
        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);
        return cr;
    }

    @RequestMapping("/select/query")
    public CsiResult select_query(@RequestParam(value="employeename",defaultValue="0")String employeename,@RequestParam(value="status")Integer status){

        //条件构造器
        QueryWrapper<Employee> qwu=new QueryWrapper<>();
        //如果没有勾选status
        if(status==null)
        {

            qwu.like("employeename","employeename");
            //通过条件构造器查询得到返回列表
            List<Employee> lu=employeeService.list(qwu);
            //输出验证
            System.out.println(lu.get(0).toString());
            //组装返回对象
            //对象，返回信息，状态码
            CsiResult cr=new CsiResult(lu,"ok",1);

            return cr;
        }
        //勾选了状态则添加状态的查询
        qwu.like("employeename","employeename").eq("status",status);
        //通过条件构造器查询得到返回列表
        List<Employee> lu=employeeService.list(qwu);
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
        Employee employee=employeeService.getById(id);
        //输出验证
        System.out.println(employee.toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(employee,"ok",1);

        return cr;
    }

    @RequestMapping("/select/all")
    public CsiResult select_all(){

        //条件构造器
        QueryWrapper<Employee> qwu=new QueryWrapper<>();
        //通过条件构造器查询得到返回列表
        List<Employee> lu=employeeService.list(qwu);
        //输出验证
        System.out.println(lu.get(0).toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(lu,"ok",1);

        return cr;
    }
}
