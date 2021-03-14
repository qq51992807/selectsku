package com.yang.selectsku.utils;

import com.yang.selectsku.DyPost.DyBuyCart;
import com.yang.selectsku.DyPost.DyBuyCart2;
import com.yang.selectsku.controller.getSku;
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
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class getDySkuAndCommit implements Runnable{

    public int time;
    public  String itemId;
    public String itemName;
    public String combId;
    public  int  num=0;
    public boolean firstCome=true;
    public boolean addStart=true;
    String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
    String baiyeAddress="6837435314240340236";
    String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};
    String xCookie=" passport_csrf_token=9ca99ffdad1abbe901df514515e6779b; passport_csrf_token_default=9ca99ffdad1abbe901df514515e6779b; install_id=3237384126992995; ttreq=1$5339498c4c1bc6c31982d7628b01134327e66179; d_ticket=b8a37bb52c5fc8a7dfe3896a3dbfd5d986961; multi_sids=1472985216323047%3A50702332d2773a492a29154fffe9c1e7; odin_tt=85c44fad3e6fdfded72f207be3da152566fdfb0eea0549d27b217b37a841d2ed84a74bf233cf6fc4992e965143262bf29a7fe701253e5b873e7d069adf31954e; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=50702332d2773a492a29154fffe9c1e7%7C1614261497%7C5184000%7CMon%2C+26-Apr-2021+13%3A58%3A17+GMT; uid_tt=a0601eec5f0e138c946762d756c50cd6; uid_tt_ss=a0601eec5f0e138c946762d756c50cd6; sid_tt=50702332d2773a492a29154fffe9c1e7; sessionid=50702332d2773a492a29154fffe9c1e7; sessionid_ss=50702332d2773a492a29154fffe9c1e7";
    String xAddress="6916499793699176711";
    String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道石溪红太阳幼儿园旁边"};

    DyBuyCart dyBuyCart;
    DyBuyCart dyBuyCart2;

    public getDySkuAndCommit(String itemId,String combId, String itemName, int time, boolean addStart){
        this.itemId=itemId;
        this.combId=combId;
        this.itemName=itemName;
        this.time=time;
        this.addStart=addStart;
        dyBuyCart=new DyBuyCart(baiyeCookie, baiyeAddress,itemId,combId,baiyeAddressList);
        dyBuyCart2=new DyBuyCart(xCookie,xAddress,itemId,combId,xAddressList);
    }

    public void run(){
        while (1==1) {
            try {
                httpGet("https://ec.snssdk.com/product/getstock?id=" + itemId,itemId,combId, itemName);
                Thread.sleep(200 * time);
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
//        getDySkuAndCommit getDySkuAndCommit=new getDySkuAndCommit("3467328892761730995","1693219764071485","k40",1,false);
        getDySkuAndCommit getDySkuAndCommit=new getDySkuAndCommit("3453521734500751426","1422354648","mate40黑色128g",1,false);
//        getDySkuAndCommit getDySkuAndCommit2=new getDySkuAndCommit("3453521734500751426","1422354655","mate40黑色256g",1,false);
//        getDySkuAndCommit getDySkuAndCommit3=new getDySkuAndCommit("3453521734500751426","1422354657","mate40白色256g",1,false);
        Thread mThread1=new Thread(getDySkuAndCommit,"线程1");
//        Thread mThread2=new Thread(getDySkuAndCommit2,"线程2");
//        Thread mThread3=new Thread(getDySkuAndCommit3,"线程3");
        mThread1.start();
//        mThread2.start();
//        mThread3.start();
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

    public  String httpGet(String url,String itemId,String combId,String itemName)
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
        if(json==null||json.equals("")||json.equals("[]")){

        }else {
            try {
                JSONObject jsonArray = new JSONObject(json);
                JSONObject data = new JSONObject(jsonArray.getString("data") + "");
                //sku
                JSONObject stock=new JSONObject(data.getString("stock")+"");
                int StockNum=0;
                Iterator iterator=stock.keys();
                while (iterator.hasNext()){
                    String key = String.valueOf(iterator.next());
//                    String value = "";

                    if(stock.get(key) != null) {
//                        value = stock.get(key).toString();
                        JSONObject stockValue=new JSONObject(stock.get(key).toString()+"");
                        if(stockValue.getString("id").equals(combId))
                            StockNum=Integer.parseInt(stockValue.getString("stock_num"));
                    }
                }

//                int StockNum = Integer.parseInt(data.getString("total_stock_num"));
//                if (firstCome)
                    System.out.println(df.format(new Date()) + " 商品编号：" + itemId + " 商品名称为：" + itemName + " 当前库存状态为 " + StockNum);
                // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;
//                System.out.println(dyBuyCart2.post());
                if (num != StockNum) {
//                    System.out.println(dyBuyCart.post(combId));
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
//                                            ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                            "  ]}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                        num = StockNum;
                    } else {
                        //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);
                        System.out.println(dyBuyCart.post());
                        System.out.println(dyBuyCart2.post());
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
//                                        ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
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
//                                            ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
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
