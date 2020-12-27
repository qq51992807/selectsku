package com.yang.selectsku.controller;

import net.sf.json.JSONArray;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;

public class getKaoLaSku implements Runnable {

    public int num=0;
    public String goodsId;
    public int index;
    public int time;

    public  getKaoLaSku(String goodsId,int time,int index){
        this.goodsId=goodsId;
        this.index=index;
        this.time=time;
    }

    public void run(){
        while(1==1){
         //   long time=System.currentTimeMillis();
            try {
//                httpGet("https://goods.kaola.com/product/getPcGoodsDetailDynamic.json?provinceCode=440000&cityCode=440100&districtCode=440106&goodsId=8234486&categoryId=7991&t="+time+"&t="+time,"UTF-8",1);
//                httpGet("https://m-goods.kaola.com.hk/product/getWapGoodsDetailDynamic.json?t="+time+"&goodsId=8234486&provinceCode=440000&cityCode=440100&districtCode=440106","UTF-8",1);
                getkaolaSku(goodsId,index);
                Thread.sleep(1000*time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void  main(String[] args){
//        getKaoLaSku getKaoLaSku=new getKaoLaSku();
//        Thread mThread1=new Thread(getKaoLaSku,"线程1");
//        mThread1.start();
////        getKaoLaSku.getkaolaSku();
//
//    }

    public  String httpGet(String url,String charset,int index)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();
        HttpClient client = new DefaultHttpClient();
        try {
            httpGet.setURI(new URI(url));
            httpGet.setHeader("Referer","https://goods.kaola.com/product/8234486.html?spm=a2v0d.13659821.0.0.fa6522c8uNTfBk&kpm=MTAwMg%3D%3D.OTgwNDk%3D.MjY1MTEwNw%3D%3D.MQ%3D%3D%40%40Xw%3D%3D&_h5da=true");
//            httpGet.setHeader("cookie","isg=BDs7z7tF4KVNYtwRaZlRR13hwBulkE-Su1MCZC34FzpRjFtutWDf4lnaoOpnt6eK; l=eBgvzQweO8q9Ru_iBOfaKurza77ORCdbYuPzaNbMiOCP_yfp5drlWZ-lnVY9Cn1Rh6qJR353WmuWBeYBmQRrnxvO5l5OqgDmn; tfstk=c-yPBwxqtWV2jqDtEYMeONWrkQDRZYN8Ggi-ZWOoAXL1WXDliXWKcyLaF8Adpbf..; x5sec=7b227761676272696467652d616c69626162612d67726f75703b32223a226138386365383562306233343234666438333638636438636562303032353836434b2f706e663846454d48782b2b583430614b4362513d3d227d; NTES_KAOLA_ADDRESS_CONTROL=440000|440100|440103|1; xlly_s=1; cna=r2JuGN10VzcCARsvBYfAs2rV; JSESSIONID-WKL-8IO=g1udflmZUkYuXaPlxVQicvypI70r4VCbWz8R\\wp60ks+\\hmSiWrJ7BfHLPTOHR9OZ8jrIjpvDPpfxBGaf6lEXG3AUoDOeJEM5klN7tVAx7LWQlxUPEZXARdRbCbdR68hmq2NVV244PdeR0MjKSeTQ\\du403gPysdBIpNqJC5nCgQRzJo:1609090606813; _klhtxd_=31");
            httpGet.setHeader("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32");
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。" + e.getMessage());
        }
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("112.111.217.134", 9999));
//        HttpHost proxy = new HttpHost("218.93.119.164", 9002);
//        client.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY,
//              proxy);
// 发送请求

        HttpResponse httpResponse = client.execute(httpGet);
// 获取返回的数据
        HttpEntity entity = httpResponse.getEntity();
        byte[] body = EntityUtils.toByteArray(entity);
        StatusLine sL = httpResponse.getStatusLine();
        int statusCode = sL.getStatusCode();
        if (statusCode == 200) {
            json = new String(body,charset);
            entity.consumeContent();
        } else {
            throw new HttpException("statusCode=" + statusCode);
        }

        try {

            JSONObject jsonArray = new JSONObject(json);
//

            JSONObject data = new JSONObject(jsonArray.getString("data") + "");
            JSONArray array = JSONArray.fromObject(data.get("skuDetailList") + "");
            net.sf.json.JSONObject Allsku = ( net.sf.json.JSONObject) array.get(index-1);
            JSONObject skuStore = new JSONObject(Allsku.getString("skuStore") + "");
            int currentStoreskuStore=Integer.parseInt(skuStore.getString("currentStore")+"");

            //sku
              System.out.println( "当前库存为 " + currentStoreskuStore);
              if(num!=currentStoreskuStore) {
                  String message =
                          " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                  "  \"content\":\"考拉监控商品库存变化 " + num + " -> " + currentStoreskuStore + " \"," +
                                  "  \"summary\":\"库存提醒 考拉监控商品库存变化 " + num + " -> " + currentStoreskuStore + " \"," +
                                  "  \"topicIds\":[ \n" +
                                  "      1205\n" +
                                  "  ]," +
                                  "  \"contentType\":2, " +
                                  "  \"uids\":[" +
                                  "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\"" +
                                  "  ]}";
                  getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                  num = currentStoreskuStore;
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

                System.out.println("response: " + response);
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
    public void getkaolaSku(String goodsId,int index){//8234486
        String message ="{" +
                " \"minappGoodsDetailDynamicParam\": {" +
                "  \"goodsId\": "+goodsId+"," +
                "  \"addressParam\": {" +
                "   \"provinceCode\": 510000," +
                "   \"cityCode\": 510100," +
                "   \"districtCode\": 510122" +
                "  }\n" +
                " }\n" +
                "}";
       String respons= post("https://gw.kaola.com/gw/product/minappGoodsDynamic?version=1.0&group=onlinejd&_bx-m=2.0.10-beta1&sign=1%40%2FwywN14mEA%2Bowm9w2%2FxsTo5iTjaLa2XzIQ7sJWfNqNoeGU2qZjMs07cjdC4kzs5Lz5G4W98PhC%3D%3D", message);
        try {

            JSONObject jsonArray = new JSONObject(respons);
//

            JSONObject data = new JSONObject(jsonArray.getString("body") + "");
            JSONArray array = JSONArray.fromObject(data.get("skuDetailList") + "");
            net.sf.json.JSONObject Allsku = ( net.sf.json.JSONObject) array.get(index-1);
            JSONObject skuStore = new JSONObject(Allsku.getString("skuStore") + "");
            int currentStoreskuStore=Integer.parseInt(skuStore.getString("currentStore")+"");

            //sku
            System.out.println( "当前库存为 " + currentStoreskuStore);
            if(num!=currentStoreskuStore) {
                String message2 =
                        " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                "  \"content\":\"考拉监控商品库存变化 " + num + " -> " + currentStoreskuStore + " \"," +
                                "  \"summary\":\"库存提醒 考拉监控商品库存变化 " + num + " -> " + currentStoreskuStore + " \"," +
                                "  \"topicIds\":[ \n" +
                                "      1205\n" +
                                "  ]," +
                                "  \"contentType\":2, " +
                                "  \"uids\":[" +
                                "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\"" +
                                "  ]}";
                getSku.post("http://wxpusher.zjiecode.com/api/send/message", message2);
                num = currentStoreskuStore;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
