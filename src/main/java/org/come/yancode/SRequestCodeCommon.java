package org.come.yancode;

import cn.hutool.http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SRequestCodeCommon {
    public static final String IP = "http://127.0.0.1";
    public static final String PORT = "8090";

    public static Boolean verify(String code){
        String url = IP.concat(":").concat(PORT).concat("/verify/");
        Boolean aBoolean = Boolean.valueOf(HttpUtil.get(url.concat(code)));
        return aBoolean;
    }

    private static CloseableHttpClient httpClient;
    private static HttpGet httpGet;
    public static final String CONTENT_TYPE = "Content-Type";
    public static String sendGet(String code) {
        String resp = null;
        try {
            httpClient = HttpClients.createDefault();
            String url = IP.concat(":").concat(PORT).concat("/verify/"+code);
            httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                resp = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
            LoggerFactory.getLogger(SRequestCodeCommon.class).info(" resp:{}", resp);
        }catch (Exception e){
            LoggerFactory.getLogger(SRequestCodeCommon.class).error(" yan code error:{}", e);
        }
        return resp;
    }


}
