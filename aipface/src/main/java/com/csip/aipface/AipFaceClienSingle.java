package com.csip.aipface;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

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
public class AipFaceClienSingle {

    //双检锁实现单例模式
    private volatile static AipFaceClienSingle singleton;
    private AipFaceClienSingle (){}
    public static AipFaceClienSingle getSingleton() {
        if (singleton == null) {
            synchronized (AipFaceClienSingle.class) {
                if (singleton == null) {
                    singleton = new AipFaceClienSingle();
                    // 初始化一个AipFace
                }
            }
        }
        return singleton;
    }

    //百度人脸识别api
    //设置APPID/AK/SK
    public static final String APP_ID = "17788374";
    public static final String API_KEY = "UK0geY7xrOzU1V9XpqdSWIUl";
    public static final String SECRET_KEY = "Buc50rFoVILvXoPjlVmFuOu6cfjADPMc";

    public AipFace getaipfaceclient() {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        return client;
    }
}
