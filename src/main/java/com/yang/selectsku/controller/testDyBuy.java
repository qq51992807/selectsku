package com.yang.selectsku.controller;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class testDyBuy {

    public static void main(String args[]){
        String url="https://ec.snssdk.com/order/newcreate" ;
//
        testDyBuy testDyBuy=new testDyBuy();
        String productId="3453521734500751426";
        String comboId="1422354655";// 1422354648     1422354655
        String respones=testDyBuy.post( productId, comboId);
        System.out.println(respones);
    }


    public  String post(String productId,String comboId) {

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
                postMethod.setRequestHeader("User-Agent","Aweme 12.1.0 rv:141017 (iPhone; iOS 12.2; zh_CN) Cronet");
//                postMethod.setRequestHeader("Cookie","passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=1b765ab5396764dd57346ec3af8c5a7deb0cd; multi_sids=88742122835%3Afbc0259541effd117d4a6d60940bc8a8; odin_tt=9dce4719ff93f0f23e5f9e92df9d0f2c6e0d49f159c966338629d856d4af3ac08db6e88b32b5b67ed761fde43a2a67d0; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=fbc0259541effd117d4a6d60940bc8a8%7C1610102534%7C5184000%7CTue%2C+09-Mar-2021+10%3A42%3A14+GMT; uid_tt=6703625e4a7c06e3164659655030568f; uid_tt_ss=6703625e4a7c06e3164659655030568f; sid_tt=fbc0259541effd117d4a6d60940bc8a8; sessionid=fbc0259541effd117d4a6d60940bc8a8; sessionid_ss=fbc0259541effd117d4a6d60940bc8a8");
                postMethod.setRequestHeader("Cookie","passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; multi_sids=1472985216323047%3A0fbc826685d425016f42a565e5668789; odin_tt=919305ac7ba5c097a05e065668a9c1b067ed96db1e9d61d3ed3a8bbd617cc950b59799e200e454b906319738dde84d3a1465c2f9948938e31e697bab80c5db44; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; d_ticket=5898336d74f838f0ae041bb8059dbe18eb0cd; sid_guard=0fbc826685d425016f42a565e5668789%7C1610298880%7C5184000%7CThu%2C+11-Mar-2021+17%3A14%3A40+GMT; uid_tt=4052d67bd165532c1022976559496f8c; uid_tt_ss=4052d67bd165532c1022976559496f8c; sid_tt=0fbc826685d425016f42a565e5668789; sessionid=0fbc826685d425016f42a565e5668789; sessionid_ss=0fbc826685d425016f42a565e5668789");
//                postMethod.setRequestHeader("Cookie","install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; d_ticket=cd9e4e11edff757e10148f870b74b6551edd1; multi_sids=1472985216323047%3A56b49838f55ad6659534ef81ce0f59ab; odin_tt=b8c92c74c34f83ab2793a38b7626ff63f743fba7c1913a56be9a563cc977865d604720b14b61abf563e427a2335b28f7db0ee6b64c6c8a2a60e368504f40c8c9; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=56b49838f55ad6659534ef81ce0f59ab%7C1610106413%7C5184000%7CTue%2C+09-Mar-2021+11%3A46%3A53+GMT; uid_tt=4b1ed2344420a835463cbf0c3ae6fe2c; uid_tt_ss=4b1ed2344420a835463cbf0c3ae6fe2c; sid_tt=56b49838f55ad6659534ef81ce0f59ab; sessionid=56b49838f55ad6659534ef81ce0f59ab; sessionid_ss=56b49838f55ad6659534ef81ce0f59ab");

//                postMethod.setRequestHeader("Cookie","passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; tt_webid=e254ddac709bbb535ef049fd9e024c3e; d_ticket=fb2f63caf1aaece9b4f7d7386e6d59611edd1; multi_sids=1261852034861415%3A0870973d3653292d6c553b0b2983d1ea; odin_tt=030e7e1d4fdc6cb6c5db70d6fae7ce276adcae2cb8ba19813bed201fe80ba105fe010113a77cc3ceb4161ef15c2334905536f56a06d50d6b5e5295a2b261a23c; n_mh=gyhYXI_ryT7KwoxdKJ-FvHwDVLPgJasRgcioYGrquAk; sid_guard=0870973d3653292d6c553b0b2983d1ea%7C1610117483%7C5184000%7CTue%2C+09-Mar-2021+14%3A51%3A23+GMT; uid_tt=d5b94fa554a94c8888931fa4e73dedfa; uid_tt_ss=d5b94fa554a94c8888931fa4e73dedfa; sid_tt=0870973d3653292d6c553b0b2983d1ea; sessionid=0870973d3653292d6c553b0b2983d1ea; sessionid_ss=0870973d3653292d6c553b0b2983d1ea");


//参数设置，需要注意的就是里边不能传NULL，要传空字符串
                NameValuePair[] data2 = {
                        new NameValuePair("json_form"," {\"b_type\":2," +
//                                "\"env_type\":\"1\",\"activity_id\":\"\",\"origin_type\":\"3002002002\"," +
//                                "\"origin_id\":\"3333330376333880_3457057351729847491\"," +
                                "\"new_source_type\":\"product_detail\",\"new_source_id\":\"0\"," +
                                "\"source_type\":\"0\",\"source_id\":\"0\",\"schema\":\"sslocal://\"," +
//                                "\"extra\":\"{\\\"page_type\\\":\\\"lynx\\\",\\\"alkey\\\":\\\"1128_3333330376333880_0_3454717434362255576_010\\\"," +
//                                "\\\"buyin_track\\\":\\\"COgIELi0gKjX9PUFGgQIABAAIgAow7mK0IXr-_wvMAI\\\",\\\"c_biz_combo\\\":\\\"8\\\"," +
//                                "\\\"risk_info\\\":\\\"{\\\\\\\"ac\\\\\\\":\\\\\\\"WIFI\\\\\\\",\\\\\\\"amount\\\\\\\":\\\\\\\"400\\\\\\\"," +
//                                "\\\\\\\"app_id\\\\\\\":1128,\\\\\\\"app_name\\\\\\\":\\\\\\\"aweme\\\\\\\"," +
//                                "\\\\\\\"brand\\\\\\\":\\\\\\\"iPhone11,2\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"App Store\\\\\\\"," +
//                                "\\\\\\\"device_platform\\\\\\\":\\\\\\\"iphone\\\\\\\",\\\\\\\"device_type\\\\\\\":\\\\\\\"iPhone11,2\\\\\\\"," +
//                                "\\\\\\\"did\\\\\\\":\\\\\\\"2304228498630093\\\\\\\",\\\\\\\"iid\\\\\\\":\\\\\\\"2198675385226238\\\\\\\"," +
//                                "\\\\\\\"ip\\\\\\\":\\\\\\\"27.47.16.86\\\\\\\"," +
//                                "\\\\\\\"openudid\\\\\\\":\\\\\\\"701a3307965b4667cf87e21478594ac5d5ddf711\\\\\\\"," +
//                                "\\\\\\\"os_version\\\\\\\":\\\\\\\"13.2\\\\\\\"," +
//                                "\\\\\\\"sub_order_info\\\\\\\":[{\\\\\\\"author_id\\\\\\\":\\\\\\\"0\\\\\\\"," +
//                                "\\\\\\\"card_id\\\\\\\":0,\\\\\\\"commodity_amount\\\\\\\":\\\\\\\"400\\\\\\\"," +
//                                "\\\\\\\"commodity_ec_discount_amount\\\\\\\":\\\\\\\"0\\\\\\\"," +
//                                "\\\\\\\"first_cid\\\\\\\":\\\\\\\"20073\\\\\\\",\\\\\\\"fourth_cid\\\\\\\":\\\\\\\"0\\\\\\\"," +
//                                "\\\\\\\"new_source_type\\\\\\\":\\\\\\\"product_detail\\\\\\\"," +
//                                "\\\\\\\"origin_id\\\\\\\":\\\\\\\"3333330376333880_3454717434362255576\\\\\\\"," +
//                                "\\\\\\\"origin_type\\\\\\\":3002002002,\\\\\\\"price\\\\\\\":\\\\\\\"400\\\\\\\"," +
//                                "\\\\\\\"product_id\\\\\\\":\\\\\\\"3454717434362255576\\\\\\\"," +
//                                "\\\\\\\"product_name\\\\\\\":\\\\\\\"ZMI紫米PurPods\\\\\\\",\\\\\\\"quantity\\\\\\\":\\\\\\\"1\\\\\\\"," +
//                                "\\\\\\\"room_id\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"second_cid\\\\\\\":\\\\\\\"21269\\\\\\\"," +
//                                "\\\\\\\"shop_id\\\\\\\":\\\\\\\"5714070\\\\\\\"," +
//                                "\\\\\\\"sku\\\\\\\":{\\\\\\\"sku_detail\\\\\\\":[{\\\\\\\"sku_name\\\\\\\":\\\\\\\"规格\\\\\\\"," +
//                                "\\\\\\\"sku_val\\\\\\\":\\\\\\\"默认规格\\\\\\\"}],\\\\\\\"sku_id\\\\\\\":1536928593}," +
//                                "\\\\\\\"third_cid\\\\\\\":\\\\\\\"26976\\\\\\\"," +
//                                "\\\\\\\"user_agent\\\\\\\":\\\\\\\"Aweme 11.1.0 rv:141017 (iPhone; iOS 11.2; zh_CN) Cronet\\\\\\\"," +
//                                "\\\\\\\"address\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"mobile\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"135****0143\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"detail\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"前进街道石溪村桥头东街四巷一号\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"is_default\\\\\\\\\\\\\\\":1,\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"6837435314240340236\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"prov_id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"440000\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"city_id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"440100\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"city\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"广州市\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"area_id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"440106\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"area\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"天河区\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"prov\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"广东省\\\\\\\\\\\\\\\"," +
//                                "\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"杨梓博\\\\\\\\\\\\\\\"}\\\\\\\"}]," +
//                                "\\\\\\\"uid\\\\\\\":\\\\\\\"88742122835\\\\\\\"," +
//                                "\\\\\\\"user_agent\\\\\\\":\\\\\\\"Aweme 14.1.0 rv:141017 (iPhone; iOS 11.2; zh_CN) Cronet\\\\\\\"," +
//                                "\\\\\\\"version_code\\\\\\\":\\\\\\\"14.1.0\\\\\\\",\\\\\\\"is_jailbreak\\\\\\\":\\\\\\\"2\\\\\\\"," +
//                                "\\\\\\\"biometric_params\\\\\\\":\\\\\\\"x8/qLXn24O2AJSZ9htpPDu2w9hHWD2PiStJAStVFti8=\\\\\\\"}\\\"," +
//                                "\\\"sdk_version\\\":\\\"v2\\\",\\\"dev_info\\\":\\\"{\\\\\\\"reqIp\\\\\\\":\\\\\\\"27.47.6.86\\\\\\\"," +
//                                "\\\\\\\"os\\\\\\\":\\\\\\\"ios\\\\\\\",\\\\\\\"aid\\\\\\\":\\\\\\\"1128\\\\\\\"," +
//                                "\\\\\\\"ua\\\\\\\":\\\\\\\"Aweme 11.1.0 rv:141017 (iPhone; iOS 11.2; zh_CN) Cronet\\\\\\\"," +
//                                "\\\\\\\"lang\\\\\\\":\\\\\\\"zh-Hans\\\\\\\",\\\\\\\"deviceId\\\\\\\":\\\\\\\"2304228498630093\\\\\\\"," +
//                                "\\\\\\\"appVersion\\\\\\\":\\\\\\\"14.1.0\\\\\\\",\\\\\\\"cjSdkVersion\\\\\\\":\\\\\\\"5.6.2.0\\\\\\\"," +
//                                "\\\\\\\"bioType\\\\\\\":\\\\\\\"2\\\\\\\"}\\\"}\"," +
                                "\"combo_id\":"+comboId+"," +
//                                "\"combo_id\":\"1428229999\"," +//wifi路由器
                                "\"combo_num\":1," +
                                "\"product_id\":"+productId+"," +
//                                "\"product_id\":\"3453752569850162679\"," +
                                "\"buyer_words\":\"\"," +
//                                "\"coupon_info\":{}," +
//                                "\"stock_info\":[{\"stock_type\":2,\"stock_num\":1,\"warehouse_id\":\"6882858266968342792\"," +
//                                "\"sku_id\":\"1454211939\"}]," +
                                "\"area_type\":\"169\"," +
//                                "\"warehouse_id\":6882858266968343000," +
                                "\"post_addr\":" +
                                "{\"province\":{\"id\":\"440000\",\"name\":\"广东省\"},\"city\":{\"id\":\"440100\",\"name\":\"广州市\"}," +
                                "\"town\":{\"id\":\"440106\",\"name\":\"天河区\"}," +
                                "\"detail\":\"前进街道石溪村桥头新街一巷一号\"}," +
                                "\"post_receiver\":\"林先生\"," +
                                "\"post_tel\":\"135****5662\"," +
                                "\"address_id\":\"6892397162693427459\",\"freight_insurance\":true," +
                                "\"gray_feature\":\"PlatformFullDiscount\"," +
//                                "\"price_info\":{\"origin\":39900,\"freight\":0,\"coupon\":0,\"pay\":39900}," +
                                "\"sub_way\":0,\"pay_type\":2,\"s_type\":\"\",\"room_id\":\"\",\"shop_user_id\":\"\"," +
//                                "\"entrance_params\":\"{\\\"source_method\\\":\\\"product_card\\\",\\\"carrier_source\\\":\\\"store_page\\\"," +
//                                "\\\"which_account\\\":\\\"\\\",\\\"ecom_group_type\\\":\\\"video\\\"}\"," +
//                                "\"author_id\":\"66916631931\"," +
                                "\"author_id\":\"4195355415549012\"," +
//                                "\"content_id\":\"0\",\"shop_id\":\"AaMGPLt\",\"sub_b_type\":\"3\"," +
//                                "\"zg_ext_param\":\"{\\\"credit_pay_param\\\":" +
//                                "{\\\"fee_rate_per_day\\\":\\\"0.0267\\\",\\\"has_credit_param\\\":true,\\\"has_trade_time\\\":false," +
//                                "\\\"installment_starting_amount\\\":20000,\\\"is_credit_activate\\\":false,\\\"remaining_credit\\\":0," +
//                                "\\\"trade_time\\\":0},\\\"decision_id\\\":\\\"88742122835_1609939896611501\\\",\\\"jr_uid\\\":\\\"2400924455414748\\\"," +
//                                "\\\"promotion_process\\\":{\\\"create_time\\\":1609939896,\\\"process_id\\\":\\\"07982668e44ef9e80f8957b2507ac32e\\\"," +
//                                "\\\"process_info\\\":\\\"\\\"}}\"," +
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
