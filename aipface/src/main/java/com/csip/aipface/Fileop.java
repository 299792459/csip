package com.csip.aipface;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/18 0018
 * @since 1.0.0
 */
@Component
public class Fileop {
    /**
     * 实现文件上传
     * */
    public String fileUpload(MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "D:/test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){
            //判断文件父目录是否存在,不存在则新建一个
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }


    /*
     * 获取multifile.html页面
     */
    @RequestMapping("multifile")
    public String multifile(){
        return "/multifile";
    }

    /**
     * 实现多文件上传
     * */
    //文件全部放在HttpServletRequest对象中
    public String multifileUpload(HttpServletRequest request){

        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("fileName");
        if(files.isEmpty()){
            return "false";
        }

        String path = "C:/test" ;

        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

            if(file.isEmpty()){
                return "false";
            }else{
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        return "true";
    }
}
