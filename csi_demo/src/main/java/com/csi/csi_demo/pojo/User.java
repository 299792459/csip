package com.csi.csi_demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @create 2019/11/16 0016
 * @since 1.0.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1802401L;

    //sql字段在映射的时候不区分大小写，而java区分
    //sql字段带下划线的情况下
    Integer id;
    String loginname;
    String password;
    Integer status;
    String createdate;
    String username;
    String face_url;
    String face_path;
}
