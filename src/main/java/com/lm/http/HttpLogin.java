package com.lm.http;



import  org.apache.commons.httpclient.Cookie;
import  org.apache.commons.httpclient.HttpClient;
import  org.apache.commons.httpclient.NameValuePair;
import  org.apache.commons.httpclient.cookie.CookiePolicy;
import  org.apache.commons.httpclient.methods.GetMethod;
import  org.apache.commons.httpclient.methods.PostMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.util.HashMap;

/**
 * @Classname HttpLogin
 * @Description TODO
 * @Date 2020/10/15 17:38
 * @Created by limeng
 */
public class HttpLogin {
    public static void main(String[] args) {

        // 登陆 Url
        String loginUrl =  "http://192.168.200.116:8088/api/rest_j/v1/user/login?password=hdfs&userName=hdfs" ;
        // 需登陆后访问的 Url
        String dataUrl =  "http://192.168.200.116:8088/api/rest_j/v1/entrance/execute" ;
        String dataUrl2 = "/api/rest_j/v1/entrance/execute";
        HttpClient httpClient =  new HttpClient();



        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
        PostMethod postMethod =  new  PostMethod(loginUrl);

        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = {  new  NameValuePair( "password" ,  "hdfs" ),  new  NameValuePair( "userName" ,  "hdfs" ) };
        postMethod.setRequestBody(data);
        try  {
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            int  statusCode=httpClient.executeMethod(postMethod);

            // 获得登陆后的 Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpcookies =  new  StringBuffer();
            for  (Cookie c : cookies) {
                tmpcookies.append(c.toString() +  ";" );
                System.out.println( "cookies = " +c.toString());
            }
          //  if (statusCode== 302 ){ //重定向到新的URL
                System.out.println( "模拟登录成功" );

                PostMethod getMethod =  new  PostMethod(dataUrl);
                JSONObject jsonData = new JSONObject();
                jsonData.put("method", dataUrl2);
                jsonData.put("params", new HashMap<>()); //用户指定的运行服务程序的参数,必填，里面的值可以为空
                jsonData.put("executeApplicationName", "hive");//执行引擎，我用的hive
                jsonData.put("executionCode", "show tables");
                jsonData.put("runType", "sql");//当用户执行如spark服务时，可以选择python、R、SQL等,不能为空

                StringRequestEntity requestEntity = new StringRequestEntity(
                    data.toString(),
                    "application/json",
                    "UTF-8");
//                NameValuePair[] data2 = {  new  NameValuePair( "executeApplicationName" ,  "spark" ),
//                        new  NameValuePair( "runType" ,  "scala" ) ,
//                        new  NameValuePair( "executionCode" ,  "print(\"aa\")" ) ,
//                        new  NameValuePair( "umUser" ,  "hdfs" ),
//                        new  NameValuePair( "method" ,  "/api/rest_j/v1/entrance/execute" ),
//                        new  NameValuePair( "params" ,  new HashMap<String,String>().toString())};
              //  getMethod.setRequestBody(data2);
                getMethod.setRequestEntity(requestEntity);

            // 进行登陆后的操作
               // GetMethod getMethod =  new  GetMethod(dataUrl);
                // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
                getMethod.setRequestHeader( "cookie" , tmpcookies.toString());
                // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
                // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
                postMethod.setRequestHeader( "Referer" ,  "http://192.168.200.116:8088" );
                postMethod.setRequestHeader( "User-Agent" ,  "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36" );
                httpClient.executeMethod(getMethod);
                // 打印出返回数据，检验一下是否成功
                String text = getMethod.getResponseBodyAsString();
                System.out.println(text);
          //  }
//            else  {
//                System.out.println( "登录失败" );
//            }
        }
        catch  (Exception e) {
            e.printStackTrace();
        }
    }
}
