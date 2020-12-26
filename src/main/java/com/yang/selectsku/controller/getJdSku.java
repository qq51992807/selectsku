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

public class getJdSku implements Runnable{


    public int time;
    public  String itemId;
    public String areaCode;
    public int send;
    public  String  itemState="无货";
    public  getJdSku(String itemId,int time,String areaCode,int send){
        this.itemId=itemId;
        this.time=time;
        this.areaCode=areaCode;
        this.send=send;
    }
    public void run() {
        //判断发送的对象 1为白夜 2为群霸
        String sendIds;
        if(send==1){
            sendIds=  "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"";
        }else{
            sendIds="      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\"";
        }
        while(1==1) {
            try {//100006359561  //apple 100016034400
//                getJdSku.httpGet("http://c0.3.cn/stocks?type=batchstocks&skuIds="+itemId+"&area=19_1601_3635&_=1608961684270&scriptCharset=GBK&buyNum=1&province=%E5%B9%BF%E4%B8%9C", "GBK", itemId);
                httpGet("http://c0.3.cn/stocks?type=batchstocks&skuIds="+itemId+"&area="+areaCode+"", "GBK", itemId,sendIds);
                Thread.sleep(1000*time);
            } catch (HttpException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//        public static void main(String[] args) {
//        getJdSku getJdSku=new getJdSku("100016034400",60,"19_1601_50259_51886");
//        Thread mThread1=new Thread(getJdSku,"线程1");
//        mThread1.start();
//    }


    public  String httpGet(String url, String charset,String itemId,String sendIds)
            throws HttpException, IOException  {
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

                JSONObject jsonArray = new JSONObject(json);
                JSONObject item = new JSONObject(jsonArray.getString(itemId) + "");
                //sku
                String StockStateName=item.getString("StockStateName");
                System.out.println("商品编号："+itemId+"当前库存为 " + StockStateName);
               // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;

                if(!itemState.equals(StockStateName)){
                    itemState=StockStateName;
//        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);
                    String message=
                            " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                    "  \"content\":\" 商品编号："+itemId+" 库存为 "+StockStateName+" 直接链接为 <a href=' https://p.m.jd.com/norder/order.action?wareId="+itemId+"&wareNum=1&enterOrder=true '>https://p.m.jd.com/norder/order.action?wareId="+itemId+"&wareNum=1&enterOrder=true</a>  \"," +
                                    "  \"summary\":\" 库存提醒 商品编号："+itemId+" 库存现在为 "+StockStateName+" \"," +
                                    "  \"topicIds\":[ \n" +
                                    "      1205\n" +
                                    "  ]," +
                                    "  \"contentType\":2, " +
                                    "  \"uids\":[" +
                                    sendIds +
                                    "  ]}" ;
                    getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);
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


}
