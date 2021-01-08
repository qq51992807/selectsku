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

public class getDySku implements Runnable{

    public int time;
    public  String itemId;
    public String itemName;
    public  int  num=0;
    public boolean firstCome=true;

    public testDyBuy testDyBuy=new testDyBuy();

    public getDySku(String itemId,String itemName,int time){
        this.itemId=itemId;
        this.itemName=itemName;
        this.time=time;
    }

    public void run(){
        while (1==1) {
            try {
                httpGet("https://ec.snssdk.com/product/getstock?id=" + itemId, itemId, itemName);
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

//    public static  void main(String args[]){
//        getDySku getDySku=new getDySku("3449075513329613691","mate40",3);
//        Thread mThread1=new Thread(getDySku,"线程1");
//        mThread1.start();
//    }


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
        try {
                JSONObject jsonArray = new JSONObject(json);
            JSONObject data = new JSONObject(jsonArray.getString("data") + "");
            //sku
            int StockNum=Integer.parseInt(data.getString("total_stock_num"));
            System.out.println(df.format(new Date())+" 商品编号："+itemId+" 商品名称为："+itemName+" 当前库存状态为 " + StockNum);
            // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;

            if(num!=StockNum){
                if(firstCome){
                    String message=
                            " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                    "  \"content\":\"商品名称："+itemName+" 当前库存状态为 "+StockNum+ " \"," +
                                    "  \"summary\":\"开启抖音监控商品 "+itemName+" 成功 当前库存状态为 "+StockNum+"  \"," +
                                    "  \"topicIds\":[ \n" +
                                    "      1205\n" +
                                    "  ]," +
                                    "  \"contentType\":2, " +
                                    "  \"uids\":[" +
                                    "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\""+
                                    ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" "+
                                    "  ]}" ;
                    getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);
                    firstCome=false;
                    num=StockNum;
                }else{
                    //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);


                        String message=
                            " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                    "  \"content\":\"商品名称："+itemName+" 库存变化为 "+num+" -> "+StockNum+ " \"," +
                                    "  \"summary\":\"库存提醒 抖音商品名称："+itemName+" 库存变化为 "+num+" -> "+StockNum+" \"," +
                                    "  \"topicIds\":[ \n" +
                                    "      1205\n" +
                                    "  ]," +
                                    "  \"contentType\":2, " +
                                    "  \"uids\":[" +
                                    "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\""+
                                    ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                    "  ]}" ;
                    getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);


                    if(itemId.equals("3453521734500751426")){//mate40
                        sendMessageDy( testDyBuy.post( itemId, "1422354648"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354655"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354649"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354657"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354650"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354659"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354651"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354661"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354653"));
                        sendMessageDy( testDyBuy.post( itemId, "1422354662"));
                    }else if(itemId.equals("3452440959718151364")){ //mate40p
                        sendMessageDy( testDyBuy.post( itemId, "1394047553"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047554"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047555"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047556"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047557"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047558"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047559"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047560"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047561"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047562"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047563"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047564"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047565"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047566"));
                        sendMessageDy( testDyBuy.post( itemId, "1394047567"));
                    }else if(itemId.equals("3454856842449155193")){ //nova8 3454856842449155193
                        sendMessageDy( testDyBuy.post( itemId, "1458560510"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560514"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560511"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560515"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560512"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560517"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560513"));
                        sendMessageDy( testDyBuy.post( itemId, "1458560518"));
                    }else if(itemId.equals("3449855221851887670")) { //保时捷 3449855221851887670
                        sendMessageDy( testDyBuy.post( itemId, "1313132626"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132628"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132627"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132629"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132630"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132632"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132631"));
                        sendMessageDy( testDyBuy.post( itemId, "1313132633"));
                    }else if(itemId.equals("3454861367230727564")) { //nova8p 3454861367230727564
                        sendMessageDy( testDyBuy.post( itemId, "1458855405"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855410"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855406"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855411"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855408"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855412"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855409"));
                        sendMessageDy( testDyBuy.post( itemId, "1458855414"));
                    }


                    num=StockNum;
                }
            }else{
                if(firstCome) {
                    String message=
                            " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                    "  \"content\":\"商品名称："+itemName+" 当前库存状态为 "+StockNum+ " \"," +
                                    "  \"summary\":\"开启抖音监控商品 "+itemName+" 成功 当前库存状态为 "+StockNum+"  \"," +
                                    "  \"topicIds\":[ \n" +
                                    "      1205\n" +
                                    "  ]," +
                                    "  \"contentType\":2, " +
                                    "  \"uids\":[" +
                                    "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\""+
                                    ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" "+
                                    "  ]}" ;
                    getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);
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

    void sendMessageDy(String response){
        String message=
                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                        "  \"content\":\"抖音提交结果 ："+response+"  \"," +
                        "  \"summary\":\"抖音提交结果 ："+response+"  \"," +
                        "  \"topicIds\":[ \n" +
                        "      1205\n" +
                        "  ]," +
                        "  \"contentType\":2, " +
                        "  \"uids\":[" +
                        "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\""+
                        "  ]}" ;
        getSku.post("http://wxpusher.zjiecode.com/api/send/message",message);
    }

}
