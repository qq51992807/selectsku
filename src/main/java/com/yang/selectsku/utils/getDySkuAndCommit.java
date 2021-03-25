package com.yang.selectsku.utils;

import com.yang.selectsku.DyPost.DyBuyCart;
import com.yang.selectsku.DyPost.DyBuyCart2;
import com.yang.selectsku.controller.getSku;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class getDySkuAndCommit implements Runnable{

    public int time;
    public  String itemId;
    public String itemName;
    public String combId;
    public  int  num=0;
    public boolean firstCome=true;
    public boolean addStart=true;
//    String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
//    String baiyeAddress="6837435314240340236";
//    String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};
//    String xCookie=" passport_csrf_token=9ca99ffdad1abbe901df514515e6779b; passport_csrf_token_default=9ca99ffdad1abbe901df514515e6779b; install_id=3237384126992995; ttreq=1$5339498c4c1bc6c31982d7628b01134327e66179; d_ticket=b8a37bb52c5fc8a7dfe3896a3dbfd5d986961; multi_sids=1472985216323047%3A50702332d2773a492a29154fffe9c1e7; odin_tt=85c44fad3e6fdfded72f207be3da152566fdfb0eea0549d27b217b37a841d2ed84a74bf233cf6fc4992e965143262bf29a7fe701253e5b873e7d069adf31954e; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=50702332d2773a492a29154fffe9c1e7%7C1614261497%7C5184000%7CMon%2C+26-Apr-2021+13%3A58%3A17+GMT; uid_tt=a0601eec5f0e138c946762d756c50cd6; uid_tt_ss=a0601eec5f0e138c946762d756c50cd6; sid_tt=50702332d2773a492a29154fffe9c1e7; sessionid=50702332d2773a492a29154fffe9c1e7; sessionid_ss=50702332d2773a492a29154fffe9c1e7";
//    String xAddress="6916499793699176711";
//    String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道石溪红太阳幼儿园旁边"};
//    //sister
//    String sCookie="passport_csrf_token=6e68c297546a71fd4815a8e60ccb3b14; passport_csrf_token_default=6e68c297546a71fd4815a8e60ccb3b14; d_ticket=4f767eff2e5ba8c5bdd2e7c24315a9b686961; multi_sids=3307744305625069%3A5ec312aeaf762303ca7eb9627799044e; n_mh=tiWJmiHDDSZkF2jPg-96KomjLPtt576IpcNIeEm_AOo; odin_tt=31e18ceda221e150fbcf70dd8070c46e76f45b9d023f348bb0989f088ee7aa6466a3695decd3b9618939c95123eeffa1b1984fe7b3d29056d14ccbc829fb6f63; sessionid=5ec312aeaf762303ca7eb9627799044e; sessionid_ss=5ec312aeaf762303ca7eb9627799044e; sid_guard=5ec312aeaf762303ca7eb9627799044e%7C1614347836%7C5184000%7CTue%2C+27-Apr-2021+13%3A57%3A16+GMT; sid_tt=5ec312aeaf762303ca7eb9627799044e; uid_tt=c2ebb22b53ee89e53685e2f2a9430a78; uid_tt_ss=c2ebb22b53ee89e53685e2f2a9430a78; install_id=1953160264683320; ttreq=1$40b78edabf045f7e266425e3bbd6ceb3878234b4";
//    String sAddress="6918589482463740172";
//    String[] sAddressList=new String[]{"陈雅晴","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头东街四巷幼儿园旁"};
String s2Cookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4; d_ticket=cfb1880c6bb762e173a6f515d8e68b9f1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C756116130366872%3A92f7a548a492b4e9f3aa9de7850b1191%7C105355465580%3A8ed43e8dd47b6c603330cdb6c7859882; odin_tt=e502009d34e418db7119e4634e5a50bb4ed2753c02bfa560abb6a583a016cf1f97dffd6ae8bff98e69f4d873ebbdb7887f7b805deccd18b971f30609fa58b43b; n_mh=SHOETCR3w2Ik0FhySpqbIvNm7RD_W6I8fpCDQxuMU4k; sid_guard=8ed43e8dd47b6c603330cdb6c7859882%7C1614345714%7C5184000%7CTue%2C+27-Apr-2021+13%3A21%3A54+GMT; uid_tt=ed036b6908ea659b1af4f5dbc0df2d79; uid_tt_ss=ed036b6908ea659b1af4f5dbc0df2d79; sid_tt=8ed43e8dd47b6c603330cdb6c7859882; sessionid=8ed43e8dd47b6c603330cdb6c7859882; sessionid_ss=8ed43e8dd47b6c603330cdb6c7859882";
    String s2Address="6918658514772640013";
    String[] s2AddressList=new String[]{"许教锐","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村新街金康药房旁边"};
    //第二个号 father
    String fCookie="passport_csrf_token=9ca99ffdad1abbe901df514515e6779b; passport_csrf_token_default=9ca99ffdad1abbe901df514515e6779b; install_id=3237384126992995; ttreq=1$5339498c4c1bc6c31982d7628b01134327e66179; d_ticket=29f4cb107313e2066dee97c9f6374adb86961; multi_sids=1472985216323047%3A50702332d2773a492a29154fffe9c1e7%7C3737940135263357%3Ad0267a40ce65f85489d14a4bbd1bd1c8; odin_tt=0bea8d0d17c0f85e13435118599e24b3102611d051622984838df183be8f57fb4bd4c75ca4041714bfe6eaf00689752c180226c7d0ecc8af6c7f8fb74d402dce; n_mh=e7zrLh1hc595q6UZf4MiMRkxIBd-K2qBrejNnmwEzS0; sid_guard=d0267a40ce65f85489d14a4bbd1bd1c8%7C1614346908%7C5184000%7CTue%2C+27-Apr-2021+13%3A41%3A48+GMT; uid_tt=a632cc09dc7dd37c4e01539a725d475d; uid_tt_ss=a632cc09dc7dd37c4e01539a725d475d; sid_tt=d0267a40ce65f85489d14a4bbd1bd1c8; sessionid=d0267a40ce65f85489d14a4bbd1bd1c8; sessionid_ss=d0267a40ce65f85489d14a4bbd1bd1c8";
    String fAddress="6918559175584858371";
    //        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440500","汕头市","440513","潮阳区","棉城南中路永安园c区4栋601"};
    String[] fAddressList=new String[]{"杨建辉","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道红太阳旁边菜鸟驿站"};
    //chenyang
    String cCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=a7861b6c51f5bc8ee50866c49bca398b1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892; odin_tt=868ce1bf3a4c6f3f3d0cb9673fd5829cd480e758a00dbc5b9247c652d7fa49dbd752ec04a1fab4d8ac4e33ee8ed4852c69330ea594b6b44961b43cdb072b6dcf; n_mh=X3mk4JLS5hSPdGvdQopR-ixSByMPMsY-A_ADl09B0pM; sid_guard=40aad9b8036149cf70ea4652e3704892%7C1611843122%7C5184000%7CMon%2C+29-Mar-2021+14%3A12%3A02+GMT; uid_tt=a08cfc446d0c0ecd563fc974ae4710a8; uid_tt_ss=a08cfc446d0c0ecd563fc974ae4710a8; sid_tt=40aad9b8036149cf70ea4652e3704892; sessionid=40aad9b8036149cf70ea4652e3704892; sessionid_ss=40aad9b8036149cf70ea4652e3704892";
    String cAddress="6894594590695751939";
    String[] cAddressList=new String[]{"程陆羊","133****5078","510000","四川省","510100","成都市","510116","双流区","正北下街176号"};
    //c5
    String c5Cookie="passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; tt_webid=f8197919392e0d221919204567d7062f; d_ticket=e7224a45a3117bbbe16d39f2918458bdeb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d%7C105355465580%3A7cbee9771b6cb13a168f6c2d518181d1%7C3737940135263357%3A1b9594bff220657ba60fe275f009f732%7C756116130366872%3A86b7d27c000c5cbe61ff914b17a931e1%7C2752825819145204%3Ae07e80e84e13c42fb655def213f75955%7C104560386685%3A6bb98eede0c8c63ebcb71aba734b45bb; n_mh=1Zzmvx-ZDThnBmYDgz8bnH9bp7H46JZ9u1B5bsaCEj8; odin_tt=7945aa5e80a3a2072b6b5c028dd2b66febfd4cade99d52f3ba10302694e430563c6c2fd8241d83debae79fd5f276b81feed3f1076671338cea3df29d936c63ec; sessionid=6bb98eede0c8c63ebcb71aba734b45bb; sessionid_ss=6bb98eede0c8c63ebcb71aba734b45bb; sid_guard=6bb98eede0c8c63ebcb71aba734b45bb%7C1614256888%7C5184000%7CMon%2C+26-Apr-2021+12%3A41%3A28+GMT; sid_tt=6bb98eede0c8c63ebcb71aba734b45bb; uid_tt=fd1e6bcbb3d4b9ac50f66a1bf553162f; uid_tt_ss=fd1e6bcbb3d4b9ac50f66a1bf553162f; install_id=3606819300717640; ttreq=1$badf703a7fca8ea3d0e028d4fa4f486ecb8099ce";
    String c5Address="6894589775353807108";
    String[] c5AddressList=new String[]{"陈小羊","173****4230","510000","四川省","510100","成都市","510116","双流区","天府大道南段846号"};
    //第一个号 mon
    String mCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; d_ticket=0fded85b73da0401c3d23c26db55f19e1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C83195091752253%3A6b00b372db8e0677d29698f6d6ac066e%7C756116130366872%3A92f7a548a492b4e9f3aa9de7850b1191; n_mh=D7xgIq_o9qQ0h91TFc4cI-fBXrdBKjUlpxVoR4skJCs; odin_tt=3de8f0601a91f18310c3d3465fd5d3f1ce47fe36e288a6e62fea119acaa8423a0889c0ce000f6db313909b24707ce5f278f6105267e97ef6b526896d142a6adc; sessionid=92f7a548a492b4e9f3aa9de7850b1191; sessionid_ss=92f7a548a492b4e9f3aa9de7850b1191; sid_guard=92f7a548a492b4e9f3aa9de7850b1191%7C1614345485%7C5184000%7CTue%2C+27-Apr-2021+13%3A18%3A05+GMT; sid_tt=92f7a548a492b4e9f3aa9de7850b1191; uid_tt=e034f84f17a94e15414b72de1d9e93ab; uid_tt_ss=e034f84f17a94e15414b72de1d9e93ab; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4";
    String mAddress="6918549752523047181";
    String[] mAddressList=new String[]{"洪启扬","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道河溪串串旁边东街四巷菜鸟驿站"};

    String cookie="tt_webid=f8197919392e0d221919204567d7062f; passport_csrf_token=971e61e5ebff4411db99fb1b9a04d13b; passport_csrf_token_default=971e61e5ebff4411db99fb1b9a04d13b; install_id=3606819300717640; ttreq=1$badf703a7fca8ea3d0e028d4fa4f486ecb8099ce; odin_tt=b8c3c3ca3e012152020563f000b37026e9217e433b41191eca01f960e2201b1a2302f56793133411506717250a42ccdd69a1031e74886e28e057e24444b577d8; n_mh=QUECUHe-NIZU7W_CpbsPkdHMuPtEwiQNvQozhrliKAQ; d_ticket=ab37e866c17393172b025b272924e9edeb0cd; sid_guard=1b44ac3ad03d5a784d94ad723211ea94|1616665420|5184000|Mon,+24-May-2021+09:43:40+GMT; uid_tt=0091511ea16d81ef06ae13b21f49cba6; uid_tt_ss=0091511ea16d81ef06ae13b21f49cba6; sid_tt=1b44ac3ad03d5a784d94ad723211ea94; sessionid=1b44ac3ad03d5a784d94ad723211ea94; sessionid_ss=1b44ac3ad03d5a784d94ad723211ea94; multi_sids=88742122835:25b3fa0b3ab384dde7d9e0a51288964d|3737940135263357:1b9594bff220657ba60fe275f009f732|756116130366872:86b7d27c000c5cbe61ff914b17a931e1|2752825819145204:e07e80e84e13c42fb655def213f75955|104560386685:6bb98eede0c8c63ebcb71aba734b45bb|2779157997825406:1b44ac3ad03d5a784d94ad723211ea94";
    String addressId="6943523905256669473";
    String[] AddressList=new String[]{"杨梓博","135****0143","510000","四川省","510100","成都市","510116","双流区","正北下街168号御景台"};


    DyBuyCart dyBuyCart;
    DyBuyCart dyBuyCart2;
    DyBuyCart dyBuyCart3;
    DyBuyCart dyBuyCart4;
    DyBuyCart dyBuyCart5;

    public getDySkuAndCommit(String itemId,String combId, String itemName, int time, boolean addStart){
        this.itemId=itemId;
        this.combId=combId;
        this.itemName=itemName;
        this.time=time;
        this.addStart=addStart;
//        dyBuyCart=new DyBuyCart(baiyeCookie, baiyeAddress,itemId,combId,baiyeAddressList);
//        dyBuyCart2=new DyBuyCart(xCookie,xAddress,itemId,combId,xAddressList);
//        dyBuyCart3=new DyBuyCart(sCookie,sAddress,itemId,combId,sAddressList);
//        dyBuyCart3=new DyBuyCart(cCookie,cAddress,itemId,combId,cAddressList);
//        dyBuyCart4=new DyBuyCart(c5Cookie,c5Address,itemId,combId,c5AddressList);
//        dyBuyCart5=new DyBuyCart(mCookie,mAddress,itemId,combId,mAddressList);
        dyBuyCart=new DyBuyCart(cookie, addressId,itemId,combId,AddressList);
//        dyBuyCart2=new DyBuyCart(fCookie,fAddress,itemId,combId,fAddressList);
    }

    public void run(){
        while (1==1) {
            try {
                httpGet("https://ec.snssdk.com/product/getstock?id=" + itemId,itemId,combId, itemName);
                Thread.sleep(0 * time);
            } catch (HttpException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void main(String args[]){
        for(int i=1;i<3;i++) {
            getDySkuAndCommit getDySkuAndCommit = new getDySkuAndCommit("3469911916158283919", "1694292913360935", "8499", 1, false);
            getDySkuAndCommit getDySkuAndCommit2 = new getDySkuAndCommit("3469913342095789983", "1694293620671533", "9399", 1, false);
//            getDySkuAndCommit getDySkuAndCommit2 = new getDySkuAndCommit("3467328892761730995", "1693219764071437", "k40 256", 1, false);
//            getDySkuAndCommit getDySkuAndCommit3 = new getDySkuAndCommit("3467328892761730995", "1693219766630446", "k40 256", 1, false);
//            getDySkuAndCommit getDySkuAndCommit4 = new getDySkuAndCommit("3467328892761730995", "1693219766630462", "k40 128", 1, false);
//            getDySkuAndCommit getDySkuAndCommit5 = new getDySkuAndCommit("3467328892761730995", "1693219766630414", "k40 128", 1, false);
//            getDySkuAndCommit getDySkuAndCommit6 = new getDySkuAndCommit("3467328892761730995", "1693219764071453", "k40 128", 1, false);
//        getDySkuAndCommit getDySkuAndCommit=new getDySkuAndCommit("3453521734500751426","1422354648","mate40黑色128g",1,false);
//        getDySkuAndCommit getDySkuAndCommit2=new getDySkuAndCommit("3453521734500751426","1422354655","mate40黑色256g",1,false);
//        getDySkuAndCommit getDySkuAndCommit3=new getDySkuAndCommit("3453521734500751426","1422354657","mate40白色256g",1,false);
            Thread mThread1 = new Thread(getDySkuAndCommit, "线程a"+i);
            Thread mThread2 = new Thread(getDySkuAndCommit2, "线程b"+i);
//            Thread mThread3 = new Thread(getDySkuAndCommit3, "线程c"+i);
//            Thread mThread4 = new Thread(getDySkuAndCommit4, "线程d"+i);
//            Thread mThread5 = new Thread(getDySkuAndCommit5, "线程e"+i);
//            Thread mThread6 = new Thread(getDySkuAndCommit6, "线程f"+i);
            mThread1.start();
            mThread2.start();
//            mThread3.start();
//            mThread4.start();
//            mThread5.start();
//            mThread6.start();
        }
    }
//public static void main(String args[]){
//
////    getDySku getDySku=new getDySku("3457878064195892911","老罗黄金",1,true);
////    testDyBuy testDyBuy=new testDyBuy();
////    testDyBuy2 testDyBuy2=new testDyBuy2();
////    while(1==1) {
////        getDySku.sendMessageDy(testDyBuy.post(getDySku.itemId, "1572967386"), "老罗黄金");
////        getDySku.sendMessageDy(testDyBuy2.post(getDySku.itemId, "1572967386"), "老罗黄金");
////    }
//    getDySku getDySku=new getDySku("3453521734500751426","mate40",1,false);
//    DyBuyHuawei dyBuyHuawei=new DyBuyHuawei();
//    getDySku.sendMessageDy(dyBuyHuawei.post(getDySku.itemId, "1422354648"), "mate40");
//
//}


    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    public  String httpGet(String url,String itemId,String combId,String itemName)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");

// 设置参数
        try {
            httpGet.setURI(new URI(url));
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。"+e.getMessage());
        }
// 发送请求
        HttpClient client=HttpClients.createDefault();
        HttpResponse httpResponse = client.execute(httpGet);
// 获取返回的数据
        HttpEntity entity = httpResponse.getEntity();
        byte[] body = EntityUtils.toByteArray(entity);
        StatusLine sL = httpResponse.getStatusLine();
        int statusCode = sL.getStatusCode();
        if (statusCode == 200) {
            json = new String(body);
            entity.consumeContent();
        } else {
            throw new HttpException("statusCode="+statusCode);
        }
        if(json==null||json.equals("")||json.equals("[]")){

        }else {
            try {
                JSONObject jsonArray = new JSONObject(json);
                JSONObject data = new JSONObject(jsonArray.getString("data") + "");
                //sku
                JSONObject stock=new JSONObject(data.getString("stock")+"");
                int StockNum=0;
                Iterator iterator=stock.keys();
                while (iterator.hasNext()){
                    String key = String.valueOf(iterator.next());
//                    String value = "";

                    if(stock.get(key) != null) {
//                        value = stock.get(key).toString();
                        JSONObject stockValue=new JSONObject(stock.get(key).toString()+"");
                        if(stockValue.getString("id").equals(combId))
                            StockNum=Integer.parseInt(stockValue.getString("stock_num"));
                    }
                }

//                int StockNum = Integer.parseInt(data.getString("total_stock_num"));
//                if (firstCome)
                    System.out.println(df.format(new Date()) + " 商品编号：" + itemId + " 商品名称为：" + itemName + " 当前库存状态为 " + StockNum);
                // skuMessage="商品编号："+itemId+" 当前库存为:"+StockStateName;
//                System.out.println(dyBuyCart2.post());
                if (num != StockNum) {
//                    System.out.println(dyBuyCart.post(combId));
                    if (firstCome) {
                        if (addStart) {
                            String message =
                                    " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                            "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockNum + " \"," +
                                            "  \"summary\":\"开启抖音监控商品 " + itemName + " 成功 当前库存状态为 " + StockNum + "  \"," +
                                            "  \"topicIds\":[ \n" +
                                            "      1205\n" +
                                            "  ]," +
                                            "  \"contentType\":2, " +
                                            "  \"uids\":[" +
                                            "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
//                                            ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                            "  ]}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                        num = StockNum;
                    } else {
                        //        getSku.httpGet("http://wxpusher.zjiecode.com/api/send/message/?appToken=AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ&content="+title.trim()+"库存为"+jsonArray4.get("quantity")+"&uid=UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk","UTF-8",2);
                        System.out.println(dyBuyCart.post());
//                        System.out.println(dyBuyCart2.post());
//                        System.out.println(dyBuyCart3.post());
//                        System.out.println(dyBuyCart4.post());
//                        System.out.println(dyBuyCart5.post());
                        String message =
                                " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                        "  \"content\":\"商品名称：" + itemName + " 库存变化为 " + num + " -> " + StockNum + " \"," +
                                        "  \"summary\":\"库存提醒 抖音商品名称：" + itemName + " 库存变化为 " + num + " -> " + StockNum + " \"," +
                                        "  \"topicIds\":[ \n" +
                                        "      1205\n" +
                                        "  ]," +
                                        "  \"contentType\":2, " +
                                        "  \"uids\":[" +
                                        "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
//                                        ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                        "  ]}";
                        getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        num = StockNum;
                    }
                } else {
                    if (firstCome) {
                        if (addStart) {
                            String message =
                                    " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                            "  \"content\":\"商品名称：" + itemName + " 当前库存状态为 " + StockNum + " \"," +
                                            "  \"summary\":\"开启抖音监控商品 " + itemName + " 成功 当前库存状态为 " + StockNum + "  \"," +
                                            "  \"topicIds\":[ \n" +
                                            "      1205\n" +
                                            "  ]," +
                                            "  \"contentType\":2, " +
                                            "  \"uids\":[" +
                                            "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
//                                            ",  \"UID_N5AytME3daIlngtVm6Yt71xx7nrA\", \"UID_EXA4w2hi8PSinrndA9dK4ux8y5yw\" " +
                                            "  ]}";
                            getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
                        }
                        firstCome = false;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
    public  String post(String url,String data) {

        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils
                        .toString(httpresponse.getEntity());

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

    void sendMessageDy(String response,String itemName){
        if(response!=null&&response.length()!=0) {
            String response2 = TransationMessage(response);
            System.out.println(response2);
            if (response2.equals("")) {
                String message =
                        " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                "  \"content\":\"抖音 " + itemName + " 提交结果 ：" + response2 + "成功  \"," +
                                "  \"summary\":\"抖音 " + itemName + " 提交结果 ：" + response2 + "成功  \"," +
                                "  \"topicIds\":[ \n" +
                                "      1205\n" +
                                "  ]," +
                                "  \"contentType\":2, " +
                                "  \"uids\":[" +
                                "      \"UID_yV8nb3gdc7I6eYSBRWY0IQP3bcgk\"" +
                                "  ]}";
                getSku.post("http://wxpusher.zjiecode.com/api/send/message", message);
            }
        }
    }
    public String TransationMessage(String message){
        String data=null;
        try {
            JSONObject jsonArray = new JSONObject(message);
            data= jsonArray.getString("msg");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }


}
