package com.yang.selectsku.controller;

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

public class getSnSku implements Runnable{


    public  String  itemState="无货";
    public boolean firstCome=true;
    public boolean addStart=true;
    public String firstItemId;
    public String secondItemId;
    public String itemName;
    public int time;


    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


    public getSnSku(String firstItemId,String secondItemId,int time,String itemName, boolean addStart){
        this.firstItemId=firstItemId;
        this.secondItemId=secondItemId;
        this.time=time;
        this.itemName=itemName;
        this.addStart=addStart;

    }

    @Override
    public void run() {
        while (1==1) {
            try {
                httpGet("https://pas.suning.com/nspcsale_0_" + secondItemId + "_" + secondItemId + "_" + firstItemId + "_190_020.html", "GBK", firstItemId, secondItemId, itemName);
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

    public static void main(String args[]){
//        getSnSku getSnSku=new getSnSku("0000000000","11001203841",1,"茅台",true);
//        try {
//            getSnSku.httpGet("https://pas.suning.com/nspcsale_0_11001203841_11001203841_0000000000_190_020.html", "GBK","0000000000","11001203841","茅台");
//        } catch (HttpException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        getSnSku getSnSku=new getSnSku("0000000000","11001203841",1,"茅台",true);
        getSnSku getSnSku=new getSnSku("0000000000","12122946298",1,"Apple12",true);
        Thread myThread=new Thread(getSnSku,"sn监控");
        myThread.start();

    }


    public  String httpGet(String url, String charset,String firstItemId,String secondItemId,String itemName)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();

// 设置参数
        try {
            httpGet.setURI(new URI(url));
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。"+e.getMessage());
        }
// 发送请求
        HttpClient client=new DefaultHttpClient();
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
            throw new HttpException("statusCode="+statusCode);
        }

        try {
//                JSONObject jsonArray = new JSONObject(json);
            JSONObject jsonArray = new JSONObject(json.substring(json.indexOf("{"),json.lastIndexOf("}")+1));
            JSONObject data = new JSONObject(jsonArray.getString("data") + "");
            JSONObject price = new JSONObject(data.getString("price") + "");
            String subString=price.getString("saleInfo");
            JSONObject saleInfo = new JSONObject(subString.substring(subString.indexOf("{"),subString.lastIndexOf("}")+1));
            int invStatus = saleInfo.getInt("invStatus") ;
//            System.out.println(invStatus);
            String StockStateName=null;
            if(invStatus==2){
                StockStateName="无货";
            }else{
                StockStateName="有货";
            }



            //sku
            if(firstCome)
                System.out.println(df.format(new Date())+" 苏宁商品编号："+firstItemId+secondItemId+" 商品名称为："+itemName+" 当前库存状态为 " + StockStateName);
            // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;
//
            if(!itemState.equals(StockStateName)){
                if(firstCome){
                    if(addStart) {
                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockStateName + " 直接链接为 <a href=' https://m.suning.com/product/"+firstItemId+"/"+secondItemId+".html'>点击跳转购买</a>  \"," +
                                        "  \"summary\":\"开启苏宁监控商品 " + itemName + " 成功 当前库存状态为 " + StockStateName + "   \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1396\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        "  ]}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                    }
                    firstCome=false;

                }else{
                    //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);
                    if(!StockStateName.equals("无货")) {
                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称：" + itemName + " 库存变化为 " + itemState + " -> " + StockStateName + " 直接链接为 <a href=' https://m.suning.com/product/"+firstItemId+"/"+secondItemId+".html'>点击跳转购买</a>  \"," +
                                        "  \"summary\":\"库存提醒 苏宁商品名称：" + itemName + " 库存变化为 " + itemState + " -> " + StockStateName + "   \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1396\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        "  ]}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                    }
                }

                itemState=StockStateName;
            }else{
                if(firstCome) {
                    if(addStart) {
                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockStateName + " 直接链接为 <a href=' https://m.suning.com/product/"+firstItemId+"/"+secondItemId+".html'>点击跳转购买</a>  \"," +
                                        "  \"summary\":\"开启苏宁监控商品 " + itemName + " 成功 当前库存状态为 " + StockStateName + "   \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1396\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        "  ]}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                    }
                    firstCome = false;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
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
}
