package com.yang.selectsku.DyPost;

import com.yang.selectsku.controller.getSku;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class commitDy  {

    public static  void main(String agrs[]){
      while(1==1) {
          //baiye
          String baiyeCookie = "passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3Ae73ef71f7034400eba58dccabb9af11c; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; odin_tt=40e3b5563f4989145665b5ff815766daf9e3a622beb0c7d98f5e2fcf57c5343391d5733740c7e8764ae4fe901069c57c; sessionid=e73ef71f7034400eba58dccabb9af11c; sessionid_ss=e73ef71f7034400eba58dccabb9af11c; sid_guard=e73ef71f7034400eba58dccabb9af11c%7C1610330943%7C5184000%7CFri%2C+12-Mar-2021+02%3A09%3A03+GMT; sid_tt=e73ef71f7034400eba58dccabb9af11c; uid_tt=58766eacf7c338b92bc4decf7f61cc34; uid_tt_ss=58766eacf7c338b92bc4decf7f61cc34; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874";
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

          String baiyeCookie2="install_id=1424621436676839;ttreq=1$a30a27693a1bbdba981c18c33bda9cc0e33f91f4;passport_csrf_token=198a3d68fa02dd65c73819c00416948f;passport_csrf_token_default=198a3d68fa02dd65c73819c00416948f;tt_webid=43643eaa2491c888f60d54536fe848b3;d_ticket=6ab29e151c04af2168f5846edd8cea6fcb36c;multi_sids=1472985216323047%3A2d78c24ec2551d40825127443793b1f4;n_mh=WaqjDB5YUdIJmee3ZJFaEbqV4DFU_lpXINnjn3Kel-o;sid_guard=2d78c24ec2551d40825127443793b1f4%7C1610116470%7C5184000%7CTue%2C+09-Mar-2021+14%3A34%3A30+GMT;uid_tt=ae2f16e52624a1eb07b05203aa1126ac;uid_tt_ss=ae2f16e52624a1eb07b05203aa1126ac;sid_tt=2d78c24ec2551d40825127443793b1f4;sessionid=2d78c24ec2551d40825127443793b1f4;sessionid_ss=2d78c24ec2551d40825127443793b1f4;odin_tt=7b7e91e4a9f297de1144733079d24f64926aac8210dac0d130a5e3b5e8bc8943390357795a72c511ccbb9dee9c6a169626c25bfceff5a9d360946f471deeac08";
//          DyBuyCom dyBuyCom = new DyBuyCom(baiyeCookie2, "6916499793699176711", "66916631931", "1422354648", "3453521734500751426");
//          commitDy.sendMessageDy(dyBuyCom.post(), "mate40");
          //老罗黄金DyBuyCom
//          DyBuyCom  dyBuyCom2=new DyBuyCom(baiyeCookie,"6837435314240340236","4195355415549012","1572967386","3457878064195892911");
//        commitDy.sendMessageDy(dyBuyCom2.post(),"老罗黄金");


//        System.getProperties().setProperty("http.proxyHost", "10.22.40.32");
//        System.getProperties().setProperty("http.proxyPort", "8080");
          // 判断代理是否设置成功
          // 发送 GET 请求;


//
      }
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
