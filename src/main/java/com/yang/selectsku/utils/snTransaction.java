package com.yang.selectsku.utils;

import com.suning.api.DefaultSuningClient;
import com.suning.api.entity.netalliance.BacthcustomlinkQueryRequest;
import com.suning.api.entity.netalliance.BacthcustomlinkQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class snTransaction {

    public static void main(String[] args){
        System.out.println( snTransaction.snTransactionItem("https://m.suning.com/product/0000000000/12235065676.html"));
        System.out.println(snTransaction.snTransactionItem("https://product.suning.com/0000000000/142149680.html"));
    }

    public static  String snTransactionItem(String url){
        BacthcustomlinkQueryRequest request = new BacthcustomlinkQueryRequest();
        request.setExtend(url+"?");
        request.setPromotionId("883034");
//api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
//        request.setCheckParam(true);
        String serverUrl = "https://open.suning.com/api/http/sopRequest";
        String appKey = "bac5239d544d1a2b8f13bc8de3bc9310";
        String appSecret = "d6a48b34ce6c4d39d62488d726e1878b";
        DefaultSuningClient client = new DefaultSuningClient(serverUrl, appKey,appSecret, "json");
        try {
            BacthcustomlinkQueryResponse response = client.excute(request);
            try {
                JSONObject jsonObject=new JSONObject(response.getBody());
                JSONObject sn_responseContentnew=new JSONObject(jsonObject.getString("sn_responseContent"));
                JSONObject sn_body=new JSONObject(sn_responseContentnew.getString("sn_body"));
                JSONObject queryBacthcustomlink=new JSONObject(sn_body.getString("queryBacthcustomlink"));
                if(queryBacthcustomlink.has("shortLink")){
                    String shortLink=queryBacthcustomlink.getString("shortLink");
//                    System.out.println(shortLink.substring(1,shortLink.length()-1));
                    url=shortLink.substring(1,shortLink.length()-1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }



        } catch (SuningApiException e) {
            e.printStackTrace();
        }
     return url;
    }
}
