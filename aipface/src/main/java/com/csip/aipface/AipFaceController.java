package com.csip.aipface;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/aipface")
@EnableAutoConfiguration
@CrossOrigin
public class AipFaceController {



    String imgpath="D:\\img\\me.jpg";
    String image64 = "";
    String imageType = "BASE64";
    String groupId = "myfacedb";
    String userId = "cj3";

    @Autowired
    AipFaceClienSingle afcs;



    @RequestMapping("/add")
    public String add(@RequestParam(value = "base")String base){

        JSONObject res1=new JSONObject();
        JSONObject res2=new JSONObject();
        try {
            res1=afcs.getaipfaceclient().detect(base,imageType,null);
            //System.out.println(res.get("error_code"));
            System.out.println(res1.toString());

            System.out.println(res1.get("error_msg").toString());
            if(!res1.get("error_msg").toString().equals("SUCCESS"))
            {
                System.out.println("识别结果非人脸");
                return "nook";
            }
            res2=afcs.getaipfaceclient().addUser(base,imageType,groupId,userId,null);

            if(!res2.get("error_msg").toString().equals("SUCCESS"))
            {
                System.out.println("注册失败");
                return "nook";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("注册成功");
        return "ok";
    }

    @RequestMapping("/update")
    public String update(){

        try {
            JSONObject res=afcs.getaipfaceclient().updateUser(image64,imageType,groupId,userId,null);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "res";
    }

    @RequestMapping("/detect")
    public String detect(String base){

        //image64=new ImgToBase64().ImageToBase64(imgpath);
        JSONObject res=new JSONObject();
        try {
            res=afcs.getaipfaceclient().detect(base,imageType,null);
            //System.out.println(res.get("error_code"));
            System.out.println(res.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        return res.get("error_code").toString();
    }

    @RequestMapping("/search")
    public String search(@RequestParam(value = "base")String base){

        try {
            JSONObject res=afcs.getaipfaceclient().search(base, imageType, groupId, null);
            if(!res.get("error_code").toString().equals("0"))
            {
                System.out.println("登陆失败");
                return "nook";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("登陆成功");
        return "ok";
    }



}
