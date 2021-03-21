package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.userAgents;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.Random;

public class DyBuyCom2 {


//    public String cookie="passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3Ae73ef71f7034400eba58dccabb9af11c; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; odin_tt=40e3b5563f4989145665b5ff815766daf9e3a622beb0c7d98f5e2fcf57c5343391d5733740c7e8764ae4fe901069c57c; sessionid=e73ef71f7034400eba58dccabb9af11c; sessionid_ss=e73ef71f7034400eba58dccabb9af11c; sid_guard=e73ef71f7034400eba58dccabb9af11c%7C1610330943%7C5184000%7CFri%2C+12-Mar-2021+02%3A09%3A03+GMT; sid_tt=e73ef71f7034400eba58dccabb9af11c; uid_tt=58766eacf7c338b92bc4decf7f61cc34; uid_tt_ss=58766eacf7c338b92bc4decf7f61cc34; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874";
//    public String addressId="6837435314240340236";
//    public String authorId="66916631931";
public  String cookie=null;
    public String addressId=null;
    public String authorId=null;
    public String comboId=null;
    public String productId=null;
    public String[] addressList;

    public DyBuyCom2(String cookie,String addressId,String authorId,String comboId,String productId,String[] addressList){
        this.cookie=cookie;
        this.addressId=addressId;
        this.authorId=authorId;
        this.comboId=comboId;
        this.productId=productId;
        this.addressList=addressList;

    }
    public  String post() {

        String response = null;
        Random rand = new Random();

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
//                postMethod.setRequestHeader("User-Agent", userAgents.generate());
                postMethod.setRequestHeader("Cookie",cookie);


//参数设置，需要注意的就是里边不能传NULL，要传空字符串
//                NameValuePair[] data2 = {
//                        new NameValuePair("json_form"," {\"b_type\":2," +
////                                "\"env_type\":\"1\",\"activity_id\":\"\",\"origin_type\":\"3002002002\"," +
////                                "\"origin_id\":\"3333330376333880_3457057351729847491\"," +
//                                "\"new_source_type\":\"product_detail\",\"new_source_id\":\"0\"," +
//                                "\"source_type\":\"0\",\"source_id\":\"0\",\"schema\":\"sslocal://\"," +
//                                "\"combo_id\":"+comboId+"," +
//                                "\"combo_num\":1," +
//                                "\"product_id\":"+productId+"," +
//                                "\"buyer_words\":\"\"," +
//                                "\"area_type\":\"169\"," +
////                                "\"warehouse_id\":6882858266968343000," +
//                                "\"post_addr\":" +
//                                "{\"province\":{\"id\":\"440000\",\"name\":\"广东省\"},\"city\":{\"id\":\"440100\",\"name\":\"广州市\"}," +
//                                "\"town\":{\"id\":\"440106\",\"name\":\"天河区\"}," +
//                                "\"detail\":\"\"}," +
//                                "\"post_receiver\":\"杨先生\"," +
//                                "\"post_tel\":\"135****0143\"," +
//                                "\"address_id\":\""+addressId+"\"," +
//                                "\"freight_insurance\":true," +
//                                "\"gray_feature\":\"PlatformFullDiscount\"," +
//                                "\"sub_way\":0,\"pay_type\":2,\"s_type\":\"\",\"room_id\":\"\",\"shop_user_id\":\"\"," +
//                               "\"author_id\":\""+authorId+"\"," +
//                                "\"sdk_version\":\"v2\"}" +
//                                ""),
//                        new NameValuePair("request_tag_from","lynx")
//                };
//                NameValuePair[] data2 = {
//                        new NameValuePair("json_form"," {\"b_type\":2," +
////                                "\"env_type\":\"1\",\"activity_id\":\"\",\"origin_type\":\"3002002002\"," +
////                                "\"origin_id\":\"3333330376333880_3457057351729847491\"," +
//                                "\"new_source_type\":\"product_detail\",\"new_source_id\":\"0\"," +
//                                "\"source_type\":\"0\",\"source_id\":\"0\",\"schema\":\"sslocal://\"," +
//                                "\"combo_id\":"+comboId+"," +
//                                "\"combo_num\":1," +
//                                "\"product_id\":"+productId+"," +
//                                "\"buyer_words\":\"\"," +
//                                "\"coupon_info\":{}," +
//                                "\"stock_info\":[{\"stock_type\":3,\"stock_num\":1,\"warehouse_id\":\"0\",\"sku_id\":\""+comboId+"\"}]," +
//                                "\"area_type\":\"169\"," +
//                                "\"warehouse_id\":0," +
////                                "\"warehouse_id\":6882858266968343000," +
//                                "\"post_addr\":" +
//                                "{\"province\":{\"id\":\""+addressList[2]+"\",\"name\":\""+addressList[3]+"\"},\"city\":{\"id\":\""+addressList[4]+"\",\"name\":\""+addressList[5]+"\"}," +
//                                "\"town\":{\"id\":\""+addressList[6]+"\",\"name\":\""+addressList[7]+"\"}," +
//                                "\"detail\":\""+addressList[8]+"\"}," +
//                                "\"post_receiver\":\""+addressList[0]+"\"," +
//                                "\"post_tel\":\""+addressList[1]+"\"," +
//                                "\"address_id\":\""+addressId+"\"," +
//                                "\"freight_insurance\":true," +
//                                "\"gray_feature\":\"PlatformFullDiscount\"," +
//                                "\"sub_way\":0,\"pay_type\":2,\"s_type\":\"\",\"room_id\":\"\",\"shop_user_id\":\"\"," +
//                                "\"author_id\":\""+authorId+"\"," +
//                                "\"sdk_version\":\"v2\"}" +
//                                ""),
//                        new NameValuePair("request_tag_from","lynx")
//                };
//                NameValuePair[] data2 = {
//                        new NameValuePair("json_form"," {\"b_type\":1,\"env_type\":\"1\",\"activity_id\":\"\"," +
//                                "\"origin_type\":\"3001002000\",\"origin_id\":\"3333330376333880_3459275358950588079\"," +
//                                "\"new_source_type\":\"product_detail\",\"new_source_id\":\"0\",\"source_type\":\"0\"," +
//                                "\"source_id\":\"0\",\"schema\":\"sslocal://\"," +
//                                "\"extra\":\"{\\\"alkey\\\":\\\"1112_3333330376333880_0_3459275358950588079_010\\\"," +
//                                "\\\"buyin_track\\\":\\\"CNgIELi0gKjX9PUFGgQIABAAIgAor_2LtMaT9IAwMAI\\\"," +
//                                "\\\"c_biz_combo\\\":\\\"8\\\"}\",\"entrance_params\":\"{\\\"ecom_group_type\\\":\\\"video\\\"," +
//                                "\\\"carrier_source\\\":\\\"store_page\\\",\\\"source_method\\\":\\\"\\\"}\"," +
//                                "\"combo_id\":\""+comboId+"\",\"combo_num\":1,\"product_id\":\""+productId+"\"," +
//                                "\"buyer_words\":\"\",\"coupon_info\":{},\"area_type\":\"169\"," +
//                                "\"warehouse_id\":\"\"," +
//                                "\"post_addr\":" +
//                                "{\"province\":{\"id\":\""+addressList[2]+"\",\"name\":\""+addressList[3]+"\"},\"city\":{\"id\":\""+addressList[4]+"\",\"name\":\""+addressList[5]+"\"}," +
//                                "\"town\":{\"id\":\""+addressList[6]+"\",\"name\":\""+addressList[7]+"\"}," +
//                                "\"detail\":\""+addressList[8]+"\"}," +
//                                "\"post_receiver\":\""+addressList[0]+"\"," +
//                                "\"post_tel\":\""+addressList[1]+"\"," +
//                                "\"address_id\":\""+addressId+"\"," +
//                                "\"freight_insurance\":true," +
//                                "\"stock_info\":[{\"stock_type\":2,\"stock_num\":1," +
//                                "\"warehouse_id\":\"\",\"skuId\":\""+comboId+"\"}]," +
//                                "\"gray_feature\":\"PlatformFullDiscount\",\"sub_way\":0,\"pay_type\":2," +
//                                "\"s_type\":\"\",\"room_id\":\"\",\"content_id\":\"0\",\"author_id\":\"3333330376333880\"," +
//                                "\"shop_user_id\":\"\",\"sub_b_type\":\"3\"," +
//                                "\"price_info\":{\"origin\":1580,\"freight\":0,\"coupon\":0,\"pay\":1580}" +
//                                "}" +
//                                "")
//                };
                NameValuePair[] data2 = {
                        new NameValuePair("json_form","{\"b_type\":2,\"env_type\":\"1\",\"activity_id\":\"\"," +
                                "\"origin_type\":\"3002070010\",\"origin_id\":\"791240065681438_3454310666498894355\"," +
                                "\"new_source_type\":\"product_detail\",\"new_source_id\":\"0\",\"source_type\":\"0\"," +
                                "\"source_id\":\"0\",\"schema\":\"sslocal://\",\"extra\":\"{\\\"page_type\\\":\\\"lynx\\\"," +
                                "\\\"alkey\\\":\\\"1128_791240065681438_0_3454310666498894355_010\\\",\\\"c_biz_combo\\\":\\\"8\\\"," +
                                "\\\"risk_info\\\":\\\"{\\\\\\\"ac\\\\\\\":\\\\\\\"WIFI\\\\\\\",\\\\\\\"amount\\\\\\\":\\\\\\\"2990\\\\\\\"," +
                                "\\\\\\\"app_id\\\\\\\":1128,\\\\\\\"app_name\\\\\\\":\\\\\\\"aweme\\\\\\\"," +
                                "\\\\\\\"brand\\\\\\\":\\\\\\\"iPhone"+rand.nextInt(12)+",1\\\\\\\"," +
                                "\\\\\\\"channel\\\\\\\":\\\\\\\"App Store\\\\\\\",\\\\\\\"checkout_id\\\\\\\":1," +
                                "\\\\\\\"device_platform\\\\\\\":\\\\\\\"iphone\\\\\\\",\\\\\\\"device_type\\\\\\\":\\\\\\\"iPhone10,1\\\\\\\"," +
                                "\\\\\\\"did\\\\\\\":\\\\\\\"70599853338\\\\\\\",\\\\\\\"iid\\\\\\\":\\\\\\\"2938330485358728\\\\\\\"," +
                                "\\\\\\\"ip\\\\\\\":\\\\\\\"112.94."+rand.nextInt(100)+".131\\\\\\\"," +
                                "\\\\\\\"openudid\\\\\\\":\\\\\\\"77367eb045b95e6c5b202b191e883e7f3d680b7d\\\\\\\"," +
                                "\\\\\\\"os_version\\\\\\\":\\\\\\\"14.2\\\\\\\"," +
                                "\\\\\\\"sub_order_info\\\\\\\":[{\\\\\\\"author_id\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"card_id\\\\\\\":0," +
                                "\\\\\\\"checkout_id\\\\\\\":\\\\\\\"1\\\\\\\"," +
                                "\\\\\\\"commodity_amount\\\\\\\":\\\\\\\"2990\\\\\\\"," +
                                "\\\\\\\"commodity_ec_discount_amount\\\\\\\":\\\\\\\"0\\\\\\\"," +
                                "\\\\\\\"first_cid\\\\\\\":\\\\\\\"20018\\\\\\\",\\\\\\\"fourth_cid\\\\\\\":\\\\\\\"0\\\\\\\"," +
                                "\\\\\\\"is_preorder\\\\\\\":0,\\\\\\\"new_source_type\\\\\\\":\\\\\\\"product_detail\\\\\\\"," +
                                "\\\\\\\"origin_id\\\\\\\":\\\\\\\"791240065681438_3454310666498894355\\\\\\\"," +
                                "\\\\\\\"origin_type\\\\\\\":3002070010,\\\\\\\"price\\\\\\\":\\\\\\\"2990\\\\\\\"," +
                                "\\\\\\\"product_id\\\\\\\":\\\\\\\""+productId+"\\\\\\\"," +
                                "\\\\\\\"product_name\\\\\\\":\\\\\\\"乐事薯片休闲小吃40g*10包\\\\\\\"," +
                                "\\\\\\\"product_type\\\\\\\":0,\\\\\\\"quantity\\\\\\\":\\\\\\\"1\\\\\\\"," +
                                "\\\\\\\"room_id\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"second_cid\\\\\\\":\\\\\\\"20313\\\\\\\"," +
                                "\\\\\\\"shop_id\\\\\\\":\\\\\\\"5109425\\\\\\\",\\\\\\\"sku\\\\\\\":{\\\\\\\"sku_detail\\\\\\\":" +
                                "[{\\\\\\\"sku_name\\\\\\\":\\\\\\\"香型\\\\\\\",\\\\\\\"sku_val\\\\\\\":\\\\\\\"随机口味*10\\\\\\\"}]," +
                                "\\\\\\\"sku_id\\\\\\\":"+comboId+"},\\\\\\\"third_cid\\\\\\\":\\\\\\\"22983\\\\\\\"," +
                                "\\\\\\\"user_agent\\\\\\\":\\\\\\\""+userAgents.generate()+"\\\\\\\"," +
//                                "\\\\\\\"address\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"mobile\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"137****5219\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"detail\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"城南街道南关小哈佛旁\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"is_default\\\\\\\\\\\\\\\":0,\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\""+addressId+"\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"prov_id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"440000\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"city_id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"440500\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"city\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"汕头市\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"area_id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"440513\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"area\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"潮阳区\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"prov\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"广东省\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"杨梓欣\\\\\\\\\\\\\\\"}\\\\\\\"" +
                                "}]," +
                                "\\\\\\\"uid\\\\\\\":\\\\\\\"1472985216323047\\\\\\\"," +
                                "\\\\\\\"user_agent\\\\\\\":\\\\\\\""+userAgents.generate()+"\\\\\\\"," +
                                "\\\\\\\"version_code\\\\\\\":\\\\\\\"15.1.0\\\\\\\",\\\\\\\"is_jailbreak\\\\\\\":\\\\\\\"2\\\\\\\"," +
                                "\\\\\\\"biometric_params\\\\\\\":\\\\\\\"WypRC2CHNKHOLjWZ2BD7v2Mmcv0Mn7ZYvr/wZR7sEsI=\\\\\\\"}\\\"," +
                                "\\\"sdk_version\\\":\\\"v2\\\",\\\"dev_info\\\":\\\"{\\\\\\\"reqIp\\\\\\\":\\\\\\\"112.94."+rand.nextInt(100)+".131\\\\\\\"," +
                                "\\\\\\\"os\\\\\\\":\\\\\\\"ios\\\\\\\",\\\\\\\"aid\\\\\\\":\\\\\\\"1128\\\\\\\"," +
                                "\\\\\\\"ua\\\\\\\":\\\\\\\""+userAgents.generate()+"\\\\\\\"," +
                                "\\\\\\\"lang\\\\\\\":\\\\\\\"zh-Hans\\\\\\\",\\\\\\\"deviceId\\\\\\\":\\\\\\\"70599853338\\\\\\\"," +
                                "\\\\\\\"appVersion\\\\\\\":\\\\\\\"15.1.0\\\\\\\",\\\\\\\"cjSdkVersion\\\\\\\":\\\\\\\"5.6.8.0\\\\\\\"," +
                                "\\\\\\\"bioType\\\\\\\":\\\\\\\"1\\\\\\\"}\\\"}\",\"combo_id\":\""+comboId+"\",\"combo_num\":1," +
                                "\"product_id\":\""+productId+"\",\"buyer_words\":\"\",\"coupon_info\":{}," +
                                "\"stock_info\":[{\"stock_type\":5,\"stock_num\":1,\"warehouse_id\":\"0\",\"sku_id\":\""+comboId+"\"}]," +
                                "\"campaign_id\":\"\",\"area_type\":\"169\",\"warehouse_id\":0," +
                                "\"post_addr\":" +
                                "{\"province\":{\"id\":\""+addressList[2]+"\",\"name\":\""+addressList[3]+"\"},\"city\":{\"id\":\""+addressList[4]+"\",\"name\":\""+addressList[5]+"\"}," +
                                "\"town\":{\"id\":\""+addressList[6]+"\",\"name\":\""+addressList[7]+"\"}," +
                                "\"detail\":\""+addressList[8]+"\"}," +
                                "\"post_receiver\":\""+addressList[0]+"\"," +
                                "\"post_tel\":\""+addressList[1]+"\"," +
                                "\"address_id\":\""+addressId+"\"," +
                                "\"freight_insurance\":false,\"cert_insurance\":false,\"gray_feature\":\"PlatformFullDiscount\"," +
                                "\"price_info\":{\"origin\":2990,\"freight\":0,\"coupon\":0,\"pay\":2990},\"sub_way\":0,\"pay_type\":2," +
                                "\"s_type\":\"\",\"room_id\":\"\",\"shop_user_id\":\"\",\"entrance_params\":\"{\\\"label_name\\\":\\\"\\\"," +
                                "\\\"carrier_source\\\":\\\"order_detail\\\",\\\"brand_verified\\\":\\\"0\\\",\\\"source_method\\\":\\\"\\\"," +
                                "\\\"coupon_id\\\":\\\"\\\",\\\"product_activity_type\\\":\\\"\\\",\\\"auto_coupon\\\":0," +
                                "\\\"ecom_group_type\\\":\\\"video\\\",\\\"is_groupbuying\\\":0}\",\"author_id\":\"791240065681438\"," +
                                "\"content_id\":\"0\",\"shop_id\":\"nkyDGSw\",\"sub_b_type\":\"3\",\"zg_ext_param\":\"{\\\"credit_pay_param\\\":" +
                                "{\\\"fee_rate_per_day\\\":\\\"\\\",\\\"has_credit_param\\\":false,\\\"has_trade_time\\\":false," +
                                "\\\"installment_starting_amount\\\":0,\\\"is_credit_activate\\\":false,\\\"remaining_credit\\\":0,\\\"trade_time\\\":0}," +
                                "\\\"decision_id\\\":\\\"1472985216323047_1616252811366117\\\",\\\"jr_uid\\\":\\\"4029024036727166\\\"," +
                                "\\\"promotion_process\\\":{\\\"create_time\\\":"+System.currentTimeMillis()+",\\\"process_id\\\":\\\"d02060ee472feff9973ffd27209f2a5f\\\"," +
                                "\\\"process_info\\\":\\\"\\\"}}\",\"sdk_version\":\"v2\",\"identity_card_id\":\"\"}" +
                                "")
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
