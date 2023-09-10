package org.come.until;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
  

/**
 * java post提交的工具类
 * @author Administrator
 *
 */
public class APIHttpClient {  
  
    // 接口地址  
    private static String apiURL = "http://127.0.0.1/GameServer.v6.0/servlet/AppServerlet";  
    private Log logger = LogFactory.getLog(this.getClass());  
    private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";  
    private HttpClient httpClient = null;  
    private HttpPost method = null;  
    private long startTime = 0L;  
    private long endTime = 0L;  
    private int status = 0;  
  
    /** 
     * 接口地址 
     *  
     * @param url 
     */  
    public APIHttpClient(String url) {  
  
        if (url != null) {  
            APIHttpClient.apiURL = url;  
        }  
        if (apiURL != null) {  
            this.httpClient = new DefaultHttpClient();  
            this.method = new HttpPost(apiURL);  
  
        }  
    }  
  
    /** 
     * 调用 API 
     *  
     * @param parameters 
     * @return 
     */  
    public String post(String parameters) {  
        String body = null;  
        this.logger.info("parameters:" + parameters);  
  
        if (this.method != null & parameters != null  
                && !"".equals(parameters.trim())) {  
            try {  
  
                // 建立一个NameValuePair数组，用于存储欲传送的参数  
                this.method.addHeader("Content-type","application/json; charset=utf-8");  
                this.method.setHeader("Accept", "application/json");  
                this.method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));  
                this.startTime = System.currentTimeMillis();  
  
                HttpResponse response = this.httpClient.execute(this.method);  
                  
                this.endTime = System.currentTimeMillis();  
                int statusCode = response.getStatusLine().getStatusCode();  
                  
                this.logger.info("statusCode:" + statusCode);  
                this.logger.info("调用API 花费时间(单位：毫秒)：" + (this.endTime - this.startTime));  
                if (statusCode != HttpStatus.SC_OK) {  
                    this.logger.error("Method failed:" + response.getStatusLine());  
                    this.status = 1;  
                }  
  
                // Read the response body  
                body = EntityUtils.toString(response.getEntity());  
  
            } catch (IOException e) {  
                // 网络错误  
                this.status = 3;  
            } finally {  
                this.logger.info("调用接口状态：" + this.status);  
            }  
  
        }  
        return body;  
    }  
  
    
    /**
     * 通过对应的路径进行发送
     * @param args
     */
    public static void sendMes(String url,String mes){
    	APIHttpClient ac = new APIHttpClient(url);  	
    	ac.post(mes);
    }
  
    /** 
     * 0.成功 1.执行方法失败 2.协议错误 3.网络错误 
     *  
     * @return the status 
     */  
    public int getStatus() {  
        return this.status;  
    }  
  
    /** 
     * @param status 
     *            the status to set 
     */  
    public void setStatus(int status) {  
        this.status = status;  
    }  
  
    /** 
     * @return the startTime 
     */  
    public long getStartTime() {  
        return this.startTime;  
    }  
  
    /** 
     * @return the endTime 
     */  
    public long getEndTime() {  
        return this.endTime;  
    }  
}  
