package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.postUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class commitKsTest implements Runnable {
   static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式


//    String itemId="885854627282";
//    String skuId="885854628282";
//    String authorId="1991432282";
//    String discountFee="200000";
//    String paymentFee="149900";
//    String price="349900";
//    String promotionId="691429e12bffc5b731ec70591b480125BbISNgTireg";//秒杀id


    static  String itemId="1153115418880";
    static  String skuId="1153115419880";
    static  String authorId="188888880";
    static  String discountFee="0";
    static  String paymentFee="29900";
    static  String price="29900";
//    String promotionId="b5aa763af497c642df4d0d7e2276b6e1KQQ0B6ID9R4";//秒杀id
    static  String promotionId="";//秒杀id


    static  String cookie="appver=9.0.30.4898; browseType=4; c=a; client_key=56c3713c; countryCode=cn; country_code=cn; cs=false; darkMode=true; did=9194D956-A77D-4825-BE62-0A6E4FCB14E1; egid=DFP6EB5557B5EA7E82A469C61CA08B8354D4C18E6BE06568FF04B1342B10605E; foreign=0; gid=DFP6EB5557B5EA7E82A469C61CA08B8354D4C18E6BE06568FF04B1342B10605E; global_id=DFP6EB5557B5EA7E82A469C61CA08B8354D4C18E6BE06568FF04B1342B10605E; isp=CMCC; kpf=IPHONE; kpn=KUAISHOU; ks-s-ctn=0; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAGLZmnTTfHUHjDDnd4l2KBWIgAMb4jNY2L1AUNp2CpNx0hQ99AsFKM-7EqkMqwwFgVKIlmivitd_K12fgZ0xb87iKvVi3OdtpMKeGIapt7LDUPOWSidOfzec7XmSGgflh-I3lyZSTFDRHN5VQp90AmH2Dsa2vMDPnl0r5-528zkWMVNNn-Ti-sz8K9PyqcJaTnu_VEiF89m4uOBBbp8shXQMn3LFkaWOEjfpS3-_J40YxoSO10xFXRwSIqcekHg3JqdJpRXIiCJLSjwjqEYvUKigEB-8euxF1b3yzEocyulGLOZ9nDh1ygFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAd2PDBWMBFtLzxKJVpUQai_hAZci9N_NFhVLuzY9Nx3zVzyksXBTkJTiU94Qs4gtdOSxOuKR1_-qsRR1PwKrSPdd5Fv-pXa3lnP5Pl7vo5HF6MoybDBOS60wLQrnDub5046iMG61ufNihHLTn1TGTWfXDLMXULkkz3Y7cVgV2ke7DYMaSQ7O3YVq2a9lUHemEd8FDLgzB9nRzi-KqQRPymEaEi0FTenUzzyakcPnzsVR98aTkSIg8lehYpmet7qUI0hWeidRbR6Rujf3XiZ5nLzXo6K6n8coBTAB; kuaishou.sixin.login_st=ChdrdWFpc2hvdS5zaXhpbi5sb2dpbi5zdBKgAXBa2IaTPISV-pwo8B3bxgSBXXW40PGpSGvuXjZKk58ZmHgie8-R_FUHXlH2yFxIX0sZqL53LTN6a1t8B2KMJPOBUCUfvFs-LNoLLdSmcBlhZnKbTKHfXMr4HdbY9b3my7M1TtuMGJBd_V4V6CftY40w_rCm5NNfZYCBXGBO63BRYsKnzwchRgquqKUqE3nsS1C4Fbmd7zsQUjIRuqOXXZ8aElCFD4yoG0dNrMrGMgWk18ADhiIg7tZf6dFnaZpN0hkN8jld5gPpNdBH2P6AXdYp3VVdXcQoBTAB; language=zh-Hans-CN;q=1; lat=23.11193537936646; ll=CfCkCcynHDdAEQRh6AHTWVxA; lon=113.4035038728071; mod=iPhone13,2; net=中国移动_3; os=14.2; power_mode=0; session_id=DDB4BE19-AE09-44C0-B29C-DFEFFF5374C0; sh=2532; sid=DDB4BE19-AE09-44C0-B29C-DFEFFF5374C0; sw=1170; sys=ios14.2; token=fb4dfe5b7321486ba15975077a4d56d0-1963187365; ud=1963187365; userId=1963187365; ver=9.0; weblogger_switch=; ks-s-ctn=e815d17f-05ae-46db-bb52-66ea650fc891; ks-s-ctn=0";
    static  String url = "https://app.kwaixiaodian.com/rest/app/grocery/ks/order/create/v2?retrylimit=true&serverExpTag=1_u%2F2482609_msk222002";
    static String json="{\n" +
            "  \"param\": \"{\\\"clientId\\\":1,\\\"remark\\\":\\\"\\\"," +
            "\\\"addressId\\\":115978411365,\\\"mobile\\\":\\\"\\\",\\\"expressFee\\\":0," +
            "\\\"paymentFee\\\":"+paymentFee+",\\\"carrierType\\\":null," +
            "\\\"discountFee\\\":"+discountFee+",\\\"likeExpTag\\\":\\\"\\\"," +
            "\\\"skuList\\\":[{\\\"sellerId\\\":\\\""+authorId+"\\\",\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+",\\\"num\\\":1," +
            "\\\"promoteParam\\\":null,\\\"price\\\":"+price+",\\\"expressFee\\\":0,\\\"extInfo\\\":null," +
            "\\\"cpsParam\\\":{\\\"promoteId\\\":\\\"ks_8110234_666_-WeNR8Nnme4\\\",\\\"promoteChannel\\\":\\\"1\\\"}," +
            "\\\"insuranceParam\\\":{},\\\"saleAuthorization\\\":\\\"\\\",\\\"traceTag\\\":\\\"\\\"," +
            "\\\"serviceRule\\\":{\\\"firstOrderGuaranteeFlag\\\":false,\\\"refundRule\\\":\\\"5\\\"," +
            "\\\"freightInsuranceRule\\\":null,\\\"depositRule\\\":\\\"1\\\",\\\"certificateGuarantee\\\":\\\"1\\\"," +
//        "\\\"refundRuleVO\\\":{\\\"code\\\":\\\"5\\\",\\\"title\\\":\\\"支持7天无理由退货(拆封后不支持)\\\"," +
//        "\\\"text\\\":\\\"支持7天无理由退货(拆封后不支持)\\\"}," +
            "\\\"theDayOfDeliverGoodsTime\\\":15,\\\"openFastRefund\\\":true," +
            "\\\"fastDelivery\\\":false,\\\"saleFlag\\\":false,\\\"promiseDeliveryTime\\\":-1,\\\"supportByJd\\\":false}}]," +
            "\\\"serverExpTag\\\":\\\"\\\",\\\"clientExpTag\\\":\\\"\\\",\\\"marketingInfoList\\\":[],\\\"cpsVersion\\\":\\\"\\\"}\"\n" +
            "}";
    //            String cookie = "  appver=8.3.31.4600;  client_key=56c3713c; token=c13419c9168c4b83900e1510d685ff14-1963187365;";

    public static String commit(){
        String message = postUtils.post(url, json, true, cookie);
        return df.format(new Date())+message;
    }


//    String json ="{\n" +
//            "  \"param\": \"{\\\"clientId\\\":1,\\\"remark\\\":\\\"\\\"," +
//            "\\\"addressId\\\":115978411365,\\\"mobile\\\":\\\"\\\"," +//256800446365  115978411365
//            "\\\"expressFee\\\":0,\\\"paymentFee\\\":"+paymentFee+",\\\"carrierIdStr\\\":\\\"\\\"," +
//            "\\\"carrierType\\\":\\\"\\\",\\\"discountFee\\\":"+discountFee+",\\\"likeExpTag\\\":\\\"\\\"," +
//            "\\\"skuList\\\":[{\\\"sellerId\\\":"+authorId+",\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+",\\\"num\\\":1," +
//            "\\\"promoteParam\\\":null,\\\"price\\\":"+price+",\\\"expressFee\\\":0,\\\"extInfo\\\":null,\\\"cpsParam\\\":null," +
//            "\\\"insuranceParam\\\":{},\\\"saleAuthorization\\\":\\\"\\\",\\\"traceTag\\\":\\\"\\\"}]," +
//            "\\\"serverExpTag\\\":\\\"\\\",\\\"clientExpTag\\\":\\\"\\\"," +
//            "\\\"marketingInfoList\\\":[{\\\"promotionId\\\":\\\""+promotionId+"\\\"," +
//            "\\\"promotionType\\\":3,\\\"marketingType\\\":1000,\\\"marketingSubType\\\":1001," +
//            "\\\"marketingIdStr\\\":\\\""+promotionId+"\\\",\\\"discountFee\\\":"+discountFee+"," +
//            "\\\"marketingUseList\\\":[{\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+"}]}]}\"\n" +
//            "}";


        public static void main(String args[]) {
        for (int i=0;i<1;i++){
            new Thread(new commitKsTest(),"ks"+i).start();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        }




    @Override
    public void run() {
        while (1 == 1) {
            String message = postUtils.post(url, json, true, cookie);
            System.out.println(df.format(new Date())+message);
        }

}



}
