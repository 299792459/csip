package com.csi.csi_demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csi.csi_demo.Service.DocumentService;
import com.csi.csi_demo.pojo.Document;
import com.csi.csi_demo.utils.CsiResult;
import com.csi.csi_demo.utils.Fileop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/document")
@CrossOrigin
public class DocumentController {



    @Autowired
    DocumentService documentService;

    @Autowired
    Fileop fop;

    @RequestMapping("/add")
    public CsiResult add(@RequestParam(value="documentupload")Document document,@RequestParam("file") MultipartFile file){

        //根据前台传过来的document添加
        try {
            documentService.save(document);
            //上传文件
            fop.fileUpload(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);

        return cr;
    }
    @RequestMapping("/update")
    public CsiResult update_id(@RequestParam(value="document")Document document,@RequestParam(value="id")int id){
        //根据前台传过来的id修改对应document
        try {
            document.setId(id);
            documentService.updateById(document);
        }catch (Exception e){
            e.printStackTrace();
        }

        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);

        return cr;
    }
    @RequestMapping("/delete")
    public CsiResult delete_batch(@RequestParam(value="idlist")List idlist){

        //根据前台传过来的idlist删除对应document
        try {
            documentService.removeByIds(idlist);
        }catch (Exception e){
            e.printStackTrace();
        }
        //组装返回值
        CsiResult cr=new CsiResult(null,"ok",1);
        return cr;
    }

    @RequestMapping("/select/query")
    public CsiResult select_query(@RequestParam(value="documentname",defaultValue="0")String documentname,@RequestParam(value="status")Integer status){

        //条件构造器
        QueryWrapper<Document> qwu=new QueryWrapper<>();
        //如果没有勾选status
        if(status==null)
        {

            qwu.like("documentname","documentname");
            //通过条件构造器查询得到返回列表
            List<Document> lu=documentService.list(qwu);
            //输出验证
            System.out.println(lu.get(0).toString());
            //组装返回对象
            //对象，返回信息，状态码
            CsiResult cr=new CsiResult(lu,"ok",1);

            return cr;
        }
        //勾选了状态则添加状态的查询
        qwu.like("documentname","documentname").eq("status",status);
        //通过条件构造器查询得到返回列表
        List<Document> lu=documentService.list(qwu);
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
        Document document=documentService.getById(id);
        //输出验证
        System.out.println(document.toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(document,"ok",1);

        return cr;
    }

    @RequestMapping("/select/all")
    public CsiResult select_all(){

        //条件构造器
        QueryWrapper<Document> qwu=new QueryWrapper<>();
        //通过条件构造器查询得到返回列表
        List<Document> lu=documentService.list(qwu);
        //输出验证
        System.out.println(lu.get(0).toString());
        //组装返回对象
        //对象，返回信息，状态码
        CsiResult cr=new CsiResult(lu,"ok",1);

        return cr;
    }
}
