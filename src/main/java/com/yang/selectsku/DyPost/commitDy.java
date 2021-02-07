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


    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


//    String itemName="mate 40";
//    String authorId="88742122835";
//    String[] comboIds={"1460415030","1460415031","1460415034","1460415036","1460415037","1460415038","1460415039"};
//    String productId="3454882272933738579";

    String itemName;
    String authorId;
    String productId;
    List   comboIds;

    public commitDy(String itemName,String authorId,String productId,List comboIds){
        this.itemName=itemName;
        this.authorId=authorId;
        this.productId= productId;
        this.comboIds=comboIds;
    }



    public static  void main(String agrs[]){
        String itemName="显卡";
        String authorId="";
        String productId="3460046513886078993";
        List comboIds=dyGetCombIdsUtils.getCombIds(productId);
        //开启线程提交
        for(int i=0;i<10;i++){
            int num=i+1;
            new Thread(new commitDy(itemName,authorId,productId,comboIds),"抢购线程"+num).start();
        }
    }


        //第一个号 mon
        String mCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=5c7f3a125890f2ac968418aa5a7291a61edd1; multi_sids=756116130366872%3A9c33ff8919fab8cce524363feafdb2eb; odin_tt=3437f512b40b7d4155a955b406411d24faaec563744ac1285f710fd6e444b943d20404bf999558370f4fe07468372a97e09b032c5125c383dccffddac265d153; n_mh=D7xgIq_o9qQ0h91TFc4cI-fBXrdBKjUlpxVoR4skJCs; sid_guard=9c33ff8919fab8cce524363feafdb2eb%7C1611415950%7C5184000%7CWed%2C+24-Mar-2021+15%3A32%3A30+GMT; uid_tt=83f74ed0dd4f9f172ac6a1f1cc0a0893; uid_tt_ss=83f74ed0dd4f9f172ac6a1f1cc0a0893; sid_tt=9c33ff8919fab8cce524363feafdb2eb; sessionid=9c33ff8919fab8cce524363feafdb2eb; sessionid_ss=9c33ff8919fab8cce524363feafdb2eb";
        String mAddress="6918549752523047181";
        String[] mAddressList=new String[]{"姚云娟","135****1928","440000","广东省","440500","汕头市","440513","潮阳区","南关街道小哈佛双语幼儿园旁"};

        //第二个号 father
        String fCookie="install_id=1249458498576615; ttreq=1$caca2f3a236cfb840b6e81e0adacd87c8b154da1; passport_csrf_token=a487cfbe93a489edd8e2fdc41f1ba082; passport_csrf_token_default=a487cfbe93a489edd8e2fdc41f1ba082; n_mh=e7zrLh1hc595q6UZf4MiMRkxIBd-K2qBrejNnmwEzS0; sid_guard=7af8fcba9a0bfe54d8820837045bcce1%7C1610850503%7C5183999%7CThu%2C+18-Mar-2021+02%3A28%3A22+GMT; uid_tt=ac9059d19c970797b6394df953ffbaab; uid_tt_ss=ac9059d19c970797b6394df953ffbaab; sid_tt=7af8fcba9a0bfe54d8820837045bcce1; sessionid=7af8fcba9a0bfe54d8820837045bcce1; sessionid_ss=7af8fcba9a0bfe54d8820837045bcce1; odin_tt=a27d43e1c3640d0a8897c2cd25e02705bb84ad758325e18ee998b4422359980a5f6b557674f0249840c86a5eb9ba78e59c107f2a1fb0ff716050328aa1dc8f9644197d27ad970ab93940235a126b773b; d_ticket=49dd63d5e183cf27d39cf9e18e5d0ff41edd1";
        String fAddress="6918559175584858371";
        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440500","汕头市","440513","潮阳区","棉城南中路永安园c区4栋601"};
//        String[] fAddressList=new String[]{"杨建辉","135****0619","440000","广东省","440100","广州市","440106","天河区","前进街道红太阳幼儿园旁边菜鸟驿站"};
//        DyBuyCom fDyBuyCom3 = new DyBuyCom(fCookie, fAddress, authorId, lyhComboId, productId,fAddressList);//显卡

        //第三个号7074
        String xCookie="install_id=3993839559263757; ttreq=1$92c997f9f4a0e9b9d1895c89e46e1df6198a5762; passport_csrf_token=e9e998a9b301ed4c70808ef2e5f60d27; passport_csrf_token_default=e9e998a9b301ed4c70808ef2e5f60d27; d_ticket=42604e0fc8e7c2dc6782794070a8d3a61edd1; multi_sids=1472985216323047%3A4e9612523e552f72ba8e9dcc8b92cbec; odin_tt=c7d50a30ea6d22a428e9f190c6af9ee1a739bbbe49a1d1cc8f1501858f93b184546b62915b958a2c5fef562dcfebcea8a87350c2a9a2e166e3afa4f6c6440762; n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o; sid_guard=4e9612523e552f72ba8e9dcc8b92cbec%7C1610859650%7C5184000%7CThu%2C+18-Mar-2021+05%3A00%3A50+GMT; uid_tt=5e9c4bc12abc49d2135e94040578419d; uid_tt_ss=5e9c4bc12abc49d2135e94040578419d; sid_tt=4e9612523e552f72ba8e9dcc8b92cbec; sessionid=4e9612523e552f72ba8e9dcc8b92cbec; sessionid_ss=4e9612523e552f72ba8e9dcc8b92cbec";
        String xAddress="6916499793699176711";
//        String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440100","广州市","440106","天河区","石溪红太阳幼儿园旁边"};
        String[] xAddressList=new String[]{"梁振宇","135****7074","440000","广东省","440500","汕头市","440513","潮阳区","棉城镇小哈佛幼儿园旁边"};

        //sister
        String sCookie="install_id=2850347468465390; ttreq=1$1268bb261c792ee2103532213555ca1fa99f0c92; passport_csrf_token=263fd20d3a4329a7ffe3034b6cdc880c; passport_csrf_token_default=263fd20d3a4329a7ffe3034b6cdc880c; d_ticket=a018a4c5790c902315a17227270e022eeb0cd; multi_sids=3307744305625069%3A2e0f196e2ec8afbe1d4956c53f0e02f8; odin_tt=cbb6a66071c4d89c2fdf8a22e702fb001ac1830686eb9c58e52271aec1b3e0a2e1e7cd8c1fc57eb3884d4c3b4c90606769d1e113b1269e743733ac892a6c2668; n_mh=tiWJmiHDDSZkF2jPg-96KomjLPtt576IpcNIeEm_AOo; sid_guard=2e0f196e2ec8afbe1d4956c53f0e02f8%7C1610860039%7C5184000%7CThu%2C+18-Mar-2021+05%3A07%3A19+GMT; uid_tt=cbce34d1b849aec58886828295ac353b; uid_tt_ss=cbce34d1b849aec58886828295ac353b; sid_tt=2e0f196e2ec8afbe1d4956c53f0e02f8; sessionid=2e0f196e2ec8afbe1d4956c53f0e02f8; sessionid_ss=2e0f196e2ec8afbe1d4956c53f0e02f8";
        String sAddress="6918589482463740172";
//        String[] sAddressList=new String[]{"陈雅晴","137****5219","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头东街四巷一号菜鸟驿站"};
        String[] sAddressList=new String[]{"陈雅晴","137****5219","440000","广东省","440500","汕头市","440513","潮阳区","城南街道五响仙岛肠粉店附近"};

        //chenyang
        String cCookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=a7861b6c51f5bc8ee50866c49bca398b1edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892; odin_tt=868ce1bf3a4c6f3f3d0cb9673fd5829cd480e758a00dbc5b9247c652d7fa49dbd752ec04a1fab4d8ac4e33ee8ed4852c69330ea594b6b44961b43cdb072b6dcf; n_mh=X3mk4JLS5hSPdGvdQopR-ixSByMPMsY-A_ADl09B0pM; sid_guard=40aad9b8036149cf70ea4652e3704892%7C1611843122%7C5184000%7CMon%2C+29-Mar-2021+14%3A12%3A02+GMT; uid_tt=a08cfc446d0c0ecd563fc974ae4710a8; uid_tt_ss=a08cfc446d0c0ecd563fc974ae4710a8; sid_tt=40aad9b8036149cf70ea4652e3704892; sessionid=40aad9b8036149cf70ea4652e3704892; sessionid_ss=40aad9b8036149cf70ea4652e3704892";
        String cAddress="6894594590695751939";
        String[] cAddressList=new String[]{"程陆羊","133****5078","510000","四川省","510100","成都市","510116","双流区","正北下街176号"};

        //chenyang2
        String c2Cookie="passport_csrf_token=2c7ac9e5c6c75160cf6f7fffdf887e74; passport_csrf_token_default=2c7ac9e5c6c75160cf6f7fffdf887e74; tt_webid=e254ddac709bbb535ef049fd9e024c3e; install_id=4186594606323176; ttreq=1$ef5a5fe81d8f80f9dc9dffed8dce17b2f748cfbd; d_ticket=15a03a2c9b17dce61e052aecc6686bd31edd1; multi_sids=1261852034861415%3A38d0b5c63014f656b57440fb84fc2f70%7C2704415701336907%3A40aad9b8036149cf70ea4652e3704892%7C111074284681%3Ac7f27f510d238cae4cbd691efa9c846e; odin_tt=dbee6f028b7d87e614a4ad62959e315e1bbfbc21034d0a59c8afd838d4d70285949f40d3fb3b03eda1cf7f2191ff456a2a728d265b64529cbce22cd2edff8d2c; n_mh=RWNI4MgyTOAsnGQEgN_-AQ_lNSNzhBCJ-6FVS-aw8cE; sid_guard=c7f27f510d238cae4cbd691efa9c846e%7C1611843634%7C5184000%7CMon%2C+29-Mar-2021+14%3A20%3A34+GMT; uid_tt=3905739b7dd3ebd9f182c108b01708c0; uid_tt_ss=3905739b7dd3ebd9f182c108b01708c0; sid_tt=c7f27f510d238cae4cbd691efa9c846e; sessionid=c7f27f510d238cae4cbd691efa9c846e; sessionid_ss=c7f27f510d238cae4cbd691efa9c846e";
        String c2Address="6922815319501259022";
        String[] c2AddressList=new String[]{"林涛","133****5078","510000","四川省","510100","成都市","510116","双流区","天府新区华阳街道四河路280号"};

         //sister2
        String s2Cookie="passport_csrf_token=791790d70c659b9986f271fd949cfed0; passport_csrf_token_default=791790d70c659b9986f271fd949cfed0; install_id=3026269286957454; ttreq=1$f22519f9f705a39308ab8196772d91cd7289bf6d; d_ticket=ca2d055fefc4943417a5d6781c5c8184eb0cd; odin_tt=210499e6d6a5884e017e4fe42ff408fceff36f96994f6aeb7064bca30fd5aed73c74f355d1dc06d2a1d8c77e0b6cb668a81dcad8be09ee5d6f4d5c69d4249505; n_mh=SHOETCR3w2Ik0FhySpqbIvNm7RD_W6I8fpCDQxuMU4k; sid_guard=4c0fa911dcc6a1cc9db35c72d8dccb90%7C1610875858%7C5183999%7CThu%2C+18-Mar-2021+09%3A30%3A57+GMT; uid_tt=c199f4fad291270e87df9f8760d05c67; uid_tt_ss=c199f4fad291270e87df9f8760d05c67; sid_tt=4c0fa911dcc6a1cc9db35c72d8dccb90; sessionid=4c0fa911dcc6a1cc9db35c72d8dccb90; sessionid_ss=4c0fa911dcc6a1cc9db35c72d8dccb90";
        String s2Address="6918658514772640013";
        String[] s2AddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村新街1巷金康药房旁边"};

        String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3A25b3fa0b3ab384dde7d9e0a51288964d; odin_tt=bbc3e39c267b90287f1305f5e19b4823d8563b406d630e05b1058d14637fdba011ea86960a8559182aee8f3ce950e9c1; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; sid_guard=25b3fa0b3ab384dde7d9e0a51288964d%7C1611414189%7C5184000%7CWed%2C+24-Mar-2021+15%3A03%3A09+GMT; uid_tt=008f0ed3a8635c0a1e860ec533379df8; uid_tt_ss=008f0ed3a8635c0a1e860ec533379df8; sid_tt=25b3fa0b3ab384dde7d9e0a51288964d; sessionid=25b3fa0b3ab384dde7d9e0a51288964d; sessionid_ss=25b3fa0b3ab384dde7d9e0a51288964d";
        String baiyeAddress="6837435314240340236";
//        String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440100","广州市","440106","天河区","前进街道石溪村桥头新街一巷一号"};
        String[] baiyeAddressList=new String[]{"杨梓博","135****0143","440000","广东省","440500","汕头市","440513","潮阳区","南关小哈佛幼儿园旁边"};

        public void run() {
            List<DyBuyCom> dList=commitDy.newitems(baiyeCookie, baiyeAddress, authorId, comboIds, productId,baiyeAddressList);
//            List<DyBuyCom> mList=commitDy.newitems(mCookie, mAddress, authorId, comboIds, productId,mAddressList);
            List<DyBuyCom> fList=commitDy.newitems(fCookie, fAddress, authorId, comboIds, productId,fAddressList);
            List<DyBuyCom> xList=commitDy.newitems(xCookie, xAddress, authorId, comboIds, productId,xAddressList);
            List<DyBuyCom> s1List=commitDy.newitems(sCookie, sAddress, authorId, comboIds, productId,sAddressList);
//            List<DyBuyCom> s2List=commitDy.newitems(s2Cookie, s2Address, authorId, comboIds,productId,s2AddressList);
            List<DyBuyCom> c1List=commitDy.newitems(cCookie, cAddress, authorId, comboIds, productId,cAddressList);
            List<DyBuyCom> c2List=commitDy.newitems(c2Cookie, c2Address, authorId, comboIds, productId,c2AddressList);
            //需要遍历执行的方法
            while(1==1) {
                for (int i=0;i<comboIds.size();i++){
                    commitDy.sendMessageDy(dList.get(i).post(),itemName,"大号");

//                    commitDy.sendMessageDy(mList.get(i).post(),itemName,"妈号");//掉线  //

                    commitDy.sendMessageDy(fList.get(i).post(),itemName,"爸号");
                    commitDy.sendMessageDy(xList.get(i).post(),itemName,"小号");

                    commitDy.sendMessageDy(s1List.get(i).post(),itemName,"姐1号");
//                    commitDy.sendMessageDy(s2List.get(i).post(),itemName,"姐2号"); //

                    commitDy.sendMessageDy(c1List.get(i).post(),itemName,"陈阳1号");
                    commitDy.sendMessageDy(c2List.get(i).post(),itemName,"陈阳2号");
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


   public static void sendMessageDy(String response,String itemName,String userName){
        if(response!=null&&response.length()!=0) {
            String response2 = TransationMessage(response,userName);
            System.out.println(response2);
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
            data= Thread.currentThread().toString()+"-"+df.format(new Date())+"-"+userName+"-"+jsonArray.getString("msg");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }





}
