package com.yang.selectsku.controller;

import antlr.StringUtils;
import com.yang.selectsku.DyPost.DyBuyHuawei;
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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getDySku implements Runnable{

    public int time;
    public  String itemId;
    public String itemName;
    public  int  num=0;
    public boolean firstCome=true;
    public boolean addStart=true;


    public getDySku(String itemId,String itemName,int time,boolean addStart){
        this.itemId=itemId;
        this.itemName=itemName;
        this.time=time;
        this.addStart=addStart;
    }

    public void run(){
        while (1==1) {
            try {
                httpGet("https://ec.snssdk.com/product/getstock?id=" + itemId, itemId, itemName);
                Thread.sleep(800 * time);
            } catch (HttpException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void main(String args[]){
        getDySku getDySku=new getDySku("3452440959718151364","mate40p",3,true);
        Thread mThread1=new Thread(getDySku,"线程1");
        mThread1.start();
    }
//public static void main(String args[]){
//
////    getDySku getDySku=new getDySku("3457878064195892911","老罗黄金",1,true);
////    testDyBuy testDyBuy=new testDyBuy();
////    testDyBuy2 testDyBuy2=new testDyBuy2();
////    while(1==1) {
////        getDySku.sendMessageDy(testDyBuy.post(getDySku.itemId, "1572967386"), "老罗黄金");
////        getDySku.sendMessageDy(testDyBuy2.post(getDySku.itemId, "1572967386"), "老罗黄金");
////    }
//    getDySku getDySku=new getDySku("3453521734500751426","mate40",1,false);
//    DyBuyHuawei dyBuyHuawei=new DyBuyHuawei();
//    getDySku.sendMessageDy(dyBuyHuawei.post(getDySku.itemId, "1422354648"), "mate40");
//
//}


    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    public  String httpGet(String url,String itemId,String itemName)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");

// 设置参数
        try {
            httpGet.setURI(new URI(url));
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。"+e.getMessage());
        }
// 发送请求
        HttpClient client=HttpClients.createDefault();
        HttpResponse httpResponse = client.execute(httpGet);
// 获取返回的数据
        HttpEntity entity = httpResponse.getEntity();
        byte[] body = EntityUtils.toByteArray(entity);
        StatusLine sL = httpResponse.getStatusLine();
        int statusCode = sL.getStatusCode();
        if (statusCode == 200) {
            json = new String(body);
            entity.consumeContent();
        } else {
            throw new HttpException("statusCode="+statusCode);
        }
        if(json==null||json.equals("")){

        }else {
            try {
                JSONObject jsonArray = new JSONObject(json);
                JSONObject data = new JSONObject(jsonArray.getString("data") + "");
                //sku
                int StockNum = Integer.parseInt(data.getString("total_stock_num"));
                if (firstCome)
                    System.out.println(df.format(new Date()) + " 商品编号：" + itemId + " 商品名称为：" + itemName + " 当前库存状态为 " + StockNum);
                // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;

                if (num != StockNum) {
                    if (firstCome) {
                        if (addStart) {
                            String message =
                                    " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                            "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockNum + " \"," +
                                            "  \"summary\":\"开启抖音监控商品 " + itemName + " 成功 当前库存状态为 " + StockNum + "  \"," +
                                            "  \"topicIds\":[ \n" +
                                            "      1205\n" +
                                            "  ]," +
                                            "  \"contentType\":2, " +
                                            "  \"uids\":[" +
                                            "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
                                            ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                            "  ]}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                        num = StockNum;
                    } else {
                        //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);


                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称：" + itemName + " 库存变化为 " + num + " -> " + StockNum + " \"," +
                                        "  \"summary\":\"库存提醒 抖音商品名称：" + itemName + " 库存变化为 " + num + " -> " + StockNum + " \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1205\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
                                        ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                        "  ]}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        num = StockNum;
                    }
                } else {
                    if (firstCome) {
                        if (addStart) {
                            String message =
                                    " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                            "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockNum + " \"," +
                                            "  \"summary\":\"开启抖音监控商品 " + itemName + " 成功 当前库存状态为 " + StockNum + "  \"," +
                                            "  \"topicIds\":[ \n" +
                                            "      1205\n" +
                                            "  ]," +
                                            "  \"contentType\":2, " +
                                            "  \"uids\":[" +
                                            "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
                                            ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                            "  ]}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
    public  String post(String url,String data) {

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

    void sendMessageDy(String response,String itemName){
        if(response!=null&&response.length()!=0) {
            String response2 = TransationMessage(response);
            System.out.println(response2);
            if (response2.equals("")) {
                String message =
                        " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                "  \"content\":\"抖音 " + itemName + " 提交结果 ：" + response2 + "成功  \"," +
                                "  \"summary\":\"抖音 " + itemName + " 提交结果 ：" + response2 + "成功  \"," +
                                "  \"topicIds\":[ \n" +
                                "      1205\n" +
                                "  ]," +
                                "  \"contentType\":2, " +
                                "  \"uids\":[" +
                                "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
                                "  ]}";
                getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
            }
        }
    }
    public String TransationMessage(String message){
        String data=null;
        try {
            JSONObject jsonArray = new JSONObject(message);
            data= jsonArray.getString("msg");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }


}
