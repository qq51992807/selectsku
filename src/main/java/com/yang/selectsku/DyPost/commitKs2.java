package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.postUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class commitKs2 implements Runnable {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式


//    String itemId="885854627282";
//    String skuId="885854628282";
//    String authorId="1991432282";
//    String discountFee="200000";
//    String paymentFee="149900";
//    String price="349900";
//    String promotionId="691429e12bffc5b731ec70591b480125BbISNgTireg";//秒杀id

//    String itemId="880959905526";
//    String skuId="880959906526";
//    String authorId="1740179526";
//    String discountFee="47000";
//    String paymentFee="39900";
//    String price="86900";
//    String promotionId="65684b7fabc44396eaa816eba1c032f670eIst0Ika8";//秒杀id

    //12点
    String itemId="885859332282";String skuId="885859335282";String authorId="1991432282";String discountFee="200000";String paymentFee="149900";String price="349900";String promotionId="b12dd2f015dd0224dd5d7150898c2997yfB8elR8umE";//秒杀id
    //8点
    //String itemId="885864214282";String skuId="885864215282";String authorId="1991432282";String discountFee="200000";String paymentFee="149900";String price="349900";String promotionId="03bec6935f4f79360477d58839a337e37clm5n_Kvf8";//秒杀id



    String json ="{\n" +
            "  \"param\": \"{\\\"clientId\\\":1,\\\"remark\\\":\\\"\\\"," +
            "\\\"addressId\\\":256800446365,\\\"mobile\\\":\\\"\\\"," +//256800446365  115978411365
            "\\\"expressFee\\\":0,\\\"paymentFee\\\":"+paymentFee+",\\\"carrierIdStr\\\":\\\"3\\\"," +
            "\\\"carrierType\\\":19,\\\"discountFee\\\":"+discountFee+",\\\"likeExpTag\\\":\\\"\\\"," +
            "\\\"skuList\\\":[{\\\"sellerId\\\":"+authorId+",\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+",\\\"num\\\":1," +
            "\\\"promoteParam\\\":null,\\\"price\\\":"+price+",\\\"expressFee\\\":0,\\\"extInfo\\\":null,\\\"cpsParam\\\":null," +
            "\\\"insuranceParam\\\":{},\\\"saleAuthorization\\\":\\\"\\\",\\\"traceTag\\\":\\\"\\\"}]," +
            "\\\"serverExpTag\\\":\\\"1_u/94246100_msk111\\\",\\\"clientExpTag\\\":\\\"\\\"," +
            "\\\"marketingInfoList\\\":[{\\\"promotionId\\\":\\\""+promotionId+"\\\"," +
            "\\\"promotionType\\\":4,\\\"marketingType\\\":5000,\\\"marketingSubType\\\":5003," +
            "\\\"marketingIdStr\\\":\\\""+promotionId+"\\\",\\\"discountFee\\\":"+discountFee+"," +
            "\\\"marketingUseList\\\":[{\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+"}]}]}\"\n" +
            "}";
    //            String cookie = "  appver=8.3.31.4600;  client_key=56c3713c; token=c13419c9168c4b83900e1510d685ff14-1963187365;";
    String json2 ="{\n" +
            "  \"param\": \"{\\\"clientId\\\":1,\\\"remark\\\":\\\"\\\"," +
            "\\\"addressId\\\":197789953108,\\\"mobile\\\":\\\"\\\"," +//197789953108  127017172108
            "\\\"expressFee\\\":0,\\\"paymentFee\\\":"+paymentFee+",\\\"carrierIdStr\\\":\\\"3\\\"," +
            "\\\"carrierType\\\":19,\\\"discountFee\\\":"+discountFee+",\\\"likeExpTag\\\":\\\"\\\"," +
            "\\\"skuList\\\":[{\\\"sellerId\\\":"+authorId+",\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+",\\\"num\\\":1," +
            "\\\"promoteParam\\\":null,\\\"price\\\":"+price+",\\\"expressFee\\\":0,\\\"extInfo\\\":null,\\\"cpsParam\\\":null," +
            "\\\"insuranceParam\\\":{},\\\"saleAuthorization\\\":\\\"\\\",\\\"traceTag\\\":\\\"\\\"}]," +
            "\\\"serverExpTag\\\":\\\"1_u/94246100_msk111\\\",\\\"clientExpTag\\\":\\\"\\\"," +
            "\\\"marketingInfoList\\\":[{\\\"promotionId\\\":\\\""+promotionId+"\\\"," +
            "\\\"promotionType\\\":4,\\\"marketingType\\\":5000,\\\"marketingSubType\\\":5003," +
            "\\\"marketingIdStr\\\":\\\""+promotionId+"\\\",\\\"discountFee\\\":"+discountFee+"," +
            "\\\"marketingUseList\\\":[{\\\"itemId\\\":"+itemId+",\\\"skuId\\\":"+skuId+"}]}]}\"\n" +
            "}";
    String cookie="appver=9.0.30.4898; c=a; client_key=56c3713c; countryCode=cn; did=9194D956-A77D-4825-BE62-0A6E4FCB14E1; egid=DFP18F3A08EAA3FD5B91D3A8DB4E90F17A63AEA63BB5EFB741F64FAF39E89C46; gid=DFP18F3A08EAA3FD5B91D3A8DB4E90F17A63AEA63BB5EFB741F64FAF39E89C46; kpf=IPHONE; kpn=KUAISHOU; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAGt9kt9NzWTk1pHmthJ7NSm04eOsciCEa4PxVQU2sMqAi51IzNVS1oI0VK6kRCABjQshCo-83tEgdA-tMLgxeqg-ESZMjcdwrx_j5JLnwMG8oKo_h8QrD_TQrK84dKjihAknRak-Y14UOqpiaBYgml7CY7s6dhnL_Pix4OcMjVhaul47uenSTjwemAxIeHry3hHfTGzt1kir6t-jK-PyfMDD3zkF6URA3kVQbz8xACVzBoSU4WTbvq0Tx-DMNypzgE6lCiYIiCcT3---UQrX6RBOgPRx0INnPKLhMyqOKoxsiMFpaGS7ygFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgARLk1Hg1_uuoWocSHLSpR2-2OrkiyCCptY_Dc4gsXA8rO3OhrSleWx8pvQxpVstLerrIQe_c565iN1ztIdJUA-mWkj6JncVck42sPP9Pf-d2HLq5X5c5LyX6QOs_pHmcyo63zBVnsxtIpc_Pccnixm17WZ5_l_V418WJA-M3EIMG1iRKoQP_9VUlWaQtHCjSiq0YSEFv95RpB94q2j9vjTQaErEJA26FToVlAmaCbr6l_rMcGiIg1sdHAydFNDemqVolKj-g-6ym_pHuGiOkTnWQTVJibZAoBTAB; kuaishou.sixin.login_st=ChdrdWFpc2hvdS5zaXhpbi5sb2dpbi5zdBKgAQT375OUDpn5TXCI4c8EzmEAr3TWJJ56xja7Hj1E5peFaNq8_B5xOqC79a19niWEdBOhejXpyhbB9ga5KbcjHT5zPIzo5GvbHU7Bd_ywYtJLFD8YLVo8txJ__bL12PVtMkwV90wUU6G2ndepvyMJX-4pDdIAqmwXMlgdL5GsHy8c1LWS3RGNwh2JZs2X7M5ck1hjS5lcnEezJ9qsNPdvTuUaEiX5bz-J70ThowsWD80kXuYL-yIgTCcA6HK7asIIsgsdA4Ycdtwy4n6OBb_w2r5j6FAVWUwoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.111701; lon=113.403360; mod=iPhone13%2C2; net=WIFI; sys=iOS_14.2; token=c13419c9168c4b83900e1510d685ff14-1963187365; userId=1963187365; ver=9.0; browseType=4; country_code=cn; cs=false; darkMode=false; foreign=0; global_id=DFP18F3A08EAA3FD5B91D3A8DB4E90F17A63AEA63BB5EFB741F64FAF39E89C46; isp=CMCC; ll=Cd4g9WqYHDdAEYTxBajQWVxA; os=14.2; power_mode=0; session_id=27BF7A5D-F438-409F-A61C-A271179CA646; sh=2532; sid=27BF7A5D-F438-409F-A61C-A271179CA646; sw=1170; ud=1963187365; weblogger_switch=";
    String cookie2="appver=9.0.30.4898; browseType=4; c=a; client_key=56c3713c; countryCode=cn; country_code=cn; cs=false; darkMode=false; egid=DFP18F3A08EAA3FD5B91D3A8DB4E90F17A63AEA63BB5EFB741F64FAF39E89C46; foreign=0; gid=DFP18F3A08EAA3FD5B91D3A8DB4E90F17A63AEA63BB5EFB741F64FAF39E89C46; global_id=DFP18F3A08EAA3FD5B91D3A8DB4E90F17A63AEA63BB5EFB741F64FAF39E89C46; isp=CMCC; kpf=IPHONE; kpn=KUAISHOU; ks-s-ctn=0; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAEZf4lKIJSJVtnjRR-mQA8wOpo6nPuwJ_QwcO7kOgMWkWPW7aBta_oni4_iw_3t0gkjESEW5XPQgsF2CfgCtrk2X5sUuehFOKPTPmnOT9bTwZzqMvqAGT2ohFmqY-99NJynAtToMdPVIccvBshmdq-2l45w6K2recFxbE3zRUThXug33khsC3xk4eEgPbPY0vsvOkY1Ppn2O0Gj7g7ZgP-X8O98piZobuu0dJScsHqAghoSazTfny_JTR-ACizRT3ZIfi-5IiACBUXUlMMdbms7__9re5jB0Os4f7tyxUcHCrBJOTUTjygFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAT7x3km5fGLDo71zjcND6RAARHVa640VIiq2dIO5idN_qmBlbnxrvOsM_mHDFR6PJa3dGBQEYjpHpPKkFXhswoqnwmWU_qutNz6z6GVSwCSd3YHNWQpbLfNQMr7D_NPBrfuPO16ZDcWVecpgVLgL9WsURGzARH4goGqw_doo_7qt-ZcqAig2gyLqjXkFS7Q6u4fO4PC8PrONE3e8wMVuhRAaEhjJyx43dk5d3a_MhbFPKNS9fCIgw6FYLZQiznh_HmbiMaY2Ov0ykYJFc98TgCZyOGX1_TQoBTAB; kuaishou.sixin.login_st=ChdrdWFpc2hvdS5zaXhpbi5sb2dpbi5zdBKgAa3g35P_FLYNbfMTAV7oowWLU2OJJ6sLz9R952APo01feS8cx2aRNtStx6Xc8lwbPKKKBparu_VSUlN6qFYiPiVWAMrIih-ECJtgO03EC5KCgMMsPY9e8lrHWMo9ZgjvSU2a7bDv6UfVARU-uoLCxpl8yNVDU9GLHvUMiIM3c4sPfD9ijE73yjTAgvDwaSXPJtRMywM2gMN3l3BPFYTD6WQaEk8ZgyzV6kDTiIME3Bz8GqJ7ViIgPTeY0S0Q7rb6B_YhZo_6sfQJYI7GBZ3GgHAkrJ3NsyQoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.11191191142212; ll=CUOXT0KmHDdAESAZoI%2FSWVxA; lon=113.4034766257723; mod=iPhone13%2C2; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; power_mode=0; session_id=05C6EB59-1842-4184-9AD6-9934462000D0; sh=2532; sid=05C6EB59-1842-4184-9AD6-9934462000D0; sw=1170; sys=ios14.2; token=d1b693fe032c49c1a442f4ca9ba239c1-1975218108; ud=1975218108; userId=1975218108; ver=9.0; weblogger_switch=; did=9194D956-A77D-4825-BE62-0A6E4FCB14E1; ks-s-ctn=0";
    String url = "https://app.kwaixiaodian.com/rest/app/grocery/ks/order/create/v2?retrylimit=true&serverExpTag=1_u%2F2482609_msk222002";

    boolean flag=false;
    boolean endFlag=true;
    int num=0;

        public static void main(String args[]) {
        for (int i=0;i<30;i++){
            new Thread(new commitKs2(),"ks"+i).start();
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
            if(df.format(new Date()).compareTo("2021-02-01 11:59:58:500")>0){
                flag=true;
            }else{
                if(num==0){
                    System.out.println("等待中");
                    num++;
                }

            }
            if(df.format(new Date()).compareTo("2021-02-01 12:00:02.000")>0){
                endFlag=false;
            }
            if(flag){
                if(endFlag) {
                    String message = postUtils.post(url, json, true, cookie);
                    String message2 = postUtils.post(url, json2, true, cookie2);
                    System.out.println(df.format(new Date())+message + "-一号");
                    System.out.println(df.format(new Date())+message2 + "-二号");
                }
            }
//
        }

}


}
