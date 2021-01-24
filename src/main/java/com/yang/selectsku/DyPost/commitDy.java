package com.yang.selectsku.DyPost;

import com.yang.selectsku.controller.getSku;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class commitDy  implements Runnable {

    public static  void main(String agrs[]){
        commitDy commitDy=new commitDy();
        commitDy commitDy2=new commitDy();
        commitDy commitDy3=new commitDy();
        commitDy commitDy4=new commitDy();
        Thread t1=new Thread(commitDy,"t1");
        Thread t2=new Thread(commitDy2,"t2");
        Thread t3=new Thread(commitDy3,"t3");
        Thread t4=new Thread(commitDy4,"t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
//      while(1==1) {
          //baiye
          String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
          //mate 40
//          DyBuyCom dyBuyCom = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1422354648", "3453521734500751426");
//          DyBuyCom dyBuyCom2 = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1422354655", "3453521734500751426");
//          DyBuyCom dyBuyCom3 = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1422354649", "3453521734500751426");
//          DyBuyCom dyBuyCom4 = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1422354650", "3453521734500751426");
//          DyBuyCom dyBuyCom5 = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1422354659", "3453521734500751426");
//          commitDy.sendMessageDy(dyBuyCom.post(), "mate40");
//          commitDy.sendMessageDy(dyBuyCom2.post(), "mate40");
//          commitDy.sendMessageDy(dyBuyCom3.post(), "mate40");
//          commitDy.sendMessageDy(dyBuyCom4.post(), "mate40");
//          commitDy.sendMessageDy(dyBuyCom5.post(), "mate40");
          //老罗黄金DyBuyCom dyBuyCom2=new DyBuyCom(baiyeCookie,"6837435314240340236","4195355415549012","1572967386","3457878064195892911");
//        commitDy.sendMessageDy(dyBuyCom2.post(),"老罗黄金");

//          String baiyeCookie2="install_id=1424621436676839;ttreq=1$a30a27693a1bbdba981c18c33bda9cc0e33f91f4;passport_csrf_token=198a3d68fa02dd65c73819c00416948f;passport_csrf_token_default=198a3d68fa02dd65c73819c00416948f;tt_webid=43643eaa2491c888f60d54536fe848b3;d_ticket=6ab29e151c04af2168f5846edd8cea6fcb36c;multi_sids=1472985216323047%3A2d78c24ec2551d40825127443793b1f4;n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o;sid_guard=2d78c24ec2551d40825127443793b1f4%7C1610116470%7C5184000%7CTue%2C+09-Mar-2021+14%3A34%3A30+GMT;uid_tt=ae2f16e52624a1eb07b05203aa1126ac;uid_tt_ss=ae2f16e52624a1eb07b05203aa1126ac;sid_tt=2d78c24ec2551d40825127443793b1f4;sessionid=2d78c24ec2551d40825127443793b1f4;sessionid_ss=2d78c24ec2551d40825127443793b1f4;odin_tt=7b7e91e4a9f297de1144733079d24f64926aac8210dac0d130a5e3b5e8bc8943390357795a72c511ccbb9dee9c6a169626c25bfceff5a9d360946f471deeac08";
//          DyBuyCom dyBuyCom = new DyBuyCom(baiyeCookie2, "6916499793699176711", "66916631931", "1422354648", "3453521734500751426");
//          commitDy.sendMessageDy(dyBuyCom.post(), "mate40");
//         DyBuyCom dyBuyCom = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1589896507", "3446378222026157031");
//          commitDy.sendMessageDy(dyBuyCom.post(), "apple11");
//          DyBuyCom dyBuyCom2 = new DyBuyCom(baiyeCookie, "6837435314240340236", "66916631931", "1590825275", "3457129447176722097");
//          commitDy.sendMessageDy(dyBuyCom2.post(), "apple12");
          //老罗黄金DyBuyCom
//          DyBuyCom  dyBuyCom2=new DyBuyCom(baiyeCookie,"6837435314240340236","4195355415549012","1572967386","3457878064195892911");
//        commitDy.sendMessageDy(dyBuyCom2.post(),"老罗黄金");

//          DyBuyCom dyBuyCom = new DyBuyCom(baiyeCookie, "6837435314240340236", "70204787595", "1608031563", "3459180397022337632");
//           commitDy.sendMessageDy(dyBuyCom.post(), "dunk黑白");

        //通用抢购参数
        String hhqItemName="胡海泉黄金";
        String hhqAuthorId="637346025580430";
        String hhqComboId="1602609036";
        String hhqComboId2="1572967386";
        String hhqProductId="3458968178451993063";
        String hhqProductId2="3457878064195892911";


        String lyhItemName="显卡";
        String lyhAuthorId="4195355415549012";
        String lyhComboId="1689478075627528";
        String lyhProductId="3460046513886078993";

        String  xzItemName="dunk鞋子";
        String  xzAuthorId="70204787595";
        String  xzComboId1="1689577332230184";
        String  xzComboId2="1689577332230200";
        String  xzComboId3="1689577332231240";
        String  xzComboId4="1689577332231256";
        String  xzComboId5="1689577332231272";
        String  xzComboId6="1689577332231288";
        String  xzComboId7="1689651749471288";
        String  xzComboId8="1689651749472264";
        String  xzComboId9="1689651749472280";
        String  xzComboId10="1689651749472296";
        String  xzComboId11="1689651749472312";
        String  xzComboId12="1689651749683207";
        String  xzComboId13="1689651749683223";
        String  xzProductId="3460254394396900924";
        String  xzProductId2="3460253582681582302";



        //第一个号 mon
        String mCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=5c7f3a125890f2ac968418aa5a7291a61edd1; multi_sids=756116130366872%3A9c33ff8919fab8cce524363feafdb2eb; odin_tt=3437f512b40b7d4155a955b406411d24faaec563744ac1285f710fd6e444b943d20404bf999558370f4fe07468372a97e09b032c5125c383dccffddac265d153; n_mh=D7xgIq_o9qQ0h91TFc4cI-fBXrdBKjUlpxVoR4skJCs; sid_guard=9c33ff8919fab8cce524363feafdb2eb%7C1611415950%7C5184000%7CWed%2C+24-Mar-2021+15%3A32%3A30+GMT; uid_tt=83f74ed0dd4f9f172ac6a1f1cc0a0893; uid_tt_ss=83f74ed0dd4f9f172ac6a1f1cc0a0893; sid_tt=9c33ff8919fab8cce524363feafdb2eb; sessionid=9c33ff8919fab8cce524363feafdb2eb; sessionid_ss=9c33ff8919fab8cce524363feafdb2eb";
        String mAddress="6918549752523047181";
        String[] mAddressList=new String[]{"姚云娟","135****1928","440000","广东省","440500","汕头市","440513","潮阳区","南关街道小哈佛双语幼儿园旁"};
        DyBuyCom mDyBuyCom = new DyBuyCom(mCookie, mAddress, hhqAuthorId, hhqComboId, hhqProductId,mAddressList);
        DyBuyCom mDyBuyCom2 = new DyBuyCom(mCookie, mAddress, hhqAuthorId, hhqComboId2, hhqProductId2,mAddressList);
        DyBuyCom mDyBuyCom3 = new DyBuyCom(mCookie, mAddress, lyhAuthorId, lyhComboId, lyhProductId,mAddressList);//显卡

        //第二个号 father
        String fCookie="install_id=1249458498576615; ttreq=1$caca2f3a236cfb840b6e81e0adacd87c8b154da1; passport_csrf_token=a487cfbe93a489edd8e2fdc41f1ba082; passport_csrf_token_default=a487cfbe93a489edd8e2fdc41f1ba082; n_mh=e7zrLh1hc595q6UZf4MiMRkxIBd-K2qBrejNnmwEzS0; sid_guard=7af8fcba9a0bfe54d8820837045bcce1%7C1610850503%7C5183999%7CThu%2C+18-Mar-2021+02%3A28%3A22+GMT; uid_tt=ac9059d19c970797b6394df953ffbaab; uid_tt_ss=ac9059d19c970797b6394df953ffbaab; sid_tt=7af8fcba9a0bfe54d8820837045bcce1; sessionid=7af8fcba9a0bfe54d8820837045bcce1; sessionid_ss=7af8fcba9a0bfe54d8820837045bcce1; odin_tt=a27d43e1c3640d0a8897c2cd25e02705bb84ad758325e18ee998b4422359980a5f6b557674f0249840c86a5eb9ba78e59c107f2a1fb0ff716050328aa1dc8f9644197d27ad970ab93940235a126b773b; d_ticket=49dd63d5e183cf27d39cf9e18e5d0ff41edd1";
        String fAddress="6918559175584858371";
//        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440500","汕头市","440513","潮阳区","南关永安园c区4栋601"};
        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440100","广州市","440106","天河区","前进街道红太阳幼儿园旁边菜鸟驿站"};
        DyBuyCom fDyBuyCom = new DyBuyCom(fCookie, fAddress, hhqAuthorId, hhqComboId, hhqProductId,fAddressList);
        DyBuyCom fDyBuyCom2 = new DyBuyCom(fCookie, fAddress, hhqAuthorId, hhqComboId2, hhqProductId2,fAddressList);
        DyBuyCom fDyBuyCom3 = new DyBuyCom(fCookie, fAddress, lyhAuthorId, lyhComboId, lyhProductId,fAddressList);//显卡


        //第三个号7074
        String xCookie="install_id=3993839559263757; ttreq=1$92c997f9f4a0e9b9d1895c89e46e1df6198a5762; passport_csrf_token=e9e998a9b301ed4c70808ef2e5f60d27; passport_csrf_token_default=e9e998a9b301ed4c70808ef2e5f60d27; d_ticket=42604e0fc8e7c2dc6782794070a8d3a61edd1; multi_sids=1472985216323047%3A4e9612523e552f72ba8e9dcc8b92cbec; odin_tt=c7d50a30ea6d22a428e9f190c6af9ee1a739bbbe49a1d1cc8f1501858f93b184546b62915b958a2c5fef562dcfebcea8a87350c2a9a2e166e3afa4f6c6440762; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=4e9612523e552f72ba8e9dcc8b92cbec%7C1610859650%7C5184000%7CThu%2C+18-Mar-2021+05%3A00%3A50+GMT; uid_tt=5e9c4bc12abc49d2135e94040578419d; uid_tt_ss=5e9c4bc12abc49d2135e94040578419d; sid_tt=4e9612523e552f72ba8e9dcc8b92cbec; sessionid=4e9612523e552f72ba8e9dcc8b92cbec; sessionid_ss=4e9612523e552f72ba8e9dcc8b92cbec";
        String xAddress="6916499793699176711";
        String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440100","广州市","440106","天河区","石溪红太阳幼儿园旁边"};
        DyBuyCom xDyBuyCom = new DyBuyCom(xCookie, xAddress, hhqAuthorId, hhqComboId, hhqProductId,xAddressList);
        DyBuyCom xDyBuyCom2 = new DyBuyCom(xCookie, xAddress, hhqAuthorId, hhqComboId2, hhqProductId2,xAddressList);
        DyBuyCom xDyBuyCom3 = new DyBuyCom(xCookie, xAddress, lyhAuthorId, lyhComboId, lyhProductId,xAddressList);//显卡

        //sister
        String sCookie="install_id=2850347468465390; ttreq=1$1268bb261c792ee2103532213555ca1fa99f0c92; passport_csrf_token=263fd20d3a4329a7ffe3034b6cdc880c; passport_csrf_token_default=263fd20d3a4329a7ffe3034b6cdc880c; d_ticket=a018a4c5790c902315a17227270e022eeb0cd; multi_sids=3307744305625069%3A2e0f196e2ec8afbe1d4956c53f0e02f8; odin_tt=cbb6a66071c4d89c2fdf8a22e702fb001ac1830686eb9c58e52271aec1b3e0a2e1e7cd8c1fc57eb3884d4c3b4c90606769d1e113b1269e743733ac892a6c2668; n_mh=tiWJmiHDDSZkF2jPg-96KomjLPtt576IpcNIeEm_AOo; sid_guard=2e0f196e2ec8afbe1d4956c53f0e02f8%7C1610860039%7C5184000%7CThu%2C+18-Mar-2021+05%3A07%3A19+GMT; uid_tt=cbce34d1b849aec58886828295ac353b; uid_tt_ss=cbce34d1b849aec58886828295ac353b; sid_tt=2e0f196e2ec8afbe1d4956c53f0e02f8; sessionid=2e0f196e2ec8afbe1d4956c53f0e02f8; sessionid_ss=2e0f196e2ec8afbe1d4956c53f0e02f8";
        String sAddress="6918589482463740172";
        String[] sAddressList=new String[]{"陈雅晴","137****5219","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头东街四巷一号菜鸟驿站"};
        DyBuyCom sDyBuyCom = new DyBuyCom(sCookie, sAddress, hhqAuthorId, hhqComboId, hhqProductId,sAddressList);
        DyBuyCom sDyBuyCom2 = new DyBuyCom(sCookie, sAddress, hhqAuthorId, hhqComboId2, hhqProductId2,sAddressList);
        DyBuyCom sDyBuyCom3 = new DyBuyCom(sCookie, sAddress, lyhAuthorId, lyhComboId, lyhProductId,sAddressList);//显卡
        DyBuyCom sDyBuyComxz1 = new DyBuyCom(sCookie, sAddress, xzAuthorId, xzComboId1, xzProductId,sAddressList);
        DyBuyCom sDyBuyComxz2 = new DyBuyCom(sCookie, sAddress, xzAuthorId, xzComboId2, xzProductId,sAddressList);
        DyBuyCom sDyBuyComxz3 = new DyBuyCom(sCookie, sAddress, xzAuthorId, xzComboId3, xzProductId,sAddressList);
        DyBuyCom sDyBuyComxz4 = new DyBuyCom(sCookie, sAddress, xzAuthorId, xzComboId4, xzProductId,sAddressList);
        DyBuyCom sDyBuyComxz5 = new DyBuyCom(sCookie, sAddress, xzAuthorId, xzComboId5, xzProductId,sAddressList);
        DyBuyCom sDyBuyComxz6 = new DyBuyCom(sCookie, sAddress, xzAuthorId, xzComboId6, xzProductId,sAddressList);

        //chenyang
        String cCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=ef198a2a7cb458a4ddeaf70f01a7128f1edd1; multi_sids=4072239783486783%3Af8e4023bfbd4ab3611425994b92b2b5c; odin_tt=22b1439ba4b9c1de572cbf619ad7fee743ff2a8ee1040a25c2f67c0118b355cf0619af7950d56804e8c9a4b921463d5af77f4e971d6d99b578f2326e3802955b; n_mh=M3Pqh0_BYO4bkImToyvuFY7romDqKHnvIhvR91e6Bm4; sid_guard=f8e4023bfbd4ab3611425994b92b2b5c%7C1611407722%7C5184000%7CWed%2C+24-Mar-2021+13%3A15%3A22+GMT; uid_tt=ff51eb80485de93291799af81889073c; uid_tt_ss=ff51eb80485de93291799af81889073c; sid_tt=f8e4023bfbd4ab3611425994b92b2b5c; sessionid=f8e4023bfbd4ab3611425994b92b2b5c; sessionid_ss=f8e4023bfbd4ab3611425994b92b2b5c";
        String cAddress="6858218598763135239";
        String[] cAddressList=new String[]{"陈三洋","191****8826","510000","四川省","510100","成都市","510116","双流区","正北下街168号御景台"};
        DyBuyCom cDyBuyCom2 = new DyBuyCom(cCookie, cAddress, hhqAuthorId, hhqComboId2, hhqProductId2,cAddressList);
        DyBuyCom cDyBuyCom3 = new DyBuyCom(cCookie, cAddress, lyhAuthorId, lyhComboId, lyhProductId,cAddressList);//显卡


        //sister2
        String s2Cookie="passport_csrf_token=791790d70c659b9986f271fd949cfed0; passport_csrf_token_default=791790d70c659b9986f271fd949cfed0; install_id=3026269286957454; ttreq=1$f22519f9f705a39308ab8196772d91cd7289bf6d; d_ticket=ca2d055fefc4943417a5d6781c5c8184eb0cd; odin_tt=210499e6d6a5884e017e4fe42ff408fceff36f96994f6aeb7064bca30fd5aed73c74f355d1dc06d2a1d8c77e0b6cb668a81dcad8be09ee5d6f4d5c69d4249505; n_mh=SHOETCR3w2Ik0FhySpqbIvNm7RD_W6I8fpCDQxuMU4k; sid_guard=4c0fa911dcc6a1cc9db35c72d8dccb90%7C1610875858%7C5183999%7CThu%2C+18-Mar-2021+09%3A30%3A57+GMT; uid_tt=c199f4fad291270e87df9f8760d05c67; uid_tt_ss=c199f4fad291270e87df9f8760d05c67; sid_tt=4c0fa911dcc6a1cc9db35c72d8dccb90; sessionid=4c0fa911dcc6a1cc9db35c72d8dccb90; sessionid_ss=4c0fa911dcc6a1cc9db35c72d8dccb90";
        String s2Address="6918658514772640013";
        String[] s2AddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村新街1巷金康药房旁边"};
        DyBuyCom s2DyBuyCom2 = new DyBuyCom(s2Cookie, s2Address, hhqAuthorId, hhqComboId2, hhqProductId2,s2AddressList);
        DyBuyCom s2DyBuyCom3 = new DyBuyCom(s2Cookie, s2Address, lyhAuthorId, lyhComboId,lyhProductId,s2AddressList);//显卡
        //dunk鞋子
        DyBuyCom s2DyBuyComxz1 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId1,xzProductId,s2AddressList);//
        DyBuyCom s2DyBuyComxz2 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId2,xzProductId,s2AddressList);//
        DyBuyCom s2DyBuyComxz3 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId3,xzProductId,s2AddressList);//
        DyBuyCom s2DyBuyComxz4 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId4,xzProductId,s2AddressList);//
        DyBuyCom s2DyBuyComxz5 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId5,xzProductId,s2AddressList);//
        DyBuyCom s2DyBuyComxz6 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId6,xzProductId,s2AddressList);//
        DyBuyCom s2DyBuyComxz7 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId7,xzProductId2,s2AddressList);//
        DyBuyCom s2DyBuyComxz8 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId8,xzProductId2,s2AddressList);//
        DyBuyCom s2DyBuyComxz9 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId9,xzProductId2,s2AddressList);//
        DyBuyCom s2DyBuyComxz10 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId10,xzProductId2,s2AddressList);//
        DyBuyCom s2DyBuyComxz11 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId11,xzProductId2,s2AddressList);//
        DyBuyCom s2DyBuyComxz12 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId12,xzProductId2,s2AddressList);//
        DyBuyCom s2DyBuyComxz13 = new DyBuyCom(s2Cookie, s2Address, xzAuthorId, xzComboId13,xzProductId2,s2AddressList);//



        String baiyeAddress="6837435314240340236";
        String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};
//        DyBuyCom baiye = new DyBuyCom(baiyeCookie, baiyeAddress, lyhAuthorId, lyhComboId, lyhProductId,baiyeAddressList);//显卡
//        DyBuyCom baiye2 = new DyBuyCom(baiyeCookie, baiyeAddress, lyhAuthorId, "1580996688", "3457065967442607818",baiyeAddressList);
        public void run() {
        //需要遍历执行的方法
        while(1==1) {

//            commitDy.sendMessageDy(fDyBuyCom3.post(), lyhItemName);
//            commitDy.sendMessageDy(sDyBuyCom3.post(), lyhItemName);
//            commitDy.sendMessageDy(xDyBuyCom3.post(), lyhItemName);
//            commitDy.sendMessageDy(s2DyBuyCom3.post(), lyhItemName );


            commitDy.sendMessageDy(s2DyBuyComxz1.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz2.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz3.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz4.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz5.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz6.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz7.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz8.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz9.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz10.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz11.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz12.post(), xzItemName);
            commitDy.sendMessageDy(s2DyBuyComxz13.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz1.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz1.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz2.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz3.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz4.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz5.post(), xzItemName);
            commitDy.sendMessageDy(sDyBuyComxz6.post(), xzItemName);



//            commitDy.sendMessageDy(mDyBuyCom3.post(), lyhItemName );
        }



//



//        DyBuyCom ceDyBuyCom = new DyBuyCom(sCookie, sAddress, "3333330376333880", "1499817523", "3456126080547732473",sAddressList);
//        commitDy.sendMessageDy(ceDyBuyCom.post(), "测试");
//        DyBuyCom ceDyBuyCom = new DyBuyCom(xCookie, xAddress, "3333330376333880", "1499817523", "3456126080547732473",xAddressList);
//        commitDy.sendMessageDy(ceDyBuyCom.post(), "测试");





//        System.getProperties().setProperty("http.proxyHost", "10.22.40.32");
//        System.getProperties().setProperty("http.proxyPort", "8080");
          // 判断代理是否设置成功
          // 发送 GET 请求;


//
//      }
    }



   public static void sendMessageDy(String response,String itemName){
        if(response!=null&&response.length()!=0) {
            String response2 = TransationMessage(response);
            System.out.println(response2);
            if (response2.equals("")) {
                String message =
                        " { \"appToken\":\"AT_Q45yzpNW3dKPNaFF0SLXHZCfMjMcPFrJ\"," +
                                "  \"content\":\"抖音 " + itemName + " 提交结果 ：" + response2 + " 成功  \"," +
                                "  \"summary\":\"抖音 " + itemName + " 提交结果 ：" + response2 + " 成功  \"," +
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
    public static String TransationMessage(String message){
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
