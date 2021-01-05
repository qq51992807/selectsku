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
import java.net.URI;
import java.net.URISyntaxException;

public class analysisKaoLa  {

    public StringBuffer stringBuffer=new StringBuffer();

    public String goodsId;

    public  analysisKaoLa(String goodsId){
        this.goodsId=goodsId;
    }


//    public static void  main(String[] args){
//        analysisKaoLa analysisKaoLa=new analysisKaoLa("5481535");//5481535
////        long time=System.currentTimeMillis();
//
//          //  analysisKaoLa.httpGet("https://goods.kaola.com/product/getPcGoodsDetailDynamic.json?provinceCode=440000&cityCode=440100&districtCode=440106&goodsId=8234486&categoryId=7991&t="+time+"&t="+time,"UTF-8");
//        analysisKaoLa.getkaolaInfo(analysisKaoLa.goodsId);//8234486
//        System.out.println(analysisKaoLa.stringBuffer);
//
//    }



    public  String httpGet(String url,String charset)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();
        HttpClient client = new DefaultHttpClient();
//        HttpHost proxy = new HttpHost("127.0.0.1", 8423);
////        client.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY,
////                proxy);
// 设置参数
        try {
            httpGet.setURI(new URI(url));
//            httpGet.setHeader("x-forwarded-for","127.0.0.1");
            // httpGet.setHeader("Accept-Encoding","gzip, deflate, br");
//            httpGet.setHeader("accept","*/*");
//            httpGet.setHeader("authority","goods.kaola.com");
//            httpGet.setHeader("sec-fetch-site","same-origin");
//            httpGet.setHeader("sec-fetch-mode","cors");
//            httpGet.setHeader("sec-fetch-dest","empty");
//            httpGet.setHeader("content-type","application/x-www-form-urlencoded");
            httpGet.setHeader("cookie", "davisit=68; kaola_user_key=ad0c2ea6-bdc2-4a36-85b9-e5041c01a035; JSESSIONID-WKL-8IO=BUX9vHqMIPWDJezDseWbWKWXje4yT%2B0IwLBg68C%2FdoCw%2FHDj7Tv2%2B7a78V341jZmIaB1L2s1jT9sa9Q6zEQxP8vuPlSWzbckm9hrxJDEQ%2FNcotGHdOf6SpLfRl%5C4PHc6fmh7j5CBq%2FGtq4H01Z6%5COt%5CeP%5CtbfZotWSAV5w%2Foa7y%2F1Vgv%3A1609121550251; _klhtxd_=31; __da_ntes_utma=2525167.1415907335.1609035151.1609035151.1609035151.1; davisit=1; cna=RQ4nGIfDnzsCARsvBvc0GViC; KAOLA_NEW_USER_COOKIE=yes; xlly_s=1; NTES_KAOLA_ADDRESS_CONTROL=440000|440100|440106|3; cookie2=18e0b17d4beac7b2e4f5db709682c1bf; t=7f099a6fc2a970557ce5403b36cc6008; _tb_token_=14333503573e; __da_ntes_utmfc=1; __da_ntes_utmz=1; hb_MA-AE38-1FCC6CD7201B_source=pages.kaola.com; __da_ntes_utmb=2525167.1.10.1609054062; NTES_KAOLA_RV=1803320|8234486; x5sec=7b227761676272696467652d616c69626162612d67726f75703b32223a223234303334363663653136363865616431386334636135633263623531636634434f33756f503846454a544c78762f35753658517341453d227d; l=eBMziQaeO8WyecdxBO5BFurza77TUIRb8PVzaNbMiInca6GF9FtTtNQ2XpcWWdtjgtCvnetrJmGnARIE334dVxDDBevuIQP-FxvO.; tfstk=cne5BpiqfUY7BB5eUusqYZty-9kCaJtsA_guV743qLSJCEESksfWQVi8UWYpHfnf.; isg=BNLSgsNH2YUP3yV2IQrAwR48I5i049Z9Sfomq5wr1AVxr3KphHFcjHmBH0s22k4V");
//            httpGet.setHeader("referer","https://goods.kaola.com/product/8234486.html?spm=a2v0d.13659821.0.0.fa6522c8uNTfBk&kpm=MTAwMg%3D%3D.OTgwNDk%3D.MjY1MTEwNw%3D%3D.MQ%3D%3D%40%40Xw%3D%3D&_h5da=true");

        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。" + e.getMessage());
        }
// 发送请求

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

//        try {

//            JSONObject jsonArray = new JSONObject(json);
////
//
//            JSONObject data = new JSONObject(jsonArray.getString("data") + "");
////            JSONObject skuDetailList = new JSONObject(data.get("skuDetailList") + "");
//            JSONArray array = JSONArray.fromObject(data.get("skuDetailList") + "");
//            for(int i=0;i<array.size();i++){
//                net.sf.json.JSONObject Allsku = ( net.sf.json.JSONObject) array.get(i);
//                JSONObject skuInfo = new JSONObject(Allsku.getString("skuInfo") + "");
////                JSONObject skuPropertyList = new JSONObject(skuInfo.getString("skuPropertyList") + "");
//                JSONArray skuPropertyList = JSONArray.fromObject(skuInfo.get("skuPropertyList") + "");
////                JSONObject skuPropertyList0 = new JSONObject(skuPropertyList.getString("0") + "");
////                JSONObject skuPropertyList1 = new JSONObject(skuPropertyList.getString("1") + "");
//                net.sf.json.JSONObject skuPropertyList0 =  ( net.sf.json.JSONObject) skuPropertyList.get(0);
//                net.sf.json.JSONObject skuPropertyList1 =  ( net.sf.json.JSONObject) skuPropertyList.get(1);
//                String color=skuPropertyList0.get("propertyName")+""+skuPropertyList0.get("propertyValue")+"";
//                String size=skuPropertyList1.get("propertyName")+""+skuPropertyList1.get("propertyValue")+"";
//                stringBuffer.append(color+size);
//                if(i!=array.size()-1){
//                    stringBuffer.append(",");
//                }
////                System.out.println(color+size);
//            }

            //sku
            // String StockStateName = item.getString("StockStateName");
            //  System.out.println("商品编号：" + itemId + "当前库存为 " + StockStateName);
            // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;


//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
            return json;
//        }
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
    public void getkaolaInfo(String goodsId){//8234486
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
            for(int i=0;i<array.size();i++){
                net.sf.json.JSONObject Allsku = ( net.sf.json.JSONObject) array.get(i);
                JSONObject skuInfo = new JSONObject(Allsku.getString("skuInfo") + "");
                JSONArray skuPropertyList = JSONArray.fromObject(skuInfo.get("skuPropertyList") + "");
                net.sf.json.JSONObject skuPropertyList0 =  ( net.sf.json.JSONObject) skuPropertyList.get(0);
                String color=skuPropertyList0.get("propertyName")+""+skuPropertyList0.get("propertyValue")+"";
                StringBuffer size=new StringBuffer();
                if(skuPropertyList.size()!=1) {
                    net.sf.json.JSONObject skuPropertyList1 = (net.sf.json.JSONObject) skuPropertyList.get(1);
                    size.append(skuPropertyList1.get("propertyName")+""+skuPropertyList1.get("propertyValue")+"");
                }


                int j=i+1;
                stringBuffer.append("("+j+")"+color+" "+size.toString()+"  ");
//                System.out.println(color+size);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
