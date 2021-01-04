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

public class getJdSku implements Runnable{


    public int time;
    public  String itemId;
    public String areaCode;
    public int send;
    public String itemName;
    public  String  itemState="无货";
    public boolean firstCome=true;
    public  getJdSku(String itemId,int time,String areaCode,int send,String itemName){
        this.itemId=itemId;
        this.time=time;
        this.areaCode=areaCode;
        this.send=send;
        this.itemName=itemName;
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    public void run() {
        //判断发送的对象 1为白夜 2为群霸
        String sendIds;
        if(send==1){
            sendIds=  "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"";
        }else{
            sendIds="        \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\"";
        }
        while(1==1) {
            try {//100006359561  //apple 100016034400
//                getJdSku.httpGet("http://c0.3.cn/stocks?type=batchstocks&skuIds="+itemId+"&area=19_1601_3635&_=1608961684270&scriptCharset=GBK&buyNum=1&province=%E5%B9%BF%E4%B8%9C", "GBK", itemId);
//                 httpGet("http://c0.3.cn/stocks?type=batchstocks&skuIds="+itemId+"&area="+areaCode+"", "GBK", itemId,sendIds,itemName);
                 httpGet("https://c0.3.cn/stocks?callback=jQuery1951451&type=getstocks&skuIds="+itemId+"&area="+areaCode+"&_=1609066125592", "GBK", itemId,sendIds,itemName);
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
//        getJdSku getJdSku1=new getJdSku("100009808169",10,"19_1601_50259_51886",1,"mate40黑色");
//        getJdSku getJdSku2=new getJdSku("100006359561",10,"19_1601_50259_51886",1,"xs");
//        getJdSku getJdSku3=new getJdSku("100017133254",10,"19_1601_50259_51886",1,"mate40银色");
//        getJdSku getJdSku4=new getJdSku("100009808171",10,"19_1601_50259_51886",1,"mate40白色");
//        Thread mThread1=new Thread(getJdSku1,"线程1");
//        Thread mThread2=new Thread(getJdSku2,"线程2");
//        Thread mThread3=new Thread(getJdSku3,"线程3");
//        Thread mThread4=new Thread(getJdSku4,"线程4");
//        mThread1.start();
//        mThread2.start();
//        mThread3.start();
//        mThread4.start();
//    }


    public  String httpGet(String url, String charset,String itemId,String sendIds,String itemName)
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
//                JSONObject jsonArray = new JSONObject(json);
                JSONObject jsonArray = new JSONObject(json.substring(json.indexOf("{"),json.lastIndexOf("}")+1));
                JSONObject item = new JSONObject(jsonArray.getString(itemId) + "");
                //sku
                String StockStateName=item.getString("StockStateName");
                System.out.println(df.format(new Date())+" 商品编号："+itemId+" 商品名称为："+itemName+" 当前库存状态为 " + StockStateName+"来自用户 "+send);
               // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;

                if(!itemState.equals(StockStateName)){
                    if(firstCome){
                        String message=
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称："+itemName+" 当前库存状态为 "+StockStateName+" 直接链接为 <a href=' https://p.m.jd.com/norder/order.action?wareId="+itemId+"&wareNum=1&enterOrder=true '>https://p.m.jd.com/norder/order.action?wareId="+itemId+"&wareNum=1&enterOrder=true</a>  \"," +
                                        "  \"summary\":\"开启JD监控商品 "+itemName+" 成功 当前库存状态为 "+StockStateName+"  \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1205\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        sendIds +
                                        "  ]}" ;
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);
                        firstCome=false;
                    }else{
                        //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);
                        String message=
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称："+itemName+" 库存变化为 "+itemState+" -> "+StockStateName+" 直接链接为 <a href=' https://p.m.jd.com/norder/order.action?wareId="+itemId+"&wareNum=1&enterOrder=true '>https://p.m.jd.com/norder/order.action?wareId="+itemId+"&wareNum=1&enterOrder=true</a>  \"," +
                                        "  \"summary\":\"库存提醒 JD商品名称："+itemName+" 库存变化为 "+itemState+" -> "+StockStateName+" \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1205\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        sendIds +
                                        "  ]}" ;
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);
                    }

                    itemState=StockStateName;
                }else{
                    if(firstCome) {
                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockStateName + " 直接链接为 <a href=' https://p.m.jd.com/norder/order.action?wareId=" + itemId + "&wareNum=1&enterOrder=true '>https://p.m.jd.com/norder/order.action?wareId=" + itemId + "&wareNum=1&enterOrder=true</a>  \"," +
                                        "  \"summary\":\"开启监控JD商品 " + itemName + " 成功 当前库存状态为 " + StockStateName + "  \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1205\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        sendIds +
                                        "  ]}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
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
