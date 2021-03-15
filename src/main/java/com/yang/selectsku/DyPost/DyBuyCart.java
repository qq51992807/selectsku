package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.userAgents;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DyBuyCart implements Runnable{

//    String xCookie="passport_csrf_token=9ca99ffdad1abbe901df514515e6779b; passport_csrf_token_default=9ca99ffdad1abbe901df514515e6779b; install_id=3237384126992995; ttreq=1$5339498c4c1bc6c31982d7628b01134327e66179; d_ticket=b8a37bb52c5fc8a7dfe3896a3dbfd5d986961; multi_sids=1472985216323047%3A50702332d2773a492a29154fffe9c1e7; odin_tt=85c44fad3e6fdfded72f207be3da152566fdfb0eea0549d27b217b37a841d2ed84a74bf233cf6fc4992e965143262bf29a7fe701253e5b873e7d069adf31954e; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=50702332d2773a492a29154fffe9c1e7%7C1614261497%7C5184000%7CMon%2C+26-Apr-2021+13%3A58%3A17+GMT; uid_tt=a0601eec5f0e138c946762d756c50cd6; uid_tt_ss=a0601eec5f0e138c946762d756c50cd6; sid_tt=50702332d2773a492a29154fffe9c1e7; sessionid=50702332d2773a492a29154fffe9c1e7; sessionid_ss=50702332d2773a492a29154fffe9c1e7";
//String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";

    //    public String cookie="passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3Ae73ef71f7034400eba58dccabb9af11c; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; odin_tt=40e3b5563f4989145665b5ff815766daf9e3a622beb0c7d98f5e2fcf57c5343391d5733740c7e8764ae4fe901069c57c; sessionid=e73ef71f7034400eba58dccabb9af11c; sessionid_ss=e73ef71f7034400eba58dccabb9af11c; sid_guard=e73ef71f7034400eba58dccabb9af11c%7C1610330943%7C5184000%7CFri%2C+12-Mar-2021+02%3A09%3A03+GMT; sid_tt=e73ef71f7034400eba58dccabb9af11c; uid_tt=58766eacf7c338b92bc4decf7f61cc34; uid_tt_ss=58766eacf7c338b92bc4decf7f61cc34; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874";
//    public String addressId="6837435314240340236";
//    public String authorId="66916631931";
    public  String cookie;
    public String addressId;
//    public String authorId=null;
    public String comboId;
    public String productId;
    public String[] addressList;


    public DyBuyCart(String cookie,String addressId,String productId,String comboId,String[] addressList){
        this.cookie=cookie;
        this.addressId=addressId;
        this.productId=productId;
        this.comboId=comboId;
        this.addressList=addressList;

    }

    public  static void main(String[] args){
        String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
        String baiyeAddress="6837435314240340236";
        String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};

        DyBuyCart   dyBuyCart=new DyBuyCart(baiyeCookie, baiyeAddress,"3453521734500751426","1422354655",baiyeAddressList);
        System.out.println(dyBuyCart.post());
//        for(int i=0;i<1;i++){
//            DyBuyCart dyBuyCart=new DyBuyCart();
//           new Thread(dyBuyCart,""+i).start();
//        }



    }

    @Override
    public void run() {

    }


//    public DyBuyCart(String cookie, String addressId, String authorId, String comboId, String productId, String[] addressList){
//        this.cookie=cookie;
//        this.addressId=addressId;
//        this.authorId=authorId;
//        this.comboId=comboId;
//        this.productId=productId;
//        this.addressList=addressList;
//
//    }
    public  String post() {

        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
//

                PostMethod postMethod = null;
                postMethod = new PostMethod("https://ec.snssdk.com/order/batchCreate") ;
                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
                postMethod.setRequestHeader("User-Agent", userAgents.generate());
                postMethod.setRequestHeader("Cookie",cookie);



                NameValuePair[] data2 = {
                        new NameValuePair("json_form"," {\"b_type\":3,\"env_type\":\"1\",\"activity_id\":\"\"," +
                                "\"origin_type\":\"0\",\"origin_id\":\"0\",\"new_source_type\":\"order_center\"," +
                                "\"new_source_id\":\"0\",\"source_type\":\"0\",\"source_id\":\"0\"," +
                                "\"schema\":\"sslocal://\",\"extra\":\"{}\",\"entrance_params\":\"{}\"," +
                                "\"orders\":[" +
                                "{\"product_id\":\"3454310666498894355\",\"combo_id\":\"1692485978644492\"," +
                                "\"cart_id\":\"6938777143845732645\"," +
                                "\"combo_num\":1,\"coupon_info\":{}," +
                                "\"cert_insurance\":false," +
                                "\"freight_insurance\":false}," +
                                "{\"product_id\":\""+productId+"\",\"combo_id\":\""+comboId+"\"," +
                                "\"cart_id\":\"6938776602478346499\"," +
                                "\"combo_num\":1,\"coupon_info\":{}," +
                                "\"cert_insurance\":false," +
                                "\"freight_insurance\":false}],\"gray_feature\":\"PlatformFullDiscount\",\"author_id\":\"\"," +
                                "\"post_addr\":" +
                                "{\"province\":{\"id\":\""+addressList[2]+"\",\"name\":\""+addressList[3]+"\"},\"city\":{\"id\":\""+addressList[4]+"\",\"name\":\""+addressList[5]+"\"}," +
                                "\"town\":{\"id\":\""+addressList[6]+"\",\"name\":\""+addressList[7]+"\"}," +
                                "\"detail\":\""+addressList[8]+"\"}," +
                                "\"post_receiver\":\""+addressList[0]+"\"," +
                                "\"post_tel\":\""+addressList[1]+"\"," +
                                "\"address_id\":\""+addressId+"\"," +
                                "\"area_type\":\"\"," +
                                "\"s_type\":\"\",\"room_id\":\"\",\"sub_b_type\":\"3\"}" +
                                ""),
//                        new NameValuePair("json_form","{\"b_type\":2,\"env_type\":\"1\",\"activity_id\":\"\",\"origin_type\":\"0\"," +
//                                "\"origin_id\":\"0\",\"new_source_type\":\"order_center\",\"new_source_id\":\"0\",\"source_type\":\"0\"," +
//                                "\"source_id\":\"0\",\"schema\":\"sslocal://\",\"extra\":\"{}\",\"entrance_params\":\"{}\"," +
//                                "\"orders\":[{\"product_id\":\"3462247420468057294\",\"combo_id\":\"1690550491397166\"," +
//                                "\"cart_id\":\"6938777143845732645\",\"combo_num\":1,\"coupon_info\":{},\"room_id\":\"6938643338891463431\"," +
//                                "\"author_id\":\"2392139999215742\",\"shop_user_id\":\"8459253\"," +
//                                "\"extra\":{\"alkey\":\"1128_2392139999215742_6938643338891463431_3462247420468057294_010\"," +
//                                "\"author_id\":\"2392139999215742\",\"buyin_track\":\"CKHxBhD-gKD3t_SfBBoMCIeWhu6q68ClYBACIgAozqmLrPb1l4YwMAI\"," +
//                                "\"c_biz_combo\":\"8\",\"cart_track\":\"{\\\"source_method\\\":\\\"live_cover\\\"," +
//                                "\\\"carrier_source\\\":\\\"live_merge\\\",\\\"carrier_type\\\":\\\"live_list_card\\\",\\\"ecom_group_type\\\":\\\"live\\\"}\"," +
//                                "\"origin_id\":\"2392139999215742_6938643338891463431_3462247420468057294\",\"origin_type\":\"3002015000\"," +
//                                "\"room_id\":\"6938643338891463431\",\"shop_user_id\":\"8459253\",\"new_source_type\":\"order_center\"}," +
//                                "\"pay_type\":2,\"stock_info\":[{\"stock_type\":1,\"stock_num\":1,\"warehouse_id\":\"\"}]," +
//                                "\"cert_insurance\":false,\"freight_insurance\":false}," +
//                                "{\"product_id\":\"3467323393014160584\"," +
//                                "\"combo_id\":\""+comboId+"\",\"cart_id\":\"6938776602478346499\",\"combo_num\":1,\"coupon_info\":{},\"room_id\":\"\",\"author_id\":\"791240065681438\",\"shop_user_id\":\"5109425\",\"extra\":{\"alkey\":\"\",\"author_id\":\"791240065681438\",\"buyin_track\":\"\",\"c_biz_combo\":\"8\",\"cart_track\":\"{\\\"source_method\\\":\\\"\\\",\\\"carrier_source\\\":\\\"scan\\\",\\\"carrier_type\\\":\\\"\\\",\\\"ecom_group_type\\\":\\\"video\\\"}\",\"origin_id\":\"791240065681438_3454310666498894355\",\"origin_type\":\"3002070010\",\"room_id\":\"\",\"shop_user_id\":\"5109425\",\"new_source_type\":\"order_center\"},\"pay_type\":2,\"stock_info\":[{\"stock_type\":1,\"stock_num\":1,\"warehouse_id\":\"\"}],\"cert_insurance\":false,\"freight_insurance\":false}],\"gray_feature\":\"PlatformFullDiscount\",\"author_id\":\"\",\"post_addr\":{\"province\":{\"id\":\"440000\",\"name\":\"广东省\"},\"city\":{\"id\":\"440100\",\"name\":\"广州市\"},\"town\":{\"id\":\"440106\",\"name\":\"天河区\"},\"detail\":\"前进街道石溪村桥头新街一巷一号\",\"tag\":\"\"},\"post_receiver\":\"杨梓博\",\"post_tel\":\"135****0143\",\"address_id\":\"6916499793699176711\",\"area_type\":\"\",\"price_info\":{\"origin\":4980,\"freight\":0,\"coupon\":0,\"pay\":4980},\"sub_way\":0,\"pay_type\":2,\"token\":\"\",\"s_type\":\"\",\"room_id\":\"\",\"sub_b_type\":\"3\"}"),
//
 new NameValuePair("request_tag_from","h5")
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
