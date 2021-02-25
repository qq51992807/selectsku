package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.userAgents;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.Random;

public class autoSendMessageLive {
      String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
    String xCookie="install_id=3993839559263757; ttreq=1$92c997f9f4a0e9b9d1895c89e46e1df6198a5762; passport_csrf_token=e9e998a9b301ed4c70808ef2e5f60d27; passport_csrf_token_default=e9e998a9b301ed4c70808ef2e5f60d27; d_ticket=42604e0fc8e7c2dc6782794070a8d3a61edd1; multi_sids=1472985216323047%3A4e9612523e552f72ba8e9dcc8b92cbec; odin_tt=c7d50a30ea6d22a428e9f190c6af9ee1a739bbbe49a1d1cc8f1501858f93b184546b62915b958a2c5fef562dcfebcea8a87350c2a9a2e166e3afa4f6c6440762; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=4e9612523e552f72ba8e9dcc8b92cbec%7C1610859650%7C5184000%7CThu%2C+18-Mar-2021+05%3A00%3A50+GMT; uid_tt=5e9c4bc12abc49d2135e94040578419d; uid_tt_ss=5e9c4bc12abc49d2135e94040578419d; sid_tt=4e9612523e552f72ba8e9dcc8b92cbec; sessionid=4e9612523e552f72ba8e9dcc8b92cbec; sessionid_ss=4e9612523e552f72ba8e9dcc8b92cbec";
    String buffer[]={"啊","嗯","哦","喔",};


    public static void main(String args[]){
        autoSendMessageLive autoSendMessageLive=new autoSendMessageLive();
        Random random=new Random();
        while(1==1){
            String s="我是小甜甜";
            StringBuffer stringBuffer=new StringBuffer();
            stringBuffer.append(s);
            int num=random.nextInt(autoSendMessageLive.buffer.length);
            for(int i=0;i<num;i++){
                stringBuffer.append(",");
                stringBuffer.append(s);
            }
//            stringBuffer.append(autoSendMessageLive.buffer[num]);
            System.out.println(stringBuffer.toString());
            System.out.println(autoSendMessageLive.post( stringBuffer.toString()));
            System.out.println(autoSendMessageLive.post( "我是小甜甜。。。。。。"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }


    public  String post(String s) {

        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
//

                PostMethod postMethod = null;
                postMethod = new PostMethod("https://webcast3-normal-act-lq.amemv.com/webcast/room/chat/?iid=360681930071764&aid=1128") ;
//                postMethod = new PostMethod("https://webcast3-normal-c-lq.huoshan.com/webcast/room/chat/?iid=2850347468465390&aid=1112") ;
                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8") ;
                postMethod.setRequestHeader("User-Agent", userAgents.generate());
                postMethod.setRequestHeader("Cookie",baiyeCookie);


//参数设置，需要注意的就是里边不能传NULL，要传空字符串

                NameValuePair[] data2 = {
                        new NameValuePair("common_label_list"," "),
                        new NameValuePair("content",s),
                        new NameValuePair("enter_source",""),
                        new NameValuePair("request_id",""),
                        new NameValuePair("room_id","6926809686276688655")
                };
                postMethod.setRequestBody(data2);

                org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
                int response2 = httpClient.executeMethod(postMethod); // 执行POST方法
                String result = postMethod.getResponseBodyAsString() ;
                return result;


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
