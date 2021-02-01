package com.yang.selectsku.utils;

import com.yang.selectsku.DyPost.commitKs;
import org.apache.http.HttpException;

import java.io.IOException;

public class getKsSku implements Runnable {


    public static void main(String args[]){
        for (int i=0;i<1;i++) {
            getKsSku getKsSku = new getKsSku();
            Thread thread = new Thread(getKsSku, "getSku"+i);
            thread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        boolean flag=true;
        while (1 == 1) {
            try {
                String cookie = "appver=8.3.31.4600; browseType=4; c=a; client_key=56c3713c; country_code=cn; cs=false; darkMode=false; did=57FA0A19-8744-4096-933D-965B0AA65A16; foreign=0; global_id=DFP28331CC076AFA997341CC37F576ECB96CD84A87952819862C4835A04CC0AA; isp=; kpf=IPHONE; kpn=KUAISHOU; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAFfGtKoTbyGMQZSdkScjsGvD2b-rxuTyzaUhk-4BsBYTha71ULBFf05KZob7YqWBHmNqT4u1H75tkJlmPJ7LtQlbHCUqGRnfzCpD5_n-7KUBkoLxxWS-Bw9sshnY9uvPE3BrE9ItAH52Z0HjwCfnXUkvWIcZKmQV_XnVtssYZWzWNnKfIo48L2hsRoNFw1h6rlLoGpBDmMNeUjiEdFSMMArEHyPK4tbDcP5ybyTrqU0rBoSRCUg25kRQfGgW7J-1Cb386UHIiAdPwKzcBj1CHZ1TnSbnJOHGNFGI6uwg8Ut4nVTLJqOPigFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAfEI5rXx-9z5_tj-ZKBJBoIXAg1Lc61p71G91qFLzitEtugx4yM_ucxmGR_6NIwCZ3LmWpQ5v70UYpGADMKdvyAtFtIsrXr4cYYzX3ZDRaCTT1wcmJjbfzZixLWOImxM0TRhOvhgWy5ZdjbZkjr9otkmL5lih-9KvbN-Mn7KwNMsbHnQc8T1OOaVwdBYuZRvzg171ihclofoGL26tjWB-c8aEtIXc_XUTivPxSOZo8JjD5AnfSIg6e7NkHXcJ5kgjmqqCLLQkuFk7YhNZXTBJA04SSyBfNAoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.11167929190704; ll=CZRhmgOXHDdAEWPDLWvPWVxA; lon=113.403284830752; mod=iPhone10%2C1; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; session_id=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sh=1334; sid=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sw=750; sys=ios14.2; token=d01d71ffdc744bc9abd3bf769f934eb4-1963187365; ud=1963187365; ver=8.3; weblogger_switch=; appver=8.3.31.4600; browseType=4; c=a; client_key=56c3713c; country_code=cn; cs=false; darkMode=false; did=57FA0A19-8744-4096-933D-965B0AA65A16; foreign=0; global_id=DFP28331CC076AFA997341CC37F576ECB96CD84A87952819862C4835A04CC0AA; isp=; kpf=IPHONE; kpn=KUAISHOU; kuaishou.api_st=Cg9rdWFpc2hvdS5hcGkuc3QSsAFfGtKoTbyGMQZSdkScjsGvD2b-rxuTyzaUhk-4BsBYTha71ULBFf05KZob7YqWBHmNqT4u1H75tkJlmPJ7LtQlbHCUqGRnfzCpD5_n-7KUBkoLxxWS-Bw9sshnY9uvPE3BrE9ItAH52Z0HjwCfnXUkvWIcZKmQV_XnVtssYZWzWNnKfIo48L2hsRoNFw1h6rlLoGpBDmMNeUjiEdFSMMArEHyPK4tbDcP5ybyTrqU0rBoSRCUg25kRQfGgW7J-1Cb386UHIiAdPwKzcBj1CHZ1TnSbnJOHGNFGI6uwg8Ut4nVTLJqOPigFMAE; kuaishou.h5_st=Cg5rdWFpc2hvdS5oNS5zdBKgAfEI5rXx-9z5_tj-ZKBJBoIXAg1Lc61p71G91qFLzitEtugx4yM_ucxmGR_6NIwCZ3LmWpQ5v70UYpGADMKdvyAtFtIsrXr4cYYzX3ZDRaCTT1wcmJjbfzZixLWOImxM0TRhOvhgWy5ZdjbZkjr9otkmL5lih-9KvbN-Mn7KwNMsbHnQc8T1OOaVwdBYuZRvzg171ihclofoGL26tjWB-c8aEtIXc_XUTivPxSOZo8JjD5AnfSIg6e7NkHXcJ5kgjmqqCLLQkuFk7YhNZXTBJA04SSyBfNAoBTAB; language=zh-Hans-CN%3Bq%3D1; lat=23.11167929190704; ll=CZRhmgOXHDdAEWPDLWvPWVxA; lon=113.403284830752; mod=iPhone10%2C1; net=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8_5; os=14.2; session_id=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sh=1334; sid=3F0B8FBD-CA09-48C9-BD7F-22B53579779F; sw=750; sys=ios14.2; token=d01d71ffdc744bc9abd3bf769f934eb4-1963187365; ud=1963187365; ver=8.3; weblogger_switch=; countryCode=CN; egid=DFPEC33CF54AD5D6A7D8E581DF46A2C0CB8BA31022ED6214BB3FCDF0C296CC94; gid=DFPEC33CF54AD5D6A7D8E581DF46A2C0CB8BA31022ED6214BB3FCDF0C296CC94; kuaishou.sixin.login_st=; userId=1963187365; ks-s-ctn=8eed87a9-a6df-45ca-9e87-5788c1dec79a";
                int skuStock= Integer.parseInt(postUtils.getSkuState(postUtils.httpGet("https://app.kwaixiaodian.com/rest/app/grocery/product/self/detail?itemId=885839274282&retryLimit=true", "UTF-8", cookie)));
                System.out.println(skuStock);
                int num=0;

                if(skuStock==0){
                    if(flag) {
                        commitKs commitKs = new commitKs();
                        Thread thread = new Thread(commitKs, "ks" + num);
                        thread.start();
                        num++;
                        flag=false;
                    }
                }
            } catch (HttpException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
