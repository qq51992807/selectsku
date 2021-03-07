package com.yang.selectsku.DyPost;

import com.yang.selectsku.controller.getSku;
import com.yang.selectsku.utils.dyGetCombIdsUtils;
import com.yang.selectsku.utils.dyProductSearchUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class commitDy  implements Runnable {


    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式


//    String itemName="mate 40";
//    String authorId="88742122835";
//    String[] comboIds={"1460415030","1460415031","1460415034","1460415036","1460415037","1460415038","1460415039"};
//    String productId="3454882272933738579";

    String itemName;
    String authorId;
    String productId;
    List   comboIds;
    boolean twoMethod;

    public commitDy(String itemName,String authorId,String productId,List comboIds,boolean twoMethod){
        this.itemName=itemName;
        this.authorId=authorId;
        this.productId= productId;
        this.comboIds=comboIds;
        this.twoMethod=twoMethod;
    }



    public static  void main(String agrs[]){
        String itemName="冰淇淋鞋子";
        String authorId="99514375927";
        String productId="3462925694588298451";
        List comboIds=dyGetCombIdsUtils.getCombIds(productId);
        //开启线程提交
        for(int i=0;i<10;i++){
            int num=i+1;
            new Thread(new commitDy(itemName,authorId,productId,comboIds,false),"抢购线程"+num).start();
        }
    }


        //第一个号 mon
        String mCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; d_ticket=0fded85b73da0401c3d23c26db55f19e1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C83195091752253%3A6b00b372db8e0677d29698f6d6ac066e%7C756116130366872%3A92f7a548a492b4e9f3aa9de7850b1191; n_mh=D7xgIq_o9qQ0h91TFc4cI-fBXrdBKjUlpxVoR4skJCs; odin_tt=3de8f0601a91f18310c3d3465fd5d3f1ce47fe36e288a6e62fea119acaa8423a0889c0ce000f6db313909b24707ce5f278f6105267e97ef6b526896d142a6adc; sessionid=92f7a548a492b4e9f3aa9de7850b1191; sessionid_ss=92f7a548a492b4e9f3aa9de7850b1191; sid_guard=92f7a548a492b4e9f3aa9de7850b1191%7C1614345485%7C5184000%7CTue%2C+27-Apr-2021+13%3A18%3A05+GMT; sid_tt=92f7a548a492b4e9f3aa9de7850b1191; uid_tt=e034f84f17a94e15414b72de1d9e93ab; uid_tt_ss=e034f84f17a94e15414b72de1d9e93ab; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4";
        String mAddress="6918549752523047181";
        String[] mAddressList=new String[]{"许教锐","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道石溪红太阳幼儿园新街一巷"};

        //第二个号 father
        String fCookie="passport_csrf_token=9ca99ffdad1abbe901df514515e6779b; passport_csrf_token_default=9ca99ffdad1abbe901df514515e6779b; install_id=3237384126992995; ttreq=1$5339498c4c1bc6c31982d7628b01134327e66179; d_ticket=29f4cb107313e2066dee97c9f6374adb86961; multi_sids=1472985216323047%3A50702332d2773a492a29154fffe9c1e7%7C3737940135263357%3Ad0267a40ce65f85489d14a4bbd1bd1c8; odin_tt=0bea8d0d17c0f85e13435118599e24b3102611d051622984838df183be8f57fb4bd4c75ca4041714bfe6eaf00689752c180226c7d0ecc8af6c7f8fb74d402dce; n_mh=e7zrLh1hc595q6UZf4MiMRkxIBd-K2qBrejNnmwEzS0; sid_guard=d0267a40ce65f85489d14a4bbd1bd1c8%7C1614346908%7C5184000%7CTue%2C+27-Apr-2021+13%3A41%3A48+GMT; uid_tt=a632cc09dc7dd37c4e01539a725d475d; uid_tt_ss=a632cc09dc7dd37c4e01539a725d475d; sid_tt=d0267a40ce65f85489d14a4bbd1bd1c8; sessionid=d0267a40ce65f85489d14a4bbd1bd1c8; sessionid_ss=d0267a40ce65f85489d14a4bbd1bd1c8";
        String fAddress="6918559175584858371";
//        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440500","汕头市","440513","潮阳区","棉城南中路永安园c区4栋601"};
        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440100","广州市","440106","天河区","前进街道红太阳幼儿园旁边菜鸟驿站"};
//        DyBuyCom fDyBuyCom3 = new DyBuyCom(fCookie, fAddress, authorId, lyhComboId, productId,fAddressList);//显卡

        //第三个号7074
//        String xCookie="install_id=3993839559263757; ttreq=1$92c997f9f4a0e9b9d1895c89e46e1df6198a5762; passport_csrf_token=e9e998a9b301ed4c70808ef2e5f60d27; passport_csrf_token_default=e9e998a9b301ed4c70808ef2e5f60d27; d_ticket=42604e0fc8e7c2dc6782794070a8d3a61edd1; multi_sids=1472985216323047%3A4e9612523e552f72ba8e9dcc8b92cbec; odin_tt=c7d50a30ea6d22a428e9f190c6af9ee1a739bbbe49a1d1cc8f1501858f93b184546b62915b958a2c5fef562dcfebcea8a87350c2a9a2e166e3afa4f6c6440762; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=4e9612523e552f72ba8e9dcc8b92cbec%7C1610859650%7C5184000%7CThu%2C+18-Mar-2021+05%3A00%3A50+GMT; uid_tt=5e9c4bc12abc49d2135e94040578419d; uid_tt_ss=5e9c4bc12abc49d2135e94040578419d; sid_tt=4e9612523e552f72ba8e9dcc8b92cbec; sessionid=4e9612523e552f72ba8e9dcc8b92cbec; sessionid_ss=4e9612523e552f72ba8e9dcc8b92cbec";
        String xCookie=" passport_csrf_token=9ca99ffdad1abbe901df514515e6779b; passport_csrf_token_default=9ca99ffdad1abbe901df514515e6779b; install_id=3237384126992995; ttreq=1$5339498c4c1bc6c31982d7628b01134327e66179; d_ticket=b8a37bb52c5fc8a7dfe3896a3dbfd5d986961; multi_sids=1472985216323047%3A50702332d2773a492a29154fffe9c1e7; odin_tt=85c44fad3e6fdfded72f207be3da152566fdfb0eea0549d27b217b37a841d2ed84a74bf233cf6fc4992e965143262bf29a7fe701253e5b873e7d069adf31954e; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=50702332d2773a492a29154fffe9c1e7%7C1614261497%7C5184000%7CMon%2C+26-Apr-2021+13%3A58%3A17+GMT; uid_tt=a0601eec5f0e138c946762d756c50cd6; uid_tt_ss=a0601eec5f0e138c946762d756c50cd6; sid_tt=50702332d2773a492a29154fffe9c1e7; sessionid=50702332d2773a492a29154fffe9c1e7; sessionid_ss=50702332d2773a492a29154fffe9c1e7";
        String xAddress="6916499793699176711";
        String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道石溪红太阳幼儿园旁边"};
//        String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440500","汕头市","440513","潮阳区","棉城镇小哈佛幼儿园旁边"};

        //sister
        String sCookie="passport_csrf_token=6e68c297546a71fd4815a8e60ccb3b14; passport_csrf_token_default=6e68c297546a71fd4815a8e60ccb3b14; d_ticket=4f767eff2e5ba8c5bdd2e7c24315a9b686961; multi_sids=3307744305625069%3A5ec312aeaf762303ca7eb9627799044e; n_mh=tiWJmiHDDSZkF2jPg-96KomjLPtt576IpcNIeEm_AOo; odin_tt=31e18ceda221e150fbcf70dd8070c46e76f45b9d023f348bb0989f088ee7aa6466a3695decd3b9618939c95123eeffa1b1984fe7b3d29056d14ccbc829fb6f63; sessionid=5ec312aeaf762303ca7eb9627799044e; sessionid_ss=5ec312aeaf762303ca7eb9627799044e; sid_guard=5ec312aeaf762303ca7eb9627799044e%7C1614347836%7C5184000%7CTue%2C+27-Apr-2021+13%3A57%3A16+GMT; sid_tt=5ec312aeaf762303ca7eb9627799044e; uid_tt=c2ebb22b53ee89e53685e2f2a9430a78; uid_tt_ss=c2ebb22b53ee89e53685e2f2a9430a78; install_id=1953160264683320; ttreq=1$40b78edabf045f7e266425e3bbd6ceb3878234b4";
        String sAddress="6918589482463740172";
        String[] sAddressList=new String[]{"陈雅晴","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头东街四巷幼儿园旁"};
//        String[] sAddressList=new String[]{"陈雅晴","137****5219","440000","广东省","440500","汕头市","440513","潮阳区","城南街道五响仙岛肠粉店附近"};

        //jiaorui
        String jCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; d_ticket=466ae907747c47537ec86d661c31ce7a1edd1; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C3483677160387581%3Ada8274ea98cfb040176f45282910da38%7C3765149701776035%3A8023f31286c432487216e8b6e9e90e1e; odin_tt=e2819530a5fb66e0834c45b23569bd3b0789d9e86dd8e2745139da5b77bd0b9ce14dbbf78bdf81ecb47b88fcb74ff6cae0089cb84f204e3e8608c407675071ca; n_mh=gyhYXI_ryT7KwoxdKJ-FvHwDVLPgJasRgcioYGrquAk; sid_guard=38d0b5c63014f656b57440fb84fc2f70%7C1614253556%7C5184000%7CMon%2C+26-Apr-2021+11%3A45%3A56+GMT; uid_tt=3ed84ad6f66708b92baad802d3881c23; uid_tt_ss=3ed84ad6f66708b92baad802d3881c23; sid_tt=38d0b5c63014f656b57440fb84fc2f70; sessionid=38d0b5c63014f656b57440fb84fc2f70; sessionid_ss=38d0b5c63014f656b57440fb84fc2f70";
        String jAddress="6915401985411793164";
        String[] jAddressList=new String[]{"林先生","135****7074","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};
//


        //chenyang
        String cCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=a7861b6c51f5bc8ee50866c49bca398b1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892; odin_tt=868ce1bf3a4c6f3f3d0cb9673fd5829cd480e758a00dbc5b9247c652d7fa49dbd752ec04a1fab4d8ac4e33ee8ed4852c69330ea594b6b44961b43cdb072b6dcf; n_mh=X3mk4JLS5hSPdGvdQopR-ixSByMPMsY-A_ADl09B0pM; sid_guard=40aad9b8036149cf70ea4652e3704892%7C1611843122%7C5184000%7CMon%2C+29-Mar-2021+14%3A12%3A02+GMT; uid_tt=a08cfc446d0c0ecd563fc974ae4710a8; uid_tt_ss=a08cfc446d0c0ecd563fc974ae4710a8; sid_tt=40aad9b8036149cf70ea4652e3704892; sessionid=40aad9b8036149cf70ea4652e3704892; sessionid_ss=40aad9b8036149cf70ea4652e3704892";
        String cAddress="6894594590695751939";
        String[] cAddressList=new String[]{"程陆羊","133****5078","510000","四川省","510100","成都市","510116","双流区","正北下街176号"};

        //chenyang2
        String c2Cookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=15a03a2c9b17dce61e052aecc6686bd31edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e; odin_tt=dbee6f028b7d87e614a4ad62959e315e1bbfbc21034d0a59c8afd838d4d70285949f40d3fb3b03eda1cf7f2191ff456a2a728d265b64529cbce22cd2edff8d2c; n_mh=RWNI4MgyTOAsnGQEgN_-AQ_lNSNzhBCJ-6FVS-aw8cE; sid_guard=c7f27f510d238cae4cbd691efa9c846e%7C1611843634%7C5184000%7CMon%2C+29-Mar-2021+14%3A20%3A34+GMT; uid_tt=3905739b7dd3ebd9f182c108b01708c0; uid_tt_ss=3905739b7dd3ebd9f182c108b01708c0; sid_tt=c7f27f510d238cae4cbd691efa9c846e; sessionid=c7f27f510d238cae4cbd691efa9c846e; sessionid_ss=c7f27f510d238cae4cbd691efa9c846e";
        String c2Address="6922815319501259022";
        String[] c2AddressList=new String[]{"林涛","133****5078","510000","四川省","510100","成都市","510116","双流区","华阳镇街道正北下街166号"};

        //chenyang3
        String c3Cookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4; d_ticket=466ae907747c47537ec86d661c31ce7a1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C3483677160387581%3Ada8274ea98cfb040176f45282910da38%7C3765149701776035%3A8023f31286c432487216e8b6e9e90e1e; odin_tt=c021cf67dde2a7c520f1223b109cd27113fd9971ab2ef74d9f814b79311fadc2e300e2efea0872db49b72aa3dcd742d3510e4e89435866de0e841734a5c5bb35; n_mh=DsWlEgxNuxDuQ2aVYQ2XERSRuByvWgYIPF3grkR78Jo; sid_guard=da8274ea98cfb040176f45282910da38%7C1614180125%7C5184000%7CSun%2C+25-Apr-2021+15%3A22%3A05+GMT; uid_tt=25cbbf07cbdb4d8f40e236d43a6294d8; uid_tt_ss=25cbbf07cbdb4d8f40e236d43a6294d8; sid_tt=da8274ea98cfb040176f45282910da38; sessionid=da8274ea98cfb040176f45282910da38; sessionid_ss=da8274ea98cfb040176f45282910da38";
        String c3Address="6932846757948801293";
        String[] c3AddressList=new String[]{"程其阳","173****8229","510000","四川省","510100","成都市","510116","双流区","正北下街166号水印城小区"};

        //chenyang4
        String c4Cookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4; d_ticket=466ae907747c47537ec86d661c31ce7a1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C3483677160387581%3Ada8274ea98cfb040176f45282910da38%7C3765149701776035%3A8023f31286c432487216e8b6e9e90e1e; odin_tt=6fb54ea518d63f676bbcfd1f92d3783c86305ac41870dc35bc4f183297fe29213b9c2dd3459d894a3d6fbbc28263e08852dffb3d8962d47dd4f9f256a33d5218; n_mh=OjFpZ5CheV2xnvbEB0hcp7f8E4_fa1vbp9TdkaOdEzw; sid_guard=8023f31286c432487216e8b6e9e90e1e%7C1614179880%7C5184000%7CSun%2C+25-Apr-2021+15%3A18%3A00+GMT; uid_tt=53329e7a663d00c271196cad8774f622; uid_tt_ss=53329e7a663d00c271196cad8774f622; sid_tt=8023f31286c432487216e8b6e9e90e1e; sessionid=8023f31286c432487216e8b6e9e90e1e; sessionid_ss=8023f31286c432487216e8b6e9e90e1e";
        String c4Address="6931310826884251907";
        String[] c4AddressList=new String[]{"陈小氧","199****5265","510000","四川省","510100","成都市","510116","双流区","华阳镇街道正北下街166号"};

        //c5
        String c5Cookie="passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; tt_webid=f8197919392e0d221919204567d7062f; d_ticket=e7224a45a3117bbbe16d39f2918458bdeb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d%7C105355465580%3A7cbee9771b6cb13a168f6c2d518181d1%7C3737940135263357%3A1b9594bff220657ba60fe275f009f732%7C756116130366872%3A86b7d27c000c5cbe61ff914b17a931e1%7C2752825819145204%3Ae07e80e84e13c42fb655def213f75955%7C104560386685%3A6bb98eede0c8c63ebcb71aba734b45bb; n_mh=1Zzmvx-ZDThnBmYDgz8bnH9bp7H46JZ9u1B5bsaCEj8; odin_tt=7945aa5e80a3a2072b6b5c028dd2b66febfd4cade99d52f3ba10302694e430563c6c2fd8241d83debae79fd5f276b81feed3f1076671338cea3df29d936c63ec; sessionid=6bb98eede0c8c63ebcb71aba734b45bb; sessionid_ss=6bb98eede0c8c63ebcb71aba734b45bb; sid_guard=6bb98eede0c8c63ebcb71aba734b45bb%7C1614256888%7C5184000%7CMon%2C+26-Apr-2021+12%3A41%3A28+GMT; sid_tt=6bb98eede0c8c63ebcb71aba734b45bb; uid_tt=fd1e6bcbb3d4b9ac50f66a1bf553162f; uid_tt_ss=fd1e6bcbb3d4b9ac50f66a1bf553162f; install_id=3606819300717640; ttreq=1$badf703a7fca8ea3d0e028d4fa4f486ecb8099ce";
        String c5Address="6894589775353807108";
        String[] c5AddressList=new String[]{"陈小羊","173****4230","510000","四川省","510100","成都市","510116","双流区","天府大道南段846号"};


    //sister2
        String s2Cookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=1917970565572591; ttreq=1$9274b59c5a494c468c35ea22435b0591d889ccb4; d_ticket=cfb1880c6bb762e173a6f515d8e68b9f1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e%7C756116130366872%3A92f7a548a492b4e9f3aa9de7850b1191%7C105355465580%3A8ed43e8dd47b6c603330cdb6c7859882; odin_tt=e502009d34e418db7119e4634e5a50bb4ed2753c02bfa560abb6a583a016cf1f97dffd6ae8bff98e69f4d873ebbdb7887f7b805deccd18b971f30609fa58b43b; n_mh=SHOETCR3w2Ik0FhySpqbIvNm7RD_W6I8fpCDQxuMU4k; sid_guard=8ed43e8dd47b6c603330cdb6c7859882%7C1614345714%7C5184000%7CTue%2C+27-Apr-2021+13%3A21%3A54+GMT; uid_tt=ed036b6908ea659b1af4f5dbc0df2d79; uid_tt_ss=ed036b6908ea659b1af4f5dbc0df2d79; sid_tt=8ed43e8dd47b6c603330cdb6c7859882; sessionid=8ed43e8dd47b6c603330cdb6c7859882; sessionid_ss=8ed43e8dd47b6c603330cdb6c7859882";
        String s2Address="6918658514772640013";
        String[] s2AddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村新街1巷金康药房旁边"};

        String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
        String baiyeAddress="6837435314240340236";
        String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};
//        String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440500","汕头市","440513","潮阳区","南关小哈佛幼儿园旁边"};

        public void run() {
            List<DyBuyCom2> dList=commitDy.newitems2(baiyeCookie, baiyeAddress, authorId, comboIds, productId,baiyeAddressList);
            List<DyBuyCom2> mList=commitDy.newitems2(mCookie, mAddress, authorId, comboIds, productId,mAddressList);
            List<DyBuyCom2> fList=commitDy.newitems2(fCookie, fAddress, authorId, comboIds, productId,fAddressList);
            List<DyBuyCom2> jList=commitDy.newitems2(jCookie, jAddress, authorId, comboIds, productId,jAddressList);
            List<DyBuyCom2> xList=commitDy.newitems2(xCookie, xAddress, authorId, comboIds, productId,xAddressList);
            List<DyBuyCom2> s1List=commitDy.newitems2(sCookie, sAddress, authorId, comboIds, productId,sAddressList);
            List<DyBuyCom2> s2List=commitDy.newitems2(s2Cookie, s2Address, authorId, comboIds,productId,s2AddressList);
            List<DyBuyCom2> c1List=commitDy.newitems2(cCookie, cAddress, authorId, comboIds, productId,cAddressList);
            List<DyBuyCom2> c2List=commitDy.newitems2(c2Cookie, c2Address, authorId, comboIds, productId,c2AddressList);
            List<DyBuyCom2> c3List=commitDy.newitems2(c3Cookie, c3Address, authorId, comboIds, productId,c3AddressList);
            List<DyBuyCom2> c4List=commitDy.newitems2(c4Cookie, c4Address, authorId, comboIds, productId,c4AddressList);
            List<DyBuyCom2> c5List=commitDy.newitems2(c5Cookie, c5Address, authorId, comboIds, productId,c5AddressList);
//            if(twoMethod){
//                List<DyBuyCom2> dList2=commitDy.newitems2(baiyeCookie, baiyeAddress, authorId, comboIds, productId,baiyeAddressList);
////            List<DyBuyCom> mList=commitDy.newitems(mCookie, mAddress, authorId, comboIds, productId,mAddressList);
//                List<DyBuyCom2> fList2=commitDy.newitems2(fCookie, fAddress, authorId, comboIds, productId,fAddressList);
//                List<DyBuyCom2> xList2=commitDy.newitems2(xCookie, xAddress, authorId, comboIds, productId,xAddressList);
//                List<DyBuyCom2> s1List2=commitDy.newitems2(sCookie, sAddress, authorId, comboIds, productId,sAddressList);
//            List<DyBuyCom2> s2List2=commitDy.newitems2(s2Cookie, s2Address, authorId, comboIds,productId,s2AddressList);
//                List<DyBuyCom2> c1List2=commitDy.newitems2(cCookie, cAddress, authorId, comboIds, productId,cAddressList);
//                List<DyBuyCom2> c2List2=commitDy.newitems2(c2Cookie, c2Address, authorId, comboIds, productId,c2AddressList);
//            }
            //需要遍历执行的方法
            while(1==1) {
                for (int i=0;i<comboIds.size();i++){
//
//                    if(twoMethod)
//                        commitDy.sendMessageDy(dList.get(i).post(),itemName,"大号(two)");


                    //
                    commitDy.sendMessageDy(xList.get(i).post(),itemName,"小号");
                    commitDy.sendMessageDy(fList.get(i).post(),itemName,"爸号");
                    commitDy.sendMessageDy(s1List.get(i).post(),itemName,"姐1号");
                    commitDy.sendMessageDy(s2List.get(i).post(),itemName,"姐2号");
                    commitDy.sendMessageDy(c5List.get(i).post(),itemName,"陈阳5号（4230）");
                    commitDy.sendMessageDy(mList.get(i).post(),itemName,"妈号");
                    commitDy.sendMessageDy(c1List.get(i).post(),itemName,"陈阳1号（5078）");
                    commitDy.sendMessageDy(c2List.get(i).post(),itemName,"陈阳2号（）");



//                    commitDy.sendMessageDy(c3List.get(i).post(),itemName,"陈阳3号（8229）");

//                    commitDy.sendMessageDy(dList.get(i).post(),itemName,"大号");
////                    if(twoMethod)
//                        commitDy.sendMessageDy(s2List2.get(i).post(),itemName,"姐2号(two)");

//                    if(twoMethod)
//                        commitDy.sendMessageDy(fList2.get(i).post(),itemName,"爸号(two)");

//                    if(twoMethod)
//                        commitDy.sendMessageDy(xList2.get(i).post(),itemName,"小号(two)");
//

//                    if(twoMethod)
//                         commitDy.sendMessageDy(s1List2.get(i).post(),itemName,"姐1号(two)");


//                    if(twoMethod)
//                        commitDy.sendMessageDy(c1List2.get(i).post(),itemName,"陈阳1号(two)");
//                    commitDy.sendMessageDy(c2List.get(i).post(),itemName,"陈阳2号");
//                    commitDy.sendMessageDy(c4List.get(i).post(),itemName,"陈阳4号");
//                    commitDy.sendMessageDy(c1List.get(i).post(),itemName,"陈阳1号");
//                    commitDy.sendMessageDy(c3List.get(i).post(),itemName,"陈阳3号");
//                    commitDy.sendMessageDy(xList.get(i).post(),itemName,"小号");
//                    commitDy.sendMessageDy(fList.get(i).post(),itemName,"爸号");
//                    commitDy.sendMessageDy(jList.get(i).post(),itemName,"教锐"); //
//                    if(twoMethod)
//                        commitDy.sendMessageDy(c2List2.get(i).post(),itemName,"陈阳2号(two)");


                }
             }

    }


    public static List<DyBuyCom> newitems(String cookie,String address,String authorId,List comboIds,String productId,String[] addressList){
        List<DyBuyCom> list=new ArrayList<>();
            for(int i=0;i<comboIds.size();i++){
                DyBuyCom dyBuyCom=new DyBuyCom(cookie,address,authorId,comboIds.get(i)+"",productId,addressList);
                list.add(dyBuyCom);
            }

    return list;

    }
    public static List<DyBuyCom2> newitems2(String cookie,String address,String authorId,List comboIds,String productId,String[] addressList){
        List<DyBuyCom2> list=new ArrayList<>();
        for(int i=0;i<comboIds.size();i++){
            DyBuyCom2 dyBuyCom=new DyBuyCom2(cookie,address,authorId,comboIds.get(i)+"",productId,addressList);
            list.add(dyBuyCom);
        }

        return list;

    }


   public static void sendMessageDy(String response,String itemName,String userName){
        if(response!=null&&response.length()!=0) {
            String response2 = TransationMessage(response,userName);
            if (response2.equals("")) {
                String message =
                        " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                "  \"content\":\"抖音 "+userName + itemName + " 提交结果 ：" + response2 + " 成功  \"," +
                                "  \"summary\":\"抖音 "+userName + itemName + " 提交结果 ：" + response2 + " 成功  \"," +
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
    public static String TransationMessage(String message,String userName){
        String data=null;
        try {
            JSONObject jsonArray = new JSONObject(message);
            System.out.println(Thread.currentThread().toString()+"-"+df.format(new Date())+"-"+userName+"-"+jsonArray.getString("msg"));
            data=jsonArray.getString("msg") ;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }





}
