package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.postUtils;
import org.apache.http.HttpException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.util.Random;

public class commitKs implements Runnable {



    public  static void main(String agrs[]){
            for(int i=0;i<3;i++){
                commitKs commitKs=new commitKs();
                Thread thread=new Thread(commitKs,"ks"+i);
                thread.start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    String address1="256800446365";//"115978411365";//"256800446365";
    String address2="197789953108";
//    String cookie1="appver=8.3.31.4600; browseType=4; c=a; client_key=56c3713c; country_code=cn; cs=false; darkMode=false; did=57FA0A19-8744-4096-933D-965B0AA65A16; foreign=0; global_id=DFP28331CC076AFA997341CC37F576ECB96CD84A87952819862C4835A04CC0AA; isp=; kpf=IPHONE; kpn=KUAISHOU; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAFfGtKoTbyGMQZSdkScjsGvD2b-rxuTyzaUhk-4BsBYTha71ULBFf05KZob7YqWBHmNqT4u1H75tkJlmPJ7LtQlbHCUqGRnfzCpD5_n-7KUBkoLxxWS-Bw9sshnY9uvPE3BrE9ItAH52Z0HjwCfnXUkvWIcZKmQV_XnVtssYZWzWNnKfIo48L2hsRoNFw1h6rlLoGpBDmMNeUjiEdFSMMArEHyPK4tbDcP5ybyTrqU0rBoSRCUg25kRQfGgW7J-1Cb386UHIiAdPwKzcBj1CHZ1TnSbnJOHGNFGI6uwg8Ut4nVTLJqOPigFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAfEI5rXx-9z5_tj-ZKBJBoIXAg1Lc61p71G91qFLzitEtugx4yM_ucxmGR_6NIwCZ3LmWpQ5v70UYpGADMKdvyAtFtIsrXr4cYYzX3ZDRaCTT1wcmJjbfzZixLWOImxM0TRhOvhgWy5ZdjbZkjr9otkmL5lih-9KvbN-Mn7KwNMsbHnQc8T1OOaVwdBYuZRvzg171ihclofoGL26tjWB-c8aEtIXc_XUTivPxSOZo8JjD5AnfSIg6e7NkHXcJ5kgjmqqCLLQkuFk7YhNZXTBJA04SSyBfNAoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.11167929190704; ll=CZRhmgOXHDdAEWPDLWvPWVxA; lon=113.403284830752; mod=iPhone10%2C1; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; session_id=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sh=1334; sid=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sw=750; sys=ios14.2; token=d01d71ffdc744bc9abd3bf769f934eb4-1963187365; ud=1963187365; ver=8.3; weblogger_switch=; appver=8.3.31.4600; browseType=4; c=a; client_key=56c3713c; country_code=cn; cs=false; darkMode=false; did=57FA0A19-8744-4096-933D-965B0AA65A16; foreign=0; global_id=DFP28331CC076AFA997341CC37F576ECB96CD84A87952819862C4835A04CC0AA; isp=; kpf=IPHONE; kpn=KUAISHOU; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAFfGtKoTbyGMQZSdkScjsGvD2b-rxuTyzaUhk-4BsBYTha71ULBFf05KZob7YqWBHmNqT4u1H75tkJlmPJ7LtQlbHCUqGRnfzCpD5_n-7KUBkoLxxWS-Bw9sshnY9uvPE3BrE9ItAH52Z0HjwCfnXUkvWIcZKmQV_XnVtssYZWzWNnKfIo48L2hsRoNFw1h6rlLoGpBDmMNeUjiEdFSMMArEHyPK4tbDcP5ybyTrqU0rBoSRCUg25kRQfGgW7J-1Cb386UHIiAdPwKzcBj1CHZ1TnSbnJOHGNFGI6uwg8Ut4nVTLJqOPigFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAfEI5rXx-9z5_tj-ZKBJBoIXAg1Lc61p71G91qFLzitEtugx4yM_ucxmGR_6NIwCZ3LmWpQ5v70UYpGADMKdvyAtFtIsrXr4cYYzX3ZDRaCTT1wcmJjbfzZixLWOImxM0TRhOvhgWy5ZdjbZkjr9otkmL5lih-9KvbN-Mn7KwNMsbHnQc8T1OOaVwdBYuZRvzg171ihclofoGL26tjWB-c8aEtIXc_XUTivPxSOZo8JjD5AnfSIg6e7NkHXcJ5kgjmqqCLLQkuFk7YhNZXTBJA04SSyBfNAoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.11167929190704; ll=CZRhmgOXHDdAEWPDLWvPWVxA; lon=113.403284830752; mod=iPhone10%2C1; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; session_id=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sh=1334; sid=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sw=750; sys=ios14.2; token=d01d71ffdc744bc9abd3bf769f934eb4-1963187365; ud=1963187365; ver=8.3; weblogger_switch=; countryCode=CN; egid=DFPEC33CF54AD5D6A7D8E581DF46A2C0CB8BA31022ED6214BB3FCDF0C296CC94; gid=DFPEC33CF54AD5D6A7D8E581DF46A2C0CB8BA31022ED6214BB3FCDF0C296CC94; kuaishou.sixin.login_st=; userId=1963187365; ks-s-ctn=8eed87a9-a6df-45ca-9e87-5788c1dec79a";
//    String cookie1="  appver=8.3.31.4600;  client_key=56c3713c; token=d01d71ffdc744bc9abd3bf769f934eb4-1963187365";
    String cookie1=" apptype=9; appver=2.10.30.10479; browseType=4; c=a; client_key=9ac68a4c; country_code=cn; darkMode=false; did=A90F6D0D-34ED-481C-B2EE-BBDABFF618D5; foreign=0; global_id=DFP45F19B2943387CF034F763DEC10DB69F7D7A2C70205047B4105A26C5DB1DA; isp=CMCC; kpf=IPHONE; kpn=THANOS; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAF4pki9uWeaUAlI7wPpwKg_36LkwHEvh2cp98ABXhX8kmYnFeb8sIMFX1Nr5HpLgAj4w9TcCnOnZO8Om6utZUEILMu2ycopbZg1GjUT2jbN2DiZhMFYiXEoAlNCQpSS9_WXkjYWvtqT30PiDZgM-ifmYGoFlHLqpcOcbkToWDLSQo9dojoBz8sPQLsZVZGHOocpskHdaMWaosq_5PMku-FU0UzpVF56j4HMIfyrJcNUVxoSIsIoLes9RPioExUSX2KZ9NeXIiC7n4h2anPmGh-MMYgcbWoQtjbGM_3Oe0oUdvAV47vowCgFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgARJ9SjaMaQYXFrMGHUM-rkd-CzRHdQumWjdse80guBnaouSZkIEmd7YpRfjc6lvWRgSiJzkvT2NKnY6K40S_T5JIdyXklHFmwFTWr5SVksC-bWQQKdO2h7Y0DFe3HAEYSVDo7psfjVrwcYLKGdaumVEQQ6N0VIhUJDmFrzQVpgYF8k0G2dq1pZJFmiCN_SEBbJbxvwk3Qxzszkusrk7Q1BMaEp0eftNRumGRlTzDnTam4VQFlCIgG7AY2_HLn6G3x6MXFQIaQPpL6AM9FXIFatb-Cxmwax0oBTAB; language=zh-Hans-CN%3Bq%3D1; mod=iPhone13%2C2; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; sh=2436; sid=0947D91C-67AA-4BA3-B25E-E133F16E53A3; sw=1125; sys=ios14.2; ud=1963187365; ver=2.10";
    //   String cookie2="appver=9.0.30.4898; browseType=4; c=a; client_key=56c3713c; country_code=cn; cs=false; darkMode=false; foreign=0; global_id=DFP1E465D944C30481DC30CB06CC8B8194A6FD49940C31305718A7F5DFB2685C; isp=CMCC; kpf=IPHONE; kpn=KUAISHOU; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAGt9kt9NzWTk1pHmthJ7NSm04eOsciCEa4PxVQU2sMqAi51IzNVS1oI0VK6kRCABjQshCo-83tEgdA-tMLgxeqg-ESZMjcdwrx_j5JLnwMG8oKo_h8QrD_TQrK84dKjihAknRak-Y14UOqpiaBYgml7CY7s6dhnL_Pix4OcMjVhaul47uenSTjwemAxIeHry3hHfTGzt1kir6t-jK-PyfMDD3zkF6URA3kVQbz8xACVzBoSU4WTbvq0Tx-DMNypzgE6lCiYIiCcT3---UQrX6RBOgPRx0INnPKLhMyqOKoxsiMFpaGS7ygFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgARLk1Hg1_uuoWocSHLSpR2-2OrkiyCCptY_Dc4gsXA8rO3OhrSleWx8pvQxpVstLerrIQe_c565iN1ztIdJUA-mWkj6JncVck42sPP9Pf-d2HLq5X5c5LyX6QOs_pHmcyo63zBVnsxtIpc_Pccnixm17WZ5_l_V418WJA-M3EIMG1iRKoQP_9VUlWaQtHCjSiq0YSEFv95RpB94q2j9vjTQaErEJA26FToVlAmaCbr6l_rMcGiIg1sdHAydFNDemqVolKj-g-6ym_pHuGiOkTnWQTVJibZAoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.11179360535886; ll=CRDrdoGeHDdAEcTYgkHRWVxA; lon=113.4033969667244; mod=iPhone13%2C2; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; power_mode=0; session_id=7E02FFFE-2451-4530-9B91-880AF04A9A92; sh=2532; sid=7E02FFFE-2451-4530-9B91-880AF04A9A92; sw=1170; sys=ios14.2; token=c13419c9168c4b83900e1510d685ff14-1963187365; ud=1963187365; ver=9.0; weblogger_switch=; countryCode=cn; egid=DFP1E465D944C30481DC30CB06CC8B8194A6FD49940C31305718A7F5DFB2685C; gid=DFP1E465D944C30481DC30CB06CC8B8194A6FD49940C31305718A7F5DFB2685C; kuaishou.sixin.login_st=ChdrdWFpc2hvdS5zaXhpbi5sb2dpbi5zdBKgAWidQvM7dR4SVM8VCe3rzZJ_WfKZ8Swvq0d5Md3LN62zjtHKt9hoNVOFiVaJtGk9pYAET2lkH0l8X4Tg5l-VSmGinORHqoUMB9RW2wUGYj3y0RmQpYoq9pcyQCSd96EDtNalKMtWX40fUZWor9DEf8ryuzWDbkYqy-wTCFJOihMWJc5KFKsj2uIt46Yi6uW2EAwz7v3TBqRk5sdH0w5T2GIaEkeSYEWVkEHotJ-aH5DP1qnVPCIgWwjVEWn7y-g5Y6eNrIxXyJIANyHRXo4uBcTlILxeo44oBTAB; userId=1963187365; ks-s-ctn=1207a12d-d171-4e5f-85b6-493864966c1e; did=9194D956-A77D-4825-BE62-0A6E4FCB14E1; ks-s-ctn=0; ks-s-ctn=0";
    String address=address1;
//    String cookie=cookie1;
    String itemId="885846213282";
    String skuId="885846214282";
    String authorId="1991432282";
    String price="149900";

//    String itemId="864696306280";
//    String skuId= "864696307280";
//    String authorId="1090119280";
//    String price="100";
    Random random=new Random();
    int num=0;
    @Override
    public void run() {
        String key="56c3713c";
        while (1 == 1) {
            String cookie="  appver=8.3.31.4600;  client_key="+key+"; token=c13419c9168c4b83900e1510d685ff14-1963187365;";
            String json = "{\"param\": \"{\\\"clientId\\\":1,\\\"remark\\\":\\\"\\\",\\\"addressId\\\":" + address + "," +
                    "\\\"mobile\\\":\\\"\\\",\\\"expressFee\\\":0,\\\"paymentFee\\\":"+price+",\\\"carrierType\\\":2,\\\"discountFee\\\":0," +
                    "\\\"likeExpTag\\\":\\\"\\\",\\\"skuList\\\":[{\\\"sellerId\\\":\\\""+authorId+"\\\",\\\"itemId\\\":\\\"" + itemId + "\\\"," +
                    "\\\"skuId\\\":\\\""+skuId+"\\\",\\\"num\\\":1,\\\"promoteParam\\\":null,\\\"price\\\":"+price+",\\\"expressFee\\\":0," +
                    "\\\"extInfo\\\":null,\\\"cpsParam\\\":null,\\\"insuranceParam\\\":{},\\\"saleAuthorization\\\":\\\"\\\",\\\"traceTag\\\":\\\"\\\"}]," +
                    "\\\"serverExpTag\\\":\\\"\\\",\\\"clientExpTag\\\":\\\"\\\",\\\"marketingInfoList\\\":null}\"}";
            String url = "https://app.kwaixiaodian.com/rest/app/grocery/ks/order/create/v2?retrylimit=true";
            String message = postUtils.post(url, json, true, cookie);
            System.out.println(message + "-第" + num + "次");
            num++;
//            try {
//                Thread.sleep(3000);
////                Thread.sleep(random.nextInt(100));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            if (message != null) {
                try {
                    JSONObject jsonArray = new JSONObject(message);
                    if (jsonArray.getInt("result") == 3404) {
//                        return;
                        if(key.equals("56c3713c")){
                            key="9ac68a4c";
                        }else {
                            key="56c3713c";
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
