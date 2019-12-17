package com.csi.csi_demo.pojo;

import lombok.Data;

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

public class Employee implements Serializable {

    private static final long serialVersionUID = -1802405L;

    Integer id;
    Integer deptId;
    Integer jobId;
    String name;
    String cardId;
    String address;
    String postCode;
    String tel;
    String phone;
    String qqNum;
    String email;
    String sex;
    String party;
    String birthday;
    String race;
    String education;
    String speciality;
    String hobby;
    String remark;
    String createDate;
}
