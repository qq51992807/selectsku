package com.yang.selectsku.controller;

import com.yang.selectsku.DyPost.DyBuyCom;
import com.yang.selectsku.DyPost.commitDy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class commonController {


    @ResponseBody
    @RequestMapping("/dyTest")
    public void test(){
        String baiyeCookie="passport_csrf_token=42832717a9f0f60f7f3868569c383319; passport_csrf_token_default=42832717a9f0f60f7f3868569c383319; d_ticket=fa7848f1f9d190dbf6442455837db915eb0cd; multi_sids=88742122835%3Ae73ef71f7034400eba58dccabb9af11c; n_mh=DxBWqrWtnZ3DN8crkqKQYzcoxJ-Y-BpdBRaxlOGtWvc; odin_tt=40e3b5563f4989145665b5ff815766daf9e3a622beb0c7d98f5e2fcf57c5343391d5733740c7e8764ae4fe901069c57c; sessionid=e73ef71f7034400eba58dccabb9af11c; sessionid_ss=e73ef71f7034400eba58dccabb9af11c; sid_guard=e73ef71f7034400eba58dccabb9af11c%7C1610330943%7C5184000%7CFri%2C+12-Mar-2021+02%3A09%3A03+GMT; sid_tt=e73ef71f7034400eba58dccabb9af11c; uid_tt=58766eacf7c338b92bc4decf7f61cc34; uid_tt_ss=58766eacf7c338b92bc4decf7f61cc34; install_id=2198675385226238; ttreq=1$a1e08746f12df0b34fd82ec109be91aeafb8b874";
        //mate 40
//        DyBuyCom dyBuyCom=new DyBuyCom(baiyeCookie,"6837435314240340236","66916631931","1422354648","3453521734500751426");
//        commitDy.sendMessageDy(dyBuyCom.post(),"mate40");

        System.getProperties().setProperty("http.proxyHost", "10.22.40.32");
        System.getProperties().setProperty("http.proxyPort", "8080");
        // 判断代理是否设置成功
        // 发送 GET 请求;

        //老罗黄金
//        DyBuyCom dyBuyCom2=new DyBuyCom(baiyeCookie,"6837435314240340236","4195355415549012","1572967386","3457878064195892911");
//        commitDy.sendMessageDy(dyBuyCom2.post(),"老罗黄金");
    }





}
