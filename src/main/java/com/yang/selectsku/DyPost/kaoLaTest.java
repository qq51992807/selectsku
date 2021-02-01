package com.yang.selectsku.DyPost;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class kaoLaTest {

    public static void main(String args[]){
        kaoLaTest kaoLaTest=new kaoLaTest();
        kaoLaTest.post();
    }

    String  cookie="kaola-user-beta-traffic=19013207289; current_env=testjd; ucn=center; isg=BObmTFHdunS0xG7Qi8pt6PGMPVhoxyqBVfGzl9CP0InkU4RtOFdtkfIzrYn6YCKZ; KAOLA_USER_ID=109999078399525227; KAOLA_MAIN_ACCOUNT=yd.15c70d57054b46fda@163.com; KAOLA_MAIN_ACCOUNT.sig=p3kgGFznl5q1mS8IVl8y-gEPGGA6LI_UaMeolMXezyY; KAOLA_USER_ID.sig=FBv6QCGx0tWqq-3mJn5dzI4n6q5QFrwH5Up3IQAFVgw; kaola-user-beta-traffic.sig=m4PE7BPwn3cXdd-lu7lnLejLzIV5ZXM9awfyDFcZlj8; JSESSIONID-WKL-8IO=0r/cst7ssvdQTnkuvT1Dd4b2ycNJaqhbKn5MG58tjZzbRWsECn62o8xGLlu0X/+lhMcmtSLR4csXYdwbvhhd0szG+0RnUQHQgSfU2mZ1QAorbKJjgAjMnXitsfnosOD0+ib6+0AtJx25oYlv4WMCVE+iZPPjMxlbvo0ly2+IvyP5fZMK:1611062945242; _klhtxd_=31; _tb_token_=fe9e8a4939f49; cookie2=1643b8712402727585a6aee4269abde3; csg=54e96f14; kaola_csg=422d0e9e; munb=2207161234257; t=9e761ffa04f4231a2f7e673eaecea0c3; unb=2207161234257; cna=NXmMGPwPlmQCAXBezChYdIju; kaola_user_key=3352fbaf-7ec3-4fdf-9d51-6cbf7632c9c5";
    public  String post() {

        String response = null;
        String data="{\"orderApi\":{\"mustCreateOrder\":0,\"idfa\":\"B84A2B7E8D23577F2D50FAB0D2AD4042D155893B0027FFFE23CB3B72D28AC7A4CBDC40D9EAC6E0C0F4CBF7193B1059D6\",\"orderForm\":{\"goods\":[{\"tempGoodsActivityType\":\"\",\"goodsType\":0,\"isHuanGou\":0,\"innerSource\":\"DETAIL-CONFIRM\",\"tempCurrentPrice\":240,\"skuId\":\"20359565530\",\"formGoodsType\":0,\"tempBuyAmount\":1,\"instalment\":0,\"activitySchemeId\":0,\"selected\":1,\"goodsId\":\"5758477\",\"choosePriceType\":0}],\"redPacketStatus\":2,\"orderInvoiceDTO\":{},\"consumptionGoldParam\":{\"useStatus\":0},\"useRedPacket\":null,\"s\":\"2\",\"address\":{\"addressId\":7462707063},\"allowanceParam\":{\"useStatus\":0},\"orderType\":1000,\"creditsDetailParamDtoList\":[],\"logisticsAmount\":0,\"submitFrom\":0,\"depositId\":0,\"confirmOrderSerialId\":\"1760590810\",\"extendPreviewData\":\"{\\\"callbackRequest\\\":{\\\"renderBuy2\\\":false,\\\"requestCheckId\\\":\\\"e8f202b9dc25f389c9c3beba910ed0be\\\",\\\"tradeOrderDTOList\\\":[{\\\"importType\\\":1,\\\"orderLineDTOList\\\":[{\\\"activitySchemeId\\\":0,\\\"formGoodsType\\\":0,\\\"goodsId\\\":5758477,\\\"goodsIdentify\\\":\\\"0\\\",\\\"skuId\\\":\\\"20359565530\\\",\\\"tempBuyAmount\\\":1}],\\\"sellSupplierType\\\":1000,\\\"warehouseId\\\":9001}]},\\\"vipRightAllowed\\\":true}\",\"vipRelatedBuyParam\":{\"relatedOptType\":0,\"relatedBuyVipInt\":0,\"relatedBuyVipAmount\":279,\"relatedBuyVipSaveAmount\":73.090000000000003,\"relatedBuyVipType\":1}},\"couponList\":[],\"forceCreateOrder\":0,\"supportQuantity\":1}}";
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost("https://gw.kaola.com/gw/user/order/V387");
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httppost.setHeader("Cookie",cookie);
                httppost.setHeader("aaid","2488B451-029E-AA66-DE4C-279E2140578E");
                httppost.setHeader("klauserid","109999078399525227");
                httppost.setHeader("wua","QnIk_OOIBPWPKsqUmg4OtybaZp%2Bo1M0uslnA0ThI7earXebynamuZxC7cHaQxKvawD1926BtEKRV2u58%2BHR9YldZ8GHAX3yWJLVbsfwrB4QQRtkdnqbsVb6MfW0UFc6xZQcT7YPZj74JVCcfvI%2F1JeIeIww7mlJIWNNg76X1CC41P2JdU1pEBIQNQ1i%2FrTpD6Yp5Gc%2BiN6geCNK%2BUvIJWIusPzOuYjeCMyshdDdGHMKNkEOnBFJnCYmdOJ%2BhPAYXkJdAL3NFubDpbpcmayOPUlZAit6inJzWFag8u9zw8jBZxooULxr9MaaKQusiClAUKW2MRKvz1Y5gEQ%2BRpUoyqEf7nK0na5t62fQi6%2FaailtUwowbYZJc8CWsjUIGUPkAlz9jRPUUTCN3drPEkIusN%2BGjS13p9r9ToaL7peGPWoecWyzs%3D");
                httppost.setHeader("ursAuth","C111A6B55E89962C4A4103388E6826AF1D105FBC5959029F9438CAE73BBF7C784E4BAF59E2104055DFB807075A356377E71B72EF5A5033C7954385D03B8CD81C");
                httppost.setHeader("kaola_user_key","3352fbaf-7ec3-4fdf-9d51-6cbf7632c9c5");

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

//        try {
//            CloseableHttpClient httpclient = null;
//            CloseableHttpResponse httpresponse = null;
//            try {
//                httpclient = HttpClients.createDefault();
////
//
//                PostMethod postMethod = null;
//                postMethod = new PostMethod("https://ec.snssdk.com/order/newcreate") ;
//                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
////                postMethod.setRequestHeader("User-Agent","Aweme 11.1.0 rv:141017 (iPhone; iOS 11.2; zh_CN) Cronet");
//                postMethod.setRequestHeader("Cookie",cookie);
//
//                NameValuePair[] data2 = {
//                        new NameValuePair("json_form"," "),
//                        new NameValuePair("request_tag_from","lynx")
//                };
//                postMethod.setRequestBody(data2);
//
//                org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
//                int response2 = httpClient.executeMethod(postMethod); // 执行POST方法
//                String result = postMethod.getResponseBodyAsString() ;
//
//                return result;
//
//
////                System.out.println("response: " + response);
//            } finally {
//                if (httpclient != null) {
//                    httpclient.close();
//                }
//                if (httpresponse != null) {
//                    httpresponse.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return response;
    }
}
