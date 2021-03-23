package com.yang.selectsku.utils;

import com.yang.selectsku.DyPost.commitKs;
import com.yang.selectsku.DyPost.commitKsTest;
import com.yang.selectsku.controller.getSku;
import org.apache.http.HttpException;

import java.io.IOException;

public class getKsSku implements Runnable {

    public String itemId;
    public getKsSku(String itemId){
        this.itemId=itemId;
    }


    public static void main(String args[]){
        for (int i=0;i<1 ;i++) {
            getKsSku getKsSku = new getKsSku("1153115418880");
            Thread thread = new Thread(getKsSku, "getSku"+i);
            thread.start();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void run() {
        boolean flag=true;
        while (1 == 1) {
            try {
                String cookie="appver=9.0.30.4898; browseType=4; c=a; client_key=56c3713c; countryCode=cn; country_code=cn; cs=false; darkMode=true; did=9194D956-A77D-4825-BE62-0A6E4FCB14E1; egid=DFP6EB5557B5EA7E82A469C61CA08B8354D4C18E6BE06568FF04B1342B10605E; foreign=0; gid=DFP6EB5557B5EA7E82A469C61CA08B8354D4C18E6BE06568FF04B1342B10605E; global_id=DFP6EB5557B5EA7E82A469C61CA08B8354D4C18E6BE06568FF04B1342B10605E; isp=CMCC; kpf=IPHONE; kpn=KUAISHOU; ks-s-ctn=0; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAGLZmnTTfHUHjDDnd4l2KBWIgAMb4jNY2L1AUNp2CpNx0hQ99AsFKM-7EqkMqwwFgVKIlmivitd_K12fgZ0xb87iKvVi3OdtpMKeGIapt7LDUPOWSidOfzec7XmSGgflh-I3lyZSTFDRHN5VQp90AmH2Dsa2vMDPnl0r5-528zkWMVNNn-Ti-sz8K9PyqcJaTnu_VEiF89m4uOBBbp8shXQMn3LFkaWOEjfpS3-_J40YxoSO10xFXRwSIqcekHg3JqdJpRXIiCJLSjwjqEYvUKigEB-8euxF1b3yzEocyulGLOZ9nDh1ygFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAd2PDBWMBFtLzxKJVpUQai_hAZci9N_NFhVLuzY9Nx3zVzyksXBTkJTiU94Qs4gtdOSxOuKR1_-qsRR1PwKrSPdd5Fv-pXa3lnP5Pl7vo5HF6MoybDBOS60wLQrnDub5046iMG61ufNihHLTn1TGTWfXDLMXULkkz3Y7cVgV2ke7DYMaSQ7O3YVq2a9lUHemEd8FDLgzB9nRzi-KqQRPymEaEi0FTenUzzyakcPnzsVR98aTkSIg8lehYpmet7qUI0hWeidRbR6Rujf3XiZ5nLzXo6K6n8coBTAB; kuaishou.sixin.login_st=ChdrdWFpc2hvdS5zaXhpbi5sb2dpbi5zdBKgAXBa2IaTPISV-pwo8B3bxgSBXXW40PGpSGvuXjZKk58ZmHgie8-R_FUHXlH2yFxIX0sZqL53LTN6a1t8B2KMJPOBUCUfvFs-LNoLLdSmcBlhZnKbTKHfXMr4HdbY9b3my7M1TtuMGJBd_V4V6CftY40w_rCm5NNfZYCBXGBO63BRYsKnzwchRgquqKUqE3nsS1C4Fbmd7zsQUjIRuqOXXZ8aElCFD4yoG0dNrMrGMgWk18ADhiIg7tZf6dFnaZpN0hkN8jld5gPpNdBH2P6AXdYp3VVdXcQoBTAB; language=zh-Hans-CN;q=1; lat=23.11193537936646; ll=CfCkCcynHDdAEQRh6AHTWVxA; lon=113.4035038728071; mod=iPhone13,2; net=中国移动_3; os=14.2; power_mode=0; session_id=DDB4BE19-AE09-44C0-B29C-DFEFFF5374C0; sh=2532; sid=DDB4BE19-AE09-44C0-B29C-DFEFFF5374C0; sw=1170; sys=ios14.2; token=fb4dfe5b7321486ba15975077a4d56d0-1963187365; ud=1963187365; userId=1963187365; ver=9.0; weblogger_switch=; ks-s-ctn=e815d17f-05ae-46db-bb52-66ea650fc891; ks-s-ctn=0";
                int skuStock= Integer.parseInt(postUtils.getSkuState(postUtils.httpGet("https://app.kwaixiaodian.com/rest/app/grocery/product/self/detail?itemId="+itemId+"&retryLimit=true", "UTF-8", cookie)));
                System.out.println(skuStock);
                int num=0;

                if(skuStock>0){
                    String result=commitKsTest.commit();
                    System.out.println(result);
                    String message =
                            " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                    "  \"content\":\"快手提交结果 ： 成功  \"," +
                                    "  \"summary\":\"快手提交结果 ： 成功  \"," +
                                    "  \"topicIds\":[ \n" +
                                    "      1205\n" +
                                    "  ]," +
                                    "  \"contentType\":2, " +
                                    "  \"uids\":[" +
                                    "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
                                    "  ]}";
                    getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                }
            } catch (HttpException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
