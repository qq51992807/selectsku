package com.yang.selectsku.controller;

import com.yang.selectsku.utils.userAgents;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.annotation.security.RunAs;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class startLive implements Runnable {

    String authorId;
    String authorName;
    int time;
    boolean firstCome = true;
    boolean addStart = true;
    String liveStatus = "下播";

    public startLive(String authorId, String authorName, int time, boolean addStart) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.time = time;
        this.addStart = addStart;
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


    @Override
    public void run() {
        while (1 == 1) {
            try {
//                httpGet("https://api3-core-lite-act-hl.amemv.com/aweme/v1/user/profile/other/?user_id="+authorId, "UTF-8");
                httpGet("https://webcast3-normal-c-lq.huoshan.com/webcast/room/info_by_user/?aid=1112&user_id=" + authorId, "UTF-8");
                Thread.sleep(1000 * time);
            } catch (HttpException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public static void main(String args[]) {

    }


    public String httpGet(String url, String charset)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();
        httpGet.setHeader("User-Agent", userAgents.generate());

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
//
        if (json == null || json.equals("")) {

        } else {
            try {
                JSONObject jsonArray = new JSONObject(json);
                JSONObject data = new JSONObject(jsonArray.getString("data"));
//                System.out.println(df.format(new Date()) + "--" + data);
                String nowLiveStatus=null;
                if(data.has("id")){
                    String id = data.getString("id");
                    if (!id.equals("0")) {
                        nowLiveStatus = "开播啦";
                    }
                }else {
                    nowLiveStatus = "下播";
                }


                    if (firstCome)
                    System.out.println(df.format(new Date()) + " 主播id：" + authorId + " 主播名称：" + authorName + " 当前直播状态为 " + liveStatus);
                // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;

                if (!liveStatus.equals(nowLiveStatus)) {
                    if (firstCome) {
                        if (addStart) {
                            String message =
                                    " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                            "  \"content\":\"主播名称：" + authorName + " 当前状态为 " + nowLiveStatus + " \"," +
                                            "  \"summary\":\"抖音主播名称：" + authorName + " 当前状态为 " + nowLiveStatus + " \"," +
                                            "  \"topicIds\":[ \n" +
                                            "      1528\n" +
                                            "  ]," +
                                            "  \"contentType\":2 " +
                                            "}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                    } else {
                        //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);


                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"主播名称：" + authorName + "---" + nowLiveStatus + " \"," +
                                        "  \"summary\":\"抖音主播名称：" + authorName + "---" + nowLiveStatus + "  \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1528\n" +
                                        "  ]," +
                                        "  \"contentType\":2 " +
                                        "}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                    }
                    liveStatus=nowLiveStatus;
                } else {
                    if (firstCome) {
                        if (addStart) {
                            String message =
                                    " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                            "  \"content\":\"主播名称：" + authorName + " 当前状态为 " + nowLiveStatus + " \"," +
                                            "  \"summary\":\"抖音主播名称：" + authorName + " 当前状态为 " + nowLiveStatus + " \"," +
                                            "  \"topicIds\":[ \n" +
                                            "      1528\n" +
                                            "  ]," +
                                            "  \"contentType\":2 " +
                                            "}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                    }
                    liveStatus=nowLiveStatus;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return json;
    }


    public String post(String url, String data) {

        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils
                        .toString(httpresponse.getEntity());

//                System.out.println("response: " + response);
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}
