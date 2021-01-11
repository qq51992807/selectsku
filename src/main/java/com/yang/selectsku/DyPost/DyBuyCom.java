package com.yang.selectsku.DyPost;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DyBuyCom {


//    public String cookie="passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3Ae73ef71f7034400eba58dccabb9af11c; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; odin_tt=40e3b5563f4989145665b5ff815766daf9e3a622beb0c7d98f5e2fcf57c5343391d5733740c7e8764ae4fe901069c57c; sessionid=e73ef71f7034400eba58dccabb9af11c; sessionid_ss=e73ef71f7034400eba58dccabb9af11c; sid_guard=e73ef71f7034400eba58dccabb9af11c%7C1610330943%7C5184000%7CFri%2C+12-Mar-2021+02%3A09%3A03+GMT; sid_tt=e73ef71f7034400eba58dccabb9af11c; uid_tt=58766eacf7c338b92bc4decf7f61cc34; uid_tt_ss=58766eacf7c338b92bc4decf7f61cc34; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874";
//    public String addressId="6837435314240340236";
//    public String authorId="66916631931";

    public  String cookie=null;
    public String addressId=null;
    public String authorId=null;
    public String comboId=null;
    public String productId=null;

    public DyBuyCom(String cookie,String addressId,String authorId,String comboId,String productId){
        this.cookie=cookie;
        this.addressId=addressId;
        this.authorId=authorId;
        this.comboId=comboId;
        this.productId=productId;

    }
    public  String post() {

        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
//

                PostMethod postMethod = null;
                postMethod = new PostMethod("https://ec.snssdk.com/order/newcreate") ;
                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
                postMethod.setRequestHeader("User-Agent","Aweme 11.1.0 rv:141017 (iPhone; iOS 11.2; zh_CN) Cronet");
               postMethod.setRequestHeader("Cookie",cookie);


//参数设置，需要注意的就是里边不能传NULL，要传空字符串
                NameValuePair[] data2 = {
                        new NameValuePair("json_form"," {\"b_type\":2," +
//                                "\"env_type\":\"1\",\"activity_id\":\"\",\"origin_type\":\"3002002002\"," +
//                                "\"origin_id\":\"3333330376333880_3457057351729847491\"," +
                                "\"new_source_type\":\"product_detail\",\"new_source_id\":\"0\"," +
                                "\"source_type\":\"0\",\"source_id\":\"0\",\"schema\":\"sslocal://\"," +
                                "\"combo_id\":"+comboId+"," +
                                "\"combo_num\":1," +
                                "\"product_id\":"+productId+"," +
                                "\"buyer_words\":\"\"," +
                                "\"area_type\":\"169\"," +
//                                "\"warehouse_id\":6882858266968343000," +
                                "\"post_addr\":" +
                                "{\"province\":{\"id\":\"440000\",\"name\":\"广东省\"},\"city\":{\"id\":\"440100\",\"name\":\"广州市\"}," +
                                "\"town\":{\"id\":\"440106\",\"name\":\"天河区\"}," +
                                "\"detail\":\"\"}," +
                                "\"post_receiver\":\"杨先生\"," +
                                "\"post_tel\":\"135****0143\"," +
                                "\"address_id\":\""+addressId+"\"," +
                                "\"freight_insurance\":true," +
                                "\"gray_feature\":\"PlatformFullDiscount\"," +
                                "\"sub_way\":0,\"pay_type\":2,\"s_type\":\"\",\"room_id\":\"\",\"shop_user_id\":\"\"," +
                               "\"author_id\":\""+authorId+"\"," +
                                "\"sdk_version\":\"v2\"}" +
                                ""),
                        new NameValuePair("request_tag_from","lynx")


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
