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
public class Notice implements Serializable {

    private static final long serialVersionUID = -1802402L;

    Integer id;
    String title;
    String content;
    String createDate;
    Integer userId;
}
