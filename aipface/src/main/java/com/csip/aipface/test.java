package com.csip.aipface;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/18 0018
 * @since 1.0.0
 */
public class test {

    public static void main(String []args){


        String imgpath="D:\\img\\me.jpg";
        String image64 = "";
        String imageType = "BASE64";
        String groupId = "myfacedb";
        String userId = "cj";



        ImgToBase64 imageToBase64=new ImgToBase64();
        image64=imageToBase64.ImageToBase64(imgpath);

        AipFaceClienSingle myaip=AipFaceClienSingle.getSingleton();
        //JSONObject res = myaip.getaipfaceclient().detect(image64, imageType,null);
        //输出检测结果
        System.out.println();
        //System.out.println(res.toString(2));

        //myaip.getaipfaceclient().groupAdd("myfacedb",null);
        //myaip.getaipfaceclient().addUser(image64, imageType, groupId, userId, null);


        JSONObject res2 = myaip.getaipfaceclient().search(image64, imageType, groupId, null);
        System.out.println(res2.toString(2));
    }
}
