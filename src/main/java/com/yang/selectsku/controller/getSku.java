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

public class getSku implements Runnable  {

    public int time;
    public  String itemId;
    public  int  num;
    public int send;//1为白夜  2 为群霸
    public   String skuMessage="";
    public boolean firstCome=true;
    public String itemName;
    public boolean addStart=true;
    public boolean errorSend=true;
    public String areaName="广东";
    public String areaId="440106020";
    public  getSku(String itemId,int time,int send ,String itemName,boolean addStart){
        this.itemId=itemId;
        this.time=time;
        this.send=send;
        this.itemName=itemName;
        this.addStart=addStart;
    }
    public  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    public void run() {
        //判断发送的对象 1为白夜 2为群霸
        String sendIds;
        if(send==1){
            sendIds="      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" ";
        }else{
//            sendIds=  "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"";
            sendIds="      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" ";
            areaName="四川";
            areaId="510122";
        }
        while(1==1) {
            try {
                httpGet("https://mdskip.taobao.com/mobile/queryH5Detail.htm?decision=sku&itemId="+itemId+"&areaId="+areaId, "GBK", 1,sendIds,itemName);
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
    public static void main(String[] args) {//mao  20739895092   mate40  634411655593
        //pcCode = {11: '北京市', 12: '天津市', 13: '河北省', 14: '山西省', 15: '内蒙古自治区', 21: '辽宁省', 22: '吉林省',
//        //          23: '黑龙江省', 31: '上海市', 32: '江苏省', 33: '浙江省', 34: '安徽省', 35: '福建省', 36: '江西省',
//        //          37: '山东省', 41: '河南省', 42: '湖北省', 43: '湖南省', 44: '广东省', 45: '广西壮族自治区', 46: '海南省',
//        //          50: '重庆市', 51: '四川省', 52: '贵州省', 53: '云南省', 54: '西藏自治区', 61: '陕西省', 62: '甘肃省',
//        //          63: '青海省', 64: '宁夏回族自治区', 65: '新疆维吾尔自治区', 71: '台湾省', 81: '香港特别行政区', 82: '澳门特别行政区'}
//        getSku getSku;
//        getSku= new getSku("630047971548",1);//634411655593
//        getSku.run();
//        Thread mThread1=new Thread(getSku,"线程1");
//        mThread1.start();


    }

public  String httpGet(String url, String charset,int method,String sendIds,String itemName)
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
        //title
        JSONObject jsonArray = new JSONObject(json);
        JSONObject item = new JSONObject(jsonArray.getString("item") + "");
        String title=item.getString("title");
//        System.out.println(title);
        //sku
        JSONObject jsonArray2 = new JSONObject(jsonArray.get("skuCore") + "");
//        System.out.println(jsonArray2);
        JSONObject jsonArray3 = new JSONObject(jsonArray2.get("sku2info") + "");
//        System.out.println(jsonArray3);
        JSONObject jsonArray4 = new JSONObject(jsonArray3.get("0") + "");
//        System.out.println(jsonArray4);
        int newNum=Integer.parseInt(jsonArray4.get("quantity")+"");
        if(firstCome)
        System.out.println(df.format(new Date())+"title"+" 当前库存为 " + newNum);
        //skuMessage=title+" 当前库存为:"+newNum;
        if(num!=newNum) {
           if(firstCome) {
               if(addStart) {
                   String message =
                           " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                   "  \"content\":\" " + title + " 库存为" + newNum + "\"," +
                                   "  \"summary\":\"开启【淘宝-"+areaName+"】商品监控库存提醒 " + itemName + " 现在数量为 " + newNum + "<br>"+df.format(new Date())+" \"," +
                                   "  \"topicIds\":[ \n" +
                                   "      1205\n" +
                                   "  ]," +
                                   "  \"contentType\":2, " +
                                   "  \"uids\":[" +
                                   sendIds +
                                   "  ]}";
                   getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
               }
               num = newNum;
               firstCome=false;
           }else{
               String message =
                       " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                               "  \"content\":\" " + title + " 库存为" + newNum + "\"," +
                               "  \"summary\":\"【淘宝-"+areaName+"】" + itemName + "库存变化 " + num + " -> "+newNum+"<br>"+df.format(new Date())+" \"," +
                               "  \"topicIds\":[ \n" +
                               "      1205\n" +
                               "  ]," +
                               "  \"contentType\":2, " +
                               "  \"uids\":[" +
                               sendIds +
                               "  ]}";
               getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
               num = newNum;
           }
        }else{
            if(firstCome) {
                if(addStart) {
                    String message =
                            " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                    "  \"content\":\" " + title + "库存为" + newNum + "\"," +
                                    "  \"summary\":\"开启【淘宝-"+areaName+"】商品监控库存 " + itemName + " 现在数量为 " + newNum + "<br>"+df.format(new Date())+" \"," +
                                    "  \"topicIds\":[ \n" +
                                    "      1205\n" +
                                    "  ]," +
                                    "  \"contentType\":2, " +
                                    "  \"uids\":[" +
                                    sendIds +
                                    "  ]}";
                    getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                }
                firstCome = false;
            }
        }
    } catch (JSONException e) {
//        e.printStackTrace();
        if(errorSend){
            if(e.getMessage().contains("JSONObject[\"item\"] not found")){
                String message =
                        " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                "  \"content\":\" 商品id设置错误  \"," +
                                "  \"summary\":\"【淘宝-"+areaName+"】商品 " + itemName + " id设置错误，请检查 <br>"+df.format(new Date())+" \"," +
                                "  \"topicIds\":[ \n" +
                                "      1205\n" +
                                "  ]," +
                                "  \"contentType\":2, " +
                                "  \"uids\":[" +
                                sendIds +
                                "  ]}";
                getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
            }else{
                System.out.println(e.getMessage());
            }
            errorSend=false;
        }

    }



        return json;
    }
    public static String post(String url,String data) {
//        try {
//            URL url = new URL(strURL);// 创建连接
//            HttpURLConnection connection = (HttpURLConnection)
//                    url.openConnection();
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setUseCaches(false);
//            connection.setInstanceFollowRedirects(true);
//            connection.setRequestMethod("POST");// 设置请求方式
//            connection.setRequestProperty("Accept","application/json");// 设置接收数据的格式
//            connection.setRequestProperty("Content-Type","application/json");// 设置发送数据的格式
//            connection.connect(); OutputStreamWriter out = new OutputStreamWriter( connection.getOutputStream(),"UTF-8");// utf-8编码
//            out.append(params); out.flush(); out.close(); // 读取响应
//            int length = (int) connection.getContentLength();// 获取长度
//            InputStream is = connection.getInputStream();
//            if (length != -1){
//                byte[] data = new byte[length];
//                byte[] temp = new byte[512];
//                int readLen = 0; int destPos = 0;
//                while ((readLen = is.read(temp)) > 0){
//                    System.arraycopy(temp, 0, data, destPos, readLen);
//                    destPos += readLen;
//                }
//                String result = new String(data, "UTF-8");
//                System.out.println(result);
//                return result;
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        return "error";
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
    public  String getSkuMessage(){
        return skuMessage;
    }

}
