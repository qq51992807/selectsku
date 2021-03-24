package com.yang.selectsku.utils;

import net.sf.json.JSONArray;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class postUtils {

    public static String[] ips = {"27.47.6.160", "27.47.5.160", "27.47.15.160"};
    static Random random = new Random();
    public static String post(String url, String data, boolean isCookie, String cookie) {

        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
//                httpclient = (CloseableHttpClient)wrapClient(httpclient);
                HttpPost httppost = new HttpPost(url);
//                String proxyHost = "forward.xdaili.cn";
//                Integer proxyPort = 80;
//                HttpHost proxy = new HttpHost(proxyHost, proxyPort, "http");

//                System.getProperties().setProperty("http.proxyHost", "124.112.4.119");//random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255));
//                System.getProperties().setProperty("http.proxyPort", "4278");
//                httppost.addHeader("x-forwarded-for","127.0."+random.nextInt(255)+"."+random.nextInt(255));
                if (isCookie) {
                    httppost.setHeader("Cookie", cookie);
                    httppost.setHeader("User-Agent","Aweme 11.1.0 rv:141017 (iPhone; iOS 11.2; zh_CN) Cronet");//userAgents.generate());
//                    httppost.setHeader("Connection","close");
//                    int timestamp = (int) (new Date().getTime()/1000);
//                    String planText="orderno=ZF20213240774wo0eeV,secret=916ea1da1ed840389618a033d9a81570,timestamp="+timestamp;
//                    String sign=org.apache.commons.codec.digest.DigestUtils.md5Hex(planText).toUpperCase();
//                    httppost.setHeader("Authorization","sign="+sign+"&orderno=ZF20213240774wo0eeV&timestamp="+timestamp);
                }
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
//                RequestConfig reqConfig = RequestConfig.custom().setConnectionRequestTimeout(5000).setConnectTimeout(10000) // 设置连接超时时间
//                        .setSocketTimeout(10000) // 设置读取超时时间
//                        .setExpectContinueEnabled(false).setProxy(new HttpHost(proxyHost, proxyPort))
//                        .setCircularRedirectsAllowed(true) // 允许多次重定向
//                        .build();
//                httppost.setConfig(reqConfig);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils
                        .toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return response;
    }

    public static String httpGet(String url, String charset,String cookie)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();
        httpGet.setHeader("cookie",cookie);

// 设置参数
        try {
            httpGet.setURI(new URI(url));
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。" + e.getMessage());
        }
// 发送请求
        HttpClient client = new DefaultHttpClient();
        HttpResponse httpResponse = client.execute(httpGet);
// 获取返回的数据
        HttpEntity entity = httpResponse.getEntity();
        byte[] body = EntityUtils.toByteArray(entity);
        StatusLine sL = httpResponse.getStatusLine();
        int statusCode = sL.getStatusCode();
        if (statusCode == 200) {
            json = new String(body, charset);
            entity.consumeContent();
        } else {
            throw new HttpException("statusCode=" + statusCode);
        }
        return json;
    }


    public static String getSkuState(String json){
        String message=null;
        try {
            JSONObject jsonArray = new JSONObject(json);
           JSONObject productDetail=new JSONObject(jsonArray.getString("productDetail"));
//           List<String> skuInfoList=productDetail.getString("skuInfoList");
            JSONArray skuInfoListArray = JSONArray.fromObject(productDetail.get("skuInfoList") + "");
            String skuStock=new JSONObject(skuInfoListArray.get(0)+"").getString("skuStock");
//            JSONObject skuInfoList=new JSONObject(productDetail.getString("skuInfoList"));
            message=skuStock;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return message;
    }


    /**
     * 避免HttpClient的”SSLPeerUnverifiedException: peer not authenticated”异常
     * 不用导入SSL证书
     * @param base
     * @return
     */
    public static HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] arg0,
                                               String arg1) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] arg0,
                                               String arg1) throws CertificateException {
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(ssf).build();
            return httpclient;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpClients.createDefault();
        }
    }

}
